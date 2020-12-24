package com.example.notes_with_a_smile.Helper

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(url: String) {
    Glide
            .with(this.context)
            .load(url)
            .centerCrop()
            .into(this)
}
