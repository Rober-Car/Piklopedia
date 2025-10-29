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
            Pikmin(1, "Pikmin rubrus", R.drawable.red_pikmin, R.string.pikmin_rojo),
            Pikmin(2, "Pikmin auribus", R.drawable.yellow_pikmin,  R.string.pikmin_amarillo),
            Pikmin(3, "Pikmin caerula", R.drawable.blue_pikmin, R.string.pikmin_azul),
            Pikmin(4, "Pikmin venalbius", R.drawable.white_pikmin, R.string.pikmin_blanco),
            Pikmin(5, "Pikmin violaceus", R.drawable.purple_pikmin, R.string.pikmin_morado),
            Pikmin(6, "Pikmin granitus", R.drawable.rock_pikmin, R.string.pikmin_petreo),
            Pikmin(7, "Pikmin volucris", R.drawable.winged_pikmin, R.string.pikmin_alado),
            Pikmin(8, "Pikmin glacialis", R.drawable.ice_pikmin, R.string.pikmin_gelido),
            Pikmin(9, "Pikmin luminis", R.drawable.glow_pikmin, R.string.pikmin_luminoso)
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
            R.id.opcion_acerca ->


        }
    }
}