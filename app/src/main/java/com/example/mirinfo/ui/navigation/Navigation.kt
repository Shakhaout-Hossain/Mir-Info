package com.example.mirinfo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mirinfo.ui.screens.HomeScreen
import com.example.mirinfo.ui.login.LoginPage
import com.example.mirinfo.ui.login.SignUpPage
//import com.example.mirinfo.ui.screens.EmailVerificationScreen
import com.example.mirinfo.viewModel.AuthViewModel

@Composable
fun Navigation(modifier: Modifier = Modifier, authViewModel: AuthViewModel) {
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = "login", builder = {
        composable("login") {
            LoginPage(modifier, navController, authViewModel)
        }
        composable("signup") {
            SignUpPage(modifier, navController, authViewModel)
        }
//        composable("verifyEmail") {
//            EmailVerificationScreen(authViewModel) {
//                navController.navigate("home") {
//                    popUpTo("verifyEmail") { inclusive = true }
//                }
//            }
//        }
        composable("home") {
            HomeScreen(modifier, navController, authViewModel)
        }
    })
}