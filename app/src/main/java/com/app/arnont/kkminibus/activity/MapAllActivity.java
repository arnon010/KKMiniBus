package com.app.arnont.kkminibus.activity;

import android.annotation.TargetApi;
import android.content.Intent;
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
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

public class MapAllActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static final int ACCESS_FINE_LOCATION_INTENT_ID = 3;

    String[] nameArray = {
            "สาย 2 : บ้านโคกฟันโปง – บ้านโคกน้อย\n\nCentral",
            "สาย 3 : บขส.3 – บ้านพรหมนิมิตร\n\nTheMall",
            "สาย 4 : บขส.3 – บ้านหนองน้ำเกลี้ยง\n\nKK",
            "สาย 5 : ตลาดหนองไผ่ล้อม – บ้านทุ่ม\n\nSchool",
            "สาย 6 : ตลาดเทศบาล 1 – บ้านเหล่านกชุม\n\nFootball",
            "สาย 8 : สามเหลี่ยม – บ้านดอนบม\n\nCentral",
            "สาย 9 : สามเหลี่ยม – บ้านสะอาด\n\nTheMall",
            "สาย 10 : มหาวิทยาลัยขอนแก่น – สนามม้า\n\nKK",
            "สาย 11 : บ้านโนนสวรรค์ – บ้านขามเจริญ\n\nSchool",
            "สาย 12 : พิพิธภัณฑ์ – รร.ท่าพระวิทยายน\n\nFootball",
            "สาย 13 : บ้านน้อยนิเวศน์ – บ้านสว่างมรรคา\n\nCentral",
            "สาย 16 : บ้านโนนทัน – วัดป่าอดุลยาราม\n\nTheMall",
            "สาย 17 : บ้านโนนทัน – บ้านโคกท่า\n\nKK",
            "สาย 18 : โรงเรียนกัลยาณวัตร – บ้านโนนพอง\n\nSchool",
            "สาย 19 : ตลาดหนองไผ่ล้อม – บ้านโนนเรือง\n\nFootball",
            "สาย 20 : ตลาดหนองไผ่ล้อม – บ้านกลางฮุง\n\nCentral",
            "สาย 21 : บ้านโนนเขวา – บ้านดอนยาง\n\nTheMall",
            "สาย 22 : บ้านหนองไฮ- บ้านดอนหญ้านาง\n\nKK",
            "สาย 23 : ตลาดเทศบาล 1 – บ้านห้วยเตย\n\nSchool"};

    String[] infoArray = {
            "Central",
            "TheMall",
            "KK",
            "School",
            "Football",
            "Central",
            "TheMall",
            "KK",
            "School",
            "Football",
            "Central",
            "TheMall",
            "KK",
            "School",
            "Football",
            "Central",
            "TheMall",
            "KK",
            "School"
    };

    Integer[] imageArray = {
            R.drawable.ic_car2,
            R.drawable.ic_car3,
            R.drawable.ic_car4,
            R.drawable.ic_car5,
            R.drawable.ic_car6,
            R.drawable.ic_car8,
            R.drawable.ic_car9,
            R.drawable.ic_car10,
            R.drawable.ic_car11,
            R.drawable.ic_car12,
            R.drawable.ic_car13,
            R.drawable.ic_car16,
            R.drawable.ic_car17,
            R.drawable.ic_car18,
            R.drawable.ic_car19,
            R.drawable.ic_car20,
            R.drawable.ic_car21,
            R.drawable.ic_car22,
            R.drawable.ic_car23
    };


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
        final LatLng latLng = new LatLng(16.426794, 102.874816);
        mMap.addMarker(new MarkerOptions().position(latLng).title("สาย 2 : บ้านโคกฟันโปง – บ้านโคกน้อย").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_short)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

        LatLng latLng1 = new LatLng(16.389369, 102.806185);
        mMap.addMarker(new MarkerOptions().position(latLng1).title("สาย 3 : บขส.3 – บ้านพรหมนิมิตร").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_short)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng1));

        LatLng latLng2 = new LatLng(16.498304, 102.832508);
        mMap.addMarker(new MarkerOptions().position(latLng2).title("สาย 4 : บขส.3 – บ้านหนองน้ำเกลี้ยง").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_short)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng2));

        LatLng latLng3 = new LatLng(16.426291, 102.827488);
        mMap.addMarker(new MarkerOptions().position(latLng3).title("สาย 5 : ตลาดหนองไผ่ล้อม – บ้านทุ่ม").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_short)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng3));

        LatLng latLng5 = new LatLng(16.389369, 102.806185);
        mMap.addMarker(new MarkerOptions().position(latLng5).title("สาย 8 : สามเหลี่ยม – บ้านดอนบม").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_short)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng5));

        LatLng latLng14 = new LatLng(16.455835, 102.827421);
        mMap.addMarker(new MarkerOptions().position(latLng14).title("สาย 9 : สามเหลี่ยม – บ้านสะอาด").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_short)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng14));

        LatLng latLng6 = new LatLng(16.389369, 102.806185);
        mMap.addMarker(new MarkerOptions().position(latLng6).title("สาย 10 : มหาวิทยาลัยขอนแก่น – สนามม้า").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_short)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng6));

        LatLng latLng16 = new LatLng(16.409522, 102.781848);
        mMap.addMarker(new MarkerOptions().position(latLng16).title("สาย 11 : บ้านโนนสวรรค์ – บ้านขามเจริญ").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_short)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng16));

        LatLng latLng8 = new LatLng(16.389369, 102.806185);
        mMap.addMarker(new MarkerOptions().position(latLng8).title("สาย 12 : พิพิธภัณฑ์ – รร.ท่าพระวิทยายน").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_short)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng8));

        LatLng latLng15 = new LatLng(16.447973, 102.822856);
        mMap.addMarker(new MarkerOptions().position(latLng15).title("สาย 13 : บ้านน้อยนิเวศน์ – บ้านสว่างมรรคา").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_short)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng15));

        LatLng latLng17 = new LatLng(16.464537, 102.827373);
        mMap.addMarker(new MarkerOptions().position(latLng17).title("สาย 16 : บ้านโนนทัน – วัดป่าอดุลยาราม").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_long)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng17));

        LatLng latLng18 = new LatLng(16.389369, 102.806185);
        mMap.addMarker(new MarkerOptions().position(latLng18).title("สาย 17 : บ้านโนนทัน – บ้านโคกท่า").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_long)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng18));

        LatLng latLng9 = new LatLng(16.426794, 102.874816);
        mMap.addMarker(new MarkerOptions().position(latLng9).title("สาย 18 : โรงเรียนกัลยาณวัตร – บ้านโนนพอง").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_long)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng9));

        LatLng latLng10 = new LatLng(16.426291, 102.827488);
        mMap.addMarker(new MarkerOptions().position(latLng10).title("สาย 19 : ตลาดหนองไผ่ล้อม – บ้านโนนเรือง").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_long)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng10));

        LatLng latLng11 = new LatLng(16.426291, 102.827488);
        mMap.addMarker(new MarkerOptions().position(latLng11).title("สาย 20 : ตลาดหนองไผ่ล้อม – บ้านกลางฮุง").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_long)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng11));

        LatLng latLng19 = new LatLng(16.455550, 102.855093);
        mMap.addMarker(new MarkerOptions().position(latLng19).title("สาย 21 : บ้านโนนเขวา – บ้านดอนยาง").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_long)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng19));

        LatLng latLng12 = new LatLng(16.414864, 102.874371);
        mMap.addMarker(new MarkerOptions().position(latLng12).title("สาย 22 : บ้านหนองไฮ- บ้านดอนหญ้านาง").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_long)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng12));

        LatLng latLng13 = new LatLng(16.438631, 102.834744);
        mMap.addMarker(new MarkerOptions().position(latLng13).title("สาย 23 : ตลาดเทศบาล 1 – บ้านห้วยเตย").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_pin_marker)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng13));

        LatLng latLng4 = new LatLng(16.425585, 102.834150);
        mMap.addMarker(new MarkerOptions().position(latLng4).title("สาย 6 : ตลาดเทศบาล 1 – บ้านเหล่านกชุม").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_long)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng4, 14));

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                if (marker.getTitle().equals("สาย 2 : บ้านโคกฟันโปง – บ้านโคกน้อย")) {
                    Intent intent = new Intent(MapAllActivity.this, MapsDetailActivity.class);
                    String message = nameArray[0];
                    intent.putExtra("minibus", message);
                    String message2 = infoArray[0];
                    intent.putExtra("btsMinibus2", message2);
                    Integer message3 = imageArray[0];
                    intent.putExtra("image", message3);
                    startActivity(intent);
                    overridePendingTransition(R.anim.push_in, R.anim.push_in_exit);

                }
                else if (marker.getTitle().equals("สาย 3 : บขส.3 – บ้านพรหมนิมิตร")) {
                    Intent intent = new Intent(MapAllActivity.this, MapsDetailActivity.class);
                    String message = nameArray[1];
                    intent.putExtra("minibus", message);
                    String message2 = infoArray[1];
                    intent.putExtra("btsMinibus2", message2);
                    Integer message3 = imageArray[1];
                    intent.putExtra("image", message3);
                    startActivity(intent);
                    overridePendingTransition(R.anim.push_in, R.anim.push_in_exit);

                }else if (marker.getTitle().equals("สาย 4 : บขส.3 – บ้านหนองน้ำเกลี้ยง")) {
                    Intent intent = new Intent(MapAllActivity.this, MapsDetailActivity.class);
                    String message = nameArray[2];
                    intent.putExtra("minibus", message);
                    String message2 = infoArray[2];
                    intent.putExtra("btsMinibus2", message2);
                    Integer message3 = imageArray[2];
                    intent.putExtra("image", message3);
                    startActivity(intent);
                    overridePendingTransition(R.anim.push_in, R.anim.push_in_exit);

                }else if (marker.getTitle().equals("สาย 5 : ตลาดหนองไผ่ล้อม – บ้านทุ่ม")) {
                    Intent intent = new Intent(MapAllActivity.this, MapsDetailActivity.class);
                    String message = nameArray[3];
                    intent.putExtra("minibus", message);
                    String message2 = infoArray[3];
                    intent.putExtra("btsMinibus2", message2);
                    Integer message3 = imageArray[3];
                    intent.putExtra("image", message3);
                    startActivity(intent);
                    overridePendingTransition(R.anim.push_in, R.anim.push_in_exit);

                }else if (marker.getTitle().equals("สาย 6 : ตลาดเทศบาล 1 – บ้านเหล่านกชุม")) {
                    Intent intent = new Intent(MapAllActivity.this, MapsDetailActivity.class);
                    String message = nameArray[4];
                    intent.putExtra("minibus", message);
                    String message2 = infoArray[4];
                    intent.putExtra("btsMinibus2", message2);
                    Integer message3 = imageArray[4];
                    intent.putExtra("image", message3);
                    startActivity(intent);
                    overridePendingTransition(R.anim.push_in, R.anim.push_in_exit);

                }else if (marker.getTitle().equals("สาย 8 : สามเหลี่ยม – บ้านดอนบม")) {
                    Intent intent = new Intent(MapAllActivity.this, MapsDetailActivity.class);
                    String message = nameArray[5];
                    intent.putExtra("minibus", message);
                    String message2 = infoArray[5];
                    intent.putExtra("btsMinibus2", message2);
                    Integer message3 = imageArray[5];
                    intent.putExtra("image", message3);
                    startActivity(intent);
                    overridePendingTransition(R.anim.push_in, R.anim.push_in_exit);

                }else if (marker.getTitle().equals("สาย 9 : สามเหลี่ยม – บ้านสะอาด")) {
                    Intent intent = new Intent(MapAllActivity.this, MapsDetailActivity.class);
                    String message = nameArray[6];
                    intent.putExtra("minibus", message);
                    String message2 = infoArray[6];
                    intent.putExtra("btsMinibus2", message2);
                    Integer message3 = imageArray[6];
                    intent.putExtra("image", message3);
                    startActivity(intent);
                    overridePendingTransition(R.anim.push_in, R.anim.push_in_exit);
                }else if (marker.getTitle().equals("สาย 10 : มหาวิทยาลัยขอนแก่น – สนามม้า")) {
                    Intent intent = new Intent(MapAllActivity.this, MapsDetailActivity.class);
                    String message = nameArray[7];
                    intent.putExtra("minibus", message);
                    String message2 = infoArray[7];
                    intent.putExtra("btsMinibus2", message2);
                    Integer message3 = imageArray[7];
                    intent.putExtra("image", message3);
                    startActivity(intent);
                    overridePendingTransition(R.anim.push_in, R.anim.push_in_exit);

                }else if (marker.getTitle().equals("สาย 11 : บ้านโนนสวรรค์ – บ้านขามเจริญ")) {
                    Intent intent = new Intent(MapAllActivity.this, MapsDetailActivity.class);
                    String message = nameArray[8];
                    intent.putExtra("minibus", message);
                    String message2 = infoArray[8];
                    intent.putExtra("btsMinibus2", message2);
                    Integer message3 = imageArray[8];
                    intent.putExtra("image", message3);
                    startActivity(intent);
                    overridePendingTransition(R.anim.push_in, R.anim.push_in_exit);

                }
                else if (marker.getTitle().equals("สาย 12 : พิพิธภัณฑ์ – รร.ท่าพระวิทยายน")) {
                    Intent intent = new Intent(MapAllActivity.this, MapsDetailActivity.class);
                    String message = nameArray[9];
                    intent.putExtra("minibus", message);
                    String message2 = infoArray[9];
                    intent.putExtra("btsMinibus2", message2);
                    Integer message3 = imageArray[9];
                    intent.putExtra("image", message3);
                    startActivity(intent);
                    overridePendingTransition(R.anim.push_in, R.anim.push_in_exit);

                }else if (marker.getTitle().equals("สาย 13 : บ้านน้อยนิเวศน์ – บ้านสว่างมรรคา")) {
                    Intent intent = new Intent(MapAllActivity.this, MapsDetailActivity.class);
                    String message = nameArray[10];
                    intent.putExtra("minibus", message);
                    String message2 = infoArray[10];
                    intent.putExtra("btsMinibus2", message2);
                    Integer message3 = imageArray[10];
                    intent.putExtra("image", message3);
                    startActivity(intent);
                    overridePendingTransition(R.anim.push_in, R.anim.push_in_exit);

                }else if (marker.getTitle().equals("สาย 16 : บ้านโนนทัน – วัดป่าอดุลยาราม")) {
                    Intent intent = new Intent(MapAllActivity.this, MapsDetailActivity.class);
                    String message = nameArray[11];
                    intent.putExtra("minibus", message);
                    String message2 = infoArray[11];
                    intent.putExtra("btsMinibus2", message2);
                    Integer message3 = imageArray[11];
                    intent.putExtra("image", message3);
                    startActivity(intent);
                    overridePendingTransition(R.anim.push_in, R.anim.push_in_exit);

                }else if (marker.getTitle().equals("สาย 17 : บ้านโนนทัน – บ้านโคกท่า")) {
                    Intent intent = new Intent(MapAllActivity.this, MapsDetailActivity.class);
                    String message = nameArray[12];
                    intent.putExtra("minibus", message);
                    String message2 = infoArray[12];
                    intent.putExtra("btsMinibus2", message2);
                    Integer message3 = imageArray[12];
                    intent.putExtra("image", message3);
                    startActivity(intent);
                    overridePendingTransition(R.anim.push_in, R.anim.push_in_exit);

                }else if (marker.getTitle().equals("สาย 18 : โรงเรียนกัลยาณวัตร – บ้านโนนพอง")) {
                    Intent intent = new Intent(MapAllActivity.this, MapsDetailActivity.class);
                    String message = nameArray[13];
                    intent.putExtra("minibus", message);
                    String message2 = infoArray[13];
                    intent.putExtra("btsMinibus2", message2);
                    Integer message3 = imageArray[13];
                    intent.putExtra("image", message3);
                    startActivity(intent);
                    overridePendingTransition(R.anim.push_in, R.anim.push_in_exit);

                }else if (marker.getTitle().equals("สาย 19 : ตลาดหนองไผ่ล้อม – บ้านโนนเรือง")) {
                    Intent intent = new Intent(MapAllActivity.this, MapsDetailActivity.class);
                    String message = nameArray[14];
                    intent.putExtra("minibus", message);
                    String message2 = infoArray[14];
                    intent.putExtra("btsMinibus2", message2);
                    Integer message3 = imageArray[14];
                    intent.putExtra("image", message3);
                    startActivity(intent);
                    overridePendingTransition(R.anim.push_in, R.anim.push_in_exit);

                }else if (marker.getTitle().equals("สาย 20 : ตลาดหนองไผ่ล้อม – บ้านกลางฮุง")) {
                    Intent intent = new Intent(MapAllActivity.this, MapsDetailActivity.class);
                    String message = nameArray[15];
                    intent.putExtra("minibus", message);
                    String message2 = infoArray[15];
                    intent.putExtra("btsMinibus2", message2);
                    Integer message3 = imageArray[15];
                    intent.putExtra("image", message3);
                    startActivity(intent);
                    overridePendingTransition(R.anim.push_in, R.anim.push_in_exit);

                }else if (marker.getTitle().equals("สาย 21 : บ้านโนนเขวา – บ้านดอนยาง")) {
                    Intent intent = new Intent(MapAllActivity.this, MapsDetailActivity.class);
                    String message = nameArray[16];
                    intent.putExtra("minibus", message);
                    String message2 = infoArray[16];
                    intent.putExtra("btsMinibus2", message2);
                    Integer message3 = imageArray[16];
                    intent.putExtra("image", message3);
                    startActivity(intent);
                    overridePendingTransition(R.anim.push_in, R.anim.push_in_exit);

                }else if (marker.getTitle().equals("สาย 22 : บ้านหนองไฮ- บ้านดอนหญ้านาง")) {
                    Intent intent = new Intent(MapAllActivity.this, MapsDetailActivity.class);
                    String message = nameArray[17];
                    intent.putExtra("minibus", message);
                    String message2 = infoArray[17];
                    intent.putExtra("btsMinibus2", message2);
                    Integer message3 = imageArray[17];
                    intent.putExtra("image", message3);
                    startActivity(intent);
                    overridePendingTransition(R.anim.push_in, R.anim.push_in_exit);

                }else if (marker.getTitle().equals("สาย 23 : ตลาดเทศบาล 1 – บ้านห้วยเตย")) {
                    Intent intent = new Intent(MapAllActivity.this, MapsDetailActivity.class);
                    String message = nameArray[18];
                    intent.putExtra("minibus", message);
                    String message2 = infoArray[18];
                    intent.putExtra("btsMinibus2", message2);
                    Integer message3 = imageArray[18];
                    intent.putExtra("image", message3);
                    startActivity(intent);
                    overridePendingTransition(R.anim.push_in, R.anim.push_in_exit);

                }
            }
        });

        Polygon polygon = googleMap.addPolygon(new PolygonOptions()
                .clickable(true)
                .add(
                        new LatLng(16.519279, 102.797877),
                        new LatLng(16.510163, 102.917247),
                        new LatLng(16.365698, 102.880722),
                        new LatLng(16.384732, 102.761325)
                ));
        polygon.setTag("alpha");
        polygon.setStrokeColor(getResources().getColor(R.color.colorAccent));
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
