package com.app.arnont.kkminibus.activity;

import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.os.Build;
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

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
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
            case "กลางเมือง":
                LatLng mapCenter1 = new LatLng(16.438445, 102.836451);
                map.addMarker(new MarkerOptions().position(mapCenter1).title("Start").snippet("กลางเมือง").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                LatLng mapCenter2 = new LatLng(16.372533, 102.809281);
                map.addMarker(new MarkerOptions().position(mapCenter2).title("Stop").snippet("กลางเมือง").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter1, 15));
                map.addPolyline(new PolylineOptions().geodesic(true)
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
                        .add(new LatLng(16.420436, 102.834634))
                        .add(new LatLng(16.420153, 102.834605))
                        .add(new LatLng(16.419322, 102.834537))
                        .add(new LatLng(16.418722, 102.834468))
                        .add(new LatLng(16.417904, 102.834296))
                        .add(new LatLng(16.417317, 102.834248))
                        .add(new LatLng(16.416774, 102.834231))
                        .add(new LatLng(16.415997, 102.834144))
                        .add(new LatLng(16.415718, 102.834128))
                        .add(new LatLng(16.415337, 102.834089))
                        .add(new LatLng(16.414704, 102.834041))
                        .add(new LatLng(16.414336, 102.834001))
                        .add(new LatLng(16.413366, 102.833918))
                        .add(new LatLng(16.413034, 102.833897))
                        .add(new LatLng(16.412424, 102.833822))
                        .add(new LatLng(16.411302, 102.833721))
                        .add(new LatLng(16.410329, 102.833646))
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
                        .color(getResources().getColor(R.color.green))
                );
                break;
            case "ชาตะผดุง":
                LatLng mapCenter3 = new LatLng(16.428768, 102.851612);
                map.addMarker(new MarkerOptions().position(mapCenter3).title("Start").snippet("ชาตะผดุง").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                LatLng mapCenter4 = new LatLng(16.435280, 102.854037);
                map.addMarker(new MarkerOptions().position(mapCenter4).title("Stop").snippet("ชาตะผดุง").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter3, 15));
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
                        .add(new LatLng(16.434323, 102.853546))
                        .add(new LatLng(16.434500, 102.853624))
                        .add(new LatLng(16.434639, 102.853806))
                        .add(new LatLng(16.434966, 102.853927))
                        .add(new LatLng(16.435280, 102.854037))

                        .color(getResources().getColor(R.color.gold))
                );
                break;
            case "ทางรถไฟ":
                LatLng mapCenter5 = new LatLng(16.415613, 102.822637);
                map.addMarker(new MarkerOptions().position(mapCenter5).title("Start").snippet("ทางรถไฟ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                LatLng mapCenter6 = new LatLng(16.426291, 102.827488);
                map.addMarker(new MarkerOptions().position(mapCenter6).title("Stop").snippet("ทางรถไฟ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter5, 15));
                map.addPolyline(new PolylineOptions().geodesic(true)
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
                );
                break;
            case "บ้านบะขาม":
                LatLng mapCenter7 = new LatLng(16.428739, 102.854318);
                map.addMarker(new MarkerOptions().position(mapCenter7).title("Start").snippet("บ้านบะขาม").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                LatLng mapCenter8 = new LatLng(16.434208, 102.860257);
                map.addMarker(new MarkerOptions().position(mapCenter8).title("Stop").snippet("บ้านบะขาม").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter7, 15));
                map.addPolyline(new PolylineOptions().geodesic(true)
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
                        .add(new LatLng(16.434208, 102.860257))

                );

                break;

            case "บ้านหนองไฮ":
                LatLng mapCenter9 = new LatLng(16.414864, 102.874371);
                map.addMarker(new MarkerOptions().position(mapCenter9).title("Start").snippet("บ้านหนองไฮ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                LatLng mapCenter10 = new LatLng(16.427204, 102.869500);
                map.addMarker(new MarkerOptions().position(mapCenter10).title("Stop").snippet("บ้านหนองไฮ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter9, 15));
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
                );

                break;

            case "ประชาสโมสร":
                LatLng mapCenter11 = new LatLng(16.427275, 102.870638);
                map.addMarker(new MarkerOptions().position(mapCenter11).title("Start").snippet("ประชาสโมสร").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                LatLng mapCenter12 = new LatLng(16.439512, 102.828740);
                map.addMarker(new MarkerOptions().position(mapCenter12).title("Stop").snippet("ประชาสโมสร").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter11, 15));
                map.addPolyline(new PolylineOptions().geodesic(true)
                        .add(new LatLng(16.427275, 102.870638))
                        .add(new LatLng(16.427751, 102.870674))
                        .add(new LatLng(16.428270, 102.870728))
                        .add(new LatLng(16.428646, 102.870692))
                        .add(new LatLng(16.428953, 102.870645))
                        .add(new LatLng(16.429312, 102.870537))
                        .add(new LatLng(16.429658, 102.870381))
                        .add(new LatLng(16.430106, 102.870118))
                        .add(new LatLng(16.431489, 102.869076))
                        .add(new LatLng(16.431968, 102.868599))
                        .add(new LatLng(16.432145, 102.868376))
                        .add(new LatLng(16.432485, 102.867845))
                        .add(new LatLng(16.432688, 102.867472))
                        .add(new LatLng(16.433088, 102.866414))
                        .add(new LatLng(16.433196, 102.865960))
                        .add(new LatLng(16.433288, 102.865517))
                        .add(new LatLng(16.433524, 102.864211))
                        .add(new LatLng(16.434026, 102.861256))
                        .add(new LatLng(16.434122, 102.860982))
                        .add(new LatLng(16.434208, 102.860257))
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
                );
                break;

            case "ม - ภาค":
                LatLng mapCenter13 = new LatLng(16.421426, 102.820540);
                map.addMarker(new MarkerOptions().position(mapCenter13).title("Start").snippet("ม - ภาค").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                LatLng mapCenter14 = new LatLng(16.423574, 102.800331);
                map.addMarker(new MarkerOptions().position(mapCenter14).title("Stop").snippet("ม - ภาค").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter13, 15));
                map.addPolyline(new PolylineOptions().geodesic(true)
                        .add(new LatLng(16.421426, 102.820540))
                        .add(new LatLng(16.421439, 102.820350))
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
                );
                break;
            case "มลิวรรณ":
                LatLng mapCenter15 = new LatLng(16.439512, 102.828740);
                map.addMarker(new MarkerOptions().position(mapCenter15).title("Start").snippet("มลิวรรณ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                LatLng mapCenter16 = new LatLng(16.448607, 102.767814);
                map.addMarker(new MarkerOptions().position(mapCenter16).title("Stop").snippet("มลิวรรณ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter15, 15));
                map.addPolyline(new PolylineOptions().geodesic(true)
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
                );

                break;

            case "มิตรภาพ":
                LatLng mapCenter17 = new LatLng(16.498304, 102.832508);
                map.addMarker(new MarkerOptions().position(mapCenter17).title("Start").snippet("มิตรภาพ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                LatLng mapCenter18 = new LatLng(16.389369, 102.806185);
                map.addMarker(new MarkerOptions().position(mapCenter18).title("Stop").snippet("มิตรภาพ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter17, 15));
                map.addPolyline(new PolylineOptions().geodesic(true)
                        .add(new LatLng(16.498304, 102.832508))
                        .add(new LatLng(16.495192, 102.832503))
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
                        .add(new LatLng(16.439115, 102.828022))
                        .add(new LatLng(16.438589, 102.827530))
                        .add(new LatLng(16.437824, 102.826861))
                        .add(new LatLng(16.436794, 102.825938))
                        .add(new LatLng(16.436625, 102.825758))
                        .add(new LatLng(16.436249, 102.825447))
                        .add(new LatLng(16.435610, 102.824986))
                        .add(new LatLng(16.434832, 102.824551))
                        .add(new LatLng(16.434639, 102.824444))
                        .add(new LatLng(16.434225, 102.824240))
                        .add(new LatLng(16.433934, 102.824052))
                        .add(new LatLng(16.433530, 102.823944))
                        .add(new LatLng(16.432939, 102.823786))
                        .add(new LatLng(16.432172, 102.823555))
                        .add(new LatLng(16.431168, 102.823271))
                        .add(new LatLng(16.430587, 102.823185))
                        .add(new LatLng(16.429275, 102.822799))
                        .add(new LatLng(16.428267, 102.822509))
                        .add(new LatLng(16.426240, 102.821903))
                        .add(new LatLng(16.424805, 102.821496))
                        .add(new LatLng(16.423642, 102.821179))
                        .add(new LatLng(16.422454, 102.820851))
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


                );
                break;
            case "ร - 8":
                LatLng mapCenter19 = new LatLng(16.462070, 102.798958);
                map.addMarker(new MarkerOptions().position(mapCenter19).title("Start").snippet("ร - 8").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                LatLng mapCenter20 = new LatLng(16.444697, 102.793631);
                map.addMarker(new MarkerOptions().position(mapCenter20).title("Stop").snippet("ร - 8").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter19, 15));
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
            case "รอบบึงแก่นนคร":
                LatLng mapCenter21 = new LatLng(16.406101, 102.839402);
                map.addMarker(new MarkerOptions().position(mapCenter21).title("Start").snippet("รอบบึงแก่นนคร").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                LatLng mapCenter22 = new LatLng(16.406092, 102.839392);
                map.addMarker(new MarkerOptions().position(mapCenter22).title("Stop").snippet("รอบบึงแก่นนคร").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter21, 15));
                map.addPolyline(new PolylineOptions().geodesic(true)
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



                );
                break;
            case "ศรีจันทร์":
                LatLng mapCenter23 = new LatLng(16.426794, 102.874816);
                map.addMarker(new MarkerOptions().position(mapCenter23).title("Start").snippet("ศรีจันทร์").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                LatLng mapCenter24 = new LatLng(16.436621, 102.765723);
                map.addMarker(new MarkerOptions().position(mapCenter24).title("Stop").snippet("ศรีจันทร์").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter23, 15));
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
                        .add(new LatLng(16.430605, 102.833904))
                        .add(new LatLng(16.430695, 102.833474))
                        .add(new LatLng(16.430824, 102.832166))
                        .add(new LatLng(16.431001, 102.830967))
                        .add(new LatLng(16.431105, 102.830233))
                        .add(new LatLng(16.431215, 102.829768))
                        .add(new LatLng(16.431297, 102.829234))
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
                );
                break;
            case "ศูนย์ราชการ - ทุ่งสร้าง":
                LatLng mapCenter25 = new LatLng(16.438666, 102.834748);
                map.addMarker(new MarkerOptions().position(mapCenter25).title("Start").snippet("ศูนย์ราชการ - ทุ่งสร้าง").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                LatLng mapCenter26 = new LatLng(16.447767, 102.841116);
                map.addMarker(new MarkerOptions().position(mapCenter26).title("Stop").snippet("ศูนย์ราชการ - ทุ่งสร้าง").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter25, 15));
                map.addPolyline(new PolylineOptions().geodesic(true)
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
            case "หน้าเมือง":
                LatLng mapCenter27 = new LatLng(16.438631, 102.834744);
                map.addMarker(new MarkerOptions().position(mapCenter27).title("Start").snippet("หน้าเมือง").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                LatLng mapCenter28 = new LatLng(16.413376, 102.832315);
                map.addMarker(new MarkerOptions().position(mapCenter28).title("Stop").snippet("หน้าเมือง").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter27, 15));
                map.addPolyline(new PolylineOptions().geodesic(true)
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
                );
                break;
            case "หลังหอกาฬ":
                LatLng mapCenter29 = new LatLng(16.440927, 102.819076);
                map.addMarker(new MarkerOptions().position(mapCenter29).title("Start").snippet("หลังหอกาฬ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                LatLng mapCenter30 = new LatLng(16.464089, 102.831887);
                map.addMarker(new MarkerOptions().position(mapCenter30).title("Stop").snippet("หลังหอกาฬ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter29, 15));
                map.addPolyline(new PolylineOptions().geodesic(true)
                        .add(new LatLng(16.440927, 102.819076))
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
                );
                break;
            case "เหล่านาดี":
                LatLng mapCenter31 = new LatLng(16.406098, 102.784713);
                map.addMarker(new MarkerOptions().position(mapCenter31).title("Start").snippet("เหล่านาดี").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                LatLng mapCenter32 = new LatLng(16.413339, 102.835190);
                map.addMarker(new MarkerOptions().position(mapCenter32).title("Stop").snippet("เหล่านาดี").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapCenter31, 15));
                map.addPolyline(new PolylineOptions().geodesic(true)
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
                        .add(new LatLng(16.411564, 102.809545))
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
                        .add(new LatLng(16.413339, 102.835190))
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
