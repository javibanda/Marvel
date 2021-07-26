package com.example.marvel.model.comics

import com.example.marvel.model.characters.Thumbnail

data class ComicsAndSeries(
    val id: Int,
    val thumbnail: Thumbnail,
    val title: String)