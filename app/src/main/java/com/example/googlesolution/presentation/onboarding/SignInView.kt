package com.example.googlesolution.presentation.onboarding

// Create composable function for SignUpView and add modifier to fill the entire screen with OutlinedTextField for email and password and trailing icons for email and password
// Add modifier to fill the entire screen with OutlinedTextField for email and password and trailing icons for email and password
// Add section for sign up button, not signed up yet text and sign in text and forgot password

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.googlesolution.R
import com.example.googlesolution.R.string.*

@Composable
fun SignUpView(
    modifier: Modifier = Modifier,
    onSignUp: () -> Unit,
    onSignIn: () -> Unit,
    onForgotPassword: () -> Unit,
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
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
            label = { Text(text = stringResource(id = R.string.email)) },
            leadingIcon = { Icon(imageVector = Icons.Filled.Email, contentDescription = null) },
            modifier = Modifier.fillMaxWidth(),
            // add trailing icon for email using Icons.Filled.Check
            // Use Icons.Default.Check to add trailing icon for email
            trailingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = null,
                    )
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
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
        Spacer(modifier = Modifier.height(20.dp))
        TextButton(
            onClick = onForgotPassword,
            modifier = Modifier.align(End),
        ) {
            Text(
                text = stringResource(id = forgot_password),
                color = Color.Black,
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        Button(
            onClick = onSignUp,
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
                text = stringResource(id = sign_in),
                modifier = Modifier.padding(5.dp),
            )
        }

        Spacer(modifier = Modifier.height(100.dp))
        Text(
            text = stringResource(id = not_signed_up_yet),
            modifier = Modifier.align(End),
        )
        TextButton(
            onClick = onSignIn,
            modifier = Modifier.align(End),
        ) {
            Text(
                text = stringResource(id = sign_up),
                color = Color.Black,
            )
        }
    }
}

// Add Preview for SignUpView
@Preview(showBackground = true)
@Composable
fun SignUpViewPreview() {
    SignUpView(
        onSignUp = {},
        onSignIn = {},
        onForgotPassword = {}
    )
}