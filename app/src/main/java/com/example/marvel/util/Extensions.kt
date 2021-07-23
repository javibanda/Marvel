package com.example.marvel.util

import android.content.Context
import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.loadUrl(url: String){
    Picasso
        .get()
        .load(url)
        .resize(context.convertDpToPX( this.layoutParams.width),
            context.convertDpToPX(this.layoutParams.height)
        ).into(this)
}

fun Context.convertDpToPX(dp: Int) =
    (dp * resources.displayMetrics.density).toInt()