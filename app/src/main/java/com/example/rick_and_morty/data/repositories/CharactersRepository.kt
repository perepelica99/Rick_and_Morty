package com.example.rick_and_morty.data.repositories

import androidx.paging.PagingData
import com.example.rick_and_morty.data.models.CharactersModel
import kotlinx.coroutines.flow.Flow

abstract class CharactersRepository {
    abstract fun getAllCharacters(
        name: String?,
        status: String?,
        gender: String?,
        type: String?,
        species: String?
    ): Flow<PagingData<CharactersModel>>

    abstract suspend fun getAllCharactersByIds(ids: List<Int>): List<CharactersModel>
}