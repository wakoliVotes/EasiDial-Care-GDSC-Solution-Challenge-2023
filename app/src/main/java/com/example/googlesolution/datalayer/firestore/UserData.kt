package com.example.googlesolution.datalayer.firestore

import com.example.googlesolution.datalayer.firebaseauth.AuthRepository
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class UserData(
    // 1. Personal data
    var firstName: String,
    var lastName: String,
    var phone: String,
    var dateOfBirth: String,

    // 2. Medical History
    var preExistingMedicalCondition: String,
    var previousSurgeries: Boolean,

    ) {
    val database = Firebase.firestore
    val userID = AuthRepository().userEmail

    // use this var when writing to the database
    val userCloudData = hashMapOf(
        "user ID" to userID,
        "first name" to firstName,
        "last name" to lastName,
        "phone number" to phone,
        "date of birth" to dateOfBirth,
        "pre existing medical condition" to preExistingMedicalCondition,
        "previous surgeries" to previousSurgeries,
    )
}