package com.example.rick_and_morty.data.models

data class LocationPresentation(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residentsIds: List<Int>
)