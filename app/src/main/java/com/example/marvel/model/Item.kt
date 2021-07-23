package com.example.marvel.model

data class Item(
    val name: String? = null,
    val resourceURI: String? = null


) {
    override fun toString(): String {
        return "Item(name='$name', resourceURI='$resourceURI')"
    }
}