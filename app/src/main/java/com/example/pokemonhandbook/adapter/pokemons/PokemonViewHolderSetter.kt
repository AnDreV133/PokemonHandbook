package com.example.pokemonhandbook.adapter.pokemons

import android.annotation.SuppressLint
import com.example.pokemonhandbook.utils.url2ImageView

class PokemonViewHolderSetter(private val vh: PokemonViewHolder) {
    fun setFieldName(it: String): PokemonViewHolderSetter {
        vh.fieldName.text = it
        return this
    }

    @SuppressLint("SetTextI18n")
    fun setFieldWeight(it: Int): PokemonViewHolderSetter {
        vh.fieldWeight.text = "weight: $it"
        return this
    }

    @SuppressLint("SetTextI18n")
    fun setFieldHeight(it: Int): PokemonViewHolderSetter {
        vh.fieldHeight.text = "height: $it"
        return this
    }

    fun setFieldImage(it: String): PokemonViewHolderSetter {
        url2ImageView(vh.context, it, vh.fieldImage)

        return this
    }

    fun setClickListener(listener: () -> Unit): PokemonViewHolderSetter {
        vh.itemView.setOnClickListener { listener() }
        return this
    }
}