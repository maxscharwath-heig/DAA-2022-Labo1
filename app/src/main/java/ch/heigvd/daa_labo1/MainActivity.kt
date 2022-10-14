package ch.heigvd.daa_labo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import ch.heigvd.daa_labo1.contracts.UserInputFirstnameContract

class MainActivity : AppCompatActivity() {
    private lateinit var welcomeLabel: TextView
    private lateinit var editButton: Button

    private var userFirstName: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        welcomeLabel = findViewById(R.id.welcome_label)
        editButton = findViewById(R.id.edit_button)

        updateWelcomeLabel(userFirstName)

        editButton.setOnClickListener {
            getUserFirstnameInput.launch(userFirstName)
        }
    }

    private val getUserFirstnameInput = registerForActivityResult(UserInputFirstnameContract()) {
        updateWelcomeLabel(it)
        Log.d("res",it)
    }

    private fun updateWelcomeLabel(firstname: String) {
        userFirstName = firstname

        if (userFirstName.isEmpty()) {
            welcomeLabel.text = getString(R.string.welcome_empty)
        } else {
            welcomeLabel.text = getString(R.string.welcome_with_name, userFirstName)
        }
    }
}