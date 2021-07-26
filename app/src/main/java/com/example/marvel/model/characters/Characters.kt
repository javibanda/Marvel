package com.example.marvel.model.characters

import com.google.gson.annotations.SerializedName

data class Characters(
    @SerializedName("data")
    val data: Data
)