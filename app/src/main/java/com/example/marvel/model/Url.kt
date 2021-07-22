package com.example.marvel.model

data class Url(
    val type: String,
    val url: String


) {
    override fun toString(): String {
        return "Url(type='$type', url='$url')"
    }
}