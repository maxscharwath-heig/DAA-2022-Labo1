package ch.heigvd.daa_labo1.contracts

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import ch.heigvd.daa_labo1.InputNameActivity

class UserInputFirstnameContract : ActivityResultContract<String, String>() {

    override fun createIntent(context: Context, input: String): Intent {
        return Intent(context, InputNameActivity::class.java)
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String {
        if (resultCode != Activity.RESULT_OK) {
            return ""
        }

        return intent?.getStringExtra(InputNameActivity.USER_FIRSTNAME_KEY) ?: ""
    }
}