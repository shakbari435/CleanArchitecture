package com.shakbari.clean.ui.repository

import com.shakbari.clean.data.api.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiHelper){
    suspend fun getUsers() = apiHelper.getUsers()
}