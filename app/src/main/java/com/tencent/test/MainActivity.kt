package com.tencent.test

import android.content.Context
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
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
        for (i in 1..5){
            var rect = SquareRect()
            rect.title.set("美股快迭")
            rect.image.set("https://y.gtimg.cn/music/common/upload/t_movie_h5/260358.jpg")
            datas.add(rect)
        }
        for (i in 1..5){
            var rect = HorizontalRect()
            rect.title.set("美股快迭")
            rect.image.set("https://y.gtimg.cn/music/common/upload/t_movie_h5/259169.jpg")
            datas.add(rect)
        }
        recycler_view.adapter = TvAdapter(this,datas)
    }

    private class TvAdapter(context : Context,val data : ArrayList<BaseRect>) : BaseTvAdapter(context){
        override fun getLayoutIdForPosition(position: Int): Int {
            return data[position].getLayoutId()
        }

        override fun getItemForPosition(position : Int) : BaseRect{
            return data[position]
        }

        override fun getItemCount(): Int {
             return data.size
        }
    }

}
