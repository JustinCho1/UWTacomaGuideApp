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

public class MainActivity3 extends AppCompatActivity implements LocationListener{
    Button button1;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        button1 = (Button) findViewById(R.id.button4);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(intent);
            }
        });
        button2 = (Button) findViewById(R.id.button7);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                startActivity(intent);
            }
        });
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

    }
    protected void onResume() {

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
        setContentView(R.layout.activity_main3);

        button1 = (Button) findViewById(R.id.button4);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(intent);
            }
        });
        button2 = (Button) findViewById(R.id.button7);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                startActivity(intent);
            }
        });

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates("gps", 400, 0.1f, this);
    }
    public void onLocationChanged(@NonNull Location location) {
        setContentView(R.layout.activity_main3);
        button1 = (Button) findViewById(R.id.button4);
        TextView textview1 = findViewById(R.id.textView7);
        TextView textview2 = findViewById(R.id.textView3);
        TextView textview3 = findViewById(R.id.textView4);
        TextView textview4 = findViewById(R.id.textView6);
        TextView textview5 = findViewById(R.id.textView8);
        TextView textview6 = findViewById(R.id.textView9);
        ImageView imageView1 = findViewById(R.id.imageView4);
        ImageView imageView2 = findViewById(R.id.imageView6);
        ImageView imageView3 = findViewById(R.id.imageView7);
        ImageView imageView4 = findViewById(R.id.imageView26);
        ImageView imageView5 = findViewById(R.id.imageView29);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(intent);
            }
        });
        double lat1 = location.getLatitude();
        double lng1 = location.getLongitude();
        if((lat1 >= 47.24524 && lat1 <= 47.24710) && (lng1 >= -122.43794 && lng1 <= -122.43555)){
            textview1.setText("You are now in the east side of Pacific Avnue Road. Available Restraunts include: ");
            textview2.setText("S-level Tea");
            textview3.setText("Hot Rod Dog");
            textview4.setText("Jimmy Johns");
            textview5.setText("Sam Choy's Poke");
            textview6.setText("Zeek's Pizza");
            imageView1.setImageResource(R.drawable.sleveltea);
            imageView2.setImageResource(R.drawable.hotdog);
            imageView3.setImageResource(R.drawable.jimmyjohns);
            imageView4.setImageResource(R.drawable.samchoys);
            imageView5.setImageResource(R.drawable.zeeks);
        }
        else if((lat1 >= 47.24305 && lat1 <= 47.24524) && (lng1 >= -122.43794 && lng1 <= -122.43555)) {
            textview1.setText("You are now in the west side of Pacific Avnue Road. Available Restraunts include: ");
            textview2.setText("Subway");
            textview3.setText("Abella Pizzeria");
            textview4.setText("Crisp Greens");
            textview5.setText("Indochine");
            textview6.setText("Anthem Coffee");
            imageView1.setImageResource(R.drawable.subway);
            imageView2.setImageResource(R.drawable.abella);
            imageView3.setImageResource(R.drawable.crispgreens);
            imageView4.setImageResource(R.drawable.indochine);
            imageView5.setImageResource(R.drawable.anthem);
        }
        else{
            textview1.setText("As you walk around the UWT campus, this page will find places to eat near you");
            textview2.setText("(blank)");
            textview3.setText("(blank)");
            textview4.setText("(blank)");
            textview5.setText("");
            imageView1.setImageResource(R.drawable.blank);
            imageView2.setImageResource(R.drawable.blank);
            imageView3.setImageResource(R.drawable.blank);
        }
    }
}