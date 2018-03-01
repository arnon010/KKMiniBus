package com.app.arnont.kkminibus.activity;

import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import com.app.arnont.kkminibus.fragment.ItemListDialogFragment;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationServices;

import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import com.app.arnont.kkminibus.R;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsDetailActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap map;
    TextView txtMiniBusDetail;
    private static GoogleApiClient mGoogleApiClient;
    private static final int ACCESS_FINE_LOCATION_INTENT_ID = 3;
    String txtFix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_detail);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Toolbar toolbar = findViewById(R.id.toolbarDetailMiniBus);
        toolbar.setTitle(R.string.detail_mini_bus);
        setActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        String savedExtra = getIntent().getStringExtra("minibus");
        txtMiniBusDetail = findViewById(R.id.txtMiniBusDetail);
        txtMiniBusDetail.setText(savedExtra);

        txtFix = txtMiniBusDetail.getText().toString();

        ItemListDialogFragment fragment = ItemListDialogFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.map_fragment_container,fragment).commit();


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.pop_out, R.anim.pop_out_exit);
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
        map = googleMap;

        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        map.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        map.moveCamera(CameraUpdateFactory.newLatLng(sydney));


        map.getUiSettings().setZoomControlsEnabled(true);
        map.getUiSettings().setCompassEnabled(true);
        map.getUiSettings().setMyLocationButtonEnabled(true);
        map.getUiSettings().setMapToolbarEnabled(true);
        map.setPadding(0,0,0,120);
        enableCurrentLocationButton();




        // Polylines
        switch (txtFix) {
            case "รถสองแถว สาย 2":
                LatLng mapCenter3 = new LatLng(16.426973, 102.872721);
                map.addMarker(new MarkerOptions().position(mapCenter3).title("Start").snippet("stay with my girlfriend"));
                LatLng mapCenter4 = new LatLng(16.436582, 102.765653);
                map.addMarker(new MarkerOptions().position(mapCenter4).title("Stop").snippet("stay with my girlfriend"));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter3, 16));
                map.addPolyline(new PolylineOptions().geodesic(true)
                        .add(new LatLng(16.426973, 102.872721))
                        .add(new LatLng(16.430299, 102.836118))
                        .add(new LatLng(16.426504, 102.835148))
                        .add(new LatLng(16.426627, 102.834347))
                        .add(new LatLng(16.426807, 102.833516))
                        .add(new LatLng(16.429133, 102.833773))
                        .add(new LatLng(16.432915, 102.834159))
                        .add(new LatLng(16.437010, 102.834577))
                        .add(new LatLng(16.438736, 102.834741))
                        .add(new LatLng(16.439240, 102.830803))
                        .add(new LatLng(16.431367, 102.828682))
                        .add(new LatLng(16.432690, 102.819577))
                        .add(new LatLng(16.434429, 102.817839))
                        .add(new LatLng(16.434660, 102.816369))
                        .add(new LatLng(16.433497, 102.813097))
                        .add(new LatLng(16.434546, 102.808172))
                        .add(new LatLng(16.434854, 102.804792))
                        .add(new LatLng(16.436582, 102.765653))
                );
                break;
            case "Pig":
                LatLng mapCenter2 = new LatLng(13.785056, 100.630257);
                map.addMarker(new MarkerOptions().position(mapCenter2).title("Start").snippet("stay with my girlfriend"));
                LatLng mapCenter1 = new LatLng(13.787607, 100.630293);
                map.addMarker(new MarkerOptions().position(mapCenter1).title("Stop").snippet("stay with my girlfriend"));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter2, 16));
                map.addPolyline(new PolylineOptions().geodesic(true)
                        .add(new LatLng(13.785056, 100.630257))
                        .add(new LatLng(13.786084, 100.629872))
                        .add(new LatLng(13.786338, 100.631763))
                        .add(new LatLng(13.787390, 100.631443))
                        .add(new LatLng(13.787252, 100.630990))
                        .add(new LatLng(13.787758, 100.630754))
                        .add(new LatLng(13.787607, 100.630293))
                );
                break;
            default:
                LatLng mapCenter = new LatLng(13.784910, 100.627749);
                map.addMarker(new MarkerOptions().position(mapCenter).title("My room").snippet("stay with my girlfriend"));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter, 16));
                break;

        }
    }

    private void enableCurrentLocationButton() {
        //before further proceed check if google map is null or not because this method is calling after giving permission
        if (map != null) {
            if (ContextCompat.checkSelfPermission(MapsDetailActivity.this,
                    android.Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED)
                requestLocationPermission();
            else {
                map.getUiSettings().setMyLocationButtonEnabled(true);//enable Location button, if you don't want MyLocationButton set it false
                map.setMyLocationEnabled(true);//enable blue dot
            }
        }
    }
    private void requestLocationPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(MapsDetailActivity.this, android.Manifest.permission.ACCESS_FINE_LOCATION)) {
            ActivityCompat.requestPermissions(MapsDetailActivity.this,
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    ACCESS_FINE_LOCATION_INTENT_ID);

        } else {
            ActivityCompat.requestPermissions(MapsDetailActivity.this,
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    ACCESS_FINE_LOCATION_INTENT_ID);
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        //On Pause stop Location Update

        if (mGoogleApiClient != null && mGoogleApiClient.isConnected())
            stopLocationUpdates();
    }

    //Stop Location Update Method
    protected void stopLocationUpdates() {
        LocationServices.FusedLocationApi.removeLocationUpdates(
                mGoogleApiClient, (LocationListener) this);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }
}
