package com.example.uwtacomaguideapp;
import android.content.Context;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

import java.util.concurrent.atomic.AtomicBoolean;

public class MainActivity2 extends AppCompatActivity implements LocationListener {
    Button button1;
    double width;
    private FusedLocationProviderClient fusedLocationClient;
    public static final String GPS_PROVIDER = "gps";

    //private final LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
    //47.24676, -122.44121 | 47.24676 -122.43613 | 47.24258, -122.44121 | 47.24258, -122.43613
    // 0.00418, -0.00508
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        AtomicBoolean permissions = new AtomicBoolean(false);
        ActivityResultLauncher<String[]> locationPermissionRequest =
                registerForActivityResult(new ActivityResultContracts
                                .RequestMultiplePermissions(), result -> {
                            Boolean fineLocationGranted = result.getOrDefault(
                                    android.Manifest.permission.ACCESS_FINE_LOCATION, false);
                            Boolean coarseLocationGranted = result.getOrDefault(
                                    android.Manifest.permission.ACCESS_COARSE_LOCATION,false);
                            if (fineLocationGranted != null && fineLocationGranted) {
                                permissions.set(true);
                                // Precise location access granted.
                            } else if (coarseLocationGranted != null && coarseLocationGranted) {
                                permissions.set(false);
                                // Only approximate location access granted.
                            } else {
                                permissions.set(false);
                                // No location access granted.

                            }
                        }
                );

        locationPermissionRequest.launch(new String[] {
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
        });
        button1 = (Button) findViewById(R.id.button2);
        //TextView textview3 = findViewById(R.id.textView3);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
        //ImageView imageView1 = findViewById(R.id.imageView);
        //Provider provider = locationManager.getBestProvider(GPS_PROVIDER)
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            //
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        width = displayMetrics.widthPixels;
        Location location = locationManager.getLastKnownLocation("gps");
        //LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (location != null) {
            //TextView textview1 = findViewById(R.id.textView);
            //TextView textview2 = findViewById(R.id.textView2);
            double lat = location.getLatitude();
            double lng = (location.getLongitude());
            ImageView imageView = findViewById(R.id.imageView);
            if ((lng >= -122.44271 && lng <= -122.43257) && (lat <= 47.24700 && lat >= 47.24315)) {
                //lat1 = Math.floor(2.2 * ((lat1 - 47.24258) * 100000));
                //lng1 = Math.floor(2.26 * ((lng1 - (-122.44121)) * 100000));
                //imageView.setX(((float)lat1));
                //imageView.setY(((float)lng1)); //383
                lat = Math.floor(width * (0.583) * (1 - (((lat - 47.24315) * 100000) / 385))); //937
                lng = Math.floor((width) * (((lng - (-122.44271)) * 100000) / 1014)); //767
                //textview3.setText(height);
                //textview4.setText(width);
                //textview1.setText(lat);
                //textview2.setText(lng);
                imageView.setX((float) lng);
                imageView.setY((float) lat);
                //textview1.setText(String.valueOf(location.getLatitude() + " " + location.getLongitude()));
                //textview2.setText(String.valueOf(lat1 + " " + lng1));
                //imageView.setY(2500);
            }
            //ImageView imageView1 = findViewById(R.id.imageView3);
            //textview1.setText(lat);
            //textview2.setText(lng);
            //imageView1.setX(2038 / (imageView1.getDrawable().getIntrinsicWidth()));
            //imageView1.setY(2189 / (imageView1.getDrawable().getIntrinsicHeight()));
//            TextView textview1 = findViewById(R.id.textView);
//            TextView textview2 = findViewById(R.id.textView2);
//            String lat = String.valueOf(location.getLatitude());
//            String lng = String.valueOf(location.getLongitude());
//            textview1.setText(lat);
//            textview2.setText(lng);
            onLocationChanged(location);
        }
    }

    protected void onResume() {
        //setContentView(R.layout.activity_main2);
        //locationManager.requestLocationUpdates(provider, 400, 1, this);
        super.onResume();
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        setContentView(R.layout.activity_main2);
        button1 = (Button) findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
        ImageView imageView2 = findViewById(R.id.imageView3);
        imageView2.measure(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        width = displayMetrics.widthPixels;
        //imageView.setY((float)height);
        //Log.i(String.valueOf(width), "width is: ");;
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates("gps", 400, 0.1f, this);
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        setContentView(R.layout.activity_main2);
        button1 = (Button) findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
        //TextView textview1 = findViewById(R.id.textView);
        //TextView textview2 = findViewById(R.id.textView2);
        //TextView textview3 = findViewById(R.id.textView3);
        //TextView textview4 = findViewById(R.id.textView4);
        //TextView textview1 = findViewById(R.id.textView);
        //TextView textview2 = findViewById(R.id.textView2);
        ImageView imageView = findViewById(R.id.imageView);
        //int screenHeight = displayMetrics.heightPixels;
        //Log.d(String.valueOf(screenWidth), "width is: ");
        //Log.d(String.valueOf(width), "height is: ");
        double lat1 = location.getLatitude();
        double lng1 = location.getLongitude();
        //String lat = String.valueOf(lat1);
        //String lng = String.valueOf(lng1);
        //47.24676, -122.44121 | 47.24676 -122.43613 | 47.24258, -122.44121 | 47.24258, -122.43613
        // 0.00418, -0.00508
        //432, 376
            if ((lng1 >= -122.44302 && lng1 <= -122.43257) && (lat1 <= 47.24818 && lat1 >= 47.24295)) {
                //lat1 = Math.floor(2.2 * ((lat1 - 47.24258) * 100000));
                //lng1 = Math.floor(2.26 * ((lng1 - (-122.44121)) * 100000));
                //imageView.setX(((float)lat1));
                //imageView.setY(((float)lng1)); //383
                lat1 = Math.floor(width * (0.583) * (1 - (((lat1 - 47.24315) * 100000) / 483))); //937
                lng1 = Math.floor((width) * (((lng1 - (-122.44271)) * 100000) / 1045)); //767
                //textview3.setText(height);
                //textview4.setText(width);
                //textview1.setText(lat);
                //textview2.setText(lng);
                imageView.setX((float) lng1);
                imageView.setY((float) lat1);
                //textview1.setText(String.valueOf(location.getLatitude() + " " + location.getLongitude()));
                //textview2.setText(String.valueOf(lat1 + " " + lng1));
                //imageView.setY(2500);
            }
        }
    }
