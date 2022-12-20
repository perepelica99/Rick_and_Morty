package com.example.rick_and_morty.data.locations

import android.os.Bundle
import androidx.fragment.app.Fragment

class LocationDetailsFragment:Fragment() {

    companion object {
        private const val KEY_LOCATION_ID: String = "KEY_LOCATION_ID"

        @JvmStatic
        fun newInstance(
            locationId: Int,
        ) =
            LocationDetailsFragment().apply {
                arguments = Bundle().apply {
                    putInt(KEY_LOCATION_ID, locationId)
                }
            }
    }
}