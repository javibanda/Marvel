package com.example.marvel.model.characters

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("results") val heroes: List<Heroes>,
    @SerializedName("count")
    val count: Int
) {
    override fun toString(): String {
        return "Data(results=$heroes)"
    }
}