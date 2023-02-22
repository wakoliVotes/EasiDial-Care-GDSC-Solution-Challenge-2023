package com.example.googlesolution.presentation.homeviews

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.googlesolution.R
import com.example.googlesolution.ui.theme.WaterMilder

@Composable

fun AmbulancesView() {
    Scaffold {
            padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Text(
                text = "Top Ambulance Services",
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            LazyRow {
                items(5) { index ->
                    TopAmbulanceList(ambulanceName = "St. Johns", ambulanceNumber = "071212345${index + 1}")
                }
            }
            Text(
                text = "Ambulances",
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 30.dp, bottom = 28.dp, start = 10.dp)
            )
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
            ) {
                items(10) { index ->
                    AmbulancesList(hospitalName = "Hospital ${index + 1}")
                }
            }
            Divider(modifier = Modifier.padding(vertical = 16.dp))
            // Add 2 buttons to move to Home and to MapView
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth(0.4f)
                        .height(50.dp)
                ) {
                    Text(text = "See Hospitals")
                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth(0.4f)
                        .height(50.dp)
                ) {
                    Text(text = "Map View")
                }
            }
        }
    }
}

@Composable
fun AmbulancesList(hospitalName: String) {
    Card(
        modifier = Modifier
            .padding(start = 5.dp, end = 5.dp, bottom = 8.dp)
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.medium),
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .padding(2.dp)
                .background(WaterMilder)
                .alpha(0.8f)
                .clip(MaterialTheme.shapes.medium)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ambulance0),
                contentDescription = "Hospital",
                modifier = Modifier
                    .height(100.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .weight(1.5f),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column (
                modifier = Modifier.weight(4f),
            ) {
                Text(
                    text = hospitalName,
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 5.dp, bottom = 4.dp)
                )
                Text(
                    text = "Address",
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier.padding(bottom = 2.dp)
                )
                Text(
                    text = "Phone Number",
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier.padding(bottom = 2.dp)
                )
                Text(
                    text = "Ambulance: YES/NO",
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier.padding(bottom = 2.dp)
                )
            }
            IconButton(
                onClick = { /* TODO */ },
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f)
            ) {
                Icon(
                    imageVector = Icons.Default.Call,
                    contentDescription = "Call",
                    tint = Color.Blue
                )
            }
        }
    }
}

@Composable
fun TopAmbulanceList(
    ambulanceName: String,
    ambulanceNumber: String
) {
    Card(
        modifier = Modifier
            .padding(end = 8.dp)
            .size(150.dp),
        elevation = 5.dp
    ) {
        Column(
            modifier = Modifier.padding(0.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ambulance1),
                contentDescription = "Ambulance",
                modifier = Modifier.height(100.dp),
                contentScale = ContentScale.FillWidth
            )
            Text(
                text = ambulanceName,
                style = MaterialTheme.typography.subtitle2,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = ambulanceNumber,
                style = MaterialTheme.typography.caption,
                fontWeight = FontWeight.SemiBold,
            )
        }
    }
}

@Preview
@Composable
fun AmbulancePreview() {
    AmbulancesView()
}