package com.example.marvel.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import com.example.marvel.R
import com.example.marvel.model.characters.Hero
import com.example.marvel.model.characters.Thumbnail
import com.example.marvel.util.loadUrl


class HeroFragment : Fragment() {

    private lateinit var imgHero: ImageView
    private lateinit var txtName: TextView
    private lateinit var txtDescription: TextView
    private lateinit var hero: Hero
    private lateinit var btnComic: Button
    private lateinit var btnSeries: Button
    private val args: HeroFragmentArgs by navArgs()


    private fun initView(viewInit: View): View? {
        imgHero = viewInit.findViewById(R.id.imgCharacter)
        txtName = viewInit.findViewById(R.id.txtNameCharacter)
        txtDescription = viewInit.findViewById(R.id.txtDescriptionCharacter)
        btnComic = viewInit.findViewById(R.id.btnComics)
        btnSeries = viewInit.findViewById(R.id.btnSeries)
        initHero()
        return viewInit
    }

    private fun initHero(){
        val thumbnail = Thumbnail(args.thumbnailExtension, args.thumbnailPath)
        hero = Hero(
            args.descriptionHero,
            args.idHero,
            args.nameHero,
            thumbnail
            )
    }

    private fun initNavigation(option: String) =
        HeroFragmentDirections.actionHeroFragmentToListComicsAndSeriesFragment(hero.id, option)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_hero, container, false)
        return initView(view)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        implementInterface()
        allClicks()
    }

    private fun implementInterface(){
        imgHero.loadUrl(hero.thumbnail.getUrl())
        txtName.text = hero.name
        setDescription()
    }

    private fun navigate(option: String){
        NavHostFragment.findNavController(this).navigate(
            initNavigation(option)
        )
    }

    private fun clickBtnComics(){
        btnComic.setOnClickListener {
            navigate(OPTION_COMICS)
        }
    }

    private fun clickBtnSeries(){
        btnSeries.setOnClickListener {
            navigate(OPTION_SERIES)
        }
    }

    private fun allClicks(){
        clickBtnComics()
        clickBtnSeries()
    }

    private fun setDescription(){
        with(hero){
            with(txtDescription) {
                text = if (description == "") {
                    resources.getString(R.string.no_description)
                } else {
                    description
                }
            }
        }
    }

    companion object {
        private const val OPTION_COMICS = "comics"
        private const val OPTION_SERIES = "series"
    }


}