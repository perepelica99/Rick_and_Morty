package com.example.rick_and_morty.data.models

data class CharactersModel(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val originLocation: Map<String, String>,
    val lastLocation: Map<String, String>,
    val imageUrl: String,
    val episodeIds: List<Int>
)


interface Mapper<T, R> {
    fun transform(data: T): R
}


class GetCharacterPresentationModel :
    Mapper<CharactersModel, CharacterPresentation> {

    override fun transform(data: CharactersModel): CharacterPresentation {

        return CharacterPresentation(
            id = data.id,
            name = data.name,
            species = data.species,
            status = data.status,
            type = data.type,
            gender = data.gender,
            originLocation = data.originLocation,
            lastLocation = data.lastLocation,
            imageUrl = data.imageUrl,
            episodeIds = data.episodeIds,
        )
    }
}

