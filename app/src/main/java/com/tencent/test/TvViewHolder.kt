package com.tencent.test

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

/**
 * Created by Greyzhou on 2018/6/8.
 */
class TvViewHolder (private val binding: ViewDataBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(item : Any) {
        binding.setVariable(BR.item,item)
        binding.executePendingBindings()
    }
}