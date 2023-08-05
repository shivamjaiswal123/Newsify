package com.example.newsapp.data.repository

import com.example.newsapp.data.model.News
import com.example.newsapp.utills.Response


interface INewsRepository {
    suspend fun getNews(cat: String): Response<News>
}