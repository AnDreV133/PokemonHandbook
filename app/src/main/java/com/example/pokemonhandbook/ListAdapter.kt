package com.example.pokemonhandbook

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val dataSet: List<String>) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    private val TAG = "MyListAdapter"
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fieldName: TextView = itemView.findViewById(R.id.fieldName)
        val fieldWeight: TextView = itemView.findViewById(R.id.fieldWeight)
        val fieldHeight: TextView = itemView.findViewById(R.id.fieldHeight)
        val fieldImage: ImageView = itemView.findViewById(R.id.fieldImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.recycler_view_item, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG, "position: $position")
    }

    override fun getItemCount() = dataSet.size
}

