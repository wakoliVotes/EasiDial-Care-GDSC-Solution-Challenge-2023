package com.example.googlesolution.presentation.homeviews

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.googlesolution.datalayer.EmergencyLessons
import com.example.googlesolution.datalayer.LessonsViewModel
import com.example.googlesolution.ui.theme.BlueMildest


@Composable
fun EmergencyLessons(
    navController: NavHostController,
) {

    val viewModel = viewModel<LessonsViewModel>()
    val searchText by viewModel.searchText.collectAsState()
    val lessons by viewModel.lessons.collectAsState()
    val isSearching by viewModel.isSearching.collectAsState()


    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(BlueMildest)
                .verticalScroll(rememberScrollState())
        ) {
            LazyColumn(modifier = Modifier.weight(1f)) {
                item{
                    Text(
                        text = "Emergency Lessons",
                        style = MaterialTheme.typography.h6,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(start = 16.dp, bottom = 5.dp, top = 40.dp)
                    )
                    Text(
                        text = "Be Informed: Be Safe",
                        style = MaterialTheme.typography.subtitle2,
                        color = Color.Black,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .padding(start = 16.dp, bottom = 25.dp, top = 5.dp)
                            .alpha(0.5f)
                    )
                    Text(
                        text = "Emergencies can happen at any time, and it's important to be prepared to respond quickly and effectively. Whether it's a medical emergency, a natural disaster, or a personal crisis, knowing what to do in the moment can make all the difference.",
                        modifier = Modifier
                            .padding(start = 16.dp, bottom = 8.dp, end = 16.dp)
                            .alpha(0.7f),
                        textAlign = TextAlign.Justify,
                        fontSize = 12.sp,
                        color = Color.Black,
                        )
                    Text(
                        text = "The following lessons will help you prepare for and respond to emergencies. You can also find more information on accessing care and services in the Hospital and Ambulances pages.",
                        modifier = Modifier
                            .padding(start = 16.dp, bottom = 8.dp, end = 16.dp)
                            .alpha(0.7f)
                        ,
                        textAlign = TextAlign.Justify,
                        fontSize = 12.sp
                    )
                }
                item {
                    TextField(
                        value = searchText,
                        onValueChange = viewModel::onSearchTermChange,
                        label = {
                            Text(text = "Search")
                                },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .alpha(0.8f)
                    )
                }
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
            Divider(modifier = Modifier.padding(vertical = 16.dp))
        }
    }
}

@Composable
fun EmergencyListItem(lessons: EmergencyLessons, expanded: Boolean) {
    var isExpanded by remember { mutableStateOf(expanded) }

    Card(
        modifier = Modifier
            .padding(bottom = 8.dp, end = 8.dp, start = 8.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
        ,
        elevation = 5.dp
    ) {
        Column(
            modifier = Modifier
                .clickable { isExpanded = !isExpanded }
        ) {
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
                    imageVector = if (isExpanded) Icons.Filled.Add else Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Expand/Collapse",
                    tint = Color.Gray,
                    modifier = Modifier
                        .size(28.dp)
                        .padding(end = 10.dp)
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
                        text = "Severity: "+ lessons.severityState,
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
fun DefaultPreview( ) {
    EmergencyLessons(navController = rememberNavController(),
    )
}



