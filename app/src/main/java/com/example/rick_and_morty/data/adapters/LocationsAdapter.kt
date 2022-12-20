package com.example.rick_and_morty.data.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.rick_and_morty.R
import com.example.rick_and_morty.data.models.LocationPresentation
import com.example.rick_and_morty.databinding.ItemLocationsBinding

class LocationsAdapter : PagingDataAdapter<LocationPresentation, LocationsViewHolder>(LocationsDiffCallback()) {

    var onLocationItem: ((LocationPresentation) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        LocationsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_locations, parent, false))


    override fun onBindViewHolder(holderContacts: LocationsViewHolder, position: Int) {
        getItem(position)?.let { holderContacts.bind(it) }
        holderContacts.itemView.setOnClickListener {
            onLocationItem?.invoke(getItem(position)!!)
        }
    }

    private class LocationsDiffCallback : DiffUtil.ItemCallback<LocationPresentation>() {

        override fun areItemsTheSame(
            oldItem: LocationPresentation,
            newItem: LocationPresentation
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: LocationPresentation,
            newItem: LocationPresentation
        ): Boolean {
            return oldItem == newItem
        }
    }
}


class LocationsViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    private val binding = ItemLocationsBinding.bind(itemView)

    fun bind(item: LocationPresentation) = with(binding) {

        nameLocationItem.text = item.name
        dimensionLocationItem.text = item.dimension
        typeLocationItem.text = item.dimension
    }

}