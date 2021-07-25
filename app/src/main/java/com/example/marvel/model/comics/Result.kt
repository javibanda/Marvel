package com.example.marvel.model.comics

data class Result(
    val id: Int,
    val prices: List<Price>,
    val thumbnail: Thumbnail,
    val title: String,
)