package com.example.uwtacomaguideapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    protected void onResume() {
        super.onResume();
        Button button1 = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button5);
        Button button3 = findViewById(R.id.button18);
        ImageView abellas = findViewById(R.id.imageView8);
        ImageView anthem = findViewById(R.id.imageView10);
        ImageView slvltea = findViewById(R.id.imageView12);
        ImageView crisp = findViewById(R.id.imageView13);
        ImageView hotdog = findViewById(R.id.imageView16);
        ImageView indochine = findViewById(R.id.imageView17);
        ImageView jimmyjohns = findViewById(R.id.imageView18);
        ImageView samchoy = findViewById(R.id.imageView19);
        ImageView subway = findViewById(R.id.imageView20);
        ImageView zeeks = findViewById(R.id.imageView21);
        ScrollView pacific = findViewById(R.id.pacific);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity4.this, MainActivity3.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity4.this, MainActivity5.class);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity4.this, MainActivity6.class);
//                startActivity(intent);
            }
        });
        abellas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("https://www.restaurantji.com/wa/tacoma/abella-pizzeria-/");
            }
        });
        anthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("https://www.myanthemcoffee.com/menus");
            }
        });
        slvltea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("https://www.facebook.com/p/S-LEVEL-TEA-100057634501940/");
            }
        });
        crisp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("https://www.crispgreens.co/menu-pacific-ave");
            }
        });
        hotdog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("http://places.singleplatform.com/hot-rod-dog/menu?ref=google");
            }
        });
        indochine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("https://indochinedowntown.com/menu.html");
            }
        });
        jimmyjohns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("https://www.jimmyjohns.com/");
            }
        });
        subway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("https://www.subway.com/en-us/locator");
            }
        });
        zeeks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("https://zeekspizza.com/locations/zeeks-pizza-tacoma/");
            }
        });
    }
    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}