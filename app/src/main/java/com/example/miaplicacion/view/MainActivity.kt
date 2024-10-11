package com.example.miaplicacion.view

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.miaplicacion.R
import com.example.miaplicacion.logic.Client
import com.example.miaplicacion.logic.Controller
import com.example.miaplicacion.logic.interfaces.OperationsInterface
import kotlin.math.log

class MainActivity : AppCompatActivity(), OperationsInterface{
    private lateinit var myButtonAdd : ImageView
    private lateinit var myButtonUpdate : ImageView
    private lateinit var myButtonDel : ImageView
    private lateinit var mydialog: dialog
    private val controller = Controller()



    companion object{
        const val TAG = "---SALIDA---"
        const val TAGA = "---ANADIR---"
        const val TAGU = "---UPDATE---"
        const val TAGD = "---DELETE---"

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge() barra superior transparente
        setContentView(R.layout.activity_main)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/

        Log.d(TAG, "Esto es un ejemplo de log")
        start()
    }

    private fun start(){
        myButtonAdd= findViewById(R.id.myButtonAdd)
        myButtonUpdate= findViewById(R.id.myButtomEdit)
        myButtonDel= findViewById(R.id.myButtomDel)
        mydialog = dialog(controller)

        mydialog.setListener(this)

        myButtonAdd.setOnClickListener{
            mydialog.show(0)
            Log.d(TAGA, "He pulsado añadir")
        }
        myButtonUpdate.setOnClickListener{
            mydialog.show(1)
            Log.d(TAGU, "He pulsado update")
        }
        myButtonDel.setOnClickListener{
            mydialog.show(2)
            Log.d(TAGD, "He pulsado delete")
        }


    }

    override fun ClientAdd(id: Int, name: String, apellido : String, numero : Int) {
        val newClient = Client (id, name, apellido, numero)
        controller.ClientAddController(newClient)
        var msg =  "El cliente con id = $id, ha sido insertado correctamente"

        Log.d(TAG, msg)
        showConsoleData(msg)
    }

    override fun ClientDel(id: Int) {
        var msg = ""
        val delete = controller.ClientDelController(id)  //borramos

        if (delete)
            msg =  "El cliente con id = $id, ha sido eliminado correctamente"
        else
            msg = "El cliente con id = $id, no ha sido encontrado para eliminar"

        Log. d(TAG, msg)
        showConsoleData(msg)

    }

    override fun ClientUpdate(id: Int, name: String, apellido: String, numero: Int) {
        var msg = ""
        val update = controller.ClientUpdateController(id, name)  //borramos el 2.

        if (update)
            msg =  "El cliente con id = $id, ha sido editado correctamente"
        else
            msg = "El cliente con id = $id, no ha sido encontrado para editar"

        Log. d(TAG, msg)
        showConsoleData(msg)
    }

    fun showConsoleData(msg:String){
        val msg = controller.showData()
        Thread.sleep(2000)
        Log. d(TAG, msg)
    }
}