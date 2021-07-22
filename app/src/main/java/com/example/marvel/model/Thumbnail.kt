package com.example.marvel.model

data class Thumbnail(
    val extension: String,
    val path: String


) {
    override fun toString(): String {
        return "Thumbnail(extension='$extension', path='$path')"
    }
}