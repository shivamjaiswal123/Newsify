package com.example.newsapp.network

import android.util.Log
import com.example.newsapp.model.Article
import com.example.newsapp.model.News
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.reflect.KFunction0

class NewsRepository {
    fun getNewsApi(cat: String, callback: (List<Article>) -> Unit) {
        var newsList = mutableListOf<Article>()
        val news = RetrofitHelper.service.getTopHeadlines("in", cat, 1)

        news.enqueue(object : Callback<News?> {
            override fun onResponse(call: Call<News?>, response: Response<News?>) {
                val news = response.body()?.articles
                if (news != null) {
                    news.forEach {
                        if (it.author != null) {
                            newsList.add(it)
                        }
                    }
                    callback(newsList)
                }
            }

            override fun onFailure(call: Call<News?>, t: Throwable) {
                Log.d("error", "onFailure:Error in fetching the news")
            }
        })
    }
}