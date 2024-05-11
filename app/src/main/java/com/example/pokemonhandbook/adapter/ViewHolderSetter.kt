package com.example.pokemonhandbook.adapter

import com.bumptech.glide.Glide
import com.example.pokemonhandbook.R

class ViewHolderSetter(private val vh: ViewHolder) {
    fun setFieldName(it: String): ViewHolderSetter {
        vh.fieldName.text = it
        return this
    }
    fun setFieldWeight(it: Int): ViewHolderSetter {
        vh.fieldWeight.text = it.toString()
        return this
    }
    fun setFieldHeight(it: Int): ViewHolderSetter {
        vh.fieldHeight.text = it.toString()
        return this
    }
    fun setFieldImage(it: String): ViewHolderSetter {
        Glide.with(vh.context)
            .load("url here") 
            .placeholder(R.drawable.ph_detail_image_view)
            .into(vh.fieldImage) // todo make async
        return this
    }
}