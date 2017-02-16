package com.lasalle.second.part.mapsintroduction;

import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class MapWithMapViewActivity extends AppCompatActivity implements OnMapReadyCallback {

    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_with_map_view);

        mapView = (MapView) findViewById(R.id.map_view);

        mapView.onCreate(savedInstanceState);

        try {
            MapsInitializer.initialize(getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mapView.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLngBounds bounds = new LatLngBounds(
                new LatLng(41.338669, 2.086029),
                new LatLng(41.450961, 2.22801));

        Geocoder coder = new Geocoder(getApplicationContext());

        try {
            if(!coder.isPresent()) {
                throw new Exception("Coder is not present!");
            }

            List<Address> address = coder.getFromLocationName("Carrer dels quatre camins 30, Barcelona", 5);
            if (!address.isEmpty()) {
                Address location = address.get(0);
                Marker marker = googleMap.addMarker(
                        new MarkerOptions()
                                .position(new LatLng(location.getLatitude(), location.getLongitude())));
                marker.
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(location.getLatitude(), location.getLongitude())));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                marker.
                return false;
            }
        });
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mapView != null) {
            mapView.onDestroy();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(mapView != null) {
            mapView.onResume();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(mapView != null) {
            mapView.onStart();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mapView != null) {
            mapView.onStop();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(mapView != null) {
            mapView.onSaveInstanceState(outState);
        }
    }
}
