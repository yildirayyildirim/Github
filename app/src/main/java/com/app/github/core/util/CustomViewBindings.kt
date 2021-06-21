package com.app.github.core.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class CustomViewBindings {
    companion object {

        @BindingAdapter("app:imagePath")
        @JvmStatic
        fun imagePath(view: ImageView, imageUrl: String?) {
            var requestOption = RequestOptions()
            requestOption = requestOption.transforms(RoundedCorners(15))
            imageUrl?.apply {
                Glide.with(view.context).load(this).apply(requestOption).into(view)
            }
        }
    }
}