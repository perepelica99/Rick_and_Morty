package com.example.rick_and_morty.data.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.paging.ExperimentalPagingApi
import com.example.rick_and_morty.data.use_cases.CharactersUseCases

@ExperimentalPagingApi
class CharactersViewModelProvider(
    private val getAllCharactersUseCase: CharactersUseCases
) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CharactersViewModel(
            getAllCharactersUseCase = getAllCharactersUseCase
        ) as T
    }
}