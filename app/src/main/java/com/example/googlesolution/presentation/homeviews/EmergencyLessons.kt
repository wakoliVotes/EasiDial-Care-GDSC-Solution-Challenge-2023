package com.example.googlesolution.presentation.homeviews

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.googlesolution.datalayer.screensviewmodels.EmergencyLessons
import com.example.googlesolution.datalayer.screensviewmodels.LessonsViewModel
import com.example.googlesolution.ui.theme.lightGreen
import com.example.googlesolution.ui.theme.lightGreener


@Composable
fun EmergencyLessons(
    navController: NavHostController,
) {

    val viewModel = viewModel<LessonsViewModel>()
    val searchText by viewModel.searchText.collectAsState()
    val lessons by viewModel.lessons.collectAsState()
    val isSearching by viewModel.isSearching.collectAsState()

    var isExpandedState by remember {
        mutableStateOf(false)
    }
    val rotationState by animateFloatAsState(
        targetValue = if (isExpandedState) 180f else 0f
    )

    MaterialTheme() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding()
                    .clip(RoundedCornerShape(0.dp, 0.dp, 24.dp, 24.dp))
                    .background(lightGreener)
            ) {
                Column {
                    Text(
                        text = "Lessons", style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 28.sp,
                        ), modifier = Modifier.padding(start = 16.dp)
                    )
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                    ) {
                        TextButton(onClick = { isExpandedState = !isExpandedState }) {
                            Text(
                                text = "Be informed, stay safe.",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        }
                        IconButton(
                            onClick = { isExpandedState = !isExpandedState },
                            modifier = Modifier
                                .rotate(rotationState),
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = if (isExpandedState) "Collapse" else "Expand",
                                modifier = Modifier.size(42.dp),
                            )
                        }
                    }
                    if (isExpandedState) Text(
                        text = "Emergencies can happen at any time, and it's important to be prepared to respond quickly and effectively. Whether it's a medical emergency, a natural disaster, or a personal crisis, knowing what to do in the moment can make all the difference.\nThe following lessons will help you prepare for and respond to emergencies. You can also find more information on accessing care and services in the Hospital and Ambulances pages.",
                        fontSize = 16.sp,
                        modifier = Modifier.padding(16.dp)

                    )
                }
            }


            TextField(
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    cursorColor = lightGreener,
                    textColor = Color.Black,
                    disabledLabelColor = Color.Black,
                    focusedLabelColor = lightGreener,
                    unfocusedLabelColor = Color.Black,
                ),
                value = searchText,
                onValueChange = viewModel::onSearchTermChange,
                label = {
                    Text(text = "Search", fontSize = 16.sp)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .size(50.dp)
                    .alpha(0.8f)
                    .clip(RoundedCornerShape(16.dp))
            )


            LazyColumn(modifier = Modifier.weight(1f)) {
                items(lessons) { lesson ->
                    EmergencyListItem(lessons = lesson, expanded = false)
                }
                item {
                    Text(
                        text = "End of Lessons. Stay Safe!",
                        color = Color.Black,
                        modifier = Modifier
                            .padding(16.dp)
                            .alpha(0.8f)
                    )
                }
            }
        }

    }
}

@Composable
fun EmergencyListItem(lessons: EmergencyLessons, expanded: Boolean) {
    var isExpanded by remember { mutableStateOf(expanded) }

    Card(
        modifier = Modifier
            .padding(bottom = 8.dp, end = 8.dp, start = 8.dp)
            .fillMaxWidth(),
        elevation = 4.dp,
        shape = RoundedCornerShape(16.dp),

        ) {
        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Row(
                modifier = Modifier.padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(lessons.lessonImage),
                    contentDescription = "Lesson",
                    modifier = Modifier
                        .size(if (isExpanded) 100.dp else 50.dp)
                        .clip(if (isExpanded) CircleShape else RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Crop,
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = lessons.lessonName,
                    style = MaterialTheme.typography.subtitle2,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .weight(1f)
                        .alpha(0.8f),
                    textAlign = TextAlign.Start
                )
                Icon(
                    imageVector = if (isExpanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Expand/Collapse",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(24.dp)
                        .padding()
                        .background(lightGreen, CircleShape)
                )

            }
            if (isExpanded) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                ) {
                    Text(
                        text = lessons.description,
                        style = MaterialTheme.typography.caption,
                        textAlign = TextAlign.Justify,
                    )
                    Text(
                        text = "Severity: " + lessons.severityState,
                        style = MaterialTheme.typography.subtitle2,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .padding(top = 4.dp, bottom = 2.dp)
                            .alpha(0.6f)
                    )
                }
            }
        }
    }
}


// Add Preview
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EmergencyLessons(
        navController = rememberNavController(),
    )
}



