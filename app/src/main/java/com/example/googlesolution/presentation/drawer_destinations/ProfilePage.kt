package com.example.googlesolution.presentation.drawer_destinations

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.googlesolution.R
import com.example.googlesolution.datalayer.firestore.DataViewModel
import com.example.googlesolution.navgraph.Screens
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfilePage(
    navController: NavController,
    dataViewModel: DataViewModel = viewModel(),
) {

    val userData = dataViewModel.state.value

    fun signOut() {
        Firebase.auth.signOut()
        navController.navigate(Screens.SignIn.route) {
            launchSingleTop = true
            popUpTo(route = Screens.MainScreen.route) {
                inclusive = true
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.surface,
                contentColor = MaterialTheme.colors.onSurface,
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.round_arrow_back_ios_new_24),
                            contentDescription = "Back"
                        )
                    }
                },
                title = {
                    Text(text = "Profile")
                },
                actions = {
                    IconButton(onClick = {
                        navController.navigate(Screens.MedicalInformationPage.route) {
                            launchSingleTop = true
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "Edit"
                        )
                    }
                }
            )
        }) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colors.background)
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(CircleShape),
                contentAlignment = Alignment.Center,
            ) {
                // TODO: show user profile image
                Image(
                    painter = painterResource(id = R.drawable.easidial_logo1),
                    contentDescription = null,
                    modifier = Modifier
                        .size(160.dp)
                        .background(Color.Black, CircleShape)
                        .clip(CircleShape),
                    contentScale = ContentScale.Fit
                )
            }
            BodyListItem(
                icon = R.drawable.outline_account_circle_24,
                label = userData.fullName,
            )
            BodyListItem(
                icon = R.drawable.email,
                label = userData.id,
            )
            BodyListItem(
                icon = R.drawable.outline_phone_24,
                label = userData.phone,
            )
            Card(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp)
                    .fillMaxWidth()
                    .clickable {
                        signOut()
                    },
                shape = RoundedCornerShape(8.dp),
                backgroundColor = MaterialTheme.colors.surface
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.outline_logout_24),
                        contentDescription = null,
                        Modifier.size(32.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = buildString {
                        append("Log Out")
                    }, fontSize = 18.sp)
                }
            }
            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}

@Preview
@Composable
fun ProfilePagePrev() {
    ProfilePage(rememberNavController())
}

@Composable
fun BodyListItem(
    icon: Int,
    iconSize: Dp = 32.dp,
    label: String,
    labelSize: TextUnit = 18.sp,
) {
    Card(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.padding(16.dp)
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                Modifier.size(iconSize)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = buildString {
                append(label)
            }, fontSize = labelSize)
        }
    }
}

@Preview
@Composable
fun BodyListItemPrev() {
    BodyListItem(
        icon = R.drawable.outline_account_circle_24,
        label = "Account"
    )
}