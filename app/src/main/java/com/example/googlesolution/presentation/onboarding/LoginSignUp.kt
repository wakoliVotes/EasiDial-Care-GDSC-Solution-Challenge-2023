package com.example.googlesolution.presentation.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.googlesolution.R
import com.example.googlesolution.datalayer.firebaseauth.login.LoginViewModel
import com.example.googlesolution.ui.theme.GoogleSolutionTheme
import com.example.googlesolution.ui.theme.lightGreener


@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel? = null,
    onNavToHomePage: () -> Unit,
    onNavToSignUpPge: () -> Unit,
) {
    val loginUiState = loginViewModel?.loginUiState
    val isError = loginUiState?.logInError != null
    val context = LocalContext.current
    val primaryColor = MaterialTheme.colors.primary

    // Visibility
    var passwordVisibility by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    )
    {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.3f)
                .clip(RoundedCornerShape(0.dp, 0.dp, 200.dp, 200.dp))
                .background(lightGreener),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            // Logo image section and app name
            Image(
                painter = painterResource(id = R.drawable.easidial_logo1),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .padding(1.dp)
                    .background(Color.Black, CircleShape)
                    .clip(CircleShape),
                contentScale = ContentScale.Fit
            )
            Text(
                text = "EasiDialCare",
                style = MaterialTheme.typography.h4,
                color = MaterialTheme.colors.onPrimary,
                modifier = Modifier
                    .padding(top = 4.dp)
            )
        }
        Spacer(modifier = Modifier.height(80.dp))
        Text(
            text = "Login",
            style = MaterialTheme.typography.h5,
            // Commented this color property, it's not changed on dark theme
//            color = MaterialTheme.colors.onSecondary
        )
        if (isError) {
            Text(
                text = loginUiState?.logInError ?: "unknown error",
                color = MaterialTheme.colors.error,
                modifier = Modifier.padding(16.dp)
            )
        }
        OutlinedTextField(
            value = loginUiState?.userName ?: "",
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.DarkGray,
                unfocusedBorderColor = Color.LightGray,
                focusedLabelColor = Color.DarkGray,
                unfocusedLabelColor = Color.LightGray,
                cursorColor = Color.DarkGray,
                textColor = primaryColor,
            ),
            onValueChange = {
                loginViewModel?.onUserNameChange(it)
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    tint = primaryColor
                )
            },
            label = {
                Text(text = "Email", color = primaryColor)
            },
            isError = isError,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Email
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
        )
        OutlinedTextField(
            value = loginUiState?.password ?: "",
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.DarkGray,
                unfocusedBorderColor = Color.LightGray,
                focusedLabelColor = Color.DarkGray,
                unfocusedLabelColor = Color.LightGray,
                cursorColor = Color.DarkGray,
                textColor = primaryColor,
            ),
            onValueChange = {
                loginViewModel?.onPasswordNameChange(it)
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = null,
                    tint = primaryColor
                )
            },
            trailingIcon = {
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    // User painter resource to add visibility icon
                    Icon(
                        painter = painterResource(id = if (passwordVisibility) R.drawable.visibility else R.drawable.visibility_off),
                        contentDescription = null,
                        tint = primaryColor
                    )
                }
            },
            label = {
                Text(text = "Password", color = primaryColor)
            },
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            isError = isError,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password
            ),
            keyboardActions = KeyboardActions(onDone = { loginViewModel?.loginUser(context) }),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
        )
        Spacer(modifier = Modifier.height(28.dp))
        Button(
            onClick = {
                /*TODO*/
                loginViewModel?.loginUser(context)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = lightGreener,
                contentColor = MaterialTheme.colors.onSecondary,
            ),
            shape = MaterialTheme.shapes.medium,
        ) {
            if (loginUiState?.isLoading == true) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(28.dp),
                    strokeWidth = 4.dp,
                    color = colorResource(id = R.color.black)
                )
            } else {
                Text(
                    text = "Login",
                    modifier = Modifier.padding(5.dp),
                    style = MaterialTheme.typography.button,
                    fontWeight = FontWeight.ExtraBold,
                )
            }
        }
        Spacer(modifier = Modifier.size(16.dp))

        Row(
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Don't have an account?",
//                color = MaterialTheme.colors.onSecondary  // Dark theme*
            )
            Spacer(modifier = Modifier.size(8.dp))
            TextButton(onClick = {
                /*TODO*/
                onNavToSignUpPge.invoke()
            }) {
                Text(
                    text = "Sign Up",
                    color = lightGreener,
                    fontWeight = FontWeight.Bold
                )
            }
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
    onNavToHomePage: () -> Unit,
    onNavToLoginpPage: () -> Unit,
) {
    val loginUiState = loginViewModel?.loginUiState
    val isError = loginUiState?.signUpError != null
    val context = LocalContext.current
    val primaryColor = MaterialTheme.colors.primary

    // visibility
    var passwordVisibility by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.3f)
                .clip(RoundedCornerShape(0.dp, 0.dp, 200.dp, 200.dp))
                .background(lightGreener),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Logo image section and app name
            Image(
                painter = painterResource(id = R.drawable.easidial_logo1),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .padding(1.dp)
                    .background(Color.Black, CircleShape)
                    .clip(CircleShape),
                contentScale = ContentScale.Fit
            )
            Text(
                text = "EasiDialCare",
                style = MaterialTheme.typography.h4,
                color = MaterialTheme.colors.onPrimary,
                modifier = Modifier
                    .padding(top = 4.dp)
            )
        }
        Spacer(modifier = Modifier.height(80.dp))
        Text(
            text = "Sign Up",
            style = MaterialTheme.typography.h5,
            color = MaterialTheme.colors.onSecondary
        )
        if (isError) {
            Text(
                text = loginUiState?.signUpError ?: "unknown error",
                color = MaterialTheme.colors.error,
                modifier = Modifier.padding(16.dp)
            )
        }
        OutlinedTextField(
            value = loginUiState?.userNameSignUp ?: "",
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.DarkGray,
                unfocusedBorderColor = Color.LightGray,
                focusedLabelColor = Color.DarkGray,
                unfocusedLabelColor = Color.LightGray,
                cursorColor = Color.DarkGray,
                textColor = primaryColor,
            ),
            onValueChange = {
                loginViewModel?.onUserChangeSignUp(it)
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null, tint = primaryColor,
                )
            },
            label = {
                Text(text = "Email", color = primaryColor)
            },
            isError = isError,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Email
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
        )
        OutlinedTextField(
            value = loginUiState?.passwordSignUp ?: "",
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.DarkGray,
                unfocusedBorderColor = Color.LightGray,
                focusedLabelColor = Color.DarkGray,
                unfocusedLabelColor = Color.LightGray,
                cursorColor = Color.DarkGray,
                textColor = primaryColor,
            ),
            onValueChange = {
                loginViewModel?.onPasswordChangeSignUp(it)
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = null, tint = primaryColor,
                )
            },
            trailingIcon = {
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    // User painter resource to add visibility icon
                    Icon(
                        painter = painterResource(id = if (passwordVisibility) R.drawable.visibility else R.drawable.visibility_off),
                        contentDescription = null,
                        tint = primaryColor
                    )
                }
            },
            label = {
                Text(text = "Password", color = primaryColor)
            },
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            isError = isError,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Password
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
        )
        OutlinedTextField(
            value = loginUiState?.confirmPasswordSignUp ?: "",
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.DarkGray,
                unfocusedBorderColor = Color.LightGray,
                focusedLabelColor = Color.DarkGray,
                unfocusedLabelColor = Color.LightGray,
                cursorColor = Color.DarkGray,
                textColor = primaryColor,
            ),
            onValueChange = {
                loginViewModel?.onConfirmPasswordChange(it)
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = null, tint = primaryColor
                )
            },
            trailingIcon = {
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    // User painter resource to add visibility icon
                    Icon(
                        painter = painterResource(id = if (passwordVisibility) R.drawable.visibility else R.drawable.visibility_off),
                        contentDescription = null,
                        tint = primaryColor,
                    )
                }
            },
            label = {
                Text(text = "Confirm Password", color = primaryColor)
            },
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            isError = isError,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
        )
        Spacer(modifier = Modifier.height(28.dp))
        Button(
            onClick = {
                /*TODO*/
                loginViewModel?.createUser(context)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = lightGreener,
                contentColor = MaterialTheme.colors.onSecondary
            )
        ) {
            if (loginUiState?.isLoading == true) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(28.dp),
                    strokeWidth = 4.dp,
                    color = colorResource(id = R.color.black)
                )
            } else {
                Text(
                    text = "Sign Up",
                    modifier = Modifier.padding(5.dp),
                    style = MaterialTheme.typography.button,
                    color = MaterialTheme.colors.onSecondary
                )
            }
        }
        Spacer(modifier = Modifier.size(4.dp))

        Row(
            modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Already have an Account?",
//                color = MaterialTheme.colors.onSecondary
            )
            Spacer(modifier = Modifier.size(8.dp))
            TextButton(onClick = {
                /*TODO*/
                onNavToLoginpPage.invoke()
            }) {
                Text(
                    text = "Login",
                    color = lightGreener
                )
            }
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
fun PreLoginSCreen() {
    GoogleSolutionTheme() {
        LoginScreen(onNavToHomePage = { /*TODO*/ }) {
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreSignUpSCreen() {
    GoogleSolutionTheme() {
        SignUpScreen(onNavToHomePage = { /*TODO*/ }) {
        }
    }
}