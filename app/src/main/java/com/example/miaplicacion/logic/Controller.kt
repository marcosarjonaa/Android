package com.example.miaplicacion.logic

import com.example.miaplicacion.data.RepositoryClient
import kotlin.random.Random
import kotlin.random.nextInt

class Controller() {
    private var myListClient: MutableList<Client>

    init {
        myListClient = RepositoryClient.ListClient.toMutableList()
    }

    fun ClientAddController(clienteNuevo : Client){
        myListClient.add(clienteNuevo)
    }

    fun ClientDelController(id: Int) : Boolean = myListClient.removeAll{ it.id==id}

    fun ClientUpdateController(id : Int, name : String, apellido: String, telefono: Int): Boolean{
        val findClient: Client? = myListClient.find { it.id == id }
        return findClient?.let{
            it.name = name
            it.apellido= apellido
            it.telefono=telefono

            true
        }?:false
    }

    fun showData() = myListClient.toString()

    fun devIDrandom(): Int{
        return if (myListClient.size==0){
            -1
        } else {
            val p = Random.nextInt(0, myListClient.size)
            myListClient[p].id
        }
    }

    fun devNumRandom(): Int{
        var primeros3 : Int = Random.nextInt(100,1000)
        var segundos3 : Int = Random.nextInt(1,1000)
        var ultimos3 : Int = Random.nextInt(1,1000)
        var numero: Int = (primeros3*1000000)+(segundos3*1000)+ultimos3
        return numero
    }
}