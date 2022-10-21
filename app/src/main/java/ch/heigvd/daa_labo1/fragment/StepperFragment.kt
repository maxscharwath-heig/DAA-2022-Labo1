package ch.heigvd.daa_labo1.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ch.heigvd.daa_labo1.R
import ch.heigvd.daa_labo1.WelcomeActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_STEP = "ARG_STEP"

/**
 * A simple [Fragment] subclass.
 * Use the [StepperFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StepperFragment : Fragment() {
    private var stepValue: String = "DEFAULT VALUE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            stepValue = it.getString(ARG_STEP).toString()

        }
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putString(ARG_STEP, stepValue)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        if (savedInstanceState != null) {
            stepValue = savedInstanceState.getString(ARG_STEP).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stepper, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textStep = view.findViewById<TextView>(R.id.text_step)
        textStep.text = stepValue
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @return A new instance of fragment StepperFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
            StepperFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_STEP, param1)
                }
            }
    }
}