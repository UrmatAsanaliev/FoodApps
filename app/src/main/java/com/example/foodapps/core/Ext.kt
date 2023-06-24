package com.example.foodapps.core

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.isVisible
import com.bumptech.glide.Glide

fun ImageView.loadImage(img: String) {
    Glide.with(this).load(img).into(this)
}

fun Context.showToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun View.visible() {
    this.isVisible = true
}

fun View.gone() {
    this.isVisible = false
}