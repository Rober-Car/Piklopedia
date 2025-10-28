package dam.pmdm.piklopedia

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PikminDetalleActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "EXTRA_NAME"
        const val EXTRA_IMAGE = "EXTRA_IMAGE"
        const val EXTRA_DESC  = "EXTRA_DESC"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla_detalle_pikmin)

        // toolbar
        val toolbar= findViewById<Toolbar>(R.id.mi_toolbar_detalle)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        // vistas del layout

        val imagenView = findViewById<ImageView>(R.id.imagen_detalle)
        val nombreView = findViewById<TextView>(R.id.nombre_pikmin_detalle)
        val descView   = findViewById<TextView>(R.id.descripcion_detalle)

        //3) Leer los extras del Intent
        val nombre = intent.getStringExtra(EXTRA_NAME) ?: "Pikmin"
        val imageRes = intent.getIntExtra(EXTRA_IMAGE, 0)
        val descRes = intent.getIntExtra(EXTRA_DESC, 0)
        val descripcionText: String = if (descRes != 0) getString(descRes)
        else intent.getStringExtra(EXTRA_DESC) ?: "Descripción no disponible."

        // Asignar
        nombreView.text = nombre
        descView.text = descripcionText
        if (imageRes != 0) imagenView.setImageResource(imageRes) else imagenView.setImageResource(R.drawable.ic_launcher_foreground)
        imagenView.contentDescription = nombre
    }

    // Manejar clic en la flecha de retroceso de la Toolbar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish() // cierra la actividad y vuelve a la anterior
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}



