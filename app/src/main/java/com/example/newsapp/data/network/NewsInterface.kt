package com.example.newsapp.data.network

import com.example.newsapp.data.model.News
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

const val API = "081085a5ca9e42d88b110d7bdc05d6e6"
interface NewsInterface {
    @GET("/v2/top-headlines?apiKey=$API")
    fun getTopHeadlines(@Query("country")country: String, @Query("page")page: Int): Response<News>

    @GET("/v2/top-headlines?apiKey=$API")
    suspend fun getTopHeadlines(@Query("country")country: String, @Query("category")category: String, @Query("page")page: Int): Response<News>
}

//https://newsapi.org/v2/top-headlines?apiKey=081085a5ca9e42d88b110d7bdc05d6e6&country=us&page=1

//https://newsapi.org/v2/top-headlines?apiKey=081085a5ca9e42d88b110d7bdc05d6e6&country=in&category=entertainment&page=1