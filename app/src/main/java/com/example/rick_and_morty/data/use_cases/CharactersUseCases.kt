package com.example.rick_and_morty.data.use_cases

import androidx.paging.PagingData
import com.example.rick_and_morty.data.models.CharactersModel
import com.example.rick_and_morty.data.repositories.CharactersRepository
import kotlinx.coroutines.flow.Flow

class CharactersUseCases (
    private val charactersRepository: CharactersRepository
) {

    fun execute(
        name: String?,
        status: String?,
        gender: String?,
        type: String?,
        species: String?
    ): Flow<PagingData<CharactersModel>> {
        return charactersRepository.getAllCharacters(
            name = name,
            status = status,
            gender = gender,
            type = type,
            species = species
        )
    }
}