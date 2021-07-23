package com.example.marvel.model

data class Series(
    val available: Int? = null,
    val collectionURI: String? = null,
    val items: List<ItemXX>? = null,
    val returned: Int? = null

) {
    override fun toString(): String {
        return "Series(available=$available, collectionURI='$collectionURI', items=$items, returned=$returned)"
    }
}