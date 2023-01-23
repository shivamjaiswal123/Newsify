package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.adapter.NewsAdapter
import com.example.newsapp.model.News
import com.example.newsapp.network.RetrofitHelper
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var adapter: NewsAdapter
    lateinit var layoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getNews()
    }

    private fun getNews() {
        val news = RetrofitHelper.service.getTopHeadlines("in", 1)
        news.enqueue(object : Callback<News?> {
            override fun onResponse(call: Call<News?>, response: Response<News?>) {
                //val news = response.body()                  news is of News data class
                val news = response.body()?.articles         //news is of Article data class coz accessing articles
                if (news != null) {
                    Log.d("LOL", news.toString())
                    adapter = NewsAdapter(this@MainActivity, news)
                    recyclerView.adapter = adapter
                    layoutManager = LinearLayoutManager(this@MainActivity)
                    recyclerView.layoutManager = layoutManager
                }
            }

            override fun onFailure(call: Call<News?>, t: Throwable) {
                Log.d("error", "onFailure:Error in fetching the news")
            }
        })
    }
}