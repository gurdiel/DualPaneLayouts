package com.mpd.pmdm.dualpanelayouts

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup


class ListFragment : Fragment(){

    //Declaramos una variable para almacenar la implementación de la interfaz
    //StarSignListener declarada en MainActivity.kt
    private lateinit var starSignListener: StarSignListener

    //Con este onAttach comprobamos que la Actividad que contenga este fragmento
    //implemente el starSignListener, o de lo contrario se lanzará una excepción.
    //Así aseguramos poder notificar a la Actividad cuando se haga click en un signo
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is StarSignListener){
            starSignListener = context
        } else{
          throw RuntimeException("Must implement StarSignListener")
        }
        //Valdría también lo siguiente
//        if(activity is StarSignListener){
//            starSignListener = activity as StarSignListener
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val starSigns = listOf<View>(
            view.findViewById(R.id.aquarius),
            view.findViewById(R.id.pisces),
            view.findViewById(R.id.aries),
            view.findViewById(R.id.taurus),
            view.findViewById(R.id.gemini),
            view.findViewById(R.id.cancer),
            view.findViewById(R.id.leo),
            view.findViewById(R.id.virgo),
            view.findViewById(R.id.libra),
            view.findViewById(R.id.scorpio),
            view.findViewById(R.id.sagittarius),
            view.findViewById(R.id.capricorn),
        )

        //Asociamos a cada TextView de Signo el propio fragment como onClickListener (porque lo implementamos)
        //Basado en ejemplo: https://www.geeksforgeeks.org/how-to-communicate-between-fragments-in-android/
        starSigns.forEach{
            it.setOnClickListener{
                starSignListener.onSelected(it.id)
            }
        }

    }

}