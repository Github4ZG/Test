package com.tencent.test

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by Greyzhou on 2018/6/29.
 */
open abstract class BaseTvAdapter(context : Context) : RecyclerView.Adapter<TvViewHolder>(){
    private val layoutInflater = LayoutInflater.from(context)

    override fun onBindViewHolder(holder: TvViewHolder?, position: Int) {
        holder?.bind(getItemForPosition(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TvViewHolder {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(layoutInflater,viewType,parent,false)
        return TvViewHolder(binding)
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    abstract fun getItemForPosition(position:Int) : Any

    abstract fun getLayoutIdForPosition(position: Int) : Int

}