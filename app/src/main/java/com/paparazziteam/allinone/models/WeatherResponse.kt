package com.paparazziteam.allinone.models

import com.google.gson.annotations.SerializedName


data class WeatherInfo(
    @SerializedName("coord") val coord: Coord,
    @SerializedName("sys") val sys: Sys,
    @SerializedName("weather") val weathers: List<Weather> = listOf(),
    @SerializedName("main") val main: Main,
    @SerializedName("wind") val wind: Wind,
    @SerializedName("rain") val rain: Rain,
    @SerializedName("clouds") val clouds: Clouds,
    @SerializedName("dt") val dt: Long,
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("cod") val cod: Float
)

data class Weather(
    @SerializedName("id") val id: Int = 0,
    @SerializedName("main") val main: String? = null,
    @SerializedName("description") val description: String? = null,
    @SerializedName("icon") val icon: String? = null
)

data class Clouds(@SerializedName("all") val all: Float = 0f)

data class Rain(@SerializedName("3h") val h3: Float = 0f)

data class Wind(
    @SerializedName("speed")
    val speed: Float = 0f,
    @SerializedName("deg")
    val deg: Float = 0f
)

data class Main(
    @SerializedName("temp") val temp: Float = 0f,
    @SerializedName("humidity") val humidity: Float = 0f,
    @SerializedName("pressure") val pressure: Float = 0f,
    @SerializedName("temp_min") val temp_min: Float = 0f,
    @SerializedName("temp_max") val temp_max: Float = 0f
)

data class Sys(
    @SerializedName("country") val country: String? = null,
    @SerializedName("sunrise") val sunrise: Long = 0,
    @SerializedName("sunset") val sunset: Long = 0
)

data class Coord(
    @SerializedName("lon") val longitud: Float = 0f,
    @SerializedName("lat") val latitud: Float = 0f,
)