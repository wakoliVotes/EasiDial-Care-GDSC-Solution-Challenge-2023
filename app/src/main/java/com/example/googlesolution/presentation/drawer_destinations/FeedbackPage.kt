package com.example.googlesolution.presentation.drawer_destinations

import android.annotation.SuppressLint
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.googlesolution.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun FeedbackPage(navController: NavController) {

    Scaffold(topBar = {
        TopAppBar(
            navigationIcon = {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.round_arrow_back_ios_new_24),
                        contentDescription = "Back"
                    )
                }
            },
            title = {
                Text(text = "Feedback")
            }
        )
    }) {
// TODO: Add Feedback content here:
    }
}

@Preview
@Composable
fun FeedbackPagePrev() {
    FeedbackPage(rememberNavController())
}