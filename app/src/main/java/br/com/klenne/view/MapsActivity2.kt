package br.com.klenne.view

import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.os.Build
import android.os.Bundle
import android.os.Looper
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import br.com.klenne.common.Common
import br.com.klenne.model.MyPlaces
import br.com.klenne.remote.IGoogleAPIService
import com.google.android.gms.location.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_maps2.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.StringBuilder


class MapsActivity2 : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private var latitude: Double = 0.toDouble()
    private var longitude: Double = 0.toDouble()
    private lateinit var mLastLocation: Location
    private var mMarker: Marker? = null

    lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    lateinit var locationRequest: LocationRequest
    lateinit var locationCallback: LocationCallback

    companion object {
        private const val MY_PERMISSION_CODE: Int = 1000

    }

    lateinit var mService: IGoogleAPIService
    internal lateinit var currentPlace: MyPlaces

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps2)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)


//init Service
        mService = Common.googleApiService
        //runtime permision
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkLocationPermission()) {


                buildLocationRequest()
                buildLocationCallback()

                fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

                fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, Looper.myLooper())
            }
        } else {

            buildLocationRequest()
            buildLocationCallback()

            fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

            fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, Looper.myLooper())
        }


        btn_atualizar.setOnClickListener {
            nearByPlace()
        }
btn_voltar_gps.setOnClickListener {
    val intent= Intent(this,TelaMain::class.java)
    startActivity(intent)
    finish(

    )
}
    }

    override fun onStop() {
        fusedLocationProviderClient.removeLocationUpdates(locationCallback)
        super.onStop()
    }

    private fun buildLocationCallback() {
        locationCallback = object : LocationCallback() {
            override fun onLocationResult(p0: LocationResult?) {
                mLastLocation = p0!!.locations.get(p0!!.locations.size - 1)//get last locations

                if (mMarker != null) {
                    mMarker!!.remove()
                }
                latitude = mLastLocation.latitude
                longitude = mLastLocation.longitude

                val latLng = LatLng(latitude, longitude)
                val markerOptions = MarkerOptions()
                    .position(latLng)
                    .title("Você está aqui")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))

                mMarker = mMap!!.addMarker(markerOptions)

                mMap!!.moveCamera(CameraUpdateFactory.newLatLng(latLng))
                mMap!!.animateCamera(CameraUpdateFactory.zoomTo(15f))
            }
        }
    }

    private fun buildLocationRequest() {

        locationRequest = LocationRequest()
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        locationRequest.interval = 5000
        locationRequest.fastestInterval = 3000
        locationRequest.smallestDisplacement = 10f
    }

    private fun checkLocationPermission(): Boolean {
        if (ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    android.Manifest.permission.ACCESS_FINE_LOCATION
                )
            ) {
                ActivityCompat.requestPermissions(
                    this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION)

                    , MY_PERMISSION_CODE
                )
            } else {
                ActivityCompat.requestPermissions(
                    this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION)

                    , MY_PERMISSION_CODE
                )
                return false
            }
        }
        return true

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            MY_PERMISSION_CODE -> {
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(
                            this,
                            android.Manifest.permission.ACCESS_FINE_LOCATION
                        ) == PackageManager.PERMISSION_GRANTED
                    ) {
                        if (checkLocationPermission()) {

                            buildLocationRequest()
                            buildLocationCallback()

                            fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

                            fusedLocationProviderClient.requestLocationUpdates(
                                locationRequest,
                                locationCallback,
                                Looper.myLooper()
                            )
                            mMap!!.isMyLocationEnabled = true
                        }
                    }
                } else {
                    Toast.makeText(this, "Acesso ao GPS negado", Toast.LENGTH_SHORT).show()

                }
            }

        }
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.ACCESS_FINE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED
            ) {

                mMap!!.isMyLocationEnabled = true
            }
        } else {
            mMap!!.isMyLocationEnabled = true

        }
        mMap.uiSettings.isZoomControlsEnabled = true

    }

    private fun nearByPlace() {
        val typePlace = "restaurant"
        mMap.clear()

        val url = getUrl(latitude, longitude, typePlace)
        mService.getNearbyPlaces(url)
            .enqueue(object : Callback<MyPlaces> {
                override fun onFailure(call: Call<MyPlaces>, t: Throwable) {
                    Toast.makeText(baseContext, "" + t.message, Toast.LENGTH_SHORT).show()

                }

                override fun onResponse(call: Call<MyPlaces>, response: Response<MyPlaces>) {
                    currentPlace = response!!.body()!!
                    if (response!!.isSuccessful) {

                        for (i in 0 until response!!.body()!!.results!!.size) {
                            val markerOptions = MarkerOptions()
                            val googlePlace = response.body()!!.results!![i]
                            val lat = googlePlace.geometry!!.location!!.lat
                            val lng = googlePlace.geometry!!.location!!.lng
                            val placeName = googlePlace.name
                            val latLng = LatLng(lat, lng)

                            markerOptions.position(latLng)
                            markerOptions.title(placeName)
                            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_stat_name_loto))
                            markerOptions.snippet(i.toString())

                            mMap!!.addMarker(MarkerOptions())
                            mMap!!.moveCamera(CameraUpdateFactory.newLatLng(latLng))
                            mMap!!.animateCamera(CameraUpdateFactory.zoomTo(15f))

                        }


                    }
                }

            })
    }

    private fun getUrl(latitude: Double, longitude: Double, typePlace: String): String {


        val googlePlaceUrl = StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json")
        googlePlaceUrl.append("?location=$latitude,$longitude")
        googlePlaceUrl.append("&radius=10000")//10km
        googlePlaceUrl.append("&type=$typePlace")
        googlePlaceUrl.append("&key=AIzaSyDL-_RQtKB8l7Jqif9p1Hp2lEYxAklmAhg")

        Log.d("UEL_DEBUG", googlePlaceUrl.toString())
        return googlePlaceUrl.toString()
    }


}
