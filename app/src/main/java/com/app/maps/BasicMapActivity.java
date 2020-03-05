package com.app.maps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class BasicMapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private LatLng latlngDRU = new LatLng(13.5236257,100.7541701);
    private LatLng latlngOther = new LatLng(13.5436257,100.7541701);
    private Marker mMarker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple2map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.maps);
        mapFragment.getMapAsync( this);
    }

    @Override
    public void onMapReady (GoogleMap googleMap){

        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlngDRU,15));

        if(mMarker != null){
            mMarker.remove();
        }

        mMarker = googleMap.addMarker(new MarkerOptions()
                .position(latlngDRU)
                .title("DRU")
                .snippet("DRU sp")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));
        mMarker = googleMap.addMarker(new MarkerOptions()
                .position(latlngOther)
                .title("Orther")
                .snippet("orther")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));

    }
}
