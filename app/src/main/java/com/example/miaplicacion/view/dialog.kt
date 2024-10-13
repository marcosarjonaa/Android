package com.example.miaplicacion.view


import com.example.miaplicacion.data.RepositoryClient
import com.example.miaplicacion.logic.Controller
import com.example.miaplicacion.logic.interfaces.OperationsInterface
import com.google.android.material.animation.AnimatableView.Listener

class dialog(var controller: Controller) {
    private var listener: OperationsInterface? = null  //Ya si eso lo creo.

    private var action: Int = 0

    fun setListener(_listener: OperationsInterface) {
        listener = _listener

    }

    fun devIDrandom(){

    }

    fun show(typeAction: Int) {
        listener?.let {
            val posibleId = controller.devIDrandom()
            val posibleNumero = controller.devNumRandom()
            when (typeAction) {
                0 -> onAccept()

                1 ->
                    if (posibleId != -1)
                        onEdit(posibleId, "CAMBIADO", "TODO", posibleNumero)

                2 ->
                    if (posibleId != -1)
                        onDelete(posibleId)

            }

        }
    }

    private fun onDelete(id: Int) {
        listener!!.ClientDel(id)
    }

    private fun onEdit(id: Int, name: String, apellido: String, numero: Int) {
        listener!!.ClientUpdate(id, name, apellido, numero)
    }

    private fun onAccept() {
        var numero = controller.devIDrandom()
        listener!!.ClientAdd(RepositoryClient.incrementPrimary(), "NUEVO", "CLIENTE", numero)
    }
}