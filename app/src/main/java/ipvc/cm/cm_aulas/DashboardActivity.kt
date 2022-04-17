package ipvc.cm.cm_aulas

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        setTitle("Dashboard")

        val parametro = intent.getStringExtra(PARAM_NAME)
        val textView = findViewById<TextView>(R.id.tv1Dashboard)

        textView.setText(parametro)
    }
}