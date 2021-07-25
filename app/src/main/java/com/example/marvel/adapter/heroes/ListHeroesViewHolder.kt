package com.example.marvel.adapter.heroes

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.marvel.R
import com.example.marvel.adapter.base.BaseViewHolder
import com.example.marvel.fragments.ListHeroesFragmentDirections
import com.example.marvel.model.characters.Hero
import com.example.marvel.util.loadUrl

class ListHeroesViewHolder(itemView: View) : BaseViewHolder(itemView) {

    private val txtName = itemView.findViewById<TextView>(R.id.txtNameHero)
    private val imgHero = itemView.findViewById<ImageView>(R.id.imgHero)

    fun bindHeroes(hero: Hero, fragment: Fragment){
        txtName.text = hero.name
        imgHero.loadUrl(hero.thumbnail.getUrl())
        click(fragment, hero)
    }

    private fun initNavigate(hero: Hero) =
        ListHeroesFragmentDirections.actionListHeroesFragmentToHeroFragment(
            hero.id,
            hero.name,
            hero.description,
            hero.thumbnail.getPath(),
            hero.thumbnail.getExtension()
        )


    private fun navigate(fragment: Fragment, hero: Hero){
        NavHostFragment.findNavController(fragment).navigate(
            initNavigate(hero))
    }

    private fun click(fragment: Fragment, hero: Hero){
        itemView.setOnClickListener {
            navigate(fragment, hero)
        }

    }
}