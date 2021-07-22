package com.example.marvel.model

data class Characters(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val `data`: Data,
    val etag: String,
    val status: String

) {
    override fun toString(): String {
        return "Characters(attributionHTML='$attributionHTML', attributionText='$attributionText', code=$code, copyright='$copyright', `data`=$`data`, etag='$etag', status='$status')"
    }
}