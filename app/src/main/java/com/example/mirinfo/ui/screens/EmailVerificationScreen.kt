//package com.example.mirinfo.ui.screens
//
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Button
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import com.example.mirinfo.viewModel.AuthViewModel
//
//
//@Composable
//fun EmailVerificationScreen(authViewModel: AuthViewModel = viewModel(), onVerified: () -> Unit) {
//    val verificationMessage = remember { mutableStateOf("") }
//
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp),
//        verticalArrangement = Arrangement.Center
//    ) {
//        Button(onClick = {
//            authViewModel.sendEmailVerification(
//                onSuccess = {
//                    verificationMessage.value = "Verification email sent successfully."
//                },
//                onFailure = { error ->
//                    verificationMessage.value = "Error: $error"
//                }
//            )
//        }) {
//            Text("Send Verification Email")
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
////        Button(onClick = {
////            authViewModel.checkEmailVerification { isVerified ->
////                if (isVerified) {
////                    onVerified()
////                } else {
////                    verificationMessage.value = "Email is not verified yet."
////                }
////            }
////        }) {
////            Text("Check Verification Status")
////        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Text(verificationMessage.value)
//    }
//}