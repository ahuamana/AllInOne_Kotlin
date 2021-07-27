package com.paparazziteam.allinone.adapters


import android.content.Context
import android.provider.Settings.Global.getString
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.paparazziteam.allinone.databinding.CardviewNewsBinding
import com.paparazziteam.allinone.models.NewsItem
import com.paparazziteam.allinone.viewModels.NewsItemViewModel

class NewsAdapter (private val newsList: List<NewsItem>) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>(){

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = CardviewNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        context = parent.context

        return NewsViewHolder(binding)

    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val newsItem = newsList[position]
        holder.bind(newsItem)

    }

    override fun getItemCount() = newsList.size

    override fun getItemViewType(position: Int) = position


    inner class NewsViewHolder(private  val binding: CardviewNewsBinding) : RecyclerView.ViewHolder(binding.root)
    {
        init {
            binding.viewModel = NewsItemViewModel(context)
        }

        fun bind(newsItem: NewsItem){
            binding.apply {
                viewModel?.setNewsItem(newsItem)

                executePendingBindings()
            }
        }

    }




}