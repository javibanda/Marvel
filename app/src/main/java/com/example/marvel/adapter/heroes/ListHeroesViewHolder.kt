package com.example.marvel.adapter.heroes

import android.media.Image
import android.view.TextureView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.marvel.R
import com.example.marvel.adapter.base.BaseViewHolder
import com.example.marvel.model.characters.Heroes
import com.example.marvel.util.loadUrl

class ListHeroesViewHolder(itemView: View) : BaseViewHolder(itemView) {

    private val txtName = itemView.findViewById<TextView>(R.id.txtNameHero)
    private val imgHero = itemView.findViewById<ImageView>(R.id.imgHero)

    fun bindHeroes(heroes: Heroes, fragment: Fragment){
        txtName.text = heroes.name
        imgHero.loadUrl(heroes.thumbnail.getUrl())
    }
}