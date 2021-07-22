package com.example.marvel.model

data class Events(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemX>,
    val returned: Int

) {
    override fun toString(): String {
        return "Events(available=$available, collectionURI='$collectionURI', items=$items, returned=$returned)"
    }
}