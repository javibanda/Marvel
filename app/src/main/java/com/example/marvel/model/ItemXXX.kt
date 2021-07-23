package com.example.marvel.model

data class ItemXXX(
    val name: String? = null,
    val resourceURI: String? = null,
    val type: String? = null

) {
    override fun toString(): String {
        return "ItemXXX(name='$name', resourceURI='$resourceURI', type='$type')"
    }
}