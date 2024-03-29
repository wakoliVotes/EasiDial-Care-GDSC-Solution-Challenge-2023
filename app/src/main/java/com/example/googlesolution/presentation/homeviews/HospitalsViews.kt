package com.example.googlesolution.presentation.homeviews

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.googlesolution.R
import com.example.googlesolution.datalayer.screensviewmodels.Hospital
import com.example.googlesolution.datalayer.screensviewmodels.HospitalsViewModel
import com.example.googlesolution.datalayer.screensviewmodels.TopHospitals
import com.example.googlesolution.ui.theme.lightGreener
import com.example.googlesolution.ui.theme.lightGreenest
import com.google.accompanist.flowlayout.FlowRow

@Composable

fun HospitalsViews(
    navController: NavHostController,
) {
    val viewModel = viewModel<HospitalsViewModel>()
    val searchText by viewModel.searchText.collectAsState()
    val hospitals by viewModel.hospitals.collectAsState()
    val isSearching by viewModel.isSearching.collectAsState()

    MaterialTheme() {
        Scaffold(
            modifier = Modifier
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding()
                        .clip(RoundedCornerShape(0.dp, 0.dp, 24.dp, 24.dp))
                        .background(lightGreener)
                ) {
                    Column(
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = "Hospitals",
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 28.sp,
                            ),
                            modifier = Modifier
                                .padding(start = 16.dp)
                        )
                        Text(
                            text = "Access Services in Emergencies",
                            style = MaterialTheme.typography.subtitle2,
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp,
                            modifier = Modifier
                                .padding(start = 16.dp, bottom = 16.dp, top = 4.dp)
                                .alpha(0.5f)
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        //.background(BlueMildest)
                        .padding(top = 0.dp)
                ) {
                    // Search TextField
                    TextField(
                        value = searchText,
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.White,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            cursorColor = lightGreener,
                            textColor = Color.Black,
                            disabledLabelColor = Color.Black,
                            focusedLabelColor = lightGreener,
                            unfocusedLabelColor = Color.Black,
                        ),
                        onValueChange = { /*TODO*/
                            viewModel.onSearchTermChange(it)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .size(50.dp)
                            .alpha(0.8f)
                            .clip(RoundedCornerShape(16.dp)),
                        textStyle = TextStyle(
                            color = MaterialTheme.colors.onSecondary
                        ),
                        label = {
                            Text(
                                text = "Search",
                                style = TextStyle(
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 16.sp
                                )
                            )
                        },
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "search",
                                tint = Color.Gray
                            )
                        },
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Done,
                            keyboardType = KeyboardType.Text
                        ),
                    )
                    // End of Search TextField
                    FlowRow(
                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                            .weight(1f)
                            .padding(4.dp)
                    ) {
                        hospitals.forEach {
                            HospitalListItem(hospitals = it)
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun HospitalListItem(
    hospitals: Hospital,
) {
    val context = LocalContext.current

    Card(
        elevation = 4.dp,
        backgroundColor = MaterialTheme.colors.surface,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(all = 4.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(6.dp)
        ) {
            Image(
                painter = painterResource(id = hospitals.hospImage),
                contentDescription = "",
                modifier = Modifier
                    .height(106.dp)
                    .width(120.dp)
                    .weight(0.3f)
                    .padding(4.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.FillBounds
            )
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .weight(0.6f)
                    .padding(start = 8.dp)
            ) {
                Text(
                    text = hospitals.name,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.W400,
                    modifier = Modifier
                        .padding(top = 2.dp),
                    overflow = TextOverflow.Visible,
                )
                Text(
                    hospitals.location,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.W300,
                    modifier = Modifier.padding(),
                )
                Row(
                    modifier = Modifier
                        .padding(top = 4.dp, start = 8.dp, end = 30.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = {
                            /*TODO*/
                            // allow share via text, email, whatsapp, telegram, etc
                            val intent = Intent(Intent.ACTION_SEND).apply {
                                type = "text/plain"
                                putExtra(
                                    Intent.EXTRA_TEXT,
                                    "Check out: ${hospitals.name}, ${hospitals.contact}"
                                )
                            }
                            context.startActivity(intent)
                        },
                        modifier = Modifier
                            .size(28.dp)
                            .background(MaterialTheme.colors.onSecondary, CircleShape)
                            .clip(CircleShape)
                            .padding(),
                    ) {
                        Icon(
                            imageVector = Icons.Default.Share,
                            contentDescription = "Share",
                            tint = MaterialTheme.colors.secondary,
                            modifier = Modifier
                                .padding(5.dp)
                        )
                    }
                    Text(
                        text = hospitals.contact,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.W500,
                        modifier = Modifier.padding(),
                    )
                    IconButton(
                        onClick = {
                            /*TODO*/
                            // open dialer
                            val intent = Intent(Intent.ACTION_DIAL).apply {
                                data = "tel:${hospitals.contact}".toUri()
                            }
                            context.startActivity(intent)

                        },
                        modifier = Modifier
                            .size(28.dp)
                            .background(MaterialTheme.colors.secondary, CircleShape)
                            .clip(CircleShape)
                            .padding()
                    ) {
                        Icon(
                            imageVector = Icons.Default.Call,
                            contentDescription = "Call",
                            tint = MaterialTheme.colors.onSecondary,
                            modifier = Modifier
                                .padding(5.dp)
                        )
                    }
                }
            }
            IconButton(
                onClick = {
                    /*TODO*/
                    // Toast a message saying "Has ambulance" if true, else "no ambulance"
                    if (hospitals.hasAmbulance)
                        Toast.makeText(context, "Has Ambulance", Toast.LENGTH_SHORT).show()
                    else
                        Toast.makeText(context, "No Ambulance", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier
                    .padding(8.dp)
                    .size(20.dp)
                    .background(Color.Black, CircleShape)
                    .clip(CircleShape)
                    .padding()
                    .weight(0.1f)

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.car),
                    contentDescription = "ambulance",
                    tint = if (hospitals.hasAmbulance) Color.Green else Color.Gray,
                    modifier = Modifier
                        .padding(1.dp)
                )
            }
        }
    }
}

@Composable
fun TopHospitalsListItem(
    topHospitals: TopHospitals,
) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .padding(8.dp)
            .height(210.dp)
            .width(196.dp)
            .clip(RoundedCornerShape(16.dp)),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(lightGreenest),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box() {
                Image(
                    painter = painterResource(topHospitals.hospImage),
                    contentDescription = "hospitals",
                    modifier = Modifier
                        .height(140.dp)
                        .fillMaxWidth()
                        .padding(bottom = 4.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
                IconButton(
                    onClick = {
                        /*TODO*/
                        // Toast a message saying "has ambulance" if true, else "no ambulance"
                        if (topHospitals.hasAmbulance)
                            Toast.makeText(context, "Has Ambulance", Toast.LENGTH_SHORT).show()
                        else
                            Toast.makeText(context, "No Ambulance", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier
                        .padding()
                        .size(24.dp)
                        .background(Color.White, CircleShape)
                        .clip(CircleShape)
//                        .padding()
                        .align(Alignment.BottomCenter)
                ) {
                    Icon(
                        imageVector = if (topHospitals.hasAmbulance) Icons.Default.CheckCircle else Icons.Default.Info,
                        contentDescription = "ambulance status",
                        tint = if (topHospitals.hasAmbulance) Color.Green else Color.Red,
                        modifier = Modifier
                            .padding(2.dp)
                    )

                }

            }
            Text(
                text = topHospitals.hospitalName,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.onSecondary
                ),
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .height(25.dp)
                    .padding(start = 4.dp, end = 4.dp)
            )
            Row(
                modifier = Modifier
                    .padding(top = 2.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                IconButton(
                    onClick = {
                        /* TODO */
                        val intent = Intent(Intent.ACTION_DIAL).apply {
                            data = "tel:${topHospitals.hospitalContacts}".toUri()
                        }
                        context.startActivity(intent)
                    },
                    modifier = Modifier
                        .size(28.dp)
                        .background(lightGreener, CircleShape)
                        .clip(CircleShape)
                        .padding()
                ) {
                    Icon(
                        imageVector = Icons.Default.Call,
                        contentDescription = "Call",
                        tint = MaterialTheme.colors.onPrimary,
                        modifier = Modifier
                            .padding(5.dp)
                    )
                }
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = topHospitals.hospitalContacts,
                    style = TextStyle(
                        fontWeight = FontWeight.Light,
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colors.onSecondary
                    ),
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun HomeDashboardPreview() {
    HospitalsViews(
        navController = rememberNavController()
    )
}