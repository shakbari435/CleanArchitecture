package com.shakbari.clean.data.api

import com.shakbari.clean.data.model.User
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): ArrayList<User>
}