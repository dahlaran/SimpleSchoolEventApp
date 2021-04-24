package com.dahlaran.simpleschooleventapp.views.extensions

import android.media.Image
import android.util.Log
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import com.dahlaran.simpleschooleventapp.R
import javax.security.auth.callback.Callback

/*
@BindingAdapter("app:imageUrl")
fun loadImageWithUrl(imageView: ImageView, image: Image?) {
    image?.original?.let {
        if (it.trim().isNotEmpty()) {
            imageView.loadUrl(it, R.drawable.ic_placeholder)
        } else {
            imageView.setImageResource(R.drawable.ic_placeholder)
        }
    }
}

fun ImageView.loadUrl(url: String?, @DrawableRes placeholderId: Int = 0) {
    if (placeholderId != 0) {
        Picasso.with(context).load(url).error(placeholderId).placeholder(placeholderId).into(this,
            object : Callback {
                override fun onSuccess() {
                    Log.d("Picasso Image Loading", "Picasso Image Loading succeeded")
                }

                override fun onError() {
                    Log.d("Picasso Image Loading", "Picasso Image Loading failed")
                }

            })
    } else {
        Picasso.with(context).load(url).into(this)
    }
}*/
