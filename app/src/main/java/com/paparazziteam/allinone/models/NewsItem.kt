package com.paparazziteam.allinone.models

import com.google.gson.annotations.SerializedName


data class NewsItem (
    @SerializedName("author") val id: Int = 0,
    @SerializedName("title") val title: String? = null,
    @SerializedName("description") val description: String? = null,
    @SerializedName("url") val url: String? = null,
    @SerializedName("source") val source: String? = null,
    @SerializedName("image") val image: String? = null,
    @SerializedName("category") val category: String? = null,
    @SerializedName("language") val language: String? = null,
    @SerializedName("country") val country: String? = null,
    @SerializedName("published_at") val published_at: String? = null
)

data class NewsData (
    @SerializedName("data") val items: List<NewsItem>)


