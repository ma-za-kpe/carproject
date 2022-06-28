package com.ryggs.cars.core.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.ryggs.cars.R
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

inline fun CoroutineScope.createExceptionHandler(
    message: String,
    crossinline action: (throwable: Throwable) -> Unit,
) = CoroutineExceptionHandler { _, throwable ->
    throwable.printStackTrace()
    launch {
        action(throwable)
    }
}

fun ImageView.setImage(url: String) {
    Glide.with(this.context)
        .load(url.ifEmpty { null })
        .error(R.drawable.placeholder)
        .centerCrop()
        .into(this)
}