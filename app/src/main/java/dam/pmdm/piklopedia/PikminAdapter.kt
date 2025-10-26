package dam.pmdm.piklopedia

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 *
 * */
class PikminAdapter(

	//Atributos de clase

	private val items :List<Pikmin>,
	private val alHacerclick : (Pikmin)->Unit
) :RecyclerView.Adapter<PikminAdapter.PikminVH>(){

	class PikminVH(vistaItem: View):RecyclerView.ViewHolder(vistaItem){

		val plantillaPikmin: ImageView=vistaItem.findViewById(R.id.imagen_pikmin)
		val nombrePikmin : TextView= vistaItem.findViewById(R.id.nombre_pikmin)

		fun enlazar(pikmin: Pikmin){

			plantillaPikmin.setImageResource(pikmin.imagenRes)
			nombrePikmin.text=pikmin.name
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PikminVH {
		// 1) Obtener un LayoutInflater usando el contexto del parent (el RecyclerView)
		val inflador = LayoutInflater.from(parent.context)

		// 2) Inflar el layout XML del item (item_pikmin.xml). El 'parent' es el RecyclerView y
		//    'false' evita que la vista se adjunte inmediatamente; RecyclerView se encargará de ello.
		val vistaItem = inflador.inflate(R.layout.item_pikmin, parent, false)

		// 3) Crear y devolver un nuevo ViewHolder pasando la vista inflada
		return PikminVH(vistaItem)
	}



	// 3️⃣ Rellena las vistas con los datos del Pikmin correspondiente
	override fun onBindViewHolder(holder: PikminVH, position: Int) {
		val pikminActual = items[position]
		holder.enlazar(pikminActual)

		holder.itemView.setOnClickListener {
			alHacerclick(pikminActual)
		}
	}

	// 4️⃣ Devuelve el número total de elementos
	override fun getItemCount(): Int {
		return items.size
	}


}