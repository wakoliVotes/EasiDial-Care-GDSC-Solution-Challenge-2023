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
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
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
import com.example.googlesolution.datalayer.*
import com.example.googlesolution.ui.theme.BlueMildest
import com.example.googlesolution.ui.theme.lightGreener
import com.example.googlesolution.ui.theme.lightGreenest
import com.google.accompanist.flowlayout.FlowRow

@Composable

fun AmbulancesView(
    navController: NavHostController,
) {

    val viewModel = viewModel<AmbulancesViewModel>()
    val searchText by viewModel.searchText.collectAsState()
    val ambulances by viewModel.ambulances.collectAsState()
    val isSearching by viewModel.isSearching.collectAsState()

MaterialTheme() {
    Scaffold {
            padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(BlueMildest)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 20.dp, end = 16.dp)
                    .height(36.dp)
            ) {
                Text(
                    text = "Ambulances",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                )
                Image(
                    painter = painterResource(id = R.drawable.person),
                    contentDescription = "workspaces",
                    modifier = Modifier
                        .clickable {
                            // navigate to pesonssearch
                            navController.navigate("account")
                        }
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Popular",
                style = MaterialTheme.typography.subtitle2,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 8.dp, top = 4.dp, start = 16.dp),
                color = Color.Black
            )
            LazyRow {
                items(topAmbulances) { topAmbulances ->
                    TopAmbulanceList(topAmbulances = topAmbulances)
                }
            }
            Text(
                text = "More",
                style = MaterialTheme.typography.subtitle2,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                modifier = Modifier
                    .padding(top = 4.dp, bottom = 2.dp, start = 16.dp)
            )
            OutlinedTextField(
                value = searchText,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.DarkGray,
                    unfocusedBorderColor =  Color.LightGray,
                    focusedLabelColor =  Color.DarkGray,
                    unfocusedLabelColor = Color.LightGray,
                    cursorColor = Color.DarkGray
                ),
                onValueChange = { /*TODO*/
                    viewModel.onSearchTermChange(it)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp, bottom=4.dp)
                    .align(Alignment.CenterHorizontally)
                    .size(55.dp),
                textStyle = TextStyle(
                    color = Color.Black
                ),
                label = {
                    Text(
                        text = "Find Ambulance",
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
                        tint = Color.DarkGray
                    )
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                ),

                )
            FlowRow(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .weight(1f)
                    .padding(4.dp)
            ) {
                ambulances.forEach {
                    AmbulancesListItem(ambulances = it)
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
}

@Composable
fun AmbulancesListItem(
    ambulances: Ambulances,
) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .padding(4.dp)
            .width(184.dp)
            .height(174.dp)
            .clip(RoundedCornerShape(16.dp)),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier
                .padding(all = 8.dp)
                .background(lightGreenest)
                .clip(RoundedCornerShape(16.dp))
            ,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = ambulances.ambImage),
                contentDescription = "",
                modifier = Modifier
                    .height(70.dp)
                    .width(70.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Text(
                text = ambulances.name,
                fontSize = 15.sp,
                fontWeight = FontWeight.W500,
                modifier = Modifier
                    .padding(bottom = 2.dp),
                overflow = TextOverflow.Visible
            )
            Text(
                text = ambulances.contact,
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(),
                color = Color.Gray
            )
            Row(
                modifier = Modifier
                    .padding(top = 4.dp, end = 4.dp, start = 4.dp, bottom = 4.dp)
                    .fillMaxWidth()                ,
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {
                              /*TODO - Share as Plain Text */
                              val intent = Intent(Intent.ACTION_SEND).apply {
                                  type = "text/plain"
                                  putExtra(Intent.EXTRA_TEXT, "Check out ${ambulances.name}, ${ambulances.contact}")
                              }
                              },
                    modifier = Modifier
                        .size(28.dp)
                        .background(Color.Black, CircleShape)
                        .clip(CircleShape)
                        .padding(),
                ) {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = "Share",
                        tint = lightGreener,
                        modifier = Modifier
                            .padding(5.dp)
                    )
                }
                IconButton(
                    onClick = {
                              /*TODO - Open Dialer */
                        val intent = Intent(Intent.ACTION_DIAL).apply {
                            data = "tel:${ambulances.contact}".toUri()
                        }
                        context.startActivity(intent)
                              },
                    modifier = Modifier
                        .size(28.dp)
                        .background(lightGreener, CircleShape)
                        .clip(CircleShape)
                        .padding(),
                ) {
                    Icon(
                        imageVector = Icons.Default.Call,
                        contentDescription = "Call",
                        tint = Color.White,
                        modifier = Modifier
                            .padding(5.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun TopAmbulanceList(
    topAmbulances: TopAmbulances
) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .padding(start = 8.dp)
            .height(200.dp)
            .width(170.dp)
            .clip(RoundedCornerShape(8.dp)),
    ) {
        Column(
            modifier = Modifier
                .background(lightGreenest)
                .padding(0.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(topAmbulances.ambImage),
                contentDescription = "ambulances",
                modifier = Modifier
                    .height(120.dp)
                    .fillMaxWidth()
                    .padding(start=8.dp,top=8.dp,end=8.dp)
                    .clip(RoundedCornerShape(8.dp))
                ,
                contentScale = ContentScale.Crop
            )
            Text(
                text = topAmbulances.name,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center,
                ),
                overflow = TextOverflow.Visible,
                modifier = Modifier.height(24.dp)
            )
            Row(
                modifier = Modifier
                    .padding(top=16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                IconButton(
                    onClick = {
                        /* TODO - Open Dialer */
                        val intent = Intent(Intent.ACTION_DIAL).apply {
                            data = "tel:${topAmbulances.contact}".toUri()
                        }
                        context.startActivity(intent)

                    },
                    modifier = Modifier
                        .size(28.dp)
                        .background(lightGreener, CircleShape)
                        .clip(CircleShape)
                        .padding(),
                ) {
                    Icon(
                        imageVector = Icons.Default.Call,
                        contentDescription = "Call",
                        tint = Color.White,
                        modifier = Modifier
                            .padding(5.dp)
                    )
                }
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = topAmbulances.contact,
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

@Preview
@Composable
fun AmbulancePreview() {
    AmbulancesView(
        navController = rememberNavController()
    )
}