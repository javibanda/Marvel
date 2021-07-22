package com.example.marvel.model

data class ItemXX(
    val name: String,
    val resourceURI: String

) {
    override fun toString(): String {
        return "ItemXX(name='$name', resourceURI='$resourceURI')"
    }
}