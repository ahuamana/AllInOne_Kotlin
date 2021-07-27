package com.paparazziteam.allinone.fragments

import android.content.Intent
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.maps.android.ktx.model.markerOptions
import com.paparazziteam.allinone.R
import com.paparazziteam.allinone.activities.WeatherActivity
import com.paparazziteam.allinone.viewModels.MapsViewModel

class MapsFragment : Fragment() {

    private var _map: GoogleMap? = null
    private val _viewmodel by viewModels<MapsViewModel>()

    private val callback = OnMapReadyCallback { googleMap ->

        _map = googleMap
        val latLng = LatLng(LATITUDE, LONGITUDE)

        initMapUIControls(googleMap)

        googleMap.addMarker(MarkerOptions().position(latLng).title("Marker in Huancayo"))
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, DEFAULT_ZOOM))


        //add marker
        googleMap.setOnMapClickListener {
            val marker = MarkerOptions().position(it)
            _map?.addMarker(marker)
            _map?.animateCamera(CameraUpdateFactory.newLatLngZoom(marker.position, DEFAULT_ZOOM))

        }

        googleMap.setOnMarkerClickListener {
            _viewmodel.latitude = it.position.latitude.toString()
            _viewmodel.longitude = it.position.longitude.toString()

            Log.d("LATITUDE", "LATITUDE: "+_viewmodel.latitude)
            Log.d("LONGITUD", _viewmodel.longitude)

            gotoWeatherActivity()

            true
        }
    }

    private fun gotoWeatherActivity() {

        var intent = Intent(context, WeatherActivity::class.java).apply {
            putExtra("latitude",_viewmodel.latitude)
            putExtra("longitude",_viewmodel.longitude)
        }

        startActivity(intent)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

    private fun initMapUIControls(googleMap: GoogleMap) {

        googleMap.uiSettings.isMapToolbarEnabled = true
        googleMap.uiSettings.isZoomControlsEnabled = true
        googleMap.uiSettings.isMyLocationButtonEnabled = true

    }


    companion object {
        // Coordenadas de la ciudad de Huancayo
        private const val LATITUDE = -12.057203477584785
        private const val LONGITUDE = -75.21676369217299
        private const val DEFAULT_ZOOM = 7.0f
    }
}