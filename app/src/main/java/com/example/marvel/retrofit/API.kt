package com.example.marvel.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object API  {
    private const val BASE_URL = "http://gateway.marvel.com"


    private fun getHttpLoggingInterceptor() =
        HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    private fun getClient() =
        OkHttpClient
        .Builder()
        .addInterceptor(getHttpLoggingInterceptor())
        .build()

    private fun getRetrofit(): Retrofit{
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getClient())
            .build()
    }

    val retrofit: ApiService by lazy{
        getRetrofit().create(ApiService::class.java)
    }



}