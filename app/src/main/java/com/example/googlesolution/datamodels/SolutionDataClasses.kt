package com.example.googlesolution.datamodels

import com.example.googlesolution.R
import com.example.googlesolution.presentation.homeviews.Hospital

data class Hospital(
    val hospImage: Int = R.drawable.hospital,
    val name: String,
    val about: String,
    val contact: String,
    val location: String,
    val services: String,
    val hasAmbulance: Boolean,
) {
    val hospitals =
        listOf(
            Hospital(
                name = "Hospital 1",
                about = "This is a sample hospital.",
                contact = "1234567890",
                location = "1234, XYZ Street, ABC City",
                services = "Emergency, Surgery, Pediatrics",
                hasAmbulance = true
            ),
            Hospital(
                name = "Hospital 2",
                about = "This is another sample hospital.",
                contact = "0987654321",
                location = "5678, PQR Street, DEF City",
                services = "Obstetrics, Cardiology, Neurology",
                hasAmbulance = false
            ),
            Hospital(
                name = "Hospital 3",
                about = "This is a third sample hospital.",
                contact = "2468135790",
                location = "1357, LMN Street, GHI City",
                services = "Oncology, Dermatology, Psychiatry",
                hasAmbulance = true
            ),
        )
}


data class Ambulances(
    val ambImage: Int = R.drawable.ambulance,
    val name: String,
    val contact: String,
    val location: String,
) {
    val ambulances =
        listOf(
            Ambulances(
                name = "Ambulance 1",
                contact = "1234567890",
                location = "1234, XYZ Street, ABC City",
            ),
            Ambulances(
                name = "Ambulance 2",
                contact = "0987654321",
                location = "5678, PQR Street, DEF City",
            ),
            Ambulances(
                name = "Ambulance 3",
                contact = "2468135790",
                location = "1357, LMN Street, GHI City",
            ),
        )
}