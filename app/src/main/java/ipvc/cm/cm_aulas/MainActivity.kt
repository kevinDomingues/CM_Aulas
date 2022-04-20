package ipvc.cm.cm_aulas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import ipvc.cm.cm_aulas.adapters.TodoAdapter
import ipvc.cm.cm_aulas.models.Todo
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDate

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoAdapter = TodoAdapter(ArrayList())

        rvTodoItems.adapter = todoAdapter
        rvTodoItems.layoutManager = LinearLayoutManager(this)

        btnAddTodo.setOnClickListener{
            val todoTitle = etTodo.text.toString()
            if(todoTitle.isNotEmpty()){
                val todo = Todo(todoTitle, LocalDate.now())

                todoAdapter.addTodo(todo)

                etTodo.text.clear()
            }
        }
    }
}