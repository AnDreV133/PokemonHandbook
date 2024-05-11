package com.example.pokemonhandbook.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Callback
import com.example.pokemonhandbook.R
import com.example.pokemonhandbook.api.PokemonApiHandler
import com.example.pokemonhandbook.api.model.Pokemon
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Response
import retrofit2.awaitResponse

class ListAdapter(val context: Context) :
    RecyclerView.Adapter<ViewHolder>() {
    private val TAG = "MyListAdapter"
    var size: Int = 15
    var cachedPokemons: MutableList<Pokemon> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.recycler_view_item, parent, false) as CardView,
            context
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        runBlocking {
            launch {
                val resp = PokemonApiHandler.get(position + 1)
//                if (!resp.isSuccessful) {}

                if (resp.isSuccessful && resp.body() != null) {
                    val elem: Pokemon = resp.body()!!
                    ViewHolderSetter(holder)
                        .setFieldName(elem.name)
                        .setFieldWeight(elem.weight)
                        .setFieldHeight(elem.height)
                        .setFieldImage(elem.sprites.frontDefault)


                    Log.d(TAG, "returned object from execute to API:\n$elem")
                } else {
                    Log.e(TAG, "failed to execute to API")
                }

            }
        }

        if (position == size - 6) {
            size += 10
        }

        Log.d(TAG, "position: $position")
    }

    override fun getItemCount() = size
}




