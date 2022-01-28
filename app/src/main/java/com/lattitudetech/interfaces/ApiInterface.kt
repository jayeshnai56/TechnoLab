package com.lattitudetech.interfaces

import com.lattitudetech.model.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    // API : Get Users
    @GET("users")
    suspend fun getUsers(): Response<List<User>>

}