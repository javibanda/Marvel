package com.example.marvel.retrofit


import com.example.marvel.model.characters.Characters
import com.example.marvel.model.comics.CharacterDetails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("/v1/public/characters?")
    fun getCharacters(@Query("ts") ts: String = TS,
                      @Query("apikey") apiKey: String = API_KEY,
                      @Query("hash") hash: String = HASH,
                      @Query("offset") offSet: Int,
                      @Query("limit") limit: Int
    ): Call<Characters>

    @GET("/v1/public/characters/{characterId}/{option}?")
    fun getCharacterDetails(@Path("characterId") idCharacter: Int,
                            @Path("option") option: String,
                            @Query("limit") limit: Int,
                            @Query("ts") ts: String = TS,
                            @Query("apikey") apiKey: String = API_KEY,
                            @Query("hash") hash: String = HASH
    ): Call<CharacterDetails>

    private companion object{
        const val TS = "1"
        const val API_KEY = "6253edfe88d0a0142ee64ad46a162160"
        const val HASH = "97bc35c8096b31be0da8bd253480c66f"
    }
}