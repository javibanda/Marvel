package com.example.marvel.model

data class Series(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemXX>,
    val returned: Int

) {
    override fun toString(): String {
        return "Series(available=$available, collectionURI='$collectionURI', items=$items, returned=$returned)"
    }
}