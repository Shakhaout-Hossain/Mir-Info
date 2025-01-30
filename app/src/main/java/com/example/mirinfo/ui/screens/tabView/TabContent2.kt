package com.example.mirinfo.ui.screens.tabView

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.navArgument
import com.example.mirinfo.ui.screens.webView.WebViewScreen

@Composable
fun TabContent2(navController: NavController) {
    WebViewScreen("https://www.apple.com/", navController = navController)
//    Text(
//        text = "This is Tab 2 Content",
//        style = MaterialTheme.typography.titleSmall
//    )
}