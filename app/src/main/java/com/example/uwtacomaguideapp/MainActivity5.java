package com.example.uwtacomaguideapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main5);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    protected void onResume() {
        super.onResume();
        Button button1 = findViewById(R.id.button9);
        Button button2 = findViewById(R.id.button10);
        Button button3 = findViewById(R.id.button15);
        ImageView metro = findViewById(R.id.imageView11);
        ImageView rock = findViewById(R.id.imageView22);
        ImageView sevenseas = findViewById(R.id.imageView23);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity5.this, MainActivity3.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity5.this, MainActivity4.class);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity5.this, MainActivity6.class);
//                startActivity(intent);
            }
        });
        metro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("http://places.singleplatform.com/metro-coffee/menu?ref=google");
            }
        });
        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("https://www.therockwfp.com/menu/");
            }
        });
        sevenseas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("https://www.7seasbrewing.com/beers/");
            }
        });
    }
    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}