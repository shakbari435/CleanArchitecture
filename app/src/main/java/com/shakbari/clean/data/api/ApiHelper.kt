package com.shakbari.clean.data.api

import com.shakbari.clean.data.model.User

interface ApiHelper {
    suspend fun getUsers(): ArrayList<User>
}