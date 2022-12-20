package com.example.rick_and_morty.data.episodes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import com.example.rick_and_morty.data.models.EpisodePresentation
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow

@ExperimentalPagingApi
class EpisodesViewModel(
    private val getAllEpisodesUseCase: GetAllEpisodesUseCase
) : ViewModel() {


    private val _filteredTrigger = MutableStateFlow<MutableMap<String, String?>>(
        mutableMapOf(
            "name" to null,
            "episode" to null
        )
    )

    val filteredTrigger: MutableStateFlow<MutableMap<String, String?>> = _filteredTrigger

    private var _episodesFlow = MutableSharedFlow<PagingData<EpisodePresentation>>()
    val episodesFlow = _episodesFlow



    }
}