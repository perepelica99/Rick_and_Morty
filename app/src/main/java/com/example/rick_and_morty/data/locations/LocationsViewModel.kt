package com.example.rick_and_morty.data.locations

import android.os.AsyncTask.execute
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import com.example.rick_and_morty.data.models.LocationPresentation
import com.example.rick_and_morty.data.use_cases.LocationsUseCases
import kotlinx.coroutines.flow.MutableSharedFlow

class LocationsViewModel (
    private val getAllLocationsUseCase: // LocationsUseCases
) : ViewModel() {


    private val _filteredTrigger = MutableLiveData<MutableMap<String, String?>>(
        mutableMapOf(
            "name" to null,
            "type" to null,
            "dimension" to null,
        )
    )

    val filteredTrigger: MutableLiveData<MutableMap<String, String?>> = _filteredTrigger

    private var _locationsFlow = MutableSharedFlow<PagingData<LocationPresentation>>()
    val locationsFlow = _locationsFlow

    init {
        // getLocationsByParams(null, null, null)
    }


   /* @ExperimentalPagingApi
    class LocationsViewModelProvider(
        private val getAllLocationsUseCase:  LocationsUseCases
    ) : ViewModelProvider.Factory {


        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return LocationsViewModel(
                getAllLocationsUseCase = LocationsUseCases
            ) as T
        }
    }*/
}