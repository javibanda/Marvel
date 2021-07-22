package com.example.marvel.model

data class ItemX(
    val name: String,
    val resourceURI: String


) {
    override fun toString(): String {
        return "ItemX(name='$name', resourceURI='$resourceURI')"
    }
}