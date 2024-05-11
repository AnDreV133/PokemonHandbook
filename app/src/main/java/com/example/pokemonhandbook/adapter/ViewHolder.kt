package com.example.pokemonhandbook.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonhandbook.DetailActivity
import com.example.pokemonhandbook.R

open class ViewHolder(
    itemView: CardView,
    val context: Context
) : RecyclerView.ViewHolder(itemView) {
    private val TAG = "MyViewHolder"
    val fieldName: TextView
    val fieldWeight: TextView
    val fieldHeight: TextView
    val fieldImage: ImageView

    init {
        fieldName = itemView.findViewById(R.id.fieldName)
        fieldWeight = itemView.findViewById(R.id.fieldWeight)
        fieldHeight = itemView.findViewById(R.id.fieldHeight)
        fieldImage = itemView.findViewById(R.id.fieldImage)
    }
}