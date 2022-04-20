package ipvc.cm.cm_aulas.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ipvc.cm.cm_aulas.R
import ipvc.cm.cm_aulas.models.Todo
import kotlinx.android.synthetic.main.todo_line.view.*

class TodoAdapter(
    private val todos: ArrayList<Todo>
): RecyclerView.Adapter<TodoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(
                    R.layout.todo_line,
                    parent,
                    false
                )
        )
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val currentTodo = todos[position]

        holder.apply {
            title.text = currentTodo.title
            date.text = currentTodo.date.toString()
            number.text = "#"+(position+1).toString()
        }
//        holder.title.text = currentTodo.title
//        holder.date.text = currentTodo.date.toString()
//        holder.number.text = "#" + (position + 1).toString()
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    fun addTodo(newTodo: Todo){
        todos.add(newTodo)
        notifyDataSetChanged()
    }
}

class TodoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val title = itemView.tvTodoTitle
    val date = itemView.tvTodoDate
    val number = itemView.tvTodoNumber
}