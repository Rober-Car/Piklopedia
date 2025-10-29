package dam.pmdm.piklopedia

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class DialogoAcercaDe : DialogFragment() {

    val autor= "Roberto Carlos Salvador Martín"
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Creamos el objeto AlertDialog.Builder
        val builder= AlertDialog.Builder(requireContext())
            .setTitle(getString(R.string.opcion_acerca))
            .setIcon(R.mipmap.icono_pikmin_launcher)
            .setMessage(getString(R.string.texto_dialogo,autor))
            .setPositiveButton("Aceptar") { dialog, _ ->
                dialog.dismiss() // Cierra el diálogo
            }
        return   builder.create()
    }
}
