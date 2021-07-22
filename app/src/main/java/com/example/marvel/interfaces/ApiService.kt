package com.example.marvel.interfaces


import com.example.marvel.model.Data
import com.example.marvel.model.Result
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {



    @GET("/v1/public/characters")
    fun getCharacters(@Query("ts") ts: String,
                      @Query("apikey") apiKey: String,
                      @Query("hash") hash: String
    ): Response<Data>
}