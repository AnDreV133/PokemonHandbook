package com.example.pokemonhandbook;

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pokemonhandbook.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {
    private val TAG = "MyDetailActivity"
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}