package com.app.arnont.kkminibus.activity;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.app.arnont.kkminibus.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapAllActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_all);
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
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng latLng = new LatLng(16.426794, 102.874816);
        mMap.addMarker(new MarkerOptions().position(latLng).title("รถสองแถว สาย 2"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

        LatLng latLng1 = new LatLng(16.389369, 102.806185);
        mMap.addMarker(new MarkerOptions().position(latLng1).title("รถสองแถว สาย 3"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng1));

        LatLng latLng2 = new LatLng(16.389369, 102.806185);
        mMap.addMarker(new MarkerOptions().position(latLng2).title("รถสองแถว สาย 4"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng2));

        LatLng latLng3 = new LatLng(16.426787, 102.833517);
        mMap.addMarker(new MarkerOptions().position(latLng3).title("รถสองแถว สาย 5"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng3));

        LatLng latLng4 = new LatLng(16.389369, 102.806185);
        mMap.addMarker(new MarkerOptions().position(latLng4).title("รถสองแถว สาย 6"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng4));

        LatLng latLng5 = new LatLng(16.389369, 102.806185);
        mMap.addMarker(new MarkerOptions().position(latLng5).title("รถสองแถว สาย 12"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng5,14));

        LatLng latLng6 = new LatLng(16.426508, 102.835147);
        mMap.addMarker(new MarkerOptions().position(latLng6).title("รถสองแถว สาย 18"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng6));

        LatLng latLng7 = new LatLng(16.426633, 102.834391);
        mMap.addMarker(new MarkerOptions().position(latLng7).title("รถสองแถว สาย 19"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng7));

        LatLng latLng8 = new LatLng(16.426633, 102.834391);
        mMap.addMarker(new MarkerOptions().position(latLng8).title("รถสองแถว สาย 20"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng8));

        LatLng latLng9 = new LatLng(16.414864, 102.874371);
        mMap.addMarker(new MarkerOptions().position(latLng9).title("รถสองแถว สาย 22"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng9));

        LatLng latLng10 = new LatLng(16.389369, 102.806185);
        mMap.addMarker(new MarkerOptions().position(latLng10).title("รถสองแถว สาย 23"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng10));

    }
}
