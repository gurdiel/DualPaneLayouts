package com.mpd.pmdm.dualpanelayouts

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

//Implentamos View.OnClickListener para que sea clickable el fragmento
class ListFragment : Fragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
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
        starSigns.forEach{
            it.setOnClickListener(this)
        }

    }


    /**
     * Pasa el id del signo clickado al starSignListener de la Actividad (Contexto) contenedora del fragment
     * Los Listener son un mecanismo habitual para reaccionar a cambios de otras clases.
     * Más info: https://hinchman-amanda.medium.com/the-listener-pattern-in-android-a2c532dd2938
     */
    override fun onClick(v: View?) {
        v?.let{
            //starSignListener es el atributo declarado como lateinit en esta clase
            //que se inicializa en el onAttach con el contexto (la actividad contenedora del fragmento)
            starSign -> starSignListener.onSelected(starSign.id)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}