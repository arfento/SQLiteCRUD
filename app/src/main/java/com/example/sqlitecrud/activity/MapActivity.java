package com.example.sqlitecrud.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sqlitecrud.R;
import com.google.android.gms.maps.OnMapReadyCallback;

public class MapActivity extends AppCompatActivity {

    Button btnOjek, btnPlaceAutoComplete, btnDirection, btnMapMarker,btnCurrentPlace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                Toast.makeText(this, "Membutuhkan Izin Lokasi", Toast.LENGTH_SHORT).show();
            } else {

                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                        1);
            }
        } else {
            // Permission has already been granted
            Toast.makeText(this, "Izin Lokasi diberikan", Toast.LENGTH_SHORT).show();
        }

        openAutoPlace();
        openDirectionMap();
        openOjek();
        openMapMarker();
        openCurrentPlace();
    }





    public void openOjek(){
        btnOjek= (Button)findViewById(R.id.btn_ojek);
        btnOjek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentOjek = new Intent(MapActivity.this, OjekActivity.class);
                startActivity(intentOjek);

            }
        });
    }
    public void openMapMarker(){
        btnMapMarker= (Button)findViewById(R.id.btn_mapmarker);
        btnMapMarker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMapMarker = new Intent(MapActivity.this, TesMapActivity.class);
                startActivity(intentMapMarker);

            }
        });
    }
    public void openDirectionMap(){
        btnDirection= (Button)findViewById(R.id.btn_direction);
        btnDirection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDirection = new Intent(MapActivity.this, DirectionActivity.class);
                startActivity(intentDirection);

            }
        });
    }
    public void openAutoPlace(){
        btnPlaceAutoComplete= (Button)findViewById(R.id.btn_place);
        btnPlaceAutoComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPlace = new Intent(MapActivity.this, PlaceAutoCompleteActivity.class);
                startActivity(intentPlace);

            }
        });
    }
    public void openCurrentPlace(){
        btnCurrentPlace= (Button)findViewById(R.id.btn_current_place);
        btnCurrentPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCurrentPlace = new Intent(MapActivity.this, CurrentPlaceActivity.class);
                startActivity(intentCurrentPlace);

            }
        });
    }
}