package com.codekul.googlemaps

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.setOnMapClickListener {

            mMap.addMarker(
                    MarkerOptions()
                            .position(it)
                            .title("Pune")
            )
        }

        // Add a marker in Sydney and move the camera
        val pune = LatLng(18.73, 72.56)
        mMap.addMarker(
                MarkerOptions()
                        .position(pune)
                        .title("Pune")
        )

        val mumbai = LatLng(19.0760, 72.8777)
        mMap.addMarker(
                MarkerOptions()
                        .position(mumbai)
                        .title("Mumbai")
        )

        mMap.addPolyline(
                PolylineOptions().add(pune, mumbai)
        )

        mMap.moveCamera(CameraUpdateFactory.newLatLng(pune))
    }
}
