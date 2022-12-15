package com.example.rick_and_morty.ui.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rick_and_morty.R

import com.example.rick_and_morty.databinding.FragmentCharactersBinding
import com.example.rick_and_morty.ui.adapters.CharactersAdapter

class CharactersFragment : Fragment() {

    private lateinit var binding: FragmentCharactersBinding
    private var charactersAdapter: CharactersAdapter = CharactersAdapter()

    private var params: MutableMap<String, String?> = mutableMapOf(
        "name" to null,
        "gender" to null,
        "status" to null,
        "species" to null,
        "type" to null
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_characters,container,false)
    }
}