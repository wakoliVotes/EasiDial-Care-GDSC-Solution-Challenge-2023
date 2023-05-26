package com.example.googlesolution.presentation.drawer_destinations

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.googlesolution.R
import com.example.googlesolution.datalayer.firestore.DataViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun FeedbackPage(navController: NavController, dataViewModel: DataViewModel = viewModel()) {
    val mContext = LocalContext.current
    var feedbackText by remember { mutableStateOf("") }
    val focusRequester = remember { FocusRequester() }
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    Scaffold(topBar = {
        TopAppBar(
            backgroundColor = MaterialTheme.colors.surface,
            contentColor = MaterialTheme.colors.onSurface,
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
        TextField(
            value = feedbackText, onValueChange = { newValue -> feedbackText = newValue },
            modifier = Modifier
                .focusRequester(focusRequester)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                cursorColor = Color.DarkGray,
                backgroundColor = Color.Transparent
            ),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Send,
                keyboardType = KeyboardType.Text,
                autoCorrect = true,
                capitalization = KeyboardCapitalization.Sentences
            ),
            keyboardActions = KeyboardActions(onSend = {
                if (feedbackText != "") {
                    dataViewModel.sendFeedBack(text = feedbackText)
                    Toast.makeText(mContext, "Feedback Sent", Toast.LENGTH_SHORT).show()
                    navController.navigateUp()
                } else {
                    focusRequester.requestFocus()
                    Toast.makeText(mContext, "Feedback not sent, text is empty", Toast.LENGTH_LONG)
                        .show()
                }
            })
        )
    }
}

@Preview
@Composable
fun FeedbackPagePrev() {
    FeedbackPage(rememberNavController())
}