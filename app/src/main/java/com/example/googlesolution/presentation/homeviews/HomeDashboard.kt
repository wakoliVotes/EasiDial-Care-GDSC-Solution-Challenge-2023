package com.example.googlesolution.presentation.homeviews

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.googlesolution.R

@Composable

fun HomeDashboard() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Hospital Finder") }
            )
        }
    ) {
        padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Nearest Hospitals",
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            LazyColumn(modifier = Modifier.weight(1f)) {
                items(10) { index ->
                    HospitalListItem(hospitalName = "Hospital ${index + 1}")
                }
            }
            Divider(modifier = Modifier.padding(vertical = 16.dp))
            Text(
                text = "Private Ambulance Contacts",
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            LazyRow {
                items(5) { index ->
                    AmbulanceListItem(ambulanceNumber = "12345${index + 1}")
                }
            }
        }
    }
}

@Composable
fun HospitalListItem(hospitalName: String) {
    Card(
        modifier = Modifier
            .padding(bottom = 8.dp)
            .fillMaxWidth(),
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.hospital),
                contentDescription = "Hospital",
                modifier = Modifier.size(64.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = hospitalName,
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
            )
            IconButton(
                onClick = { /* TODO */ }
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
fun AmbulanceListItem(ambulanceNumber: String) {
    Card(
        modifier = Modifier
            .padding(end = 8.dp)
            .size(120.dp),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ambulance),
                contentDescription = "Ambulance",
                modifier = Modifier.size(64.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = ambulanceNumber,
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@Preview
@Composable
fun HomeDashboardPreview() {
    HomeDashboard()
}