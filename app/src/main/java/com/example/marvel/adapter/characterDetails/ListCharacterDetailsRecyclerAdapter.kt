package com.example.marvel.adapter.characterDetails

import android.view.View
import com.example.marvel.R
import com.example.marvel.adapter.base.BaseRecyclerAdapter

import com.example.marvel.model.comics.ComicsAndSeries

class ListCharacterDetailsRecyclerAdapter (
    private val itemsList: List<ComicsAndSeries>
    ) : BaseRecyclerAdapter<ComicsAndSeries, ListCharacterDetailsViewHolder>(itemsList){
        override fun getViewHolderLayoutId(viewType: Int) = R.layout.item_list

        override fun createViewHolder(view: View, viewType: Int) = ListCharacterDetailsViewHolder(view)

        override fun onBindViewHolder(holder: ListCharacterDetailsViewHolder, position: Int) {
            holder.bindCharacterDetails(itemsList[position])
        }
}