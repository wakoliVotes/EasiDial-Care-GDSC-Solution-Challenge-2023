package com.example.googlesolution.presentation.drawer_destinations

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.googlesolution.R
import com.example.googlesolution.navgraph.Screens

@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun EmergencyButtonPage(navController: NavController) {

    // TODO: Remove these variables imitating emergency btn settings:
    // variables used to imitate settings
    var confirmationDialog by remember { mutableStateOf(true) }
    var emergencyContact by remember { mutableStateOf(true) }

    // to store the display menu state
    var mDisplayMenu by remember { mutableStateOf(false) }
    // get local context
    val mContext = LocalContext.current


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
                Text(text = "Emergency Button")
            },
        )
    }) {
        Column(
            modifier = Modifier
                //.padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            ListItem(
                text = {
                    Text(text = "Customize Emergency Button Settings")
                },
                secondaryText = {
                    Text(text = "On this screen, you can customize the behavior of the emergency button to tailor it according to your needs. The emergency button is a crucial feature that allows you to request an ambulance promptly during an emergency situation. By configuring these settings, you can personalize how the emergency button functions and ensure it aligns with your preferences.")
                }
            )
            Divider(modifier = Modifier.padding(10.dp), color = MaterialTheme.colors.primary)
            ListItem(
                text = {
                    Text(text = "Confirmation Dialogue")
                },
                secondaryText = {
                    Text(text = "Enable or disable a confirmation dialog when pressing the emergency button, providing an extra layer of assurance before initiating the ambulance request.")
                },
                trailing = {
                    // TODO: Save this setting to the shared preference
                    Switch(checked = confirmationDialog, onCheckedChange = {

                        confirmationDialog = !confirmationDialog // make changes to the SharedPref

                        Toast.makeText(
                            mContext,
                            "Confirmation Dialog turned ${if (confirmationDialog) "on" else "off"} ",
                            Toast.LENGTH_SHORT
                        ).show()
                    })
                }
            )
            Divider(modifier = Modifier.padding(10.dp), color = MaterialTheme.colors.primary)
            ListItem(
                text = {
                    Text(text = "Emergency Contact")
                },
                secondaryText = {
                    Text(text = "An emergency contact to receive notifications or alerts when the emergency button is pressed, to ensure immediate communication during emergencies.")
                },
                trailing = {
                    // TODO: Save this setting to the shared preference
                    Switch(
                        checked = emergencyContact,
                        onCheckedChange = {
                            emergencyContact = !emergencyContact // make changes to the SharedPref

                            Toast.makeText(
                                mContext,
                                "Emergency contact turned ${if (emergencyContact) "on" else "off"} ",
                                Toast.LENGTH_SHORT
                            ).show()
                        })
                }
            )
            Divider(modifier = Modifier.padding(10.dp), color = MaterialTheme.colors.primary)

            Text(
                text = "Extras",
                modifier = Modifier.padding(start = 16.dp),
                fontWeight = FontWeight.ExtraBold,
            )

            ListItem(
                text = {
                    Text(text = "Location Sharing")
                },
                secondaryText = {
                    Text(text = "Your current location will be shared with the emergency contact or emergency services, facilitating a prompt response. May require internet connection.")
                },
            )

            ListItem(
                text = {
                    Text(text = "Custom Message (SMS)")
                },
                secondaryText = {
                    Text(text = "In case you are offline, a custom message containing your emergency details will be send to us")
                },
                trailing = {
                    IconButton(onClick = {
                        navController.navigate(Screens.MedicalInformationPage.route) {
                            launchSingleTop = true
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "Edit"
                        )
                    }
                }
            )


        }
    }
}

@Preview
@Composable
fun EmergencyButtonPagePrev() {
    EmergencyButtonPage(rememberNavController())
}
