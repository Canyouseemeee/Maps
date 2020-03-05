package com.app.maps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Simple2mapActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple2map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);
    }

    public void onMapReady(GoogleMap googleMap) {
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(new LatLng(13.5236257, 100.7541701));
        markerOptions.title("DRU");
        markerOptions.snippet("Dru sp");
        markerOptions.icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));
        googleMap.addMarker(markerOptions);

        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(13.5236257, 100.7541701), 15));

        googleMap.setMinZoomPreference(12);
        googleMap.setMaxZoomPreference(18);
//        googleMap.setMyLocationEnabled(true);
    }
}
