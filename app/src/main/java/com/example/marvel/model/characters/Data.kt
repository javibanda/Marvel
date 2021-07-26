package com.example.marvel.model.characters

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("results")
    val heroes: List<Hero>,
    @SerializedName("count")
    val count: Int
) {
    override fun toString(): String {
        return "com.example.marvel.model.comics.Data(results=$heroes)"
    }
}