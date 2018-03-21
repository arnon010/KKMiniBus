package com.app.arnont.kkminibus.activity;

import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import com.app.arnont.kkminibus.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapAllActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static final int ACCESS_FINE_LOCATION_INTENT_ID = 3;

    String strLatlng,strLatlng1,strLatlng2,strLatlng3,strLatlng4,strLatlng5,strLatlng6,strLatlng7,strLatlng8,
            strLatlng9,strLatlng10,strLatlng11,strLatlng12,strLatlng13,strLatlng14, strLatlng15;


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
        mMap.addMarker(new MarkerOptions().position(latLng).title("สาย 2 : บ้านโคกฟันโปง – บ้านโคกน้อย").snippet(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

        LatLng latLng1 = new LatLng(16.389369, 102.806185);
        mMap.addMarker(new MarkerOptions().position(latLng1).title("สาย 3 : บขส.3 – บ้านพรหมนิมิตร").snippet(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng1));

        LatLng latLng2 = new LatLng(16.498304, 102.832508);
        mMap.addMarker(new MarkerOptions().position(latLng2).title("สาย 4 : บขส.3 – บ้านหนองน้ำเกลี้ยง").snippet(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng2));

        LatLng latLng3 = new LatLng(16.426291, 102.827488);
        mMap.addMarker(new MarkerOptions().position(latLng3).title("สาย 5 : ตลาดหนองไผ่ล้อม – บ้านทุ่ม").snippet(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng3));

        LatLng latLng4 = new LatLng(16.425585, 102.834150);
        mMap.addMarker(new MarkerOptions().position(latLng4).title("สาย 6 : ตลาดเทศบาล 1 – บ้านเหล่านกชุม").snippet(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng4));

        LatLng latLng5 = new LatLng(16.389369, 102.806185);
        mMap.addMarker(new MarkerOptions().position(latLng5).title("สาย 8 : สามเหลี่ยม – บ้านดอนบม").snippet(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng5));

        LatLng latLng6 = new LatLng(16.389369, 102.806185);
        mMap.addMarker(new MarkerOptions().position(latLng6).title("สาย 10 : มหาวิทยาลัยขอนแก่น – สนามม้า").snippet(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng6));

        //มลิวรรณ

        LatLng latLng8 = new LatLng(16.389369, 102.806185);
        mMap.addMarker(new MarkerOptions().position(latLng8).title("สาย 12 : พิพิธภัณฑ์ – รร.ท่าพระวิทยายน").snippet(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng8));

        LatLng latLng9 = new LatLng(16.426794, 102.874816);
        mMap.addMarker(new MarkerOptions().position(latLng9).title("สาย 18 : โรงเรียนกัลยาณวัตร – บ้านโนนพอง").snippet(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng9));

        LatLng latLng10 = new LatLng(16.426291, 102.827488);
        mMap.addMarker(new MarkerOptions().position(latLng10).title("สาย 19 : ตลาดหนองไผ่ล้อม – บ้านโนนเรือง").snippet(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng10));

        LatLng latLng11 = new LatLng(16.426291, 102.827488);
        mMap.addMarker(new MarkerOptions().position(latLng11).title("สาย 20 : ตลาดหนองไผ่ล้อม – บ้านกลางฮุง").snippet(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng11));

        LatLng latLng12 = new LatLng(16.414864, 102.874371);
        mMap.addMarker(new MarkerOptions().position(latLng12).title("สาย 22 : บ้านหนองไฮ- บ้านดอนหญ้านาง").snippet(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng12));

        LatLng latLng13 = new LatLng(16.438631, 102.834744);
        mMap.addMarker(new MarkerOptions().position(latLng13).title("สาย 23 : ตลาดเทศบาล 1 – บ้านห้วยเตย").snippet(""));
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

        strLatlng = latLng.toString();
        strLatlng1 = latLng1.toString();
        strLatlng2 = latLng2.toString();
        strLatlng3 = latLng3.toString();
        strLatlng4 = latLng4.toString();
        strLatlng5 = latLng5.toString();
        strLatlng6 = latLng6.toString();
        strLatlng7 = latLng7.toString();
        strLatlng8 = latLng8.toString();
        strLatlng9 = latLng9.toString();
        strLatlng10 = latLng10.toString();
        strLatlng11 = latLng11.toString();
        strLatlng12 = latLng12.toString();
        strLatlng13 = latLng13.toString();
        strLatlng14 = latLng14.toString();
        strLatlng15 = latLng15.toString();



        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                if (marker.getTitle().equals("สาย 2 : บ้านโคกฟันโปง – บ้านโคกน้อย")) {
                    Toast.makeText(MapAllActivity.this, "Lat Lng is " + strLatlng7, Toast.LENGTH_SHORT).show();

                }
                else if (marker.getTitle().equals("สาย 3 : บขส.3 – บ้านพรหมนิมิตร")) {
                    Toast.makeText(MapAllActivity.this, "Lat Lng is " + strLatlng, Toast.LENGTH_SHORT).show();

                }else if (marker.getTitle().equals("สาย 4 : บขส.3 – บ้านหนองน้ำเกลี้ยง")) {
                    Toast.makeText(MapAllActivity.this, "Lat Lng is " + strLatlng, Toast.LENGTH_SHORT).show();

                }else if (marker.getTitle().equals("สาย 5 : ตลาดหนองไผ่ล้อม – บ้านทุ่ม")) {
                    Toast.makeText(MapAllActivity.this, "Lat Lng is " + strLatlng, Toast.LENGTH_SHORT).show();

                }else if (marker.getTitle().equals("สาย 6 : ตลาดเทศบาล 1 – บ้านเหล่านกชุม")) {
                    Toast.makeText(MapAllActivity.this, "Lat Lng is " + strLatlng, Toast.LENGTH_SHORT).show();

                }else if (marker.getTitle().equals("สาย 8 : สามเหลี่ยม – บ้านดอนบม")) {
                    Toast.makeText(MapAllActivity.this, "Lat Lng is " + strLatlng, Toast.LENGTH_SHORT).show();

                }else if (marker.getTitle().equals("สาย 10 : มหาวิทยาลัยขอนแก่น – สนามม้า")) {
                    Toast.makeText(MapAllActivity.this, "Lat Lng is " + strLatlng, Toast.LENGTH_SHORT).show();

                }else if (marker.getTitle().equals("สาย 12 : พิพิธภัณฑ์ – รร.ท่าพระวิทยายน")) {
                    Toast.makeText(MapAllActivity.this, "Lat Lng is " + strLatlng, Toast.LENGTH_SHORT).show();

                }else if (marker.getTitle().equals("สาย 18 : โรงเรียนกัลยาณวัตร – บ้านโนนพอง")) {
                    Toast.makeText(MapAllActivity.this, "Lat Lng is " + strLatlng, Toast.LENGTH_SHORT).show();

                }else if (marker.getTitle().equals("สาย 19 : ตลาดหนองไผ่ล้อม – บ้านโนนเรือง")) {
                    Toast.makeText(MapAllActivity.this, "Lat Lng is " + strLatlng, Toast.LENGTH_SHORT).show();

                }else if (marker.getTitle().equals("สาย 20 : ตลาดหนองไผ่ล้อม – บ้านกลางฮุง")) {
                    Toast.makeText(MapAllActivity.this, "Lat Lng is " + strLatlng, Toast.LENGTH_SHORT).show();

                }else if (marker.getTitle().equals("สาย 22 : บ้านหนองไฮ- บ้านดอนหญ้านาง")) {
                    Toast.makeText(MapAllActivity.this, "Lat Lng is " + strLatlng, Toast.LENGTH_SHORT).show();

                }else if (marker.getTitle().equals("สาย 23 : ตลาดเทศบาล 1 – บ้านห้วยเตย")) {
                    Toast.makeText(MapAllActivity.this, "Lat Lng is " + strLatlng, Toast.LENGTH_SHORT).show();

                }else if (marker.getTitle().equals("หลังหอกาฬ")) {
                    Toast.makeText(MapAllActivity.this, "Lat Lng is " + strLatlng, Toast.LENGTH_SHORT).show();

                }else if (marker.getTitle().equals("เหล่านาดี")) {
                    Toast.makeText(MapAllActivity.this, "Lat Lng is " + strLatlng, Toast.LENGTH_SHORT).show();

                }else if (marker.getTitle().equals("มลิวรรณ")) {
                    Toast.makeText(MapAllActivity.this, "Lat Lng is " + strLatlng, Toast.LENGTH_SHORT).show();

                }
            }
        });

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
