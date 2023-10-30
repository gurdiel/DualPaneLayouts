package com.mpd.pmdm.dualpanelayouts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

const val STAR_SIGN_ID = "STAR_SIGN_ID"

/**
 * Declaramos nuestro propio Listener. Una interface para recibir las notificaciones
 * al seleccionar cualquier signo del zodiaco
 */
interface StarSignListener{
    /**
     * Cuando se selecciona un signo del zodiaco en ListFragment
     * se llama a la implementación de este método
     */
    fun onSelected(id: Int)
}
//Implementamos con MainActivity el StarSignListener

class MainActivity : AppCompatActivity(), StarSignListener {
    var isDualPane: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Si la actividad contiene el id del segundo contenedor de fragment, es la tablet
        isDualPane = findViewById<View>(R.id.star_sign_detail) != null
    }

    override fun onSelected(id: Int) {
        if(isDualPane){
            val detailFragment = supportFragmentManager
                .findFragmentById(R.id.star_sign_detail) as DetailFragment
            //Pasamos el id, que nos viene desde el ListFragment, a la función de DetailFragment
            detailFragment.setStarSignData(id)
        } else {
            val detailIntent = Intent(this, DetailActivity::class.java)
            detailIntent.putExtra(STAR_SIGN_ID, id)
            startActivity(detailIntent)
        }
    }
}


