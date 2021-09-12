package com.example.marvel.util

class Pages(private val limit:Int) {

    var totalElements: Int = -1
    private var page: Int = 1

    private fun getTotalPages(): Int {
        return if(totalElements%limit == 0){
            (totalElements/limit)
        }else{
            ((totalElements/limit) + 1)
        }
    }

    fun changePage(){
        page++
    }

    fun hasNextPage() = (getTotalPages() != page)

    fun getOffSet() = (page - 1) * limit
}