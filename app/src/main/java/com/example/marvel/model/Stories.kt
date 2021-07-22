package com.example.marvel.model

data class Stories(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemXXX>,
    val returned: Int


) {
    override fun toString(): String {
        return "Stories(available=$available, collectionURI='$collectionURI', items=$items, returned=$returned)"
    }
}