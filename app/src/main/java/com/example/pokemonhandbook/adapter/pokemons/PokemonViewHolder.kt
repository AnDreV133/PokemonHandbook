package com.example.pokemonhandbook.adapter.pokemons

import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonhandbook.R

open class PokemonViewHolder(
    itemView: CardView,
    val context: Context
) : RecyclerView.ViewHolder(itemView) {
    val fieldName: TextView = itemView.findViewById(R.id.fieldName)
    val fieldWeight: TextView = itemView.findViewById(R.id.fieldWeight)
    val fieldHeight: TextView = itemView.findViewById(R.id.fieldHeight)
    val fieldImage: ImageView = itemView.findViewById(R.id.fieldImage)
}