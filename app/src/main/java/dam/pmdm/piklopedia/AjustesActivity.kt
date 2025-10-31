package dam.pmdm.piklopedia

import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class AjustesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Edge-to-edge y layout
        enableEdgeToEdge()
        setContentView(R.layout.activity_ajustes)

        // Toolbar
        val toolbar = findViewById<Toolbar>(R.id.mi_toolbar_ajustes)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Referencias a RadioGroups / RadioButtons
        val rgIdiomas = findViewById<RadioGroup>(R.id.radioGroupIdioma)
        val rbIdiomaEsp = findViewById<RadioButton>(R.id.radioIdiomaEs)
        val rbIdiomaEn = findViewById<RadioButton>(R.id.radioIdiomaEn)

        val rgTema = findViewById<RadioGroup>(R.id.radioGroupTema)
        val rbTemaclaro = findViewById<RadioButton>(R.id.radioTemaClaro)
        val rbTemaOscuro = findViewById<RadioButton>(R.id.radioTemaOscuro)

        // Detectar idioma actual y marcar botón correspondiente
        val idiomaActual = Locale.getDefault().language
        if (idiomaActual == "es") {
            rbIdiomaEsp.isChecked = true
        } else {
            rbIdiomaEn.isChecked = true
        }

        // Detectar tema actual y marcar botón correspondiente
        val modoActual = AppCompatDelegate.getDefaultNightMode()
        if (modoActual == AppCompatDelegate.MODE_NIGHT_YES) {
            rbTemaOscuro.isChecked = true
        } else {
            rbTemaclaro.isChecked = true
        }

        // Listener para cambios de idioma
        rgIdiomas.setOnCheckedChangeListener { _, checkedId ->
            val nuevoIdioma = if (checkedId == R.id.radioIdiomaEs) "es" else "en"
            if (nuevoIdioma != Locale.getDefault().language) {
                cambiarIdioma(nuevoIdioma)
            }
        }

        // Listener para cambios de tema
        rgTema.setOnCheckedChangeListener { _, checkedId ->
            val nuevoModo = if (checkedId == R.id.radioTemaClaro)
                AppCompatDelegate.MODE_NIGHT_NO
            else
                AppCompatDelegate.MODE_NIGHT_YES

            if (nuevoModo != AppCompatDelegate.getDefaultNightMode()) {
                AppCompatDelegate.setDefaultNightMode(nuevoModo)
                recreate()
            }
        }

        // Insets visuales
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // Cambiar idioma y recargar
    private fun cambiarIdioma(language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = resources.configuration
        config.setLocale(locale)
        @Suppress("DEPRECATION")
        resources.updateConfiguration(config, resources.displayMetrics)
        recreate()
    }

    // Flecha de retroceso en la Toolbar
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}