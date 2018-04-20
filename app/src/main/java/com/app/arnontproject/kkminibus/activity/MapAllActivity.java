package com.app.arnontproject.kkminibus.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Toolbar;

import com.akexorcist.localizationactivity.ui.LocalizationActivity;
import com.app.arnontproject.kkminibus.R;
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

public class MapAllActivity extends LocalizationActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static final int ACCESS_FINE_LOCATION_INTENT_ID = 3;

    String[] nameArray = {
            "สาย 2 : บ้านโคกฟันโปง – บ้านโคกน้อย\nบ.โคกฟันโปง, บ.หัวทุ่ง, บ.คำไฮ, เซ็นทรัลพลาซ่า ขอนแก่น, ศาลหลักเมือง ขอนแก่น, บขส.1, โรงเรียนขอนแก่นวิทยายน, ตลาดบางลำภู, ตลาดเทศบาล, โรงเรียนกัลยาณวัตร, สถานีตํารวจภูธรเมืองขอนแก่น, เซ็นโทซ่า, ไปรษณีย์ขอนแก่น, วัดศรีจันทร์, เรือนจำขอนแก่น, วิทยาลัยเทคนิคขอนแก่น, โรงพยาบาลศูนย์ขอนแก่น, มหาวิทยาลัยเทคโนโลยีราชมงคลอีสาน, ตลาดหนองใหญ่, บ.พระคือ, บ.หนองโพธิ์, บ.หนองแสง, บ.โคกน้อย",
            "สาย 3 : บขส.3 – บ้านพรหมนิมิตร\nบขส. 3, แม็คโคร ขอนแก่น, ประตูน้ำขอนแก่น, ตลาดอู้ฟู, โรงเรียนแก่นนครวิทยาลัย, ศาลหลักเมือง ขอนแก่น, เซ็นทรัลพลาซ่า ขอนแก่น, โรงบาลราชพฤกษ์ ขอนแก่น, บขส.1, โรงเรียนขอนแก่นวิทยายน, ตลาดบางลำภู, ตลาดเทศบาล, โรงเรียนกัลยาณวัตร, สถานีตํารวจภูธรเมืองขอนแก่น, ไปรษณีย์ขอนแก่น, วิทยาลัยเทคนิคขอนแก่น, มหาวิทยาลัยเทคโนโลยีราชมงคลอีสาน, ตลาดหนองใหญ่, บ.ท่าหิน, บ.พรหมนิมิตร",
            "สาย 4 : บขส.3 – บ้านหนองน้ำเกลี้ยง\nบขส.3, แม็คโคร ขอนแก่น, ประตูน้ำขอนแก่น, ตลาดอู้ฟู, ขอนแก่นแหอวน, โรงเรียนแก่นนครวิทยาลัย, โรงเรียนโสตศึกษาขอนแก่น, สนามกีฬากลางขอนแก่น, โรงเรียนเทศบาลวัดกลาง, แฟรี่พลาซ่า, ตลาดเทศบาล, ตลาดบางลำภู, โรงเรียนขอนแก่นวิทยายน, บขส.1, ศูนย์หัวใจสิริกิตขอนแก่น, โรงพยาบาลศรีนครินทร์, มหาวิทยาลัยขอนแก่น, โลตัสเอ็กซ์ตร้า, บ.สำราญ, บ.หนองน้ำเกลี้ยง",
            "สาย 5 : ตลาดหนองไผ่ล้อม – บ้านทุ่ม\nตลาดหนองไผ่ล้อม, ตลาดเทศบาล, ตลาดบางลำภู, โรงเรียนขอนแก่นวิทยายน, เซ็นโทซ่า, ศูนย์ประชุมกาญจนาภิเษก, มหาวิทยาลัยขอนแก่น, สถาบันพัฒนาฝีมือแรงงานขอนแก่น, บ.ทุ่ม",
            "สาย 6 : ตลาดเทศบาล 1 – บ้านเหล่านกชุม\nตลาดเทศบาล, เทศบาลนครขอนแก่น, ศาลหลักเมืองขอนแก่น, เซ็นทรัลพลาซ่าขอนแก่น, บิ๊กซีขอนแก่น, ตลาดต้นตาล, โฮมโปรขอนแก่น, แม็คโครขอนแก่น, ประตูน้ำขอนแก่น, เทสโก้โลตัสขอนแก่น, บขส.3, บ.กุดกว้าง, บ.ท่าพระ, บ.หนองหญ้าแพรก, บ.ท่าแร่, บ.โนนเขวา, บ.เหล่านกชุม",
            "สาย 8 : สามเหลี่ยม – บ้านดอนบม\nมหาวิทยาลัยขอนแก่น, เซ็นโทซ่า, บขส.1, บขส.2, สถานีตํารวจภูธรเมืองขอนแก่น, โรงเรียนขอนแก่นวิทยายน, โรงเรียนกัลยาณวัตร, ตลาดเทศบาล, แฟรี่พลาซ่า, เมืองเก่า, บึงแก่นนคร, บ.ดอนบม",
            "สาย 9 : สามเหลี่ยม – บ้านสะอาด\nบ.สามเหลี่ยม, บขส.1, บขส.2, โรงเรียนขอนแก่นวิทยายน, ไปรษณีย์ขอนแก่น, ตลาดเทศบาล, แฟรี่พลาซ่า, สนามกีฬากลางขอนแก่น, โรงเรียนแก่นนครวิทยาลัย, ตลาดต้นตาล, มหาวิทยาลัยภาคตะวันออกเฉียงเหนือ, บ.กอก, บ.โจด, บ.สะอาด",
            "สาย 10 : มหาวิทยาลัยขอนแก่น – สนามม้า\nมหาวิทยาลัยขอนแก่น, บขส.1, ที่ว่าการอําเภอเมืองขอนแก่น, บ.บะขาม, เรือนจำขอนแก่น, บขส.2, โรงเรียนขอนแก่นวิทยายน, ไปรษณีย์ขอนแก่น, สถานีตํารวจภูธรเมืองขอนแก่น, ตลาดเทศบาล, แฟรี่พลาซ่า, สนามกีฬากลางขอนแก่น, โรงเรียนแก่นนครวิทยาลัย, ประตูน้ำขอนแก่น, แม็คโครขอนแก่น, เทสโก้โลตัสขอนแก่น",
            "สาย 11 : บ้านโนนสวรรค์ – บ้านขามเจริญ\nบ.โนนสวรรค์, ตลาดหนองใหญ่, วิทยาลัยอาชีวศึกษาขอนแก่น, บขส.2, โรงเรียนขอนแก่นวิทยายน, ตึกคอมขอนแก่น, เทศบาลนครขอนแก่น, ตลาดต้นตาล, บ.โคกฟันโปง",
            "สาย 12 : พิพิธภัณฑ์ – รร.ท่าพระวิทยายน\nศาลากลางจังหวัดขอนแก่น, บขส.1, โรงเรียนขอนแก่นวิทยายน, ตลาดบางลำภู, ตลาดเทศบาล, โรงเรียนแก่นนครวิทยาลัย, ประตูน้ำขอนแก่น, เทสโก้โลตัสขอนแก่น, บขส.3, บ.โนนตุ่น, บ.กุดกว้าง, บ.ท่าพระ, บ.หนองบัวดีหมี",
            "สาย 13 : บ้านน้อยนิเวศน์ – บ้านสว่างมรรคา\nบ้านน้อยนิเวศน์, บขส.1, ตลาด อ.จิระ ขอนแก่น, ตึกคอมขอนแก่น, โรงเรียนกัลยาณวัตรม, ตลาดเทศบาล, โรงเรียนเทศบาลสวนสนุก, บึงแก่นนคร, บ.ตูม, บ.ดอนบม, บ.ดอนแดง, บ้านดอนหัน",
            "สาย 16 : บ้านโนนทัน – วัดป่าอดุลยาราม\nบ.โนนทัน, ตลาดโนนทัน, โรงพยาบาลจิตเวชขอนแก่น, เรือนจำขอนแก่น, โรงเรียนกัลยาณวัตร, บขส.1, บ.สามเหลี่ยม",
            "สาย 17 : บ้านโนนทัน – บ้านโคกท่า\nบ.โนนทัน, บึงแก่นนคร, โรงเรียนเทศบาลสวนสนุก, แฟรี่พลาซ่า, ตลาดเทศบาล, โรงเรียนกัลยาณวัตร, วิทยาลัยอาชีวศึกษาขอนแก่น, ตลาดบ้านดอน, ค่ายศรีพัชรินทร์, โรงเรียนขามแก่นนคร, บ.โกทา, บ.หนองหิน, บ.ห้วยชัน, บ.โคกท่า",
            "สาย 18 : โรงเรียนกัลยาณวัตร – บ้านโนนพอง\nโรงเรียนกัลยาณวัตร, เรือนจำขอนแก่น, วิทยาลัยเทคนิคขอนแก่น, โรงพยาบาลศูนย์ขอนแก่น, มหาวิทยาลัยเทคโนโลยีราชมงคลอีสาน, ตลาดหนองใหญ่, บ.แอ่วมอง, บ.สงเปือย, บ.โนนพอง",
            "สาย 19 : ตลาดหนองไผ่ล้อม – บ้านโนนเรือง\nตลาดหนองไผ่ล้อม, ตลาดเทศบาล, ตลาดบางลำภู, โรงเรียนขอนแก่นวิทยายน, >บขส.1, ศูนย์หัวใจสิริกิตขอนแก่น, โรงพยาบาลศรีนครินทร์ขอนแก่น, มหาวิทยาลัยขอนแก่น, โลตัสเอ็กซ์ตร้า, บ.โนนเมือง, บ.โนนเรือง",
            "สาย 20 : ตลาดหนองไผ่ล้อม – บ้านกลางฮุง\nตลาดหนองไผ่ล้อม, ตลาดเทศบาล, ตลาดบางลำภู, โรงเรียนขอนแก่นวิทยายน, บขส.1, ศูนย์หัวใจสิริกิตขอนแก่น, โรงพยาบาลศรีนครินทร์ขอนแก่น, มหาวิทยาลัยขอนแก่น, โลตัสเอ็กซ์ตร้า, บ.โคกนางาม, บ.หนองค้า, บ.กลางฮุง",
            "สาย 21 : บ้านโนนเขวา – บ้านดอนยาง\nบ.โนนเขวา, บ.เหล่านกชุม, บ.บือ, บ.โนนทัน, บึงแก่นนคร, แฟรี่พลาซ่า, ตลาดเทศบาล, โรงเรียนกัลยาณวัตร, สถานีตํารวจภูธรเมืองขอนแก่น, โรงเรียนขอนแก่นวิทยายน, บขส.1, ศาลากลางจังหวัดขอนแก่น, ตลาดบ้านดอน, บ.ดองยาง",
            "สาย 22 : บ้านหนองไฮ- บ้านดอนหญ้านาง\nบ.หนองไฮ, ตลาดหนองใหญ่, โรงพยาบาลศูนย์ขอนแก่น, เรือนจำขอนแก่น, สถานีตํารวจภูธรเมืองขอนแก่น, ตลาดเทศบาล, ตลาดบางลำภู, โรงเรียนขอนแก่นวิทยายน, บขส.1, ไปรษณีย์ขอนแก่น, บ.ดอนหญ้านาง",
            "สาย 23 : ตลาดเทศบาล 1 – บ้านห้วยเตย\nตลาดเทศบาล, ตลาดเทศบาล, บ.โนนตุ่น, บ.ท่าพระ, บ.หนองบัวดีหมี, บ.หนองแวง, บ.ห้วยเตย"};

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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
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

        // Landmark
        LatLng latlngLandmark1 = new LatLng(16.439787, 102.833387);
        mMap.addMarker(new MarkerOptions().position(latlngLandmark1).title("บขส.1").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latlngLandmark1));

        LatLng latLngLandmark2 = new LatLng(16.432643, 102.835542);
        mMap.addMarker(new MarkerOptions().position(latLngLandmark2).title("โรงเรียนขอนแก่นวิทยายน").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark2));

        LatLng latLngLandmark3 = new LatLng(16.433139, 102.836696);
        mMap.addMarker(new MarkerOptions().position(latLngLandmark3).title("บนส.2 ปรับอากาศ").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark3));

        LatLng latLngLandmark4 = new LatLng(16.429768, 102.835821);
        mMap.addMarker(new MarkerOptions().position(latLngLandmark4).title("ไปรษณีย์ขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark4));

        LatLng latLngLandmark5 = new LatLng(16.427702, 102.835688);
        mMap.addMarker(new MarkerOptions().position(latLngLandmark5).title("โรงเรียนกัลยาณวัตร").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark5));

        LatLng latLngLandmark6 = new LatLng(16.423187, 102.833898);
        mMap.addMarker(new MarkerOptions().position(latLngLandmark6).title("แฟรี่ พลาซ่า").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark6));

        LatLng latLngLandmark7 = new LatLng(16.421009, 102.834317);
        mMap.addMarker(new MarkerOptions().position(latLngLandmark7).title("โรงเรียนเทศบาลสวนสนุก").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark7));

        LatLng latLngLandmark8 = new LatLng(16.412796, 102.831346);
        mMap.addMarker(new MarkerOptions().position(latLngLandmark8).title("โรงเรียนเทศบาลวันกลาง").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark8));

        LatLng latLngLandmark9 = new LatLng(16.412861, 102.828258);
        mMap.addMarker(new MarkerOptions().position(latLngLandmark9).title("สนามกิฬากลาง").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark9));

        LatLng latLngLandmark10 = new LatLng(16.415030, 102.826293);
        mMap.addMarker(new MarkerOptions().position(latLngLandmark10).title("โรงเรียนโสตศึกษา").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark10));

        LatLng latLngLandmark11 = new LatLng(16.415910, 102.823410);
        mMap.addMarker(new MarkerOptions().position(latLngLandmark11).title("โรงเรียนแก่นนครวิทยาลัย").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark11));

        LatLng latLngLandmark12 = new LatLng(16.433089, 102.825491);
        mMap.addMarker(new MarkerOptions().position(latLngLandmark12).title("เซ็นทรัลพลาซ่าขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark12));

        LatLng latLngLandmark13 = new LatLng(16.431226, 102.823968);
        mMap.addMarker(new MarkerOptions().position(latLngLandmark13).title("สวนเรืองแสง").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark13));

        LatLng latLngLandmark14 = new LatLng(16.436080, 102.830291);
        mMap.addMarker(new MarkerOptions().position(latLngLandmark14).title("คอฟฟี่ เด้อ หล่า : โอโซนวิลเลจ").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark14));

        LatLng latLngLandmark15 = new LatLng(16.408328, 102.834224);
        mMap.addMarker(new MarkerOptions().position(latLngLandmark15).title("วัดหนองแวง / พระมหาธาตุแก่นนคร").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark15));

        LatLng latLngLandmark16 = new LatLng(16.415549, 102.820259);
        mMap.addMarker(new MarkerOptions().position(latLngLandmark16).title("วัดหนองแวง / พระมหาธาตุแก่นนคร").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark16));

        LatLng latLngLandmark17 = new LatLng(16.404426, 102.813128);
        mMap.addMarker(new MarkerOptions().position(latLngLandmark17).title("ประตูน้ำขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark17));

        LatLng latLngLandmark18 = new LatLng(16.401231, 102.816647);
        mMap.addMarker(new MarkerOptions().position(latLngLandmark18).title("เทสโก้ โลตัส ขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark18));

        LatLng latLngLandmark19 = new LatLng(16.491685, 102.831488);
        mMap.addMarker(new MarkerOptions().position(latLngLandmark19).title("เทสโก้ โลตัส เอ็กซ์ตร้า").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark19));

        LatLng latLngLandmark20 = new LatLng(16.477894, 102.822860);
        mMap.addMarker(new MarkerOptions().position(latLngLandmark20).title("มหาวิทยาลัยขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark20));

        LatLng latLngLandmark21 = new LatLng(16.418840, 102.818618);
        mMap.addMarker(new MarkerOptions().position(latLngLandmark21).title("ตลาดต้นตาล").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark21));

        LatLng latLngLandmark22 = new LatLng(16.410074, 102.816836);
        mMap.addMarker(new MarkerOptions().position(latLngLandmark22).title("ตลาดอู้ฟู่").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark22));

        LatLng latLngLandmark23 = new LatLng(16.424943, 102.818906);
        mMap.addMarker(new MarkerOptions().position(latLngLandmark23).title("บิ๊ก ซี ขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark23));

        LatLng latLngLandmark24 = new LatLng(16.468368, 102.829854);
        mMap.addMarker(new MarkerOptions().position(latLngLandmark24).title("โรงพยาบาลศรีนครินทร์").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_hospital)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark24));

        LatLng latLngLandmark25 = new LatLng(16.427165, 102.834823);
        mMap.addMarker(new MarkerOptions().position(latLngLandmark25).title("ตลาดเทศบาล 1").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark25));

        LatLng latLngLandmark26 = new LatLng(16.428887, 102.835099);
        mMap.addMarker(new MarkerOptions().position(latLngLandmark26).title("ตลาดบางลำพู").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_market)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark26));

        LatLng latLngLandmark27 = new LatLng(16.428676, 102.847660);
        mMap.addMarker(new MarkerOptions().position(latLngLandmark27).title("วิทยาลัยเทคนิคขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark27));

        LatLng latLngLandmark28 = new LatLng(16.428642, 102.863618);
        mMap.addMarker(new MarkerOptions().position(latLngLandmark28).title("มหาวิทยาลัยเทคโนโลยีราชมงคลอีสาน").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark28));

        LatLng latLngLandmark29 = new LatLng(16.428680, 102.836164);
        mMap.addMarker(new MarkerOptions().position(latLngLandmark29).title("สถานีตำรวจภูธรเมืองขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark29));

        LatLng latLngLandmark30 = new LatLng(16.435663, 102.824102);
        mMap.addMarker(new MarkerOptions().position(latLngLandmark30).title("โรงพยาบาลราชพฤกษ์").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_hospital)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark30));

        LatLng latLngLandmark31 = new LatLng(16.433224, 102.821034);
        mMap.addMarker(new MarkerOptions().position(latLngLandmark31).title("โรงพยาบาลขอนแก่นราม").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_hospital)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark31));

        LatLng latLngLandmark32 = new LatLng(16.429394, 102.848246);
        mMap.addMarker(new MarkerOptions().position(latLngLandmark32).title("โรงพยาบาลศูนย์ขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_hospital)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark32));

        LatLng latLngLandmark33 = new LatLng(16.390041, 102.804180);
        mMap.addMarker(new MarkerOptions().position(latLngLandmark33).title("บขส. 3").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark33));

        LatLng latLngLandmark34 = new LatLng(16.405161, 102.814430);
        mMap.addMarker(new MarkerOptions().position(latLngLandmark34).title("แม็คโคร ขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark34));

        LatLng latLngLandmark35 = new LatLng(16.442495, 102.836309);
        mMap.addMarker(new MarkerOptions().position(latLngLandmark35).title("ศาลากลาง จังหวัดขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark35));

        LatLng latLngLandmark36 = new LatLng( 16.430006, 102.829495);
        mMap.addMarker(new MarkerOptions().position(latLngLandmark36).title("เทศบาลนครขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_home)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark36));

        LatLng latLngLandmark37 = new LatLng( 16.438297, 102.839755);
        mMap.addMarker(new MarkerOptions().position(latLngLandmark37).title("ที่ว่าการอำเภอขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark37));

        LatLng latLngLandmark38 = new LatLng( 16.437569, 102.838971);
        mMap.addMarker(new MarkerOptions().position(latLngLandmark38).title("วิทยาลัย อาชีวศึกษา ขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_school)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark38));

        LatLng latLngLandmark39 = new LatLng( 16.430244, 102.832277);
        mMap.addMarker(new MarkerOptions().position(latLngLandmark39).title("ตึกคอม ขอนแก่น").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_star)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngLandmark39));



        // Mini Bus
        LatLng latLng = new LatLng(16.426794, 102.874816);
        mMap.addMarker(new MarkerOptions().position(latLng).title("สาย 2 : บ้านโคกฟันโปง – บ้านโคกน้อย").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

        LatLng latLng1 = new LatLng(16.389369, 102.806185);
        mMap.addMarker(new MarkerOptions().position(latLng1).title("สาย 3 : บขส.3 – บ้านพรหมนิมิตร").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng1));

        LatLng latLng2 = new LatLng(16.498304, 102.832508);
        mMap.addMarker(new MarkerOptions().position(latLng2).title("สาย 4 : บขส.3 – บ้านหนองน้ำเกลี้ยง").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng2));

        LatLng latLng3 = new LatLng(16.426291, 102.827488);
        mMap.addMarker(new MarkerOptions().position(latLng3).title("สาย 5 : ตลาดหนองไผ่ล้อม – บ้านทุ่ม").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng3));

        LatLng latLng5 = new LatLng(16.389369, 102.806185);
        mMap.addMarker(new MarkerOptions().position(latLng5).title("สาย 8 : สามเหลี่ยม – บ้านดอนบม").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng5));

        LatLng latLng14 = new LatLng(16.455835, 102.827421);
        mMap.addMarker(new MarkerOptions().position(latLng14).title("สาย 9 : สามเหลี่ยม – บ้านสะอาด").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng14));

        LatLng latLng6 = new LatLng(16.389369, 102.806185);
        mMap.addMarker(new MarkerOptions().position(latLng6).title("สาย 10 : มหาวิทยาลัยขอนแก่น – สนามม้า").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng6));

        LatLng latLng16 = new LatLng(16.409522, 102.781848);
        mMap.addMarker(new MarkerOptions().position(latLng16).title("สาย 11 : บ้านโนนสวรรค์ – บ้านขามเจริญ").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng16));

        LatLng latLng8 = new LatLng(16.389369, 102.806185);
        mMap.addMarker(new MarkerOptions().position(latLng8).title("สาย 12 : พิพิธภัณฑ์ – รร.ท่าพระวิทยายน").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng8));

        LatLng latLng15 = new LatLng(16.447973, 102.822856);
        mMap.addMarker(new MarkerOptions().position(latLng15).title("สาย 13 : บ้านน้อยนิเวศน์ – บ้านสว่างมรรคา").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng15));

        LatLng latLng17 = new LatLng(16.464537, 102.827373);
        mMap.addMarker(new MarkerOptions().position(latLng17).title("สาย 16 : บ้านโนนทัน – วัดป่าอดุลยาราม").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng17));

        LatLng latLng18 = new LatLng(16.389369, 102.806185);
        mMap.addMarker(new MarkerOptions().position(latLng18).title("สาย 17 : บ้านโนนทัน – บ้านโคกท่า").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng18));

        LatLng latLng9 = new LatLng(16.426794, 102.874816);
        mMap.addMarker(new MarkerOptions().position(latLng9).title("สาย 18 : โรงเรียนกัลยาณวัตร – บ้านโนนพอง").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng9));

        LatLng latLng10 = new LatLng(16.426291, 102.827488);
        mMap.addMarker(new MarkerOptions().position(latLng10).title("สาย 19 : ตลาดหนองไผ่ล้อม – บ้านโนนเรือง").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng10));

        LatLng latLng11 = new LatLng(16.426291, 102.827488);
        mMap.addMarker(new MarkerOptions().position(latLng11).title("สาย 20 : ตลาดหนองไผ่ล้อม – บ้านกลางฮุง").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng11));

        LatLng latLng19 = new LatLng(16.455550, 102.855093);
        mMap.addMarker(new MarkerOptions().position(latLng19).title("สาย 21 : บ้านโนนเขวา – บ้านดอนยาง").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng19));

        LatLng latLng12 = new LatLng(16.414864, 102.874371);
        mMap.addMarker(new MarkerOptions().position(latLng12).title("สาย 22 : บ้านหนองไฮ- บ้านดอนหญ้านาง").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng12));

        LatLng latLng13 = new LatLng(16.438631, 102.834744);
        mMap.addMarker(new MarkerOptions().position(latLng13).title("สาย 23 : ตลาดเทศบาล 1 – บ้านห้วยเตย").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng13));

        LatLng latLng4 = new LatLng(16.425585, 102.834150);
        mMap.addMarker(new MarkerOptions().position(latLng4).title("สาย 6 : ตลาดเทศบาล 1 – บ้านเหล่านกชุม").snippet("").icon(BitmapDescriptorFactory.fromResource(R.drawable.pin_bus)));
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
