package com.giogen.mapitas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    SupportMapFragment mapFragment;
    GoogleMap map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapFragment   = SupportMapFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.map, mapFragment)
                .commit();
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.addMarker(new MarkerOptions()
                .position(new LatLng(0, 0))
                .title("Marker"));
LatLng sydney = new LatLng(-33.852,151.211);

        map.addMarker(new MarkerOptions()
                .position(sydney)
                .title("Marker"));


        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLng(sydney);

        CameraPosition cameraPosition = CameraPosition.builder().target(new LatLng(20.139295, -101.150777))
                .zoom(15)
                .tilt(67)
                .bearing(90).build();
      //  cameraUpdate = CameraUpdateFactory();
      //  map.animateCamera(cameraUpdate);
        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}