package com.example.googlesolution.presentation.drawer_destinations

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ListItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.googlesolution.R

@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MedicalInformationPage(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(
            navigationIcon = {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.round_arrow_back_ios_new_24),
                        contentDescription = "Back"
                    )
                }
            },
            title = {
                Text(text = "Medical Information")
            }
        )
    }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(top = 10.dp, bottom = 10.dp)
        ) {
            ListItem(text = {
                Text(text = "The Medical Information is a vital component of your emergency preparedness. It allows you to provide essential medical details that can assist healthcare professionals in delivering appropriate care during an emergency")
            })
            Divider(modifier = Modifier.padding(10.dp), color = MaterialTheme.colors.primary)
            ListItem(text = {
                Text(text = "Personal Information", fontWeight = FontWeight.ExtraBold)
            })

            ListItem(text = {
                Text(text = "Full Name:")
            },
                secondaryText = {
                    Text(text = "James Danish")
                },
                trailing = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")
                    }
                }
            )
            ListItem(text = {
                Text(text = "Phone:")
            },
                secondaryText = {
                    Text(text = "0712345678")
                },
                trailing = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")
                    }
                }
            )
            ListItem(text = {
                Text(text = "Date of Birth:")
            },
                secondaryText = {
                    Text(text = "21/02/1982")
                },
                trailing = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")
                    }
                }
            )

            Divider(modifier = Modifier.padding(10.dp), color = MaterialTheme.colors.primary)
            ListItem(text = {
                Text(text = "Emergency Contacts", fontWeight = FontWeight.ExtraBold)
            },
                secondaryText = { Text(text = "One of these contacts will get an alert or a notification in case of an emergency.") })
            ListItem(text = {
                Text(text = "First Contact:", fontWeight = FontWeight.Light)
            })
            ListItem(text = {
                Text(text = "Name:")
            },
                secondaryText = {
                    Text(text = "Name")
                },
                trailing = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")
                    }
                }
            )
            ListItem(text = {
                Text(text = "Phone:")
            },
                secondaryText = {
                    Text(text = "0712345678")
                },
                trailing = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")
                    }
                }
            )
            ListItem(text = {
                Text(text = "Second Contact:", fontWeight = FontWeight.Light)
            })
            ListItem(text = {
                Text(text = "Name:")
            },
                secondaryText = {
                    Text(text = "Name")
                },
                trailing = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")
                    }
                }
            )
            ListItem(text = {
                Text(text = "Phone:")
            },
                secondaryText = {
                    Text(text = "0712345678")
                },
                trailing = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")
                    }
                }
            )
            Divider(modifier = Modifier.padding(10.dp), color = MaterialTheme.colors.primary)
            ListItem(
                text = {
                    Text(text = "Custom Message", fontWeight = FontWeight.ExtraBold)
                },
                secondaryText = {
                    Text(text = "Create a custom message to accompany the notification or alert sent to the emergency contact. This message can include additional details or specific instructions regarding the emergency situation, providing essential information upfront.")
                },
                trailing = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")
                    }
                },
            )
            Divider(modifier = Modifier.padding(10.dp), color = MaterialTheme.colors.primary)
            ListItem(
                text = {
                    Text(text = "Medical Conditions", fontWeight = FontWeight.ExtraBold)
                },
                secondaryText = {
                    Text(text = "Document any existing medical conditions or chronic illnesses you have. This may include conditions such as diabetes, asthma, heart disease, epilepsy, allergies, or any other significant health concerns. Include details about the diagnosis, treatment, and medications associated with each condition.")
                },
                trailing = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")
                    }
                },
            )
            Divider(modifier = Modifier.padding(10.dp), color = MaterialTheme.colors.primary)
            ListItem(
                text = {
                    Text(text = "Allergies", fontWeight = FontWeight.ExtraBold)
                },
                secondaryText = {
                    Text(text = "Specify any known allergies, including medication allergies, food allergies, or environmental allergies. Mention the type of allergic reaction you experience and any necessary emergency measures or medications to be taken.")
                },
                trailing = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")
                    }
                },
            )
            Divider(modifier = Modifier.padding(10.dp), color = MaterialTheme.colors.primary)
            ListItem(
                text = {
                    Text(text = "Health Insurance", fontWeight = FontWeight.ExtraBold)
                },
                secondaryText = {
                    Text(text = "Include details about your health insurance coverage, including the name of the insurance provider, policy number, and any specific requirements or limitations.")
                },
                trailing = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")
                    }
                },
            )
        }
    }
}

@Preview
@Composable
fun MedicalInformationPagePrev() {
    MedicalInformationPage(rememberNavController())
}