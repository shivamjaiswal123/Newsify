package com.example.newsapp.data.repository


import com.example.newsapp.data.model.News
import com.example.newsapp.data.network.NewsInterface
import com.example.newsapp.utills.Response
import javax.inject.Inject


class NewsRepository @Inject constructor(private val newsApi: NewsInterface) : INewsRepository {
    override suspend fun getNews(cat: String): Response<News> {
        return try {
            val response = newsApi.getTopHeadlines("in", cat, 1)
            if (response.isSuccessful && response.body() != null) {
                Response.Success(response.body()!!)
            } else {
                Response.Error(response.message() ?: "Something went wrong !!")
            }
        } catch (e: Exception) {
            Response.Error("An error occurred: ${e.message}")
        }
    }
}