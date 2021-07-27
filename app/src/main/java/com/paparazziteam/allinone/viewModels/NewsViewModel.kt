package com.paparazziteam.allinone.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.paparazziteam.allinone.models.NewsData
import com.paparazziteam.allinone.models.NewsItem
import com.paparazziteam.allinone.services.NewsService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsViewModel : ViewModel() {
    //It's constantly called when the data model changes
    private val _newsList = MutableLiveData<List<NewsItem>>()
    val newsList: LiveData<List<NewsItem>> =_newsList

    init {
        getNewsSources()
    }

    private fun getNewsSources() {
        Log.e("Codigo ", "inicial")
        val retrofit = Retrofit.Builder()
            .baseUrl("http://api.mediastack.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //call interface
        val service = retrofit.create(NewsService::class.java)
        val call: Call<NewsData> = service.getNewsData()

        //Ejecutar
        call.enqueue(object : Callback<NewsData> {
            override fun onResponse(call: Call<NewsData>, response: Response<NewsData>) {
                if (response.isSuccessful) {
                    Log.e("Codigo ", "" + response.code())
                    val news = response.body()
                    _newsList.value = news?.items
                    return
                }
            }
            override fun onFailure(call: Call<NewsData>, t: Throwable) {
                Log.e("Error ", t.message!!)
            }
        })


    }

}