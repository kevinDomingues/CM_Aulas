package ipvc.cm.cm_aulas.api

import ipvc.cm.cm_aulas.models.User
import retrofit2.Call
import retrofit2.http.GET

interface EndPoints {

    @GET("/users/")
    fun getUsers(): Call<List<User>>
}