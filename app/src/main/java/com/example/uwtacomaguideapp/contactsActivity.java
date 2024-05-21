package com.example.uwtacomaguideapp;

import android.content.Intent;
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

public class contactsActivity extends AppCompatActivity {

    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_contacts);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        button1 = (Button) findViewById(R.id.homeContacts);

        // General
        Button genPhone1 = findViewById(R.id.buttonGenPhone1);

        Button genPhone2 = findViewById(R.id.buttonGenPhone2);

        Button genEmail = findViewById(R.id.buttonGenEmail);

        // Admissions
        Button admissionPhone = findViewById(R.id.buttonAdmissionPhone);

        Button admissionEmail = findViewById(R.id.buttonAdmissionEmail);

        // Financial
        Button financialPhone = findViewById(R.id.buttonFinancialPhone);

        Button financialEmail = findViewById(R.id.buttonFinancialEmail);

        // Office
        Button officePhone = findViewById(R.id.buttonOfficePhone);

        Button officeEmail = findViewById(R.id.buttonOfficeEmail);

        // IT
        Button ITEmail = findViewById(R.id.buttonITEmail);

        // Alumni
        Button alumniPhone = findViewById(R.id.buttonAlumniPhone);

        Button alumniEmail = findViewById(R.id.buttonAlumniEmail);

        // Alumni
        Button safetyPhone = findViewById(R.id.buttonSafetyPhone);

        Button safetyEmail = findViewById(R.id.buttonSafetyEmail);


        //TextView textview3 = findViewById(R.id.textView3);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(contactsActivity.this, MainActivity.class);
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

                Toast.makeText(contactsActivity.this, "Copied to Clipboard", Toast.LENGTH_SHORT).show();
            }
        };

        genPhone1.setOnClickListener(copyTextListener);
        genPhone2.setOnClickListener(copyTextListener);
        genEmail.setOnClickListener(copyTextListener);

        admissionPhone.setOnClickListener(copyTextListener);
        admissionEmail.setOnClickListener(copyTextListener);

        financialPhone.setOnClickListener(copyTextListener);
        financialEmail.setOnClickListener(copyTextListener);

        officePhone.setOnClickListener(copyTextListener);
        officeEmail.setOnClickListener(copyTextListener);

        ITEmail.setOnClickListener(copyTextListener);

        alumniPhone.setOnClickListener(copyTextListener);
        alumniEmail.setOnClickListener(copyTextListener);

        safetyPhone.setOnClickListener(copyTextListener);
        safetyEmail.setOnClickListener(copyTextListener);
    }
}