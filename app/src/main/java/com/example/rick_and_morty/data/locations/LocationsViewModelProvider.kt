package com.example.rick_and_morty.data.locations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.paging.ExperimentalPagingApi
import com.example.rick_and_morty.data.use_cases.LocationsUseCases

@ExperimentalPagingApi
class LocationsViewModelProvider(
    private val getAllLocationsUseCase: LocationsUseCases
) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LocationsViewModel(
            getAllLocationsUseCase = getAllLocationsUseCase
        ) as T
    }
}