package dam.pmdm.piklopedia

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AjustesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ajustes)

        val toolbar= findViewById<Toolbar>(R.id.mi_toolbar_ajustes)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val rgIdiomas = findViewById<RadioGroup>(R.id.radioGroupIdioma)
        val rbIdiomaEsp = findViewById<RadioButton>(R.id.radioIdiomaEs)
        val rbIdiomaEn = findViewById<RadioButton>(R.id.radioIdiomaEn)

        val rgTema = findViewById<RadioGroup>(R.id.radioGroupTema)
        val rbTemaclaro = findViewById<RadioButton>(R.id.radioTemaClaro)
        val rbTemaOscuro = findViewById<RadioButton>(R.id.radioTemaOscuro)

        rbIdiomaEsp.isChecked = true
        rbTemaclaro.isChecked = true

        rgIdiomas.setOnCheckedChangeListener {group, checkedId ->
            if(checkedId == R.id.radioIdiomaEs){

            }else{

            }
        }

        rgTema.setOnCheckedChangeListener {group, checkedId ->

            if(checkedId == R.id.radioTemaClaro){

            }else{

            }

        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}