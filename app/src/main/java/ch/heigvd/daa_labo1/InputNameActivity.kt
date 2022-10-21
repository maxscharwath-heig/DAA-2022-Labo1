package ch.heigvd.daa_labo1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class InputNameActivity : AppCompatActivity() {
    companion object {
        const val USER_FIRSTNAME_KEY = "FIRSTNAME_KEY"
    }

    private lateinit var firstnameInput: EditText
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_name)

        firstnameInput = findViewById(R.id.firstname_input)
        saveButton = findViewById(R.id.save_button)

        // Get the given intent parameter
        firstnameInput.setText(intent.getStringExtra(USER_FIRSTNAME_KEY))

        saveButton.setOnClickListener {
            // Build & send back the activity result
            val data = Intent()
            data.putExtra(USER_FIRSTNAME_KEY, getFirstname())
            setResult(RESULT_OK, data)
            finish()
        }
    }

    private fun getFirstname(): String {
        return firstnameInput.text.toString().trim()
    }
}