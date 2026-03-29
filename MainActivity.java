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

        // Initialise the WebView
        myWebView = findViewById(R.id.miracleWebView);
        WebSettings s = myWebView.getSettings();

        // Webview settings for the HTML
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);
        s.setAllowFileAccess(true);

        s.setAllowContentAccess(false);
        s.setAllowFileAccessFromFileURLs(false);
        s.setAllowUniversalAccessFromFileURLs(false);

        // Disable zooming to keep UI intact
        s.setSupportZoom(false);
        s.setBuiltInZoomControls(false);

        // Well, we don't password saving in the app shell
        s.setSavePassword(false);
        s.setSaveFormData(false);

        // Disable geolocation, no need so why ask it? I don't sell user data
        s.setGeolocationEnabled(false);

        // Forget anything which was typed except those stored
        s.setCacheMode(WebSettings.LOAD_NO_CACHE);

        // Idk, just to make sure there is no past memory?
        myWebView.clearCache(true);
        myWebView.setWebViewClient(new WebViewClient()); // ensures that links don't open in external browser
        myWebView.loadUrl("file:///android_asset/index.html"); // Load the html file
    }
}
