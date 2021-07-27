package com.paparazziteam.allinone.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.paparazziteam.allinone.databinding.ActivityWeatherBinding
import com.paparazziteam.allinone.models.WeatherInfo
import com.paparazziteam.allinone.viewModels.MapsViewModel

class WeatherActivity : AppCompatActivity() {

    private lateinit var binding:ActivityWeatherBinding

    // Obtain the ViewModel component.
    private val _viewModel:MapsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherBinding.inflate(getLayoutInflater()).apply {
            lifecycleOwner = this@WeatherActivity
            viewModel = _viewModel
        }


        _viewModel.latitude = intent.getStringExtra("latitude").toString()
        _viewModel.longitude = intent.getStringExtra("longitude").toString()

        //android.util.Log.e("LATITUD - LONGITUD","LATITUD: "+viewModel.latitude +" LONGITUD: "+viewModel.longitude )

        _viewModel.getWeatherData()

        // Create the observer which updates the UI.

        setContentView(binding.root)

    }

}


