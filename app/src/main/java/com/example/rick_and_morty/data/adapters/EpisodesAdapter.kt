package com.example.rick_and_morty.data.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.rick_and_morty.R
import com.example.rick_and_morty.data.models.EpisodePresentation
import com.example.rick_and_morty.databinding.ItemEpisodeBinding

class EpisodesAdapter : PagingDataAdapter<EpisodePresentation, EpisodesViewHolder>(EpisodesDiffCallback()) {

    var onEpisodeItem: ((EpisodePresentation) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        EpisodesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_episode, parent, false))


    override fun onBindViewHolder(holderContacts: EpisodesViewHolder, position: Int) {
        getItem(position)?.let { holderContacts.bind(it) }
        holderContacts.itemView.setOnClickListener {
            onEpisodeItem?.invoke(getItem(position)!!)
        }
    }

    private class EpisodesDiffCallback : DiffUtil.ItemCallback<EpisodePresentation>() {

        override fun areItemsTheSame(
            oldItem: EpisodePresentation,
            newItem: EpisodePresentation
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: EpisodePresentation,
            newItem: EpisodePresentation
        ): Boolean {
            return oldItem == newItem
        }
    }
}

class EpisodesViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    private val binding = ItemEpisodeBinding.bind(itemView)

    fun bind(item: EpisodePresentation) = with(binding) {

        nameEpisodeItem.text = item.name
        dataEpisodeItem.text = item.air_date
        numberEpisodeItem.text = item.episode
    }
}