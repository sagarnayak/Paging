package com.sagar.android.paging.ui.mainactivity.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sagar.android.paging.databinding.NewsListItemBinding
import com.sagar.android.paging.model.News

class NewsAdapter(private val newsList: MutableList<News>) :
    PagedListAdapter<News, NewsAdapter.ViewHolder>(
        object : DiffUtil.ItemCallback<News>() {
            override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
                return oldItem.title == newItem.title
            }
        }
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            NewsListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(newsList[position])
    }


    inner class ViewHolder(private val newsListItemBinding: NewsListItemBinding) :
        RecyclerView.ViewHolder(newsListItemBinding.root) {

        fun bind(news: News) {
            newsListItemBinding.textView.text = news.title
        }
    }
}