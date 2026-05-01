package com.example.map;

import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Map Fragment load
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
    }

    // Map ready होने पर यह function call होता है
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Pune location
        LatLng pune = new LatLng(18.5204, 73.8567);

        // Marker add
        mMap.addMarker(new MarkerOptions().position(pune).title("Pune"));

        // Camera move
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pune, 12));
    }
}