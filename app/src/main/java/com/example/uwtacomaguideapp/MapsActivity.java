package com.example.uwtacomaguideapp;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

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
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback, LocationListener {
    private FusedLocationProviderClient fusedLocationClient;
    private GoogleMap globalGoogleMap;
    private Marker m;
    public static final String GPS_PROVIDER = "gps";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        EdgeToEdge.enable(this);
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        AtomicBoolean permissions = new AtomicBoolean(false);
        ActivityResultLauncher<String[]> locationPermissionRequest =
                registerForActivityResult(new ActivityResultContracts
                                .RequestMultiplePermissions(), result -> {
                            Boolean fineLocationGranted = result.getOrDefault(
                                    Manifest.permission.ACCESS_FINE_LOCATION, false);
                            Boolean coarseLocationGranted = result.getOrDefault(
                                    Manifest.permission.ACCESS_COARSE_LOCATION,false);
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
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
        });

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        locationManager.requestLocationUpdates("gps", 400, 0.1f, this);


    }
    protected void onResume() {
        super.onResume();

    }
    public void onLocationChanged(@NonNull Location location) {

        double lat1 = location.getLatitude();
        double lng1 = location.getLongitude();
        LatLng sydney = new LatLng(lat1, lng1);
        m.setPosition(sydney);


    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        globalGoogleMap = googleMap;
        double lat1 = 47.24558;
        double lng1 = -122.43801;
        LatLng sydney = new LatLng(lat1, lng1);
        m = globalGoogleMap.addMarker(new MarkerOptions()
                .position(sydney)
            );
        LatLng uwt1 = new LatLng(47.24700159629406, -122.44145650138451);
        GroundOverlayOptions uwtmap1 = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.row1column1))
                .position(uwt1, 170f, 150f);
        globalGoogleMap.addGroundOverlay(uwtmap1);
        LatLng uwt2 = new LatLng(47.24700159629406, -122.439345650138451);
        GroundOverlayOptions uwtmap2 = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.row1column2))
                .position(uwt2, 170f, 150f);
        globalGoogleMap.addGroundOverlay(uwtmap2);
        LatLng uwt3 = new LatLng(47.24700159629406, -122.437145650138451);
        GroundOverlayOptions uwtmap3 = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.row1column3))
                .position(uwt3, 170f, 150f);
        globalGoogleMap.addGroundOverlay(uwtmap3);
        LatLng uwt4 = new LatLng(47.24700159629406, -122.435145650138451);
        GroundOverlayOptions uwtmap4 = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.row1column4))
                .position(uwt4, 170f, 150f);
        globalGoogleMap.addGroundOverlay(uwtmap4);
        LatLng uwt5 = new LatLng(47.24565159629406, -122.44145650138451);
        GroundOverlayOptions uwtmap5 = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.row2column1))
                .position(uwt5, 170f, 150f);
        globalGoogleMap.addGroundOverlay(uwtmap5);
        LatLng uwt6 = new LatLng(47.24565159629406, -122.439345650138451);
        GroundOverlayOptions uwtmap6 = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.row2column2))
                .position(uwt6, 170f, 150f);
        globalGoogleMap.addGroundOverlay(uwtmap6);
        LatLng uwt7 = new LatLng(47.24565159629406, -122.437145650138451);
        GroundOverlayOptions uwtmap7 = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.row2column3))
                .position(uwt7, 170f, 150f);
        globalGoogleMap.addGroundOverlay(uwtmap7);
        LatLng uwt8 = new LatLng(47.24565159629406, -122.435145650138451);
        GroundOverlayOptions uwtmap8 = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.row2column4))
                .position(uwt8, 170f, 150f);
        globalGoogleMap.addGroundOverlay(uwtmap8);
        LatLng uwt9 = new LatLng(47.24435159629406, -122.44145650138451);
        GroundOverlayOptions uwtmap9 = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.row3column1))
                .position(uwt9, 170f, 150f);
        globalGoogleMap.addGroundOverlay(uwtmap9);
        LatLng uwt10 = new LatLng(47.24435159629406, -122.439345650138451);
        GroundOverlayOptions uwtmap10 = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.row3column2))
                .position(uwt10, 170f, 150f);
        globalGoogleMap.addGroundOverlay(uwtmap10);
        LatLng uwt11 = new LatLng(47.24435159629406, -122.437145650138451);
        GroundOverlayOptions uwtmap11 = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.row3column3))
                .position(uwt11, 170f, 150f);
        globalGoogleMap.addGroundOverlay(uwtmap11);
        LatLng uwt12 = new LatLng(47.24435159629406, -122.435145650138451);
        GroundOverlayOptions uwtmap12 = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.row3column4))
                .position(uwt12, 170f, 150f);
        globalGoogleMap.addGroundOverlay(uwtmap12);
        LatLng uwt13 = new LatLng(47.24305159629406, -122.44145650138451);
        GroundOverlayOptions uwtmap13 = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.row4column1))
                .position(uwt13, 170f, 150f);
        globalGoogleMap.addGroundOverlay(uwtmap13);
        LatLng uwt14 = new LatLng(47.24305159629406, -122.439345650138451);
        GroundOverlayOptions uwtmap14 = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.row4column2))
                .position(uwt14, 170f, 150f);
        globalGoogleMap.addGroundOverlay(uwtmap14);
        LatLng uwt15 = new LatLng(47.24305159629406, -122.437145650138451);
        GroundOverlayOptions uwtmap15 = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.row4column3))
                .position(uwt15, 170f, 150f);
        globalGoogleMap.addGroundOverlay(uwtmap15);
        LatLng uwt16 = new LatLng(47.24305159629406, -122.435145650138451);
        GroundOverlayOptions uwtmap16 = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.row4column4))
                .position(uwt16, 170f, 150f);
        globalGoogleMap.addGroundOverlay(uwtmap16);

    }



}