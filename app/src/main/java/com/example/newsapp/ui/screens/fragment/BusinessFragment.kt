package com.example.newsapp.ui.screens.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.databinding.FragmentBusinessBinding
import com.example.newsapp.ui.adapter.NewsAdapter
import com.example.newsapp.ui.screens.activity.NewsActivity
import com.example.newsapp.utills.Response
import com.example.newsapp.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BusinessFragment : Fragment() {
    lateinit var binding: FragmentBusinessBinding
    lateinit var viewModel: MainViewModel
    private lateinit var adapter: NewsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBusinessBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        setupRecyclerView()

        viewModel.article.observe(viewLifecycleOwner, Observer {
            binding.progressBar.isVisible = false
            when (it) {
                is Response.Success -> {
                    adapter.setData(it.data?.articles!!)
                }

                is Response.Error -> {
                    Toast.makeText(requireContext(), it.errorMsg.toString(), Toast.LENGTH_SHORT)
                        .show()
                }

                is Response.Loading -> {
                    binding.progressBar.isVisible = true
                }
            }
        })
        viewModel.getNews("business")

        return binding.root
    }

    private fun setupRecyclerView() {
        adapter = NewsAdapter {
            val intent = Intent(requireContext(), NewsActivity::class.java)
            intent.putExtra("URL", it.url)
            this.startActivity(intent)
        }                         //initialize adapter
        binding.recyclerView.adapter = adapter          //set adapter to recyclerview
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }
}