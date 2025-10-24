package dam.pmdm.piklopedia

import android.os.Bundle

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
        val reciclador: RecyclerView=findViewById(R.id.mi_recycler)

        /**
         * Crea una instancia de GridLayoutManager,
         * organiza los ítems del RecyclerView en 3 columnas.
         */
        val grid= GridLayoutManager(this,3)


        /** Asigna el layautManager al recyclerView*/
        reciclador.layoutManager=grid

        /**
         * Lista de datos
         * */

        val pikminLista = listOf(
            Pikmin(1, "Pikminidae rubrus", R.drawable.red_pikmin),
            Pikmin(2, "Pikminidae auribus", R.drawable.yellow_pikmin),
            Pikmin(3, "Pikminidae caerula", R.drawable.blue_pikmin),
            Pikmin(4, "Pikminidae venalbius", R.drawable.white_pikmin),
            Pikmin(5, "Pikminidae violaceus", R.drawable.purple_pikmin),
            Pikmin(6, "Pikminidae granitus", R.drawable.rock_pikmin),
            Pikmin(7, "Pikminidae volucris", R.drawable.winged_pikmin),
            Pikmin(8, "Pikminidae glacialis", R.drawable.ice_pikmin),
            Pikmin(9, "Pikminidae luminis", R.drawable.glow_pikmin)
        )


    }
}