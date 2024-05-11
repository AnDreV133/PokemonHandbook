package com.example.pokemonhandbook.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.pokemonhandbook.R

fun url2ImageView(context: Context, url: String?, imageView: ImageView) {
    if (url != null)
        Glide.with(context)
            .load(url)
            .placeholder(R.drawable.ph_detail_image_view)
            .into(imageView)
}