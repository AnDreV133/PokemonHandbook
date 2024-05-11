package com.example.pokemonhandbook.adapter.pokemons

import android.content.Context
import android.content.Intent
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonhandbook.DetailActivity
import com.example.pokemonhandbook.R
import com.example.pokemonhandbook.api.model.Pokemon
import kotlinx.coroutines.Job

open class PokemonViewHolder(
    itemView: CardView,
    val context: Context
) : RecyclerView.ViewHolder(itemView) {
    val fieldName: TextView = itemView.findViewById(R.id.fieldName)
    val fieldWeight: TextView = itemView.findViewById(R.id.fieldWeight)
    val fieldHeight: TextView = itemView.findViewById(R.id.fieldHeight)
    val fieldImage: ImageView = itemView.findViewById(R.id.fieldImage)

    fun bind(pokemon: Pokemon, job: Job? = null) {
        PokemonViewHolderSetter(this)
            .setFieldName(pokemon.name)
            .setFieldWeight(pokemon.weight)
            .setFieldHeight(pokemon.height)
            .setFieldImage(pokemon.sprites.frontDefault)
            .setClickListener {
                job?.cancel()
                context.startActivity(
                    Intent(context, DetailActivity::class.java)
                        .putExtra("pokemon", pokemon)
                )
            }
    }
}