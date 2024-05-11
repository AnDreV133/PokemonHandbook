package com.example.pokemonhandbook;

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.pokemonhandbook.adapter.stats.StatsAdapter
import com.example.pokemonhandbook.api.model.Pokemon
import com.example.pokemonhandbook.databinding.ActivityDetailBinding
import com.example.pokemonhandbook.utils.url2ImageView


class DetailActivity : Activity() {
    private val TAG = "MyDetailActivity"
    private lateinit var binding: ActivityDetailBinding

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pokemonFromExtra: Pokemon = intent.extras?.getSerializable("pokemon", Pokemon::class.java)!!
        binding.let {
            url2ImageView(this, pokemonFromExtra.sprites.frontDefault, it.fieldImageDetail)

            it.fieldNameDetail.text = "name: ${pokemonFromExtra.name}"
            it.fieldHeightDetail.text = "height: ${pokemonFromExtra.height}"
            it.fieldWeightDetail.text = "weight: ${pokemonFromExtra.weight}"
            it.fieldStatList.adapter = StatsAdapter(pokemonFromExtra.stats)
        }
    }
}