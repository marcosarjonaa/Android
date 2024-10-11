package com.example.miaplicacion.data

import com.example.miaplicacion.logic.Client

class RepositoryClient {

    companion object{
        var primary= 100

        val ListClient: List<Client> = listOf(
            Client(incrementPrimary(), "Marcos", "Arjona" , 644733216),
            Client(incrementPrimary(), "Dani", "Cornejo", 646619448),
            Client(incrementPrimary(), "Alejandro", "Copado", 610864408)

            )

        fun incrementPrimary() = primary++ //devuelvo e incremento después

    }
}