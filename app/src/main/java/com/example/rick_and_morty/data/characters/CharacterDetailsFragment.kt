package com.example.rick_and_morty.data.characters

import android.os.Bundle
import androidx.fragment.app.Fragment

class CharacterDetailsFragment : Fragment() {


    companion object {
        private const val KEY_CHARACTER_ID: String = "KEY_CHARACTER_ID"

        @JvmStatic
        fun newInstance(
            characterId: Int
        ) =
            CharacterDetailsFragment().apply {
                arguments = Bundle().apply {
                    putInt(KEY_CHARACTER_ID, characterId)
                }
            }
    }
}