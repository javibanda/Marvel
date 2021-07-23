package com.example.marvel.model

data class Characters(
    val attributionHTML: String? = null,
    val attributionText: String? = null,
    val code: Int? = null,
    val copyright: String? = null,
    val `data`: Data,
    val etag: String? = null,
    val status: String? = null

) {
    override fun toString(): String {
        return "Characters(attributionHTML='$attributionHTML', attributionText='$attributionText', code=$code, copyright='$copyright', `data`=$`data`, etag='$etag', status='$status')"
    }
}