package com.malviya.letterhead;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.JavascriptInterface;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private WebView myWebView;
    private ValueCallback<Uri[]> mUploadMessage;
    private final static int FILECHOOSER_RESULTCODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myWebView = findViewById(R.id.miracleWebView);
        WebSettings s = myWebView.getSettings();

        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);
        s.setAllowFileAccess(true);
        s.setAllowContentAccess(false);
        s.setAllowFileAccessFromFileURLs(false);
        s.setAllowUniversalAccessFromFileURLs(false);

        // 1. This creates a "portal" named 'AndroidPrint' that the HTML calls in ln274 of index.html
        myWebView.addJavascriptInterface(new WebAppInterface(this), "AndroidPrint");

        myWebView.setWebViewClient(new WebViewClient());

        // 2. File upload bridge to allow button and Android system comm (kinda)
        myWebView.setWebChromeClient(new WebChromeClient() {
            // For Android 5.0+ though my API24 is 7.0+
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback,
                                             WebChromeClient.FileChooserParams fileChooserParams) {
                if (mUploadMessage != null) mUploadMessage.onReceiveValue(null);
                mUploadMessage = filePathCallback;

                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*"); // Imgs for logo/sign
                startActivityForResult(Intent.createChooser(intent, "Select Asset"), FILECHOOSER_RESULTCODE);
                return true;
            }
        });

        myWebView.loadUrl("file:///android_asset/index.html");
    }

    // 3. File Picker button result
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == FILECHOOSER_RESULTCODE) {
            if (null == mUploadMessage) return;
            Uri result = (intent == null || resultCode != RESULT_OK) ? null : intent.getData();
            if (result != null) {
                mUploadMessage.onReceiveValue(new Uri[]{result});
            } else {
                mUploadMessage.onReceiveValue(null);
            }
            mUploadMessage = null;
        }
    }

    // 4. Making print button to work!
    public class WebAppInterface {
        Context mContext;
        WebAppInterface(Context c) { mContext = c; }

        @JavascriptInterface
        public void printPage() {
            runOnUiThread(() -> {
                PrintManager printManager = (PrintManager) getSystemService(Context.PRINT_SERVICE);
                String jobName = getString(R.string.app_name) + " Document";
                PrintDocumentAdapter printAdapter = myWebView.createPrintDocumentAdapter(jobName);
                if (printManager != null) {
                    printManager.print(jobName, printAdapter, new PrintAttributes.Builder().build());
                }
            });
        }
    }
}
