package com.example.marvel.interfaces


import com.example.marvel.model.Characters
import com.example.marvel.model.Data
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/v1/public/characters?")
    fun getCharacters(@Query("ts") ts: String,
                      @Query("apikey") apiKey: String,
                      @Query("hash") hash: String
    ): Call<Characters>
}