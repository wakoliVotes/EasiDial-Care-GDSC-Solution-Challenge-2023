package com.example.googlesolution.presentation.homeviews

import android.content.Intent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.googlesolution.R
import com.example.googlesolution.datamodels.Hospital
import com.example.googlesolution.datamodels.TopHospitals
import com.example.googlesolution.datamodels.hospitals
import com.example.googlesolution.datamodels.topHospitals
import com.example.googlesolution.presentation.bottomviews.BottomNavBarItems
import com.example.googlesolution.ui.theme.*
import com.google.accompanist.flowlayout.FlowRow

@Composable

fun HomeDashboard(
    navController: NavHostController,
) {
    Scaffold (
        modifier = Modifier
            .background(BlueMildest),
            ) {
        padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(BlueMildest)) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 8.dp, end = 16.dp)
                    .height(24.dp)
            ) {
                Text(
                    text = "Hospitals",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                )
                Image(painter = painterResource(id = R.drawable.workspaces),
                    contentDescription = "workspaces"
                )
            }
            OutlinedTextField(
                value = "",
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Gray,
                    unfocusedBorderColor =  Color.LightGray,
                    focusedLabelColor =  Color.Gray,
                    unfocusedLabelColor = Color.Gray,
                    cursorColor = Color.LightGray,
                ),
                onValueChange = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
                    .align(Alignment.CenterHorizontally)
                    .size(55.dp),
                label = {
                    Text(
                        text = "Find Hospital",
                        style = TextStyle(
                            fontWeight = FontWeight.Normal,
                            fontSize = 11.sp
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
            Text(
                text = "Popular",
                style = MaterialTheme.typography.subtitle2,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 8.dp, top = 8.dp, start = 16.dp),
                color = Color.Black,
            )
            LazyRow {
                items(topHospitals) { topHospitals ->
                    TopHospitalsListItem(topHospitals =topHospitals)
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "More",
                style = MaterialTheme.typography.subtitle2,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 8.dp, start = 16.dp),
                color = Color.Black
            )
            FlowRow(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .weight(1f)
                    .padding(4.dp)
                    .border(0.dp, Color.Transparent)
                    .background(Color.White),
            ) {
                hospitals.forEach {
                    HospitalListItem(hospitals = it)
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            BottomNavBarItems(navController = rememberNavController())
        }
    }
}

@Composable
fun HospitalListItem(
    hospitals: Hospital,
) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .padding(all = 4.dp)
            .fillMaxWidth()
            .height(80.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White)
            .border(0.dp, Color.Transparent)

        ,
        elevation = 0.dp
    ) {
        Row(
            modifier = Modifier
                .padding(all = 4.dp)
                .background(Color.White),
        ) {
            Image(
                painter = painterResource(id = hospitals.hospImage),
                contentDescription = "",
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
                    .padding(end = 8.dp)
                    .background(Color.White)
                    .clip(RoundedCornerShape(8.dp, 0.dp, 0.dp,8.dp)),
                contentScale = ContentScale.FillBounds
            )
            Column(

            ) {
                Text(
                    text = hospitals.name,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.W400,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(top = 2.dp),
                    overflow = TextOverflow.Visible,
                )
                Text(
                    hospitals.location,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W300,
                    modifier = Modifier.padding(),
                    color = Color.Gray
                )
                Row(
                    modifier = Modifier
                        .padding(top = 4.dp, start = 24.dp, end = 49.dp)
                        .fillMaxWidth()
                        .background(Color.White),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = {
                            /*TODO*/
                            // allow share via text, email, whatsapp, telegram, etc
                            val intent = Intent(Intent.ACTION_SEND).apply {
                                type = "text/plain"
                                putExtra(Intent.EXTRA_TEXT, "Check out this hospital: ${hospitals.name}")
                            }
                            context.startActivity(intent)
                        },
                        modifier = Modifier
                            .size(15.dp),
                    ) {
                        Icon(
                            imageVector = Icons.Default.Share,
                            contentDescription = "Share",
                            tint = Color.DarkGray
                        )

                    }
                    Text(
                        text = hospitals.contact,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.W500,
                        modifier = Modifier.padding(),
                        color = Color.Gray
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
                            .size(15.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Call,
                            contentDescription = "Call",
                            tint = Color.DarkGray
                        )

                    }
                }

            }

        }
    }
}

@Composable
fun TopHospitalsListItem(
    topHospitals: TopHospitals
) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .padding(start = 8.dp)
            .height(152.dp)
            .width(136.dp)
            .background(Color.White)
            .clip(RoundedCornerShape(8.dp)),
    ) {
        Column(
            modifier = Modifier.padding(0.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(topHospitals.hospImage),
                contentDescription = "hospitals",
                modifier = Modifier
                    .height(104.dp)
                    .width(150.dp)
                    .padding(4.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop

            )
            Text(
                text = topHospitals.hospitalName,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center,
                ),
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .height(20.dp)
                    .padding(start = 4.dp, end = 4.dp)
            )
            Row(
                modifier = Modifier
                    .padding(top=4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
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
                        .size(15.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Call,
                        contentDescription = "Call",
                        tint = Color.Blue
                    )
                }
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = topHospitals.hospitalContacts,
                    style = TextStyle(
                        fontWeight = FontWeight.Light,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center,
                    ),
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeDashboardPreview() {
    HomeDashboard(
        navController = rememberNavController()
    )
}