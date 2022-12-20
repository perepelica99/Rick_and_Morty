package com.example.rickandmorty.presentation.models.episode

data class EpisodePresentation(
    val id: Int,
    val name: String,
    val air_date: String,
    val episode: String,
    val residentsIds: List<Int>
)