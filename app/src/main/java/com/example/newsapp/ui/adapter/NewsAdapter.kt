package com.example.newsapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.R
import com.example.newsapp.data.model.Article
import com.example.newsapp.databinding.ItemLayoutBinding

class NewsAdapter(private val onItemClick: (Article) -> Unit) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private var articlesList: List<Article> = listOf()      // Initial empty list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = articlesList[position]
        holder.bind(article)
    }

    override fun getItemCount(): Int {
        return articlesList.size
    }

    inner class ViewHolder(private val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article){
            binding.apply {
                newsTitle.text = article.title
                newsDescription.text = article.description
                Glide.with(binding.root).load(article.urlToImage).into(newsImage)

                root.setOnClickListener {
                    onItemClick(article)
                }
            }

        }
    }

    fun setData(data: List<Article>) {
        articlesList = data
        notifyDataSetChanged()
    }
}