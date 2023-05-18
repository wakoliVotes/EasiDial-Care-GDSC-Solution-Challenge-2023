package com.example.googlesolution.presentation.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.googlesolution.R
import com.example.googlesolution.navgraph.Screens
import com.example.googlesolution.ui.theme.White
import com.example.googlesolution.ui.theme.lightGreen

//TODO:
// Create a screens containing image, description text and a button to navigate to the next screen
// Fillmaxsize is used to fill the entire screen
// background color is set to blue
// Image is placed at the top of the screen
// Text is placed in the center of the screen
// Button is placed at the bottom of the screen
// text color is set to white

/**
This screen is not the start route once user signs in, this is checked at the nav graph.
*/

@Composable
fun OnBoardScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(lightGreen)
    ) {
        Image(
            bitmap = ImageBitmap.imageResource(id = R.drawable.hospital),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 100.dp, start = 40.dp)
                .width(200.dp)
                .height(200.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop

        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                bitmap = ImageBitmap.imageResource(id = R.drawable.emergency_banner),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 100.dp, top = 40.dp)
                    .width(200.dp)
                    .height(200.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Text(
                text = "Find a Hospital near you",
                style = MaterialTheme.typography.h2,
                color = MaterialTheme.colors.onSecondary,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
                    // on navigation to the SignIn screen, pop the backstack
                    navController.navigate(Screens.SignIn.route){
                        launchSingleTop = true
                        popUpTo(route = Screens.OnBoarding.route) {
                            inclusive = true
                        }
                    }
                },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(50.dp),
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.onBackground,
                    contentColor = MaterialTheme.colors.onSecondary
                )
            ) {
                Text(
                    text = "Go",
                    style = MaterialTheme.typography.h5,
                    color = MaterialTheme.colors.onPrimary,
                    fontWeight = FontWeight.ExtraBold
                )
            }

        }
    }
}


// Create preview for the OnBoardScreen
@Preview
@Composable
fun OnBoardScreenPreview() {
    OnBoardScreen(navController = rememberNavController())
}






