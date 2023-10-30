package com.mpd.pmdm.dualpanelayouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * Declaramos nuestro propio Listener. Una interface para recibir las notificaciones
 * al seleccionar cualquier signo del zodiaco
 */
interface StarSignListener{
    fun onSelected(id: Int)
}
//Implementamos con MainActivity el StarSignListener

class MainActivity : AppCompatActivity(), StarSignListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onSelected(id: Int) {
        TODO("Not yet implemented")
    }
}


