package com.example.rick_and_morty.data.episodes

import android.os.Bundle
import androidx.fragment.app.Fragment

class EpisodeDetailsFragment:Fragment() {

    companion object {
        private const val KEY_EPISODE_ID: String = "KEY_EPISODE_ID"

        @JvmStatic
        fun newInstance(
            episodeId: Int,
        ) =
            EpisodeDetailsFragment().apply {
                arguments = Bundle().apply {
                    putInt(KEY_EPISODE_ID, episodeId)
                }
            }
    }
}