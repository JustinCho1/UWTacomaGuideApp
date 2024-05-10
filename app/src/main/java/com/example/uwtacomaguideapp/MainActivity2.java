package com.example.uwtacomaguideapp;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
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
        Location location = locationManager.getLastKnownLocation("gps");
        //LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (location != null) {
            //TextView textview1 = findViewById(R.id.textView);
            //TextView textview2 = findViewById(R.id.textView2);
            String lat = String.valueOf(location.getLatitude());
            String lng = String.valueOf(location.getLongitude());
            //ImageView imageView = findViewById(R.id.imageView);
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
        ImageView imageView = findViewById(R.id.imageView);
        //imageView.setX(447);
        //imageView.setY(447);
        ImageView imageView1 = findViewById(R.id.imageView4);
        imageView1.measure(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        width = imageView1.getMeasuredWidth();
        //imageView.setY((float)height);
        //Log.i(String.valueOf(height), "width is: ");;
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates("gps", 400, 1, this);

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
        ImageView imageView1 = findViewById(R.id.imageView4);
        imageView1.measure(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        int screenHeight = displayMetrics.heightPixels;
        Log.d(String.valueOf(screenWidth), "width is: ");
        Log.d(String.valueOf(screenHeight), "height is: ");
        double lat1 = location.getLatitude();
        double lng1 = location.getLongitude();

        //String lat = String.valueOf(lat1);
        //String lng = String.valueOf(lng1);

        //47.24676, -122.44121 | 47.24676 -122.43613 | 47.24258, -122.44121 | 47.24258, -122.43613
        // 0.00418, -0.00508
        //432, 376
        if((lng1 >= -122.44131 && lng1 <= -122.43133) && (lat1 <= 47.24883 && lat1 >= 47.24258)){
            //lat1 = Math.floor(2.2 * ((lat1 - 47.24258) * 100000));
            //lng1 = Math.floor(2.26 * ((lng1 - (-122.44121)) * 100000));
            //imageView.setX(((float)lat1));
            //imageView.setY(((float)lng1)); //383

            lat1 = Math.floor(width * ((((lat1 - 47.24258) * 100000) / 625)));
            lng1 = Math.floor(width * 1.2 * (((lng1 - (-122.44131)) * 100000) / 998));
            //textview3.setText(height);
            //textview4.setText(width);
            //textview1.setText(lat);
            //textview2.setText(lng);
            imageView.setX((float)lat1);
            imageView.setY((float)lng1);
            //imageView.setY(2500);

        }
    }
}