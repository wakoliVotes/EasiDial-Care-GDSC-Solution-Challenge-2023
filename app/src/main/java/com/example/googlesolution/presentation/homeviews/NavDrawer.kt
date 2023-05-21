package com.example.googlesolution.presentation.homeviews

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.googlesolution.R
import com.example.googlesolution.navgraph.Screens

// TODO: Hoist states in nav drawer Composables

@Composable
fun NavDrawer(navController: NavController) {


    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize(),

        ) {
        Spacer(modifier = Modifier.height(40.dp))
        NavHeader()
        Spacer(modifier = Modifier.height(20.dp))
        NavBody(navController = navController)
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun NavDrawerPrev() {
    NavDrawer(rememberNavController())
}

@Composable
fun NavHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(CircleShape),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            painter = painterResource(id = R.drawable.easidial_logo1),
            contentDescription = null,
            modifier = Modifier
                .size(160.dp)
                .padding(1.dp)
                .background(Color.Black, CircleShape)
                .clip(CircleShape),
            contentScale = ContentScale.Fit
        )
    }
}

@Preview
@Composable
fun NavHeaderPrev() {
    NavHeader()
}

@Composable
fun NavListItem(
    navController: NavController,
    route: String,
    icon: Int,
    iconSize: Dp = 32.dp,
    label: String,
    labelSize: TextUnit = 18.sp,
) {
    Card(
        modifier = Modifier
            .padding(top = 4.dp, bottom = 8.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .clickable {
                navController.navigate(route) {
                    launchSingleTop = true
                }
            },
        shape = RoundedCornerShape(16.dp),
        backgroundColor = MaterialTheme.colors.secondary
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.padding(8.dp)
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
fun NavListItemPrev() {
    NavListItem(
        navController = rememberNavController(),
        route = Screens.ProfilePage.route,
        icon = R.drawable.outline_account_circle_24,
        label = "Account"
    )
}

@Composable
fun NavBody(navController: NavController) {
    LazyColumn {
        item {
            NavListItem(
                navController = navController,
                route = Screens.ProfilePage.route,
                icon = R.drawable.outline_account_circle_24,
                label = "Profile"
            )
        }
        item {
            NavListItem(
                navController = navController,
                route = Screens.MedicalInformationPage.route,
                icon = R.drawable.outline_medical_information_24,
                label = "Medical Information"
            )
        }
        item {
            NavListItem(
                navController = navController,
                route = Screens.EmergencyButtonPage.route,
                icon = R.drawable.outline_emergency_24,
                label = "Emergency Button"
            )
        }
        item {
            NavListItem(
                navController = navController,
                route = Screens.FeedbackPage.route,
                icon = R.drawable.outline_feedback_24,
                label = "Feedback"
            )
        }
        item {
            NavListItem(
                navController = navController,
                route = Screens.AboutUsPage.route,
                icon = R.drawable.outline_info_24,
                label = "About Us"
            )
        }
    }
}

@Preview
@Composable
fun NavBodyPrev() {
    NavBody(rememberNavController())
}