package com.example.newsapp.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.R
import com.example.newsapp.adapter.NewsAdapter
import com.example.newsapp.network.NewsRepository
import kotlinx.android.synthetic.main.fragment_general.*
import kotlinx.android.synthetic.main.fragment_tech.*
import kotlinx.android.synthetic.main.fragment_tech.recyclerView
import kotlinx.coroutines.*


class TechFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val newsRepository = NewsRepository()
        CoroutineScope(Dispatchers.IO).launch {
            val news = async(Dispatchers.IO) { newsRepository.getNewsFromApi("technology") }
            withContext(Dispatchers.Main){
                recyclerView.layoutManager = LinearLayoutManager(requireContext())
                recyclerView.adapter = NewsAdapter(requireContext(), news.await())
            }
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tech, container, false)
    }
}