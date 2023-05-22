package com.example.googlesolution.presentation.drawer_destinations

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ListItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.googlesolution.R

@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MedicalInformationPage(navController: NavController) {
    val mContext = LocalContext.current

    // TODO: Check on Material Theming to avoid using of "unfocused..." in all OutlinedTextField
    // ..in this file

    ///Start Personal Data
    var editingFullName by remember { mutableStateOf(false) }
    var fullName by remember { mutableStateOf("") }

    var editingPhone by remember { mutableStateOf(false) }
    var phone by remember { mutableStateOf("") }

    var editingDateOfBirth by remember { mutableStateOf(false) }
    var dateOfBirth by remember { mutableStateOf("") }
    ///End Personal Data

    ///Start Emergency Contacts
    var editingFirstContactName by remember { mutableStateOf(false) }
    var firstContactName by remember { mutableStateOf("") }

    var editingFirstContactPhone by remember { mutableStateOf(false) }
    var firstContactPhone by remember { mutableStateOf("") }

    var editingSecondContactName by remember { mutableStateOf(false) }
    var secondContactName by remember { mutableStateOf("") }

    var editingSecondContactPhone by remember { mutableStateOf(false) }
    var secondContactPhone by remember { mutableStateOf("") }
    ///End Emergency Contacts

    ///Start Other Info
    var editingCustomMessage by remember { mutableStateOf(false) }
    var customMessage by remember { mutableStateOf("") }

    var editingMedicalConditions by remember { mutableStateOf(false) }
    var medicalConditions by remember { mutableStateOf("") }

    var editingAllergies by remember { mutableStateOf(false) }
    var allergies by remember { mutableStateOf("") }

    var editingHealthInsurance by remember { mutableStateOf(false) }
    var healthInsurance by remember { mutableStateOf("") }
    ///End Other Info

    fun editFullName(newName: String) {
        editingFullName = !editingFullName
        Toast.makeText(mContext, "Saving...", Toast.LENGTH_SHORT).show()
        // TODO: Add logic to save newName to Firestore.
        // update UI when complete.
    }

    fun editPhone(newPhone: String) {
        editingPhone = !editingPhone
        Toast.makeText(mContext, "Saving...", Toast.LENGTH_SHORT).show()
        // TODO: Add logic to save newPhone to Firestore.
        // update UI when complete.
    }

    fun editDateOfBirth(newDate: String) {
        editingDateOfBirth = !editingDateOfBirth
        Toast.makeText(mContext, "Saving...", Toast.LENGTH_SHORT).show()
        // TODO: Add logic to save newDate to Firestore.
        // update UI when complete.
    }

    fun editFirstContactName(newName: String) {
        editingFirstContactName = !editingFirstContactName
        Toast.makeText(mContext, "Saving...", Toast.LENGTH_SHORT).show()
        // TODO: Add logic to save newName to Firestore.
        // update UI when complete.
    }

    fun editFirstContactPhone(newPhone: String) {
        editingFirstContactPhone = !editingFirstContactPhone
        Toast.makeText(mContext, "Saving...", Toast.LENGTH_SHORT).show()
        // TODO: Add logic to save newPhone to Firestore.
        // update UI when complete.
    }

    fun editSecondContactName(newName: String) {
        editingSecondContactName = !editingSecondContactName
        Toast.makeText(mContext, "Saving...", Toast.LENGTH_SHORT).show()
        // TODO: Add logic to save newName to Firestore.
        // update UI when complete.
    }

    fun editSecondContactPhone(newPhone: String) {
        editingSecondContactPhone = !editingSecondContactPhone
        Toast.makeText(mContext, "Saving...", Toast.LENGTH_SHORT).show()
        // TODO: Add logic to save newPhone to Firestore.
        // update UI when complete.
    }

    fun editingCustomMessage(newCustomMessage: String) {
        editingCustomMessage = !editingCustomMessage
        Toast.makeText(mContext, "Saving...", Toast.LENGTH_SHORT).show()
        // TODO: Add logic to save newCustomMessage to Firestore.
        // update UI when complete.
    }

    fun editMedicalConditions(newMedicalConditions: String) {
        editingMedicalConditions = !editingMedicalConditions
        Toast.makeText(mContext, "Saving...", Toast.LENGTH_SHORT).show()
        // TODO: Add logic to save newMedicalConditions to Firestore.
        // update UI when complete.
    }

    fun editAllergies(newAllergies: String) {
        editingAllergies = !editingAllergies
        Toast.makeText(mContext, "Saving...", Toast.LENGTH_SHORT).show()
        // TODO: Add logic to save newAllergies to Firestore.
        // update UI when complete.
    }

    fun editHealthInsurance(newHealthInsurance: String) {
        editingHealthInsurance = !editingHealthInsurance
        Toast.makeText(mContext, "Saving...", Toast.LENGTH_SHORT).show()
        // TODO: Add logic to save newHealthInsurance to Firestore.
        // update UI when complete.
    }

    Scaffold(topBar = {
        TopAppBar(navigationIcon = {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(
                    painter = painterResource(id = R.drawable.round_arrow_back_ios_new_24),
                    contentDescription = "Back"
                )
            }
        }, title = {
            Text(text = "Medical Information")
        })
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
            }, secondaryText = {
                Column {
                    Text(text = "James Danish")
                }
            }, trailing = {
                if (!editingFullName) IconButton(onClick = { editingFullName = true }) {
                    Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")
                }
            })
            if (editingFullName) OutlinedTextField(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                value = fullName,
                singleLine = true,
                label = {
                    Text(text = "Edit Name")
                },
                onValueChange = {
                    fullName = it
                },
                trailingIcon = {
                    Button(modifier = Modifier.padding(end = 8.dp), onClick = {
                        editFullName(fullName)
                    }) {
                        Text(text = "Save")
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = MaterialTheme.colors.primary,
                    unfocusedLabelColor = MaterialTheme.colors.primary,
                    textColor = Color.Black,
                    backgroundColor = Color.White
                ),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Words,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(onDone = {
                    editFullName(fullName)
                })
            )



            ListItem(text = {
                Text(text = "Phone:")
            }, secondaryText = {
                Text(text = "0712345678")
            }, trailing = {
                IconButton(onClick = { editingPhone = !editingPhone }) {
                    Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")
                }
            })
            if (editingPhone) OutlinedTextField(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                value = phone,
                singleLine = true,
                label = {
                    Text(text = "Edit Phone")
                },
                onValueChange = {
                    phone = it
                },
                trailingIcon = {
                    Button(modifier = Modifier.padding(end = 8.dp), onClick = {
                        editPhone(phone)
                    }) {
                        Text(text = "Save")
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = MaterialTheme.colors.primary,
                    unfocusedLabelColor = MaterialTheme.colors.primary,
                    textColor = Color.Black,
                    backgroundColor = Color.White
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone, imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(onDone = {
                    editPhone(phone)
                })
            )



            ListItem(text = {
                Text(text = "Date of Birth:")
            }, secondaryText = {
                Text(text = "21/02/1982")
            }, trailing = {
                IconButton(onClick = { editingDateOfBirth = !editingDateOfBirth }) {
                    Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")
                }
            })
            if (editingDateOfBirth) OutlinedTextField(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                value = dateOfBirth,
                singleLine = true,
                label = {
                    Text(text = "Edit Date of Birth")
                },
                onValueChange = {
                    dateOfBirth = it
                },
                trailingIcon = {
                    Button(modifier = Modifier.padding(end = 8.dp), onClick = {
                        editDateOfBirth(dateOfBirth)
                    }) {
                        Text(text = "Save")
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = MaterialTheme.colors.primary,
                    unfocusedLabelColor = MaterialTheme.colors.primary,
                    textColor = Color.Black,
                    backgroundColor = Color.White
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text, imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(onDone = {
                    editDateOfBirth(dateOfBirth)
                })
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
            }, secondaryText = {
                Text(text = "Name")
            }, trailing = {
                IconButton(onClick = { editingFirstContactName = !editingFirstContactName }) {
                    Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")
                }
            })
            if (editingFirstContactName) OutlinedTextField(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                value = firstContactName,
                singleLine = true,
                label = {
                    Text(text = "Edit Name")
                },
                onValueChange = {
                    firstContactName = it
                },
                trailingIcon = {
                    Button(modifier = Modifier.padding(end = 8.dp), onClick = {
                        editFirstContactName(firstContactName)
                    }) {
                        Text(text = "Save")
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = MaterialTheme.colors.primary,
                    unfocusedLabelColor = MaterialTheme.colors.primary,
                    textColor = Color.Black,
                    backgroundColor = Color.White
                ),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Words,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(onDone = {
                    editFirstContactName(firstContactName)
                })
            )




            ListItem(text = {
                Text(text = "Phone:")
            }, secondaryText = {
                Text(text = "0712345678")
            }, trailing = {
                IconButton(onClick = { editingFirstContactPhone = !editingFirstContactPhone }) {
                    Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")
                }
            })
            if (editingFirstContactPhone) OutlinedTextField(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                value = firstContactPhone,
                singleLine = true,
                label = {
                    Text(text = "Edit Phone")
                },
                onValueChange = {
                    firstContactPhone = it
                },
                trailingIcon = {
                    Button(modifier = Modifier.padding(end = 8.dp), onClick = {
                        editFirstContactPhone(firstContactPhone)
                    }) {
                        Text(text = "Save")
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = MaterialTheme.colors.primary,
                    unfocusedLabelColor = MaterialTheme.colors.primary,
                    textColor = Color.Black,
                    backgroundColor = Color.White
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone, imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(onDone = {
                    editFirstContactPhone(firstContactPhone)
                })
            )




            ListItem(text = {
                Text(text = "Second Contact:", fontWeight = FontWeight.Light)
            })
            ListItem(text = {
                Text(text = "Name:")
            }, secondaryText = {
                Text(text = "Name")
            }, trailing = {
                IconButton(onClick = { editingSecondContactName = !editingSecondContactName }) {
                    Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")
                }
            })
            if (editingSecondContactName) OutlinedTextField(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                value = secondContactName,
                singleLine = true,
                label = {
                    Text(text = "Edit Name")
                },
                onValueChange = {
                    secondContactName = it
                },
                trailingIcon = {
                    Button(modifier = Modifier.padding(end = 8.dp), onClick = {
                        editSecondContactName(secondContactName)
                    }) {
                        Text(text = "Save")
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = MaterialTheme.colors.primary,
                    unfocusedLabelColor = MaterialTheme.colors.primary,
                    textColor = Color.Black,
                    backgroundColor = Color.White
                ),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Words,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(onDone = {
                    editSecondContactName(secondContactName)
                })
            )





            ListItem(text = {
                Text(text = "Phone:")
            }, secondaryText = {
                Text(text = "0712345678")
            }, trailing = {
                IconButton(onClick = { editingSecondContactPhone = !editingSecondContactPhone }) {
                    Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")
                }
            })
            if (editingSecondContactPhone) OutlinedTextField(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                value = secondContactPhone,
                singleLine = true,
                label = {
                    Text(text = "Edit Phone")
                },
                onValueChange = {
                    secondContactPhone = it
                },
                trailingIcon = {
                    Button(modifier = Modifier.padding(end = 8.dp), onClick = {
                        editSecondContactPhone(secondContactPhone)
                    }) {
                        Text(text = "Save")
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = MaterialTheme.colors.primary,
                    unfocusedLabelColor = MaterialTheme.colors.primary,
                    textColor = Color.Black,
                    backgroundColor = Color.White
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone, imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(onDone = {
                    editSecondContactPhone(secondContactPhone)
                })
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
                    IconButton(onClick = { editingCustomMessage = !editingCustomMessage }) {
                        Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")
                    }
                },
            )
            if (editingCustomMessage) OutlinedTextField(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                value = customMessage,
                singleLine = true,
                label = {
                    Text(text = "Edit Custom Message")
                },
                onValueChange = {
                    customMessage = it
                },
                trailingIcon = {
                    Button(modifier = Modifier.padding(end = 8.dp), onClick = {
                        editingCustomMessage(customMessage)
                    }) {
                        Text(text = "Save")
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = MaterialTheme.colors.primary,
                    unfocusedLabelColor = MaterialTheme.colors.primary,
                    textColor = Color.Black,
                    backgroundColor = Color.White
                ),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Sentences,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(onDone = {
                    editingCustomMessage(customMessage)
                })
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
                    IconButton(onClick = { editingMedicalConditions = !editingMedicalConditions }) {
                        Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")
                    }
                },
            )
            if (editingMedicalConditions) OutlinedTextField(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                value = medicalConditions,
                singleLine = false,
                maxLines = 6,
                label = {
                    Text(text = "Edit Medical Conditions")
                },
                onValueChange = {
                    medicalConditions = it
                },
                trailingIcon = {
                    Button(modifier = Modifier.padding(end = 8.dp), onClick = {
                        editMedicalConditions(medicalConditions)
                    }) {
                        Text(text = "Save")
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = MaterialTheme.colors.primary,
                    unfocusedLabelColor = MaterialTheme.colors.primary,
                    textColor = Color.Black,
                    backgroundColor = Color.White
                ),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Sentences,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(onDone = {
                    editMedicalConditions(medicalConditions)
                })
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
                    IconButton(onClick = { editingAllergies = !editingAllergies }) {
                        Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")
                    }
                },
            )
            if (editingAllergies) OutlinedTextField(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                value = allergies,
                singleLine = false,
                maxLines = 6,
                label = {
                    Text(text = "Edit Allergies. (separate with a comma)")
                },
                onValueChange = {
                    allergies = it
                },
                trailingIcon = {
                    Button(modifier = Modifier.padding(end = 8.dp), onClick = {
                        editAllergies(allergies)
                    }) {
                        Text(text = "Save")
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = MaterialTheme.colors.primary,
                    unfocusedLabelColor = MaterialTheme.colors.primary,
                    textColor = Color.Black,
                    backgroundColor = Color.White
                ),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Sentences,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(onDone = {
                    editAllergies(allergies)
                })
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
                    IconButton(onClick = { editingHealthInsurance = !editingHealthInsurance }) {
                        Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")
                    }
                },
            )
            if (editingHealthInsurance) OutlinedTextField(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                value = healthInsurance,
                singleLine = false,
                maxLines = 6,
                label = {
                    Text(text = "Edit Health Insurance")
                },
                onValueChange = {
                    healthInsurance = it
                },
                trailingIcon = {
                    Button(modifier = Modifier.padding(end = 8.dp), onClick = {
                        editHealthInsurance(healthInsurance)
                    }) {
                        Text(text = "Save")
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = MaterialTheme.colors.primary,
                    unfocusedLabelColor = MaterialTheme.colors.primary,
                    textColor = Color.Black,
                    backgroundColor = Color.White
                ),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Sentences,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(onDone = {
                    editHealthInsurance(healthInsurance)
                })
            )

        }
    }
}

@Preview
@Composable
fun MedicalInformationPagePrev() {
    MedicalInformationPage(rememberNavController())
}