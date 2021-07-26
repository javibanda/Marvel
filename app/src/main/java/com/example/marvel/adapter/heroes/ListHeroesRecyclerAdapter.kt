package com.example.marvel.adapter.heroes

import android.view.View
import androidx.fragment.app.Fragment
import com.example.marvel.R
import com.example.marvel.adapter.base.BaseRecyclerAdapter
import com.example.marvel.model.characters.Hero

class ListHeroesRecyclerAdapter(
    private val itemsList: List<Hero>,
    private val fragment: Fragment,
) : BaseRecyclerAdapter<Hero, ListHeroesViewHolder>(itemsList){
    override fun getViewHolderLayoutId(viewType: Int) = R.layout.item_hero_list

    override fun createViewHolder(view: View, viewType: Int) = ListHeroesViewHolder(view)

    override fun onBindViewHolder(holder: ListHeroesViewHolder, position: Int) {
        holder.bindHeroes(itemsList[position], fragment)
    }
}