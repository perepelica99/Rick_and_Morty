package com.example.rick_and_morty.ui.adapters


import android.content.Context
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IntRange
import androidx.recyclerview.widget.DiffUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.rick_and_morty.R
import com.example.rick_and_morty.databinding.ItemCharacterBinding
import com.example.rick_and_morty.ui.adapters.CharactersAdapter.CharactersViewHolder
import com.example.rick_and_morty.ui.models.CharacterPresentation


class CharactersAdapter : RecyclerView.Adapter<CharactersViewHolder>() {

    private var onCharacterItem: ((CharacterPresentation) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val context: Context = parent.context
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_character, parent, false)
        return CharactersViewHolder(itemView)
    }


    override fun onBindViewHolder(holderContacts: CharactersViewHolder, position: Int) {


     /*   getItem(position)?.let { holderContacts.bind(it) }
        holderContacts.itemView.setOnClickListener {
           onCharacterItem?.invoke(getItem(position)!!)
        }*/

    }


    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


    private class CharactersDiffCallback : DiffUtil.ItemCallback<CharacterPresentation>() {
        override fun areItemsTheSame(
            oldItem: CharacterPresentation,
            newItem: CharacterPresentation
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: CharacterPresentation,
            newItem: CharacterPresentation
        ): Boolean {
            return oldItem == newItem
        }
    }


        class CharactersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemCharacterBinding.bind(itemView)

        fun bind(item: CharacterPresentation) = with(binding) {
            characterName.text = item.name
            characterSapience.text = item.species
            characterStatus.text = item.status

            when (item.gender) {
                "Male" -> itemGender.setImageResource(R.drawable.ic_male)
                "Female" -> itemGender.setImageResource(R.drawable.ic_female)
                "Unknown" -> itemGender.setImageResource(R.drawable.ic_unknown)
                else -> itemGender.setImageResource(R.drawable.ic_genderless)
            }

            Glide.with(itemView)
                .load(item.imageUrl)
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_dissconect)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .centerCrop()
                .into(characterImage)
        }
    }
}