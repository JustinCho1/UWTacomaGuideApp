package com.example.uwtacomaguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class feedbackActivity extends AppCompatActivity {
    Button button1;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_feedback);

        webView = findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLScJ0JQu_6Ib-AErXcBdMTw2TLvoyDUdH_gblzoNXTEFDUkgvw/viewform?usp=sf_link");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        button1 = (Button) findViewById(R.id.homeFeedback);
        //TextView textview3 = findViewById(R.id.textView3);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(feedbackActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}