package com.example.googlesolution.datamodels.firebaseauth.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.googlesolution.ui.theme.GoogleSolutionTheme



@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel? = null,
    onNavToHomePage:() -> Unit,
    onNavToSignUpPage: () -> Unit,
){
    val loginUiState = loginViewModel?.loginUiState
    val isError = loginUiState?.logInError != null
    val context = LocalContext.current



    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
            )
    {
        Text(
            text = "Login",
            style = MaterialTheme.typography.h3,
            color = MaterialTheme.colors.primary
        )
        if (isError) {
            Text(text = loginUiState?.logInError ?: "unknown error",
                color = Color.Red
            )
        }
        OutlinedTextField(
            value = loginUiState?.userName ?: "",
            onValueChange = {
                loginViewModel?.onUserNameChange(it)
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Person,
                    contentDescription = null)
            },
            label = {
                Text(text = "Email")
            },
            isError = isError
        )
        OutlinedTextField(
            value = loginUiState?.password ?: "",
            onValueChange = {
                loginViewModel?.onPasswordNameChange(it)
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Lock,
                    contentDescription = null)
            },
            label = {
                Text(text = "Password")
            },
            visualTransformation = PasswordVisualTransformation(),
            isError = isError
        )
        Button(
            onClick = { 
            /*TODO*/
                loginViewModel?.loginUser(context)
            }
        ) {
            Text(text = "Login")
        }
        Spacer(modifier = Modifier.size(16.dp))
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Don't have an account?")
            Spacer(modifier = Modifier.size(8.dp))
            TextButton(onClick = {
            /*TODO*/
                onNavToSignUpPage.invoke()
            }) {
                Text(text = "Sign Up")
            }
        }

        if (loginUiState?.isLoading == true){
            CircularProgressIndicator()
        }

        LaunchedEffect(key1 = loginViewModel?.hasUser) {
            if (loginViewModel?.hasUser == true) {
                onNavToHomePage.invoke()
            }
        }
    }
}

@Composable
fun SignUpScreen(
    loginViewModel: LoginViewModel? = null,
    onNavToHomePage:() -> Unit,
    onNavToLoginpPage: () -> Unit,
){
    val loginUiState = loginViewModel?.loginUiState
    val isError = loginUiState?.signUpError != null
    val context = LocalContext.current



    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(
            text = "Sign Up",
            style = MaterialTheme.typography.h3,
            color = MaterialTheme.colors.primary
        )
        if (isError) {
            Text(text = loginUiState?.signUpError ?: "unknown error",
                color = Color.Red
            )
        }
        OutlinedTextField(
            value = loginUiState?.userNameSignUp ?: "",
            onValueChange = {
                loginViewModel?.onUserChangeSignUp(it)
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Person,
                    contentDescription = null)
            },
            label = {
                Text(text = "Email")
            },
            isError = isError
        )
        OutlinedTextField(
            value = loginUiState?.passwordSignUp ?: "",
            onValueChange = {
                loginViewModel?.onPasswordChangeSignUp(it)
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Lock,
                    contentDescription = null)
            },
            label = {
                Text(text = "Password")
            },
            visualTransformation = PasswordVisualTransformation(),
            isError = isError
        )
        OutlinedTextField(
            value = loginUiState?.confirmPasswordSignUp ?: "",
            onValueChange = {
                loginViewModel?.onConfirmPasswordChange(it)
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Lock,
                    contentDescription = null)
            },
            label = {
                Text(text = "Confirm Password")
            },
            visualTransformation = PasswordVisualTransformation(),
            isError = isError
        )
        Button(
            onClick = {
                /*TODO*/
                loginViewModel?.createUser(context)
            }
        ) {
            Text(text = "Sign Up")
        }
        Spacer(modifier = Modifier.size(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Already have an Account?")
            Spacer(modifier = Modifier.size(8.dp))
            TextButton(onClick = {
                /*TODO*/
                onNavToLoginpPage.invoke()
            }) {
                Text(text = "Login")
            }
        }

        if (loginUiState?.isLoading == true){
            CircularProgressIndicator()
        }

        LaunchedEffect(key1 = loginViewModel?.hasUser) {
            if (loginViewModel?.hasUser == true) {
                onNavToHomePage.invoke()
            }
        }

    }
}


@Preview(showSystemUi = true)
@Composable
fun PreLoginSCreen(){
    GoogleSolutionTheme() {
        LoginScreen(onNavToHomePage = { /*TODO*/ }) {
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreSignUpSCreen(){
    GoogleSolutionTheme() {
        SignUpScreen(onNavToHomePage = { /*TODO*/ }) {
        }
    }
}