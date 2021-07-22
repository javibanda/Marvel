package com.example.marvel.model

data class Data(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<Result>,
    val total: Int


) {
    override fun toString(): String {
        return "Data(count=$count, limit=$limit, offset=$offset, results=$results, total=$total)"
    }
}