package com.example.pokemonhandbook.adapter.pokemons

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonhandbook.R
import com.example.pokemonhandbook.api.PokemonApiHandler
import com.example.pokemonhandbook.api.model.Pokemon
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException

class PokemonsAdapter(private val context: AppCompatActivity) :
    RecyclerView.Adapter<PokemonViewHolder>() {
    private val TAG = "MyListAdapter"
    private val NUM_OF_LOADING_ITEM = 25
    private val NUM_OF_ITEM_BEFORE_WHICH_HAPPEN_LOADING = 10
    private val MAX_NUM_OF_ITEM_IF_TOTAL_AMOUNT_NOT_LOADED = 100
    private var cachedPokemons: MutableList<Pokemon?> = mutableListOf()
    private val totalNumOfPokemons = getTotalCount()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder =
        PokemonViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list, parent, false) as CardView, context
        )

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        if (position >= getItemCount() - NUM_OF_ITEM_BEFORE_WHICH_HAPPEN_LOADING) {
            loadMore()
        }

        if (cachedPokemons[position] != null) {
            holder.bind(cachedPokemons[position]!!)
            return
        }

        Log.d(TAG, "Start init item by position: $position")
        CoroutineScope(Dispatchers.Default).launch {
            val resp = try {
                PokemonApiHandler.get(position + 1)
            } catch (e: IOException) {
                Log.e(TAG, "Not connected to API")
                return@launch
            }

            if (!resp.isSuccessful) {
                Log.e(TAG, "API returned error code by ID ${position + 1}: ${resp.code()}")
                return@launch
            }

            if (resp.body() == null) {
                Log.e(TAG, "Returned object from API by ID ${position + 1} is null")
                return@launch
            }

            val elem: Pokemon = resp.body()!!
            cachedPokemons[position] = elem
            withContext(Dispatchers.Main) { launch { holder.bind(elem) } }
            Log.d(TAG, "Item initialised by position: $position")
        }
    }

    override fun getItemCount(): Int {
        if (cachedPokemons.size == 0) loadMore()
        return cachedPokemons.size
    }

    private fun loadMore() {
        val buf: List<Pokemon?> = mutableListOf<Pokemon?>().apply {
            var count = 0
            while (
                count < NUM_OF_LOADING_ITEM && cachedPokemons.size
                < (totalNumOfPokemons ?: MAX_NUM_OF_ITEM_IF_TOTAL_AMOUNT_NOT_LOADED)
            ) {
                add(null)
                count++
            }
        }

        cachedPokemons.addAll(buf)
    }

    private fun getTotalCount(): Int? {
        var count: Int? = null
        CoroutineScope(Dispatchers.Default).launch {
            count = async { PokemonApiHandler.getCount().body()?.count }.await()
        }

        return count
    }
}