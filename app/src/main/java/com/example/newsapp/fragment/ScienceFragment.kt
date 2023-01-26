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
import kotlinx.android.synthetic.main.fragment_science.*

class ScienceFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val newsRepository = NewsRepository()
        newsRepository.getNewsApi("science") { newsList ->
            Log.d("logs", "science called")
            recyclerView.adapter = NewsAdapter(requireContext(), newsList)
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_science, container, false)
    }

}