package com.example.googlesolution.presentation.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
fun OnBoardScreen(
    image: ImageBitmap,
    description: String,
    onButtonClick: () -> Unit,
    isLastScreen: Boolean = false
) {
    var visible by remember { mutableStateOf(false) }
    val alpha by animateFloatAsState(
        targetValue = if (visible) 1f else 0f,
        animationSpec = tween(1000)
    )
    LaunchedEffect(key1 = true) {
        visible = true
    }
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
                bitmap = image,
                contentDescription = null,
                modifier = Modifier
                    .width(300.dp)
                    .height(300.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop

            )
            AnimatedVisibility(
                visible = visible,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Text(
                    text = description,
                    style = MaterialTheme.typography.h2,
                    color = MaterialTheme.colors.onPrimary,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Button(
                onClick = onButtonClick,
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
                    text = if (isLastScreen) "Get Started" else "Go",
                    style = MaterialTheme.typography.h6,
                    color = White
                )
                if (isLastScreen) {
                    Icon(
                        imageVector = Icons.Default.Done,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 8.dp)
                    )
                } else {
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 20.dp),
                        tint = White
                    )
                }
            }
        }
    }
}
}


// Create preview for the OnBoardScreen
@Preview
@Composable
fun OnBoardScreenPreview() {
    OnBoardScreen(
        image = ImageBitmap.imageResource(id = R.drawable.hospital),
        description = "Find a Hospital near you",
        onButtonClick = { },
        isLastScreen = false
    )
}






