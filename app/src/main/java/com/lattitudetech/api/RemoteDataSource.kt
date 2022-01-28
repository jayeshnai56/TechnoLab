package com.lattitudetech.api

import com.lattitudetech.interfaces.ApiInterface
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val service: ApiInterface) {

    suspend fun getUsers() = service.getUsers()
}