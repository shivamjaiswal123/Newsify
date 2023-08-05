package com.example.newsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.model.News
import com.example.newsapp.data.repository.INewsRepository
import com.example.newsapp.utills.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val newsRepository: INewsRepository): ViewModel() {
    private var _articles = MutableLiveData<Response<News>>()
    val article: LiveData<Response<News>> get() = _articles

    fun getNews(cat: String){
        _articles.value = Response.Loading()
        viewModelScope.launch {
            newsRepository.getNews(cat).let {
                _articles.postValue(it)
            }
        }
    }
}