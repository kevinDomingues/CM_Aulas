package ipvc.cm.cm_aulas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

const val PARAM_NAME = "none"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun changeName(view: View) {
        val editText = findViewById<EditText>(R.id.et1)
        val textView = findViewById<TextView>(R.id.tv1)

        if(editText.text.toString() == ""){
            Toast.makeText(this, "Please write your name", Toast.LENGTH_SHORT).show()
        } else {
            textView.text = editText.text
            // textView.text = editText.text
        }
    }

    fun goToNextPage(view: View) {
        val editText = findViewById<EditText>(R.id.et1)
        val intent = Intent(this, DashboardActivity::class.java).apply {
            putExtra(PARAM_NAME, editText.text.toString())
        }
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.custom_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.item1 -> {
                Toast.makeText(this, "Item 1 selecionado", Toast.LENGTH_SHORT).show();
                true
            }
            R.id.item3 -> {
                Toast.makeText(this, "Item 3 selecionado", Toast.LENGTH_SHORT).show();
                true
            }
            R.id.subitem1 -> {
                Toast.makeText(this, "SubItem 1 selecionado", Toast.LENGTH_SHORT).show();
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}