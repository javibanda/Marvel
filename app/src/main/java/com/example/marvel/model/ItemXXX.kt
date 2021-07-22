package com.example.marvel.model

data class ItemXXX(
    val name: String,
    val resourceURI: String,
    val type: String

) {
    override fun toString(): String {
        return "ItemXXX(name='$name', resourceURI='$resourceURI', type='$type')"
    }
}