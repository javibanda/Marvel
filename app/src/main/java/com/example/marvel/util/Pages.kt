package com.example.marvel.util

class Pages(private val limit:Int, private var page: Int) {

    fun getOffSet(page: Int) = (page - 1) * limit

    fun movePage(page: Int, count: Int): Boolean{
        return if (hasNextPage(page, count)){
            this.page = this.page + page
            true
        }else{
            false
        }
    }

    fun getPage(): Int = page

    private fun hasNextPage(page: Int, count: Int) = ((this.page + page != 0) && (count > 1))

}