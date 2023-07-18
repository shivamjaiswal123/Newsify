package com.example.newsapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.data.model.Article
import com.example.newsapp.data.repository.NewsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private var _articles = MutableLiveData<List<Article>>()
    val article: LiveData<List<Article>> get() = _articles

    fun getNews(cat: String){
        CoroutineScope(Dispatchers.IO).launch {
            NewsRepository.getNewsFromApi(cat)?.let {
                _articles.postValue(it)
            }
        }
    }
}