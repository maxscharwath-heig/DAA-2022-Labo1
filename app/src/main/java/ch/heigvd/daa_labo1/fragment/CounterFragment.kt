package ch.heigvd.daa_labo1.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import ch.heigvd.daa_labo1.R

private const val ARG_COUNTER = "param_counter"

class CounterFragment : Fragment() {

    var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            counter = it.getInt(ARG_COUNTER)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // création de la vue à partir du xml
        return inflater.inflate(R.layout.fragment_counter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(savedInstanceState != null)
            counter = savedInstanceState.getInt(ARG_COUNTER, 0)

        // linkage de la GUI
        val counterTv = view.findViewById<TextView>(R.id.f_counter)
        val button = view.findViewById<Button>(R.id.f_counter_increment)

        // initialisation des vues
        counterTv.text = "$counter"

        // évenements
        button.setOnClickListener {
            ++counter
            counterTv.text = "$counter"
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(ARG_COUNTER, counter)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("CounterFragment", "onDestroy")
    }

    companion object {
        @JvmStatic
        fun newInstance(counter: Int = 0) =
            CounterFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COUNTER, counter)
                }
            }
    }
}