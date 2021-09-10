package com.example.marvel.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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


    private var page = Pages(LIMIT_HEROES, 1)

    private lateinit var recyclerHeroes: RecyclerView
    private lateinit var progressBar: ProgressBar
    val HeroList: MutableList<String> = ArrayList()


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
        getDataApi(0)

    }

    private fun initRecyclerViewHeroes(listHeroes: List<Hero>, changePage: Int, dataCount: Int){
        if(page.movePage(changePage, dataCount)){
            val heroesAdapter = ListHeroesRecyclerAdapter(listHeroes, this)
            recyclerHeroes.apply {
                layoutManager = LinearLayoutManager(activity)
                setHasFixedSize(true)
                adapter = heroesAdapter
            }
        }
    }

    private fun getProvisionalPage(changePage: Int)=  page.getPage() + changePage





    private fun getDataApi(changePage: Int){
        progressBar.visibility = View.VISIBLE
        val call = API.retrofit.getCharacters(
            offSet = page.getOffSet(getProvisionalPage(changePage)),
            limit = LIMIT_HEROES)
        call.enqueue(object : Callback<Characters> {
            override fun onResponse(call: Call<Characters>, response: Response<Characters>) {
                if (response.code() == 200){
                    val count = response.body()!!.data.count
                    val total = response.body()!!.data.total
                    page.totalElements = total

                    Log.d(":::", page.getTotalPages().toString())

                    initRecyclerViewHeroes(response.body()!!.data.heroes, changePage, count)
                    progressBar.visibility = View.GONE
                }
            }

            override fun onFailure(call: Call<Characters>, t: Throwable) {
                context?.let { Toasts.showToastNoInternet(it) }
            }

        })
    }

    companion object {
        private const val LIMIT_HEROES = 50
    }
}