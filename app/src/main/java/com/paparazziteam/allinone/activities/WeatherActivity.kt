package com.paparazziteam.allinone.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider

import androidx.lifecycle.ViewModelStore
import com.paparazziteam.allinone.R
import com.paparazziteam.allinone.databinding.ActivityWeatherBinding
import com.paparazziteam.allinone.viewModels.MapsViewModel

class WeatherActivity : AppCompatActivity() {

    private lateinit var binding:ActivityWeatherBinding
    private val viewModel: MapsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel.latitude = intent.getStringExtra("latitude").toString()
        viewModel.longitude = intent.getStringExtra("longitude").toString()

        android.util.Log.e("LATITUD - LONGITUD","LATITUD: "+viewModel.latitude +" LONGITUD: "+viewModel.longitude )

        viewModel.getWeatherData()



    }

}


