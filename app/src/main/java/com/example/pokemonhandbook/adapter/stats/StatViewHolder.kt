package com.example.pokemonhandbook.adapter.stats

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonhandbook.R

class StatViewHolder(
    itemView: View,
) : RecyclerView.ViewHolder(itemView) {
    val fieldStatDetail: TextView = itemView.findViewById(R.id.fieldStatDetail)
    val fieldStatValueDetail: TextView = itemView.findViewById(R.id.fieldStatValueDetail)
}