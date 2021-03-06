package com.app.arnontproject.kkminibus.activity;

import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import com.akexorcist.localizationactivity.ui.LocalizationActivity;
import com.app.arnontproject.kkminibus.fragment.ItemListDialogFragment;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationServices;

import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import com.app.arnontproject.kkminibus.R;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsDetailActivity extends LocalizationActivity implements OnMapReadyCallback {

    private GoogleMap map;
    TextView txtMiniBusDetail;
    private static GoogleApiClient mGoogleApiClient;
    private static final int ACCESS_FINE_LOCATION_INTENT_ID = 3;
    String txtFix;



    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_maps_detail);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Toolbar toolbar = findViewById(R.id.toolbarDetailMiniBus);
        toolbar.setTitle(R.string.bus_route);
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
        map.setPadding(0,0,0,150);
        enableCurrentLocationButton();

        map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);


        // Polylines
        switch (txtFix) {
            case "สาย 2 : บ้านโคกฟันโปง – บ้านโคกน้อย\nบ.โคกฟันโปง, บ.หัวทุ่ง, บ.คำไฮ, เซ็นทรัลพลาซ่า ขอนแก่น, ศาลหลักเมือง ขอนแก่น, บขส.1, โรงเรียนขอนแก่นวิทยายน, ตลาดบางลำภู, ตลาดเทศบาล, โรงเรียนกัลยาณวัตร, สถานีตํารวจภูธรเมืองขอนแก่น, เซ็นโทซ่า, ไปรษณีย์ขอนแก่น, วัดศรีจันทร์, เรือนจำขอนแก่น, วิทยาลัยเทคนิคขอนแก่น, โรงพยาบาลศูนย์ขอนแก่น, มหาวิทยาลัยเทคโนโลยีราชมงคลอีสาน, ตลาดหนองใหญ่, บ.พระคือ, บ.หนองโพธิ์, บ.หนองแสง, บ.โคกน้อย":

                // pin landmark start
                LatLng latlngLandmark1Line2 = new LatLng(16.438105, 102.774191);
                map.addMarker(new MarkerOptions().position(latlngLandmark1Line2).title("บ.โคกฟันโปง").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latlngLandmark1Line2));

                LatLng latLngLandmark2Line2 = new LatLng(16.437724, 102.795194);
                map.addMarker(new MarkerOptions().position(latLngLandmark2Line2).title("บ.หัวทุ่ง").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark2Line2));

                LatLng latLngLandmark3Line2 = new LatLng(16.436375, 102.799377);
                map.addMarker(new MarkerOptions().position(latLngLandmark3Line2).title("บ.คำไฮ").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark3Line2));

                LatLng latLngLandmark4Line2 = new LatLng(16.432114, 102.824713);
                map.addMarker(new MarkerOptions().position(latLngLandmark4Line2).title("เซ็นทรัลพลาซ่าขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark4Line2));

                LatLng latLngLandmark5Line2 = new LatLng(16.431150, 102.828590);
                map.addMarker(new MarkerOptions().position(latLngLandmark5Line2).title("ศาลหลักเมือง ขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark5Line2));

                LatLng latlngLandmark6Line2 = new LatLng(16.439266, 102.833345);
                map.addMarker(new MarkerOptions().position(latlngLandmark6Line2).title("บขส.1").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latlngLandmark6Line2));

                LatLng latLngLandmark7Line2 = new LatLng(16.432384, 102.835668);
                map.addMarker(new MarkerOptions().position(latLngLandmark7Line2).title("โรงเรียนขอนแก่นวิทยายน").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark7Line2));

                LatLng latLngLandmark8Line2 = new LatLng(16.428785, 102.835340);
                map.addMarker(new MarkerOptions().position(latLngLandmark8Line2).title("ตลาดบางลำพู").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark8Line2));

                LatLng latLngLandmark9Line2 = new LatLng(16.427475, 102.835103);
                map.addMarker(new MarkerOptions().position(latLngLandmark9Line2).title("ตลาดเทศบาล").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark9Line2));

                LatLng latlngLandmark10Line2 = new LatLng(16.427651, 102.835532);
                map.addMarker(new MarkerOptions().position(latlngLandmark10Line2).title("โรงเรียนกัลยาณวัตร").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latlngLandmark10Line2));

                LatLng latLngLandmark11Line2 = new LatLng(16.428687, 102.835620);
                map.addMarker(new MarkerOptions().position(latLngLandmark11Line2).title("สถานีตํารวจภูธรเมืองขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark11Line2));

                LatLng latLngLandmark12Line2 = new LatLng(16.429769, 102.835726);
                map.addMarker(new MarkerOptions().position(latLngLandmark12Line2).title("ไปรษณีย์ขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark12Line2));

                LatLng latLngLandmark13Line2 = new LatLng(16.430044, 102.839578);
                map.addMarker(new MarkerOptions().position(latLngLandmark13Line2).title("วัดศรีจันทร์").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark13Line2));

                LatLng latlngLandmark14Line2 = new LatLng(16.429288, 102.845191);
                map.addMarker(new MarkerOptions().position(latlngLandmark14Line2).title("เรือนจำขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latlngLandmark14Line2));

                LatLng latLngLandmark15Line2 = new LatLng(16.428625, 102.847469);
                map.addMarker(new MarkerOptions().position(latLngLandmark15Line2).title("วิทยาลัยเทคนิคขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark15Line2));

                LatLng latLngLandmark16Line2 = new LatLng(16.428952, 102.849130);
                map.addMarker(new MarkerOptions().position(latLngLandmark16Line2).title("โรงพยาบาลศูนย์ขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark16Line2));

                LatLng latLngLandmark17Line2 = new LatLng(16.428111, 102.863237);
                map.addMarker(new MarkerOptions().position(latLngLandmark17Line2).title("มหาวิทยาลัยเทคโนโลยีราชมงคลอีสาน").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark17Line2));

                LatLng latLngLandmark18Line2 = new LatLng(16.427545, 102.868770);
                map.addMarker(new MarkerOptions().position(latLngLandmark18Line2).title("ตลาดหนองใหญ่").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark18Line2));

//                LatLng latLngLandmark19Line2 = new LatLng(16.421090, 102.894248);
//                map.addMarker(new MarkerOptions().position(latLngLandmark19Line2).title("บ. พระคือ").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark19Line2));
//
//                LatLng latLngLandmark20Line2 = new LatLng(16.419572, 102.894469);
//                map.addMarker(new MarkerOptions().position(latLngLandmark20Line2).title("บ. หนองโพธิ์").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark20Line2));
//
//                LatLng latLngLandmark21Line2 = new LatLng(16.409421, 102.900173);
//                map.addMarker(new MarkerOptions().position(latLngLandmark21Line2).title("บ. หนองแสง").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark21Line2));
//
//                LatLng latLngLandmark22Line2 = new LatLng(16.403769, 102.900674);
//                map.addMarker(new MarkerOptions().position(latLngLandmark22Line2).title("บ. โคกน้อย").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark22Line2));

                // pin landmark stop

                LatLng mapCenter1 = new LatLng(16.426794, 102.874816);
                map.addMarker(new MarkerOptions().position(mapCenter1).title("Start").snippet("สาย 2 : บ้านโคกฟันโปง – บ้านโคกน้อย").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                LatLng mapCenter2 = new LatLng(16.436621, 102.765723);
                map.addMarker(new MarkerOptions().position(mapCenter2).title("Stop").snippet("สาย 2 : บ้านโคกฟันโปง – บ้านโคกน้อย").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter1, 15));
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
                        .add(new LatLng(16.429555, 102.835606))
                        .add(new LatLng(16.428214, 102.835443))
                        .add(new LatLng(16.426950, 102.835191))
                        .add(new LatLng(16.426483, 102.835155))
                        .add(new LatLng(16.426648, 102.834281))
                        .add(new LatLng(16.426780, 102.833520))
                        .add(new LatLng(16.426890, 102.833536))
                        .add(new LatLng(16.427799, 102.833629))
                        .add(new LatLng(16.428365, 102.833677))
                        .add(new LatLng(16.429107, 102.833788))
                        .add(new LatLng(16.429863, 102.833872))
                        .add(new LatLng(16.430620, 102.833935))
                        .add(new LatLng(16.431039, 102.833951))
                        .add(new LatLng(16.432594, 102.834130))
                        .add(new LatLng(16.433275, 102.834206))
                        .add(new LatLng(16.434210, 102.834304))
                        .add(new LatLng(16.434695, 102.834352))
                        .add(new LatLng(16.435657, 102.834449))
                        .add(new LatLng(16.436703, 102.834547))
                        .add(new LatLng(16.437597, 102.834645))
                        .add(new LatLng(16.438631, 102.834744))
                        .add(new LatLng(16.439031, 102.832998))
                        .add(new LatLng(16.439305, 102.830818))
                        .add(new LatLng(16.438482, 102.830603))
                        .add(new LatLng(16.437880, 102.830469))
                        .add(new LatLng(16.437139, 102.830292))
                        .add(new LatLng(16.435997, 102.829938))
                        .add(new LatLng(16.435316, 102.829792))
                        .add(new LatLng(16.434463, 102.829522))
                        .add(new LatLng(16.433367, 102.829246))
                        .add(new LatLng(16.432747, 102.829109))
                        .add(new LatLng(16.431959, 102.828875))
                        .add(new LatLng(16.431341, 102.828699))
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
                        .add(new LatLng(16.434623, 102.807639))
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
                        .add(new LatLng(16.438231, 102.774610))
                        .add(new LatLng(16.438291, 102.773212))
                        .add(new LatLng(16.438257, 102.772102))
                        .add(new LatLng(16.436621, 102.765723))
                        .color(getResources().getColor(R.color.s2))
                );
                break;
            case "สาย 3 : บขส.3 – บ้านพรหมนิมิตร\nบขส. 3, แม็คโคร ขอนแก่น, ประตูน้ำขอนแก่น, ตลาดอู้ฟู, โรงเรียนแก่นนครวิทยาลัย, ศาลหลักเมือง ขอนแก่น, เซ็นทรัลพลาซ่า ขอนแก่น, โรงบาลราชพฤกษ์ ขอนแก่น, บขส.1, โรงเรียนขอนแก่นวิทยายน, ตลาดบางลำภู, ตลาดเทศบาล, โรงเรียนกัลยาณวัตร, สถานีตํารวจภูธรเมืองขอนแก่น, ไปรษณีย์ขอนแก่น, วิทยาลัยเทคนิคขอนแก่น, มหาวิทยาลัยเทคโนโลยีราชมงคลอีสาน, ตลาดหนองใหญ่, บ.ท่าหิน, บ.พรหมนิมิตร":

                // pin landmark start
                LatLng latLngLandmark1Line3 = new LatLng(16.404893, 102.815481);
                map.addMarker(new MarkerOptions().position(latLngLandmark1Line3).title("แม็คโคร ขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark1Line3));

                LatLng latLngLandmark2Line3 = new LatLng(16.389460, 102.805893);
                map.addMarker(new MarkerOptions().position(latLngLandmark2Line3).title("บขส.3").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark2Line3));

                LatLng latLngLandmark3Line3 = new LatLng(16.435156, 102.824569);
                map.addMarker(new MarkerOptions().position(latLngLandmark3Line3).title("โรงบาลราชพฤกษ์ ขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_hospital)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark3Line3));

                LatLng latLngLandmark4Line3 = new LatLng(16.404327, 102.815374);
                map.addMarker(new MarkerOptions().position(latLngLandmark4Line3).title("ประตูน้ำขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark4Line3));

                LatLng latLngLandmark5Line3 = new LatLng(16.409903, 102.817031);
                map.addMarker(new MarkerOptions().position(latLngLandmark5Line3).title("ตลาดอู้ฟู").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark5Line3));

                LatLng latLngLandmark6Line3 = new LatLng(16.432384, 102.835668);
                map.addMarker(new MarkerOptions().position(latLngLandmark6Line3).title("โรงเรียนขอนแก่นวิทยายน").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark6Line3));

                LatLng latLngLandmark7Line3 = new LatLng(16.431150, 102.828590);
                map.addMarker(new MarkerOptions().position(latLngLandmark7Line3).title("ศาลหลักเมือง ขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark7Line3));

                LatLng latLngLandmark8Line3 = new LatLng(16.432114, 102.824713);
                map.addMarker(new MarkerOptions().position(latLngLandmark8Line3).title("เซ็นทรัลพลาซ่า ขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark8Line3));

                LatLng latLngLandmark9Line3 = new LatLng(16.439266, 102.833345);
                map.addMarker(new MarkerOptions().position(latLngLandmark9Line3).title("บขส.1").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark9Line3));

                LatLng latLngLandmark10Line3 = new LatLng(16.432384, 102.835668);
                map.addMarker(new MarkerOptions().position(latLngLandmark10Line3).title("โรงเรียนขอนแก่นวิทยายน").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark10Line3));

                LatLng latLngLandmark11Line3 = new LatLng(16.428785, 102.835340);
                map.addMarker(new MarkerOptions().position(latLngLandmark11Line3).title("ตลาดบางลำพู").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark11Line3));

                LatLng latLngLandmark12Line3 = new LatLng(16.427475, 102.835103);
                map.addMarker(new MarkerOptions().position(latLngLandmark12Line3).title("ตลาดเทศบาล").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark12Line3));

                LatLng latLngLandmark13Line3 = new LatLng(16.427651, 102.835532);
                map.addMarker(new MarkerOptions().position(latLngLandmark13Line3).title("โรงเรียนกัลยาณวัตร").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark13Line3));

                LatLng latLngLandmark14Line3 = new LatLng(16.428687, 102.835620);
                map.addMarker(new MarkerOptions().position(latLngLandmark14Line3).title("สถานีตํารวจภูธรเมืองขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark14Line3));

                LatLng latLngLandmark15Line3 = new LatLng(16.429769, 102.835726);
                map.addMarker(new MarkerOptions().position(latLngLandmark15Line3).title("ไปรษณีย์ขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark15Line3));

                LatLng latLngLandmark16Line3 = new LatLng(16.428625, 102.847469);
                map.addMarker(new MarkerOptions().position(latLngLandmark16Line3).title("วิทยาลัยเทคนิคขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark16Line3));

                LatLng latLngLandmark17Line3 = new LatLng(16.428111, 102.863237);
                map.addMarker(new MarkerOptions().position(latLngLandmark17Line3).title("มหาวิทยาลัยเทคโนโลยีราชมงคลอีสาน").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark17Line3));

                LatLng latLngLandmark18Line3 = new LatLng(16.427545, 102.868770);
                map.addMarker(new MarkerOptions().position(latLngLandmark18Line3).title("ตลาดหนองใหญ่").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark18Line3));

//                LatLng latLngLandmark19Line3 = new LatLng(16.438345, 102.943897);
//                map.addMarker(new MarkerOptions().position(latLngLandmark19Line3).title("บ. ท่าหิน").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark19Line3));
//
//                LatLng latLngLandmark20Line3 = new LatLng(16.446155, 102.947748);
//                map.addMarker(new MarkerOptions().position(latLngLandmark20Line3).title("บ. พรหมนิมิตร").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark20Line3));

                // pin landmark stop

                LatLng mapCenter3 = new LatLng(16.389369, 102.806185);
                map.addMarker(new MarkerOptions().position(mapCenter3).title("Start").snippet("สาย 3 : บขส.3 – บ้านพรหมนิมิตร").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                LatLng mapCenter4 = new LatLng(16.427065, 102.872894);
                map.addMarker(new MarkerOptions().position(mapCenter4).title("Stop").snippet("สาย 3 : บขส.3 – บ้านพรหมนิมิตร").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter3, 15));
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
                        .add(new LatLng(16.429901, 102.829051))
                        .add(new LatLng(16.430298, 102.829166))
                        .add(new LatLng(16.430442, 102.828734))
                        .add(new LatLng(16.430586, 102.828463))
                        .add(new LatLng(16.430946, 102.828235))
                        .add(new LatLng(16.431170, 102.828117))
                        .add(new LatLng(16.431420, 102.827881))
                        .add(new LatLng(16.431523, 102.827280))
                        .add(new LatLng(16.431497, 102.827060))
                        .add(new LatLng(16.431605, 102.826449))
                        .add(new LatLng(16.431806, 102.825108))
                        .add(new LatLng(16.431986, 102.823987))
                        .add(new LatLng(16.432068, 102.823381))
                        .add(new LatLng(16.432346, 102.823461))
                        .add(new LatLng(16.433360, 102.823840))
                        .add(new LatLng(16.433821, 102.823994))
                        .add(new LatLng(16.434224, 102.824222))
                        .add(new LatLng(16.434773, 102.824511))
                        .add(new LatLng(16.435662, 102.825018))
                        .add(new LatLng(16.436274, 102.825469))
                        .add(new LatLng(16.436763, 102.825909))
                        .add(new LatLng(16.438281, 102.827288))
                        .add(new LatLng(16.439017, 102.827921))
                        .add(new LatLng(16.439567, 102.828398))
                        .add(new LatLng(16.439727, 102.828484))
                        .add(new LatLng(16.439505, 102.829650))
                        .add(new LatLng(16.439288, 102.831608))
                        .add(new LatLng(16.439102, 102.833018))
                        .add(new LatLng(16.438845, 102.834766))
                        .add(new LatLng(16.437631, 102.834648))
                        .add(new LatLng(16.436695, 102.834544))
                        .add(new LatLng(16.434215, 102.834297))
                        .add(new LatLng(16.431045, 102.833964))
                        .add(new LatLng(16.430613, 102.833943))
                        .add(new LatLng(16.429291, 102.833804))
                        .add(new LatLng(16.428140, 102.833668))
                        .add(new LatLng(16.426791, 102.833517))
                        .add(new LatLng(16.425654, 102.833426))
                        .add(new LatLng(16.425609, 102.833947))
                        .add(new LatLng(16.425511, 102.835001))
                        .add(new LatLng(16.425637, 102.835066))
                        .add(new LatLng(16.426047, 102.835106))
                        .add(new LatLng(16.426507, 102.835109))
                        .add(new LatLng(16.426954, 102.835178))
                        .add(new LatLng(16.428210, 102.835414))
                        .add(new LatLng(16.428925, 102.835505))
                        .add(new LatLng(16.429594, 102.835586))
                        .add(new LatLng(16.430397, 102.835645))
                        .add(new LatLng(16.430111, 102.837685))
                        .add(new LatLng(16.430029, 102.838710))
                        .add(new LatLng(16.429731, 102.840888))
                        .add(new LatLng(16.429617, 102.841725))
                        .add(new LatLng(16.429432, 102.843077))
                        .add(new LatLng(16.428959, 102.846328))
                        .add(new LatLng(16.428805, 102.847390))
                        .add(new LatLng(16.428835, 102.849793))
                        .add(new LatLng(16.428804, 102.853741))
                        .add(new LatLng(16.428475, 102.857003))
                        .add(new LatLng(16.428197, 102.860490))
                        .add(new LatLng(16.427857, 102.864031))
                        .add(new LatLng(16.427610, 102.866906))
                        .add(new LatLng(16.427291, 102.870619))
                        .add(new LatLng(16.427065, 102.872894))

                        .color(getResources().getColor(R.color.s3))
                );
                break;
            case "สาย 4 : บขส.3 – บ้านหนองน้ำเกลี้ยง\nบขส.3, แม็คโคร ขอนแก่น, ประตูน้ำขอนแก่น, ตลาดอู้ฟู, ขอนแก่นแหอวน, โรงเรียนแก่นนครวิทยาลัย, โรงเรียนโสตศึกษาขอนแก่น, สนามกีฬากลางขอนแก่น, โรงเรียนเทศบาลวัดกลาง, แฟรี่พลาซ่า, ตลาดเทศบาล, ตลาดบางลำภู, โรงเรียนขอนแก่นวิทยายน, บขส.1, ศูนย์หัวใจสิริกิตขอนแก่น, โรงพยาบาลศรีนครินทร์, มหาวิทยาลัยขอนแก่น, โลตัสเอ็กซ์ตร้า, บ.สำราญ, บ.หนองน้ำเกลี้ยง":

                // pin land mark start
                LatLng latLngLandmark1Line4 = new LatLng(16.389460, 102.805893);
                map.addMarker(new MarkerOptions().position(latLngLandmark1Line4).title("บขส. 3").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark1Line4));

                LatLng latLngLandmark2Line4 = new LatLng(16.404893, 102.815481);
                map.addMarker(new MarkerOptions().position(latLngLandmark2Line4).title("แม็คโคร ขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark2Line4));

                LatLng latLngLandmark3Line4 = new LatLng(16.404327, 102.815374);
                map.addMarker(new MarkerOptions().position(latLngLandmark3Line4).title("ประตูน้ำขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark3Line4));

                LatLng latLngLandmark4Line4 = new LatLng(16.409903, 102.817031);
                map.addMarker(new MarkerOptions().position(latLngLandmark4Line4).title("ตลาดอู้ฟู").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark4Line4));

                LatLng latLngLandmark5Line4 = new LatLng(16.416125, 102.821296);
                map.addMarker(new MarkerOptions().position(latLngLandmark5Line4).title("ขอนแก่นแหอวน").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark5Line4));

                LatLng latLngLandmark6Line4 = new LatLng(16.415286, 102.824483);
                map.addMarker(new MarkerOptions().position(latLngLandmark6Line4).title("โรงเรียนแก่นนครวิทยาลัย").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark6Line4));

                LatLng latLngLandmark7Line4 = new LatLng(16.414764, 102.826183);
                map.addMarker(new MarkerOptions().position(latLngLandmark7Line4).title("โรงเรียนโสตศึกษาขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark7Line4));

                LatLng latLngLandmark8Line4 = new LatLng(16.413771, 102.828920);
                map.addMarker(new MarkerOptions().position(latLngLandmark8Line4).title("สนามกีฬากลางขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark8Line4));

                LatLng latLngLandmark9Line4 = new LatLng(16.413293, 102.831271);
                map.addMarker(new MarkerOptions().position(latLngLandmark9Line4).title("โรงเรียนเทศบาลวัดกลาง").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark9Line4));

                LatLng latLngLandmark10Line4 = new LatLng(16.423924, 102.833135);
                map.addMarker(new MarkerOptions().position(latLngLandmark10Line4).title("แฟรี่ พลาซ่า").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark10Line4));

                LatLng latLngLandmark11Line4 = new LatLng(16.427475, 102.835103);
                map.addMarker(new MarkerOptions().position(latLngLandmark11Line4).title("ตลาดเทศบาล").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark11Line4));

                LatLng latLngLandmark12Line4 = new LatLng(16.428785, 102.835340);
                map.addMarker(new MarkerOptions().position(latLngLandmark12Line4).title("ตลาดบางลำพู").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark12Line4));

                LatLng latLngLandmark13Line4 = new LatLng(16.432384, 102.835668);
                map.addMarker(new MarkerOptions().position(latLngLandmark13Line4).title("โรงเรียนขอนแก่นวิทยายน").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark13Line4));

                LatLng latLngLandmark14Line4 = new LatLng(16.439266, 102.833345);
                map.addMarker(new MarkerOptions().position(latLngLandmark14Line4).title("บขส. 1").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark14Line4));

                LatLng latLngLandmark15Line4 = new LatLng(16.466365, 102.831799);
                map.addMarker(new MarkerOptions().position(latLngLandmark15Line4).title("ศูนย์หัวใจสิริกิตขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_hospital)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark15Line4));

                LatLng latLngLandmark16Line4 = new LatLng(16.468164, 102.831906);
                map.addMarker(new MarkerOptions().position(latLngLandmark16Line4).title("โรงพยาบาลศรีนครินทร์").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_hospital)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark16Line4));

                LatLng latLngLandmark17Line4 = new LatLng(16.476059, 102.832161);
                map.addMarker(new MarkerOptions().position(latLngLandmark17Line4).title("มหาวิทยาลัยขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark17Line4));

                LatLng latLngLandmark18Line4 = new LatLng(16.491834, 102.832177);
                map.addMarker(new MarkerOptions().position(latLngLandmark18Line4).title("โลตัสเอ็กซ์ตร้า").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark18Line4));

//                LatLng latLngLandmark19Line4 = new LatLng(16.535924, 102.830049);
//                map.addMarker(new MarkerOptions().position(latLngLandmark19Line4).title("บ.สำราญ").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark19Line4));
//
//                LatLng latLngLandmark20Line4 = new LatLng(16.561523, 102.824449);
//                map.addMarker(new MarkerOptions().position(latLngLandmark20Line4).title("บ. หนองน้ำเกลี้ยง").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark20Line4));
                // pin land mark stop


                LatLng mapCenter5 = new LatLng(16.498304, 102.832508);
                map.addMarker(new MarkerOptions().position(mapCenter5).title("Start").snippet("สาย 4 : บขส.3 – บ้านหนองน้ำเกลี้ยง").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                LatLng mapCenter6 = new LatLng(16.389369, 102.806185);
                map.addMarker(new MarkerOptions().position(mapCenter6).title("Stop").snippet("สาย 4 : บขส.3 – บ้านหนองน้ำเกลี้ยง").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter5, 15));
                map.addPolyline(new PolylineOptions().geodesic(true)
                        .add(new LatLng(16.498304, 102.832508))
                        .add(new LatLng(16.495192, 102.832503 ))
                        .add(new LatLng(16.492846, 102.832482))
                        .add(new LatLng(16.491035, 102.832498))
                        .add(new LatLng(16.488808, 102.832509))
                        .add(new LatLng(16.487851, 102.832477))
                        .add(new LatLng(16.487033, 102.832488))
                        .add(new LatLng(16.485392, 102.832515))
                        .add(new LatLng(16.482655, 102.832515))
                        .add(new LatLng(16.480736, 102.832472))
                        .add(new LatLng(16.478694, 102.832504))
                        .add(new LatLng(16.476523, 102.832504))
                        .add(new LatLng(16.475643, 102.832547))
                        .add(new LatLng(16.473272, 102.832450))
                        .add(new LatLng(16.470895, 102.832294))
                        .add(new LatLng(16.468451, 102.832176))
                        .add(new LatLng(16.466717, 102.832042))
                        .add(new LatLng(16.464685, 102.831919))
                        .add(new LatLng(16.463985, 102.831892))
                        .add(new LatLng(16.462112, 102.831849))
                        .add(new LatLng(16.459946, 102.831710))
                        .add(new LatLng(16.458176, 102.831597))
                        .add(new LatLng(16.457224, 102.831576))
                        .add(new LatLng(16.454312, 102.831410))
                        .add(new LatLng(16.452501, 102.831284))
                        .add(new LatLng(16.450252, 102.831145))
                        .add(new LatLng(16.448750, 102.831059))
                        .add(new LatLng(16.448063, 102.830965))
                        .add(new LatLng(16.445712, 102.830284))
                        .add(new LatLng(16.444652, 102.829951))
                        .add(new LatLng(16.443662, 102.829602))
                        .add(new LatLng(16.442972, 102.829451))
                        .add(new LatLng(16.440762, 102.828784))
                        .add(new LatLng(16.440518, 102.828738))
                        .add(new LatLng(16.439777, 102.828526))
                        .add(new LatLng(16.439561, 102.828413))
                        .add(new LatLng(16.439446, 102.829908))
                        .add(new LatLng(16.439318, 102.830817))
                        .add(new LatLng(16.439074, 102.832823))
                        .add(new LatLng(16.438831, 102.834276))
                        .add(new LatLng(16.438631, 102.834744))
                        .add(new LatLng(16.437597, 102.834645))
                        .add(new LatLng(16.436703, 102.834547))
                        .add(new LatLng(16.435657, 102.834449))
                        .add(new LatLng(16.434695, 102.834352))
                        .add(new LatLng(16.434210, 102.834304))
                        .add(new LatLng(16.433275, 102.834206))
                        .add(new LatLng(16.432594, 102.834130))
                        .add(new LatLng(16.431039, 102.833951))
                        .add(new LatLng(16.430620, 102.833935))
                        .add(new LatLng(16.429863, 102.833872))
                        .add(new LatLng(16.429107, 102.833788))
                        .add(new LatLng(16.428365, 102.833677))
                        .add(new LatLng(16.427799, 102.833629))
                        .add(new LatLng(16.426890, 102.833536))
                        .add(new LatLng(16.426202, 102.833470))
                        .add(new LatLng(16.425661, 102.833423))
                        .add(new LatLng(16.425380, 102.833422))
                        .add(new LatLng(16.425112, 102.833330))
                        .add(new LatLng(16.424696, 102.833299))
                        .add(new LatLng(16.424079, 102.833227))
                        .add(new LatLng(16.423976, 102.833221))
                        .add(new LatLng(16.423369, 102.833240))
                        .add(new LatLng(16.422607, 102.833130))
                        .add(new LatLng(16.422360, 102.832991))
                        .add(new LatLng(16.421938, 102.832959))
                        .add(new LatLng(16.421610, 102.832908))
                        .add(new LatLng(16.421151, 102.832874))
                        .add(new LatLng(16.420570, 102.832795))
                        .add(new LatLng(16.420275, 102.832760))
                        .add(new LatLng(16.419942, 102.832702))
                        .add(new LatLng(16.419504, 102.832652))
                        .add(new LatLng(16.419370, 102.832633))
                        .add(new LatLng(16.418997, 102.832620))
                        .add(new LatLng(16.417878, 102.832522))
                        .add(new LatLng(16.417241, 102.832518))
                        .add(new LatLng(16.416923, 102.832507))
                        .add(new LatLng(16.416283, 102.832542))
                        .add(new LatLng(16.415039, 102.832495))
                        .add(new LatLng(16.413376, 102.832315))
                        .add(new LatLng(16.413446, 102.831158))
                        .add(new LatLng(16.413472, 102.830919))
                        .add(new LatLng(16.413510, 102.830675))
                        .add(new LatLng(16.413595, 102.830166))
                        .add(new LatLng(16.413765, 102.829412))
                        .add(new LatLng(16.413863, 102.829047))
                        .add(new LatLng(16.413991, 102.828632))
                        .add(new LatLng(16.414385, 102.826963))
                        .add(new LatLng(16.414578, 102.826164))
                        .add(new LatLng(16.415046, 102.824491))
                        .add(new LatLng(16.415579, 102.822632))
                        .add(new LatLng(16.415620, 102.822364))
                        .add(new LatLng(16.415700, 102.822104))
                        .add(new LatLng(16.415798, 102.821860))
                        .add(new LatLng(16.415924, 102.821366))
                        .add(new LatLng(16.415970, 102.821004))
                        .add(new LatLng(16.415960, 102.820712))
                        .add(new LatLng(16.415880, 102.820411))
                        .add(new LatLng(16.415729, 102.820025))
                        .add(new LatLng(16.415531, 102.819673))
                        .add(new LatLng(16.415389, 102.819370))
                        .add(new LatLng(16.415181, 102.818984))
                        .add(new LatLng(16.414821, 102.818550))
                        .add(new LatLng(16.414049, 102.818307))
                        .add(new LatLng(16.413540, 102.818292))
                        .add(new LatLng(16.412768, 102.818019))
                        .add(new LatLng(16.411648, 102.817670))
                        .add(new LatLng(16.410266, 102.817270))
                        .add(new LatLng(16.408311, 102.816841))
                        .add(new LatLng(16.406778, 102.816401))
                        .add(new LatLng(16.405080, 102.815939))
                        .add(new LatLng(16.403279, 102.815435))
                        .add(new LatLng(16.401766, 102.815059))
                        .add(new LatLng(16.400161, 102.814609))
                        .add(new LatLng(16.398452, 102.814083))
                        .add(new LatLng(16.396805, 102.813643))
                        .add(new LatLng(16.395165, 102.813105))
                        .add(new LatLng(16.393389, 102.812560))
                        .add(new LatLng(16.391917, 102.812087))
                        .add(new LatLng(16.390332, 102.811540))
                        .add(new LatLng(16.389612, 102.811369))
                        .add(new LatLng(16.388255, 102.810962))
                        .add(new LatLng(16.388577, 102.809616))
                        .add(new LatLng(16.388830, 102.808600))
                        .add(new LatLng(16.389066, 102.807493))
                        .add(new LatLng(16.389369, 102.806185))
                        .color(getResources().getColor(R.color.s4))

                );
                break;
            case "สาย 5 : ตลาดหนองไผ่ล้อม – บ้านทุ่ม\nตลาดหนองไผ่ล้อม, ตลาดเทศบาล, ตลาดบางลำภู, โรงเรียนขอนแก่นวิทยายน, เซ็นโทซ่า, ศูนย์ประชุมกาญจนาภิเษก, มหาวิทยาลัยขอนแก่น, สถาบันพัฒนาฝีมือแรงงานขอนแก่น, บ.ทุ่ม":

                // pin land mark start

                LatLng latLngLandmark1Line5 = new LatLng(16.425937, 102.831489);
                map.addMarker(new MarkerOptions().position(latLngLandmark1Line5).title("ตลาดหนองไผ่ล้อม").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark1Line5));

                LatLng latLngLandmark2Line5 = new LatLng(16.427475, 102.835103);
                map.addMarker(new MarkerOptions().position(latLngLandmark2Line5).title("ตลาดเทศบาล").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark2Line5));

                LatLng latLngLandmark3Line5 = new LatLng(16.428785, 102.835340);
                map.addMarker(new MarkerOptions().position(latLngLandmark3Line5).title("ตลาดบางลำพู").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark3Line5));

                LatLng latLngLandmark4Line5 = new LatLng(16.432384, 102.835668);
                map.addMarker(new MarkerOptions().position(latLngLandmark4Line5).title("โรงเรียนขอนแก่นวิทยายน").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark4Line5));

                LatLng latLngLandmark5Line5 = new LatLng(16.441920, 102.814607);
                map.addMarker(new MarkerOptions().position(latLngLandmark5Line5).title("ศูนย์ประชุมกาญจนาภิเษก").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark5Line5));

                LatLng latLngLandmark6Line5 = new LatLng(16.441920, 102.814607);
                map.addMarker(new MarkerOptions().position(latLngLandmark6Line5).title("มหาวิทยาลัยขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark6Line5));

                LatLng latLngLandmark7Line5 = new LatLng(16.446249, 102.785799);
                map.addMarker(new MarkerOptions().position(latLngLandmark7Line5).title("สถาบันพัฒนาฝีมือแรงงาน ขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark7Line5));

//                LatLng latLngLandmark8Line5 = new LatLng(16.450427, 102.714856);
//                map.addMarker(new MarkerOptions().position(latLngLandmark8Line5).title("บ. ทุ่ม").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark8Line5));

                // pin land mark stop


                LatLng mapCenter7 = new LatLng(16.426291, 102.827488);
                map.addMarker(new MarkerOptions().position(mapCenter7).title("Start").snippet("สาย 5 : ตลาดหนองไผ่ล้อม – บ้านทุ่ม").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                LatLng mapCenter8 = new LatLng(16.448607, 102.767814);
                map.addMarker(new MarkerOptions().position(mapCenter8).title("Stop").snippet("สาย 5 : ตลาดหนองไผ่ล้อม – บ้านทุ่ม").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter7, 15));
                map.addPolyline(new PolylineOptions().geodesic(true)
                        .add(new LatLng(16.426291, 102.827488))
                        .add(new LatLng(16.426173, 102.828182))
                        .add(new LatLng(16.426026, 102.829503))
                        .add(new LatLng(16.425977, 102.829932))
                        .add(new LatLng(16.425926, 102.830578))
                        .add(new LatLng(16.425893, 102.831128))
                        .add(new LatLng(16.425790, 102.831680))
                        .add(new LatLng(16.425746, 102.832292))
                        .add(new LatLng(16.425661, 102.833423))
                        .add(new LatLng(16.426202, 102.833470))
                        .add(new LatLng(16.426890, 102.833536))
                        .add(new LatLng(16.427799, 102.833629))
                        .add(new LatLng(16.428365, 102.833677))
                        .add(new LatLng(16.429107, 102.833788))
                        .add(new LatLng(16.429863, 102.833872))
                        .add(new LatLng(16.430620, 102.833935))
                        .add(new LatLng(16.431039, 102.833951))
                        .add(new LatLng(16.432594, 102.834130))
                        .add(new LatLng(16.433275, 102.834206))
                        .add(new LatLng(16.434210, 102.834304))
                        .add(new LatLng(16.434695, 102.834352))
                        .add(new LatLng(16.435657, 102.834449))
                        .add(new LatLng(16.436703, 102.834547))
                        .add(new LatLng(16.437597, 102.834645))
                        .add(new LatLng(16.438631, 102.834744))
                        .add(new LatLng(16.438710, 102.834736))
                        .add(new LatLng(16.438960, 102.833174))
                        .add(new LatLng(16.439022, 102.832513))
                        .add(new LatLng(16.439063, 102.832171))
                        .add(new LatLng(16.439265, 102.830764))
                        .add(new LatLng(16.439405, 102.829458))
                        .add(new LatLng(16.439512, 102.828740))
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
                        .add(new LatLng(16.448607, 102.767814))

                        .color(getResources().getColor(R.color.s5))


                );

                break;

            case "สาย 6 : ตลาดเทศบาล 1 – บ้านเหล่านกชุม\nตลาดเทศบาล, เทศบาลนครขอนแก่น, ศาลหลักเมืองขอนแก่น, เซ็นทรัลพลาซ่าขอนแก่น, บิ๊กซีขอนแก่น, ตลาดต้นตาล, โฮมโปรขอนแก่น, แม็คโครขอนแก่น, ประตูน้ำขอนแก่น, เทสโก้โลตัสขอนแก่น, บขส.3, บ.กุดกว้าง, บ.ท่าพระ, บ.หนองหญ้าแพรก, บ.ท่าแร่, บ.โนนเขวา, บ.เหล่านกชุม":


                // pin land mark start

                LatLng latLngLandmark1Line6 = new LatLng(16.427475, 102.835103);
                map.addMarker(new MarkerOptions().position(latLngLandmark1Line6).title("ตลาดเทศบาล").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark1Line6));

                LatLng latLngLandmark2Line6 = new LatLng(16.429785, 102.829246);
                map.addMarker(new MarkerOptions().position(latLngLandmark2Line6).title("เทศบาลนครขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark2Line6));

                LatLng latLngLandmark3Line6 = new LatLng(16.431150, 102.828590);
                map.addMarker(new MarkerOptions().position(latLngLandmark3Line6).title("ศาลหลักเมือง ขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark3Line6));

                LatLng latLngLandmark4Line6 = new LatLng(16.432114, 102.824713);
                map.addMarker(new MarkerOptions().position(latLngLandmark4Line6).title("เซ็นทรัลพลาซ่า ขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark4Line6));

                LatLng latLngLandmark5Line6 = new LatLng(16.423967, 102.820964);
                map.addMarker(new MarkerOptions().position(latLngLandmark5Line6).title("บิ๊กซี ขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark5Line6));

                LatLng latLngLandmark6Line6 = new LatLng(16.417918, 102.819266);
                map.addMarker(new MarkerOptions().position(latLngLandmark6Line6).title("ตลาดต้นตาล").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark6Line6));

                LatLng latLngLandmark7Line6 = new LatLng(16.409620, 102.817625);
                map.addMarker(new MarkerOptions().position(latLngLandmark7Line6).title("โฮมโปร ขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark7Line6));

                LatLng latLngLandmark8Line6 = new LatLng(16.404893, 102.815481);
                map.addMarker(new MarkerOptions().position(latLngLandmark8Line6).title("แม็คโคร ขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark8Line6));

                LatLng latLngLandmark9Line6 = new LatLng(16.404327, 102.815374);
                map.addMarker(new MarkerOptions().position(latLngLandmark9Line6).title("ประตูน้ำขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark9Line6));

                LatLng latLngLandmark10Line6 = new LatLng(16.401355, 102.815494);
                map.addMarker(new MarkerOptions().position(latLngLandmark10Line6).title("เทสโก้ โลตัส ขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark10Line6));

                LatLng latLngLandmark11Line6 = new LatLng(16.389460, 102.805893);
                map.addMarker(new MarkerOptions().position(latLngLandmark11Line6).title("บขส. 3").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark11Line6));

//                LatLng latLngLandmark11Line6 = new LatLng();
//                map.addMarker(new MarkerOptions().position(latLngLandmark11Line6).title("บ. กุดกว้าง").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark11Line6));
//
//                LatLng latLngLandmark12Line6 = new LatLng();
//                map.addMarker(new MarkerOptions().position(latLngLandmark12Line6).title("บ. ท่าพระ").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark12Line6));
//
//                LatLng latLngLandmark13Line6 = new LatLng();
//                map.addMarker(new MarkerOptions().position(latLngLandmark13Line6).title("บ. หนองหญ้าแพรก").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark13Line6));
//
//                LatLng latLngLandmark14Line6 = new LatLng();
//                map.addMarker(new MarkerOptions().position(latLngLandmark14Line6).title("บ. ท่าแร่").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark14Line6));
//
//                LatLng latLngLandmark15Line6 = new LatLng();
//                map.addMarker(new MarkerOptions().position(latLngLandmark15Line6).title("บ. โนนเขวา").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark15Line6));
//
//                LatLng latLngLandmark16Line6 = new LatLng();
//                map.addMarker(new MarkerOptions().position(latLngLandmark16Line6).title("บ. เหล่านกชุม").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark16Line6));

                // pin land mark stop

                LatLng mapCenter9 = new LatLng(16.425585, 102.834150);
                map.addMarker(new MarkerOptions().position(mapCenter9).title("Start").snippet("สาย 6 : ตลาดเทศบาล 1 – บ้านเหล่านกชุม").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                LatLng mapCenter10 = new LatLng(16.389369, 102.806185);
                map.addMarker(new MarkerOptions().position(mapCenter10).title("Stop").snippet("สาย 6 : ตลาดเทศบาล 1 – บ้านเหล่านกชุม").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter9, 15));
                map.addPolyline(new PolylineOptions().geodesic(true)
                        .add(new LatLng(16.425585, 102.834150))
                        .add(new LatLng(16.425660, 102.833427))
                        .add(new LatLng(16.425756, 102.832275))
                        .add(new LatLng(16.425779, 102.831686))
                        .add(new LatLng(16.425888, 102.831128))
                        .add(new LatLng(16.425919, 102.830597))
                        .add(new LatLng(16.425978, 102.829926))
                        .add(new LatLng(16.426017, 102.829521))
                        .add(new LatLng(16.426112, 102.828762))
                        .add(new LatLng(16.426189, 102.828188))
                        .add(new LatLng(16.426619, 102.828255))
                        .add(new LatLng(16.427846, 102.828545))
                        .add(new LatLng(16.429253, 102.828889))
                        .add(new LatLng(16.429441, 102.828929))
                        .add(new LatLng(16.429959, 102.829073))
                        .add(new LatLng(16.430275, 102.829170))
                        .add(new LatLng(16.430396, 102.828824))
                        .add(new LatLng(16.430571, 102.828464))
                        .add(new LatLng(16.431098, 102.828169))
                        .add(new LatLng(16.431426, 102.827905))
                        .add(new LatLng(16.431537, 102.827279))
                        .add(new LatLng(16.431763, 102.825966))
                        .add(new LatLng(16.431970, 102.824639))
                        .add(new LatLng(16.432172, 102.823555))
                        .add(new LatLng(16.431168, 102.823271))
                        .add(new LatLng(16.430587, 102.823185))
                        .add(new LatLng(16.429275, 102.822799))
                        .add(new LatLng(16.428267, 102.822509))
                        .add(new LatLng(16.426240, 102.821903))
                        .add(new LatLng(16.424805, 102.821496))
                        .add(new LatLng(16.423642, 102.821179))
                        .add(new LatLng(16.421152, 102.820449))
                        .add(new LatLng(16.419742, 102.820053))
                        .add(new LatLng(16.418651, 102.819736))
                        .add(new LatLng(16.416999, 102.819248))
                        .add(new LatLng(16.416525, 102.819061))
                        .add(new LatLng(16.416335, 102.819012))
                        .add(new LatLng(16.415867, 102.818825))
                        .add(new LatLng(16.414821, 102.818550))
                        .add(new LatLng(16.414049, 102.818307))
                        .add(new LatLng(16.413540, 102.818292))
                        .add(new LatLng(16.412768, 102.818019))
                        .add(new LatLng(16.411648, 102.817670))
                        .add(new LatLng(16.410266, 102.817270))
                        .add(new LatLng(16.409248, 102.817056))
                        .add(new LatLng(16.408311, 102.816841))
                        .add(new LatLng(16.406778, 102.816401))
                        .add(new LatLng(16.405080, 102.815939))
                        .add(new LatLng(16.403279, 102.815435))
                        .add(new LatLng(16.401766, 102.815059))
                        .add(new LatLng(16.400161, 102.814609))
                        .add(new LatLng(16.398452, 102.814083))
                        .add(new LatLng(16.396805, 102.813643))
                        .add(new LatLng(16.395165, 102.813105))
                        .add(new LatLng(16.393389, 102.812560))
                        .add(new LatLng(16.391917, 102.812087))
                        .add(new LatLng(16.390332, 102.811540))
                        .add(new LatLng(16.389612, 102.811369))
                        .add(new LatLng(16.388255, 102.810962))
                        .add(new LatLng(16.388577, 102.809616))
                        .add(new LatLng(16.388830, 102.808600))
                        .add(new LatLng(16.389066, 102.807493))
                        .add(new LatLng(16.389369, 102.806185))

                        .color(getResources().getColor(R.color.s6))
                );

                break;

            case "สาย 8 : สามเหลี่ยม – บ้านดอนบม\nมหาวิทยาลัยขอนแก่น, เซ็นโทซ่า, บขส.1, บขส.2, สถานีตํารวจภูธรเมืองขอนแก่น, โรงเรียนขอนแก่นวิทยายน, โรงเรียนกัลยาณวัตร, ตลาดเทศบาล, แฟรี่พลาซ่า, เมืองเก่า, บึงแก่นนคร, บ.ดอนบม":

                // pin land mark start

                LatLng latLngLandmark1Line8 = new LatLng(16.476059, 102.832161);
                map.addMarker(new MarkerOptions().position(latLngLandmark1Line8).title("มหาวิทยาลัยขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark1Line8));

                LatLng latLngLandmark2Line8 = new LatLng(16.439266, 102.833345);
                map.addMarker(new MarkerOptions().position(latLngLandmark2Line8).title("บขส. 1").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark2Line8));

                LatLng latLngLandmark3Line8 = new LatLng(16.433174, 102.836077);
                map.addMarker(new MarkerOptions().position(latLngLandmark3Line8).title("บขส. 2").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark3Line8));

                LatLng latLngLandmark4Line8 = new LatLng(16.428687, 102.835620);
                map.addMarker(new MarkerOptions().position(latLngLandmark4Line8).title("สถานีตํารวจภูธรเมืองขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark4Line8));

                LatLng latLngLandmark5Line8 = new LatLng(16.432384, 102.835668);
                map.addMarker(new MarkerOptions().position(latLngLandmark5Line8).title("โรงเรียนขอนแก่นวิทยายน").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark5Line8));

                LatLng latLngLandmark6Line8 = new LatLng(16.427651, 102.835532);
                map.addMarker(new MarkerOptions().position(latLngLandmark6Line8).title("โรงเรียนกัลยาณวัตร").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark6Line8));

                LatLng latLngLandmark7Line8 = new LatLng(16.427475, 102.835103);
                map.addMarker(new MarkerOptions().position(latLngLandmark7Line8).title("ตลาดเทศบาล").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark7Line8));

                LatLng latLngLandmark8Line8 = new LatLng(16.423924, 102.833135);
                map.addMarker(new MarkerOptions().position(latLngLandmark8Line8).title("แฟรี่ พลาซ่า").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark8Line8));

                LatLng latLngLandmark9Line8 = new LatLng(16.413309, 102.835381);
                map.addMarker(new MarkerOptions().position(latLngLandmark9Line8).title("บึงแก่นนคร").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark9Line8));

//                LatLng latLngLandmark10Line8 = new LatLng(16.378520, 102.846291);
//                map.addMarker(new MarkerOptions().position(latLngLandmark10Line8).title("บ. ดอนบม").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark10Line8));

                // pin land mark stop

                LatLng mapCenter11 = new LatLng(16.389369, 102.806185);
                map.addMarker(new MarkerOptions().position(mapCenter11).title("Start").snippet("สาย 8 : สามเหลี่ยม – บ้านดอนบม").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                LatLng mapCenter12 = new LatLng(16.464089, 102.831887);
                map.addMarker(new MarkerOptions().position(mapCenter12).title("Stop").snippet("สาย 8 : สามเหลี่ยม – บ้านดอนบม").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter11, 15));
                map.addPolyline(new PolylineOptions().geodesic(true)
                        .add(new LatLng(16.389369, 102.806185))
                        .add(new LatLng(16.389066, 102.807493))
                        .add(new LatLng(16.388830, 102.808600))
                        .add(new LatLng(16.388577, 102.809616))
                        .add(new LatLng(16.388255, 102.810962))
                        .add(new LatLng(16.389612, 102.811369))
                        .add(new LatLng(16.389136, 102.813371))
                        .add(new LatLng(16.388045, 102.817458))
                        .add(new LatLng(16.387334, 102.820188))
                        .add(new LatLng(16.386603, 102.822731))
                        .add(new LatLng(16.386319, 102.823462))
                        .add(new LatLng(16.386823, 102.823883))
                        .add(new LatLng(16.389439, 102.825792))
                        .add(new LatLng(16.389918, 102.826135))
                        .add(new LatLng(16.390551, 102.826516))
                        .add(new LatLng(16.391210, 102.826849))
                        .add(new LatLng(16.393047, 102.827793))
                        .add(new LatLng(16.394004, 102.828324))
                        .add(new LatLng(16.395028, 102.828914))
                        .add(new LatLng(16.395790, 102.829284))
                        .add(new LatLng(16.396999, 102.829952))
                        .add(new LatLng(16.397826, 102.830349))
                        .add(new LatLng(16.398599, 102.830731))
                        .add(new LatLng(16.399393, 102.831118))
                        .add(new LatLng(16.400411, 102.831551))
                        .add(new LatLng(16.401272, 102.831892))
                        .add(new LatLng(16.402672, 102.832338))
                        .add(new LatLng(16.403969, 102.832714))
                        .add(new LatLng(16.405101, 102.832982))
                        .add(new LatLng(16.405524, 102.833039))
                        .add(new LatLng(16.406435, 102.833243))
                        .add(new LatLng(16.407139, 102.833377))
                        .add(new LatLng(16.407553, 102.833448))
                        .add(new LatLng(16.408055, 102.833507))
                        .add(new LatLng(16.408960, 102.833560))
                        .add(new LatLng(16.409187, 102.833528))
                        .add(new LatLng(16.409825, 102.833592))
                        .add(new LatLng(16.410329, 102.833646))
                        .add(new LatLng(16.411302, 102.833721))
                        .add(new LatLng(16.412424, 102.833822))
                        .add(new LatLng(16.413034, 102.833897))
                        .add(new LatLng(16.413366, 102.833918))
                        .add(new LatLng(16.414336, 102.834001))
                        .add(new LatLng(16.414704, 102.834041))
                        .add(new LatLng(16.415337, 102.834089))
                        .add(new LatLng(16.415718, 102.834128))
                        .add(new LatLng(16.415997, 102.834144))
                        .add(new LatLng(16.416774, 102.834231))
                        .add(new LatLng(16.417317, 102.834248))
                        .add(new LatLng(16.417904, 102.834296))
                        .add(new LatLng(16.418722, 102.834468))
                        .add(new LatLng(16.419322, 102.834537))
                        .add(new LatLng(16.420153, 102.834605))
                        .add(new LatLng(16.420436, 102.834634))
                        .add(new LatLng(16.420585, 102.834686))
                        .add(new LatLng(16.421336, 102.834781))
                        .add(new LatLng(16.421973, 102.834860))
                        .add(new LatLng(16.422526, 102.834863))
                        .add(new LatLng(16.423146, 102.834853))
                        .add(new LatLng(16.424269, 102.834981))
                        .add(new LatLng(16.424659, 102.835021))
                        .add(new LatLng(16.425546, 102.835081))
                        .add(new LatLng(16.426043, 102.835119))
                        .add(new LatLng(16.426488, 102.835144))
                        .add(new LatLng(16.426960, 102.835193))
                        .add(new LatLng(16.428204, 102.835442))
                        .add(new LatLng(16.428894, 102.835501))
                        .add(new LatLng(16.429589, 102.835592))
                        .add(new LatLng(16.430376, 102.835662))
                        .add(new LatLng(16.431009, 102.835746))
                        .add(new LatLng(16.431416, 102.835776))
                        .add(new LatLng(16.432526, 102.835926))
                        .add(new LatLng(16.433097, 102.835950))
                        .add(new LatLng(16.434028, 102.836092))
                        .add(new LatLng(16.434916, 102.836175))
                        .add(new LatLng(16.435294, 102.836216))
                        .add(new LatLng(16.436470, 102.836360))
                        .add(new LatLng(16.437067, 102.836319))
                        .add(new LatLng(16.438445, 102.836451))
                        .add(new LatLng(16.438404, 102.836455))
                        .add(new LatLng(16.438710, 102.834736))
                        .add(new LatLng(16.438960, 102.833174))
                        .add(new LatLng(16.439022, 102.832513))
                        .add(new LatLng(16.439063, 102.832171))
                        .add(new LatLng(16.439265, 102.830764))
                        .add(new LatLng(16.439405, 102.829458))
                        .add(new LatLng(16.439512, 102.828740))
                        .add(new LatLng(16.439512, 102.828740))
                        .add(new LatLng(16.439781, 102.826719))
                        .add(new LatLng(16.440265, 102.823570))
                        .add(new LatLng(16.440646, 102.820941))
                        .add(new LatLng(16.440743, 102.820088))
                        .add(new LatLng(16.440913, 102.819134))
                        .add(new LatLng(16.441228, 102.819100))
                        .add(new LatLng(16.441820, 102.819167))
                        .add(new LatLng(16.442782, 102.819326))
                        .add(new LatLng(16.444284, 102.819530))
                        .add(new LatLng(16.445958, 102.819706))
                        .add(new LatLng(16.446410, 102.819747))
                        .add(new LatLng(16.446723, 102.819760))
                        .add(new LatLng(16.447796, 102.819899))
                        .add(new LatLng(16.447933, 102.819861))
                        .add(new LatLng(16.448489, 102.819974))
                        .add(new LatLng(16.449472, 102.820076))
                        .add(new LatLng(16.450396, 102.820218))
                        .add(new LatLng(16.451479, 102.820360))
                        .add(new LatLng(16.452351, 102.820462))
                        .add(new LatLng(16.453822, 102.820624))
                        .add(new LatLng(16.454961, 102.820742))
                        .add(new LatLng(16.456018, 102.820919))
                        .add(new LatLng(16.457103, 102.821050))
                        .add(new LatLng(16.458226, 102.821189))
                        .add(new LatLng(16.459461, 102.821339))
                        .add(new LatLng(16.460904, 102.821532))
                        .add(new LatLng(16.461555, 102.821612))
                        .add(new LatLng(16.461779, 102.821629))
                        .add(new LatLng(16.463253, 102.821827))
                        .add(new LatLng(16.465148, 102.822072))
                        .add(new LatLng(16.465139, 102.822184))
                        .add(new LatLng(16.465119, 102.822643))
                        .add(new LatLng(16.464998, 102.823781))
                        .add(new LatLng(16.464766, 102.825696))
                        .add(new LatLng(16.464653, 102.826598))
                        .add(new LatLng(16.464581, 102.827383))
                        .add(new LatLng(16.464506, 102.827735))
                        .add(new LatLng(16.464465, 102.828019))
                        .add(new LatLng(16.464372, 102.829111))
                        .add(new LatLng(16.464246, 102.830208))
                        .add(new LatLng(16.464138, 102.831166))
                        .add(new LatLng(16.464117, 102.831447))
                        .add(new LatLng(16.464089, 102.831887))
                        .color(getResources().getColor(R.color.s8)));

                        // อีกเส้น
                    LatLng mapCenter11_2 = new LatLng(16.413375, 102.833920);
                    map.addMarker(new MarkerOptions().position(mapCenter11_2).title("Start 2").snippet("สาย 8 : สามเหลี่ยม – บ้านดอนบม").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    LatLng mapCenter12_2 = new LatLng(16.390434, 102.841350);
                    map.addMarker(new MarkerOptions().position(mapCenter12_2).title("Stop 2").snippet("สาย 8 : สามเหลี่ยม – บ้านดอนบม").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    map.addPolyline(new PolylineOptions().geodesic(true)
                        .add(new LatLng(16.413375, 102.833920))
                        .add(new LatLng(16.413337, 102.835197))
                        .add(new LatLng(16.412992, 102.835159))
                        .add(new LatLng(16.412621, 102.835099))
                        .add(new LatLng(16.412336, 102.835062))
                        .add(new LatLng(16.412115, 102.835058))
                        .add(new LatLng(16.411870, 102.835065))
                        .add(new LatLng(16.411533, 102.835070))
                        .add(new LatLng(16.410992, 102.835083))
                        .add(new LatLng(16.410642, 102.835091))
                        .add(new LatLng(16.410520, 102.835108))
                        .add(new LatLng(16.410184, 102.835173))
                        .add(new LatLng(16.409345, 102.835463))
                        .add(new LatLng(16.408987, 102.835552))
                        .add(new LatLng(16.408460, 102.835729))
                        .add(new LatLng(16.408196, 102.835830))
                        .add(new LatLng(16.407502, 102.836081))
                        .add(new LatLng(16.407039, 102.836298))
                        .add(new LatLng(16.406926, 102.836406))
                        .add(new LatLng(16.406848, 102.836545))
                        .add(new LatLng(16.406699, 102.836953))
                        .add(new LatLng(16.406532, 102.837583))
                        .add(new LatLng(16.406097, 102.839131))
                        .add(new LatLng(16.406077, 102.839228))
                        .add(new LatLng(16.406101, 102.839402))
                        .add(new LatLng(16.405202, 102.839096))
                        .add(new LatLng(16.404911, 102.839005))
                        .add(new LatLng(16.404667, 102.838956))
                        .add(new LatLng(16.404395, 102.838872))
                        .add(new LatLng(16.403905, 102.838734))
                        .add(new LatLng(16.403045, 102.838474))
                        .add(new LatLng(16.402150, 102.838200))
                        .add(new LatLng(16.401217, 102.837918))
                        .add(new LatLng(16.400880, 102.837807))
                        .add(new LatLng(16.400688, 102.837749))
                        .add(new LatLng(16.400229, 102.837558))
                        .add(new LatLng(16.399842, 102.837770))
                        .add(new LatLng(16.399238, 102.838001))
                        .add(new LatLng(16.398873, 102.838178))
                        .add(new LatLng(16.397892, 102.838575))
                        .add(new LatLng(16.397022, 102.838965))
                        .add(new LatLng(16.396691, 102.839086))
                        .add(new LatLng(16.396333, 102.839246))
                        .add(new LatLng(16.395797, 102.839441))
                        .add(new LatLng(16.395254, 102.839634))
                        .add(new LatLng(16.394290, 102.839970))
                        .add(new LatLng(16.393786, 102.840156))
                        .add(new LatLng(16.393079, 102.840362))
                        .add(new LatLng(16.392493, 102.840562))
                        .add(new LatLng(16.391915, 102.840744))
                        .add(new LatLng(16.391574, 102.840870))
                        .add(new LatLng(16.391280, 102.840994))
                        .add(new LatLng(16.390943, 102.841172))
                        .add(new LatLng(16.390707, 102.841202))
                        .add(new LatLng(16.390434, 102.841350))
                        .color(getResources().getColor(R.color.s8))
                );
                break;

            case "สาย 9 : สามเหลี่ยม – บ้านสะอาด\nบ.สามเหลี่ยม, บขส.1, บขส.2, โรงเรียนขอนแก่นวิทยายน, ไปรษณีย์ขอนแก่น, ตลาดเทศบาล, แฟรี่พลาซ่า, สนามกีฬากลางขอนแก่น, โรงเรียนแก่นนครวิทยาลัย, ตลาดต้นตาล, มหาวิทยาลัยภาคตะวันออกเฉียงเหนือ, บ.กอก, บ.โจด, บ.สะอาด":

                // pin land mark start

                LatLng latLngLandmark1Line9 = new LatLng(16.440316, 102.825347);
                map.addMarker(new MarkerOptions().position(latLngLandmark1Line9).title("บ. สามเหลี่ยม").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark1Line9));

                LatLng latLngLandmark2Line9 = new LatLng(16.439266, 102.833345);
                map.addMarker(new MarkerOptions().position(latLngLandmark2Line9).title("บขส. 1").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark2Line9));

                LatLng latLngLandmark3Line9 = new LatLng(16.433174, 102.836077);
                map.addMarker(new MarkerOptions().position(latLngLandmark3Line9).title("บขส. 2").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark3Line9));

//                LatLng latLngLandmark4Line9 = new LatLng(16.378520, 102.846291);
//                map.addMarker(new MarkerOptions().position(latLngLandmark4Line9).title("บ. ดอนบม").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark4Line9));

                LatLng latLngLandmark5Line9 = new LatLng(16.432384, 102.835668);
                map.addMarker(new MarkerOptions().position(latLngLandmark5Line9).title("โรงเรียนขอนแก่นวิทยายน").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark5Line9));

                LatLng latLngLandmark6Line9 = new LatLng(16.429769, 102.835726);
                map.addMarker(new MarkerOptions().position(latLngLandmark6Line9).title("ไปรษณีย์ขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark6Line9));

                LatLng latLngLandmark7Line9 = new LatLng(16.427475, 102.835103);
                map.addMarker(new MarkerOptions().position(latLngLandmark7Line9).title("ตลาดเทศบาล").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark7Line9));

                LatLng latLngLandmark8Line9 = new LatLng(16.423924, 102.833135);
                map.addMarker(new MarkerOptions().position(latLngLandmark8Line9).title("แฟรี่ พลาซ่า").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark8Line9));

                LatLng latLngLandmark9Line9 = new LatLng(16.413771, 102.828920);
                map.addMarker(new MarkerOptions().position(latLngLandmark9Line9).title("สนามกีฬากลางขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark9Line9));

                LatLng latLngLandmark10Line9 = new LatLng(16.415286, 102.824483);
                map.addMarker(new MarkerOptions().position(latLngLandmark10Line9).title("โรงเรียนแก่นนครวิทยาลัย").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark10Line9));

                LatLng latLngLandmark11Line9 = new LatLng(16.417918, 102.819266);
                map.addMarker(new MarkerOptions().position(latLngLandmark11Line9).title("ตลาดต้นตาล").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark11Line9));

                LatLng latLngLandmark12Line9 = new LatLng(16.421536, 102.815885);
                map.addMarker(new MarkerOptions().position(latLngLandmark12Line9).title("มหาวิทยาลัยภาคตะวันออกเฉียงเหนือ").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark12Line9));

//                LatLng latLngLandmark13Line9 = new LatLng();
//                map.addMarker(new MarkerOptions().position(latLngLandmark13Line9).title("บ. โจด").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark13Line9));

//                LatLng latLngLandmark14Line9 = new LatLng(16.401787, 102.778999);
//                map.addMarker(new MarkerOptions().position(latLngLandmark14Line9).title("บ. สะอาด").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark14Line9));

                // pin land mark stop

                LatLng mapCenter27 = new LatLng(16.455835, 102.827421);
                map.addMarker(new MarkerOptions().position(mapCenter27).title("Start").snippet("สาย 9 : สามเหลี่ยม – บ้านสะอาด").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                LatLng mapCenter28 = new LatLng(16.409571, 102.781850);
                map.addMarker(new MarkerOptions().position(mapCenter28).title("Stop").snippet("สาย 9 : สามเหลี่ยม – บ้านสะอาด").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter27, 15));
                map.addPolyline(new PolylineOptions().geodesic(true)
                        .add(new LatLng(16.455835, 102.827421))
                        .add(new LatLng(16.455209, 102.827060))
                        .add(new LatLng(16.454870, 102.826884))
                        .add(new LatLng(16.454592, 102.826693))
                        .add(new LatLng(16.454301, 102.826495))
                        .add(new LatLng(16.454102, 102.826402))
                        .add(new LatLng(16.453891, 102.826324))
                        .add(new LatLng(16.453400, 102.826191))
                        .add(new LatLng(16.452658, 102.825963))
                        .add(new LatLng(16.452276, 102.825888))
                        .add(new LatLng(16.451879, 102.825794))
                        .add(new LatLng(16.450958, 102.825558))
                        .add(new LatLng(16.450510, 102.825461))
                        .add(new LatLng(16.449926, 102.825345))
                        .add(new LatLng(16.449743, 102.825342))
                        .add(new LatLng(16.449577, 102.825344))
                        .add(new LatLng(16.448431, 102.825434))
                        .add(new LatLng(16.448099, 102.825445))
                        .add(new LatLng(16.447634, 102.825480))
                        .add(new LatLng(16.447449, 102.825480))
                        .add(new LatLng(16.447248, 102.825445))
                        .add(new LatLng(16.446147, 102.825418))
                        .add(new LatLng(16.445681, 102.825372))
                        .add(new LatLng(16.445117, 102.825338))
                        .add(new LatLng(16.444739, 102.825316))
                        .add(new LatLng(16.444366, 102.825282))
                        .add(new LatLng(16.443614, 102.825302))
                        .add(new LatLng(16.443374, 102.825309))
                        .add(new LatLng(16.442337, 102.825247))
                        .add(new LatLng(16.441874, 102.825199))
                        .add(new LatLng(16.440604, 102.825172))
                        .add(new LatLng(16.440372, 102.825166))
                        .add(new LatLng(16.440173, 102.825130))
                        .add(new LatLng(16.440076, 102.825829))
                        .add(new LatLng(16.439999, 102.826473))
                        .add(new LatLng(16.439752, 102.828232))
                        .add(new LatLng(16.439646, 102.828683))
                        .add(new LatLng(16.439405, 102.829458))
                        .add(new LatLng(16.439265, 102.830764))
                        .add(new LatLng(16.439063, 102.832171))
                        .add(new LatLng(16.439022, 102.832513))
                        .add(new LatLng(16.438960, 102.833174))
                        .add(new LatLng(16.438710, 102.834736))
                        .add(new LatLng(16.438400, 102.836454))
                        .add(new LatLng(16.437067, 102.836319))
                        .add(new LatLng(16.436470, 102.836360))
                        .add(new LatLng(16.435294, 102.836216))
                        .add(new LatLng(16.434916, 102.836175))
                        .add(new LatLng(16.434028, 102.836092))
                        .add(new LatLng(16.433097, 102.835950))
                        .add(new LatLng(16.432526, 102.835926))
                        .add(new LatLng(16.431416, 102.835776))
                        .add(new LatLng(16.431009, 102.835746))
                        .add(new LatLng(16.430376, 102.835662))
                        .add(new LatLng(16.429589, 102.835592))
                        .add(new LatLng(16.428894, 102.835501))
                        .add(new LatLng(16.428204, 102.835442))
                        .add(new LatLng(16.426960, 102.835193))
                        .add(new LatLng(16.426488, 102.835144))
                        .add(new LatLng(16.426043, 102.835119))
                        .add(new LatLng(16.425546, 102.835081))
                        .add(new LatLng(16.425512, 102.834991))
                        .add(new LatLng(16.425581, 102.834230))
                        .add(new LatLng(16.425655, 102.833418))
                        .add(new LatLng(16.425380, 102.833422))
                        .add(new LatLng(16.425112, 102.833330))
                        .add(new LatLng(16.424696, 102.833299))
                        .add(new LatLng(16.424079, 102.833227))
                        .add(new LatLng(16.423976, 102.833221))
                        .add(new LatLng(16.422607, 102.833130))
                        .add(new LatLng(16.422360, 102.832991))
                        .add(new LatLng(16.421938, 102.832959))
                        .add(new LatLng(16.421610, 102.832908))
                        .add(new LatLng(16.421151, 102.832874))
                        .add(new LatLng(16.420570, 102.832795))
                        .add(new LatLng(16.420275, 102.832760))
                        .add(new LatLng(16.419942, 102.832702))
                        .add(new LatLng(16.419504, 102.832652))
                        .add(new LatLng(16.419370, 102.832633))
                        .add(new LatLng(16.418997, 102.832620))
                        .add(new LatLng(16.417878, 102.832522))
                        .add(new LatLng(16.417241, 102.832518))
                        .add(new LatLng(16.416923, 102.832507))
                        .add(new LatLng(16.416283, 102.832542))
                        .add(new LatLng(16.415039, 102.832495))
                        .add(new LatLng(16.413376, 102.832315))
                        .add(new LatLng(16.413384, 102.832319))
                        .add(new LatLng(16.413440, 102.831370))
                        .add(new LatLng(16.413446, 102.831158))
                        .add(new LatLng(16.413472, 102.830919))
                        .add(new LatLng(16.413510, 102.830675))
                        .add(new LatLng(16.413595, 102.830166))
                        .add(new LatLng(16.413765, 102.829412))
                        .add(new LatLng(16.413863, 102.829047))
                        .add(new LatLng(16.413991, 102.828632))
                        .add(new LatLng(16.414385, 102.826963))
                        .add(new LatLng(16.414578, 102.826164))
                        .add(new LatLng(16.415046, 102.824491))
                        .add(new LatLng(16.415579, 102.822632))
                        .add(new LatLng(16.415620, 102.822364))
                        .add(new LatLng(16.415700, 102.822104))
                        .add(new LatLng(16.415798, 102.821860))
                        .add(new LatLng(16.415924, 102.821366))
                        .add(new LatLng(16.415970, 102.821004))
                        .add(new LatLng(16.415960, 102.820712))
                        .add(new LatLng(16.415880, 102.820411))
                        .add(new LatLng(16.415729, 102.820025))
                        .add(new LatLng(16.415531, 102.819673))
                        .add(new LatLng(16.415389, 102.819370))
                        .add(new LatLng(16.415181, 102.818984))
                        .add(new LatLng(16.414986, 102.818506))
                        .add(new LatLng(16.415939, 102.818772))
                        .add(new LatLng(16.416422, 102.818928))
                        .add(new LatLng(16.416793, 102.819030))
                        .add(new LatLng(16.417735, 102.819298))
                        .add(new LatLng(16.419412, 102.819765))
                        .add(new LatLng(16.419939, 102.819920))
                        .add(new LatLng(16.420632, 102.820109))
                        .add(new LatLng(16.421246, 102.820279))
                        .add(new LatLng(16.421438, 102.820356))
                        .add(new LatLng(16.421421, 102.819797))
                        .add(new LatLng(16.421418, 102.819027))
                        .add(new LatLng(16.421390, 102.818692))
                        .add(new LatLng(16.421383, 102.818154))
                        .add(new LatLng(16.421380, 102.817671))
                        .add(new LatLng(16.421377, 102.817025))
                        .add(new LatLng(16.421393, 102.816161))
                        .add(new LatLng(16.421383, 102.815697))
                        .add(new LatLng(16.421344, 102.815008))
                        .add(new LatLng(16.421324, 102.814058))
                        .add(new LatLng(16.421303, 102.813597))
                        .add(new LatLng(16.421303, 102.813071))
                        .add(new LatLng(16.421303, 102.812570))
                        .add(new LatLng(16.421298, 102.812122))
                        .add(new LatLng(16.421301, 102.811773))
                        .add(new LatLng(16.421298, 102.811105))
                        .add(new LatLng(16.421298, 102.810029))
                        .add(new LatLng(16.421297, 102.808266))
                        .add(new LatLng(16.421287, 102.807097))
                        .add(new LatLng(16.421295, 102.806939))
                        .add(new LatLng(16.421354, 102.806743))
                        .add(new LatLng(16.421459, 102.806518))
                        .add(new LatLng(16.421933, 102.805611))
                        .add(new LatLng(16.421987, 102.805464))
                        .add(new LatLng(16.422337, 102.804772))
                        .add(new LatLng(16.422597, 102.804323))
                        .add(new LatLng(16.422768, 102.804043))
                        .add(new LatLng(16.423033, 102.803455))
                        .add(new LatLng(16.423366, 102.802782))
                        .add(new LatLng(16.423607, 102.802323))
                        .add(new LatLng(16.423786, 102.802023))
                        .add(new LatLng(16.424440, 102.801037))
                        .add(new LatLng(16.424197, 102.800790))
                        .add(new LatLng(16.423916, 102.800582))
                        .add(new LatLng(16.423574, 102.800331))
                        .add(new LatLng(16.423189, 102.800052))
                        .add(new LatLng(16.422618, 102.799666))
                        .add(new LatLng(16.422182, 102.799379))
                        .add(new LatLng(16.421657, 102.799009))
                        .add(new LatLng(16.421221, 102.798751))
                        .add(new LatLng(16.420899, 102.798511))
                        .add(new LatLng(16.420728, 102.798362))
                        .add(new LatLng(16.420701, 102.798272))
                        .add(new LatLng(16.421175, 102.797446))
                        .add(new LatLng(16.421361, 102.797133))
                        .add(new LatLng(16.421385, 102.797038))
                        .add(new LatLng(16.421377, 102.796904))
                        .add(new LatLng(16.421238, 102.796412))
                        .add(new LatLng(16.420965, 102.795308))
                        .add(new LatLng(16.420834, 102.794865))
                        .add(new LatLng(16.420750, 102.794436))
                        .add(new LatLng(16.420586, 102.793878))
                        .add(new LatLng(16.420274, 102.792706))
                        .add(new LatLng(16.419876, 102.791122))
                        .add(new LatLng(16.419745, 102.790693))
                        .add(new LatLng(16.419628, 102.790208))
                        .add(new LatLng(16.419452, 102.789529))
                        .add(new LatLng(16.419167, 102.788410))
                        .add(new LatLng(16.419001, 102.787769))
                        .add(new LatLng(16.419026, 102.787589))
                        .add(new LatLng(16.419152, 102.787218))
                        .add(new LatLng(16.419362, 102.786766))
                        .add(new LatLng(16.419416, 102.786586))
                        .add(new LatLng(16.419666, 102.785964))
                        .add(new LatLng(16.419064, 102.785776))
                        .add(new LatLng(16.418243, 102.785473))
                        .add(new LatLng(16.416558, 102.784792))
                        .add(new LatLng(16.415567, 102.784406))
                        .add(new LatLng(16.413817, 102.783663))
                        .add(new LatLng(16.413229, 102.783442))
                        .add(new LatLng(16.412848, 102.783289))
                        .add(new LatLng(16.411731, 102.782793))
                        .add(new LatLng(16.410638, 102.782337))
                        .add(new LatLng(16.409753, 102.781968))
                        .add(new LatLng(16.409571, 102.781850))
                        .color(getResources().getColor(R.color.s9))
                );

                break;

            case "สาย 10 : มหาวิทยาลัยขอนแก่น – สนามม้า\nมหาวิทยาลัยขอนแก่น, บขส.1, ที่ว่าการอําเภอเมืองขอนแก่น, บ.บะขาม, เรือนจำขอนแก่น, บขส.2, โรงเรียนขอนแก่นวิทยายน, ไปรษณีย์ขอนแก่น, สถานีตํารวจภูธรเมืองขอนแก่น, ตลาดเทศบาล, แฟรี่พลาซ่า, สนามกีฬากลางขอนแก่น, โรงเรียนแก่นนครวิทยาลัย, ประตูน้ำขอนแก่น, แม็คโครขอนแก่น, เทสโก้โลตัสขอนแก่น":

                // pin land mark start

//                LatLng latLngLandmark1Line10 = new LatLng(16.476059, 102.832161);
//                map.addMarker(new MarkerOptions().position(latLngLandmark1Line10).title("มหาวิทยาลัยขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark1Line10));

                LatLng latLngLandmark2Line10 = new LatLng(16.439266, 102.833345);
                map.addMarker(new MarkerOptions().position(latLngLandmark2Line10).title("บขส. 1").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark2Line10));

                LatLng latLngLandmark3Line10 = new LatLng(16.438212, 102.838964);
                map.addMarker(new MarkerOptions().position(latLngLandmark3Line10).title("ที่ว่าการอําเภอเมืองขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark3Line10));

                LatLng latLngLandmark4Line10 = new LatLng(16.431655, 102.856618);
                map.addMarker(new MarkerOptions().position(latLngLandmark4Line10).title("บ. บะขาม").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark4Line10));

                LatLng latLngLandmark5Line10 = new LatLng(16.429288, 102.845191);
                map.addMarker(new MarkerOptions().position(latLngLandmark5Line10).title("เรือนจำขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark5Line10));

                LatLng latLngLandmark6Line10 = new LatLng(16.433174, 102.836077);
                map.addMarker(new MarkerOptions().position(latLngLandmark6Line10).title("บขส. 2").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark6Line10));

                LatLng latLngLandmark7Line10 = new LatLng(16.432384, 102.835668);
                map.addMarker(new MarkerOptions().position(latLngLandmark7Line10).title("โรงเรียนขอนแก่นวิทยายน").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark7Line10));

                LatLng latLngLandmark8Line10 = new LatLng(16.429769, 102.835726);
                map.addMarker(new MarkerOptions().position(latLngLandmark8Line10).title("ไปรษณีย์ขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark8Line10));

                LatLng latLngLandmark9Line10 = new LatLng(16.428687, 102.835620);
                map.addMarker(new MarkerOptions().position(latLngLandmark9Line10).title("สถานีตํารวจภูธรเมืองขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark9Line10));

                LatLng latLngLandmark10Line10 = new LatLng(16.427475, 102.835103);
                map.addMarker(new MarkerOptions().position(latLngLandmark10Line10).title("ตลาดเทศบาล").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark10Line10));

                LatLng latLngLandmark11Line10 = new LatLng(16.423924, 102.833135);
                map.addMarker(new MarkerOptions().position(latLngLandmark11Line10).title("แฟรี่ พลาซ่า").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark11Line10));

                LatLng latLngLandmark12Line10 = new LatLng(16.413771, 102.828920);
                map.addMarker(new MarkerOptions().position(latLngLandmark12Line10).title("สนามกีฬากลางขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark12Line10));

                LatLng latLngLandmark13Line10 = new LatLng(16.415286, 102.824483);
                map.addMarker(new MarkerOptions().position(latLngLandmark13Line10).title("โรงเรียนแก่นนครวิทยาลัย").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark13Line10));

                LatLng latLngLandmark14Line10 = new LatLng(16.404327, 102.815374);
                map.addMarker(new MarkerOptions().position(latLngLandmark14Line10).title("ประตูน้ำขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark14Line10));

                LatLng latLngLandmark15Line10 = new LatLng(16.404893, 102.815481);
                map.addMarker(new MarkerOptions().position(latLngLandmark15Line10).title("แม็คโคร ขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark15Line10));

                LatLng latLngLandmark16Line10 = new LatLng(16.401355, 102.815494);
                map.addMarker(new MarkerOptions().position(latLngLandmark16Line10).title("เทสโก้ โลตัส ขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark16Line10));


                // pin land mark stop


                LatLng mapCenter13 = new LatLng(16.389369, 102.806185);
                map.addMarker(new MarkerOptions().position(mapCenter13).title("Start").snippet("สาย 10 : มหาวิทยาลัยขอนแก่น – สนามม้า").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                LatLng mapCenter14 = new LatLng(16.441628, 102.814526);
                map.addMarker(new MarkerOptions().position(mapCenter14).title("Stop").snippet("สาย 10 : มหาวิทยาลัยขอนแก่น – สนามม้า").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter13, 15));
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
                        .add(new LatLng(16.415181, 102.818984))
                        .add(new LatLng(16.415389, 102.819370))
                        .add(new LatLng(16.415531, 102.819673))
                        .add(new LatLng(16.415729, 102.820025))
                        .add(new LatLng(16.415880, 102.820411))
                        .add(new LatLng(16.415960, 102.820712))
                        .add(new LatLng(16.415970, 102.821004))
                        .add(new LatLng(16.415924, 102.821366))
                        .add(new LatLng(16.415798, 102.821860))
                        .add(new LatLng(16.415700, 102.822104))
                        .add(new LatLng(16.415620, 102.822364))
                        .add(new LatLng(16.415579, 102.822632))
                        .add(new LatLng(16.415046, 102.824491))
                        .add(new LatLng(16.414578, 102.826164))
                        .add(new LatLng(16.414385, 102.826963))
                        .add(new LatLng(16.413991, 102.828632))
                        .add(new LatLng(16.413863, 102.829047))
                        .add(new LatLng(16.413765, 102.829412))
                        .add(new LatLng(16.413595, 102.830166))
                        .add(new LatLng(16.413510, 102.830675))
                        .add(new LatLng(16.413472, 102.830919))
                        .add(new LatLng(16.413446, 102.831158))
                        .add(new LatLng(16.413440, 102.831370))
                        .add(new LatLng(16.413384, 102.832319))
                        .add(new LatLng(16.413371, 102.833081))
                        .add(new LatLng(16.413367, 102.833546))
                        .add(new LatLng(16.413380, 102.833911))
                        .add(new LatLng(16.414336, 102.834001))
                        .add(new LatLng(16.414704, 102.834041))
                        .add(new LatLng(16.415337, 102.834089))
                        .add(new LatLng(16.415718, 102.834128))
                        .add(new LatLng(16.415997, 102.834144))
                        .add(new LatLng(16.416774, 102.834231))
                        .add(new LatLng(16.417317, 102.834248))
                        .add(new LatLng(16.417904, 102.834296))
                        .add(new LatLng(16.418722, 102.834468))
                        .add(new LatLng(16.419322, 102.834537))
                        .add(new LatLng(16.420153, 102.834605))
                        .add(new LatLng(16.420436, 102.834634))
                        .add(new LatLng(16.420585, 102.834686))
                        .add(new LatLng(16.421336, 102.834781))
                        .add(new LatLng(16.421973, 102.834860))
                        .add(new LatLng(16.422526, 102.834863))
                        .add(new LatLng(16.423146, 102.834853))
                        .add(new LatLng(16.424269, 102.834981))
                        .add(new LatLng(16.424659, 102.835021))
                        .add(new LatLng(16.425546, 102.835081))
                        .add(new LatLng(16.426043, 102.835119))
                        .add(new LatLng(16.426488, 102.835144))
                        .add(new LatLng(16.426960, 102.835193))
                        .add(new LatLng(16.428204, 102.835442))
                        .add(new LatLng(16.428894, 102.835501))
                        .add(new LatLng(16.429589, 102.835592))
                        .add(new LatLng(16.430376, 102.835662))
                        .add(new LatLng(16.431009, 102.835746))
                        .add(new LatLng(16.431416, 102.835776))
                        .add(new LatLng(16.432526, 102.835926))
                        .add(new LatLng(16.433097, 102.835950))
                        .add(new LatLng(16.434028, 102.836092))
                        .add(new LatLng(16.433973, 102.836441))
                        .add(new LatLng(16.433912, 102.837208))
                        .add(new LatLng(16.433851, 102.837988))
                        .add(new LatLng(16.432194, 102.837822))
                        .add(new LatLng(16.431637, 102.837770))
                        .add(new LatLng(16.431205, 102.837715))
                        .add(new LatLng(16.430710, 102.837787))
                        .add(new LatLng(16.430101, 102.837701))
                        .add(new LatLng(16.430029, 102.838698))
                        .add(new LatLng(16.429918, 102.839321))
                        .add(new LatLng(16.429831, 102.840174))
                        .add(new LatLng(16.429488, 102.842028))
                        .add(new LatLng(16.429151, 102.844218))
                        .add(new LatLng(16.428802, 102.846814))
                        .add(new LatLng(16.428696, 102.847888))
                        .add(new LatLng(16.428717, 102.850742))
                        .add(new LatLng(16.428635, 102.853982))
                        .add(new LatLng(16.428739, 102.854318))
                        .add(new LatLng(16.429079, 102.854651))
                        .add(new LatLng(16.429614, 102.855065))
                        .add(new LatLng(16.430197, 102.855571))
                        .add(new LatLng(16.430545, 102.855820))
                        .add(new LatLng(16.430818, 102.856132))
                        .add(new LatLng(16.431108, 102.856352))
                        .add(new LatLng(16.431172, 102.856477))
                        .add(new LatLng(16.431442, 102.856802))
                        .add(new LatLng(16.431692, 102.857158))
                        .add(new LatLng(16.431869, 102.857424))
                        .add(new LatLng(16.432191, 102.857947))
                        .add(new LatLng(16.432644, 102.858728))
                        .add(new LatLng(16.432994, 102.859323))
                        .add(new LatLng(16.433210, 102.859814))
                        .add(new LatLng(16.433331, 102.859996))
                        .add(new LatLng(16.433426, 102.860122))
                        .add(new LatLng(16.433516, 102.860187))
                        .add(new LatLng(16.433796, 102.860192))
                        .add(new LatLng(16.433796, 102.860192))
                        .add(new LatLng(16.434280, 102.859862))
                        .add(new LatLng(16.434307, 102.859566))
                        .add(new LatLng(16.434321, 102.859346))
                        .add(new LatLng(16.434385, 102.858780))
                        .add(new LatLng(16.434462, 102.858319))
                        .add(new LatLng(16.434560, 102.857241))
                        .add(new LatLng(16.434611, 102.856973))
                        .add(new LatLng(16.434612, 102.856980))
                        .add(new LatLng(16.435083, 102.855112))
                        .add(new LatLng(16.435280, 102.854037))
                        .add(new LatLng(16.435531, 102.853018))
                        .add(new LatLng(16.435685, 102.852121))
                        .add(new LatLng(16.436040, 102.850511))
                        .add(new LatLng(16.436127, 102.849916))
                        .add(new LatLng(16.436276, 102.848924))
                        .add(new LatLng(16.436369, 102.848484))
                        .add(new LatLng(16.436635, 102.846890))
                        .add(new LatLng(16.437154, 102.843908))
                        .add(new LatLng(16.437761, 102.840241))
                        .add(new LatLng(16.437795, 102.839931))
                        .add(new LatLng(16.438001, 102.838563))
                        .add(new LatLng(16.438404, 102.836455))
                        .add(new LatLng(16.438710, 102.834736))
                        .add(new LatLng(16.438960, 102.833174))
                        .add(new LatLng(16.439022, 102.832513))
                        .add(new LatLng(16.439063, 102.832171))
                        .add(new LatLng(16.439265, 102.830764))
                        .add(new LatLng(16.439405, 102.829458))
                        .add(new LatLng(16.439512, 102.828740))
                        .add(new LatLng(16.439512, 102.828740))
                        .add(new LatLng(16.439781, 102.826719))
                        .add(new LatLng(16.440265, 102.823570))
                        .add(new LatLng(16.440646, 102.820941))
                        .add(new LatLng(16.440743, 102.820088))
                        .add(new LatLng(16.440913, 102.819134))
                        .add(new LatLng(16.441258, 102.817117))
                        .add(new LatLng(16.441392, 102.815894))
                        .add(new LatLng(16.441628, 102.814526))
                        .color(getResources().getColor(R.color.s10)));

                        //อีกเส้น
                    LatLng mapCenter13_2 = new LatLng(16.428768, 102.851612);
                    map.addMarker(new MarkerOptions().position(mapCenter13_2).title("Start").snippet("สาย 10 : มหาวิทยาลัยขอนแก่น – สนามม้า").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    LatLng mapCenter14_2 = new LatLng(16.435280, 102.854037);
                    map.addMarker(new MarkerOptions().position(mapCenter14_2).title("Stop").snippet("สาย 10 : มหาวิทยาลัยขอนแก่น – สนามม้า").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                    map.addPolyline(new PolylineOptions().geodesic(true)
                        .add(new LatLng(16.428768, 102.851612))
                        .add(new LatLng(16.429478, 102.851593))
                        .add(new LatLng(16.430206, 102.851606))
                        .add(new LatLng(16.430444, 102.851644))
                        .add(new LatLng(16.430753, 102.851778))
                        .add(new LatLng(16.430989, 102.851905))
                        .add(new LatLng(16.431383, 102.852119))
                        .add(new LatLng(16.431927, 102.852406))
                        .add(new LatLng(16.432343, 102.852623))
                        .add(new LatLng(16.432670, 102.852773))
                        .add(new LatLng(16.432789, 102.852838))
                        .add(new LatLng(16.433381, 102.853047))
                        .add(new LatLng(16.433502, 102.853122))
                        .add(new LatLng(16.433901, 102.853302))
                        .add(new LatLng(16.434500, 102.853624))
                        .add(new LatLng(16.434639, 102.853806))
                        .add(new LatLng(16.434966, 102.853927))
                        .add(new LatLng(16.435280, 102.854037))
                        .color(getResources().getColor(R.color.s10))
                );
                break;

            case "สาย 11 : บ้านโนนสวรรค์ – บ้านขามเจริญ\nบ.โนนสวรรค์, ตลาดหนองใหญ่, วิทยาลัยอาชีวศึกษาขอนแก่น, บขส.2, โรงเรียนขอนแก่นวิทยายน, ตึกคอมขอนแก่น, เทศบาลนครขอนแก่น, ตลาดต้นตาล, บ.โคกฟันโปง":

                // pin land mark start

//                LatLng latLngLandmark1Line11 = new LatLng(16.418274, 102.903125);
//                map.addMarker(new MarkerOptions().position(latLngLandmark1Line11).title("บ. โนนสวรรค์").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark1Line11));

                LatLng latLngLandmark2Line11 = new LatLng(16.427545, 102.868770);
                map.addMarker(new MarkerOptions().position(latLngLandmark2Line11).title("ตลาดหนองใหญ่").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark2Line11));

                LatLng latLngLandmark3Line11 = new LatLng(16.437037, 102.838568);
                map.addMarker(new MarkerOptions().position(latLngLandmark3Line11).title("วิทยาลัยอาชีวศึกษาขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark3Line11));

                LatLng latLngLandmark4Line11 = new LatLng(16.433174, 102.836077);
                map.addMarker(new MarkerOptions().position(latLngLandmark4Line11).title("บขส. 2").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark4Line11));

                LatLng latLngLandmark5Line11 = new LatLng(16.432384, 102.835668);
                map.addMarker(new MarkerOptions().position(latLngLandmark5Line11).title("โรงเรียนขอนแก่นวิทยายน").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark5Line11));

                LatLng latLngLandmark6Line11 = new LatLng(16.430799, 102.831360);
                map.addMarker(new MarkerOptions().position(latLngLandmark6Line11).title("ตึกคอม ขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark6Line11));

                LatLng latLngLandmark7Line11 = new LatLng(16.429826, 102.829212);
                map.addMarker(new MarkerOptions().position(latLngLandmark7Line11).title("เทศบาลนครขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark7Line11));

                LatLng latLngLandmark8Line11 = new LatLng(16.417918, 102.819266);
                map.addMarker(new MarkerOptions().position(latLngLandmark8Line11).title("ตลาดต้นตาล").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark8Line11));

//                LatLng latLngLandmark9Line11 = new LatLng();
//                map.addMarker(new MarkerOptions().position(latLngLandmark9Line11).title("บ. โคกฟันโปง").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark9Line11));

                // pin land mark stop


                LatLng mapCenter29 = new LatLng(16.409522, 102.781848);
                map.addMarker(new MarkerOptions().position(mapCenter29).title("Start").snippet("สาย 11 : บ้านโนนสวรรค์ – บ้านขามเจริญ").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
//                LatLng mapCenter30 = new LatLng(16.441628, 102.814526);
//                map.addMarker(new MarkerOptions().position(mapCenter30).title("Stop").snippet("สาย 11 : บ้านโนนสวรรค์ – บ้านขามเจริญ").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter29, 15));
                map.addPolyline(new PolylineOptions().geodesic(true)
                        .add(new LatLng(16.409522, 102.781848))
                        .add(new LatLng(16.406359, 102.784080))
                        .add(new LatLng(16.406098, 102.784713))
                        .add(new LatLng(16.406539, 102.787268))
                        .add(new LatLng(16.406945, 102.789760))
                        .add(new LatLng(16.407398, 102.792195))
                        .add(new LatLng(16.407892, 102.794071))
                        .add(new LatLng(16.408167, 102.795116))
                        .add(new LatLng(16.408908, 102.797283))
                        .add(new LatLng(16.409627, 102.799360))
                        .add(new LatLng(16.410025, 102.800632))
                        .add(new LatLng(16.410207, 102.801525))
                        .add(new LatLng(16.410351, 102.802481))
                        .add(new LatLng(16.410373, 102.802826))
                        .add(new LatLng(16.410399, 102.803919))
                        .add(new LatLng(16.410450, 102.805024))
                        .add(new LatLng(16.410469, 102.805748))
                        .add(new LatLng(16.410504, 102.806258))
                        .add(new LatLng(16.410586, 102.806930))
                        .add(new LatLng(16.410695, 102.807320))
                        .add(new LatLng(16.410872, 102.807840))
                        .add(new LatLng(16.410988, 102.808116))
                        .add(new LatLng(16.411315, 102.808789))
                        .add(new LatLng(16.411469, 102.809207))
                        .add(new LatLng(16.411469, 102.809207))
                        .add(new LatLng(16.411652, 102.809937))
                        .add(new LatLng(16.411665, 102.810294))
                        .add(new LatLng(16.411688, 102.810921))
                        .add(new LatLng(16.411714, 102.811425))
                        .add(new LatLng(16.411736, 102.811983))
                        .add(new LatLng(16.411776, 102.812970))
                        .add(new LatLng(16.411870, 102.813622))
                        .add(new LatLng(16.411967, 102.814005))
                        .add(new LatLng(16.412072, 102.814257))
                        .add(new LatLng(16.412203, 102.814506))
                        .add(new LatLng(16.412540, 102.815016))
                        .add(new LatLng(16.412712, 102.815177))
                        .add(new LatLng(16.413404, 102.815711))
                        .add(new LatLng(16.413916, 102.816121))
                        .add(new LatLng(16.414091, 102.816277))
                        .add(new LatLng(16.414240, 102.816502))
                        .add(new LatLng(16.414366, 102.816773))
                        .add(new LatLng(16.414471, 102.817106))
                        .add(new LatLng(16.414600, 102.817597))
                        .add(new LatLng(16.414679, 102.817830))
                        .add(new LatLng(16.414767, 102.818045))
                        .add(new LatLng(16.414978, 102.818495))
                        .add(new LatLng(16.415075, 102.818634))
                        .add(new LatLng(16.415773, 102.818819))
                        .add(new LatLng(16.416397, 102.819023))
                        .add(new LatLng(16.416929, 102.819240))
                        .add(new LatLng(16.417655, 102.819450))
                        .add(new LatLng(16.419283, 102.819941))
                        .add(new LatLng(16.420094, 102.820171))
                        .add(new LatLng(16.421408, 102.820547))
                        .add(new LatLng(16.421400, 102.820817))
                        .add(new LatLng(16.421295, 102.821338))
                        .add(new LatLng(16.421238, 102.822034))
                        .add(new LatLng(16.421168, 102.822602))
                        .add(new LatLng(16.421142, 102.823197))
                        .add(new LatLng(16.421116, 102.823612))
                        .add(new LatLng(16.421073, 102.823919))
                        .add(new LatLng(16.420957, 102.824168))
                        .add(new LatLng(16.421370, 102.824277))
                        .add(new LatLng(16.421921, 102.824430))
                        .add(new LatLng(16.422458, 102.824568))
                        .add(new LatLng(16.422920, 102.824739))
                        .add(new LatLng(16.423428, 102.824943))
                        .add(new LatLng(16.424205, 102.825187))
                        .add(new LatLng(16.425185, 102.825466))
                        .add(new LatLng(16.425673, 102.825621))
                        .add(new LatLng(16.426262, 102.825780))
                        .add(new LatLng(16.426451, 102.825875))
                        .add(new LatLng(16.426589, 102.825864))
                        .add(new LatLng(16.426928, 102.825962))
                        .add(new LatLng(16.426997, 102.826050))
                        .add(new LatLng(16.427175, 102.826069))
                        .add(new LatLng(16.428132, 102.826319))
                        .add(new LatLng(16.428681, 102.826514))
                        .add(new LatLng(16.428843, 102.826595))
                        .add(new LatLng(16.428946, 102.826688))
                        .add(new LatLng(16.429085, 102.826889))
                        .add(new LatLng(16.429412, 102.827294))
                        .add(new LatLng(16.429891, 102.827827))
                        .add(new LatLng(16.430414, 102.828382))
                        .add(new LatLng(16.430570, 102.828472))
                        .add(new LatLng(16.430903, 102.828250))
                        .add(new LatLng(16.431212, 102.828165))
                        .add(new LatLng(16.431377, 102.828277))
                        .add(new LatLng(16.431263, 102.829366))
                        .add(new LatLng(16.431104, 102.830182))
                        .add(new LatLng(16.431104, 102.830182))
                        .add(new LatLng(16.430839, 102.832182))
                        .add(new LatLng(16.430687, 102.833467))
                        .add(new LatLng(16.430591, 102.834048))
                        .add(new LatLng(16.430480, 102.834809))
                        .add(new LatLng(16.430370, 102.835661))
                        .add(new LatLng(16.431046, 102.835721))
                        .add(new LatLng(16.431476, 102.835766))
                        .add(new LatLng(16.432543, 102.835920))
                        .add(new LatLng(16.433100, 102.835939))
                        .add(new LatLng(16.434036, 102.836116))
                        .add(new LatLng(16.433962, 102.836423))
                        .add(new LatLng(16.433910, 102.837208))
                        .add(new LatLng(16.433840, 102.837986))
                        .add(new LatLng(16.434956, 102.838201))
                        .add(new LatLng(16.435393, 102.838243))
                        .add(new LatLng(16.436312, 102.838378))
                        .add(new LatLng(16.436905, 102.838458))
                        .add(new LatLng(16.437187, 102.838460))
                        .add(new LatLng(16.438001, 102.838563))
                        .add(new LatLng(16.437795, 102.839931))
                        .add(new LatLng(16.437761, 102.840241))
                        .add(new LatLng(16.437154, 102.843908))
                        .add(new LatLng(16.436635, 102.846890))
                        .add(new LatLng(16.436369, 102.848484))
                        .add(new LatLng(16.436276, 102.848924))
                        .add(new LatLng(16.436127, 102.849916))
                        .add(new LatLng(16.436040, 102.850511))
                        .add(new LatLng(16.435685, 102.852121))
                        .add(new LatLng(16.435531, 102.853018))
                        .add(new LatLng(16.435280, 102.854037))
                        .add(new LatLng(16.435083, 102.855112))
                        .add(new LatLng(16.434612, 102.856980))
                        .add(new LatLng(16.434611, 102.856973))
                        .add(new LatLng(16.434560, 102.857241))
                        .add(new LatLng(16.434462, 102.858319))
                        .add(new LatLng(16.434385, 102.858780))
                        .add(new LatLng(16.434321, 102.859346))
                        .add(new LatLng(16.434307, 102.859566))
                        .add(new LatLng(16.434280, 102.859862))
                        .add(new LatLng(16.434208, 102.860257))
                        .add(new LatLng(16.434122, 102.860982))
                        .add(new LatLng(16.434026, 102.861256))
                        .add(new LatLng(16.433524, 102.864211))
                        .add(new LatLng(16.433288, 102.865517))
                        .add(new LatLng(16.433196, 102.865960))
                        .add(new LatLng(16.433088, 102.866414))
                        .add(new LatLng(16.432688, 102.867472))
                        .add(new LatLng(16.432485, 102.867845))
                        .add(new LatLng(16.432145, 102.868376))
                        .add(new LatLng(16.431968, 102.868599))
                        .add(new LatLng(16.431489, 102.869076))
                        .add(new LatLng(16.430106, 102.870118))
                        .add(new LatLng(16.429658, 102.870381))
                        .add(new LatLng(16.429312, 102.870537))
                        .add(new LatLng(16.428953, 102.870645))
                        .add(new LatLng(16.428646, 102.870692))
                        .add(new LatLng(16.428270, 102.870728))
                        .add(new LatLng(16.427751, 102.870674))
                        .add(new LatLng(16.427275, 102.870638))
                        .add(new LatLng(16.426794, 102.874816))
                       .color(getResources().getColor(R.color.s10))
                );
                break;

            case "สาย 12 : พิพิธภัณฑ์ – รร.ท่าพระวิทยายน\nศาลากลางจังหวัดขอนแก่น, บขส.1, โรงเรียนขอนแก่นวิทยายน, ตลาดบางลำภู, ตลาดเทศบาล, โรงเรียนแก่นนครวิทยาลัย, ประตูน้ำขอนแก่น, เทสโก้โลตัสขอนแก่น, บขส.3, บ.โนนตุ่น, บ.กุดกว้าง, บ.ท่าพระ, บ.หนองบัวดีหมี":

                // pin land mark start

                LatLng latLngLandmark1Line12 = new LatLng(16.442479, 102.835975);
                map.addMarker(new MarkerOptions().position(latLngLandmark1Line12).title("ศาลากลางจังหวัดขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark1Line12));

                LatLng latLngLandmark2Line12 = new LatLng(16.439266, 102.833345);
                map.addMarker(new MarkerOptions().position(latLngLandmark2Line12).title("บขส. 1").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark2Line12));

                LatLng latLngLandmark3Line12 = new LatLng(16.432384, 102.835668);
                map.addMarker(new MarkerOptions().position(latLngLandmark3Line12).title("โรงเรียนขอนแก่นวิทยายน").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark3Line12));

                LatLng latLngLandmark4Line12 = new LatLng(16.428785, 102.835340);
                map.addMarker(new MarkerOptions().position(latLngLandmark4Line12).title("ตลาดบางลำพู").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark4Line12));

                LatLng latLngLandmark5Line12 = new LatLng(16.427475, 102.835103);
                map.addMarker(new MarkerOptions().position(latLngLandmark5Line12).title("ตลาดเทศบาล").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark5Line12));

                LatLng latLngLandmark6Line12 = new LatLng(16.415286, 102.824483);
                map.addMarker(new MarkerOptions().position(latLngLandmark6Line12).title("โรงเรียนแก่นนครวิทยาลัย").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark6Line12));

//                LatLng latLngLandmark7Line12 = new LatLng();
//                map.addMarker(new MarkerOptions().position(latLngLandmark7Line12).title("บ. โนนตุ่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark7Line12));

                LatLng latLngLandmark8Line12 = new LatLng(16.404327, 102.815374);
                map.addMarker(new MarkerOptions().position(latLngLandmark8Line12).title("ประตูน้ำขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark8Line12));

                LatLng latLngLandmark9Line12 = new LatLng(16.401355, 102.815494);
                map.addMarker(new MarkerOptions().position(latLngLandmark9Line12).title("เทสโก้ โลตัส ขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark9Line12));

                LatLng latLngLandmark10Line12 = new LatLng(16.389460, 102.805893);
                map.addMarker(new MarkerOptions().position(latLngLandmark10Line12).title("บขส. 3").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark10Line12));

//                LatLng latLngLandmark11Line12 = new LatLng();
//                map.addMarker(new MarkerOptions().position(latLngLandmark11Line12).title("บ. กุดกว้าง").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark11Line12));
//
//                LatLng latLngLandmark12Line12 = new LatLng();
//                map.addMarker(new MarkerOptions().position(latLngLandmark12Line12).title("บ. ท่าพระ").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark12Line12));
//
//                LatLng latLngLandmark13Line12 = new LatLng();
//                map.addMarker(new MarkerOptions().position(latLngLandmark13Line12).title("บ. หนองบัวดีหมี").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark13Line12));


                LatLng mapCenter15 = new LatLng(16.389369, 102.806185);
                map.addMarker(new MarkerOptions().position(mapCenter15).title("Start").snippet("สาย 12 : พิพิธภัณฑ์ – รร.ท่าพระวิทยายน").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                LatLng mapCenter16 = new LatLng(16.447767, 102.841116);
                map.addMarker(new MarkerOptions().position(mapCenter16).title("Stop").snippet("สาย 12 : พิพิธภัณฑ์ – รร.ท่าพระวิทยายน").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter15, 15));
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
                        .add(new LatLng(16.415181, 102.818984))
                        .add(new LatLng(16.415389, 102.819370))
                        .add(new LatLng(16.415531, 102.819673))
                        .add(new LatLng(16.415729, 102.820025))
                        .add(new LatLng(16.415880, 102.820411))
                        .add(new LatLng(16.415960, 102.820712))
                        .add(new LatLng(16.415970, 102.821004))
                        .add(new LatLng(16.415924, 102.821366))
                        .add(new LatLng(16.415798, 102.821860))
                        .add(new LatLng(16.415700, 102.822104))
                        .add(new LatLng(16.415620, 102.822364))
                        .add(new LatLng(16.415579, 102.822632))
                        .add(new LatLng(16.415046, 102.824491))
                        .add(new LatLng(16.414578, 102.826164))
                        .add(new LatLng(16.414385, 102.826963))
                        .add(new LatLng(16.413991, 102.828632))
                        .add(new LatLng(16.413863, 102.829047))
                        .add(new LatLng(16.413765, 102.829412))
                        .add(new LatLng(16.413595, 102.830166))
                        .add(new LatLng(16.413510, 102.830675))
                        .add(new LatLng(16.413472, 102.830919))
                        .add(new LatLng(16.413446, 102.831158))
                        .add(new LatLng(16.413440, 102.831370))
                        .add(new LatLng(16.413384, 102.832319))
                        .add(new LatLng(16.413376, 102.832315))
                        .add(new LatLng(16.415039, 102.832495))
                        .add(new LatLng(16.416283, 102.832542))
                        .add(new LatLng(16.416923, 102.832507))
                        .add(new LatLng(16.417241, 102.832518))
                        .add(new LatLng(16.417878, 102.832522))
                        .add(new LatLng(16.418997, 102.832620))
                        .add(new LatLng(16.419370, 102.832633))
                        .add(new LatLng(16.419504, 102.832652))
                        .add(new LatLng(16.419942, 102.832702))
                        .add(new LatLng(16.420275, 102.832760))
                        .add(new LatLng(16.420570, 102.832795))
                        .add(new LatLng(16.421151, 102.832874))
                        .add(new LatLng(16.421610, 102.832908))
                        .add(new LatLng(16.421938, 102.832959))
                        .add(new LatLng(16.422360, 102.832991))
                        .add(new LatLng(16.422607, 102.833130))
                        .add(new LatLng(16.423369, 102.833240))
                        .add(new LatLng(16.423976, 102.833221))
                        .add(new LatLng(16.424079, 102.833227))
                        .add(new LatLng(16.424696, 102.833299))
                        .add(new LatLng(16.425112, 102.833330))
                        .add(new LatLng(16.425380, 102.833422))
                        .add(new LatLng(16.425661, 102.833423))
                        .add(new LatLng(16.426202, 102.833470))
                        .add(new LatLng(16.426890, 102.833536))
                        .add(new LatLng(16.427799, 102.833629))
                        .add(new LatLng(16.428365, 102.833677))
                        .add(new LatLng(16.429107, 102.833788))
                        .add(new LatLng(16.429863, 102.833872))
                        .add(new LatLng(16.430620, 102.833935))
                        .add(new LatLng(16.431039, 102.833951))
                        .add(new LatLng(16.432594, 102.834130))
                        .add(new LatLng(16.433275, 102.834206))
                        .add(new LatLng(16.434210, 102.834304))
                        .add(new LatLng(16.434695, 102.834352))
                        .add(new LatLng(16.435657, 102.834449))
                        .add(new LatLng(16.436703, 102.834547))
                        .add(new LatLng(16.437597, 102.834645))
                        .add(new LatLng(16.438631, 102.834744))
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
                        .color(getResources().getColor(R.color.s12))
                );

                break;



            case "สาย 13 : บ้านน้อยนิเวศน์ – บ้านสว่างมรรคา\nบ้านน้อยนิเวศน์, บขส.1, ตลาด อ.จิระ ขอนแก่น, ตึกคอมขอนแก่น, โรงเรียนกัลยาณวัตรม, ตลาดเทศบาล, โรงเรียนเทศบาลสวนสนุก, บึงแก่นนคร, บ.ตูม, บ.ดอนบม, บ.ดอนแดง, บ้านดอนหัน":

                // pin land mark start

//                LatLng latLngLandmark1Line13 = new LatLng();
//                map.addMarker(new MarkerOptions().position(latLngLandmark1Line13).title("บ้านน้อยนิเวศน์").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark1Line13));

                LatLng latLngLandmark2Line13 = new LatLng(16.439266, 102.833345);
                map.addMarker(new MarkerOptions().position(latLngLandmark2Line13).title("บขส. 1").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark2Line13));

                LatLng latLngLandmark3Line13 = new LatLng(16.438914, 102.832317);
                map.addMarker(new MarkerOptions().position(latLngLandmark3Line13).title("ตลาด อ.จิระ ขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark3Line13));

                LatLng latLngLandmark4Line13 = new LatLng(16.430799, 102.831360);
                map.addMarker(new MarkerOptions().position(latLngLandmark4Line13).title("ตึกคอม ขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark4Line13));

                LatLng latLngLandmark5Line13 = new LatLng(16.427651, 102.835532);
                map.addMarker(new MarkerOptions().position(latLngLandmark5Line13).title("โรงเรียนกัลยาณวัตร").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark5Line13));

                LatLng latLngLandmark6Line13 = new LatLng(16.427475, 102.835103);
                map.addMarker(new MarkerOptions().position(latLngLandmark6Line13).title("ตลาดเทศบาล").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark6Line13));

                LatLng latLngLandmark7Line13 = new LatLng(16.420971, 102.834465);
                map.addMarker(new MarkerOptions().position(latLngLandmark7Line13).title("โรงเรียนเทศบาลสวนสนุก").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark7Line13));

                LatLng latLngLandmark8Line13 = new LatLng(16.413309, 102.835381);
                map.addMarker(new MarkerOptions().position(latLngLandmark8Line13).title("บึงแก่นนคร").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark8Line13));

//                LatLng latLngLandmark9Line13 = new LatLng();
//                map.addMarker(new MarkerOptions().position(latLngLandmark9Line13).title("บ. ตูม").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark9Line13));

                // pin land mark stop


                LatLng mapCenter31 = new LatLng(16.447973, 102.822856);
                map.addMarker(new MarkerOptions().position(mapCenter31).title("Start").snippet("สาย 13 : บ้านน้อยนิเวศน์ – บ้านสว่างมรรคา").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                LatLng mapCenter32 = new LatLng(16.390454, 102.841332);
                map.addMarker(new MarkerOptions().position(mapCenter32).title("Stop").snippet("สาย 13 : บ้านน้อยนิเวศน์ – บ้านสว่างมรรคา").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter31, 15));
                map.addPolyline(new PolylineOptions().geodesic(true)
                        .add(new LatLng(16.447973, 102.822856))
                        .add(new LatLng(16.447922, 102.823308))
                        .add(new LatLng(16.447631, 102.825455))
                        .add(new LatLng(16.447254, 102.825459))
                        .add(new LatLng(16.446138, 102.825405))
                        .add(new LatLng(16.445701, 102.825378))
                        .add(new LatLng(16.445121, 102.825343))
                        .add(new LatLng(16.444730, 102.825316))
                        .add(new LatLng(16.444364, 102.825268))
                        .add(new LatLng(16.443597, 102.825318))
                        .add(new LatLng(16.443466, 102.826611))
                        .add(new LatLng(16.443466, 102.826711))
                        .add(new LatLng(16.443405, 102.827110))
                        .add(new LatLng(16.443412, 102.827277))
                        .add(new LatLng(16.443285, 102.828206))
                        .add(new LatLng(16.443241, 102.828396))
                        .add(new LatLng(16.442943, 102.829434))
                        .add(new LatLng(16.441322, 102.828951))
                        .add(new LatLng(16.440751, 102.828769))
                        .add(new LatLng(16.440465, 102.828739))
                        .add(new LatLng(16.439692, 102.828491))
                        .add(new LatLng(16.439620, 102.828813))
                        .add(new LatLng(16.439464, 102.829950))
                        .add(new LatLng(16.439385, 102.830784))
                        .add(new LatLng(16.439195, 102.832164))
                        .add(new LatLng(16.439045, 102.833116))
                        .add(new LatLng(16.438925, 102.834030))
                        .add(new LatLng(16.438822, 102.834768))
                        .add(new LatLng(16.437615, 102.834654))
                        .add(new LatLng(16.436679, 102.834552))
                        .add(new LatLng(16.436722, 102.834099))
                        .add(new LatLng(16.436819, 102.833353))
                        .add(new LatLng(16.436960, 102.831854))
                        .add(new LatLng(16.437058, 102.830878))
                        .add(new LatLng(16.437156, 102.830259))
                        .add(new LatLng(16.436052, 102.829961))
                        .add(new LatLng(16.435785, 102.829897))
                        .add(new LatLng(16.435337, 102.829795))
                        .add(new LatLng(16.434468, 102.829532))
                        .add(new LatLng(16.432770, 102.829097))
                        .add(new LatLng(16.431782, 102.828819))
                        .add(new LatLng(16.431358, 102.828699))
                        .add(new LatLng(16.431258, 102.829385))
                        .add(new LatLng(16.431185, 102.829876))
                        .add(new LatLng(16.431062, 102.830412))
                        .add(new LatLng(16.430909, 102.831641))
                        .add(new LatLng(16.430771, 102.832684))
                        .add(new LatLng(16.430694, 102.833508))
                        .add(new LatLng(16.430607, 102.833936))
                        .add(new LatLng(16.430491, 102.834813))
                        .add(new LatLng(16.430386, 102.835647))
                        .add(new LatLng(16.429589, 102.835592))
                        .add(new LatLng(16.428894, 102.835501))
                        .add(new LatLng(16.428204, 102.835442))
                        .add(new LatLng(16.426960, 102.835193))
                        .add(new LatLng(16.426488, 102.835144))
                        .add(new LatLng(16.426043, 102.835119))
                        .add(new LatLng(16.425546, 102.835081))
                        .add(new LatLng(16.424659, 102.835021))
                        .add(new LatLng(16.424269, 102.834981))
                        .add(new LatLng(16.423146, 102.834853))
                        .add(new LatLng(16.422526, 102.834863))
                        .add(new LatLng(16.421973, 102.834860))
                        .add(new LatLng(16.421336, 102.834781))
                        .add(new LatLng(16.420585, 102.834686))
                        .add(new LatLng(16.420525, 102.834661))
                        .add(new LatLng(16.420497, 102.835845))
                        .add(new LatLng(16.420466, 102.836558))
                        .add(new LatLng(16.420425, 102.837055))
                        .add(new LatLng(16.420421, 102.837928))
                        .add(new LatLng(16.420404, 102.838213))
                        .add(new LatLng(16.420384, 102.838674))
                        .add(new LatLng(16.420347, 102.838913))
                        .add(new LatLng(16.420258, 102.839161))
                        .add(new LatLng(16.420142, 102.839377))
                        .add(new LatLng(16.420000, 102.839558))
                        .add(new LatLng(16.419665, 102.839836))
                        .add(new LatLng(16.418741, 102.840273))
                        .add(new LatLng(16.417900, 102.840651))
                        .add(new LatLng(16.417560, 102.840766))
                        .add(new LatLng(16.416781, 102.840965))
                        .add(new LatLng(16.416485, 102.841016))
                        .add(new LatLng(16.415806, 102.841059))
                        .add(new LatLng(16.415531, 102.841083))
                        .add(new LatLng(16.415124, 102.841183))
                        .add(new LatLng(16.414815, 102.841254))
                        .add(new LatLng(16.414349, 102.841343))
                        .add(new LatLng(16.413829, 102.841405))
                        .add(new LatLng(16.413647, 102.841419))
                        .add(new LatLng(16.413451, 102.841436))
                        .add(new LatLng(16.412929, 102.841519))
                        .add(new LatLng(16.412703, 102.841522))
                        .add(new LatLng(16.412452, 102.841491))
                        .add(new LatLng(16.412214, 102.841432))
                        .add(new LatLng(16.411218, 102.841056))
                        .add(new LatLng(16.410732, 102.840831))
                        .add(new LatLng(16.410526, 102.840753))
                        .add(new LatLng(16.409744, 102.840447))
                        .add(new LatLng(16.409228, 102.840288))
                        .add(new LatLng(16.409004, 102.840264))
                        .add(new LatLng(16.408783, 102.840259))
                        .add(new LatLng(16.408288, 102.840093))
                        .add(new LatLng(16.407621, 102.839888))
                        .add(new LatLng(16.406991, 102.839681))
                        .add(new LatLng(16.406092, 102.839392))
                        .add(new LatLng(16.406101, 102.839402))
                        .add(new LatLng(16.406077, 102.839228))
                        .add(new LatLng(16.406097, 102.839131))
                        .add(new LatLng(16.406532, 102.837583))
                        .add(new LatLng(16.406699, 102.836953))
                        .add(new LatLng(16.406848, 102.836545))
                        .add(new LatLng(16.406926, 102.836406))
                        .add(new LatLng(16.407039, 102.836298))
                        .add(new LatLng(16.407502, 102.836081))
                        .add(new LatLng(16.408196, 102.835830))
                        .add(new LatLng(16.408460, 102.835729))
                        .add(new LatLng(16.408987, 102.835552))
                        .add(new LatLng(16.409345, 102.835463))
                        .add(new LatLng(16.410184, 102.835173))
                        .add(new LatLng(16.410520, 102.835108))
                        .add(new LatLng(16.410642, 102.835091))
                        .add(new LatLng(16.410992, 102.835083))
                        .add(new LatLng(16.411533, 102.835070))
                        .add(new LatLng(16.411870, 102.835065))
                        .add(new LatLng(16.412115, 102.835058))
                        .add(new LatLng(16.412336, 102.835062))
                        .add(new LatLng(16.412621, 102.835099))
                        .add(new LatLng(16.412992, 102.835159))
                        .add(new LatLng(16.413337, 102.835197))
                        .add(new LatLng(16.414051, 102.835297))
                        .add(new LatLng(16.414334, 102.835317))
                        .add(new LatLng(16.414461, 102.835313))
                        .add(new LatLng(16.414665, 102.835293))
                        .add(new LatLng(16.414830, 102.835265))
                        .add(new LatLng(16.415187, 102.835205))
                        .add(new LatLng(16.415293, 102.835177))
                        .add(new LatLng(16.415816, 102.835037))
                        .add(new LatLng(16.416345, 102.834874))
                        .add(new LatLng(16.416480, 102.834836))
                        .add(new LatLng(16.416640, 102.834814))
                        .add(new LatLng(16.416793, 102.834816))
                        .add(new LatLng(16.417319, 102.834899))
                        .add(new LatLng(16.417514, 102.834954))
                        .add(new LatLng(16.417725, 102.835037))
                        .add(new LatLng(16.417850, 102.835099))
                        .add(new LatLng(16.418063, 102.835247))
                        .add(new LatLng(16.418405, 102.835620))
                        .add(new LatLng(16.418507, 102.835715))
                        .add(new LatLng(16.418656, 102.835861))
                        .add(new LatLng(16.418837, 102.836064))
                        .add(new LatLng(16.419248, 102.836580))
                        .add(new LatLng(16.419475, 102.836995))
                        .add(new LatLng(16.419503, 102.837190))
                        .add(new LatLng(16.419524, 102.837280))
                        .add(new LatLng(16.419593, 102.837377))
                        .add(new LatLng(16.420421, 102.837928))
                        .add(new LatLng(16.420404, 102.838213))
                        .add(new LatLng(16.420384, 102.838674))
                        .add(new LatLng(16.420347, 102.838913))
                        .add(new LatLng(16.420258, 102.839161))
                        .add(new LatLng(16.420142, 102.839377))
                        .add(new LatLng(16.420000, 102.839558))
                        .add(new LatLng(16.419665, 102.839836))
                        .add(new LatLng(16.418741, 102.840273))
                        .add(new LatLng(16.417900, 102.840651))
                        .add(new LatLng(16.417560, 102.840766))
                        .add(new LatLng(16.416781, 102.840965))
                        .add(new LatLng(16.416485, 102.841016))
                        .add(new LatLng(16.415806, 102.841059))
                        .add(new LatLng(16.415531, 102.841083))
                        .add(new LatLng(16.415124, 102.841183))
                        .add(new LatLng(16.414815, 102.841254))
                        .add(new LatLng(16.414349, 102.841343))
                        .add(new LatLng(16.413829, 102.841405))
                        .add(new LatLng(16.413647, 102.841419))
                        .add(new LatLng(16.413451, 102.841436))
                        .add(new LatLng(16.412929, 102.841519))
                        .add(new LatLng(16.412703, 102.841522))
                        .add(new LatLng(16.412452, 102.841491))
                        .add(new LatLng(16.412214, 102.841432))
                        .add(new LatLng(16.411218, 102.841056))
                        .add(new LatLng(16.410732, 102.840831))
                        .add(new LatLng(16.410526, 102.840753))
                        .add(new LatLng(16.409744, 102.840447))
                        .add(new LatLng(16.409228, 102.840288))
                        .add(new LatLng(16.409004, 102.840264))
                        .add(new LatLng(16.408783, 102.840259))
                        .add(new LatLng(16.408288, 102.840093))
                        .add(new LatLng(16.407621, 102.839888))
                        .add(new LatLng(16.406991, 102.839681))
                        .add(new LatLng(16.406092, 102.839392))
                        .add(new LatLng(16.405221, 102.839096))
                        .add(new LatLng(16.404917, 102.839010))
                        .add(new LatLng(16.404661, 102.838959))
                        .add(new LatLng(16.403910, 102.838749))
                        .add(new LatLng(16.403015, 102.838468))
                        .add(new LatLng(16.402145, 102.838200))
                        .add(new LatLng(16.401229, 102.837921))
                        .add(new LatLng(16.400221, 102.837567))
                        .add(new LatLng(16.399862, 102.837766))
                        .add(new LatLng(16.399272, 102.837990))
                        .add(new LatLng(16.398866, 102.838196))
                        .add(new LatLng(16.397964, 102.838547))
                        .add(new LatLng(16.397275, 102.838848))
                        .add(new LatLng(16.396997, 102.838971))
                        .add(new LatLng(16.396678, 102.839100))
                        .add(new LatLng(16.396343, 102.839228))
                        .add(new LatLng(16.395796, 102.839437))
                        .add(new LatLng(16.395255, 102.839636))
                        .add(new LatLng(16.394278, 102.839979))
                        .add(new LatLng(16.393830, 102.840129))
                        .add(new LatLng(16.393058, 102.840377))
                        .add(new LatLng(16.392492, 102.840570))
                        .add(new LatLng(16.391916, 102.840742))
                        .add(new LatLng(16.391473, 102.840913))
                        .add(new LatLng(16.391200, 102.841031))
                        .add(new LatLng(16.390948, 102.841160))
                        .add(new LatLng(16.390701, 102.841214))
                        .add(new LatLng(16.390454, 102.841332))
                        .color(getResources().getColor(R.color.s10)));
                break;

            case "สาย 16 : บ้านโนนทัน – วัดป่าอดุลยาราม\nบ.โนนทัน, ตลาดโนนทัน, โรงพยาบาลจิตเวชขอนแก่น, เรือนจำขอนแก่น, โรงเรียนกัลยาณวัตร, บขส.1, บ.สามเหลี่ยม":

                // pin land mark start

//                LatLng latLngLandmark1Line16 = new LatLng(16.420134, 102.849856);
//                map.addMarker(new MarkerOptions().position(latLngLandmark1Line16).title("บ. โนนทัน").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark1Line16));

                LatLng latLngLandmark2Line16 = new LatLng(16.420134, 102.849856);
                map.addMarker(new MarkerOptions().position(latLngLandmark2Line16).title("ตลาดโนนทัน").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark2Line16));

                LatLng latLngLandmark3Line16 = new LatLng(16.425506, 102.848512);
                map.addMarker(new MarkerOptions().position(latLngLandmark3Line16).title("โรงพยาบาลจิตเวชขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark3Line16));

                LatLng latLngLandmark4Line16 = new LatLng(16.429288, 102.845191);
                map.addMarker(new MarkerOptions().position(latLngLandmark4Line16).title("เรือนจำขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark4Line16));

                LatLng latLngLandmark5Line16 = new LatLng(16.427651, 102.835532);
                map.addMarker(new MarkerOptions().position(latLngLandmark5Line16).title("โรงเรียนกัลยาณวัตร").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark5Line16));

                LatLng latLngLandmark6Line16 = new LatLng(16.439266, 102.833345);
                map.addMarker(new MarkerOptions().position(latLngLandmark6Line16).title("บขส. 1").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark6Line16));

//                LatLng latLngLandmark7Line16 = new LatLng(16.440316, 102.825347);
//                map.addMarker(new MarkerOptions().position(latLngLandmark7Line16).title("บ. สามเหลี่ยม").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark7Line16));


                // pin land mark stop


                LatLng mapCenter33 = new LatLng(16.464537, 102.827373);
                map.addMarker(new MarkerOptions().position(mapCenter33).title("Start").snippet("สาย 16 : บ้านโนนทัน – วัดป่าอดุลยาราม").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                LatLng mapCenter34 = new LatLng(16.423453, 102.852517);
                map.addMarker(new MarkerOptions().position(mapCenter34).title("Stop").snippet("สาย 16 : บ้านโนนทัน – วัดป่าอดุลยาราม").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter33, 15));
                map.addPolyline(new PolylineOptions().geodesic(true)
                        .add(new LatLng(16.464537, 102.827373))
                        .add(new LatLng(16.463022, 102.827638))
                        .add(new LatLng(16.462532, 102.827690))
                        .add(new LatLng(16.462269, 102.827729))
                        .add(new LatLng(16.461924, 102.827767))
                        .add(new LatLng(16.460325, 102.828027))
                        .add(new LatLng(16.459610, 102.828140))
                        .add(new LatLng(16.458402, 102.828028))
                        .add(new LatLng(16.458150, 102.828061))
                        .add(new LatLng(16.457938, 102.828111))
                        .add(new LatLng(16.457614, 102.828219))
                        .add(new LatLng(16.457228, 102.828286))
                        .add(new LatLng(16.457028, 102.828377))
                        .add(new LatLng(16.456903, 102.828458))
                        .add(new LatLng(16.456650, 102.828671))
                        .add(new LatLng(16.456544, 102.828797))
                        .add(new LatLng(16.455938, 102.829585))
                        .add(new LatLng(16.455701, 102.829966))
                        .add(new LatLng(16.455459, 102.830329))
                        .add(new LatLng(16.455150, 102.830715))
                        .add(new LatLng(16.455010, 102.830916))
                        .add(new LatLng(16.454861, 102.831301))
                        .add(new LatLng(16.454820, 102.831623))
                        .add(new LatLng(16.453503, 102.831537))
                        .add(new LatLng(16.452885, 102.831548))
                        .add(new LatLng(16.449840, 102.831333))
                        .add(new LatLng(16.449377, 102.831280))
                        .add(new LatLng(16.448461, 102.831269))
                        .add(new LatLng(16.447988, 102.831172))
                        .add(new LatLng(16.447831, 102.832055))
                        .add(new LatLng(16.447131, 102.831909))
                        .add(new LatLng(16.446205, 102.831630))
                        .add(new LatLng(16.445397, 102.831373))
                        .add(new LatLng(16.444728, 102.831185))
                        .add(new LatLng(16.444533, 102.831142))
                        .add(new LatLng(16.444183, 102.831094))
                        .add(new LatLng(16.443566, 102.831035))
                        .add(new LatLng(16.442673, 102.831010))
                        .add(new LatLng(16.440862, 102.830911))
                        .add(new LatLng(16.440745, 102.831837))
                        .add(new LatLng(16.440636, 102.832937))
                        .add(new LatLng(16.440541, 102.833741))
                        .add(new LatLng(16.440418, 102.834917))
                        .add(new LatLng(16.439641, 102.834845))
                        .add(new LatLng(16.438823, 102.834764))
                        .add(new LatLng(16.438370, 102.834726))
                        .add(new LatLng(16.437581, 102.834630))
                        .add(new LatLng(16.436687, 102.834530))
                        .add(new LatLng(16.435384, 102.834426))
                        .add(new LatLng(16.434210, 102.834304))
                        .add(new LatLng(16.434108, 102.835231))
                        .add(new LatLng(16.434030, 102.836083))
                        .add(new LatLng(16.433094, 102.835961))
                        .add(new LatLng(16.432551, 102.835919))
                        .add(new LatLng(16.431404, 102.835766))
                        .add(new LatLng(16.431033, 102.835740))
                        .add(new LatLng(16.430392, 102.835654))
                        .add(new LatLng(16.429580, 102.835602))
                        .add(new LatLng(16.428894, 102.835490))
                        .add(new LatLng(16.428201, 102.835444))
                        .add(new LatLng(16.426935, 102.835195))
                        .add(new LatLng(16.426500, 102.835155))
                        .add(new LatLng(16.426084, 102.836749))
                        .add(new LatLng(16.426231, 102.836768))
                        .add(new LatLng(16.426959, 102.837017))
                        .add(new LatLng(16.427748, 102.837323))
                        .add(new LatLng(16.427486, 102.838344))
                        .add(new LatLng(16.427352, 102.838956))
                        .add(new LatLng(16.427010, 102.840437))
                        .add(new LatLng(16.426545, 102.840208))
                        .add(new LatLng(16.426286, 102.840028))
                        .add(new LatLng(16.426010, 102.839830))
                        .add(new LatLng(16.425647, 102.839591))
                        .add(new LatLng(16.425535, 102.839515))
                        .add(new LatLng(16.425336, 102.840172))
                        .add(new LatLng(16.425076, 102.840989))
                        .add(new LatLng(16.424843, 102.841795))
                        .add(new LatLng(16.424605, 102.842688))
                        .add(new LatLng(16.424396, 102.843482))
                        .add(new LatLng(16.425048, 102.843562))
                        .add(new LatLng(16.425446, 102.843603))
                        .add(new LatLng(16.426225, 102.843711))
                        .add(new LatLng(16.427033, 102.843799))
                        .add(new LatLng(16.428101, 102.843924))
                        .add(new LatLng(16.428573, 102.843995))
                        .add(new LatLng(16.428882, 102.844028))
                        .add(new LatLng(16.429172, 102.844073))
                        .add(new LatLng(16.429020, 102.845283))
                        .add(new LatLng(16.428796, 102.847005))
                        .add(new LatLng(16.428754, 102.848082))
                        .add(new LatLng(16.428764, 102.849040))
                        .add(new LatLng(16.428754, 102.850402))
                        .add(new LatLng(16.428643, 102.851625))
                        .add(new LatLng(16.428315, 102.851584))
                        .add(new LatLng(16.427885, 102.851490))
                        .add(new LatLng(16.427561, 102.851345))
                        .add(new LatLng(16.427021, 102.851214))
                        .add(new LatLng(16.426290, 102.851107))
                        .add(new LatLng(16.425808, 102.851018))
                        .add(new LatLng(16.425141, 102.850798))
                        .add(new LatLng(16.424671, 102.850670))
                        .add(new LatLng(16.423438, 102.850271))
                        .add(new LatLng(16.423395, 102.850795))
                        .add(new LatLng(16.423373, 102.851682))
                        .add(new LatLng(16.423409, 102.852213))
                        .add(new LatLng(16.423453, 102.852517))

                        .color(getResources().getColor(R.color.s10)));
                break;

            case "สาย 17 : บ้านโนนทัน – บ้านโคกท่า\nบ.โนนทัน, บึงแก่นนคร, โรงเรียนเทศบาลสวนสนุก, แฟรี่พลาซ่า, ตลาดเทศบาล, โรงเรียนกัลยาณวัตร, วิทยาลัยอาชีวศึกษาขอนแก่น, ตลาดบ้านดอน, ค่ายศรีพัชรินทร์, โรงเรียนขามแก่นนคร, บ.โกทา, บ.หนองหิน, บ.ห้วยชัน, บ.โคกท่า":

                // pin land mark start

//                LatLng latLngLandmark1Line17 = new LatLng();
//                map.addMarker(new MarkerOptions().position(latLngLandmark1Line17).title("บ. โนนทัน").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark1Line17));

                LatLng latLngLandmark2Line17 = new LatLng(16.413309, 102.835381);
                map.addMarker(new MarkerOptions().position(latLngLandmark2Line17).title("บึงแก่นนคร").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark2Line17));

                LatLng latLngLandmark3Line17 = new LatLng(16.420971, 102.834465);
                map.addMarker(new MarkerOptions().position(latLngLandmark3Line17).title("โรงเรียนเทศบาลสวนสนุก").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark3Line17));

                LatLng latLngLandmark4Line17 = new LatLng(16.423924, 102.833135);
                map.addMarker(new MarkerOptions().position(latLngLandmark4Line17).title("แฟรี่ พลาซ่า").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark4Line17));

                LatLng latLngLandmark5Line17 = new LatLng(16.427475, 102.835103);
                map.addMarker(new MarkerOptions().position(latLngLandmark5Line17).title("ตลาดเทศบาล").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark5Line17));

                LatLng latLngLandmark6Line17 = new LatLng(16.427651, 102.835532);
                map.addMarker(new MarkerOptions().position(latLngLandmark6Line17).title("โรงเรียนกัลยาณวัตร").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark6Line17));

                LatLng latLngLandmark7Line17 = new LatLng(16.437037, 102.838568);
                map.addMarker(new MarkerOptions().position(latLngLandmark7Line17).title("วิทยาลัยอาชีวศึกษาขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark7Line17));

                LatLng latLngLandmark8Line17 = new LatLng(16.454248, 102.842549);
                map.addMarker(new MarkerOptions().position(latLngLandmark8Line17).title("ตลาดบ้านดอน").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark8Line17));

                LatLng latLngLandmark9Line17 = new LatLng(16.460548, 102.845768);
                map.addMarker(new MarkerOptions().position(latLngLandmark9Line17).title("ค่ายศรีพัชรินทร์").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark9Line17));

                LatLng latLngLandmark10Line17 = new LatLng(16.469897, 102.854263);
                map.addMarker(new MarkerOptions().position(latLngLandmark10Line17).title("โรงเรียนขามแก่นนคร").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark10Line17));

                LatLng latLngLandmark11Line17 = new LatLng(16.479254, 102.867225);
                map.addMarker(new MarkerOptions().position(latLngLandmark11Line17).title("บ. โกทา").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark11Line17));

//                LatLng latLngLandmark12Line17 = new LatLng();
//                map.addMarker(new MarkerOptions().position(latLngLandmark12Line17).title("บ. หนองหิน").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark12Line17));
//
//                LatLng latLngLandmark13Line17 = new LatLng();
//                map.addMarker(new MarkerOptions().position(latLngLandmark13Line17).title("บ. ห้วยชัน").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark13Line17));
//
//                LatLng latLngLandmark1Line1 = new LatLng();
//                map.addMarker(new MarkerOptions().position(latLngLandmark1Line1).title("บ. โคกท่า").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark1Line1));

                // pin land mark stop


                LatLng mapCenter35 = new LatLng(16.389369, 102.806185);
                map.addMarker(new MarkerOptions().position(mapCenter35).title("Start").snippet("สาย 17 : บ้านโนนทัน – บ้านโคกท่า").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                LatLng mapCenter36 = new LatLng(16.480840, 102.872316);
                map.addMarker(new MarkerOptions().position(mapCenter36).title("Stop").snippet("สาย 17 : บ้านโนนทัน – บ้านโคกท่า").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter35, 15));
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
                        .add(new LatLng(16.415181, 102.818984))
                        .add(new LatLng(16.415389, 102.819370))
                        .add(new LatLng(16.415531, 102.819673))
                        .add(new LatLng(16.415729, 102.820025))
                        .add(new LatLng(16.415880, 102.820411))
                        .add(new LatLng(16.415960, 102.820712))
                        .add(new LatLng(16.415970, 102.821004))
                        .add(new LatLng(16.415924, 102.821366))
                        .add(new LatLng(16.415798, 102.821860))
                        .add(new LatLng(16.415700, 102.822104))
                        .add(new LatLng(16.415620, 102.822364))
                        .add(new LatLng(16.415579, 102.822632))//
                        .add(new LatLng(16.416862, 102.822997))//เปลี่ยนเส้นทาง
                        .add(new LatLng(16.417361, 102.823141))
                        .add(new LatLng(16.418254, 102.823373))
                        .add(new LatLng(16.419129, 102.823648))
                        .add(new LatLng(16.419777, 102.823820))
                        .add(new LatLng(16.420313, 102.823986))
                        .add(new LatLng(16.420954, 102.824171))
                        .add(new LatLng(16.421369, 102.824279))
                        .add(new LatLng(16.421927, 102.824432))
                        .add(new LatLng(16.422470, 102.824575))
                        .add(new LatLng(16.422897, 102.824747))
                        .add(new LatLng(16.423437, 102.824946))
                        .add(new LatLng(16.424219, 102.825176))
                        .add(new LatLng(16.425181, 102.825476))
                        .add(new LatLng(16.425680, 102.825621))
                        .add(new LatLng(16.426248, 102.825779))
                        .add(new LatLng(16.426449, 102.825862))
                        .add(new LatLng(16.426570, 102.825864))
                        .add(new LatLng(16.426933, 102.825974))
                        .add(new LatLng(16.426989, 102.826055))
                        .add(new LatLng(16.426904, 102.826218))
                        .add(new LatLng(16.426753, 102.826269))
                        .add(new LatLng(16.426639, 102.826256))
                        .add(new LatLng(16.426472, 102.826867))
                        .add(new LatLng(16.426407, 102.827070))
                        .add(new LatLng(16.426410, 102.827144))
                        .add(new LatLng(16.426281, 102.827485))
                        .add(new LatLng(16.426181, 102.828182))
                        .add(new LatLng(16.426072, 102.829089))
                        .add(new LatLng(16.426021, 102.829508))
                        .add(new LatLng(16.425988, 102.829941))
                        .add(new LatLng(16.425931, 102.830569))
                        .add(new LatLng(16.425898, 102.831132))
                        .add(new LatLng(16.425784, 102.831692))
                        .add(new LatLng(16.425759, 102.832280))//เปลี่ยนเส้นทาง
                        .add(new LatLng(16.425661, 102.833423))//
                        .add(new LatLng(16.426220, 102.833480))
                        .add(new LatLng(16.426777, 102.833524))
                        .add(new LatLng(16.426507, 102.835138))
                        .add(new LatLng(16.426507, 102.835138))
                        .add(new LatLng(16.428228, 102.835451))
                        .add(new LatLng(16.427757, 102.837295))
                        .add(new LatLng(16.428091, 102.837425))
                        .add(new LatLng(16.428377, 102.837478))
                        .add(new LatLng(16.428561, 102.837507))
                        .add(new LatLng(16.428873, 102.837587))
                        .add(new LatLng(16.429561, 102.837668))
                        .add(new LatLng(16.429684, 102.837649))
                        .add(new LatLng(16.429905, 102.837684))
                        .add(new LatLng(16.430121, 102.837695))
                        .add(new LatLng(16.430428, 102.837757))
                        .add(new LatLng(16.430735, 102.837778))
                        .add(new LatLng(16.431221, 102.837711))
                        .add(new LatLng(16.431627, 102.837773))
                        .add(new LatLng(16.432191, 102.837816))
                        .add(new LatLng(16.432959, 102.837912))
                        .add(new LatLng(16.433837, 102.838004))
                        .add(new LatLng(16.434960, 102.838214))
                        .add(new LatLng(16.435382, 102.838227))
                        .add(new LatLng(16.436303, 102.838371))
                        .add(new LatLng(16.436896, 102.838457))
                        .add(new LatLng(16.437184, 102.838462))
                        .add(new LatLng(16.438014, 102.838559))
                        .add(new LatLng(16.438417, 102.836441))
                        .add(new LatLng(16.438716, 102.834743))
                        .add(new LatLng(16.439025, 102.834794))
                        .add(new LatLng(16.439328, 102.834800))
                        .add(new LatLng(16.439328, 102.834800))
                        .add(new LatLng(16.440442, 102.834931))
                        .add(new LatLng(16.440230, 102.836644))
                        .add(new LatLng(16.440106, 102.837736))
                        .add(new LatLng(16.440033, 102.838677))
                        .add(new LatLng(16.441361, 102.838824))
                        .add(new LatLng(16.442762, 102.838965))
                        .add(new LatLng(16.442673, 102.839620))
                        .add(new LatLng(16.442627, 102.840004))
                        .add(new LatLng(16.442614, 102.840336))
                        .add(new LatLng(16.443368, 102.840419))
                        .add(new LatLng(16.444011, 102.840548))
                        .add(new LatLng(16.444535, 102.840553))
                        .add(new LatLng(16.445492, 102.840666))
                        .add(new LatLng(16.446053, 102.840832))
                        .add(new LatLng(16.446969, 102.840982))
                        .add(new LatLng(16.445472, 102.840676))
                        .add(new LatLng(16.446025, 102.840822))
                        .add(new LatLng(16.447299, 102.841046))
                        .add(new LatLng(16.447760, 102.841130))
                        .add(new LatLng(16.447992, 102.841205))
                        .add(new LatLng(16.448265, 102.841248))
                        .add(new LatLng(16.448532, 102.841326))
                        .add(new LatLng(16.449072, 102.841474))
                        .add(new LatLng(16.450194, 102.841902))
                        .add(new LatLng(16.450579, 102.841991))
                        .add(new LatLng(16.451073, 102.842077))
                        .add(new LatLng(16.451622, 102.842144))
                        .add(new LatLng(16.452396, 102.842152))
                        .add(new LatLng(16.452967, 102.842210))
                        .add(new LatLng(16.453280, 102.842243))
                        .add(new LatLng(16.454314, 102.842445))
                        .add(new LatLng(16.454619, 102.842508))
                        .add(new LatLng(16.455104, 102.842651))
                        .add(new LatLng(16.456066, 102.843145))
                        .add(new LatLng(16.456223, 102.843387))
                        .add(new LatLng(16.457513, 102.844070))
                        .add(new LatLng(16.458096, 102.844240))
                        .add(new LatLng(16.459278, 102.844889))
                        .add(new LatLng(16.459901, 102.845265))
                        .add(new LatLng(16.461458, 102.846077))
                        .add(new LatLng(16.463444, 102.847159))
                        .add(new LatLng(16.465267, 102.848140))
                        .add(new LatLng(16.466358, 102.848701))
                        .add(new LatLng(16.466904, 102.849042))
                        .add(new LatLng(16.468631, 102.852229))
                        .add(new LatLng(16.470465, 102.855531))
                        .add(new LatLng(16.470871, 102.856280))
                        .add(new LatLng(16.471442, 102.857137))
                        .add(new LatLng(16.471840, 102.857724))
                        .add(new LatLng(16.472132, 102.858036))
                        .add(new LatLng(16.472521, 102.858373))
                        .add(new LatLng(16.474306, 102.859796))
                        .add(new LatLng(16.474621, 102.860190))
                        .add(new LatLng(16.475272, 102.861096))
                        .add(new LatLng(16.475913, 102.862025))
                        .add(new LatLng(16.476714, 102.863141))
                        .add(new LatLng(16.477509, 102.864257))
                        .add(new LatLng(16.478733, 102.866010))
                        .add(new LatLng(16.479414, 102.867270))
                        .add(new LatLng(16.479633, 102.867707))
                        .add(new LatLng(16.479837, 102.868575))
                        .add(new LatLng(16.480005, 102.869216))
                        .add(new LatLng(16.480390, 102.870644))
                        .add(new LatLng(16.480840, 102.872316))

                        .color(getResources().getColor(R.color.s10)));
                break;

            case "สาย 18 : โรงเรียนกัลยาณวัตร – บ้านโนนพอง\nโรงเรียนกัลยาณวัตร, เรือนจำขอนแก่น, วิทยาลัยเทคนิคขอนแก่น, โรงพยาบาลศูนย์ขอนแก่น, มหาวิทยาลัยเทคโนโลยีราชมงคลอีสาน, ตลาดหนองใหญ่, บ.แอ่วมอง, บ.สงเปือย, บ.โนนพอง":

                // pin land mark start

                LatLng latLngLandmark1Line18 = new LatLng(16.427651, 102.835532);
                map.addMarker(new MarkerOptions().position(latLngLandmark1Line18).title("โรงเรียนกัลยาณวัตร").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark1Line18));

                LatLng latLngLandmark2Line18 = new LatLng(16.429288, 102.845191);
                map.addMarker(new MarkerOptions().position(latLngLandmark2Line18).title("เรือนจำขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark2Line18));

                LatLng latLngLandmark3Line18 = new LatLng(16.428625, 102.847469);
                map.addMarker(new MarkerOptions().position(latLngLandmark3Line18).title("วิทยาลัยเทคนิคขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark3Line18));

                LatLng latLngLandmark4Line18 = new LatLng(16.428952, 102.849130);
                map.addMarker(new MarkerOptions().position(latLngLandmark4Line18).title("โรงพยาบาลศูนย์ขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_hospital)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark4Line18));

                LatLng latLngLandmark5Line18 = new LatLng(16.428111, 102.863237);
                map.addMarker(new MarkerOptions().position(latLngLandmark5Line18).title("มหาวิทยาลัยเทคโนโลยีราชมงคลอีสาน").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark5Line18));

                LatLng latLngLandmark6Line18 = new LatLng(16.427545, 102.868770);
                map.addMarker(new MarkerOptions().position(latLngLandmark6Line18).title("ตลาดหนองใหญ่").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark6Line18));

//                LatLng latLngLandmark7Line18 = new LatLng();
//                map.addMarker(new MarkerOptions().position(latLngLandmark7Line18).title("บ. แอ่วมอง").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark7Line18));
//
//                LatLng latLngLandmark8Line18 = new LatLng();
//                map.addMarker(new MarkerOptions().position(latLngLandmark8Line18).title("บ. สงเปือย").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark8Line18));
//
//                LatLng latLngLandmark8Line18 = new LatLng();
//                map.addMarker(new MarkerOptions().position(latLngLandmark8Line18).title("บ. โนนพอง").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark8Line18));

                // pin land mark stop

                LatLng mapCenter17 = new LatLng(16.426794, 102.874816);
                map.addMarker(new MarkerOptions().position(mapCenter17).title("Start").snippet("สาย 18 : โรงเรียนกัลยาณวัตร – บ้านโนนพอง").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                LatLng mapCenter18 = new LatLng(16.426483, 102.835136);
                map.addMarker(new MarkerOptions().position(mapCenter18).title("Stop").snippet("สาย 18 : โรงเรียนกัลยาณวัตร – บ้านโนนพอง").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter17, 15));
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
                        .add(new LatLng(16.429722, 102.840867))
                        .add(new LatLng(16.428554, 102.840765))
                        .add(new LatLng(16.428054, 102.840717))
                        .add(new LatLng(16.427625, 102.840651))
                        .add(new LatLng(16.427394, 102.840589))
                        .add(new LatLng(16.427198, 102.840520))
                        .add(new LatLng(16.426989, 102.840419))
                        .add(new LatLng(16.426542, 102.840209))
                        .add(new LatLng(16.426076, 102.839894))
                        .add(new LatLng(16.425534, 102.839518))
                        .add(new LatLng(16.425649, 102.839015))
                        .add(new LatLng(16.425749, 102.838457))
                        .add(new LatLng(16.425924, 102.837532))
                        .add(new LatLng(16.425996, 102.837122))
                        .add(new LatLng(16.426094, 102.836727))
                        .add(new LatLng(16.426290, 102.835964))
                        .add(new LatLng(16.426483, 102.835136))
                        .color(getResources().getColor(R.color.s18))

                );
                break;
            case "สาย 19 : ตลาดหนองไผ่ล้อม – บ้านโนนเรือง\nตลาดหนองไผ่ล้อม, ตลาดเทศบาล, ตลาดบางลำภู, โรงเรียนขอนแก่นวิทยายน, >บขส.1, ศูนย์หัวใจสิริกิตขอนแก่น, โรงพยาบาลศรีนครินทร์ขอนแก่น, มหาวิทยาลัยขอนแก่น, โลตัสเอ็กซ์ตร้า, บ.โนนเมือง, บ.โนนเรือง":

                // pin land mark start

                LatLng latLngLandmark1Line19 = new LatLng(16.425939, 102.831801);
                map.addMarker(new MarkerOptions().position(latLngLandmark1Line19).title("ตลาดหนองไผ่ล้อม").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark1Line19));

                LatLng latLngLandmark2Line19 = new LatLng(16.427475, 102.835103);
                map.addMarker(new MarkerOptions().position(latLngLandmark2Line19).title("ตลาดเทศบาล").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark2Line19));

                LatLng latLngLandmark3Line19 = new LatLng(16.428785, 102.835340);
                map.addMarker(new MarkerOptions().position(latLngLandmark3Line19).title("ตลาดบางลำพู").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark3Line19));

                LatLng latLngLandmark4Line19 = new LatLng(16.432384, 102.835668);
                map.addMarker(new MarkerOptions().position(latLngLandmark4Line19).title("โรงเรียนขอนแก่นวิทยายน").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark4Line19));

                LatLng latLngLandmark5Line19 = new LatLng(16.439266, 102.833345);
                map.addMarker(new MarkerOptions().position(latLngLandmark5Line19).title("บขส. 1").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark5Line19));

                LatLng latLngLandmark6Line19 = new LatLng(16.466365, 102.831799);
                map.addMarker(new MarkerOptions().position(latLngLandmark6Line19).title("ศูนย์หัวใจสิริกิตขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_hospital)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark6Line19));

                LatLng latLngLandmark7Line19 = new LatLng(16.468164, 102.831906);
                map.addMarker(new MarkerOptions().position(latLngLandmark7Line19).title("โรงพยาบาลศรีนครินทร์").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_hospital)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark7Line19));

//                LatLng latLngLandmark8Line19 = new LatLng();
//                map.addMarker(new MarkerOptions().position(latLngLandmark8Line19).title("").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark8Line19));
//
//                LatLng latLngLandmark9Line19 = new LatLng();
//                map.addMarker(new MarkerOptions().position(latLngLandmark9Line19).title("").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark9Line19));

                LatLng latLngLandmark10Line19 = new LatLng(16.476059, 102.832161);
                map.addMarker(new MarkerOptions().position(latLngLandmark10Line19).title("มหาวิทยาลัยขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark10Line19));

                LatLng latLngLandmark11Line19 = new LatLng(16.491806, 102.832161);
                map.addMarker(new MarkerOptions().position(latLngLandmark11Line19).title("โลตัสเอ็กซ์ตร้า").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark11Line19));

//                LatLng latLngLandmark12Line19 = new LatLng();
//                map.addMarker(new MarkerOptions().position(latLngLandmark12Line19).title("บ. โนนม่วง").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark12Line19));
//
//                LatLng latLngLandmark13Line19 = new LatLng();
//                map.addMarker(new MarkerOptions().position(latLngLandmark13Line19).title("บ. โนนเรือง").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark13Line19));

                // pin land mark stop

                LatLng mapCenter19 = new LatLng(16.426291, 102.827488);
                map.addMarker(new MarkerOptions().position(mapCenter19).title("Start").snippet("สาย 19 : ตลาดหนองไผ่ล้อม – บ้านโนนเรือง").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                LatLng mapCenter20 = new LatLng(16.498304, 102.832508);
                map.addMarker(new MarkerOptions().position(mapCenter20).title("Stop").snippet("สาย 19 : ตลาดหนองไผ่ล้อม – บ้านโนนเรือง").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter19, 15));
                map.addPolyline(new PolylineOptions().geodesic(true)
                        .add(new LatLng(16.426291, 102.827488))
                        .add(new LatLng(16.426173, 102.828182))
                        .add(new LatLng(16.426026, 102.829503))
                        .add(new LatLng(16.425977, 102.829932))
                        .add(new LatLng(16.425926, 102.830578))
                        .add(new LatLng(16.425893, 102.831128))
                        .add(new LatLng(16.425790, 102.831680))
                        .add(new LatLng(16.425746, 102.832292))
                        .add(new LatLng(16.425661, 102.833423))
                        .add(new LatLng(16.426202, 102.833470))
                        .add(new LatLng(16.426890, 102.833536))
                        .add(new LatLng(16.427799, 102.833629))
                        .add(new LatLng(16.428365, 102.833677))
                        .add(new LatLng(16.429107, 102.833788))
                        .add(new LatLng(16.429863, 102.833872))
                        .add(new LatLng(16.430620, 102.833935))
                        .add(new LatLng(16.431039, 102.833951))
                        .add(new LatLng(16.432594, 102.834130))
                        .add(new LatLng(16.433275, 102.834206))
                        .add(new LatLng(16.434210, 102.834304))
                        .add(new LatLng(16.434695, 102.834352))
                        .add(new LatLng(16.435657, 102.834449))
                        .add(new LatLng(16.436703, 102.834547))
                        .add(new LatLng(16.437597, 102.834645))
                        .add(new LatLng(16.438631, 102.834744))
                        .add(new LatLng(16.438710, 102.834736))
                        .add(new LatLng(16.438960, 102.833174))
                        .add(new LatLng(16.439022, 102.832513))
                        .add(new LatLng(16.439063, 102.832171))
                        .add(new LatLng(16.439265, 102.830764))
                        .add(new LatLng(16.439405, 102.829458))
                        .add(new LatLng(16.439512, 102.828740))
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
                        .color(getResources().getColor(R.color.s19))


                );
                break;
            case "สาย 20 : ตลาดหนองไผ่ล้อม – บ้านกลางฮุง\nตลาดหนองไผ่ล้อม, ตลาดเทศบาล, ตลาดบางลำภู, โรงเรียนขอนแก่นวิทยายน, บขส.1, ศูนย์หัวใจสิริกิตขอนแก่น, โรงพยาบาลศรีนครินทร์ขอนแก่น, มหาวิทยาลัยขอนแก่น, โลตัสเอ็กซ์ตร้า, บ.โคกนางาม, บ.หนองค้า, บ.กลางฮุง":

                // pin land mark start

                LatLng latLngLandmark1Line20 = new LatLng(16.425939, 102.831801);
                map.addMarker(new MarkerOptions().position(latLngLandmark1Line20).title("ตลาดหนองไผ่ล้อม").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark1Line20));

                LatLng latLngLandmark2Line20 = new LatLng(16.427475, 102.835103);
                map.addMarker(new MarkerOptions().position(latLngLandmark2Line20).title("ตลาดเทศบาล").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark2Line20));

                LatLng latLngLandmark3Line20 = new LatLng(16.428785, 102.835340);
                map.addMarker(new MarkerOptions().position(latLngLandmark3Line20).title("ตลาดบางลำพู").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark3Line20));

                LatLng latLngLandmark4Line20 = new LatLng(16.432384, 102.835668);
                map.addMarker(new MarkerOptions().position(latLngLandmark4Line20).title("โรงเรียนขอนแก่นวิทยายน").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark4Line20));

                LatLng latLngLandmark5Line20 = new LatLng(16.439266, 102.833345);
                map.addMarker(new MarkerOptions().position(latLngLandmark5Line20).title("บขส. 1").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark5Line20));

                LatLng latLngLandmark6Line20 = new LatLng(16.466365, 102.831799);
                map.addMarker(new MarkerOptions().position(latLngLandmark6Line20).title("ศูนย์หัวใจสิริกิตขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_hospital)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark6Line20));

                LatLng latLngLandmark7Line20 = new LatLng(16.468164, 102.831906);
                map.addMarker(new MarkerOptions().position(latLngLandmark7Line20).title("โรงพยาบาลศรีนครินทร์").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_hospital)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark7Line20));

                LatLng latLngLandmark8Line20 = new LatLng(16.476059, 102.832161);
                map.addMarker(new MarkerOptions().position(latLngLandmark8Line20).title("มหาวิทยาลัยขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark8Line20));

                LatLng latLngLandmark9Line20 = new LatLng(16.491806, 102.832161);
                map.addMarker(new MarkerOptions().position(latLngLandmark9Line20).title("โลตัสเอ็กซ์ตร้า").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark9Line20));

//                LatLng latLngLandmark10Line20 = new LatLng();
//                map.addMarker(new MarkerOptions().position(latLngLandmark10Line20).title("บ. โคกนางาม").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark10Line20));
//
//                LatLng latLngLandmark11Line20 = new LatLng();
//                map.addMarker(new MarkerOptions().position(latLngLandmark11Line20).title("บ. หนองค้า").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark11Line20));
//
//                LatLng latLngLandmark12Line20 = new LatLng();
//                map.addMarker(new MarkerOptions().position(latLngLandmark12Line20).title("บ. กลางฮุง").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark12Line20));

                // pin land mark stop

                LatLng mapCenter21 = new LatLng(16.426291, 102.827488);
                map.addMarker(new MarkerOptions().position(mapCenter21).title("Start").snippet("สาย 20 : ตลาดหนองไผ่ล้อม – บ้านกลางฮุง").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                LatLng mapCenter22 = new LatLng(16.498304, 102.832508);
                map.addMarker(new MarkerOptions().position(mapCenter22).title("Stop").snippet("สาย 20 : ตลาดหนองไผ่ล้อม – บ้านกลางฮุง").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter21, 15));
                map.addPolyline(new PolylineOptions().geodesic(true)
                        .add(new LatLng(16.426291, 102.827488))
                        .add(new LatLng(16.426173, 102.828182))
                        .add(new LatLng(16.426026, 102.829503))
                        .add(new LatLng(16.425977, 102.829932))
                        .add(new LatLng(16.425926, 102.830578))
                        .add(new LatLng(16.425893, 102.831128))
                        .add(new LatLng(16.425790, 102.831680))
                        .add(new LatLng(16.425746, 102.832292))
                        .add(new LatLng(16.425661, 102.833423))
                        .add(new LatLng(16.426202, 102.833470))
                        .add(new LatLng(16.426890, 102.833536))
                        .add(new LatLng(16.427799, 102.833629))
                        .add(new LatLng(16.428365, 102.833677))
                        .add(new LatLng(16.429107, 102.833788))
                        .add(new LatLng(16.429863, 102.833872))
                        .add(new LatLng(16.430620, 102.833935))
                        .add(new LatLng(16.431039, 102.833951))
                        .add(new LatLng(16.432594, 102.834130))
                        .add(new LatLng(16.433275, 102.834206))
                        .add(new LatLng(16.434210, 102.834304))
                        .add(new LatLng(16.434695, 102.834352))
                        .add(new LatLng(16.435657, 102.834449))
                        .add(new LatLng(16.436703, 102.834547))
                        .add(new LatLng(16.437597, 102.834645))
                        .add(new LatLng(16.438631, 102.834744))
                        .add(new LatLng(16.438710, 102.834736))
                        .add(new LatLng(16.438960, 102.833174))
                        .add(new LatLng(16.439022, 102.832513))
                        .add(new LatLng(16.439063, 102.832171))
                        .add(new LatLng(16.439265, 102.830764))
                        .add(new LatLng(16.439405, 102.829458))
                        .add(new LatLng(16.439512, 102.828740))
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
                        .color(getResources().getColor(R.color.s20))
                );
                break;

            case "สาย 21 : บ้านโนนเขวา – บ้านดอนยาง\nบ.โนนเขวา, บ.เหล่านกชุม, บ.บือ, บ.โนนทัน, บึงแก่นนคร, แฟรี่พลาซ่า, ตลาดเทศบาล, โรงเรียนกัลยาณวัตร, สถานีตํารวจภูธรเมืองขอนแก่น, โรงเรียนขอนแก่นวิทยายน, บขส.1, ศาลากลางจังหวัดขอนแก่น, ตลาดบ้านดอน, บ.ดองยาง":

                // pin land mark start

//                LatLng latLngLandmark1Line21 = new LatLng();
//                map.addMarker(new MarkerOptions().position(latLngLandmark1Line21).title("บ. โนนเขวา").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark1Line21));
//
//                LatLng latLngLandmark2Line21 = new LatLng();
//                map.addMarker(new MarkerOptions().position(latLngLandmark2Line21).title("บ. เหล่านกชุม").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark2Line21));
//
//                LatLng latLngLandmark3Line21 = new LatLng();
//                map.addMarker(new MarkerOptions().position(latLngLandmark3Line21).title("บ. บือ").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark3Line21));
//
//                LatLng latLngLandmark4Line21 = new LatLng();
//                map.addMarker(new MarkerOptions().position(latLngLandmark4Line21).title("บ. โนนทัน").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark4Line21));

                LatLng latLngLandmark5Line21 = new LatLng(16.418743, 102.840095);
                map.addMarker(new MarkerOptions().position(latLngLandmark5Line21).title("บึงแก่นนคร").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark5Line21));

                LatLng latLngLandmark6Line21 = new LatLng(16.423924, 102.833135);
                map.addMarker(new MarkerOptions().position(latLngLandmark6Line21).title("แฟรี่ พลาซ่า").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark6Line21));

                LatLng latLngLandmark7Line21 = new LatLng(16.427475, 102.835103);
                map.addMarker(new MarkerOptions().position(latLngLandmark7Line21).title("ตลาดเทศบาล").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark7Line21));

                LatLng latLngLandmark8Line21 = new LatLng(16.427651, 102.835532);
                map.addMarker(new MarkerOptions().position(latLngLandmark8Line21).title("โรงเรียนกัลยาณวัตร").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark8Line21));

                LatLng latLngLandmark9Line21 = new LatLng(16.428687, 102.835620);
                map.addMarker(new MarkerOptions().position(latLngLandmark9Line21).title("สถานีตํารวจภูธรเมืองขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark9Line21));

                LatLng latLngLandmark10Line21 = new LatLng(16.432384, 102.835668);
                map.addMarker(new MarkerOptions().position(latLngLandmark10Line21).title("โรงเรียนขอนแก่นวิทยายน").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark10Line21));

                LatLng latLngLandmark11Line21 = new LatLng(16.439266, 102.833345);
                map.addMarker(new MarkerOptions().position(latLngLandmark11Line21).title("บขส. 1").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark11Line21));

                LatLng latLngLandmark12Line21 = new LatLng(16.442479, 102.835975);
                map.addMarker(new MarkerOptions().position(latLngLandmark12Line21).title("ศาลากลางจังหวัดขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark12Line21));

                LatLng latLngLandmark13Line21 = new LatLng(16.454248, 102.842549);
                map.addMarker(new MarkerOptions().position(latLngLandmark13Line21).title("ตลาดบ้านดอน").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark13Line21));

//                LatLng latLngLandmark13Line21 = new LatLng();
//                map.addMarker(new MarkerOptions().position(latLngLandmark13Line21).title("บ. ดองยาง").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark13Line21));

                // pin land mark stop

                LatLng mapCenter37 = new LatLng(16.455550, 102.855093);
                map.addMarker(new MarkerOptions().position(mapCenter37).title("Start").snippet("สาย 21 : บ้านโนนเขวา – บ้านดอนยาง").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                LatLng mapCenter38 = new LatLng(16.411424, 102.859660);
                map.addMarker(new MarkerOptions().position(mapCenter38).title("Stop").snippet("สาย 21 : บ้านโนนเขวา – บ้านดอนยาง").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter37, 15));
                map.addPolyline(new PolylineOptions().geodesic(true)
                        .add(new LatLng(16.455550, 102.855093))
                        .add(new LatLng(16.455376, 102.853955))
                        .add(new LatLng(16.455150, 102.852407))
                        .add(new LatLng(16.454983, 102.851497))
                        .add(new LatLng(16.454655, 102.850329))
                        .add(new LatLng(16.454350, 102.849229))
                        .add(new LatLng(16.453738, 102.847140))
                        .add(new LatLng(16.453568, 102.846480))
                        .add(new LatLng(16.453352, 102.845739))
                        .add(new LatLng(16.453248, 102.845372))
                        .add(new LatLng(16.453132, 102.844774))
                        .add(new LatLng(16.453084, 102.844245))
                        .add(new LatLng(16.453046, 102.843411))
                        .add(new LatLng(16.453037, 102.843149))
                        .add(new LatLng(16.452985, 102.842743))
                        .add(new LatLng(16.452972, 102.842211))
                        .add(new LatLng(16.452397, 102.842181))
                        .add(new LatLng(16.451610, 102.842146))
                        .add(new LatLng(16.451085, 102.842087))
                        .add(new LatLng(16.450607, 102.842010))
                        .add(new LatLng(16.450083, 102.841868))
                        .add(new LatLng(16.449178, 102.841509))
                        .add(new LatLng(16.449000, 102.841447))
                        .add(new LatLng(16.448542, 102.841341))
                        .add(new LatLng(16.448262, 102.841239))
                        .add(new LatLng(16.447999, 102.841218))
                        .add(new LatLng(16.447749, 102.841127))
                        .add(new LatLng(16.446893, 102.840979))
                        .add(new LatLng(16.446949, 102.840280))
                        .add(new LatLng(16.447126, 102.838547))
                        .add(new LatLng(16.447177, 102.837963))
                        .add(new LatLng(16.447241, 102.837551))
                        .add(new LatLng(16.447366, 102.836581))
                        .add(new LatLng(16.447431, 102.835772))
                        .add(new LatLng(16.447036, 102.835731))
                        .add(new LatLng(16.446565, 102.835566))
                        .add(new LatLng(16.446174, 102.835556))
                        .add(new LatLng(16.445667, 102.835492))
                        .add(new LatLng(16.444823, 102.835378))
                        .add(new LatLng(16.444473, 102.835357))
                        .add(new LatLng(16.444221, 102.835287))
                        .add(new LatLng(16.443136, 102.835207))
                        .add(new LatLng(16.442272, 102.835110))
                        .add(new LatLng(16.442045, 102.835100))
                        .add(new LatLng(16.441433, 102.835035))
                        .add(new LatLng(16.440435, 102.834923))
                        .add(new LatLng(16.439658, 102.834848))
                        .add(new LatLng(16.439313, 102.834810))
                        .add(new LatLng(16.438814, 102.834772))
                        .add(new LatLng(16.438445, 102.836451))
                        .add(new LatLng(16.437067, 102.836319))
                        .add(new LatLng(16.436470, 102.836360))
                        .add(new LatLng(16.435294, 102.836216))
                        .add(new LatLng(16.434916, 102.836175))
                        .add(new LatLng(16.434028, 102.836092))
                        .add(new LatLng(16.433097, 102.835950))
                        .add(new LatLng(16.432526, 102.835926))
                        .add(new LatLng(16.431416, 102.835776))
                        .add(new LatLng(16.431009, 102.835746))
                        .add(new LatLng(16.430376, 102.835662))
                        .add(new LatLng(16.429589, 102.835592))
                        .add(new LatLng(16.428894, 102.835501))
                        .add(new LatLng(16.428204, 102.835442))
                        .add(new LatLng(16.426960, 102.835193))
                        .add(new LatLng(16.426488, 102.835144))
                        .add(new LatLng(16.426043, 102.835119))
                        .add(new LatLng(16.425546, 102.835081))
                        .add(new LatLng(16.424659, 102.835021))
                        .add(new LatLng(16.424269, 102.834981))
                        .add(new LatLng(16.423146, 102.834853))
                        .add(new LatLng(16.422526, 102.834863))
                        .add(new LatLng(16.421973, 102.834860))
                        .add(new LatLng(16.421336, 102.834781))
                        .add(new LatLng(16.420585, 102.834686))
                        .add(new LatLng(16.420520, 102.834674))
                        .add(new LatLng(16.420487, 102.835847))
                        .add(new LatLng(16.420477, 102.836209))
                        .add(new LatLng(16.420425, 102.837053))
                        .add(new LatLng(16.420415, 102.837887))
                        .add(new LatLng(16.420379, 102.838574))
                        .add(new LatLng(16.420373, 102.838800))
                        .add(new LatLng(16.420282, 102.839125))
                        .add(new LatLng(16.420140, 102.839386))
                        .add(new LatLng(16.419893, 102.839657))
                        .add(new LatLng(16.419659, 102.839842))
                        .add(new LatLng(16.418719, 102.840277))
                        .add(new LatLng(16.418772, 102.840438))
                        .add(new LatLng(16.418808, 102.840923))
                        .add(new LatLng(16.418814, 102.841476))
                        .add(new LatLng(16.418796, 102.841860))
                        .add(new LatLng(16.418737, 102.842318))
                        .add(new LatLng(16.418686, 102.842838))
                        .add(new LatLng(16.418634, 102.843265))
                        .add(new LatLng(16.418595, 102.843670))
                        .add(new LatLng(16.418369, 102.845226))
                        .add(new LatLng(16.418334, 102.845556))
                        .add(new LatLng(16.418181, 102.846102))
                        .add(new LatLng(16.417962, 102.846499))
                        .add(new LatLng(16.417736, 102.846759))
                        .add(new LatLng(16.417594, 102.846971))
                        .add(new LatLng(16.417481, 102.847161))
                        .add(new LatLng(16.417427, 102.847314))
                        .add(new LatLng(16.417409, 102.847521))
                        .add(new LatLng(16.417419, 102.847844))
                        .add(new LatLng(16.417419, 102.848084))
                        .add(new LatLng(16.417318, 102.848441))
                        .add(new LatLng(16.417134, 102.848861))
                        .add(new LatLng(16.416991, 102.849062))
                        .add(new LatLng(16.416763, 102.849420))
                        .add(new LatLng(16.416642, 102.849707))
                        .add(new LatLng(16.416393, 102.850265))
                        .add(new LatLng(16.416233, 102.850820))
                        .add(new LatLng(16.416110, 102.851268))
                        .add(new LatLng(16.416046, 102.851558))
                        .add(new LatLng(16.416005, 102.851931))
                        .add(new LatLng(16.415938, 102.852215))
                        .add(new LatLng(16.415831, 102.852499))
                        .add(new LatLng(16.415693, 102.852727))
                        .add(new LatLng(16.415618, 102.852879))
                        .add(new LatLng(16.415447, 102.853139))
                        .add(new LatLng(16.415341, 102.853370))
                        .add(new LatLng(16.415146, 102.853967))
                        .add(new LatLng(16.415000, 102.854352))
                        .add(new LatLng(16.414900, 102.854634))
                        .add(new LatLng(16.414758, 102.854974))
                        .add(new LatLng(16.414635, 102.855229))
                        .add(new LatLng(16.414427, 102.855618))
                        .add(new LatLng(16.414226, 102.855951))
                        .add(new LatLng(16.414027, 102.856211))
                        .add(new LatLng(16.413683, 102.856610))
                        .add(new LatLng(16.413403, 102.856912))
                        .add(new LatLng(16.413149, 102.857144))
                        .add(new LatLng(16.412672, 102.857618))
                        .add(new LatLng(16.412312, 102.858003))
                        .add(new LatLng(16.412062, 102.858402))
                        .add(new LatLng(16.411640, 102.859188))
                        .add(new LatLng(16.411424, 102.859660))
                        .color(getResources().getColor(R.color.s20)));
                break;


            case "สาย 22 : บ้านหนองไฮ- บ้านดอนหญ้านาง\nบ.หนองไฮ, ตลาดหนองใหญ่, โรงพยาบาลศูนย์ขอนแก่น, เรือนจำขอนแก่น, สถานีตํารวจภูธรเมืองขอนแก่น, ตลาดเทศบาล, ตลาดบางลำภู, โรงเรียนขอนแก่นวิทยายน, บขส.1, ไปรษณีย์ขอนแก่น, บ.ดอนหญ้านาง":

                // pin land mark start

//                LatLng latLngLandmark1Line22 = new LatLng();
//                map.addMarker(new MarkerOptions().position(latLngLandmark1Line22).title("บ. หนองไฮ").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark1Line22));

                LatLng latLngLandmark2Line22 = new LatLng(16.427545, 102.868770);
                map.addMarker(new MarkerOptions().position(latLngLandmark2Line22).title("ตลาดหนองใหญ่").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark2Line22));

                LatLng latLngLandmark3Line22 = new LatLng(16.428952, 102.849130);
                map.addMarker(new MarkerOptions().position(latLngLandmark3Line22).title("โรงพยาบาลศูนย์ขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_hospital)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark3Line22));

                LatLng latLngLandmark4Line22 = new LatLng(16.429288, 102.845191);
                map.addMarker(new MarkerOptions().position(latLngLandmark4Line22).title("เรือนจำขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark4Line22));

                LatLng latLngLandmark5Line22 = new LatLng(16.428687, 102.835620);
                map.addMarker(new MarkerOptions().position(latLngLandmark5Line22).title("สถานีตํารวจภูธรเมืองขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark5Line22));

                LatLng latLngLandmark6Line22 = new LatLng(16.427475, 102.835103);
                map.addMarker(new MarkerOptions().position(latLngLandmark6Line22).title("ตลาดเทศบาล").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark6Line22));

                LatLng latLngLandmark7Line22 = new LatLng(16.428785, 102.835340);
                map.addMarker(new MarkerOptions().position(latLngLandmark7Line22).title("ตลาดบางลำพู").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark7Line22));

                LatLng latLngLandmark8Line22 = new LatLng(16.432384, 102.835668);
                map.addMarker(new MarkerOptions().position(latLngLandmark8Line22).title("โรงเรียนขอนแก่นวิทยายน").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark8Line22));

                LatLng latLngLandmark9Line22 = new LatLng(16.439266, 102.833345);
                map.addMarker(new MarkerOptions().position(latLngLandmark9Line22).title("บขส. 1").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark9Line22));

                LatLng latLngLandmark10Line22 = new LatLng(16.429769, 102.835726);
                map.addMarker(new MarkerOptions().position(latLngLandmark10Line22).title("ไปรษณีย์ขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark10Line22));

//                LatLng latLngLandmark11Line22 = new LatLng();
//                map.addMarker(new MarkerOptions().position(latLngLandmark11Line22).title("บ. ดอนหญ้านาง").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark11Line22));

                // pin land mark stop

                LatLng mapCenter23 = new LatLng(16.414864, 102.874371);
                map.addMarker(new MarkerOptions().position(mapCenter23).title("Start").snippet("สาย 22 : บ้านหนองไฮ- บ้านดอนหญ้านาง").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                LatLng mapCenter24 = new LatLng(16.447251, 102.837567);
                map.addMarker(new MarkerOptions().position(mapCenter24).title("Stop").snippet("สาย 22 : บ้านหนองไฮ- บ้านดอนหญ้านาง").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter23, 15));
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
                        .add(new LatLng(16.426096, 102.869730))
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
                        .add(new LatLng(16.430384, 102.835648))
                        .add(new LatLng(16.428810, 102.835509))
                        .add(new LatLng(16.428213, 102.835433))
                        .add(new LatLng(16.426947, 102.835186))
                        .add(new LatLng(16.426520, 102.835127))
                        .add(new LatLng(16.425517, 102.835052))
                        .add(new LatLng(16.425593, 102.834135))
                        .add(new LatLng(16.425661, 102.833423))
                        .add(new LatLng(16.426202, 102.833470))
                        .add(new LatLng(16.426890, 102.833536))
                        .add(new LatLng(16.427799, 102.833629))
                        .add(new LatLng(16.428365, 102.833677))
                        .add(new LatLng(16.429107, 102.833788))
                        .add(new LatLng(16.429863, 102.833872))
                        .add(new LatLng(16.430620, 102.833935))
                        .add(new LatLng(16.431039, 102.833951))
                        .add(new LatLng(16.432594, 102.834130))
                        .add(new LatLng(16.433275, 102.834206))
                        .add(new LatLng(16.434210, 102.834304))
                        .add(new LatLng(16.434695, 102.834352))
                        .add(new LatLng(16.435657, 102.834449))
                        .add(new LatLng(16.436703, 102.834547))
                        .add(new LatLng(16.437597, 102.834645))
                        .add(new LatLng(16.438631, 102.834744))
                        .add(new LatLng(16.439016, 102.832935))
                        .add(new LatLng(16.438631, 102.834744))
                        .add(new LatLng(16.439848, 102.830835))
                        .add(new LatLng(16.440255, 102.830845))
                        .add(new LatLng(16.440882, 102.830908))
                        .add(new LatLng(16.440770, 102.831841))
                        .add(new LatLng(16.440638, 102.832927))
                        .add(new LatLng(16.440540, 102.833742))
                        .add(new LatLng(16.440500, 102.834217))
                        .add(new LatLng(16.440427, 102.834926))
                        .add(new LatLng(16.440229, 102.836639))
                        .add(new LatLng(16.440195, 102.837204))
                        .add(new LatLng(16.440120, 102.837757))
                        .add(new LatLng(16.440076, 102.838237))
                        .add(new LatLng(16.440040, 102.838669))
                        .add(new LatLng(16.441360, 102.838811))
                        .add(new LatLng(16.441926, 102.838875))
                        .add(new LatLng(16.442770, 102.838967))
                        .add(new LatLng(16.442847, 102.838285))
                        .add(new LatLng(16.442883, 102.837679))
                        .add(new LatLng(16.442965, 102.836928))
                        .add(new LatLng(16.444031, 102.837078))
                        .add(new LatLng(16.444749, 102.837186))
                        .add(new LatLng(16.445151, 102.837250))
                        .add(new LatLng(16.445782, 102.837277))
                        .add(new LatLng(16.446132, 102.837322))
                        .add(new LatLng(16.446470, 102.837447))
                        .add(new LatLng(16.447251, 102.837567))
                        .color(getResources().getColor(R.color.s22))
                );
                break;
            case "สาย 23 : ตลาดเทศบาล 1 – บ้านห้วยเตย\nตลาดเทศบาล, ตลาดเทศบาล, บ.โนนตุ่น, บ.ท่าพระ, บ.หนองบัวดีหมี, บ.หนองแวง, บ.ห้วยเตย":

                // pin land mark start

//                LatLng latLngLandmark1Line23 = new LatLng(16.427475, 102.835103);
//                map.addMarker(new MarkerOptions().position(latLngLandmark1Line23).title("ตลาดเทศบาล").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark1Line23));

                LatLng latLngLandmark2Line23 = new LatLng(16.413309, 102.835381);
                map.addMarker(new MarkerOptions().position(latLngLandmark2Line23).title("บึงแก่นนคร").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark2Line23));

//                LatLng latLngLandmark3Line23 = new LatLng();
//                map.addMarker(new MarkerOptions().position(latLngLandmark3Line23).title("บ. โนนตุ่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark3Line23));
//
//                LatLng latLngLandmark4Line23 = new LatLng();
//                map.addMarker(new MarkerOptions().position(latLngLandmark4Line23).title("บ. ท่าพระ").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark4Line23));
//
//                LatLng latLngLandmark5Line23 = new LatLng();
//                map.addMarker(new MarkerOptions().position(latLngLandmark5Line23).title("บ. หนองบัวดีหมี").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark5Line23));
//
//                LatLng latLngLandmark6Line23 = new LatLng();
//                map.addMarker(new MarkerOptions().position(latLngLandmark6Line23).title("บ. หนองแวง").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark6Line23));
//
//                LatLng latLngLandmark7Line23 = new LatLng();
//                map.addMarker(new MarkerOptions().position(latLngLandmark7Line23).title("บ. ห้วยเตย").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
//                map.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark7Line23));

                // pin land mark stop

                LatLng mapCenter25 = new LatLng(16.426570, 102.826566);
                map.addMarker(new MarkerOptions().position(mapCenter25).title("Start").snippet("สาย 23 : ตลาดเทศบาล 1 – บ้านห้วยเตย").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                LatLng mapCenter26 = new LatLng(16.372533, 102.809281);
                map.addMarker(new MarkerOptions().position(mapCenter26).title("Stop").snippet("สาย 23 : ตลาดเทศบาล 1 – บ้านห้วยเตย").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter25, 15));
                map.addPolyline(new PolylineOptions().geodesic(true)
                        .add(new LatLng(16.426570, 102.826566))
                        .add(new LatLng(16.426488, 102.826850))
                        .add(new LatLng(16.426431, 102.827020))
                        .add(new LatLng(16.426416, 102.827138))
                        .add(new LatLng(16.426294, 102.827479))
                        .add(new LatLng(16.426190, 102.828161))
                        .add(new LatLng(16.426025, 102.829489))
                        .add(new LatLng(16.425984, 102.829929))
                        .add(new LatLng(16.425941, 102.830565))
                        .add(new LatLng(16.425892, 102.831139))
                        .add(new LatLng(16.425800, 102.831683))
                        .add(new LatLng(16.425606, 102.831740))
                        .add(new LatLng(16.425223, 102.831894))
                        .add(new LatLng(16.424902, 102.832011))
                        .add(new LatLng(16.424742, 102.832120))
                        .add(new LatLng(16.424552, 102.832275))
                        .add(new LatLng(16.424411, 102.832418))
                        .add(new LatLng(16.424236, 102.832729))
                        .add(new LatLng(16.424081, 102.833032))
                        .add(new LatLng(16.423931, 102.833380))
                        .add(new LatLng(16.423893, 102.833565))
                        .add(new LatLng(16.423837, 102.833715))
                        .add(new LatLng(16.423709, 102.833971))
                        .add(new LatLng(16.423526, 102.834242))
                        .add(new LatLng(16.423361, 102.834408))
                        .add(new LatLng(16.423200, 102.834578))
                        .add(new LatLng(16.423136, 102.834701))
                        .add(new LatLng(16.423100, 102.834864))
                        .add(new LatLng(16.423118, 102.834966))
                        .add(new LatLng(16.423090, 102.835149))
                        .add(new LatLng(16.423019, 102.835364))
                        .add(new LatLng(16.422983, 102.835501))
                        .add(new LatLng(16.422969, 102.835905))
                        .add(new LatLng(16.422925, 102.836221))
                        .add(new LatLng(16.422818, 102.836657))
                        .add(new LatLng(16.422760, 102.837064))
                        .add(new LatLng(16.421780, 102.837063))
                        .add(new LatLng(16.421199, 102.837063))
                        .add(new LatLng(16.420446, 102.837048))
                        .add(new LatLng(16.419684, 102.837091))
                        .add(new LatLng(16.419516, 102.837071))
                        .add(new LatLng(16.419475, 102.836995))
                        .add(new LatLng(16.419248, 102.836580))
                        .add(new LatLng(16.418837, 102.836064))
                        .add(new LatLng(16.418656, 102.835861))
                        .add(new LatLng(16.418507, 102.835715))
                        .add(new LatLng(16.418405, 102.835620))
                        .add(new LatLng(16.418063, 102.835247))
                        .add(new LatLng(16.417850, 102.835099))
                        .add(new LatLng(16.417725, 102.835037))
                        .add(new LatLng(16.417514, 102.834954))
                        .add(new LatLng(16.417319, 102.834899))
                        .add(new LatLng(16.416793, 102.834816))
                        .add(new LatLng(16.416640, 102.834814))
                        .add(new LatLng(16.416480, 102.834836))
                        .add(new LatLng(16.416345, 102.834874))
                        .add(new LatLng(16.415816, 102.835037))
                        .add(new LatLng(16.415293, 102.835177))
                        .add(new LatLng(16.415187, 102.835205))
                        .add(new LatLng(16.414830, 102.835265))
                        .add(new LatLng(16.414665, 102.835293))
                        .add(new LatLng(16.414461, 102.835313))
                        .add(new LatLng(16.414334, 102.835317))
                        .add(new LatLng(16.414051, 102.835297))
                        .add(new LatLng(16.413337, 102.835197))
                        .add(new LatLng(16.412992, 102.835159))
                        .add(new LatLng(16.412621, 102.835099))
                        .add(new LatLng(16.412336, 102.835062))
                        .add(new LatLng(16.412115, 102.835058))
                        .add(new LatLng(16.411870, 102.835065))
                        .add(new LatLng(16.411533, 102.835070))
                        .add(new LatLng(16.410992, 102.835083))
                        .add(new LatLng(16.410642, 102.835091))
                        .add(new LatLng(16.410520, 102.835108))
                        .add(new LatLng(16.410184, 102.835173))
                        .add(new LatLng(16.409921, 102.834008))
                        .add(new LatLng(16.409825, 102.833592))
                        .add(new LatLng(16.409187, 102.833528))
                        .add(new LatLng(16.408960, 102.833560))
                        .add(new LatLng(16.408055, 102.833507))
                        .add(new LatLng(16.407553, 102.833448))
                        .add(new LatLng(16.407139, 102.833377))
                        .add(new LatLng(16.406435, 102.833243))
                        .add(new LatLng(16.405524, 102.833039))
                        .add(new LatLng(16.405101, 102.832982))
                        .add(new LatLng(16.403969, 102.832714))
                        .add(new LatLng(16.402672, 102.832338))
                        .add(new LatLng(16.401272, 102.831892))
                        .add(new LatLng(16.400411, 102.831551))
                        .add(new LatLng(16.399393, 102.831118))
                        .add(new LatLng(16.398599, 102.830731))
                        .add(new LatLng(16.397826, 102.830349))
                        .add(new LatLng(16.396999, 102.829952))
                        .add(new LatLng(16.395790, 102.829284))
                        .add(new LatLng(16.395028, 102.828914))
                        .add(new LatLng(16.394004, 102.828324))
                        .add(new LatLng(16.393047, 102.827793))
                        .add(new LatLng(16.391210, 102.826849))
                        .add(new LatLng(16.390551, 102.826516))
                        .add(new LatLng(16.389918, 102.826135))
                        .add(new LatLng(16.389439, 102.825792))
                        .add(new LatLng(16.386823, 102.823883))
                        .add(new LatLng(16.386319, 102.823462))
                        .add(new LatLng(16.385462, 102.822875))
                        .add(new LatLng(16.384777, 102.822285))
                        .add(new LatLng(16.384067, 102.821690))
                        .add(new LatLng(16.382670, 102.820377))
                        .add(new LatLng(16.381734, 102.819414))
                        .add(new LatLng(16.380829, 102.818418))
                        .add(new LatLng(16.380280, 102.817760))
                        .add(new LatLng(16.379962, 102.817343))
                        .add(new LatLng(16.379702, 102.816933))
                        .add(new LatLng(16.379231, 102.816210))
                        .add(new LatLng(16.378578, 102.815258))
                        .add(new LatLng(16.377865, 102.814247))
                        .add(new LatLng(16.377440, 102.813665))
                        .add(new LatLng(16.377250, 102.813437))
                        .add(new LatLng(16.376907, 102.813090))
                        .add(new LatLng(16.376052, 102.812310))
                        .add(new LatLng(16.375726, 102.812013))
                        .add(new LatLng(16.375615, 102.811864))
                        .add(new LatLng(16.374951, 102.811353))
                        .add(new LatLng(16.374533, 102.810940))
                        .add(new LatLng(16.374074, 102.810388))
                        .add(new LatLng(16.373512, 102.809945))
                        .add(new LatLng(16.373137, 102.809645))
                        .add(new LatLng(16.372970, 102.809531))
                        .add(new LatLng(16.372533, 102.809281))

                        .color(getResources().getColor(R.color.s23))

                );
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
    public void onResume() {
        super.onResume();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }
}
