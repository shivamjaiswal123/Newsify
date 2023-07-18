package com.example.newsapp.ui.screens.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.databinding.FragmentBusinessBinding
import com.example.newsapp.ui.adapter.NewsAdapter
import com.example.newsapp.ui.screens.activity.NewsActivity
import com.example.newsapp.viewmodel.MainViewModel


class BusinessFragment : Fragment() {
    lateinit var binding: FragmentBusinessBinding
    lateinit var viewModel: MainViewModel
    lateinit var adapter: NewsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBusinessBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        setupRecyclerView()

        viewModel.article.observe(viewLifecycleOwner, Observer {
            adapter.setData(it)
        })
        viewModel.getNews("business")

        return binding.root
    }

    private fun setupRecyclerView() {
        adapter = NewsAdapter{
            val intent = Intent(requireContext(), NewsActivity::class.java)
            intent.putExtra("URL", it.url)
            this.startActivity(intent)
        }                         //initialize adapter
        binding.recyclerView.adapter = adapter          //set adapter to recyclerview
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }
}