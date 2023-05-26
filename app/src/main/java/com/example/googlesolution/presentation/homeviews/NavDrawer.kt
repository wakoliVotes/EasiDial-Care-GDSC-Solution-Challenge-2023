package com.example.googlesolution.presentation.homeviews

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
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
        modifier = Modifier
            .fillMaxHeight()
            .width(400.dp)
            .verticalScroll(rememberScrollState()),

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
    iconSize: Dp = 28.dp,
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
        shape = RoundedCornerShape(8.dp),
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
                Modifier
                    .padding(start = 8.dp)
                    .size(iconSize)
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
    Column {

        Text(
            text = "EasiDial Care",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 16.dp)
                .alpha(0.8f),
        )
        Text(
            text = "Here to help you",
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier
                .padding(start = 16.dp, bottom = 16.dp)
                .alpha(0.5f),
        )

        NavListItem(
            navController = navController,
            route = Screens.ProfilePage.route,
            icon = R.drawable.outline_account_circle_24,
            label = "Profile"
        )
        NavListItem(
            navController = navController,
            route = Screens.MedicalInformationPage.route,
            icon = R.drawable.outline_medical_information_24,
            label = "Medical Information"
        )
        NavListItem(
            navController = navController,
            route = Screens.EmergencyButtonPage.route,
            icon = R.drawable.outline_emergency_24,
            label = "Emergency Button"
        )
        NavListItem(
            navController = navController,
            route = Screens.FeedbackPage.route,
            icon = R.drawable.outline_feedback_24,
            label = "Feedback"
        )
        NavListItem(
            navController = navController,
            route = Screens.AboutUsPage.route,
            icon = R.drawable.outline_info_24,
            label = "About Us"
        )

    }
}

@Preview
@Composable
fun NavBodyPrev() {
    NavBody(rememberNavController())
}