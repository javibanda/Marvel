package com.example.marvel.model

data class Data(
    var count: Int,
    val limit: Int? = null,
    val offset: Int? = null,
    val results: List<Result>? = null,
    val total: Int? = null


) {
    override fun toString(): String {
        return "Data(count=$count, limit=$limit, offset=$offset, results=$results, total=$total)"
    }
}