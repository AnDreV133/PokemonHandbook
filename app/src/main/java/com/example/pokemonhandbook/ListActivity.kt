package com.example.pokemonhandbook;

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.pokemonhandbook.adapter.ListAdapter
import com.example.pokemonhandbook.api.PokemonApiHandler
import com.example.pokemonhandbook.databinding.ActivityListBinding
import kotlinx.coroutines.runBlocking
import retrofit2.HttpException

class ListActivity : AppCompatActivity() {
    private val TAG = "MyListActivity"
    private lateinit var binding: ActivityListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

            binding.recyclerView.adapter = ListAdapter(this)


        Log.d(TAG, "onCreate")
    }
}