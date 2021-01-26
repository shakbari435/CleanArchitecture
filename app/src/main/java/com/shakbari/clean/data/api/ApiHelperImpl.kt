package com.shakbari.clean.data.api

import com.shakbari.clean.data.model.User
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService): ApiHelper {

    override suspend fun getUsers(): ArrayList<User>  = apiService.getUsers()

}