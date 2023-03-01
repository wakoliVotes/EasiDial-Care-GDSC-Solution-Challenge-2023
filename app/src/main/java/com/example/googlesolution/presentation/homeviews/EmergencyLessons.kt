package com.example.googlesolution.presentation.homeviews

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.googlesolution.R
import com.example.googlesolution.presentation.bottomviews.BottomNavBarItems

@Composable
fun EmergencyLessons (navController: NavHostController) {
    Scaffold { padding ->
        val hospitals = remember {
            listOf(
                Hospital(
                    name = "Lesson 1",
                    description = "A stroke is a medical emergency in which the blood supply to the brain is suddenly blocked, causing part of the brain to die. A stroke is a medical emergency in which the blood supply to the brain is suddenly blocked, causing part of the brain to die.",
                    severity = "Life-threatening",
                    hasAmbulance = true
                ),
                Hospital(
                    name = "Lesson 2",
                    description = "Heart attack is a medical emergency in which the blood supply to the heart is suddenly blocked, causing part of the heart muscle to die. A heart attack is a medical emergency in which the blood supply to the heart is suddenly blocked, causing part of the heart muscle to die.",
                    severity = "Serious",
                    hasAmbulance = false
                ),
                Hospital(
                    name = "Lesson 3",
                    description = "Insect stings are a common medical emergency in which the body reacts to the bite of an insect. Insect stings are a common medical emergency in which the body reacts to the bite of an insect.",
                    severity = "Minor",
                    hasAmbulance = true
                ),
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                text = "Emergency Lessons",
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 16.dp, bottom = 5.dp, top = 40.dp)
            )
            Text(
                text = "Be Informed: Be Safe",
                style = MaterialTheme.typography.subtitle2,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 16.dp, bottom = 25.dp, top = 5.dp)
                    .alpha(0.6f)
            )
            Text(
                text = "Emergencies can happen at any time, and it's important to be prepared to respond quickly and effectively. Whether it's a medical emergency, a natural disaster, or a personal crisis, knowing what to do in the moment can make all the difference.",
                modifier = Modifier.padding(start = 16.dp, bottom = 8.dp, end = 16.dp),
                textAlign = TextAlign.Justify,
                fontSize = 12.sp
            )
            Text(
                text = "The following lessons will help you prepare for and respond to emergencies. You can also find more information on accessing care and services in the Hospital and Ambulances pages.",
                modifier = Modifier.padding(start = 16.dp, bottom = 8.dp, end = 16.dp),
                textAlign = TextAlign.Justify,
                fontSize = 12.sp
            )
            LazyColumn(modifier = Modifier.weight(1f)) {
                itemsIndexed(hospitals) { index, hospital ->
                    HospitalListItem(hospital = hospital, expanded = index == 0)
                }
            }
            Divider(modifier = Modifier.padding(vertical = 16.dp))
            Text(
                text = "Speed Dial Emergency Contacts",
                style = MaterialTheme.typography.subtitle2,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 16.dp, bottom = 8.dp, end = 16.dp)
            )
            LazyRow {
                items(5) { index ->
                    AmbulanceListing(ambulanceNumber = "0725115427${index + 1}")
                }
            }
            BottomNavBarItems(navController = rememberNavController()
            )
        }
    }
}

@Composable
fun HospitalListItem(hospital: Hospital, expanded: Boolean) {
    var isExpanded by remember { mutableStateOf(expanded) }

    Card(
        modifier = Modifier
            .padding(bottom = 8.dp, end = 8.dp, start = 8.dp)
            .fillMaxWidth(),
        elevation = 5.dp
    ) {
        Column(
            modifier = Modifier
                .clickable { isExpanded = !isExpanded }
        ) {
            Row(
                modifier = Modifier.padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.hospital),
                    contentDescription = "Lesson",
                    modifier = Modifier
                        .size(30.dp)
                        .clip(if (isExpanded) CircleShape else RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop,
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = hospital.name,
                    style = MaterialTheme.typography.subtitle2,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.weight(1f),
                    textAlign = if (isExpanded) TextAlign.Center else TextAlign.Start
                )
                Icon(
                    imageVector = if (isExpanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Expand/Collapse",
                    tint = Color.Gray,
                    modifier = Modifier
                        .size(28.dp)
                        .padding(end= 10.dp)
                )

            }
            if (isExpanded) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                ) {
                    HospitalInfoItem(title = "Description", value = hospital.description)
                    HospitalInfoItem(title = "Severity", value = hospital.severity)
                    HospitalInfoItem(title = "Risk State",
                        value = if (hospital.hasAmbulance) "YES" else "NO")
                }
            }
        }
    }
}

@Composable
fun HospitalInfoItem(title: String, value: String) {
    Column(
        modifier = Modifier
            .padding(bottom = 0.dp)
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
            style = MaterialTheme.typography.caption,
            textAlign = TextAlign.Justify,
        )
    }
}

@Composable
fun AmbulanceListing(ambulanceNumber: String) {
    Card(
        modifier = Modifier
            .padding(6.dp)
            .width(120.dp),
        elevation = 4.dp
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Name of Entity",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
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
                    modifier = Modifier.size(12.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = ambulanceNumber,
                    style = TextStyle(
                        fontSize = 12.sp
                    )
                )
            }

        }
    }
}

data class Hospital(
    val name: String,
    val description: String,
    val severity: String,
    val hasAmbulance: Boolean,
)


// Add Preview
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EmergencyLessons( navController = rememberNavController() )
}



