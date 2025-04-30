package com.example.portfolioapps;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityEm2 extends AppCompatActivity {
    WebView web;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_em2);

        web = findViewById(R.id.web);

        // Enable JavaScript
        WebSettings webSettings = web.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Load video (embedded link)
        String videoUrl = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/d9W0Wk7FFM4\" frameborder=\"0\" allowfullscreen></iframe>";
        String html = "<html><body style='margin:0;padding:0'>" + videoUrl + "</body></html>";
        web.loadData(html, "text/html", "utf-8");
    }
}
