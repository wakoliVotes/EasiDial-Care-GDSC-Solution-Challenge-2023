package com.example.googlesolution.presentation.homeviews

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.googlesolution.R
import com.example.googlesolution.datalayer.firebaseauth.login.LoginViewModel
import com.example.googlesolution.ui.theme.GoogleSolutionTheme

@Composable
fun AccountView(
    navController: NavHostController,
    loginViewModel: LoginViewModel,
){
    val loginUiState = loginViewModel.loginUiState

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    )
    {
        Column(modifier = Modifier.padding(10.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Account",
                    style = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.W800,
                        fontSize = 24.sp,
                        fontFamily = FontFamily.Monospace
                    ),
                    modifier = Modifier
                        .padding(15.dp)
                )
            }
            // Owner information
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            )
            {
                Image(
                    modifier = Modifier
                        .padding(10.dp)
                        .width(100.dp)
//                .height(80.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    painter = painterResource(id = R.drawable.owner),
                    contentDescription = "owner image"
                )
                Box(
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp),

                    ) {
                    Column {
                        Text(
                            text = "Lively Danielle",
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                        )
                        Text(
                            text = "danielle@gmail.com",
                            style = TextStyle(
                                fontWeight = FontWeight.ExtraLight,
                                fontSize = 14.sp,
                                color = Color.Red
                            ),
                            modifier = Modifier.padding(top = 5.dp)
                        )
                        // click to sign out
                        ClickableText(
                            text = AnnotatedString(
                                "Logout"
                            ) ,
                            onClick = { /*TODO*/}
                        )
                    }
                }
            }
            // General information
            Box(
                modifier = Modifier.padding(start = 10.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Text(
                        text = "General",
                        style = TextStyle(
                            fontWeight = FontWeight.ExtraLight,
                            fontSize = 16.sp
                        ),
                        modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
                    )
                    Text(
                        text = "Ratings & Review",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        ),
                        modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
                    )
                    // Divider line
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(Color.LightGray)
                    )

                    Text(
                        text = "Customer Support",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        ),
                        modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
                    )
                    // Divider line
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(Color.LightGray)
                    )
                    Text(
                        text = "Help & Feedback",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        ),
                        modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
                    )
                    // Divider line
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(Color.LightGray)
                    )
                    Text(
                        text = "About",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        ),
                        modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
                    )
                    // Divider line
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(Color.LightGray)
                    )
                }
            }
            // Extra information
            Box(
                modifier = Modifier.padding(start = 10.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Text(
                        text = "General",
                        style = TextStyle(
                            fontWeight = FontWeight.ExtraLight,
                            fontSize = 16.sp
                        ),
                        modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
                    )
                    Text(
                        text = "Ratings & Review",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        ),
                        modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
                    )
                    // Divider line
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(Color.LightGray)
                    )

                    Text(
                        text = "Customer Support",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        ),
                        modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
                    )
                    // Divider line
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(Color.LightGray)
                    )
                    Text(
                        text = "Help & Feedback",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        ),
                        modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
                    )
                    // Divider line
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(Color.LightGray)
                    )
                    Text(
                        text = "About",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        ),
                        modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
                    )
                    // Divider line
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(Color.LightGray)
                    )
                }
            }
        }
    }
}



@Preview
@Composable
private fun PreviewAccountView() {
    GoogleSolutionTheme() {
        AccountView( navController = rememberNavController(), loginViewModel = LoginViewModel())
    }
}