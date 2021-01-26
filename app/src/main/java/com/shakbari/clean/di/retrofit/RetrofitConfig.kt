package com.shakbari.clean.di.retrofit

data class RetrofitConfig(
        var url: String = "https://5e510330f2c0d300147c034c.mockapi.io/",
        var timeOut: Long = 30L,
        var token: String =  "bearer " /*+ PrefManager.getInstance(context).getToken()*/
)