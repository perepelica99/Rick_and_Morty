package com.example.rickandmorty

import com.example.rickandmorty.domain.models.episode.EpisodeModel
import com.example.rickandmorty.presentation.mapper.domain_model_to_presentation.GetEpisodePresentationModel
import com.example.rickandmorty.presentation.models.episode.EpisodePresentation
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class GetLocationPresentationMapperTest {
    var data: EpisodeModel? = null
    var transform: EpisodePresentation? = null
    @Before
    fun setUp() {
        data = EpisodeModel(id = 1, name = "Rick goes into the space", air_date = "12 feb", episode = "Episode 6", residentsIds = listOf(32, 54) )
        data?.let {
            transform = GetEpisodePresentationModel().transform(it)
        }
    }

    @Test
    fun isMappingCorrect() {
        data?.let { data ->
            transform?.let { transform ->
                assertEquals(data.id, transform.id)
                assertEquals(data.name, transform.name)
                assertEquals(data.air_date, transform.air_date)
                assertEquals(data.episode, transform.episode)
                assertEquals(data.residentsIds, transform.residentsIds)
            }
        }
    }

    @After
    fun tearDown(){
        data = null
        transform = null
    }

}