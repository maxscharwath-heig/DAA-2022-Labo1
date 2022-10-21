package ch.heigvd.daa_labo1.contracts

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import ch.heigvd.daa_labo1.InputNameActivity

/**
 * DAA - Labo 1
 *
 * @author Nicolas Crausaz
 * @author Lazar Pavicevic
 * @author Maxime Scharwath
 */
class UserInputFirstnameContract : ActivityResultContract<String, String>() {

    override fun createIntent(context: Context, input: String): Intent {
        val intent = Intent(context, InputNameActivity::class.java)
        intent.putExtra(InputNameActivity.USER_FIRSTNAME_KEY, input)
        return intent
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String {
        if (resultCode != Activity.RESULT_OK) {
            return ""
        }

        return intent?.getStringExtra(InputNameActivity.USER_FIRSTNAME_KEY) ?: ""
    }
}