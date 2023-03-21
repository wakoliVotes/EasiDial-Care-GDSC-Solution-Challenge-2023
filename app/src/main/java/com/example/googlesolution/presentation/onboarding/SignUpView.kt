package com.example.googlesolution.presentation.onboarding


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.googlesolution.R
import com.example.googlesolution.R.string.*
import com.example.googlesolution.ui.theme.BlueMildest
import java.time.format.TextStyle

@Composable
fun SignInView(
    modifier: Modifier = Modifier,
//    TODO - Add onSignUp, onSignIn and onForgotPassword parameters
//    onSignUp: () -> Unit,
//    onSignIn: () -> Unit,
//    onForgotPassword: () -> Unit,
    navController: NavHostController
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(36.dp)
            .background(BlueMildest)
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Logo image section and app name
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .padding(bottom = 16.dp)
        )
        Text(
            text = stringResource(id = app_name),
            style = MaterialTheme.typography.h4
        )
        Spacer(modifier = Modifier.height(100.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.DarkGray,
                unfocusedBorderColor =  Color.LightGray,
                focusedLabelColor =  Color.DarkGray,
                unfocusedLabelColor = Color.LightGray,
                cursorColor = Color.DarkGray,
            ),
            label = { Text(text = stringResource(id = R.string.email)) },
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Email,
                    contentDescription = null)
                          },
            trailingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = null,
                    )
                }
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.DarkGray,
                unfocusedBorderColor =  Color.LightGray,
                focusedLabelColor =  Color.DarkGray,
                unfocusedLabelColor = Color.LightGray,
                cursorColor = Color.DarkGray,
            ),
            label = { Text(text = stringResource(id = R.string.password)) },
            leadingIcon = { Icon(imageVector = Icons.Filled.Lock, contentDescription = null) },
            trailingIcon = {
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    // User painter resource to add visibility icon
                    Image(
                        painter = painterResource(id = if (passwordVisibility) R.drawable.visibility else R.drawable.visibility_off),
                        contentDescription = null,
                    )
                }
            },
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        // Add section for confirm password with OutlinedTextField
        // Add modifier to fill the entire screen with OutlinedTextField for email and password and trailing icons for email and password
        // Add trailing icon of visibility confirm password and leading icon for password

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.DarkGray,
                unfocusedBorderColor =  Color.LightGray,
                focusedLabelColor =  Color.DarkGray,
                unfocusedLabelColor = Color.LightGray,
                cursorColor = Color.DarkGray,
            ),
            label = { Text(text = stringResource(id = R.string.confirm_password)) },
            leadingIcon = { Icon(imageVector = Icons.Filled.Lock, contentDescription = null) },
            trailingIcon = {
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    // User painter resource to add visibility icon
                    Image(
                        painter = painterResource(id = if (passwordVisibility) R.drawable.visibility else R.drawable.visibility_off),
                        contentDescription = null
                    )
                }
            },
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(40.dp))
        Button(
            onClick = {
                navController.navigate("home")
                      },
            shape = RoundedCornerShape(8),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Black,
                contentColor = Color.White
            )
        ) {
            Text(
                text = stringResource(id = sign_up),
                modifier = Modifier.padding(5.dp)
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = stringResource(id = have_account))
            TextButton(
                onClick = {
                    navController.navigate("sign_in")
                },
            ) {
                Text(
                    text = stringResource(id = R.string.sign_in),
                    style = androidx.compose.ui.text.TextStyle(
                        color = Color.Black,
                        fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                        fontSize = MaterialTheme.typography.body1.fontSize
                    )
                )
            }
        }
        // add skip button, align start and add padding
        TextButton(
            onClick = {
                navController.navigate("home")
            },
            modifier = Modifier
                .align(Alignment.Start)
                .padding(4.dp)
                .width(80.dp)
                .background(Color.Black, RoundedCornerShape(8)),
        ) {
            Text(
                text = "Skip",
                color = Color.White,
            )
        }
    }
}



// Add Preview for SignUpView
@Preview(showBackground = true)
@Composable
fun SignInViewPreview() {
    SignInView(
        navController = rememberNavController()
    )
}
