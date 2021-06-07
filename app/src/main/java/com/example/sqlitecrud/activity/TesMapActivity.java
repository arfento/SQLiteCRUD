package com.example.sqlitecrud.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sqlitecrud.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class TesMapActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tes_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.tesmap);
        mapFragment.getMapAsync(this);
    }

    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng ims = new LatLng(-6.1782192,106.8129103);
        mMap.addMarker(new MarkerOptions()
                .position(ims)
                .title("Marker in IMS"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ims,15));


    }


}