package com.paparazziteam.allinone.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.paparazziteam.allinone.models.NewsItem

class NewsItemViewModel {

    private val _newsItem = MutableLiveData<NewsItem>()
    val newsItem: LiveData<NewsItem> = _newsItem

    fun setNewsItem(value: NewsItem)
    {
        _newsItem.value = value
    }
}