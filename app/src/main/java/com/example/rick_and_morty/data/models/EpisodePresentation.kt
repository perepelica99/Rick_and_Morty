package com.example.rick_and_morty.data.models

data class EpisodePresentation(
    val id: Int,
    val name: String,
    val air_date: String,
    val episode: String,
    val residentsIds: List<Int>
)