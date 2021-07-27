package com.paparazziteam.allinone.viewModels

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.paparazziteam.allinone.models.NewsItem

class NewsItemViewModel (context: Context) {

    private val _newsItem = MutableLiveData<NewsItem>()
    val newsItem: LiveData<NewsItem> = _newsItem

    private val _context = context;

    private val _btnMoreInfo = MutableLiveData<String>()
    val btnMoreInfo: LiveData<String> = _btnMoreInfo


    fun setNewsItem(value: NewsItem)
    {
        _newsItem.value = value
    }


    fun addOnClickMoreInfo()
    {
       Toast.makeText(_context,"Pronto Implementaremos mas funcionalidades!",Toast.LENGTH_SHORT).show()
       Log.e("BUTTOM","BUTTOM: Hiciste click");
    }
}
