package com.example.marvel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.marvel.interfaces.API
import com.example.marvel.model.Data
import com.example.marvel.model.Result

class MainActivity : AppCompatActivity() {

    private val TS = "1"
    private val API_KEY = "6253edfe88d0a0142ee64ad46a162160"
    private val HASH = "97bc35c8096b31be0da8bd253480c66f"
    private var heroes: Data? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getHeroes()
    }

    private fun getHeroes(){
        val heroes = API.retrofit.getCharacters(TS, API_KEY, HASH)

        if (heroes.isSuccessful){
            this.heroes = heroes.body()


                Log.d(":::Retrofit", heroes.toString())

        }else{
            Log.d(":::Retrofit", "Error")
        }
    }

}