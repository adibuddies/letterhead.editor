package com.malviya.letterhead;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the WebView
        myWebView = findViewById(R.id.miracleWebView);

        // Configure WebSettings for the Luxury Suite
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true); // Crucial for your QR and Sync logic
        webSettings.setDomStorageEnabled(true); // Helps with local rendering
        webSettings.setAllowFileAccess(true);   // Required to load your assets

        // Ensure links don't open in an external browser
        myWebView.setWebViewClient(new WebViewClient());

        // Load your local index.html
        myWebView.loadUrl("file:///android_asset/index.html");
    }
}
