package com.example.googlesolution.presentation.homeviews

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
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
fun HomeView() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Hospital Finder") }
            )
        }
    ) {
        val hospitals = remember {
            listOf(
                Hospital(
                    name = "Hospital 1",
                    about = "This is a sample hospital.",
                    contact = "1234567890",
                    location = "1234, XYZ Street, ABC City",
                    services = "Emergency, Surgery, Pediatrics",
                    hasAmbulance = true
                ),
                Hospital(
                    name = "Hospital 2",
                    about = "This is another sample hospital.",
                    contact = "0987654321",
                    location = "5678, PQR Street, DEF City",
                    services = "Obstetrics, Cardiology, Neurology",
                    hasAmbulance = false
                ),
                Hospital(
                    name = "Hospital 3",
                    about = "This is a third sample hospital.",
                    contact = "2468135790",
                    location = "1357, LMN Street, GHI City",
                    services = "Oncology, Dermatology, Psychiatry",
                    hasAmbulance = true
                ),
            )
        }

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
                itemsIndexed(hospitals) { index, hospital ->
                    HospitalListItem(hospital = hospital, expanded = index == 0)
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
                    AmbulanceListing(ambulanceNumber = "0725115427${index + 1}")
                }
            }
        }
    }
}

@Composable
fun HospitalListItem(hospital: Hospital, expanded: Boolean) {
    var isExpanded by remember { mutableStateOf(expanded) }

    Card(
        modifier = Modifier
            .padding(bottom = 8.dp)
            .fillMaxWidth(),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier.clickable { isExpanded = !isExpanded }
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
                Column(
                    modifier = Modifier.weight(1f)
                        .fillMaxWidth()
                ) {
                Text(
                    text = hospital.name,
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    imageVector = if (isExpanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Expand/Collapse",
                    tint = Color.Gray,
                    modifier = Modifier.size(32.dp)
                )
            }
            }
            if (isExpanded) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    HospitalInfoItem(title = "About", value = hospital.about)
                    HospitalInfoItem(title = "Contact", value = hospital.contact)
                    HospitalInfoItem(title = "Location", value = hospital.location)
                    HospitalInfoItem(title = "Services", value = hospital.services)
                    HospitalInfoItem(title = "Ambulance Available", value = if (hospital.hasAmbulance) "YES" else "NO")
                }
            }
        }
    }
}

@Composable
fun HospitalInfoItem(title: String, value: String) {
    Column(
        modifier = Modifier
            .padding(bottom = 8.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.subtitle1,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = value,
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier.padding(bottom = 8.dp)
        )
    }
}

@Composable
fun AmbulanceListing(ambulanceNumber: String) {
    Card(
        modifier = Modifier
            .padding(end = 8.dp)
            .width(120.dp),
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.Call,
                contentDescription = "Call",
                tint = Color.Gray,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = ambulanceNumber,
                style = MaterialTheme.typography.body1
            )
        }
    }
}

data class Hospital(
    val name: String,
    val about: String,
    val contact: String,
    val location: String,
    val services: String,
    val hasAmbulance: Boolean
)


// Add Preview
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HomeView()
}



