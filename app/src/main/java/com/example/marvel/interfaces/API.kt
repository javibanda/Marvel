package com.example.marvel.interfaces

import android.util.Log
import com.example.marvel.model.Data
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object API  {
    const val BASE_URL = "http://gateway.marvel.com"
    const val TS = "1"
    const val API_KEY = "6253edfe88d0a0142ee64ad46a162160"
    const val HASH = "97bc35c8096b31be0da8bd253480c66f"

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