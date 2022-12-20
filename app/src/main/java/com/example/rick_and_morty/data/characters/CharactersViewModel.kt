package com.example.rick_and_morty.data.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.map
import com.example.rick_and_morty.data.models.CharacterPresentation
import com.example.rick_and_morty.data.models.GetCharacterPresentationModel
import com.example.rick_and_morty.data.use_cases.CharactersUseCases
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class CharactersViewModel(
    private val getAllCharactersUseCase: CharactersUseCases ) : ViewModel() {

    private val _filteredTrigger = MutableStateFlow<MutableMap<String, String?>>(
        mutableMapOf(
            "name" to null,
            "gender" to null,
            "status" to null,
            "species" to null,
            "type" to null
        )
    )
    val filteredTrigger: MutableStateFlow<MutableMap<String, String?>> = _filteredTrigger

    private var _charactersFlow = MutableSharedFlow<PagingData<CharacterPresentation>>()
    val charactersFlow = _charactersFlow



    fun getCharactersByParams(
        name: String?,
        status: String?,
        gender: String?,
        type: String?,
        species: String?
    ) {
        getAllCharactersUseCase.execute(
            name = name,
            status = status,
            gender = gender,
            type = type,
            species = species
        ).onEach {
            _charactersFlow.emit(
                it.map { obj -> GetCharacterPresentationModel().transform(obj) }
            )
        }.launchIn(viewModelScope)
    }
}