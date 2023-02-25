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
import com.example.googlesolution.ui.theme.White

// Create a screens containing image, description text and a button to navigate to the next screen
// Fillmaxsize is used to fill the entire screen
// background color is set to blue
// Image is placed at the top of the screen
// Text is placed in the center of the screen
// Button is placed at the bottom of the screen
// text color is set to white


@Composable
fun OnBoardScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                bitmap = ImageBitmap.imageResource(id = R.drawable.hospital),
                contentDescription = null,
                modifier = Modifier
                    .width(300.dp)
                    .height(300.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop

            )

            Text(
                text = "Find a Hospital near you",
                style = MaterialTheme.typography.h2,
                color = MaterialTheme.colors.onPrimary,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            Spacer(modifier = Modifier.height(30.dp))
            Button(
                onClick = {
                    navController.navigate("signIn")
                },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(50.dp),
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Black,
                    contentColor = MaterialTheme.colors.onSecondary
                )
            ) {
                Text(
                    text = "Go",
                    style = MaterialTheme.typography.h5,
                    color = White,
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






