package ch.heigvd.daa_labo1.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ch.heigvd.daa_labo1.R

private const val ARG_STEP = "ARG_STEP"

/**
 * DAA - Labo 1
 *
 * @author Nicolas Crausaz
 * @author Lazar Pavicevic
 * @author Maxime Scharwath
 */
class StepperFragment : Fragment() {
    private var stepValue: String = "0"

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
         * @param step Step value.
         * @return A new instance of fragment StepperFragment.
         */
        @JvmStatic
        fun newInstance(step: String) =
            StepperFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_STEP, step)
                }
            }
    }
}