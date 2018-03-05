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
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
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
                LatLng mapCenter3 = new LatLng(16.426794, 102.874816);
                map.addMarker(new MarkerOptions().position(mapCenter3).title("Start").snippet("stay with my girlfriend").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                LatLng mapCenter4 = new LatLng(16.438230, 102.775181);
                map.addMarker(new MarkerOptions().position(mapCenter4).title("Stop").snippet("stay with my girlfriend").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter3, 16));
                map.addPolyline(new PolylineOptions().geodesic(true)
                        .add(new LatLng(16.426794, 102.874816))
                        .add(new LatLng(16.427133, 102.870654))
                        .add(new LatLng(16.427585, 102.865565))
                        .add(new LatLng(16.428050, 102.861020))
                        .add(new LatLng(16.428358, 102.857061))
                        .add(new LatLng(16.428635, 102.853982))
                        .add(new LatLng(16.428717, 102.850742))
                        .add(new LatLng(16.428696, 102.847888))
                        .add(new LatLng(16.428802, 102.846814))
                        .add(new LatLng(16.429151, 102.844218))
                        .add(new LatLng(16.429488, 102.842028))
                        .add(new LatLng(16.429918, 102.839321))
                        .add(new LatLng(16.430154, 102.837358))
                        .add(new LatLng(16.430369, 102.835670))
                        .add(new LatLng(16.432024, 102.835868))
                        .add(new LatLng(16.433927, 102.836073))
                        .add(new LatLng(16.435972, 102.836309))
                        .add(new LatLng(16.436510, 102.836376))
                        .add(new LatLng(16.437185, 102.836302))
                        .add(new LatLng(16.438398, 102.836468))
                        .add(new LatLng(16.438828, 102.834342))
                        .add(new LatLng(16.439116, 102.832132))
                        .add(new LatLng(16.439283, 102.830790))
                        .add(new LatLng(16.438530, 102.830610))
                        .add(new LatLng(16.437814, 102.830442))
                        .add(new LatLng(16.436606, 102.830125))
                        .add(new LatLng(16.435505, 102.829813))
                        .add(new LatLng(16.434829, 102.829619))
                        .add(new LatLng(16.434129, 102.829426))
                        .add(new LatLng(16.432787, 102.829111))
                        .add(new LatLng(16.431341, 102.828706))
                        .add(new LatLng(16.431580, 102.826718))
                        .add(new LatLng(16.432104, 102.823285))
                        .add(new LatLng(16.432224, 102.822480))
                        .add(new LatLng(16.432339, 102.822201))
                        .add(new LatLng(16.432563, 102.820139))
                        .add(new LatLng(16.432767, 102.819473))
                        .add(new LatLng(16.433595, 102.818970))
                        .add(new LatLng(16.434490, 102.817813))
                        .add(new LatLng(16.434707, 102.817323))
                        .add(new LatLng(16.434764, 102.816906))
                        .add(new LatLng(16.434586, 102.816053))
                        .add(new LatLng(16.434129, 102.814796))
                        .add(new LatLng(16.433810, 102.814268))
                        .add(new LatLng(16.433494, 102.813400))
                        .add(new LatLng(16.433501, 102.813009))
                        .add(new LatLng(16.433742, 102.811577))
                        .add(new LatLng(16.434379, 102.808965))
                        .add(new LatLng(16.434711, 102.807712))
                        .add(new LatLng(16.434685, 102.807443))
                        .add(new LatLng(16.434659, 102.806936))
                        .add(new LatLng(16.434896, 102.804676))
                        .add(new LatLng(16.435022, 102.803544))
                        .add(new LatLng(16.435285, 102.802445))
                        .add(new LatLng(16.435629, 102.801074))
                        .add(new LatLng(16.435905, 102.800162))
                        .add(new LatLng(16.436481, 102.798869))
                        .add(new LatLng(16.436957, 102.797906))
                        .add(new LatLng(16.437199, 102.797292))
                        .add(new LatLng(16.437338, 102.796858))
                        .add(new LatLng(16.437489, 102.796203))
                        .add(new LatLng(16.437600, 102.795724))
                        .add(new LatLng(16.437608, 102.795094))
                        .add(new LatLng(16.437547, 102.794211))
                        .add(new LatLng(16.437532, 102.793262))
                        .add(new LatLng(16.437501, 102.792115))
                        .add(new LatLng(16.437498, 102.791938))
                        .add(new LatLng(16.437753, 102.791042))
                        .add(new LatLng(16.437905, 102.790426))
                        .add(new LatLng(16.438034, 102.789509))
                        .add(new LatLng(16.438142, 102.788629))
                        .add(new LatLng(16.438245, 102.787535))
                        .add(new LatLng(16.438240, 102.786854))
                        .add(new LatLng(16.438240, 102.785062))
                        .add(new LatLng(16.438204, 102.783276))
                        .add(new LatLng(16.438173, 102.781559))
                        .add(new LatLng(16.438225, 102.779403))
                        .add(new LatLng(16.438230, 102.775181))
                        .color(getResources().getColor(R.color.green))
                );
                break;
            case "รถสองแถว สาย 3":
                LatLng mapCenter2 = new LatLng(16.389369, 102.806185);
                map.addMarker(new MarkerOptions().position(mapCenter2).title("Start").snippet("stay with my girlfriend"));
                LatLng mapCenter1 = new LatLng(16.427065, 102.872894);
                map.addMarker(new MarkerOptions().position(mapCenter1).title("Stop").snippet("stay with my girlfriend"));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter2, 16));
                map.addPolyline(new PolylineOptions().geodesic(true)
                        .add(new LatLng(16.389369, 102.806185))
                        .add(new LatLng(16.389066, 102.807493))
                        .add(new LatLng(16.388830, 102.808600))
                        .add(new LatLng(16.388577, 102.809616))
                        .add(new LatLng(16.388255, 102.810962))
                        .add(new LatLng(16.389612, 102.811369))
                        .add(new LatLng(16.390332, 102.811540))
                        .add(new LatLng(16.391917, 102.812087))
                        .add(new LatLng(16.393389, 102.812560))
                        .add(new LatLng(16.395165, 102.813105))
                        .add(new LatLng(16.396805, 102.813643))
                        .add(new LatLng(16.398452, 102.814083))
                        .add(new LatLng(16.400161, 102.814609))
                        .add(new LatLng(16.401766, 102.815059))
                        .add(new LatLng(16.403279, 102.815435))
                        .add(new LatLng(16.405080, 102.815939))
                        .add(new LatLng(16.406778, 102.816401))
                        .add(new LatLng(16.408311, 102.816841))
                        .add(new LatLng(16.409248, 102.817056))
                        .add(new LatLng(16.410266, 102.817270))
                        .add(new LatLng(16.411648, 102.817670))
                        .add(new LatLng(16.412768, 102.818019))
                        .add(new LatLng(16.413540, 102.818292))
                        .add(new LatLng(16.414049, 102.818307))
                        .add(new LatLng(16.414821, 102.818550))
                        .add(new LatLng(16.415325, 102.819237))
                        .add(new LatLng(16.415325, 102.819237))
                        .add(new LatLng(16.415953, 102.820588))
                        .add(new LatLng(16.416004, 102.821017))
                        .add(new LatLng(16.415839, 102.821736))
                        .add(new LatLng(16.415613, 102.822637))
                        .add(new LatLng(16.416580, 102.822927))
                        .add(new LatLng(16.415613, 102.822637))
                        .add(new LatLng(16.418124, 102.823348))
                        .add(new LatLng(16.418489, 102.823428))
                        .add(new LatLng(16.418489, 102.823428))
                        .add(new LatLng(16.419914, 102.823847))
                        .add(new LatLng(16.420496, 102.824013))
                        .add(new LatLng(16.420964, 102.824152))
                        .add(new LatLng(16.420964, 102.824152))
                        .add(new LatLng(16.420964, 102.824152))
                        .add(new LatLng(16.422485, 102.824565))
                        .add(new LatLng(16.422975, 102.824744))
                        .add(new LatLng(16.422975, 102.824744))
                        .add(new LatLng(16.422975, 102.824744))
                        .add(new LatLng(16.422975, 102.824744))
                        .add(new LatLng(16.425402, 102.825527))
                        .add(new LatLng(16.426066, 102.825709))
                        .add(new LatLng(16.426462, 102.825859))
                        .add(new LatLng(16.426462, 102.825859))
                        .add(new LatLng(16.426976, 102.826002))
                        .add(new LatLng(16.426981, 102.826093))
                        .add(new LatLng(16.426894, 102.826228))
                        .add(new LatLng(16.426768, 102.826271))
                        .add(new LatLng(16.426639, 102.826250))
                        .add(new LatLng(16.426495, 102.826864))
                        .add(new LatLng(16.426285, 102.827471))
                        .add(new LatLng(16.426178, 102.828176))
                        .add(new LatLng(16.426647, 102.828254))
                        .add(new LatLng(16.427306, 102.828407))
                        .add(new LatLng(16.428085, 102.828597))
                        .add(new LatLng(16.429256, 102.828893))
                        .add(new LatLng(16.429256, 102.828893))
                        .add(new LatLng(16.429256, 102.828893))
                        .add(new LatLng(16.429256, 102.828893))
                        .add(new LatLng(16.429256, 102.828893))
                        .add(new LatLng(16.429256, 102.828893))
                        .add(new LatLng(16.431170, 102.828117))
                        .add(new LatLng(16.431420, 102.827881))
                        .add(new LatLng(16.431523, 102.827280))
                        .add(new LatLng(16.431523, 102.827280))
                        .add(new LatLng(16.431523, 102.827280))
                        .add(new LatLng(16.431523, 102.827280))
                        .add(new LatLng(16.431986, 102.823987))
                        .add(new LatLng(16.432068, 102.823381))
                        .add(new LatLng(16.432068, 102.823381))
                        .add(new LatLng(16.432068, 102.823381))
                        .add(new LatLng(16.433360, 102.823840))
                        .add(new LatLng(16.433821, 102.823994))
                        .add(new LatLng(16.433821, 102.823994))
                        .add(new LatLng(16.433821, 102.823994))
                        .add(new LatLng(16.435662, 102.825018))
                        .add(new LatLng(16.436274, 102.825469))
                        .add(new LatLng(16.436763, 102.825909))
                        .add(new LatLng(16.438281, 102.827288))
                        .add(new LatLng(16.439017, 102.827921))
                        .add(new LatLng(16.439017, 102.827921))
                        .add(new LatLng(16.439727, 102.828484))
                        .add(new LatLng(16.439727, 102.828484))
                        .add(new LatLng(16.439727, 102.828484))
                        .add(new LatLng(16.439102, 102.833018))
                        .add(new LatLng(16.439102, 102.833018))
                        .add(new LatLng(16.437631, 102.834648))
                        .add(new LatLng(16.437631, 102.834648))
                        .add(new LatLng(16.437631, 102.834648))
                        .add(new LatLng(16.437631, 102.834648))
                        .add(new LatLng(16.437631, 102.834648))
                        .add(new LatLng(16.437631, 102.834648))
                        .add(new LatLng(16.437631, 102.834648))
                        .add(new LatLng(16.426791, 102.833517))
                        .add(new LatLng(16.425654, 102.833426))
                        .add(new LatLng(16.425609, 102.833947))
                        .add(new LatLng(16.425511, 102.835001))
                        .add(new LatLng(16.425511, 102.835001))
                        .add(new LatLng(16.426047, 102.835106))
                        .add(new LatLng(16.426047, 102.835106))
                        .add(new LatLng(16.426047, 102.835106))
                        .add(new LatLng(16.428210, 102.835414))
                        .add(new LatLng(16.428210, 102.835414))
                        .add(new LatLng(16.429594, 102.835586))
                        .add(new LatLng(16.429594, 102.835586))
                        .add(new LatLng(16.430111, 102.837685))
                        .add(new LatLng(16.430029, 102.838710))
                        .add(new LatLng(16.429731, 102.840888))
                        .add(new LatLng(16.429617, 102.841725))
                        .add(new LatLng(16.429432, 102.843077))
                        .add(new LatLng(16.429432, 102.843077))
                        .add(new LatLng(16.429432, 102.843077))
                        .add(new LatLng(16.428835, 102.849793))
                        .add(new LatLng(16.428804, 102.853741))
                        .add(new LatLng(16.428804, 102.853741))
                        .add(new LatLng(16.428804, 102.853741))
                        .add(new LatLng(16.428804, 102.853741))
                        .add(new LatLng(16.427610, 102.866906))
                        .add(new LatLng(16.427291, 102.870619))
                        .add(new LatLng(16.427065, 102.872894))
                        .color(getResources().getColor(R.color.gold))
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
