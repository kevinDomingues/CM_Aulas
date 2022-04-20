package ipvc.cm.cm_aulas

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences: SharedPreferences = getSharedPreferences("FILE_1", Context.MODE_PRIVATE)

        val usernameValue = sharedPreferences.getString("PREF_USERNAME", "")
        Log.d("SHARED_PREF_AULA", "Found shared pref: &usernameValue")

        if(usernameValue!!.isNotEmpty()){
            showWelcome(usernameValue)
        }
    }

    private fun showWelcome(usernameValue: String?) {
        findViewById<TextView>(R.id.tv1).text = "Hello, $usernameValue"
        findViewById<EditText>(R.id.et1).isEnabled = false

        val btn = findViewById<Button>(R.id.btn1)
        btn.text = "Logout"
        btn.setOnClickListener{
            logout(it)
        }
    }

    private fun logout(view: View) {
        val sharedPreferences: SharedPreferences = getSharedPreferences("FILE_1", Context.MODE_PRIVATE)
        sharedPreferences.edit()
            .clear()
            .apply()

        showLogin()
    }

    private fun showLogin() {
        Log.d("SHARED_PREF_AULA", "Found shared pref:" )

        findViewById<TextView>(R.id.tv1).text = "Login"
        findViewById<EditText>(R.id.et1).isEnabled = true

        val btn = findViewById<Button>(R.id.btn1)
        btn.text = "Login"
        btn.setOnClickListener{
            login(it)
        }
    }

    fun login(view: View) {
        val editTextUsername = findViewById<EditText>(R.id.et1)

        if(editTextUsername.text.isNotEmpty()) {
            val sharedPreferences: SharedPreferences = getSharedPreferences("FILE_1", Context.MODE_PRIVATE)
            sharedPreferences.edit()
                .putString("PREF_USERNAME", editTextUsername.text.toString())
                .apply()

            showWelcome(editTextUsername.text.toString())
            Log.d("SHARED_PREF_AULA", "Found shared pref: ${editTextUsername.text}")
        }
    }
}