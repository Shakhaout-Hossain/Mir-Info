package com.example.mirinfo.ui.screens.tabView

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.mirinfo.ui.screens.webView.WebViewScreen

@Composable
fun TabContent1(navController: NavController) {
    WebViewScreen(/*"https://mirinfosys.com/"*/navController = navController)
//    Text(
//        text = "This is Tab 1 Content",
//        style = MaterialTheme.typography.titleSmall
//    )
}