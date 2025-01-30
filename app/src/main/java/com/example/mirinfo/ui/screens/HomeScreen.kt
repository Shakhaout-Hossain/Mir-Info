package com.example.mirinfo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.mirinfo.viewModel.AuthState
import com.example.mirinfo.viewModel.AuthViewModel
import com.example.mirinfo.ui.components.HomePageMenu
import com.example.mirinfo.ui.components.ImageSlideshow

@Composable
fun HomeScreen(modifier: Modifier = Modifier, navController: NavController, authViewModel: AuthViewModel) {

    val authState = authViewModel.authState.observeAsState()

    LaunchedEffect(authState.value){
        when(authState.value){
            is AuthState.Unauthenticated -> navController.navigate("login")
            else -> Unit
        }
    }

    Column {
        // Other UI elements for the home screen
        ImageSlideshow()  // Use the slideshow composable here
        HomePageMenu(authViewModel, navController )

    }

}
