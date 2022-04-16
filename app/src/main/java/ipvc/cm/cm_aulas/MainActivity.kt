package ipvc.cm.cm_aulas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("Life cycle: onCreate")
    }

    override fun onStart() {
        super.onStart()
        println("Life cycle: onStart")
    }

    override fun onResume() {
        super.onResume()
        println("Life cycle: onResume")
    }

    override fun onPause() {
        super.onPause()
        println("Life cycle: onPause")
    }

    override fun onStop() {
        super.onStop()
        println("Life cycle: onStop")
    }

    override fun onRestart() {
        super.onRestart()
        println("Life cycle: onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("Life cycle: onDestroy")
    }
}