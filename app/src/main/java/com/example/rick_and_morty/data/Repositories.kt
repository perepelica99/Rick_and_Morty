package com.example.rick_and_morty.data

import androidx.paging.PagingData
import com.example.rick_and_morty.data.models.CharactersModel
import kotlinx.coroutines.flow.Flow

class Repositories {
}

interface CharacterDetailsRepository {

    suspend fun getCharacterById(id: Int): CharactersModel
}


interface GetCharacterFiltersRepository {
    fun getListCharactersSpecies(): Flow<List<String>>

    fun getListCharactersTypes(): Flow<List<String>>
}