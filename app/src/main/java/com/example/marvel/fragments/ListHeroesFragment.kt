package com.example.marvel.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.R
import com.example.marvel.adapter.heroes.ListHeroesRecyclerAdapter
import com.example.marvel.util.Pages
import com.example.marvel.model.characters.Characters
import com.example.marvel.model.characters.Hero
import com.example.marvel.retrofit.API
import com.example.marvel.util.Toasts
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ListHeroesFragment : Fragment() {


    private var page = Pages(LIMIT_HEROES)
    private lateinit var recyclerHeroes: RecyclerView
    private lateinit var progressBar: ProgressBar
    private val heroList: MutableList<Hero> = ArrayList()
    private var recyclerIsInit = false


    private fun initView(viewInit: View): View? {
        recyclerHeroes = viewInit.findViewById(R.id.recyclerHeroes)
        progressBar = viewInit.findViewById(R.id.progressBar)
        return viewInit
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_list_heroes, container, false)
        return initView(view)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getDataApi()
        scrollListener()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        recyclerIsInit = false
    }

    private fun scrollListener(){
        recyclerHeroes.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (isOnLastElementList(recyclerView) && progressBarIsVisible()){
                    if (page.hasNextPage()){
                        getDataApi()
                        page.changePage()
                    }
                }
                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }

    private fun isOnLastElementList(recyclerView: RecyclerView): Boolean{
        val visibleItemCount = recyclerHeroes.childCount
        val pastVisibleItem = (recyclerView.layoutManager as LinearLayoutManager).findLastVisibleItemPosition()
        val totalItems = heroList.size
        return (visibleItemCount + pastVisibleItem) >= totalItems
    }

    private fun progressBarIsVisible() = progressBar.visibility != View.VISIBLE

    private fun recyclerViewHeroes(){
        val heroesAdapter = ListHeroesRecyclerAdapter(heroList, this)
        if (recyclerIsInit){
            changeLoadMoreData()
        }else{
            initRecyclerViewHeroes(heroesAdapter)
            recyclerIsInit = true
        }
    }

    private fun changeLoadMoreData(){
        recyclerHeroes.adapter!!.notifyDataSetChanged()
    }

    private fun initRecyclerViewHeroes(heroesAdapter: ListHeroesRecyclerAdapter){
        recyclerHeroes.apply {
            layoutManager = LinearLayoutManager(activity)
            setHasFixedSize(true)
            adapter = heroesAdapter
        }
    }

    private fun getDataApi(){
        progressBar.visibility = View.VISIBLE
        val call = API.retrofit.getCharacters(
            offSet = page.getOffSet(),
            limit = LIMIT_HEROES)
        call.enqueue(object : Callback<Characters> {
            override fun onResponse(call: Call<Characters>, response: Response<Characters>) {
                if (response.code() == 200){
                    page.totalElements = response.body()!!.data.total
                    addHeroes(response.body()!!.data.heroes)
                    recyclerViewHeroes()
                    progressBar.visibility = View.GONE
                }
            }
            override fun onFailure(call: Call<Characters>, t: Throwable) {
                context?.let { Toasts.showToastNoInternet(it) }
                progressBar.visibility = View.GONE
            }

        })
    }

    private fun addHeroes(listHeroes: List<Hero>) {
        for (i in listHeroes) heroList.add(i)
    }

    companion object {
        private const val LIMIT_HEROES = 10
    }
}