package com.example.mirinfo.ui.screens

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.tooling.preview.Preview
import com.example.mirinfo.R
import com.example.mirinfo.ui.main.MainActivity
import com.example.mirinfo.ui.theme.MirInfoTheme
import kotlinx.coroutines.delay

class SplashScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MirInfoTheme {
                SplashScreen {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
            }
        }
    }
}

@Composable
fun SplashScreen(onTimeout: () -> Unit) {

    var isScaledUp by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(
        targetValue = if (isScaledUp) 2.5f else 1f, // Scale from 1x to 1.5x
        animationSpec = tween(1500)
    )

    LaunchedEffect(Unit) {
        isScaledUp = true
        delay(5000)
        onTimeout()
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

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    MirInfoTheme {
        SplashScreen()
    }
}