package com.example.marvel.interfaces

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object API  {
    private const val BASE_URL = "http://gateway.marvel.com"
    private const val TS = "1"
    private const val API_KEY = "6253edfe88d0a0142ee64ad46a162160"
    private const val HASH = "97bc35c8096b31be0da8bd253480c66f"


    val retrofit: ApiService by lazy{
        getRetrofit().create(ApiService::class.java)
    }

    private fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


}