package com.example.rick_and_morty

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.rick_and_morty.data.characters.CharacterDetailsFragment
import com.example.rick_and_morty.data.characters.CharactersFragment
import com.example.rick_and_morty.data.characters.CharactersFragment.Companion.newInstance
import com.example.rick_and_morty.data.episodes.EpisodeDetailsFragment
import com.example.rick_and_morty.data.episodes.EpisodesFragment
import com.example.rick_and_morty.data.locations.LocationDetailsFragment
import com.example.rick_and_morty.data.locations.LocationsFragment
import java.lang.reflect.Array.newInstance


class MainActivity : AppCompatActivity(), Navigator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container_navigator,
                    CharactersFragment(),
                "the first layout was added").commit()
        }else {
            if (supportFragmentManager.backStackEntryCount == 0) {
                supportFragmentManager.popBackStack("ADD FIRST FRAGMENT", 0)
            } else {
                val backEntry: FragmentManager.BackStackEntry =
                    supportFragmentManager.getBackStackEntryAt(supportFragmentManager.backStackEntryCount - 1)
                val tag = backEntry.name
                supportFragmentManager.popBackStack(tag, 0)
            }
        }


    }

    override fun openCharactersFragment() {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.container_navigator,
                CharactersFragment(),
                "CHARACTERS_FRAGMENT"
            ).addToBackStack("OPEN_CHARACTERS_FRAGMENT")
            .commit()
        supportFragmentManager.popBackStack("CHARACTERS_FRAGMENT", FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    override fun openEpisodesFragment() {
        if ( supportFragmentManager.backStackEntryCount > 0 ) {
            val backEntry: FragmentManager.BackStackEntry =
                supportFragmentManager.getBackStackEntryAt(supportFragmentManager.backStackEntryCount - 1)
            val tag = backEntry.name
            if(tag == "OPEN_EPISODE_FRAGMENT") return
        }

        supportFragmentManager.beginTransaction()
            .replace(
                R.id.container_navigator,
                EpisodesFragment(),
                "EPISODES_FRAGMENT"
            ).addToBackStack("OPEN_EPISODE_FRAGMENT")
            .commit()
    }

    override fun openLocationsFragment()  {
        if ( supportFragmentManager.backStackEntryCount > 0 ) {
            val backEntry: FragmentManager.BackStackEntry =
                supportFragmentManager.getBackStackEntryAt(supportFragmentManager.backStackEntryCount - 1)
            val tag = backEntry.name
            if(tag == "OPEN_LOCATION_FRAGMENT") return
        }

        supportFragmentManager.beginTransaction()
            .replace(
                R.id.container_navigator,
                LocationsFragment(),
                "LOCATIONS_FRAGMENT"
            ).addToBackStack("OPEN_LOCATION_FRAGMENT")
            .commit()
    }

    override fun openCharactersFilterFragment() {
        TODO("Not yet implemented")
    }

    override fun openEpisodesFilterFragment() {
        TODO("Not yet implemented")
    }

    override fun openLocationsFilterFragment() {
        TODO("Not yet implemented")
    }

    override fun openCharactersFragmentWithArg(
        status: String?,
        gender: String?,
        species: String?,
        type: String?
    ) {
        TODO("Not yet implemented")
    }

    override fun openEpisodesFragmentWithArg(episode: String?) {
        TODO("Not yet implemented")
    }

    override fun openLocationsFragmentWithArg(type: String?, dimension: String?) {
        TODO("Not yet implemented")
    }

    override fun openCharacterDetailFragment(characterId: Int) {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.container_navigator,
                CharacterDetailsFragment.newInstance(
                    characterId = characterId
                ),
                "CHARACTERS_DETAIL_FRAGMENT"
            ).addToBackStack("OPEN_CharacterDetailFragment")
            .commit()
    }

    override fun openEpisodesDetailFragment(episodeId: Int) {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.container_navigator,
                EpisodeDetailsFragment.newInstance(
                    episodeId = episodeId
                ),
                "EPISODES_DETAIL_FRAGMENT"
            ).addToBackStack("OPEN_EpisodesDetailFragment")
            .commit()
    }

    override fun openLocationsDetailFragment(locationId: Int) {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.container_navigator,
                LocationDetailsFragment.newInstance(
                    locationId = locationId
                ),
                "LOCATIONS_DETAIL_FRAGMENT"
            ).addToBackStack("OPEN_LocationsDetailFragment")
            .commit()
    }

    override fun backButton() {
       onBackPressedDispatcher.onBackPressed()
    }
}