package com.example.marvel.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.marvel.R
import com.example.marvel.model.characters.Hero
import com.example.marvel.util.loadUrl


class HeroFragment : Fragment() {

    private lateinit var imgHero: ImageView
    private lateinit var txtName: TextView
    private lateinit var txtDescription: TextView
    private lateinit var hero: Hero

    private fun initView(viewInit: View): View? {
        imgHero = viewInit.findViewById(R.id.imgCharacter)
        txtName = viewInit.findViewById(R.id.txtNameCharacter)
        txtDescription = viewInit.findViewById(R.id.txtDescriptionCharacter)
        return viewInit
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_hero, container, false)
        return initView(view)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun implementInterface(url: String, nameHero: String, descriptionHero: String){
        imgHero.loadUrl(url)
        txtName.text = nameHero
        txtDescription.text = descriptionHero
    }


}