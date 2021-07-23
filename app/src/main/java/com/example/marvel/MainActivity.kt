package com.example.marvel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AutoCompleteTextView
import android.widget.TextView
import com.example.marvel.interfaces.API
import com.example.marvel.model.Characters
import com.example.marvel.model.Data
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.text)
        Log.d(":::Retro", getCurrentData().toString())
    }

    private fun getCurrentData(): Characters? {

        var data: Characters? = null

        val call = API.retrofit.getCharacters(API.TS, API.API_KEY, API.HASH)
        call.enqueue(object : Callback<Characters> {
            override fun onResponse(call: Call<Characters>, response: Response<Characters>) {
                if (response.code() == 200){
                    Log.d(":::Retro", "paso1")

                    textView.text = response.body()?.status
                    response.body()?.status?.let { Log.d(":::Data", it )}
                    data = response.body()
                }else{
                    Log.d(":::Retrofit", "ERROR")
                }
            }

            override fun onFailure(call: Call<Characters>, t: Throwable) {

                t.message?.let { Log.d(":::Retrofit", it) }
            }

        })
        return data
    }



}