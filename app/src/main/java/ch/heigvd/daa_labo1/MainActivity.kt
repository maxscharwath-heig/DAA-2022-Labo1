package ch.heigvd.daa_labo1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

/**
 * DAA - Labo 1
 *
 * @author Nicolas Crausaz
 * @author Lazar Pavicevic
 * @author Maxime Scharwath
 */
class MainActivity : AppCompatActivity() {

    private lateinit var activity1Btn: Button
    private lateinit var activity2Btn: Button
    private lateinit var activity3Btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activity1Btn = findViewById(R.id.activity1Btn)
        activity2Btn = findViewById(R.id.activity2Btn)
        activity3Btn = findViewById(R.id.activity3Btn)

        activity1Btn.setOnClickListener {
            startActivity(Intent(this, WelcomeActivity::class.java))
        }

        activity2Btn.setOnClickListener {
            startActivity(Intent(this, MainActivityFragment1::class.java))
        }

        activity3Btn.setOnClickListener {
            startActivity(Intent(this, MainActivityFragment2::class.java))
        }
    }
}