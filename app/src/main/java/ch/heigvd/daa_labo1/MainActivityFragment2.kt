package ch.heigvd.daa_labo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import ch.heigvd.daa_labo1.fragment.StepperFragment

private const val ACTIVITY_STEP = "ACTIVITY_STEP"
class MainActivityFragment2 : AppCompatActivity() {
    private var step: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragment2)

        findViewById<Button>(R.id.btn_next).setOnClickListener {
            step++
            setFragment(step)
        }

        findViewById<Button>(R.id.btn_prev).setOnClickListener {
            step--
            supportFragmentManager.popBackStack()
        }

        findViewById<Button>(R.id.btn_close).setOnClickListener {
            finish()
        }
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putInt(ACTIVITY_STEP, step)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        step = savedInstanceState.getInt(ACTIVITY_STEP)
    }

    private fun setFragment(step: Int) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, StepperFragment.newInstance(step.toString()))
            .addToBackStack("step$step")
            .commit()
    }
}