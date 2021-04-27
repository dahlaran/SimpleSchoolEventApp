package com.dahlaran.simpleschooleventapp.views.extensions

import android.util.Log
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import com.dahlaran.simpleschooleventapp.R
import com.dahlaran.simpleschooleventapp.models.Media
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import org.json.JSONObject


@BindingAdapter("app:imageInsideMedia")
fun loadImageInsideMedia(imageView: ImageView, mediaList: List<String>?) {
    if (mediaList?.isEmpty() == false) {
        imageView.loadUrl(
            Media.fromJson(JSONObject(mediaList[0])).url,
            R.drawable.placeholder_image
        )
    } else {
        imageView.setImageResource(R.drawable.placeholder_image)
    }
}

fun ImageView.loadUrl(url: String?, @DrawableRes placeholderId: Int = 0) {
    Picasso.with(context).load(url).error(placeholderId).placeholder(placeholderId).into(this,
        object : Callback {
            override fun onSuccess() {
                Log.d("Picasso Image Loading", "Picasso Image Loading succeeded")
            }

            override fun onError() {
                Log.d("Picasso Image Loading", "Picasso Image Loading failed")
            }

        })
}
