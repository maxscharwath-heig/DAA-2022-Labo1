package ch.heigvd.daa_labo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import ch.heigvd.daa_labo1.contracts.UserInputFirstnameContract

/**
 * DAA - Labo 1
 *
 * @author Nicolas Crausaz
 * @author Lazar Pavicevic
 * @author Maxime Scharwath
 */
class WelcomeActivity : AppCompatActivity() {
    private lateinit var welcomeLabel: TextView
    private lateinit var editButton: Button

    companion object {
        var SAVED_FIRSTNAME = "SAVED_FIRSTNAME"
    }

    private var userFirstName: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        welcomeLabel = findViewById(R.id.welcome_label)
        editButton = findViewById(R.id.edit_button)

        // Get the saved instance value
        userFirstName = savedInstanceState?.getString(SAVED_FIRSTNAME) ?: ""

        updateWelcomeLabel(userFirstName)

        editButton.setOnClickListener {
            getUserFirstnameInput.launch(userFirstName)
        }
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        // Save current firstname of context change
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putString(SAVED_FIRSTNAME, userFirstName)
    }

    private fun updateWelcomeLabel(firstname: String) {
        // Update the text label with the matching text
        userFirstName = firstname

        welcomeLabel.text = when(userFirstName.isEmpty()) {
            true -> getString(R.string.welcome_empty)
            false -> getString(R.string.welcome_with_name, userFirstName)
        }
    }

    // Launch the input activity for a result
    private val getUserFirstnameInput = registerForActivityResult(UserInputFirstnameContract()) {
        updateWelcomeLabel(it)
    }
}