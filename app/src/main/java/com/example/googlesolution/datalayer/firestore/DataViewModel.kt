package com.example.googlesolution.datalayer.firestore

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.googlesolution.datalayer.firebaseauth.AuthRepository
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.time.LocalTime

data class UserFirestoreData(
    var id: String = "",
    var fullName: String = "",
    var phone: String = "",
    var dateOfBirth: String = "",
    var firstContactName: String = "",
    var firstContactPhone: String = "",
    var secondContactName: String = "",
    var secondContactPhone: String = "",
    var customMessage: String = "",
    var medicalConditions: String = "",
    var allergies: String = "",
    var healthInsurance: String = "",
)

suspend fun readFirestoreData(): UserFirestoreData {
    val database = FirebaseFirestore.getInstance()
    val userID = AuthRepository().userEmail.toString()
    val mainCollection = "users"
    val userDocRef = database.collection(mainCollection).document(userID)

    var userData: UserFirestoreData
    try {

        ///This comment block below: I'm trying to read live data. I'll do deep research later
        /*userDocRef.addSnapshotListener{
                snapshot, e ->

            if (snapshot != null && snapshot.exists()) {
                Log.d("SNAPSHOT_LISTENER", "Current data: ${snapshot.data}")
                val result = snapshot?.toObject(UserFirestoreData::class.java)

                if (result != null) {
                    userData = result
                }
            } else {
                Log.d("SNAPSHOT_LISTENER", "Current data: null")
            }
        }*/


        /// For now, I'm reading data once
        val result = userDocRef.get().await()
        if (result != null) {
            userData = UserFirestoreData(
                id = result["id"].toString(),
                fullName = result["full name"].toString(),
                phone = result["phone"].toString(),
                dateOfBirth = result["date of birth"].toString(),
                firstContactName = result["first contact name"].toString(),
                firstContactPhone = result["first contact phone"].toString(),
                secondContactName = result["second contact name"].toString(),
                secondContactPhone = result["second contact phone"].toString(),
                customMessage = result["custom message"].toString(),
                medicalConditions = result["medical conditions"].toString(),
                allergies = result["allergies"].toString(),
                healthInsurance = result["health insurance"].toString(),
            )

            // return this data if user exists, then break
            return userData
        } else {
            //if user has no data, create document with empty string values
            val data = hashMapOf<String, String>(
                "id" to userID,
                "full name" to "",
                "phone" to "",
                "date of birth" to "",
                "first contact name" to "",
                "first contact phone" to "",
                "second contact name" to "",
                "second contact phone" to "",
                "custom message" to "",
                "medical conditions" to "",
                "allergies" to "",
                "health insurance" to "",

                )
            userDocRef.set(data)
        }
        Log.d("Firestore_result", "Result: $result")
    } catch (e: FirebaseFirestoreException) {
        Log.d("FIRESTORE", "Reading data: $e")

        /*if (e.code == FirebaseFirestoreException.Code.NOT_FOUND) {

        }*/
    }

    // return empty data if no data exists
    return UserFirestoreData()
}

class DataViewModel : ViewModel() {
    var state = mutableStateOf(UserFirestoreData())

    init {
        checkIfDataExists()
    }

    fun checkIfDataExists() {
        viewModelScope.launch {
            state.value = readFirestoreData()
        }
    }

    private val database = Firebase.firestore
    private val userID = AuthRepository().userEmail.toString()
    private val mainCollection = "users"
    val userDocRef = database.collection(mainCollection).document(userID)

    // For now, all values are of type of String
    fun updateDocumentField(
        fieldName: String,
        value: String,
    ) {
        var newData = hashMapOf<String, Any>(fieldName to value)

        userDocRef.update(newData)
    }

    fun sendFeedBack(text: String) {
        var data = hashMapOf<String, Any>(
            "name" to state.value.fullName,
            "phone" to state.value.phone,
            "email" to state.value.id,
            "feedback" to text
        )

        //using time as the document ID
        val time = LocalTime.now().toString()
        database.collection("feedback").document(time).set(data)
    }
}