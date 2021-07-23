package com.example.marvel.model

data class Events(
    val available: Int? = null,
    val collectionURI: String? = null,
    val items: List<ItemX>? = null,
    val returned: Int? = null

) {
    override fun toString(): String {
        return "Events(available=$available, collectionURI='$collectionURI', items=$items, returned=$returned)"
    }
}