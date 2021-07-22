package com.example.marvel.interfaces

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object API  {
    private const val BASE_URL = "http://gateway.marvel.com"


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