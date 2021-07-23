package com.example.marvel.model

data class ItemX(
    val name: String? = null,
    val resourceURI: String? = null


) {
    override fun toString(): String {
        return "ItemX(name='$name', resourceURI='$resourceURI')"
    }
}