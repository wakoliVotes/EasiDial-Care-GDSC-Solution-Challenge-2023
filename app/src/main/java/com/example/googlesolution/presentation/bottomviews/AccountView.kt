package com.example.kcauvibe.presentation.bottomviews

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.googlesolution.R

@Composable
fun AccountView(
    navController: NavHostController
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    )
    {
        Column(modifier = Modifier.padding(10.dp)) {
            OwnerInfo()
            Spacer(modifier = Modifier.height(10.dp))
            GeneralInfo()
            Spacer(modifier = Modifier.height(10.dp))
            MoreInfo()

        }

    }
}

@Preview
@Composable
private fun OwnerInfo() {
    Column() {
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
                    text = "danielle@yahoo.com",
                    style = TextStyle(
                        fontWeight = FontWeight.ExtraLight,
                        fontSize = 14.sp
                    ),
                    modifier = Modifier.padding(top = 5.dp)
                )
            }
        }
    }
}
}


@Preview
@Composable
private fun GeneralInfo() {
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

@Preview
@Composable
private fun MoreInfo() {
    Box(
        modifier = Modifier.padding(start = 10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                text = "More",
                style = TextStyle(
                    fontWeight = FontWeight.ExtraLight,
                    fontSize = 16.sp
                ),
                modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
            )
            Text(
                text = "Privacy Policy",
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
                text = "Terms of Use",
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
                text = "Settings",
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
                text = "Logout",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                ),
                modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
            )
        }
    }
}