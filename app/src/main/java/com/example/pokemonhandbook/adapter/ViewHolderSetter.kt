package com.example.pokemonhandbook.adapter

import android.annotation.SuppressLint
import com.bumptech.glide.Glide
import com.example.pokemonhandbook.R

class ViewHolderSetter(private val vh: ViewHolder) {
    fun setFieldName(it: String): ViewHolderSetter {
        vh.fieldName.text = it
        return this
    }

    @SuppressLint("SetTextI18n")
    fun setFieldWeight(it: Int): ViewHolderSetter {
        vh.fieldWeight.text = "weight - $it"
        return this
    }

    @SuppressLint("SetTextI18n")
    fun setFieldHeight(it: Int): ViewHolderSetter {
        vh.fieldHeight.text = "height - $it"
        return this
    }

    fun setFieldImage(it: String): ViewHolderSetter {
        Glide.with(vh.context)
            .load(it)
            .placeholder(R.drawable.ph_detail_image_view)
            .into(vh.fieldImage) // todo make async
        return this
    }

    fun setClickListener(listener: () -> Unit): ViewHolderSetter {
        vh.itemView.setOnClickListener {
            listener()
        }
        return this
    }
}