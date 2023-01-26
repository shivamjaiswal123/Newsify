package com.example.newsapp.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.NewsActivity
import com.example.newsapp.R
import com.example.newsapp.model.Article
import kotlinx.android.synthetic.main.item_layout.view.*

class NewsAdapter(val context: Context, val articles: List<Article>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = articles[position].title
        holder.des.text = articles[position].description
        Glide.with(context).load(articles[position].urlToImage).into(holder.image)
        holder.itemView.setOnClickListener {
            val intent = Intent(context, NewsActivity::class.java)
            intent.putExtra("URL", articles[position].url)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.news_image
        val title = itemView.news_title
        val des = itemView.news_description
    }
}