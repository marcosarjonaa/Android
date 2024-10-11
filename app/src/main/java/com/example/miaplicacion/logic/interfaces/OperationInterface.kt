package com.example.miaplicacion.logic.interfaces

interface OperationsInterface {
    fun ClientAdd ( id: Int, name: String , apellido: String, numero: Int)
    fun ClientDel ( id: Int)
    fun ClientUpdate ( id: Int, name: String, apellido: String, numero: Int)
}