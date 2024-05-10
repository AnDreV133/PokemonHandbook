package com.example.pokemonhandbook;

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.pokemonhandbook.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {
    private val TAG = "MyListActivity"
    private lateinit var binding: ActivityListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ListAdapter(arrayListOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"))
        binding.recyclerView.adapter = adapter
        Log.d(TAG, "onCreate")
    }
}