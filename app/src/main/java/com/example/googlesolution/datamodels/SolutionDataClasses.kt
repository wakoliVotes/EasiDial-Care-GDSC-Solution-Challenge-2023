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
                name = "Aga Khan University Hospital",
                about = "This is a sample hospital.",
                contact = "1234567890",
                location = "1234, XYZ Street, ABC City",
                services = "Emergency, Surgery, Pediatrics",
                hasAmbulance = true
            ),
            Hospital(
                name = "Nairobi Hospital",
                about = "This is another sample hospital.",
                contact = "0987654321",
                location = "5678, PQR Street, DEF City",
                services = "Obstetrics, Cardiology, Neurology",
                hasAmbulance = false
            ),
            Hospital(
                name = "Moi Teaching and Referral Hospital",
                about = "This is a third sample hospital.",
                contact = "2468135790",
                location = "1357, LMN Street, GHI City",
                services = "Oncology, Dermatology, Psychiatry",
                hasAmbulance = true
            ),
            Hospital(
                name = "Kenya Medical Training College",
                about = "This is a fourth sample hospital.",
                contact = "1357924680",
                location = "2468, STU Street, JKL City",
                services = "Dentistry, Ophthalmology, Orthopedics",
                hasAmbulance = false
            ),
            Hospital(
                name = "Uhai Neema Hospital",
                about = "This is a fifth sample hospital.",
                contact = "0246813579",
                location = "3579, VWX Street, MNO City",
                services = "Gynecology, Urology, Radiology",
                hasAmbulance = true
            ),
            Hospital(
                name = "St. Francis Community Hospital",
                about = "This is a sixth sample hospital.",
                contact = "1357924680",
                location = "2468, STU Street, JKL City",
                services = "Dentistry, Ophthalmology, Orthopedics",
                hasAmbulance = false
            ),
            Hospital(
                name = "Marurui Hospital",
                about = "This is a sample hospital.",
                contact = "1234567890",
                location = "1234, XYZ Street, ABC City",
                services = "Emergency, Surgery, Pediatrics",
                hasAmbulance = true
            ),
            Hospital(
                name = "Kenyatta National Hospital",
                about = "This is another sample hospital.",
                contact = "0987654321",
                location = "5678, PQR Street, DEF City",
                services = "Obstetrics, Cardiology, Neurology",
                hasAmbulance = false
            ),
            Hospital(
                name = "St. Johns Hospital - Githurai",
                about = "This is a third sample hospital.",
                contact = "2468135790",
                location = "1357, LMN Street, GHI City",
                services = "Oncology, Dermatology, Psychiatry",
                hasAmbulance = true
        )
    )
}


data class Ambulances(
    val ambImage: Int,
    val name: String,
    val contact: String,
    val location: String,
) {
    val ambulances =
        listOf(
            Ambulances(
                ambImage = R.drawable.ambulance,
                name = "St. Johns Ambulance",
                contact = "1234567890",
                location = "1234, XYZ Street, ABC City",
            ),
            Ambulances(
                ambImage = R.drawable.ambulance,
                name = "Red Cross Ambulance",
                contact = "0987654321",
                location = "5678, PQR Street, DEF City",
            ),
            Ambulances(
                ambImage = R.drawable.ambulance,
                name = "Jetflare Ambulance",
                contact = "2468135790",
                location = "1357, LMN Street, GHI City",
            ),
            Ambulances(
                ambImage = R.drawable.ambulance,
                name = "Elite Rescue Services",
                contact = "1357924680",
                location = "2468, STU Street, JKL City",
            ),
            // add AMREF Flying Doctors Service
            Ambulances(
                ambImage = R.drawable.ambulance,
                name = "AMREF Flying Doctors Service",
                contact = "0246813579",
                location = "3579, VWX Street, MNO City",
            ),
            // add OCOA Ambulance Service
            Ambulances(
                ambImage = R.drawable.ambulance,
                name = "OCOA Ambulance Service",
                contact = "1357924680",
                location = "2468, STU Street, JKL City",
            ),
        )
}