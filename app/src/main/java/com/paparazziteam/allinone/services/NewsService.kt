package com.paparazziteam.allinone.services

import com.paparazziteam.allinone.models.NewsData
import retrofit2.Call
import retrofit2.http.GET

interface NewsService {

    @GET("v1/news?access_key=2a6960abe7dc05eaf9f2ca28738cab10&sources=cnn,bbc")
    fun getNewsData(): Call<NewsData>
}