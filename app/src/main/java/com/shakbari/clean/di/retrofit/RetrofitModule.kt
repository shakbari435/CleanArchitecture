package com.shakbari.clean.di.retrofit


import com.google.gson.GsonBuilder
import com.shakbari.clean.data.api.ApiHelper
import com.shakbari.clean.data.api.ApiHelperImpl
import com.shakbari.clean.data.api.ApiService

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RetrofitModule {

    @Provides
    fun provideUtils() = RetrofitConfig()


    @Singleton
    @Provides
    fun provideOkHttpClient(
            retrofitUtils: RetrofitConfig
    ): OkHttpClient = OkHttpClient.Builder()
            .readTimeout(retrofitUtils.timeOut, TimeUnit.SECONDS)
            .connectTimeout(retrofitUtils.timeOut, TimeUnit.SECONDS)
            .addInterceptor { chain ->
                val newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", retrofitUtils.token)
                        .build()
                chain.proceed(newRequest)
            }
            .build()



    @Singleton
    @Provides
    fun provideRetrofit(
             okHttpClient: OkHttpClient,retrofitUtils: RetrofitConfig
    ): Retrofit = Retrofit.Builder()
            .baseUrl(retrofitUtils.url)
            .client(okHttpClient)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideApiHelper(apiHelper: ApiHelperImpl): ApiHelper = apiHelper

}