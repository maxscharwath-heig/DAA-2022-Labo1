package ch.heigvd.daa_labo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import ch.heigvd.daa_labo1.fragment.StepperFragment

class MainActivityFragment2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragment2)

        findViewById<Button>(R.id.btn_next).setOnClickListener {
            // Use backStackEntryCount to determine where we are
            val step = supportFragmentManager.backStackEntryCount + 1
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, StepperFragment.newInstance(step.toString()))
                .addToBackStack("step $step")
                .commit()
        }

        findViewById<Button>(R.id.btn_back).setOnClickListener {
            // Pop the back stack to go back to the previous step
            supportFragmentManager.popBackStack()
        }

        findViewById<Button>(R.id.btn_close).setOnClickListener {
            finish()
        }
    }
}