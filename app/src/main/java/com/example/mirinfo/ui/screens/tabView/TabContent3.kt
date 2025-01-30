package com.example.mirinfo.ui.screens.tabView

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.mirinfo.ui.screens.webView.WebViewScreen

@Composable
fun TabContent3(navController: NavController) {
    WebViewScreen("https://www.amazon.com/", navController = navController)
//    Text(
//        text = "This is Tab 3 Content",
//        style = MaterialTheme.typography.titleSmall
//    )
}