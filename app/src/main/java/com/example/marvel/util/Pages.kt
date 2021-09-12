package com.example.marvel.util

class Pages(private val limit:Int) {

    var totalElements: Int = -1
    private var page: Int = 1

    fun getTotalPages(): Int {
        return if(totalElements%limit == 0){
            (totalElements/limit)
        }else{
            ((totalElements/limit) + 1)
        }
    }

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