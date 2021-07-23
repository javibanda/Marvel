package com.example.marvel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.marvel.retrofit.API
import com.example.marvel.model.characters.Characters
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getCurrentData()

    }

    private fun getCurrentData(){
        val call = API.retrofit.getCharacters()
        call.enqueue(object : Callback<Characters> {
            override fun onResponse(call: Call<Characters>, response: Response<Characters>) {
                if (response.code() == 200){
                    Log.d(":::Retro", response.body()?.data?.heroes.toString())


                }else{
                    Log.d(":::Retrofit", "ERROR")
                }
            }

            override fun onFailure(call: Call<Characters>, t: Throwable) {

                t.message?.let { Log.d(":::Retrofit", it) }
            }

        })
    }



}