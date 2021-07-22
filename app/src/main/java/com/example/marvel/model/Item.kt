package com.example.marvel.model

data class Item(
    val name: String,
    val resourceURI: String


) {
    override fun toString(): String {
        return "Item(name='$name', resourceURI='$resourceURI')"
    }
}