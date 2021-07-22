package com.example.marvel.model

data class Comics(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int

) {
    override fun toString(): String {
        return "Comics(available=$available, collectionURI='$collectionURI', items=$items, returned=$returned)"
    }
}