package com.tencent.test

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by Greyzhou on 2018/6/28.
 */
@BindingAdapter("app:imageUrl")
fun loadImage(imageView : ImageView,url : String){
    Glide.with(imageView.context)
            .load(url)
            .into(imageView)
}