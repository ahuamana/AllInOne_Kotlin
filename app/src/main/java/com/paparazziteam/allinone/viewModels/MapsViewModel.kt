package com.paparazziteam.allinone.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.paparazziteam.allinone.models.WeatherInfo
import com.paparazziteam.allinone.services.WeatherService
import com.paparazziteam.allinone.utils.Empty
import com.paparazziteam.allinone.utils.Event
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MapsViewModel: ViewModel() {

    var latitude = String.Empty
    var longitude = String.Empty



    private val _city = MutableLiveData<String>()
    val city: LiveData<String> = _city

    private val _country = MutableLiveData<String>()
    val country: LiveData<String> = _country

    private val _temperature = MutableLiveData<Int>()
    val temperature: LiveData<Int> = _temperature

    private val _weatherStatus = MutableLiveData<String>()
    val weatherStatus = _weatherStatus

    private val _humidityStatus = MutableLiveData<Int>()
    val humidityStatus = _humidityStatus

    private val _windStatus = MutableLiveData<Int>()
    val windStatus = _windStatus

    private val _pressure = MutableLiveData<Int>()
    val pressure = _pressure

    private val _dt = MutableLiveData<String>()
    val dt = _dt


    fun getWeatherData() {
        val retrofit = Retrofit.Builder()
            .baseUrl(OPEN_WEATHER_MAP_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(WeatherService::class.java)
        val call = service.getCurrentWeatherData(latitude, longitude, API_KEY, LANGUAGE)
        call.enqueue(object : Callback<WeatherInfo> {

            override fun onResponse(call: Call<WeatherInfo>, response: Response<WeatherInfo>) {
                if (response.code() == SUCCESS_STATUS) {
                    val weatherInfo = response.body()

                    android.util.Log.e("DAT7A",""+response.body())

                    if (weatherInfo != null) {
//						_city.value = "${weatherInfo.name}, ${weatherInfo.sys.country}"
                        _city.value = weatherInfo.name
                        _country.value = weatherInfo.sys.country ?: String.Empty
                        //_dt.value = convertFromEpoch(weatherInfo.dt)
                        //_temperature.value = convertToCelcius(weatherInfo.main.temp)
                        //_weatherStatus.value =
                        //    weatherInfo.weathers[0].description?.toTitleCase() ?: String.Empty
                        //_pressure.value = weatherInfo.main.pressure.roundToInt()
                        //_humidityStatus.value = weatherInfo.main.humidity.roundToInt()
                        //_windStatus.value = convertToKmPerHour(weatherInfo.wind.speed)
                    }
                }
            }

            override fun onFailure(call: Call<WeatherInfo>, t: Throwable) {
                android.util.Log.d("ERROR", t.message ?: "")
            }
        })


    }

    companion object {
        private const val SUCCESS_STATUS = 200
        private const val OPEN_WEATHER_MAP_BASE_URL = "http://api.openweathermap.org/"
        private const val API_KEY = "20af1e173f5506f1253ee8549de8716e"
        private const val LANGUAGE = "es"
    }


}