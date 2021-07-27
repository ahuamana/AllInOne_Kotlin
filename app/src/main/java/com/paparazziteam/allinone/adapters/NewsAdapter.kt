package com.paparazziteam.allinone.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.paparazziteam.allinone.databinding.CardviewNewsBinding
import com.paparazziteam.allinone.models.NewsItem
import com.paparazziteam.allinone.viewModels.NewsItemViewModel

class NewsAdapter (private val newsList: List<NewsItem>) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = CardviewNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)

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
            binding.viewModel = NewsItemViewModel()
        }

        fun bind(newsItem: NewsItem){
            binding.apply {
                viewModel?.setNewsItem(newsItem)
                executePendingBindings()
            }
        }
    }

}