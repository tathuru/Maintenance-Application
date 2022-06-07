package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class CheckSchedules extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_schedules);

        Intent intent = getIntent();
        setTitle("Internet Browser");

        String siteName = intent.getStringExtra("siteName");

        WebView webView = (WebView) findViewById(R.id.webview);

        webView.getSettings().setJavaScriptEnabled(true);

        //webView.setWebViewClient(new WebViewClient());

        webView.loadUrl( siteName);

    }
}