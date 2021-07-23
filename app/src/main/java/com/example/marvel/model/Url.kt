package com.example.marvel.model

data class Url(
    val type: String? = null,
    val url: String? = null


) {
    override fun toString(): String {
        return "Url(type='$type', url='$url')"
    }
}