package com.example.mirinfo.ui.screens.splash

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.mirinfo.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(/*onTimeout: () -> Unit,*/ navController: NavController) {

    var isScaledUp by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(
        targetValue = if (isScaledUp) 2.5f else 1f, // Scale from 1x to 1.5x
        animationSpec = tween(1000), label = ""
    )

    LaunchedEffect(Unit) {
        isScaledUp = true
        delay(3000)
        //onTimeout()
        navController.navigate("login")
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.mirinfosystemlogo),
            contentDescription = "Splash Logo",
            modifier = Modifier.scale(scale)
        )
    }

}