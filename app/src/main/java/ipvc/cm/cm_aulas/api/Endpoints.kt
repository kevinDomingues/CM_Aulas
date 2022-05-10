package ipvc.cm.cm_aulas.api

import retrofit2.Call
import retrofit2.http.*
import java.util.*

interface Endpoints {
    @GET("/users/")
    fun getUsers(): Call<List<User>>

    @GET("/users/{id}")
    fun getUserById(@Path("id") id: Int): Call<User>

    @FormUrlEncoded
    @POST("/posts")
    fun post(@Field("title") title:String?): Call<PostOutput>
}