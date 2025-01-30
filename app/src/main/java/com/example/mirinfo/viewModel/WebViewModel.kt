package com.example.mirinfo.viewModel

import android.webkit.WebView
import androidx.lifecycle.ViewModel

class WebViewModel : ViewModel() {
    private var webView: WebView? = null

    fun setWebView(view: WebView) {
        webView = view
    }

    fun goBack() {
        webView?.let {
            if (it.canGoBack()) {
                it.goBack()
            }
        }
    }
}