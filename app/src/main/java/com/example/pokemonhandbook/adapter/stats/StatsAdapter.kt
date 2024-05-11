package com.example.pokemonhandbook.adapter.stats

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonhandbook.R
import com.example.pokemonhandbook.api.model.Stat

class StatsAdapter(private val dataSet: List<Stat>) : RecyclerView.Adapter<StatViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        StatViewHolder(LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_stat_detail, parent, false)
        )
    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: StatViewHolder, position: Int) {
        holder.fieldStatDetail.text = dataSet[position].stat.name
        holder.fieldStatValueDetail.text = dataSet[position].baseStat.toString()
    }
}