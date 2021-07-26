package com.example.marvel.adapter.characterDetails

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.marvel.R
import com.example.marvel.adapter.base.BaseViewHolder
import com.example.marvel.model.comics.ComicsAndSeries
import com.example.marvel.util.loadUrl

class ListCharacterDetailsViewHolder(itemView: View) : BaseViewHolder(itemView)  {

    private val txtName = itemView.findViewById<TextView>(R.id.txtName)
    private val img = itemView.findViewById<ImageView>(R.id.img)

    @SuppressLint("SetTextI18n")
    fun bindCharacterDetails(characterDetails: ComicsAndSeries){
        txtName.text = characterDetails.title
        img.loadUrl(characterDetails.thumbnail.getUrl())
    }
}