package com.example.rick_and_morty.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.rick_and_morty.data.characters.LinkedLocation


@Entity(tableName = "CHARACTERS_TABLE")
data class Characters(
    @PrimaryKey val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val image: String,
    @ColumnInfo(name = "origin")
    val origin: LinkedLocation,
    @ColumnInfo(name = "location")
    val location: LinkedLocation,
    @ColumnInfo(name = "episodes")
    val episode: List<String>
)