package com.example.mirinfo.ui.screens.webView

import android.annotation.SuppressLint
import android.view.ViewGroup
import android.webkit.*
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.platform.*
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.mirinfo.viewModel.WebViewModel

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebViewScreen(
    url: String = "https://www.google.com", // Default URL
    webViewModel: WebViewModel = viewModel(), // ViewModel for WebView logic
    navController: NavController
) {
    var isLoading by remember { mutableStateOf(true) }
    val webView = remember { mutableStateOf<WebView?>(null) }

    BackHandler {
        if (webView.value?.canGoBack() == true) {
            webView.value?.goBack()
            //webViewModel.goBack()
        } else{
            navController.navigate("home")
        }
    }


    Box(modifier = Modifier.fillMaxSize()) {
        AndroidView(
            factory = { context ->
                WebView(context).apply {
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                    settings.apply {
                        javaScriptEnabled = true
                        domStorageEnabled = true
                        cacheMode = WebSettings.LOAD_DEFAULT
                    }
                    webViewClient = object : WebViewClient() {
                        override fun onPageFinished(view: WebView?, url: String?) {
                            super.onPageFinished(view, url)
                            isLoading = false // Hide loading when page loads
                        }

                        override fun shouldOverrideUrlLoading(
                            view: WebView?,
                            request: WebResourceRequest?
                        ): Boolean {
                            return false
                        }
                    }
                    webChromeClient = WebChromeClient()
                    loadUrl(url)
                    webView.value = this
                    webViewModel.setWebView(this)
                }
            }
        )

        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

