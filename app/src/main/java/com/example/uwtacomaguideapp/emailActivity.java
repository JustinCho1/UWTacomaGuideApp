package com.example.uwtacomaguideapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class emailActivity extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_email);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        button1 = (Button) findViewById(R.id.buttonScheduleA);
        button2 = (Button) findViewById(R.id.buttonScheduleB);
        button3 = (Button) findViewById(R.id.buttonScheduleC);
        button4 = (Button) findViewById(R.id.buttonScheduleD);
        button5 = (Button) findViewById(R.id.homeEmail);

        // General
        Button EmailA = findViewById(R.id.buttonEmailA);

        Button EmailB = findViewById(R.id.buttonEmailB);

        Button EmailC = findViewById(R.id.buttonEmailC);

        Button EmailD= findViewById(R.id.buttonEmailD);

        //TextView textview3 = findViewById(R.id.textView3);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("https://outlook.office365.com/book/IsabellaWebbAdvisingBookingPage@cloud.washington.edu/");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("https://outlook.office365.com/book/WendyBarajas@cloud.washington.edu/");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("https://outlook.office365.com/book/WillTaylorsAdvisingPage@cloud.washington.edu/");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("https://outlook.office365.com/book/KikoSalasFirstYearPremajorAdvising@cloud.washington.edu/");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(emailActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        View.OnClickListener copyTextListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                String buttonText = button.getText().toString();
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Button Text", buttonText);
                clipboard.setPrimaryClip(clip);

                Toast.makeText(emailActivity.this, "Copied to Clipboard", Toast.LENGTH_SHORT).show();
            }
        };
        EmailA.setOnClickListener(copyTextListener);
        EmailB.setOnClickListener(copyTextListener);
        EmailC.setOnClickListener(copyTextListener);
        EmailD.setOnClickListener(copyTextListener);
    }
    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}