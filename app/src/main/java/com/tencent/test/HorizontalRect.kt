package com.tencent.test

import android.databinding.ObservableField

/**
 * Created by Greyzhou on 2018/6/29.
 */
class HorizontalRect : BaseRect(R.layout.layout_horizontal_rect){
    val title = ObservableField<String>()
    val image = ObservableField<String>()
    fun onClick(rect: HorizontalRect) {
        title.set("厉害厉害")
    }
}