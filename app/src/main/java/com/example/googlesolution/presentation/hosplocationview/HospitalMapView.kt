package com.example.googlesolution.presentation.hosplocationview

import android.location.Location
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


@Composable
fun HospitalsMapView(
    navController: NavHostController,
) {
    val context = LocalContext.current
    val mapView = MapView(context).apply {
        onCreate(null)
        getMapAsync { googleMap ->
            // Setting Kenya as the map's location
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(LatLng(-0.0236, 37.9062)))

            // Adding markers for hospitals around Nairobi
            val nairobi = LatLng(-1.2921, 36.8219)
            val hospitals = listOf(
                Pair("Aga Khan Hospital", LatLng(-1.2654, 36.7992)),
                Pair("Kenyatta National Hospital", LatLng(-1.3011, 36.8074)),
                Pair("MP Shah Hospital", LatLng(-1.2632, 36.8126)),
                Pair("The Mater Hospital - Kasarani Clinic",
                    LatLng(-1.2193, 36.8889)),
                Pair("Kenyatta University Teaching Hospital",
                    LatLng(-1.1774, 36.9160)),
                Pair("Pumwani Maternity Hospital", LatLng(-1.2806, 36.8455)),
                Pair("The Nairobi Hospital", LatLng(-1.2956, 36.8040)),
                Pair("Ruaraka Uhai Neema Hospital", LatLng(-1.2269, 36.8852)),
                Pair("St. Francis Hospital", LatLng(-1.2254, 36.91588)),
                Pair("St. Johns Hospital Githurai", LatLng(-1.2033, 36.9146)),
                Pair("Guru Nanak Ramgarhia Sikh Hospital",
                    LatLng(-1.2694, 36.8330)),
                Pair("Mama Lucy Hospital", LatLng(-1.2738, 36.8994)),
                Pair("Ruaraka Uhai Neema Hospital", LatLng(-1.2267, 36.8855)),
                Pair("Gertrude's Children's Hospital -TRM Clinic",
                    LatLng(-1.2196, 36.8891)),
                Pair("Trinity Medical Clinic", LatLng(-1.2236, 36.8935)),
                Pair("The Karen Hospital", LatLng(-1.3361, 36.7261)),
                Pair("St. Scholastica Uzima Hospital", LatLng(-1.2537, 36.8566)),
                Pair("Crane Hospital", LatLng(-1.2149, 36.8865)),
                // Add Jesse Kay Children Hospital
                Pair("Jesse Kay Children Hospital", LatLng(-1.2161, 36.8869)),
                Pair("Thika Road Health Centre", LatLng(-1.2188, 36.8958))
                )


            hospitals.forEach {
                googleMap.addMarker(
                    MarkerOptions().position(it.second).title(it.first)
                )
            }

            // Zoom in on the closest hospital to Nairobi
            val closestHospital = hospitals.minByOrNull {
                val location1 = Location("")
                location1.latitude = it.second.latitude
                location1.longitude = it.second.longitude

                val location2 = Location("")
                location2.latitude = nairobi.latitude
                location2.longitude = nairobi.longitude

                location1.distanceTo(location2)
            }
            closestHospital?.let {
                val zoomLevel = 12f
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(it.second, zoomLevel))
            }
        }
    }
        AndroidView(
            factory = { mapView }
        ) {
            it.onResume()
        }
}


// Preview
@Preview
@Composable
fun PreviewHospitalsMapView() {
    HospitalsMapView(navController = rememberNavController())
}