package com.tencent.test

import android.content.Context
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.ViewGroup
import com.tencent.test.rect.databinding.SquareBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        initLayoutManager()

    }

    private fun initLayoutManager(){
        recycler_view.layoutManager = StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL)
        var datas = ArrayList<BaseRect>()
        for (i in 1..10){
            var rect = SquareRect()
            rect.title.set("美股快迭")
            datas.add(rect)
        }
        recycler_view.adapter = TvAdapter(this,datas)
    }

    private class TvAdapter(context : Context,val data : ArrayList<BaseRect>) : RecyclerView.Adapter<TvViewHolder>(){
        var layoutInflater = LayoutInflater.from(context)

        override fun onBindViewHolder(holder: TvViewHolder?, position: Int) {
            if (position < itemCount)holder?.bind(getItemForPosition(position))

        }

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TvViewHolder {
            return TvViewHolder(SquareBinding.inflate(layoutInflater,parent,false))
        }

        override fun getItemCount(): Int {
             return data.size
        }

        private fun getItemForPosition(position : Int) : BaseRect{
            return data[position]
        }

    }

}
