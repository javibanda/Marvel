package com.example.marvel.model

data class ItemXX(
    val name: String? = null,
    val resourceURI: String? = null

) {
    override fun toString(): String {
        return "ItemXX(name='$name', resourceURI='$resourceURI')"
    }
}