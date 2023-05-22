package com.example.googlesolution.presentation.drawer_destinations

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.googlesolution.R
import com.example.googlesolution.ui.theme.lightGreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AboutUsPage(navController: NavController) {
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
                Text(text = "About Us")
            }
        )
    }) {
        // TODO: Add About Us content here:
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .verticalScroll(rememberScrollState()),
                ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.easidial_logo1),
                    contentDescription = "About Us Image",
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.FillBounds,
                )
                Text(
                    text = "EasiDial Care",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    ),
                )
                Text(
                    text = "Version 1.0",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center
                    ),
                )
                
            }
            Text(
                text = "EasiDial Care is a mobile application that allows users to easily access medical services. The application allows users to access contact information for Hospitals and Ambulances essential in completing tasks like booking appointments with doctors, nurses, and other medical professionals.",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                ),
            )
            Text(
                text = "EasiDial Care also offers a platform to learn about the common health issues and emergencies. This is essential in helping users to make informed decisions about their health.",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                ),
            )
            Text(
                text = "Utility Information",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier
                    .padding(top = 16.dp)
                    .alpha(0.8f)
            )
            AboutExpandableCard(
                title = "Terms of Use",
                content = {
                    Text(
                        text = "Overview",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        ),
                    )
                    Text(
                        text = "These Terms of Use govern your use of the EasiDial Care mobile application. By using, visiting, or browsing the EasiDial Care mobile application, you accept and agree to be bound by these Terms of Use. If you do not agree to these Terms of Use, you should not use the EasiDial Care mobile application. These Terms of Use are an ongoing contract between you and EasiDial Care and apply to your use of the EasiDial Care mobile application. These Terms of Use affect your rights and you should read them carefully.",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                        ),
                    )
                    Text(
                        text = "Changes to Terms of Use",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        ),
                    )
                    Text(
                        text = "EasiDial Care reserves the right, from time to time, with or without notice to you, to change these Terms of Use in our sole and absolute discretion. The most current version of these Terms of Use can be reviewed by clicking on the Terms of Use located at the bottom of the pages of the EasiDial Care mobile application. The most current version of the Terms of Use will supersede all previous versions. Your use of the EasiDial Care mobile application or continued use of our service after changes are made means that you agree to be bound by such changes.",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                        ),
                    )
                    Text(
                        text = "Privacy",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        ),
                    )
                    Text(
                        text = "Please review our Privacy Policy, which also governs your visit to the EasiDial Care mobile application, to understand our practices.",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                        ),
                    )
                    Text(
                        text = "Electronic Communications",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        ),
                    )
                    Text(
                        text = "When you use the EasiDial Care mobile application, or send e-mails, text messages, and other communications from your desktop or mobile device to us, you may be communicating with us electronically. You consent to receive communications from us electronically, such as e-mails, texts, mobile push notices, or notices and messages on this site or through the other EasiDial Care mobile application, such as our Message Center, and you can retain copies of these communications for your records. You agree that all agreements, notices, disclosures, and other communications that we provide to you electronically satisfy any legal requirement that such communications be in writing.",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                        ),
                    )
                    Text(
                        text = "Your Account",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        ),
                    )
                    Text(
                        text = "If you use the EasiDial Care mobile application, you are responsible for maintaining the confidentiality of your account and password and for restricting access to your mobile device, and you agree to accept responsibility for all activities that occur under your account or password. EasiDial Care does sell products for children, but it sells them to adults, who can purchase with a credit card or other permitted payment method. If you are under 18, you may use the EasiDial Care mobile application only with involvement of a parent or guardian. EasiDial Care reserves the right to refuse service, terminate accounts, terminate your rights to use the EasiDial Care mobile application, remove or edit content, or cancel orders in its sole discretion.",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                        ),
                    )
                    Text(
                        text = "License and Access",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        ),
                    )
                    Text(
                        text = "Subject to your compliance with these Terms of Use and your payment of any applicable fees, EasiDial Care or its content providers grant you a limited, non-exclusive, non-transferable, non-sublicensable license to access and make personal and non-commercial use of the EasiDial Care mobile application. This license does not include any resale or commercial use of any EasiDial Care mobile application, or its contents; any collection and use of any product listings, descriptions, or prices; any derivative use of any EasiDial Care mobile application or its contents; any downloading, copying, or other use of account information for the benefit of any third party; or any use of data mining, robots, or similar data gathering and extraction tools. All rights not expressly granted to you in these Terms of Use or any Service Terms are reserved and retained by EasiDial Care or its licensors, suppliers, publishers, rightsholders, or other content providers.",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                        ),
                    )
                    Text(
                        text = "No EasiDial Care mobile application, nor any part of any EasiDial Care mobile application, may be reproduced, duplicated, copied, sold, resold, visited, or otherwise exploited for any commercial purpose without express written consent of EasiDial Care. You may not frame or utilize framing techniques to enclose any trademark, logo, or other proprietary information (including images, text, page layout, or form) of EasiDial Care without express written consent. You may not use any meta tags or any other “hidden text” utilizing EasiDial Care’s name or trademarks without the express written consent of EasiDial Care. You may not misuse the EasiDial Care mobile application. You may use the EasiDial Care mobile application only as permitted by law. The licenses granted by EasiDial Care terminate if you do not comply with these Terms of Use or any Service Terms.",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                        ),
                    )
                }
            )
            AboutExpandableCard(
                title = "Privacy Policy",
                content = {
                    Text(
                        text = "Overview",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        ),
                    )
                    Text(
                        text = "EasiDial Care is committed to protecting your privacy. This Privacy Policy applies to those who visit the EasiDial Care mobile application, but do not make a purchase, and those who make a purchase. This Privacy Policy describes how we collect, use, disclose, and protect the information of those using the EasiDial Care mobile application. By visiting and/or using the EasiDial Care mobile application on any computer, mobile phone, tablet, console, or other device (collectively, “Device”), you consent to the practices described in this Privacy Policy.",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                        ),
                    )
                    Text(
                        text = "Information We Collect",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        ),
                    )
                    Text(
                        text = "We collect a variety of information from you when you visit or use the EasiDial Care mobile application. This information may be used to contact or identify you, including: (i) your name, address, email address, telephone number, fax number, and other registration information; (ii) information about your visits to and use of the EasiDial Care mobile application; (iii) your orders for products or services through the EasiDial Care mobile application; (iv) your payment information; (v) your location information; (vi) your social media account information; and (vii) any other information you choose to provide to us (“User Information”).",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                        ),
                    )
                    Text(
                        text = "Information You Provide to Us",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        ),
                    )
                    Text(
                        text = "We collect User Information from you when you register with us, when you order products or services from us, when you use the EasiDial Care mobile application, when you post User Information to the EasiDial Care mobile application, when you send us email messages, and/or when you otherwise contact us. We may also collect User Information from you offline, such as when you call us to make a purchase. The User Information we collect from you may include your name, address, email address, telephone number, fax number, and other registration information. If you order products or services through the EasiDial Care mobile application, we may also collect your credit card number, expiration date, and security code. We may also collect information about your orders, purchases, returns, and other transactions with us, as well as your interests, preferences, and other information related to your use of the EasiDial Care mobile application.",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                        ),
                    )
                    Text(
                        text = "Information We Collect Automatically",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        ),
                    )
                    Text(
                        text = "We may automatically collect information about your use of the EasiDial Care mobile application, including the type of browser or mobile device you use, access times, pages viewed, your IP address, and the page you visited before visiting the EasiDial Care mobile application. We may also collect information about your location, including your precise location, if you have instructed your Device to send such information to the EasiDial Care mobile application via the privacy settings on that Device, or if you have uploaded photos tagged with location information. We may use the information we collect automatically to present the EasiDial Care mobile application to you on your Device, to determine your location so that we can present the EasiDial Care mobile application to you in the appropriate language, and/or to determine your age so that we can present the EasiDial Care mobile application to you in an age-appropriate manner.",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                        ),
                    )
                    Text(
                        text = "Information We Collect from Other Sources",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        ),
                    )
                    Text(
                        text = "We may also receive information about you from other sources and combine or link that with information we have about you. For example, we may collect demographic and change-of-address information from third party sources and information from third party social media platforms (such as Facebook) if you log into the EasiDial Care mobile application using your social media account credentials or if you make certain content and information publicly available, such as photos, videos, and profile information.",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                        ),
                    )
                    Text(
                        text = "Use of Information We Collect",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        ),
                    )
                    Text(
                        text = "We may use the information we collect from and about you for any of the following purposes: (i) to fulfill your requests for products and services; (ii) to provide you with targeted offers and advertising on the EasiDial Care mobile application; (iii) to contact you with information and promotional materials and offers from our company as well as from our subsidiaries, affiliates, marketing partners, advertisers, and other third parties; (iv) to contact you when necessary; (v) to review the usage and operations of the EasiDial Care mobile application and improve the EasiDial Care mobile application; (vi) to address problems with the EasiDial Care mobile application, our business, or our products and services; (vii) to protect the security or integrity of the EasiDial Care mobile application and our business; (viii) to monitor the EasiDial Care mobile application for compliance with our Terms of Use and the law; and (ix) to contact you with information and promotional materials and offers from our company as well as from our subsidiaries, affiliates, marketing partners, advertisers, and other third parties.",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                        ),
                    )
                    Text(
                        text = "Disclosure of Information We Collect",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        ),
                    )
                    Text(
                        text = "We may disclose the information we collect from and about you as follows: (i) to our service providers and suppliers, if the disclosure will enable them to fulfill your request for products or services from us for another vendor on our behalf, or if the disclosure will enable them to perform a business, professional, or technical support function for us; (ii) as necessary if we believe that there has been a violation of the EasiDial Care mobile application Terms of Use or of our rights or the rights of any third party; (iii) to respond to judicial process and provide information to law enforcement agencies or in connection with an investigation on matters related to public safety, as permitted by law, or otherwise as required by law; and (iv) as described to you at the point of collection.",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                        ),
                    )
                    Text(
                        text = "We may also share aggregated or de-identified information with third parties for research, marketing, analytics, and other purposes, provided such information does not identify a particular individual.",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                        ),
                    )
                    Text(
                        text = "Your Choices",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        ),
                    )
                    Text(
                        text = "We offer you certain choices about what information we collect from you, how we use and disclose the information we collect, and how we communicate with you. You may withdraw any consent you previously provided to us or object at any time on legitimate grounds and free of charge to the processing of your personal information, and we will apply your preferences going forward. You can choose not to receive marketing communications from us by clicking on the unsubscribe link in our marketing emails, by contacting us as specified in the “How to Contact Us” section below, or by following the instructions in the “Your Choices Regarding Your Personal Information” section of our Privacy Policy. Please include your name, email address, and postal address if you send us your request by email or postal mail. Please allow a reasonable time for us to process your request.",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                        ),
                    )
                    Text(
                        text = "Please note that if you do not want us to collect information from you, you will not be able to take advantage of many of the features of the EasiDial Care mobile application.",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                        ),
                    )
                    Text(
                        text = "Accessing and Correcting Your Information",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        ),
                    )
                    Text(
                        text = "You can review and change your personal information by logging into the EasiDial Care mobile application and visiting your account profile page. You may also send us an email at getintouchdesk@gmail.com to request access to, correct, or delete any personal information that you have provided to us. We cannot delete your personal information except by also deleting your user account. We may not accommodate a request to change information if we believe the change would violate any law or legal requirement or cause the information to be incorrect.",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                        ),
                    )
                }
            )

        }
    }
}

@Preview
@Composable
fun AboutUsPagePrev() {
    AboutUsPage(rememberNavController())
}

// Expandable card for Terms of Use and Privacy Policy
@Composable
fun AboutExpandableCard(
    title: String,
    content: @Composable () -> Unit,
) {
    var expanded by remember {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = !expanded }
                .padding(8.dp)
        ) {
            Row(
                modifier = Modifier.padding(4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.subtitle2,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .weight(1f)
                        .alpha(0.8f),
                    textAlign = TextAlign.Start
                )
                Icon(
                    imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Expand/Collapse",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(24.dp)
                        .padding()
                        .background(lightGreen, CircleShape)
                )
            }
            if (expanded) {
                content()
                // TODO - IMPROVE ON CONTENT STYLING
            }
        }
    }
}