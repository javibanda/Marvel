package com.example.marvel.model

data class Comics(
    val available: Int? = null,
    val collectionURI: String? = null,
    val items: List<Item>? = null,
    val returned: Int? = null

) {
    override fun toString(): String {
        return "Comics(available=$available, collectionURI='$collectionURI', items=$items, returned=$returned)"
    }
}