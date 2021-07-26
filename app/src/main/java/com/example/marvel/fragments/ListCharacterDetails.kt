package com.example.marvel.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.R
import com.example.marvel.adapter.characterDetails.ListCharacterDetailsRecyclerAdapter
import com.example.marvel.adapter.heroes.ListHeroesRecyclerAdapter
import com.example.marvel.model.comics.CharacterDetails
import com.example.marvel.model.comics.ComicsAndSeries
import com.example.marvel.retrofit.API
import com.example.marvel.util.Toasts.showToastEmptyList
import com.example.marvel.util.Toasts.showToastNoInternet
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ListCharacterDetails : Fragment() {

    private val args: ListCharacterDetailsArgs by navArgs()
    private lateinit var recyclerCharacterDetails: RecyclerView

    private fun initView(viewInit: View): View {
        recyclerCharacterDetails = viewInit.findViewById(R.id.recyclerCharactersDetails)
        return viewInit
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view =  inflater.inflate(R.layout.fragment_list_comics_and_series, container, false)
        return initView(view)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getDataApiComics(getIntCharacter())

    }

    private fun getDataApiComics(id: Int){
        val call = API.retrofit.getCharacterDetails(id, getOption(), LIMIT_COMICS_AND_SERIES)
        call.enqueue(object : Callback<CharacterDetails> {
            override fun onResponse(call: Call<CharacterDetails>, response: Response<CharacterDetails>) {
                val listCharacterDetails = response.body()!!.data.results
                initRecyclerViewHeroes(listCharacterDetails)
            }
            override fun onFailure(call: Call<CharacterDetails>, t: Throwable) {
                context?.let { showToastNoInternet(it) }
            }
        })
    }

    private fun initRecyclerViewHeroes(listCharacterDetails:List<ComicsAndSeries>){
            if (listCharacterDetails.isEmpty()){
                context?.let { showToastEmptyList(it, getOption()) }
                requireActivity().onBackPressedDispatcher.onBackPressed()
            }else{
                val listCharacterDetailsAdapter = ListCharacterDetailsRecyclerAdapter(listCharacterDetails)
                recyclerCharacterDetails.apply {
                    layoutManager = LinearLayoutManager(activity)
                    setHasFixedSize(true)
                    adapter = listCharacterDetailsAdapter
                }
            }
    }

    private fun getIntCharacter(): Int = args.idCharacter

    private fun getOption(): String = args.comicOrSerie

    companion object {
        private const val LIMIT_COMICS_AND_SERIES = 100
    }

}