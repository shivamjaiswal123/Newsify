package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.newsapp.adapter.NewsAdapter
import com.example.newsapp.adapter.ViewPagerAdapter
import com.example.newsapp.model.News
import com.example.newsapp.network.RetrofitHelper
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_general.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //set the swipe-able tab layout
        setTab()
    }

    private fun setTab() {
        val tablayout = findViewById<TabLayout>(R.id.tab_layout)
        val viewPager = findViewById<ViewPager2>(R.id.view_pager)

        viewPager.adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        TabLayoutMediator(tablayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Home"
                1 -> tab.text = "Sport"
                2 -> tab.text = "Science"
                3 -> tab.text = "Technology"
                4 -> tab.text = "Entertainment"
                5 -> tab.text = "Business"
            }
        }.attach()
    }
}