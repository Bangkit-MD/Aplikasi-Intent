package com.example.explisitintentapps

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class WebViewActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_URL = "extra_url"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        val url = intent.getStringExtra(EXTRA_URL)
        val myWebView: WebView = findViewById(R.id.webViewKevin)
        myWebView.loadUrl(url.toString())

        myWebView.webViewClient = WebViewClient()
        myWebView.settings.javaScriptEnabled = true
        myWebView.settings.loadsImagesAutomatically = true
        myWebView.settings.domStorageEnabled = true

    }
}