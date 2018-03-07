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
                LatLng mapCenter1 = new LatLng(16.426794, 102.874816);
                map.addMarker(new MarkerOptions().position(mapCenter1).title("Start").snippet("รถสองแถว สาย 2").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                LatLng mapCenter2 = new LatLng(16.438230, 102.775181);
                map.addMarker(new MarkerOptions().position(mapCenter2).title("Stop").snippet("รถสองแถว สาย 2").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter1, 16));
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
                LatLng mapCenter3 = new LatLng(16.389369, 102.806185);
                map.addMarker(new MarkerOptions().position(mapCenter3).title("Start").snippet("รถสองแถว สาย 3").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                LatLng mapCenter4 = new LatLng(16.427065, 102.872894);
                map.addMarker(new MarkerOptions().position(mapCenter4).title("Stop").snippet("รถสองแถว สาย 3").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter3, 16));
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
            case "รถสองแถว สาย 4":
                LatLng mapCenter5 = new LatLng(16.389369, 102.806185);
                map.addMarker(new MarkerOptions().position(mapCenter5).title("Start").snippet("รถสองแถว สาย 4").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                LatLng mapCenter6 = new LatLng(16.444697, 102.793631);
                map.addMarker(new MarkerOptions().position(mapCenter6).title("Stop").snippet("รถสองแถว สาย 4").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter5, 16));
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
                        .add(new LatLng(16.415747, 102.820063))
                        .add(new LatLng(16.415953, 102.820588))
                        .add(new LatLng(16.416004, 102.821017))
                        .add(new LatLng(16.415766, 102.821958))
                        .add(new LatLng(16.414983, 102.824726))
                        .add(new LatLng(16.414427, 102.826968))
                        .add(new LatLng(16.413974, 102.828663))
                        .add(new LatLng(16.413552, 102.830337))
                        .add(new LatLng(16.413439, 102.831260))
                        .add(new LatLng(16.413387, 102.832343))
                        .add(new LatLng(16.413377, 102.833899))
                        .add(new LatLng(16.415374, 102.834081))
                        .add(new LatLng(16.416794, 102.834231))
                        .add(new LatLng(16.417937, 102.834274))
                        .add(new LatLng(16.418750, 102.834478))
                        .add(new LatLng(16.419460, 102.834532))
                        .add(new LatLng(16.420551, 102.834628))
                        .add(new LatLng(16.421981, 102.834757))
                        .add(new LatLng(16.423196, 102.834757))
                        .add(new LatLng(16.425501, 102.835025))
                        .add(new LatLng(16.425643, 102.835068))
                        .add(new LatLng(16.426082, 102.835108))
                        .add(new LatLng(16.426494, 102.835122))
                        .add(new LatLng(16.426957, 102.835175))
                        .add(new LatLng(16.428228, 102.835438))
                        .add(new LatLng(16.428923, 102.835500))
                        .add(new LatLng(16.429651, 102.835580))
                        .add(new LatLng(16.430398, 102.835639))
                        .add(new LatLng(16.431002, 102.835736))
                        .add(new LatLng(16.431427, 102.835755))
                        .add(new LatLng(16.432538, 102.835891))
                        .add(new LatLng(16.433116, 102.835940))
                        .add(new LatLng(16.434045, 102.836082))
                        .add(new LatLng(16.434943, 102.836170))
                        .add(new LatLng(16.436477, 102.836345))
                        .add(new LatLng(16.437064, 102.836307))
                        .add(new LatLng(16.438401, 102.836444))
                        .add(new LatLng(16.438720, 102.834738))
                        .add(new LatLng(16.439008, 102.832721))
                        .add(new LatLng(16.439296, 102.830758))
                        .add(new LatLng(16.439492, 102.829041))
                        .add(new LatLng(16.439561, 102.828413))
                        .add(new LatLng(16.439777, 102.828526))
                        .add(new LatLng(16.440518, 102.828738))
                        .add(new LatLng(16.440762, 102.828784))
                        .add(new LatLng(16.442972, 102.829451))
                        .add(new LatLng(16.443662, 102.829602))
                        .add(new LatLng(16.444652, 102.829951))
                        .add(new LatLng(16.445712, 102.830284))
                        .add(new LatLng(16.448063, 102.830965))
                        .add(new LatLng(16.448750, 102.831059))
                        .add(new LatLng(16.450252, 102.831145))
                        .add(new LatLng(16.452501, 102.831284))
                        .add(new LatLng(16.454312, 102.831410))
                        .add(new LatLng(16.457224, 102.831576))
                        .add(new LatLng(16.458176, 102.831597))
                        .add(new LatLng(16.459946, 102.831710))
                        .add(new LatLng(16.462112, 102.831849))
                        .add(new LatLng(16.463985, 102.831892))
                        .add(new LatLng(16.464685, 102.831919))
                        .add(new LatLng(16.466717, 102.832042))
                        .add(new LatLng(16.468451, 102.832176))
                        .add(new LatLng(16.470895, 102.832294))
                        .add(new LatLng(16.473272, 102.832450))
                        .add(new LatLng(16.475643, 102.832547))
                        .add(new LatLng(16.476523, 102.832504))
                        .add(new LatLng(16.478694, 102.832504))
                        .add(new LatLng(16.480736, 102.832472))
                        .add(new LatLng(16.482655, 102.832515))
                        .add(new LatLng(16.485392, 102.832515))
                        .add(new LatLng(16.487033, 102.832488))
                        .add(new LatLng(16.487851, 102.832477))
                        .add(new LatLng(16.488808, 102.832509))
                        .add(new LatLng(16.491035, 102.832498))
                        .add(new LatLng(16.492846, 102.832482))
                        .add(new LatLng(16.495192, 102.832503))
                        .add(new LatLng(16.498304, 102.832508))
                );
                break;
            case "รถสองแถว สาย 5":
                LatLng mapCenter7 = new LatLng(16.426787, 102.833517);
                map.addMarker(new MarkerOptions().position(mapCenter7).title("Start").snippet("รถสองแถว สาย 5").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                LatLng mapCenter8 = new LatLng(16.448607, 102.767814);
                map.addMarker(new MarkerOptions().position(mapCenter8).title("Stop").snippet("รถสองแถว สาย 5").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter7, 16));
                map.addPolyline(new PolylineOptions().geodesic(true)
                        .add(new LatLng(16.426787, 102.833517))
                        .add(new LatLng(16.428140, 102.833664))
                        .add(new LatLng(16.388830, 102.808600))
                        .add(new LatLng(16.428425, 102.833685))
                        .add(new LatLng(16.429315, 102.833817))
                        .add(new LatLng(16.429933, 102.833882))
                        .add(new LatLng(16.430627, 102.833925))
                        .add(new LatLng(16.431042, 102.833960))
                        .add(new LatLng(16.432210, 102.834105))
                        .add(new LatLng(16.432619, 102.834140))
                        .add(new LatLng(16.433278, 102.834215))
                        .add(new LatLng(16.434214, 102.834306))
                        .add(new LatLng(16.435624, 102.834462))
                        .add(new LatLng(16.436700, 102.834550))
                        .add(new LatLng(16.437607, 102.834639))
                        .add(new LatLng(16.438721, 102.834760))
                        .add(new LatLng(16.438978, 102.833000))
                        .add(new LatLng(16.439271, 102.830774))
                        .add(new LatLng(16.439472, 102.829030))
                        .add(new LatLng(16.439781, 102.826719))
                        .add(new LatLng(16.440265, 102.823570))
                        .add(new LatLng(16.440646, 102.820941))
                        .add(new LatLng(16.440743, 102.820088))
                        .add(new LatLng(16.440913, 102.819134))
                        .add(new LatLng(16.441258, 102.817117))
                        .add(new LatLng(16.441392, 102.815894))
                        .add(new LatLng(16.441628, 102.814526))
                        .add(new LatLng(16.441746, 102.813528))
                        .add(new LatLng(16.442364, 102.809355))
                        .add(new LatLng(16.442529, 102.808306))
                        .add(new LatLng(16.442583, 102.807608))
                        .add(new LatLng(16.442761, 102.806742))
                        .add(new LatLng(16.443225, 102.803695))
                        .add(new LatLng(16.443431, 102.802253))
                        .add(new LatLng(16.443498, 102.801883))
                        .add(new LatLng(16.443585, 102.801177))
                        .add(new LatLng(16.443770, 102.800209))
                        .add(new LatLng(16.443878, 102.799503))
                        .add(new LatLng(16.443943, 102.798835))
                        .add(new LatLng(16.444270, 102.796690))
                        .add(new LatLng(16.444535, 102.794810))
                        .add(new LatLng(16.444656, 102.793957))
                        .add(new LatLng(16.444777, 102.792962))
                        .add(new LatLng(16.445168, 102.790527))
                        .add(new LatLng(16.445248, 102.789966))
                        .add(new LatLng(16.445392, 102.789253))
                        .add(new LatLng(16.445566, 102.787903))
                        .add(new LatLng(16.445697, 102.787243))
                        .add(new LatLng(16.445952, 102.785467))
                        .add(new LatLng(16.446220, 102.783560))
                        .add(new LatLng(16.446313, 102.782922))
                        .add(new LatLng(16.446441, 102.782256))
                        .add(new LatLng(16.446516, 102.781650))
                        .add(new LatLng(16.446771, 102.780078))
                        .add(new LatLng(16.446907, 102.778981))
                        .add(new LatLng(16.447064, 102.778066))
                        .add(new LatLng(16.447134, 102.777613))
                        .add(new LatLng(16.447224, 102.777141))
                        .add(new LatLng(16.447432, 102.775679))
                        .add(new LatLng(16.447772, 102.773482))
                        .add(new LatLng(16.448096, 102.771328))
                        .add(new LatLng(16.448350, 102.769683))
                        .add(new LatLng(16.448607, 102.767814)));
                        // new line

                        LatLng mapCenterNew3 = new LatLng(16.426787, 102.833517);
                        map.addMarker(new MarkerOptions().position(mapCenterNew3).title("Start").snippet("รถสองแถว สาย 5").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                        LatLng mapCenterNew4 = new LatLng(16.448607, 102.767814);
                        map.addMarker(new MarkerOptions().position(mapCenterNew4).title("Stop").snippet("รถสองแถว สาย 5").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                        map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenterNew3, 16));
                        map.addPolyline(new PolylineOptions().geodesic(true)
                        .add(new LatLng(16.462070, 102.798958))
                        .add(new LatLng(16.460743, 102.798454))
                        .add(new LatLng(16.459467, 102.797939))
                        .add(new LatLng(16.458603, 102.797601))
                        .add(new LatLng(16.458445, 102.797559))
                        .add(new LatLng(16.458154, 102.797554))
                        .add(new LatLng(16.457588, 102.797592))
                        .add(new LatLng(16.457184, 102.797608))
                        .add(new LatLng(16.456559, 102.797576))
                        .add(new LatLng(16.456191, 102.797528))
                        .add(new LatLng(16.455437, 102.797413))
                        .add(new LatLng(16.455119, 102.797316))
                        .add(new LatLng(16.454013, 102.796849))
                        .add(new LatLng(16.453563, 102.796637))
                        .add(new LatLng(16.452935, 102.796388))
                        .add(new LatLng(16.452497, 102.796229))
                        .add(new LatLng(16.452016, 102.796060))
                        .add(new LatLng(16.451363, 102.795856))
                        .add(new LatLng(16.450308, 102.795550))
                        .add(new LatLng(16.449536, 102.795298))
                        .add(new LatLng(16.449029, 102.795108))
                        .add(new LatLng(16.448543, 102.794850))
                        .add(new LatLng(16.448095, 102.794576))
                        .add(new LatLng(16.447789, 102.794340))
                        .add(new LatLng(16.447632, 102.794278))
                        .add(new LatLng(16.447635, 102.794278))
                        .add(new LatLng(16.447251, 102.794206))
                        .add(new LatLng(16.446526, 102.794007))
                        .add(new LatLng(16.445682, 102.793854))
                        .add(new LatLng(16.444826, 102.793690))
                        .add(new LatLng(16.444697, 102.793631))
                );
                break;

            case "รถสองแถว สาย 6":
                LatLng mapCenter9 = new LatLng(16.389369, 102.806185);
                map.addMarker(new MarkerOptions().position(mapCenter9).title("Start").snippet("รถสองแถว สาย 6").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                LatLng mapCenter10 = new LatLng(16.425587, 102.834144);
                map.addMarker(new MarkerOptions().position(mapCenter10).title("Stop").snippet("รถสองแถว สาย 6").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter9, 16));
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
                        .add(new LatLng(16.415867, 102.818825))
                        .add(new LatLng(16.416335, 102.819012))
                        .add(new LatLng(16.416525, 102.819061))
                        .add(new LatLng(16.416999, 102.819248))
                        .add(new LatLng(16.418651, 102.819736))
                        .add(new LatLng(16.419742, 102.820053))
                        .add(new LatLng(16.421152, 102.820449))
                        .add(new LatLng(16.422454, 102.820851))
                        .add(new LatLng(16.423642, 102.821179))
                        .add(new LatLng(16.424805, 102.821496))
                        .add(new LatLng(16.426240, 102.821903))
                        .add(new LatLng(16.428267, 102.822509))
                        .add(new LatLng(16.429275, 102.822799))
                        .add(new LatLng(16.430587, 102.823185))
                        .add(new LatLng(16.431168, 102.823271))
                        .add(new LatLng(16.432172, 102.823555))
                        .add(new LatLng(16.432084, 102.824108))
                        .add(new LatLng(16.431981, 102.824682))
                        .add(new LatLng(16.431714, 102.826501))
                        .add(new LatLng(16.431575, 102.827284))
                        .add(new LatLng(16.431488, 102.827461))
                        .add(new LatLng(16.431395, 102.828363))
                        .add(new LatLng(16.431279, 102.829326))
                        .add(new LatLng(16.431181, 102.829406))
                        .add(new LatLng(16.431014, 102.829414))
                        .add(new LatLng(16.430358, 102.829186))
                        .add(new LatLng(16.430209, 102.829142))
                        .add(new LatLng(16.429439, 102.828946))
                        .add(new LatLng(16.428809, 102.828785))
                        .add(new LatLng(16.428274, 102.828646))
                        .add(new LatLng(16.427070, 102.828343))
                        .add(new LatLng(16.426620, 102.828249))
                        .add(new LatLng(16.426290, 102.828190))
                        .add(new LatLng(16.426185, 102.828185))
                        .add(new LatLng(16.426077, 102.829092))
                        .add(new LatLng(16.426026, 102.829505))
                        .add(new LatLng(16.425980, 102.829950))
                        .add(new LatLng(16.425933, 102.830607))
                        .add(new LatLng(16.425891, 102.831137))
                        .add(new LatLng(16.425791, 102.831681))
                        .add(new LatLng(16.425759, 102.832279))
                        .add(new LatLng(16.425710, 102.832783))
                        .add(new LatLng(16.425655, 102.833425))
                        .add(new LatLng(16.425587, 102.834144))
                );
                        // new line

                        LatLng mapCenterNew1 = new LatLng(16.388255, 102.810962);
                        map.addMarker(new MarkerOptions().position(mapCenterNew1).title("Start").snippet("รถสองแถว สาย 6 - 2").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                        LatLng mapCenterNew2 = new LatLng(16.371700, 102.808896);
                        map.addMarker(new MarkerOptions().position(mapCenterNew2).title("Stop").snippet("รถสองแถว สาย 6 - 2").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                        map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenterNew1, 16));
                        map.addPolyline(new PolylineOptions().geodesic(true)
                        .add(new LatLng(16.388255, 102.810962))
                        .add(new LatLng(16.387812, 102.810951))
                        .add(new LatLng(16.386809, 102.810689))
                        .add(new LatLng(16.386034, 102.810544))
                        .add(new LatLng(16.385284, 102.810446))
                        .add(new LatLng(16.384165, 102.810404))
                        .add(new LatLng(16.383203, 102.810420))
                        .add(new LatLng(16.382127, 102.810436))
                        .add(new LatLng(16.380907, 102.810435))
                        .add(new LatLng(16.380217, 102.810414))
                        .add(new LatLng(16.378375, 102.810381))
                        .add(new LatLng(16.377073, 102.810376))
                        .add(new LatLng(16.375961, 102.810269))
                        .add(new LatLng(16.375843, 102.810237))
                        .add(new LatLng(16.375272, 102.810033))
                        .add(new LatLng(16.373949, 102.809577))
                        .add(new LatLng(16.373630, 102.809465))
                        .add(new LatLng(16.371700, 102.808896))

                );
                break;

            case "รถสองแถว สาย 12":
                LatLng mapCenter11 = new LatLng(16.389369, 102.806185);
                map.addMarker(new MarkerOptions().position(mapCenter11).title("Start").snippet("รถสองแถว สาย 12").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                LatLng mapCenter12 = new LatLng(16.498304, 102.832508);
                map.addMarker(new MarkerOptions().position(mapCenter12).title("Stop").snippet("รถสองแถว สาย 12").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter11, 16));
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
                        .add(new LatLng(16.415747, 102.820063))
                        .add(new LatLng(16.415953, 102.820588))
                        .add(new LatLng(16.416004, 102.821017))
                        .add(new LatLng(16.415839, 102.821736))
                        .add(new LatLng(16.415613, 102.822637))
                        .add(new LatLng(16.416580, 102.822927))
                        .add(new LatLng(16.415613, 102.822637))
                        .add(new LatLng(16.418124, 102.823348))
                        .add(new LatLng(16.418489, 102.823428))
                        .add(new LatLng(16.419163, 102.823632))
                        .add(new LatLng(16.419914, 102.823847))
                        .add(new LatLng(16.420496, 102.824013))
                        .add(new LatLng(16.420964, 102.824152))
                        .add(new LatLng(16.421381, 102.824270))
                        .add(new LatLng(16.421983, 102.824419))
                        .add(new LatLng(16.422485, 102.824565))
                        .add(new LatLng(16.422975, 102.824744))
                        .add(new LatLng(16.423714, 102.825017))
                        .add(new LatLng(16.424213, 102.825173))
                        .add(new LatLng(16.424656, 102.825312))
                        .add(new LatLng(16.425402, 102.825527))
                        .add(new LatLng(16.426066, 102.825709))
                        .add(new LatLng(16.426462, 102.825859))
                        .add(new LatLng(16.426611, 102.825865))
                        .add(new LatLng(16.426976, 102.826002))
                        .add(new LatLng(16.426970, 102.826128))
                        .add(new LatLng(16.426884, 102.826239))
                        .add(new LatLng(16.426742, 102.826271))
                        .add(new LatLng(16.426638, 102.826254))
                        .add(new LatLng(16.426493, 102.826857))
                        .add(new LatLng(16.426422, 102.827059))
                        .add(new LatLng(16.426412, 102.827144))
                        .add(new LatLng(16.426291, 102.827488))
                        .add(new LatLng(16.426187, 102.828174))
                        .add(new LatLng(16.426020, 102.829505))
                        .add(new LatLng(16.425927, 102.830570))
                        .add(new LatLng(16.425904, 102.831144))
                        .add(new LatLng(16.425791, 102.831688))
                        .add(new LatLng(16.425752, 102.832294))
                        .add(new LatLng(16.425658, 102.833423))
                        .add(new LatLng(16.426198, 102.833479))
                        .add(new LatLng(16.426916, 102.833536))
                        .add(new LatLng(16.428210, 102.833670))
                        .add(new LatLng(16.429150, 102.833785))
                        .add(new LatLng(16.429348, 102.833817))
                        .add(new LatLng(16.430066, 102.833887))
                        .add(new LatLng(16.430635, 102.833933))
                        .add(new LatLng(16.431008, 102.833943))
                        .add(new LatLng(16.431965, 102.834076))
                        .add(new LatLng(16.432284, 102.834115))
                        .add(new LatLng(16.432625, 102.834134))
                        .add(new LatLng(16.433278, 102.834214))
                        .add(new LatLng(16.433271, 102.834214))
                        .add(new LatLng(16.434228, 102.834306))
                        .add(new LatLng(16.435800, 102.834470))
                        .add(new LatLng(16.436752, 102.834561))
                        .add(new LatLng(16.437627, 102.834641))
                        .add(new LatLng(16.438666, 102.834748))
                        .add(new LatLng(16.439320, 102.834809))
                        .add(new LatLng(16.440439, 102.834922))
                        .add(new LatLng(16.440233, 102.836649))
                        .add(new LatLng(16.440894, 102.836724))
                        .add(new LatLng(16.441553, 102.836778))
                        .add(new LatLng(16.442000, 102.836842))
                        .add(new LatLng(16.442988, 102.836928))
                        .add(new LatLng(16.442967, 102.836940))
                        .add(new LatLng(16.443301, 102.836980))
                        .add(new LatLng(16.444201, 102.837095))
                        .add(new LatLng(16.445130, 102.837251))
                        .add(new LatLng(16.445832, 102.837286))
                        .add(new LatLng(16.446141, 102.837318))
                        .add(new LatLng(16.446473, 102.837444))
                        .add(new LatLng(16.447247, 102.837559))
                        .add(new LatLng(16.447355, 102.837600))
                        .add(new LatLng(16.447317, 102.837997))
                        .add(new LatLng(16.446962, 102.840964))
                        .add(new LatLng(16.447767, 102.841116))

                );
                break;

            case "รถสองแถว สาย 18":
                LatLng mapCenter13 = new LatLng(16.426508, 102.835147);
                map.addMarker(new MarkerOptions().position(mapCenter13).title("Start").snippet("รถสองแถว สาย 18").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                LatLng mapCenter14 = new LatLng(16.426794, 102.874816);
                map.addMarker(new MarkerOptions().position(mapCenter14).title("Stop").snippet("รถสองแถว สาย 18").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter13, 16));
                map.addPolyline(new PolylineOptions().geodesic(true)
                        .add(new LatLng(16.426508, 102.835147))
                        .add(new LatLng(16.426083, 102.836743))
                        .add(new LatLng(16.425928, 102.837540))
                        .add(new LatLng(16.425742, 102.838469))
                        .add(new LatLng(16.425545, 102.839511))
                        .add(new LatLng(16.426021, 102.839858))
                        .add(new LatLng(16.426548, 102.840194))
                        .add(new LatLng(16.427011, 102.840417))
                        .add(new LatLng(16.427248, 102.840540))
                        .add(new LatLng(16.427472, 102.840610))
                        .add(new LatLng(16.427726, 102.840666))
                        .add(new LatLng(16.428199, 102.840744))
                        .add(new LatLng(16.428570, 102.840779))
                        .add(new LatLng(16.429269, 102.840833))
                        .add(new LatLng(16.429719, 102.840864))
                        .add(new LatLng(16.429735, 102.840886))
                        .add(new LatLng(16.429647, 102.841436))
                        .add(new LatLng(16.429622, 102.841674))
                        .add(new LatLng(16.429488, 102.842028))
                        .add(new LatLng(16.429151, 102.844218))
                        .add(new LatLng(16.428802, 102.846814))
                        .add(new LatLng(16.428696, 102.847888))
                        .add(new LatLng(16.428717, 102.850742))
                        .add(new LatLng(16.428635, 102.853982))
                        .add(new LatLng(16.428358, 102.857061))
                        .add(new LatLng(16.428050, 102.861020))
                        .add(new LatLng(16.427585, 102.865565))
                        .add(new LatLng(16.427133, 102.870654))
                        .add(new LatLng(16.426794, 102.874816))
                );
                break;
            case "รถสองแถว สาย 19":
                LatLng mapCenter15 = new LatLng(16.426633, 102.834391);
                map.addMarker(new MarkerOptions().position(mapCenter15).title("Start").snippet("รถสองแถว สาย 19").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                LatLng mapCenter16 = new LatLng(16.498304, 102.832508);
                map.addMarker(new MarkerOptions().position(mapCenter16).title("Stop").snippet("รถสองแถว สาย 19").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter15, 16));
                map.addPolyline(new PolylineOptions().geodesic(true)
                        .add(new LatLng(16.426633, 102.834391))
                        .add(new LatLng(16.426491, 102.835120))
                        .add(new LatLng(16.426957, 102.835175))
                        .add(new LatLng(16.428228, 102.835438))
                        .add(new LatLng(16.428923, 102.835500))
                        .add(new LatLng(16.429651, 102.835580))
                        .add(new LatLng(16.430398, 102.835639))
                        .add(new LatLng(16.431002, 102.835736))
                        .add(new LatLng(16.431427, 102.835755))
                        .add(new LatLng(16.432538, 102.835891))
                        .add(new LatLng(16.433116, 102.835940))
                        .add(new LatLng(16.434045, 102.836082))
                        .add(new LatLng(16.434943, 102.836170))
                        .add(new LatLng(16.436477, 102.836345))
                        .add(new LatLng(16.437064, 102.836307))
                        .add(new LatLng(16.438401, 102.836444))
                        .add(new LatLng(16.438720, 102.834738))
                        .add(new LatLng(16.439008, 102.832721))
                        .add(new LatLng(16.439296, 102.830758))
                        .add(new LatLng(16.439492, 102.829041))
                        .add(new LatLng(16.439561, 102.828413))
                        .add(new LatLng(16.439777, 102.828526))
                        .add(new LatLng(16.440518, 102.828738))
                        .add(new LatLng(16.440762, 102.828784))
                        .add(new LatLng(16.442972, 102.829451))
                        .add(new LatLng(16.443662, 102.829602))
                        .add(new LatLng(16.444652, 102.829951))
                        .add(new LatLng(16.445712, 102.830284))
                        .add(new LatLng(16.448063, 102.830965))
                        .add(new LatLng(16.448750, 102.831059))
                        .add(new LatLng(16.450252, 102.831145))
                        .add(new LatLng(16.452501, 102.831284))
                        .add(new LatLng(16.454312, 102.831410))
                        .add(new LatLng(16.457224, 102.831576))
                        .add(new LatLng(16.458176, 102.831597))
                        .add(new LatLng(16.459946, 102.831710))
                        .add(new LatLng(16.462112, 102.831849))
                        .add(new LatLng(16.463985, 102.831892))
                        .add(new LatLng(16.464685, 102.831919))
                        .add(new LatLng(16.466717, 102.832042))
                        .add(new LatLng(16.468451, 102.832176))
                        .add(new LatLng(16.470895, 102.832294))
                        .add(new LatLng(16.473272, 102.832450))
                        .add(new LatLng(16.475643, 102.832547))
                        .add(new LatLng(16.476523, 102.832504))
                        .add(new LatLng(16.478694, 102.832504))
                        .add(new LatLng(16.480736, 102.832472))
                        .add(new LatLng(16.482655, 102.832515))
                        .add(new LatLng(16.485392, 102.832515))
                        .add(new LatLng(16.487033, 102.832488))
                        .add(new LatLng(16.487851, 102.832477))
                        .add(new LatLng(16.488808, 102.832509))
                        .add(new LatLng(16.491035, 102.832498))
                        .add(new LatLng(16.492846, 102.832482))
                        .add(new LatLng(16.495192, 102.832503))
                        .add(new LatLng(16.498304, 102.832508))
                );

                break;

            case "รถสองแถว สาย 20":
                LatLng mapCenter17 = new LatLng(16.426633, 102.834391);
                map.addMarker(new MarkerOptions().position(mapCenter17).title("Start").snippet("รถสองแถว สาย 20").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                LatLng mapCenter18 = new LatLng(16.498304, 102.832508);
                map.addMarker(new MarkerOptions().position(mapCenter18).title("Stop").snippet("รถสองแถว สาย 20").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter17, 16));
                map.addPolyline(new PolylineOptions().geodesic(true)
                        .add(new LatLng(16.426633, 102.834391))
                        .add(new LatLng(16.426491, 102.835120))
                        .add(new LatLng(16.426957, 102.835175))
                        .add(new LatLng(16.428228, 102.835438))
                        .add(new LatLng(16.428923, 102.835500))
                        .add(new LatLng(16.429651, 102.835580))
                        .add(new LatLng(16.430398, 102.835639))
                        .add(new LatLng(16.431002, 102.835736))
                        .add(new LatLng(16.431427, 102.835755))
                        .add(new LatLng(16.432538, 102.835891))
                        .add(new LatLng(16.433116, 102.835940))
                        .add(new LatLng(16.434045, 102.836082))
                        .add(new LatLng(16.434943, 102.836170))
                        .add(new LatLng(16.436477, 102.836345))
                        .add(new LatLng(16.437064, 102.836307))
                        .add(new LatLng(16.438401, 102.836444))
                        .add(new LatLng(16.438720, 102.834738))
                        .add(new LatLng(16.439008, 102.832721))
                        .add(new LatLng(16.439296, 102.830758))
                        .add(new LatLng(16.439492, 102.829041))
                        .add(new LatLng(16.439561, 102.828413))
                        .add(new LatLng(16.439777, 102.828526))
                        .add(new LatLng(16.440518, 102.828738))
                        .add(new LatLng(16.440762, 102.828784))
                        .add(new LatLng(16.442972, 102.829451))
                        .add(new LatLng(16.443662, 102.829602))
                        .add(new LatLng(16.444652, 102.829951))
                        .add(new LatLng(16.445712, 102.830284))
                        .add(new LatLng(16.448063, 102.830965))
                        .add(new LatLng(16.448750, 102.831059))
                        .add(new LatLng(16.450252, 102.831145))
                        .add(new LatLng(16.452501, 102.831284))
                        .add(new LatLng(16.454312, 102.831410))
                        .add(new LatLng(16.457224, 102.831576))
                        .add(new LatLng(16.458176, 102.831597))
                        .add(new LatLng(16.459946, 102.831710))
                        .add(new LatLng(16.462112, 102.831849))
                        .add(new LatLng(16.463985, 102.831892))
                        .add(new LatLng(16.464685, 102.831919))
                        .add(new LatLng(16.466717, 102.832042))
                        .add(new LatLng(16.468451, 102.832176))
                        .add(new LatLng(16.470895, 102.832294))
                        .add(new LatLng(16.473272, 102.832450))
                        .add(new LatLng(16.475643, 102.832547))
                        .add(new LatLng(16.476523, 102.832504))
                        .add(new LatLng(16.478694, 102.832504))
                        .add(new LatLng(16.480736, 102.832472))
                        .add(new LatLng(16.482655, 102.832515))
                        .add(new LatLng(16.485392, 102.832515))
                        .add(new LatLng(16.487033, 102.832488))
                        .add(new LatLng(16.487851, 102.832477))
                        .add(new LatLng(16.488808, 102.832509))
                        .add(new LatLng(16.491035, 102.832498))
                        .add(new LatLng(16.492846, 102.832482))
                        .add(new LatLng(16.495192, 102.832503))
                        .add(new LatLng(16.498304, 102.832508))
                );
                break;
            case "รถสองแถว สาย 22":
                LatLng mapCenter19 = new LatLng(16.414864, 102.874371);
                map.addMarker(new MarkerOptions().position(mapCenter19).title("Start").snippet("รถสองแถว สาย 22").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                LatLng mapCenter20 = new LatLng(16.429201, 102.833786);
                map.addMarker(new MarkerOptions().position(mapCenter20).title("Stop").snippet("รถสองแถว สาย 22").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter19, 16));
                map.addPolyline(new PolylineOptions().geodesic(true)
                        .add(new LatLng(16.414864, 102.874371))
                        .add(new LatLng(16.415543, 102.874409))
                        .add(new LatLng(16.416070, 102.874457))
                        .add(new LatLng(16.416274, 102.874449))
                        .add(new LatLng(16.416500, 102.874425))
                        .add(new LatLng(16.416675, 102.874374))
                        .add(new LatLng(16.416860, 102.874264))
                        .add(new LatLng(16.419695, 102.872349))
                        .add(new LatLng(16.419945, 102.872204))
                        .add(new LatLng(16.420356, 102.872073))
                        .add(new LatLng(16.420963, 102.871864))
                        .add(new LatLng(16.421398, 102.871716))
                        .add(new LatLng(16.422136, 102.871370))
                        .add(new LatLng(16.422701, 102.871149))
                        .add(new LatLng(16.422966, 102.871071))
                        .add(new LatLng(16.423605, 102.870931))
                        .add(new LatLng(16.425087, 102.870360))
                        .add(new LatLng(16.425200, 102.870299))
                        .add(new LatLng(16.425343, 102.870209))
                        .add(new LatLng(16.425507, 102.870100))
                        .add(new LatLng(16.425769, 102.869933))
                        .add(new LatLng(16.426021, 102.869770))
                        .add(new LatLng(16.426096, 102.869732))
                        .add(new LatLng(16.426225, 102.869676))
                        .add(new LatLng(16.426328, 102.869637))
                        .add(new LatLng(16.427204, 102.869500))
                        .add(new LatLng(16.427180, 102.869909))
                        .add(new LatLng(16.427194, 102.870063))
                        .add(new LatLng(16.427147, 102.870618))
                        .add(new LatLng(16.428243, 102.870731))
                        .add(new LatLng(16.428665, 102.870704))
                        .add(new LatLng(16.428945, 102.870648))
                        .add(new LatLng(16.429298, 102.870538))
                        .add(new LatLng(16.429743, 102.870353))
                        .add(new LatLng(16.430119, 102.870096))
                        .add(new LatLng(16.431492, 102.869082))
                        .add(new LatLng(16.431965, 102.868591))
                        .add(new LatLng(16.432369, 102.868036))
                        .add(new LatLng(16.432693, 102.867435))
                        .add(new LatLng(16.432987, 102.866660))
                        .add(new LatLng(16.433175, 102.865992))
                        .add(new LatLng(16.433437, 102.864758))
                        .add(new LatLng(16.434041, 102.861199))
                        .add(new LatLng(16.434118, 102.861018))
                        .add(new LatLng(16.434198, 102.860252))
                        .add(new LatLng(16.433787, 102.860195))
                        .add(new LatLng(16.433571, 102.860192))
                        .add(new LatLng(16.433476, 102.860165))
                        .add(new LatLng(16.433329, 102.859988))
                        .add(new LatLng(16.433177, 102.859712))
                        .add(new LatLng(16.433000, 102.859321))
                        .add(new LatLng(16.431873, 102.857422))
                        .add(new LatLng(16.431431, 102.856800))
                        .add(new LatLng(16.431135, 102.856430))
                        .add(new LatLng(16.431093, 102.856330))
                        .add(new LatLng(16.430803, 102.856092))
                        .add(new LatLng(16.430548, 102.855823))
                        .add(new LatLng(16.430214, 102.855571))
                        .add(new LatLng(16.429987, 102.855370))
                        .add(new LatLng(16.429621, 102.855049))
                        .add(new LatLng(16.429102, 102.854668))
                        .add(new LatLng(16.428780, 102.854357))
                        .add(new LatLng(16.428610, 102.854303))
                        .add(new LatLng(16.428615, 102.851626))
                        .add(new LatLng(16.428708, 102.850612))
                        .add(new LatLng(16.428697, 102.847866))
                        .add(new LatLng(16.428723, 102.847126))
                        .add(new LatLng(16.428784, 102.846557))
                        .add(new LatLng(16.429340, 102.842877))
                        .add(new LatLng(16.429438, 102.842453))
                        .add(new LatLng(16.429569, 102.841700))
                        .add(new LatLng(16.429608, 102.841587))
                        .add(new LatLng(16.429827, 102.840264))
                        .add(new LatLng(16.429907, 102.839339))
                        .add(new LatLng(16.430003, 102.838715))
                        .add(new LatLng(16.430083, 102.837702))
                        .add(new LatLng(16.430232, 102.836586))
                        .add(new LatLng(16.428810, 102.835509))
                        .add(new LatLng(16.428213, 102.835433))
                        .add(new LatLng(16.426947, 102.835186))
                        .add(new LatLng(16.426520, 102.835127))
                        .add(new LatLng(16.425517, 102.835052))
                        .add(new LatLng(16.425658, 102.833427))
                        .add(new LatLng(16.426212, 102.833481))
                        .add(new LatLng(16.426974, 102.833537))
                        .add(new LatLng(16.427808, 102.833628))
                        .add(new LatLng(16.428491, 102.833703))
                        .add(new LatLng(16.429201, 102.833786))
                );
                break;
            case "รถสองแถว สาย 23":
                LatLng mapCenter21 = new LatLng(16.389369, 102.806185);
                map.addMarker(new MarkerOptions().position(mapCenter21).title("Start").snippet("รถสองแถว สาย 23").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                LatLng mapCenter22 = new LatLng(16.426555, 102.826608);
                map.addMarker(new MarkerOptions().position(mapCenter22).title("Stop").snippet("รถสองแถว สาย 23").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter21, 16));
                map.addPolyline(new PolylineOptions().geodesic(true)
                        .add(new LatLng(16.389369, 102.806185))
                        .add(new LatLng(16.389066, 102.807493))
                        .add(new LatLng(16.388830, 102.808600))
                        .add(new LatLng(16.388577, 102.809616))
                        .add(new LatLng(16.388255, 102.810962))
                        .add(new LatLng(16.389102, 102.811218))
                        .add(new LatLng(16.389481, 102.811345))
                        .add(new LatLng(16.389952, 102.811473))
                        .add(new LatLng(16.390175, 102.811189))
                        .add(new LatLng(16.390646, 102.809456))
                        .add(new LatLng(16.390559, 102.809271))
                        .add(new LatLng(16.390374, 102.809258))
                        .add(new LatLng(16.390276, 102.809349))
                        .add(new LatLng(16.389663, 102.811632))
                        .add(new LatLng(16.389308, 102.813053))
                        .add(new LatLng(16.388130, 102.817371))
                        .add(new LatLng(16.386607, 102.823057))
                        .add(new LatLng(16.386759, 102.823572))
                        .add(new LatLng(16.386903, 102.823819))
                        .add(new LatLng(16.388828, 102.825214))
                        .add(new LatLng(16.390392, 102.826212))
                        .add(new LatLng(16.392759, 102.827553))
                        .add(new LatLng(16.393809, 102.828079))
                        .add(new LatLng(16.395734, 102.829109))
                        .add(new LatLng(16.399007, 102.830793))
                        .add(new LatLng(16.400818, 102.831577))
                        .add(new LatLng(16.401662, 102.831909))
                        .add(new LatLng(16.403494, 102.832392))
                        .add(new LatLng(16.405439, 102.832939))
                        .add(new LatLng(16.407981, 102.833390))
                        .add(new LatLng(16.410503, 102.833647))
                        .add(new LatLng(16.413405, 102.833915))
                        .add(new LatLng(16.415340, 102.834087))
                        .add(new LatLng(16.416760, 102.834226))
                        .add(new LatLng(16.417907, 102.834285))
                        .add(new LatLng(16.418736, 102.834468))
                        .add(new LatLng(16.419338, 102.834532))
                        .add(new LatLng(16.420539, 102.834648))
                        .add(new LatLng(16.420503, 102.835890))
                        .add(new LatLng(16.420436, 102.837054))
                        .add(new LatLng(16.421470, 102.837060))
                        .add(new LatLng(16.422010, 102.837065))
                        .add(new LatLng(16.422762, 102.837060))
                        .add(new LatLng(16.423850, 102.837118))
                        .add(new LatLng(16.423966, 102.836415))
                        .add(new LatLng(16.424257, 102.835074))
                        .add(new LatLng(16.424316, 102.834867))
                        .add(new LatLng(16.424571, 102.834889))
                        .add(new LatLng(16.425523, 102.834996))
                        .add(new LatLng(16.425652, 102.833424))
                        .add(new LatLng(16.425750, 102.832273))
                        .add(new LatLng(16.425806, 102.831678))
                        .add(new LatLng(16.425894, 102.831131))
                        .add(new LatLng(16.425984, 102.829918))
                        .add(new LatLng(16.426017, 102.829516))
                        .add(new LatLng(16.426177, 102.828177))
                        .add(new LatLng(16.426295, 102.827493))
                        .add(new LatLng(16.426416, 102.827150))
                        .add(new LatLng(16.426427, 102.827040))
                        .add(new LatLng(16.426555, 102.826608))

                );
                break;


            default:
                LatLng mapCenter = new LatLng(13.784910, 100.627749);
                map.addMarker(new MarkerOptions().position(mapCenter).title("My room").snippet("stay with my girlfriend").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
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
