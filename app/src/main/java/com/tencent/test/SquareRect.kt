package com.tencent.test

import android.databinding.ObservableField

/**
 * Created by Greyzhou on 2018/6/29.
 */
class SquareRect : BaseRect(R.layout.layout_square_rect){
    val title = ObservableField<String>()
    val image = ObservableField<String>()
    fun onClick(rect: SquareRect) {
        title.set("厉害厉害")
    }
}