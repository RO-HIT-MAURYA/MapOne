package com.example.studio.mapone;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     * 27.1750° N, 78.0422° E
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pins);

        LatLng latLng = new LatLng(19.2059, 72.8737);
        Marker marker = googleMap.addMarker(new MarkerOptions().position(latLng).title("Thakur college").icon(BitmapDescriptorFactory.fromBitmap(bitmap)));
        marker.setTag(0);

        //googleMap.addMarker(new MarkerOptions().position(latLng).title("Thakur college").icon(BitmapDescriptorFactory.fromBitmap(bitmap)));

        //googleMap.addMarker(new MarkerOptions().position(latLng).title("Gate way of India").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));


        latLng = new LatLng(19.1982, 72.8737);
        marker = googleMap.addMarker(new MarkerOptions().position(latLng).title("Lokhandawala Township").icon(BitmapDescriptorFactory.fromBitmap(bitmap)));
        marker.setTag(1);
        //googleMap.addMarker(new MarkerOptions().position(latLng).title("Lokhandawala Township").icon(BitmapDescriptorFactory.fromBitmap(bitmap)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 13));

        googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                return false;
            }
        });

    }
}
