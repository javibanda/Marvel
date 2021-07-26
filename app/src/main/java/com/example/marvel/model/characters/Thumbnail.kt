package com.example.marvel.model.characters

import com.google.gson.annotations.SerializedName

data class Thumbnail(
    private val extension: String,
    private val path: String,
) {
    fun getUrl(): String = "$path.$extension"

    fun getExtension(): String = extension

    fun getPath(): String = path

}
