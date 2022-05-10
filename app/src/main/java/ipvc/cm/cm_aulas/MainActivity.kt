package ipvc.cm.cm_aulas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ipvc.cm.cm_aulas.adapters.UserAdapter
import ipvc.cm.cm_aulas.api.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val request = ServiceBuilder.buildService(Endpoints::class.java)
        val call = request.getUsers()

        call.enqueue(object: Callback<List<User>> {
            override fun onResponse(
                call: Call<List<User>>,
                response: Response<List<User>>
            ) {
                if(response.isSuccessful){
                    val recView = findViewById<RecyclerView>(R.id.rvUsers)
                    recView.layoutManager = LinearLayoutManager(this@MainActivity)
                    recView.adapter = UserAdapter(response.body()!!)
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })

        val getSingleButton = findViewById<Button>(R.id.Get)

        getSingleButton.setOnClickListener {
            val callSingle = request.getUserById(2)

            callSingle.enqueue(object: Callback<User>{
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if(response.isSuccessful){
                        val c: User = response.body()!!
                        Toast.makeText(this@MainActivity, "Address: "+c.address.zipcode, Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
        }

        val postButton = findViewById<Button>(R.id.Post)

        postButton.setOnClickListener {
            val request = ServiceBuilder.buildService(Endpoints::class.java)
            val call = request.post("teste1234123")

            call.enqueue(object: Callback<PostOutput> {
                override fun onResponse(
                    call: Call<PostOutput>,
                    response: Response<PostOutput>
                ) {
                    if(response.isSuccessful){
                        val c: PostOutput = response.body()!!
                        Toast.makeText(this@MainActivity, "id: "+c.id, Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<PostOutput>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }


}