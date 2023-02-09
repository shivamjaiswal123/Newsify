package com.example.newsapp.network

import android.util.Log
import com.example.newsapp.model.Article


class NewsRepository {
     suspend fun getNewsFromApi(cat: String): List<Article> {
        val news = RetrofitHelper.service.getTopHeadlines("in", cat, 1)
        val articles = mutableListOf<Article>()
        if(news.isSuccessful){
            val body = news.body()?.articles
            if (body != null) {
                //not adding articles which has no author/image/description
                body.forEach {
                    if(it.author != null && it.urlToImage != null){
                        articles.add(it)
                    }
                }
            }else{
                Log.d("Error", "API call failed")
            }
        }
        return articles
    }
}