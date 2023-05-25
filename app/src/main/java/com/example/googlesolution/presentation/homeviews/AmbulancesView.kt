package com.example.googlesolution.presentation.homeviews

import android.content.Intent
import androidx.compose.animation.core.animateFloatAsState
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
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
import com.example.googlesolution.datalayer.screensviewmodels.Ambulances
import com.example.googlesolution.datalayer.screensviewmodels.AmbulancesViewModel
import com.example.googlesolution.datalayer.screensviewmodels.TopAmbulances
import com.example.googlesolution.datalayer.screensviewmodels.topAmbulances
import com.example.googlesolution.ui.theme.lightGreener
import com.google.accompanist.flowlayout.FlowRow

@Composable

fun AmbulancesView(
    navController: NavHostController,
) {

    val viewModel = viewModel<AmbulancesViewModel>()
    val searchText by viewModel.searchText.collectAsState()
    val ambulances by viewModel.ambulances.collectAsState()
    val isSearching by viewModel.isSearching.collectAsState()

    var isExpandedState by remember {
        mutableStateOf(false)
    }
    val rotationState by animateFloatAsState(
        targetValue = if (isExpandedState) 180f else 0f
    )

    MaterialTheme() {

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
                Column {
                    Text(
                        text = "Ambulances", style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 28.sp,
                        ), modifier = Modifier.padding(start = 16.dp)
                    )
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                    ) {
                        TextButton(onClick = { isExpandedState = !isExpandedState }) {
                            Text(
                                text = "Popular",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        }
                        IconButton(
                            onClick = { isExpandedState = !isExpandedState },
                            modifier = Modifier
                                .rotate(rotationState),
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = if (isExpandedState) "Collapse" else "Expand",
                                modifier = Modifier.size(42.dp),
                            )
                        }
                    }
                    if (isExpandedState)
                        LazyRow(modifier = Modifier.padding(bottom = 24.dp)) {
                            items(topAmbulances) { topAmbulances ->
                                TopAmbulanceList(topAmbulances = topAmbulances)
                            }
                        }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
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
                    color = Color.Black
                ),
                label = {
                    Text(
                        text = "Search", style = TextStyle(
                            fontWeight = FontWeight.Normal, fontSize = 16.sp
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

@Composable
fun AmbulancesListItem(
    ambulances: Ambulances,
) {
    val context = LocalContext.current

    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(4.dp)
            .width(184.dp)
            .height(174.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(all = 8.dp)
                .clip(RoundedCornerShape(16.dp)),
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
                modifier = Modifier.padding(bottom = 2.dp),
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
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {
                        /*TODO - Share as Plain Text */
                        val intent = Intent(Intent.ACTION_SEND).apply {
                            type = "text/plain"
                            putExtra(
                                Intent.EXTRA_TEXT,
                                "Check out ${ambulances.name}, ${ambulances.contact}"
                            )
                        }
                        context.startActivity(intent)
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
                        modifier = Modifier.padding(5.dp)
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
                        modifier = Modifier.padding(5.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun TopAmbulanceList(
    topAmbulances: TopAmbulances,
) {
    val context = LocalContext.current

    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(start = 8.dp)
            .height(200.dp)
            .width(170.dp)
    ) {
        Column(
            modifier = Modifier
//                .background(lightGreenest)
                .padding(0.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(topAmbulances.ambImage),
                contentDescription = "ambulances",
                modifier = Modifier
                    .height(120.dp)
                    .fillMaxWidth()
                    .padding(start = 8.dp, top = 8.dp, end = 8.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Text(
                text = topAmbulances.name, style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center,
                ), overflow = TextOverflow.Visible, modifier = Modifier.height(24.dp)
            )
            Row(
                modifier = Modifier.padding(top = 16.dp),
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
                        modifier = Modifier.padding(5.dp)
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