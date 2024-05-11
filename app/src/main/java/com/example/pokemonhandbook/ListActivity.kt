package com.example.pokemonhandbook;

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.pokemonhandbook.adapter.pokemons.PokemonsAdapter
import com.example.pokemonhandbook.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {
    private val TAG = "MyListActivity"
    private lateinit var binding: ActivityListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fieldPokemonList.adapter = PokemonsAdapter(this)

        Log.d(TAG, "onCreate")
    }
}