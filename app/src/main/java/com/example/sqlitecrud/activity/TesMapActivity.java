package com.example.sqlitecrud.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.sqlitecrud.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class TesMapActivity extends AppCompatActivity implements OnMapReadyCallback,
        GoogleMap.OnMarkerClickListener, GoogleMap.OnMarkerDragListener, GoogleMap.OnMapClickListener {
    private GoogleMap mMap;
    private Marker marker;


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
        marker =  mMap.addMarker(new MarkerOptions()
                .position(ims)
                .draggable(true)
                .title("Marker in IMS"));

//        mMap.setOnMarkerClickListener(this);
//        mMap.setOnMarkerDragListener(this);
        mMap.setOnMapClickListener(this);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ims,15));


    }

    @Override
    public boolean onMarkerClick(@NonNull Marker marker) {

        Toast.makeText(this, "My Position : " + marker.getPosition(), Toast.LENGTH_LONG).show();
//     or   Toast.makeText(this, "My Position : " + marker.getPosition().getLatitude, Toast.LENGTH_LONG).show();


        return false;

    }

    @Override
    public void onMarkerDragStart(@NonNull Marker marker) {
        
    }

    @Override
    public void onMarkerDrag(@NonNull Marker marker) {

    }

    @Override
    public void onMarkerDragEnd(@NonNull Marker marker) {
        Toast.makeText(this, "Lat : " + marker.getPosition().latitude
                + "\nLng : "+marker.getPosition().longitude, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        Toast.makeText(this, "Map Clicked", Toast.LENGTH_LONG).show();
    }
}