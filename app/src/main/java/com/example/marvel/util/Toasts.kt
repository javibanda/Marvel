package com.example.marvel.util

import android.content.Context
import android.widget.Toast

object Toasts {
    private fun showToast(context: Context, message: String){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show()
    }

    fun showToastNoInternet(context: Context){
        showToast(context, "No Internet, restart the application")
    }

    fun showToastEmptyList(context: Context, option: String){
        showToast(context, "There are not $option of this hero")
    }
}