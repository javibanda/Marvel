package com.example.marvel.model

data class Stories(
    val available: Int? = null,
    val collectionURI: String? = null,
    val items: List<ItemXXX>? = null,
    val returned: Int? = null


) {
    override fun toString(): String {
        return "Stories(available=$available, collectionURI='$collectionURI', items=$items, returned=$returned)"
    }
}