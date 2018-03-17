package com.app.arnont.kkminibus.activity;

import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Toolbar;

import com.app.arnont.kkminibus.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapAllActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static final int ACCESS_FINE_LOCATION_INTENT_ID = 3;


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_all);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Toolbar toolbar = findViewById(R.id.toolbarMapAll);
        toolbar.setTitle(R.string.bus_route);
        setActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


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

        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setMapToolbarEnabled(true);

        enableCurrentLocationButton();

        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);

        // Add a marker in Sydney and move the camera
        LatLng latLng = new LatLng(16.438445, 102.836451);
        mMap.addMarker(new MarkerOptions().position(latLng).title("กลางเมือง").snippet(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

        LatLng latLng1 = new LatLng(16.428768, 102.851612);
        mMap.addMarker(new MarkerOptions().position(latLng1).title("ชาตะผดุง").snippet(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng1));

        LatLng latLng2 = new LatLng(16.415613, 102.822637);
        mMap.addMarker(new MarkerOptions().position(latLng2).title("ทางรถไฟ").snippet(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng2));

        LatLng latLng3 = new LatLng(16.428739, 102.854318);
        mMap.addMarker(new MarkerOptions().position(latLng3).title("บ้านบะขาม").snippet(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng3));

        LatLng latLng4 = new LatLng(16.414864, 102.874371);
        mMap.addMarker(new MarkerOptions().position(latLng4).title("บ้านหนองไฮ").snippet(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng4));

        LatLng latLng5 = new LatLng(16.427275, 102.870638);
        mMap.addMarker(new MarkerOptions().position(latLng5).title("ประชาสโมสร").snippet(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng5));

        LatLng latLng6 = new LatLng(16.421426, 102.820540);
        mMap.addMarker(new MarkerOptions().position(latLng6).title("ม - ภาค").snippet(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng6));

        //มลิวรรณ

        LatLng latLng8 = new LatLng(16.498304, 102.832508);
        mMap.addMarker(new MarkerOptions().position(latLng8).title("มิตรภาพ").snippet(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng8));

        LatLng latLng9 = new LatLng(16.462070, 102.798958);
        mMap.addMarker(new MarkerOptions().position(latLng9).title("ร - 8").snippet(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng9));

        LatLng latLng10 = new LatLng(16.406101, 102.839402);
        mMap.addMarker(new MarkerOptions().position(latLng10).title("รอบบึงแก่นนคร").snippet(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng10));

        LatLng latLng11 = new LatLng(16.426794, 102.874816);
        mMap.addMarker(new MarkerOptions().position(latLng11).title("ศรีจันทร์").snippet(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng11));

        LatLng latLng12 = new LatLng(16.438666, 102.834748);
        mMap.addMarker(new MarkerOptions().position(latLng12).title("ูนย์ราชการ - ทุ่งสร้าง").snippet(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng12));

        LatLng latLng13 = new LatLng(16.438631, 102.834744);
        mMap.addMarker(new MarkerOptions().position(latLng13).title("หน้าเมือง").snippet(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng13));

        LatLng latLng14 = new LatLng(16.440927, 102.819076);
        mMap.addMarker(new MarkerOptions().position(latLng14).title("หลังหอกาฬ").snippet(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng14));

        LatLng latLng15 = new LatLng(16.406098, 102.784713);
        mMap.addMarker(new MarkerOptions().position(latLng15).title("เหล่านาดี").snippet(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng15));

        // มลิวรรณ
        LatLng latLng7 = new LatLng(16.439512, 102.828740);
        mMap.addMarker(new MarkerOptions().position(latLng7).title("มลิวรรณ").snippet(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng7,12));

    }


    private void enableCurrentLocationButton() {
        //before further proceed check if google map is null or not because this method is calling after giving permission
        if (mMap != null) {
            if (ContextCompat.checkSelfPermission(MapAllActivity.this,
                    android.Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED)
                requestLocationPermission();
            else {
                mMap.getUiSettings().setMyLocationButtonEnabled(true);//enable Location button, if you don't want MyLocationButton set it false
                mMap.setMyLocationEnabled(true);//enable blue dot
            }
        }
    }
    private void requestLocationPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(MapAllActivity.this, android.Manifest.permission.ACCESS_FINE_LOCATION)) {
            ActivityCompat.requestPermissions(MapAllActivity.this,
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    ACCESS_FINE_LOCATION_INTENT_ID);

        } else {
            ActivityCompat.requestPermissions(MapAllActivity.this,
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    ACCESS_FINE_LOCATION_INTENT_ID);
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.pop_out, R.anim.pop_out_exit);
    }
}
