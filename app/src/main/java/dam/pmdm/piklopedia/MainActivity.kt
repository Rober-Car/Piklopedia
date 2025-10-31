package dam.pmdm.piklopedia

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /** Busca la Toolbar por su id (mi_toolbar) y regístrala como supportActionBar.
         *  setSupportActionBar(toolbar) --> reemplaza la barra de acción (ActionBar) predeterminada de
         *  una actividad por tu barra propia */

        val toolbar: Toolbar = findViewById(R.id.mi_toolbar)
        setSupportActionBar(toolbar)


        /**
         * Busca el RecyclerView por su id (mi_recycler).
         * */
        val reciclador: RecyclerView = findViewById(R.id.mi_recycler)

        /**
         * Crea una instancia de GridLayoutManager,
         * organiza los ítems del RecyclerView en 3 columnas.
         */
        val grid = GridLayoutManager(this, 3)


        /** Asigna el layautManager al recyclerView*/
        reciclador.layoutManager = grid

        /**
         * Lista de datos
         * */

        val pikminLista = listOf(
            Pikmin(1, getString(R.string.pikmin_rojo), R.drawable.red_pikmin, R.string.pikmin_rojo_descripcion),
            Pikmin(2, getString(R.string.pikmin_amarillo), R.drawable.yellow_pikmin, R.string.pikmin_amarillo_descripcion),
            Pikmin(3, getString(R.string.pikmin_azul), R.drawable.blue_pikmin, R.string.pikmin_azul_descripcion),
            Pikmin(4, getString(R.string.pikmin_blanco), R.drawable.white_pikmin, R.string.pikmin_blanco_descripcion),
            Pikmin(5, getString(R.string.pikmin_morado), R.drawable.purple_pikmin, R.string.pikmin_morado_descripcion),
            Pikmin(6, getString(R.string.pikmin_petreo), R.drawable.rock_pikmin, R.string.pikmin_petreo_descripcion),
            Pikmin(7, getString(R.string.pikmin_alado), R.drawable.winged_pikmin, R.string.pikmin_alado_descripcion),
            Pikmin(8, getString(R.string.pikmin_gelido), R.drawable.ice_pikmin, R.string.pikmin_gelido_descripcion),
            Pikmin(9, getString(R.string.pikmin_luminoso), R.drawable.glow_pikmin, R.string.pikmin_luminoso_descripcion)
        )

        // 🔹 Conectar Adapter con RecyclerView
        val adaptador = PikminAdapter(pikminLista) { pikminSeleccionado ->
            val intent = Intent(this,PikminDetalleActivity::class.java)

            // Pasamos los datos: nombre (String), imagen (Int), descripcion (Int - resource id)

            intent.putExtra(PikminDetalleActivity.EXTRA_NAME, pikminSeleccionado.name)
            intent.putExtra(PikminDetalleActivity.EXTRA_IMAGE, pikminSeleccionado.imagenRes)
            intent.putExtra(PikminDetalleActivity.EXTRA_DESC, pikminSeleccionado.descripcionRes)
            startActivity(intent)

        }

        reciclador.adapter = adaptador
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.opcion_acerca -> {
                val fragmentManager = supportFragmentManager
                val dialogo = DialogoAcercaDe()
                dialogo.show(fragmentManager,"AcercaDeDialog")
                true
            }

            R.id.opcion_ajustes -> {
                val intent = Intent(this, AjustesActivity::class.java)
                startActivity(intent)
                true
            }

            else -> super.onOptionsItemSelected(item)
    }
}
}