package com.example.googlesolution.presentation.locationviews

import android.location.Location
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
            // Set Kenya as the map's location
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(LatLng(-0.0236, 37.9062)))

            // Add marker for hospitals around Nairobi
            val nairobi = LatLng(-1.2921, 36.8219)
            val hospitals = listOf(
                Pair("Aga Khan Hospital", LatLng(-1.2654, 36.7992)),
                Pair("Kenyatta National Hospital", LatLng(-1.3011079208974268, 36.807461974370995)),
                Pair("MP Shah Hospital", LatLng(-1.2632898251491196, 36.812698016965435)),
                Pair("The Mater Hospital - Kasarani Clinic",
                    LatLng(-1.2193374499729221, 36.88892990566548)),
                Pair("Kenyatta University Teaching Hospital",
                    LatLng(-1.1774691190860256, 36.91608746146164)),
                Pair("Pumwani Maternity Hospital", LatLng(-1.2921, 36.8219)),
                Pair("Moi Teaching and Referral Hospital", LatLng(-1.2921, 36.8219)),
                Pair("Agha Khan University Hospital", LatLng(-1.2921, 36.8219)),
                Pair("Kenya Medical Training College", LatLng(-1.2921, 36.8219)),
                Pair("The Nairobi Hospital", LatLng(-1.2956796273953772, 36.804067877003654)),
                Pair("Ruaraka Uhai Neema Hospital", LatLng(-1.2921, 36.8219)),
                Pair("St. Francis Hospital", LatLng(-1.2254778494632843, 36.915886972983834)),
                Pair("St. Johns Hospital Githurai", LatLng(-1.203397121537523, 36.91464574411761)),
                Pair("Guru Nanak Ramgarhia Sikh Hospital",
                    LatLng(-1.269487777996648, 36.83308320366392)),
                Pair("Mama Lucy Hospital", LatLng(-1.2738373715474747, 36.89944121637831)),
                Pair("Ruaraka Uhai Neema Hospital", LatLng(-1.2267736492234802, 36.88558978151493)),
                Pair("Gertrude's Children's Hospital -TRM Clinic",
                    LatLng(-1.219656881257904, 36.88910708431577)),

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
    Column {
        AndroidView(
            modifier = Modifier.weight(0.8f),
            factory = { mapView }
        ) {
            it.onResume()
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .weight(0.2f)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {
                    /* Navigate to ambulance view */
                    navController.navigate("home")
                },
                modifier = Modifier
                    .height(45.dp)
                    .width(170.dp),
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = "Hospitals",
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(horizontal = 2.dp)
                    )
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "Arrow Forward",
                        tint = Color.White,
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .align(Alignment.CenterVertically)
                    )
                }
            }
            Button(
                onClick = {
                    /* Navigate to map view */
                    navController.navigate("ambulances")
                },
                modifier = Modifier
                    .height(45.dp)
                    .width(170.dp),
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
            ) {
                // add arrow icon to the right of the text
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = "Ambulances",
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(horizontal = 2.dp)
                    )
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "Arrow Forward",
                        tint = Color.White,
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .align(Alignment.CenterVertically)
                    )
                }
            }
        }
    }
}


// Preview
@Preview
@Composable
fun PreviewHospitalsMapView() {
    HospitalsMapView(navController = rememberNavController())
}