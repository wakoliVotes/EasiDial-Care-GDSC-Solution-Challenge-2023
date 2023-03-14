package com.example.googlesolution.datamodels

import com.example.googlesolution.R


data class Hospital(
    val hospImage: Int,
    val name: String,
    val about: String,
    val contact: String,
    val location: String,
    val services: String,
    val hasAmbulance: Boolean,
)

val hospitals =
    listOf(
        Hospital(
            hospImage = R.drawable.hosp_agakhan,
            name = "Aga Khan University Hospital",
            about = "This is a sample hospital.",
            contact = "1234567890",
            location = "1234, XYZ Street, ABC City",
            services = "Emergency, Surgery, Pediatrics",
            hasAmbulance = true
        ),
        Hospital(
            hospImage = R.drawable.hosp_guru,
            name = "Guru Nanak Ramgarhia Sikh Hospital",
            about = "This is a sample hospital.",
            contact = "1234567890",
            location = "1234, XYZ Street, ABC City",
            services = "Emergency, Surgery, Pediatrics",
            hasAmbulance = true
        ),
        Hospital(
            hospImage = R.drawable.hosp_nairobihosp,
            name = "The Nairobi Hospital",
            about = "This is another sample hospital.",
            contact = "0987654321",
            location = "5678, PQR Street, DEF City",
            services = "Obstetrics, Cardiology, Neurology",
            hasAmbulance = false
        ),
        Hospital(
            hospImage = R.drawable.hosp_mamalucy,
            name = "Mama Lucy Kibaki Hospital",
            about = "This is a third sample hospital.",
            contact = "2468135790",
            location = "1357, LMN Street, GHI City",
            services = "Oncology, Dermatology, Psychiatry",
            hasAmbulance = true
        ),
        Hospital(
            hospImage = R.drawable.hosp_ku,
            name = "Kenyatta University Hospital",
            about = "This is a fourth sample hospital.",
            contact = "1357924680",
            location = "2468, STU Street, JKL City",
            services = "Dentistry, Ophthalmology, Orthopedics",
            hasAmbulance = false
        ),
        Hospital(
            hospImage = R.drawable.hosp_ruarakauhai,
            name = "Uhai Neema Hospital",
            about = "This is a fifth sample hospital.",
            contact = "0246813579",
            location = "3579, VWX Street, MNO City",
            services = "Gynecology, Urology, Radiology",
            hasAmbulance = true
        ),
        Hospital(
            hospImage = R.drawable.hosp_stfrancis,
            name = "St. Francis Community Hospital",
            about = "This is a sixth sample hospital.",
            contact = "1357924680",
            location = "2468, STU Street, JKL City",
            services = "Dentistry, Ophthalmology, Orthopedics",
            hasAmbulance = false
        ),
        Hospital(
            hospImage = R.drawable.hosp_gertrudes,
            name = "Gertrude's Children Hospital",
            about = "This is a sample hospital.",
            contact = "1234567890",
            location = "1234, XYZ Street, ABC City",
            services = "Emergency, Surgery, Pediatrics",
            hasAmbulance = true
        ),
        Hospital(
            hospImage = R.drawable.hosp_knh,
            name = "Kenyatta National Hospital",
            about = "This is another sample hospital.",
            contact = "0987654321",
            location = "5678, PQR Street, DEF City",
            services = "Obstetrics, Cardiology, Neurology",
            hasAmbulance = false
        ),
        Hospital(
            hospImage = R.drawable.hosp_stjohn,
            name = "St. Johns Hospital - Githurai",
            about = "This is a third sample hospital.",
            contact = "2468135790",
            location = "1357, LMN Street, GHI City",
            services = "Oncology, Dermatology, Psychiatry",
            hasAmbulance = true
        ),
        Hospital(
            hospImage = R.drawable.hosp_mater,
            name = "Mater Misericordiae Hospital",
            about = "This is a fourth sample hospital.",
            contact = "1357924680",
            location = "2468, STU Street, JKL City",
            services = "Dentistry, Ophthalmology, Orthopedics",
            hasAmbulance = false
        ),
        Hospital(
            hospImage = R.drawable.hosp_knh,
            name = "Marurui Health Center",
            about = "This is a fifth sample hospital.",
            contact = "0246813579",
            location = "3579, VWX Street, MNO City",
            services = "Gynecology, Urology, Radiology",
            hasAmbulance = true
        ),
        Hospital(
            hospImage = R.drawable.hosp_mater,
            name = "Makini Hospital",
            about = "This is a sixth sample hospital.",
            contact = "1357924680",
            location = "2468, STU Street, JKL City",
            services = "Dentistry, Ophthalmology, Orthopedics",
            hasAmbulance = false
        ),
        Hospital(
            hospImage = R.drawable.hosp_kasamaternity,
            name = "Kasarani Maternity & Nursing Home",
            about = "This is a sample hospital.",
            contact = "1234567890",
            location = "1234, XYZ Street, ABC City",
            services = "Emergency, Surgery, Pediatrics",
            hasAmbulance = true
        ),
    )

data class TopHospitals(
    val hospImage: Int,
    val hospitalName: String,
    val hospitalContacts: String,
)

val topHospitals = listOf(
    TopHospitals(
        hospImage = R.drawable.hosp_agakhan,
        hospitalName = "Aga Khan University Hospital",
        hospitalContacts = "1234567890",
    ),
    TopHospitals(
        hospImage = R.drawable.hosp_nairobihosp,
        hospitalName = "The Nairobi Hospital",
        hospitalContacts = "0987654321",
    ),
    TopHospitals(
        hospImage = R.drawable.hosp_ku,
        hospitalName = "Kenyatta University Hospital",
        hospitalContacts = "2468135790",
    ),
    TopHospitals(
        hospImage = R.drawable.hospital,
        hospitalName = "Kenya Medical Training College",
        hospitalContacts = "1357924680",
    ),
    TopHospitals(
        hospImage = R.drawable.hosp_ruarakauhai,
        hospitalName = "Uhai Neema Hospital",
        hospitalContacts = "0246813579",
    ),
    TopHospitals(
        hospImage = R.drawable.hosp_stfrancis,
        hospitalName = "St. Francis Community Hospital",
        hospitalContacts = "1357924680",
    ),
    TopHospitals(
        hospImage = R.drawable.hosp_knh,
        hospitalName = "Kenyatta National Hospital",
        hospitalContacts = "0987654321",
    ),
    TopHospitals(
        hospImage = R.drawable.hosp_stjohn,
        hospitalName = "St. Johns Hospital - Githurai",
        hospitalContacts = "2468135790",
    )
)

// AMBULANCES
data class TopAmbulances(
    val ambImage: Int,
    val name: String,
    val contact: String,
    val location: String,
)

val topAmbulances =
    listOf(
        TopAmbulances(
            ambImage = R.drawable.amb_stjohn,
            name = "St. Johns Ambulance",
            contact = "1234567890",
            location = "1234, XYZ Street, ABC City",
        ),
        TopAmbulances(
            ambImage = R.drawable.amb_redcross,
            name = "Red Cross Ambulance",
            contact = "0987654321",
            location = "5678, PQR Street, DEF City",
        ),
        TopAmbulances(
            ambImage = R.drawable.ambulance,
            name = "Jetflare Ambulance",
            contact = "2468135790",
            location = "1357, LMN Street, GHI City",
        ),
        TopAmbulances(
            ambImage = R.drawable.ambulance,
            name = "Elite Rescue Services",
            contact = "1357924680",
            location = "2468, STU Street, JKL City",
        ),
        TopAmbulances(
            ambImage = R.drawable.amb_amref,
            name = "AMREF Flying Doctors Service",
            contact = "0246813579",
            location = "3579, VWX Street, MNO City",
        ),
        TopAmbulances(
            ambImage = R.drawable.amb_ocoa,
            name = "OCOA Ambulance Service",
            contact = "1357924680",
            location = "2468, STU Street, JKL City",
        ),
    )

// AMBULANCES
data class Ambulances(
    val ambImage: Int,
    val name: String,
    val contact: String,
)

val ambulances =
    listOf(
        Ambulances(
            ambImage = R.drawable.amb_stjohn,
            name = "St. Johns Ambulance",
            contact = "1234567890",
        ),
        Ambulances(
            ambImage = R.drawable.amb_redcross,
            name = "Red Cross Ambulance",
            contact = "0987654321",
        ),
        Ambulances(
            ambImage = R.drawable.ambulance,
            name = "Jetflare Ambulance",
            contact = "2468135790",
        ),
        Ambulances(
            ambImage = R.drawable.ambulance,
            name = "Elite Rescue Services",
            contact = "1357924680",
        ),
        // add AMREF Flying Doctors Service
        Ambulances(
            ambImage = R.drawable.amb_amref,
            name = "AMREF Flying Doctors Service",
            contact = "0246813579",
        ),
        // add OCOA Ambulance Service
        Ambulances(
            ambImage = R.drawable.amb_ocoa,
            name = "OCOA Ambulance Service",
            contact = "1357924680",
        ),
    )

// EMERGENCY LESSONS
data class EmergencyLessons(
    val lessonImage: Int,
    val lessonName: String,
    val description: String,
    val severityState: String,
)

val lessons =
    listOf(
        // Allergic reactions
        EmergencyLessons(
            lessonImage = R.drawable.learn_burn,
            lessonName = "Allergic Reactions",
            description = "An allergic reaction is a reaction to a substance that your body sees as harmful. The immune system makes antibodies to fight the substance. These antibodies cause symptoms such as a rash, hives, or swelling. An allergic reaction is a medical emergency. If you think you or someone else is having an allergic reaction, call 911 right away.",
            severityState = "Mild"
        ),
        // add asthma attacks
        EmergencyLessons(
            lessonImage = R.drawable.learn_heart,
            lessonName = "Asthma Attacks",
            description = "Asthma is a lung disease that causes the airways to narrow and swell. This makes it hard to breathe. Asthma attacks can be mild, moderate, or severe. An asthma attack is a medical emergency. If you think you or someone else is having an asthma attack, call 911 right away.",
            severityState = "Mild"

        ),
        EmergencyLessons(
            lessonImage = R.drawable.learn_heart,
            lessonName = "Heart Attack",
            description = "A heart attack occurs when the flow of blood to the heart is blocked. This can happen when a blood clot forms in an artery that supplies blood to the heart muscle. The heart muscle begins to die, and the heart can't pump blood as well as it should. A heart attack is a medical emergency. If you think you or someone else is having a heart attack, call 911 right away.",
            severityState = "Life threatening"
        ),
        EmergencyLessons(
            lessonImage = R.drawable.learn_burn,
            lessonName = "Burns",
            description = "A burn is damage to the skin or other tissues caused by heat, electricity, chemicals, or radiation. Burns can be minor, such as a sunburn, or major, such as a burn from a fire or an explosion. Burns can affect the skin, muscles, tendons, ligaments, and bones. A burn is a medical emergency. If you think you or someone else has a burn, call 911 right away.",
            severityState = "Mild"
        ),
        // add carbon monoxide poisoning
        EmergencyLessons(
            lessonImage = R.drawable.learn_poison,
            lessonName = "Carbon Monoxide Poisoning",
            description = "Carbon monoxide is a colorless, odorless gas. It's produced when fuel doesn't burn completely. Carbon monoxide can build up in enclosed spaces. This can cause poisoning. Carbon monoxide poisoning is a medical emergency. If you think you or someone else is having carbon monoxide poisoning, call 911 right away.",
            severityState = "Life threatening"
        ),
        EmergencyLessons(
            lessonImage = R.drawable.learn_stroke,
            lessonName = "Choking",
            description = "Choking is when food, an object, or another substance blocks the airway. This can cause breathing problems or even death. Choking is a medical emergency. If you think you or someone else is choking, call 911 right away.",
            severityState = "Mild"
        ),
        EmergencyLessons(
            lessonImage = R.drawable.learn_burn,
            lessonName = "CPR",
            description = "CPR stands for cardiopulmonary resuscitation. It's a lifesaving technique that combines chest compressions with rescue breaths. CPR is used when someone's heart has stopped or when they're not breathing normally. CPR can keep oxygen-rich blood flowing to the brain and other vital organs until emergency medical services arrive. CPR is a medical emergency. If you think you or someone else needs CPR, call 911 right away.",
            severityState = "Life threatening"
        ),
        EmergencyLessons(
            lessonImage = R.drawable.learn_heart,
            lessonName = "Diabetes",
            description = "Diabetes is a disease in which your blood glucose, or blood sugar, levels are too high. Glucose comes from the foods you eat. Insulin is a hormone that helps the glucose get into your cells to give them energy . With diabetes, your body either doesn't make enough insulin or can't use its own insulin as well as it should. This causes glucose to build up in your blood instead of going into your cells. Over time, high blood glucose can cause serious health problems.",
            severityState = "Mild"
        ),
        // add drowning
        EmergencyLessons(
            lessonImage = R.drawable.learn_heart,
            lessonName = "Drowning",
            description = "Drowning is when a person's breathing or ability to move is impaired by being in or under water. Drowning can happen in as little as 30 seconds. Drowning is a medical emergency. If you think you or someone else is drowning, call 911 right away.",
            severityState = "Life threatening"
        ),
        EmergencyLessons(
            lessonImage = R.drawable.learn_burn,
            lessonName = "Electrical Shock",
            description = "An electrical shock occurs when the body comes into contact with an electrical source. This can happen when a person touches a live wire or when a person is struck by lightning. Electrical shocks can cause burns, muscle spasms, and even death. An electrical shock is a medical emergency. If you think you or someone else has been shocked, call 911 right away.",
            severityState = "Life threatening"
        ),
        EmergencyLessons(
            lessonImage = R.drawable.learn_stroke,
            lessonName = "Fainting",
            description = "Fainting is a temporary loss of consciousness caused by a lack of blood flow to the brain. It's also called syncope. Fainting can be caused by a variety of things, including low blood sugar, dehydration, and heart problems. Fainting is a medical emergency. If you think you or someone else is fainting, call 911 right away.",
            severityState = "Mild"
        ),
        // add febrile seizures
        EmergencyLessons(
            lessonImage = R.drawable.learn_stroke,
            lessonName = "Febrile Seizures",
            description = "A febrile seizure is a seizure that happens when a child has a fever. Febrile seizures are common in children. They usually last less than 15 minutes. Most febrile seizures are harmless. But they can be a medical emergency. If you think your child is having a febrile seizure, call 911 right away.",
            severityState = "Mild"

        ),
        EmergencyLessons(
            lessonImage = R.drawable.learn_poison,
            lessonName = "Frostbite",
            description = "Frostbite is a condition that occurs when your skin and tissues freeze. It most often affects your fingers, toes, ears, and nose. Frostbite can cause permanent damage to your body. Frostbite is a medical emergency. If you think you or someone else has frostbite, call 911 right away.",
            severityState = "Mild"
        ),
        // add head injuries
        EmergencyLessons(
            lessonImage = R.drawable.learn_heart,
            lessonName = "Head Injuries",
            description = "A head injury is any injury to the head or brain. Head injuries can be mild, such as a bump or bruise, or severe, such as a skull fracture or traumatic brain injury. Head injuries are a medical emergency. If you think you or someone else has a head injury, call 911 right away.",
            severityState = "Severe"
        ),
        EmergencyLessons(
            lessonImage = R.drawable.learn_burn,
            lessonName = "Heart Attack",
            description = "A heart attack occurs when the flow of blood to the heart is blocked. This can happen when a blood clot forms in an artery that supplies blood to the heart muscle. The heart muscle begins to die, and the heart can't pump blood as well as it should. A heart attack is a medical emergency. If you think you or someone else is having a heart attack, call 911 right away.",
            severityState = "Life threatening"
        ),
        EmergencyLessons(
            lessonImage = R.drawable.learn_stroke,
            lessonName = "Heatstroke",
            description = "Heatstroke is a serious medical condition that occurs when your body becomes unable to control its temperature. This happens when your body produces too much heat and can't sweat enough to cool down. Heatstroke can cause damage to your brain, heart, kidneys, and other organs. Heatstroke is a medical emergency. If you think you or someone else has heatstroke, call 911 right away.",
            severityState = "Life threatening"
        ),
        // add insect bites
        EmergencyLessons(
            lessonImage = R.drawable.learn_poison,
            lessonName = "Insect Bites",
            description = "Insect bites are caused by stinging insects, such as bees, wasps, and hornets. Insect bites can cause pain, swelling, and itching. Insect bites are a medical emergency. If you think you or someone else has been bitten by an insect, call 911 right away.",
            severityState = "Mild"
        ),

        EmergencyLessons(
            lessonImage = R.drawable.learn_stroke,
            lessonName = "Hypothermia",
            description = "Hypothermia is a condition in which your body temperature drops below 95°F (35°C). Hypothermia can occur when you're exposed to cold temperatures for a long time or when you're in very cold water. Hypothermia can cause your heart, brain, and other vital organs to slow down or stop working. Hypothermia is a medical emergency. If you think you or someone else has hypothermia, call 911 right away.",
            severityState = "Life threatening"
        ),
        EmergencyLessons(
            lessonImage = R.drawable.learn_poison,
            lessonName = "Poisoning",
            description = "Poisoning occurs when you take in a substance that can harm your body. This can happen when you eat or drink something poisonous, breathe in poisonous fumes, or get a poisonous substance on your skin. Poisoning can cause a variety of symptoms, including nausea, vomiting, diarrhea, and seizures. Poisoning is a medical emergency. If you think you or someone else has been poisoned, call 911 right away.",
            severityState = "Life threatening"
        ),
        // add snake bites
        EmergencyLessons(
            lessonImage = R.drawable.learn_burn,
            lessonName = "Snake Bites",
            description = "Snake bites are caused by venomous snakes. Snake bites can cause pain, swelling, and itching. Snake bites are a medical emergency. If you think you or someone else has been bitten by a snake, call 911 right away.",
            severityState = "Mild"
        ),
        EmergencyLessons(
            lessonImage = R.drawable.learn_burn,
            lessonName = "Severe Bleeding",
            description = "Severe bleeding is bleeding that won't stop on its own. It can be caused by a variety of things, including cuts, broken bones, and puncture wounds. Severe bleeding is a medical emergency. If you think you or someone else is bleeding severely, call 911 right away.",
            severityState = "Life threatening"
        ),
        EmergencyLessons(
            lessonImage = R.drawable.learn_heart,
            lessonName = "Seizures",
            description = "A seizure is a sudden change in the way your brain works. It can cause changes in your behavior or how your body works. Seizures can be caused by a variety of things, including high fevers, head injuries, and certain medical conditions. Seizures are a medical emergency. If you think you or someone else is having a seizure, call 911 right away.",
            severityState = "Mild"
        ),
        EmergencyLessons(
            lessonImage = R.drawable.learn_stroke,
            lessonName = "Stroke",
            description = "A stroke occurs when blood flow to part of your brain is interrupted or reduced, depriving brain tissue of oxygen and nutrients. This can cause brain cells to die. A stroke is a medical emergency. If you think you or someone else is having a stroke, call 911 right away.",
            severityState = "Life threatening"
        ),
        // add suicidal thoughts
        EmergencyLessons(
            lessonImage = R.drawable.learn_burn,
            lessonName = "Suicidal Thoughts",
            description = "Suicidal thoughts are thoughts about killing yourself. Suicidal thoughts can be caused by a variety of things, including depression, anxiety, and substance abuse. Suicidal thoughts are a medical emergency. If you think you or someone else is having suicidal thoughts, call 911 right away.",
            severityState = "Mild"
        ),
        EmergencyLessons(
            lessonImage = R.drawable.learn_stroke,
            lessonName = "Traumatic Brain Injury",
            description = "A traumatic brain injury (TBI) occurs when a bump, blow, or jolt to the head causes damage to the brain. A TBI can cause a variety of symptoms, including headaches, dizziness, and memory loss. A TBI is a medical emergency. If you think you or someone else has a TBI, call 911 right away.",
            severityState = "Life threatening"
        ),
        // add unconsciousness
        EmergencyLessons(
            lessonImage = R.drawable.learn_heart,
            lessonName = "Unconsciousness",
            description = "Unconsciousness is a state in which you're not awake or aware of your surroundings. Unconsciousness can be caused by a variety of things, including head injuries, seizures, and heart attacks. Unconsciousness is a medical emergency. If you think you or someone else is unconscious, call 911 right away.",
            severityState = "Life threatening"
        ),
        EmergencyLessons(
            lessonImage = R.drawable.learn_poison,
            lessonName = "Domestic Violence",
            description = "Domestic violence is a pattern of abusive behavior in any relationship that is used by one partner to gain or maintain power and control over another intimate partner. Domestic violence can be physical, sexual, emotional, economic, or psychological actions or threats of actions that influence another person. This includes any behaviors that intimidate, manipulate, humiliate, isolate, frighten, terrorize, coerce, threaten, blame, hurt, injure, or wound someone. Domestic violence is a medical emergency. If you think you or someone else is experiencing domestic violence, call 911 right away.",
            severityState = "Life threatening"
        ),
    )

