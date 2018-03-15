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
        LatLng latLng = new LatLng(16.438445, 102.836451);
        mMap.addMarker(new MarkerOptions().position(latLng).title("กลางเมือง"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

        LatLng latLng1 = new LatLng(16.428768, 102.851612);
        mMap.addMarker(new MarkerOptions().position(latLng1).title("ชาตะผดุง"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng1));

        LatLng latLng2 = new LatLng(16.415613, 102.822637);
        mMap.addMarker(new MarkerOptions().position(latLng2).title("ทางรถไฟ"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng2));

        LatLng latLng3 = new LatLng(16.428739, 102.854318);
        mMap.addMarker(new MarkerOptions().position(latLng3).title("บ้านบะขาม"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng3));

        LatLng latLng4 = new LatLng(16.414864, 102.874371);
        mMap.addMarker(new MarkerOptions().position(latLng4).title("บ้านหนองไฮ"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng4,14));

        LatLng latLng5 = new LatLng(16.427275, 102.870638);
        mMap.addMarker(new MarkerOptions().position(latLng5).title("ประชาสโมสร"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng5));

        LatLng latLng6 = new LatLng(16.421426, 102.820540);
        mMap.addMarker(new MarkerOptions().position(latLng6).title("ม - ภาค"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng6));

        LatLng latLng7 = new LatLng(16.439512, 102.828740);
        mMap.addMarker(new MarkerOptions().position(latLng7).title("มลิวรรณ"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng7));

        LatLng latLng8 = new LatLng(16.498304, 102.832508);
        mMap.addMarker(new MarkerOptions().position(latLng8).title("มิตรภาพ"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng8));

        LatLng latLng9 = new LatLng(16.462070, 102.798958);
        mMap.addMarker(new MarkerOptions().position(latLng9).title("ร - 8"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng9));

        LatLng latLng10 = new LatLng(16.406101, 102.839402);
        mMap.addMarker(new MarkerOptions().position(latLng10).title("รอบบึงแก่นนคร"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng10));

        LatLng latLng11 = new LatLng(16.426794, 102.874816);
        mMap.addMarker(new MarkerOptions().position(latLng11).title("ศรีจันทร์"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng11));

        LatLng latLng12 = new LatLng(16.438666, 102.834748);
        mMap.addMarker(new MarkerOptions().position(latLng12).title("ูนย์ราชการ - ทุ่งสร้าง"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng12));

        LatLng latLng13 = new LatLng(16.438631, 102.834744);
        mMap.addMarker(new MarkerOptions().position(latLng13).title("หน้าเมือง"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng13));

        LatLng latLng14 = new LatLng(16.440927, 102.819076);
        mMap.addMarker(new MarkerOptions().position(latLng14).title("หลังหอกาฬ"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng14));

        LatLng latLng15 = new LatLng(16.406098, 102.784713);
        mMap.addMarker(new MarkerOptions().position(latLng15).title("เหล่านาดี"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng15));

    }
}
