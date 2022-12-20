package com.example.rick_and_morty.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

class PageKeys {}

    @Entity(tableName = "CHARACTERS_PAGE_KEYS")
    data class CharactersPageKeys(
        @PrimaryKey(autoGenerate = false)
        val id: Int,
        val prevPage: Int?,
        val nextPage: Int?
    )

    @Entity(tableName = "EPISODES_PAGE_KEYS")
    data class EpisodesPageKeys(
        @PrimaryKey(autoGenerate = false)
        val id: Int,
        val prevPage: Int?,
        val nextPage: Int?
    )

    @Entity(tableName = "LOCATIONS_PAGE_KEYS")
    data class LocationsPageKeys(
        @PrimaryKey(autoGenerate = false)
        val id: Int,
        val prevPage: Int?,
        val nextPage: Int?
    )
