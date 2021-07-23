package com.example.marvel.model

data class Thumbnail(
    val extension: String? = null,
    val path: String? = null


) {
    override fun toString(): String {
        return "Thumbnail(extension='$extension', path='$path')"
    }
}