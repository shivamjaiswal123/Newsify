package com.example.newsapp.data.repository

import android.util.Log
import com.example.newsapp.data.model.Article
import com.example.newsapp.data.network.RetrofitHelper


class NewsRepository {
    companion object {
        suspend fun getNewsFromApi(cat: String): List<Article>? {
            val response = RetrofitHelper.service.getTopHeadlines("in", cat, 1)
            if (response.isSuccessful) {
                return response.body()?.articles
            }
            return null
        }
    }
}