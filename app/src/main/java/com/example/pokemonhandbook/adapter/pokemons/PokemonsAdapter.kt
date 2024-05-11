package com.example.pokemonhandbook.adapter.pokemons

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonhandbook.DetailActivity
import com.example.pokemonhandbook.R
import com.example.pokemonhandbook.api.PokemonApiHandler
import com.example.pokemonhandbook.api.model.Pokemon
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.HttpException

class PokemonsAdapter(private val context: AppCompatActivity) : RecyclerView.Adapter<PokemonViewHolder>() {
    private val TAG = "MyListAdapter"
    private val NUM_OF_LOAD_ITEM = 25
    private val STOCK_FOR_LOAD = 10
    private var cachedPokemons: MutableList<Pokemon> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder = PokemonViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false) as CardView, context
    )

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        if (position >= cachedPokemons.size - STOCK_FOR_LOAD) {
            loadMore()
        }

        cachedPokemons[position].run {
            PokemonViewHolderSetter(holder)
                .setFieldName(name)
                .setFieldWeight(weight)
                .setFieldHeight(height)
                .setFieldImage(sprites.frontDefault)
                .setClickListener {
                    context.startActivity(
                        Intent(context, DetailActivity::class.java)
                            .putExtra("pokemon", this)
                    )
                }
        }

        Log.d(TAG, "position: $position")
    }

    override fun getItemCount(): Int {
        if (cachedPokemons.size == 0) loadMore()
        return cachedPokemons.size
    }

    private fun loadMore() {
        val buf: MutableList<Pokemon> = mutableListOf()
        try {
            runBlocking {
                for (i in cachedPokemons.size + 1 until cachedPokemons.size + 1 + NUM_OF_LOAD_ITEM) {
                    launch {
                        val resp = PokemonApiHandler.get(i)
                        if (!resp.isSuccessful) {
                            Log.e(TAG, "API returned error code by ID $i: ${resp.code()}")
                            throw HttpException(resp)
                        }

                        if (resp.body() == null) {
                            Log.e(TAG, "Returned object from API by ID $i is null")
                            throw HttpException(resp)
                        }

                        val elem: Pokemon = resp.body()!!
                        buf.add(elem)

                        Log.d(TAG, "Returned object from execute to API by ID $i:\n$elem")
                    }
                }
            }

            cachedPokemons.addAll(buf)
        } catch (e: Exception) {
            Log.e(TAG, "Exception occurred when loading more Pokemon: ${e.message}")
        }
    }
}




