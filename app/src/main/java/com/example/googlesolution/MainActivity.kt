package com.example.googlesolution

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.googlesolution.datalayer.firebaseauth.login.LoginViewModel
import com.example.googlesolution.navgraph.NavGraph
import com.example.googlesolution.ui.theme.BlueMildest
import com.example.googlesolution.ui.theme.GoogleSolutionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val loginViewModel = viewModel(modelClass = LoginViewModel::class.java)

            GoogleSolutionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(BlueMildest)
                ) {
                    NavGraph(loginViewModel = loginViewModel)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GoogleSolutionTheme {
        NavGraph(loginViewModel = LoginViewModel())
    }
}