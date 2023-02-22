

package com.example.googlesolution.presentation.locationviews

/*
import android.content.Context
import android.content.Intent
import android.location.Location
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.googlesolution.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


@Composable
fun ExpandableMapsView() {
    val context = LocalContext.current
    val mapView = rememberMapViewWithLifecycle()

    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            mapView.apply {
                onCreate(null)
                getMapAsync { googleMap ->
                    // Set Kenya as the map's location
                    googleMap.moveCamera(CameraUpdateFactory.newLatLng(LatLng(-0.0236, 37.9062)))

                    // Add marker for hospitals around Nairobi
                    val nairobi = LatLng(-1.2921, 36.8219)
                    val hospitals = listOf(
                        Pair("Nairobi Hospital", LatLng(-1.2906, 36.8045)),
                        Pair("Aga Khan Hospital", LatLng(-1.2654, 36.7992)),
                        Pair("Kenyatta National Hospital", LatLng(-1.3004, 36.7964)),
                        Pair("MP Shah Hospital", LatLng(-1.2511, 36.8126)),
                    )

                    hospitals.forEach { (name, location) ->
                        googleMap.addMarker(
                            MarkerOptions()
                                .position(location)
                                .title(name)
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

                OnMarkerClickListener { marker ->
                    val hospital = hospitals.find { it.first == marker.title }
                    hospital?.let { (name, location) ->
                        showHospitalDetails(name, location, context)
                    }
                    true
                }
            }
        },
    ) {
        it.onResume()
    }
}

@Composable
fun showHospitalDetails(name: String, location: LatLng, context: Context) {
    val contact = "Contact info for $name"

    // Display hospital name and contact details
    Column(
        modifier = Modifier
            .background(Color.White)
            .padding(16.dp)
    ) {
        Text(text = name, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Text(text = contact, fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp))

        // Add an icon button to call the hospital
        IconButton(
            onClick = { makeCall(context, name) },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.call),
                contentDescription = "Call $name",
            )
        }
    }
}

fun makeCall(context: Context, name: String) {
    // Make a phone call to the hospital
    val phone = "123-456-7890" // Replace with actual phone number
    val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))
    context.startActivity(intent)
}

@Preview
@Composable
fun PreviewHospitalsMapView() {
    HospitalsMapView()
}

 */


