package com.app.arnontproject.kkminibus.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.akexorcist.localizationactivity.ui.LocalizationActivity;
import com.app.arnontproject.kkminibus.R;
import com.app.arnontproject.kkminibus.adapter.CustomListAdapter;
import com.app.arnontproject.kkminibus.adapter.MiniBus;

import java.util.ArrayList;
import java.util.List;

public class DetailLandMarkFromMapAllActivity extends LocalizationActivity {


    TextView txtLandMarkDetail;
    private ArrayAdapter<MiniBus> adapter;
    Toolbar toolbar;
    String txtFix;


    private List<MiniBus> miniBus;
    ArrayList<MiniBus> mAllData= new ArrayList<>();

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


    ListView listView;
    CustomListAdapter listAdapter;
    TextView firstLine;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_land_mark_from_map_all);
        toolbar = findViewById(R.id.toolbarLandMark);
        toolbar.setTitle(R.string.your_land_marker);
        setActionBar(toolbar);
        getSupportActionBar().hide();
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        firstLine = findViewById(R.id.firstLine);



        String savedExtra = getIntent().getStringExtra("place");
        txtLandMarkDetail = findViewById(R.id.txtLandMarkDetail);
        txtLandMarkDetail.setText(savedExtra);

        txtFix = txtLandMarkDetail.getText().toString();

        populateDrinksList();
        listAdapter = new CustomListAdapter(getApplicationContext(),R.layout.listview_layout,miniBus);
        listView = findViewById(R.id.listViewLandMarkDetail);
        listView.setAdapter(listAdapter);
        listView.setTextFilterEnabled(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(DetailLandMarkFromMapAllActivity.this, MapsDetailActivity.class);
                String message = nameArray[position];
                intent.putExtra("minibus", message);
                String message2 = infoArray[position];
                intent.putExtra("btsMinibus2", message2);
                Integer message3 = imageArray[position];
                intent.putExtra("image", message3);
                startActivity(intent);
                overridePendingTransition(R.anim.push_in, R.anim.push_in_exit);
            }
        });
        LayoutAnimationController lac = new LayoutAnimationController(AnimationUtils.loadAnimation(this, R.anim.pop_out), 0.5f); //0.5f == time between appearance of listview items.
        listView.setLayoutAnimation(lac);
        listView.startLayoutAnimation();



    }

    private void populateDrinksList() {


        switch (txtFix) {
            case "บขส.1":
                miniBus = new ArrayList<>();
                miniBus.add(new MiniBus(nameArray[0],infoArray[0],imageArray[0]));
                miniBus.add(new MiniBus(nameArray[2],infoArray[2] ,imageArray[2]));
                miniBus.add(new MiniBus(nameArray[5],infoArray[5] ,imageArray[5]));
                miniBus.add(new MiniBus(nameArray[6],infoArray[6] ,imageArray[6]));
                miniBus.add(new MiniBus(nameArray[7],infoArray[7] ,imageArray[7]));
                miniBus.add(new MiniBus(nameArray[9],infoArray[9] ,imageArray[9]));
                miniBus.add(new MiniBus(nameArray[10],infoArray[10] ,imageArray[10]));
                miniBus.add(new MiniBus(nameArray[11],infoArray[11] ,imageArray[11]));
                miniBus.add(new MiniBus(nameArray[14],infoArray[14] ,imageArray[14]));
                miniBus.add(new MiniBus(nameArray[15],infoArray[15] ,imageArray[15]));
                miniBus.add(new MiniBus(nameArray[16],infoArray[16] ,imageArray[16]));
                miniBus.add(new MiniBus(nameArray[17],infoArray[17] ,imageArray[17]));
                mAllData.addAll(miniBus);
                listView = findViewById(R.id.listViewLandMarkDetail);
                adapter = new CustomListAdapter(this,
                        R.layout.listview_layout, miniBus);
                listView.setAdapter(adapter);
                break;
            case "โรงเรียนขอนแก่นวิทยายน":
                miniBus = new ArrayList<>();
                miniBus.add(new MiniBus(nameArray[0],infoArray[0],imageArray[0]));
                miniBus.add(new MiniBus(nameArray[1],infoArray[1] ,imageArray[1]));
                miniBus.add(new MiniBus(nameArray[2],infoArray[2] ,imageArray[2]));
                miniBus.add(new MiniBus(nameArray[3],infoArray[3] ,imageArray[3]));
                miniBus.add(new MiniBus(nameArray[5],infoArray[5] ,imageArray[5]));
                miniBus.add(new MiniBus(nameArray[6],infoArray[6] ,imageArray[6]));
                miniBus.add(new MiniBus(nameArray[7],infoArray[7] ,imageArray[7]));
                miniBus.add(new MiniBus(nameArray[8],infoArray[8] ,imageArray[8]));
                miniBus.add(new MiniBus(nameArray[9],infoArray[9] ,imageArray[9]));
                miniBus.add(new MiniBus(nameArray[14],infoArray[14] ,imageArray[14]));
                miniBus.add(new MiniBus(nameArray[15],infoArray[15] ,imageArray[15]));
                miniBus.add(new MiniBus(nameArray[16],infoArray[16] ,imageArray[16]));
                miniBus.add(new MiniBus(nameArray[17],infoArray[17] ,imageArray[17]));
                mAllData.addAll(miniBus);
                listView = findViewById(R.id.listViewLandMarkDetail);
                adapter = new CustomListAdapter(this,
                        R.layout.listview_layout, miniBus);
                listView.setAdapter(adapter);
                break;
            case "บขส.2 ปรับอากาศ":
                miniBus = new ArrayList<>();
                miniBus.add(new MiniBus(nameArray[5],infoArray[5],imageArray[5]));
                miniBus.add(new MiniBus(nameArray[6],infoArray[6] ,imageArray[6]));
                miniBus.add(new MiniBus(nameArray[7],infoArray[7] ,imageArray[7]));
                miniBus.add(new MiniBus(nameArray[8],infoArray[8] ,imageArray[8]));
                mAllData.addAll(miniBus);
                listView = findViewById(R.id.listViewLandMarkDetail);
                adapter = new CustomListAdapter(this,
                        R.layout.listview_layout, miniBus);
                listView.setAdapter(adapter);
                break;
            case "ไปรษณีย์ขอนแก่น":
                miniBus = new ArrayList<>();
                miniBus.add(new MiniBus(nameArray[0],infoArray[0],imageArray[0]));
                miniBus.add(new MiniBus(nameArray[1],infoArray[1] ,imageArray[1]));
                miniBus.add(new MiniBus(nameArray[6],infoArray[6] ,imageArray[6]));
                miniBus.add(new MiniBus(nameArray[7],infoArray[7] ,imageArray[7]));
                miniBus.add(new MiniBus(nameArray[17],infoArray[17] ,imageArray[17]));
                mAllData.addAll(miniBus);
                listView = findViewById(R.id.listViewLandMarkDetail);
                adapter = new CustomListAdapter(this,
                        R.layout.listview_layout, miniBus);
                listView.setAdapter(adapter);
                break;
            case "โรงเรียนกัลยาณวัตร":
                miniBus = new ArrayList<>();
                miniBus.add(new MiniBus(nameArray[0],infoArray[0],imageArray[0]));
                miniBus.add(new MiniBus(nameArray[1],infoArray[1] ,imageArray[1]));
                miniBus.add(new MiniBus(nameArray[5],infoArray[5] ,imageArray[5]));
                miniBus.add(new MiniBus(nameArray[10],infoArray[10] ,imageArray[10]));
                miniBus.add(new MiniBus(nameArray[11],infoArray[11] ,imageArray[11]));
                miniBus.add(new MiniBus(nameArray[12],infoArray[12] ,imageArray[12]));
                miniBus.add(new MiniBus(nameArray[13],infoArray[13] ,imageArray[13]));
                miniBus.add(new MiniBus(nameArray[16],infoArray[16] ,imageArray[16]));
                mAllData.addAll(miniBus);
                listView = findViewById(R.id.listViewLandMarkDetail);
                adapter = new CustomListAdapter(this,
                        R.layout.listview_layout, miniBus);
                listView.setAdapter(adapter);
                break;
            case "แฟรี่พลาซ่า":
                miniBus = new ArrayList<>();
                miniBus.add(new MiniBus(nameArray[2],infoArray[2],imageArray[2]));
                miniBus.add(new MiniBus(nameArray[6],infoArray[6] ,imageArray[6]));
                miniBus.add(new MiniBus(nameArray[7],infoArray[7] ,imageArray[7]));
                miniBus.add(new MiniBus(nameArray[12],infoArray[12] ,imageArray[12]));
                miniBus.add(new MiniBus(nameArray[16],infoArray[16] ,imageArray[16]));
                mAllData.addAll(miniBus);
                listView = findViewById(R.id.listViewLandMarkDetail);
                adapter = new CustomListAdapter(this,
                        R.layout.listview_layout, miniBus);
                listView.setAdapter(adapter);
                break;
            case "โรงเรียนเทศบาลสวนสนุก":
                miniBus = new ArrayList<>();
                miniBus.add(new MiniBus(nameArray[10],infoArray[10],imageArray[10]));
                miniBus.add(new MiniBus(nameArray[12],infoArray[12],imageArray[12]));
                mAllData.addAll(miniBus);
                listView = findViewById(R.id.listViewLandMarkDetail);
                adapter = new CustomListAdapter(this,
                        R.layout.listview_layout, miniBus);
                listView.setAdapter(adapter);
                break;
            case "โรงเรียนเทศบาลวัดกลาง":
                miniBus = new ArrayList<>();
                miniBus.add(new MiniBus(nameArray[2],infoArray[2],imageArray[2]));
                mAllData.addAll(miniBus);
                listView = findViewById(R.id.listViewLandMarkDetail);
                adapter = new CustomListAdapter(this,
                        R.layout.listview_layout, miniBus);
                listView.setAdapter(adapter);
                break;
            case "สนามกีฬากลาง":
                miniBus = new ArrayList<>();
                miniBus.add(new MiniBus(nameArray[2],infoArray[2],imageArray[2]));
                miniBus.add(new MiniBus(nameArray[6],infoArray[6],imageArray[6]));
                miniBus.add(new MiniBus(nameArray[7],infoArray[7],imageArray[7]));
                mAllData.addAll(miniBus);
                listView = findViewById(R.id.listViewLandMarkDetail);
                adapter = new CustomListAdapter(this,
                        R.layout.listview_layout, miniBus);
                listView.setAdapter(adapter);
                break;
            case "โรงเรียนโสตศึกษา":
                miniBus = new ArrayList<>();
                miniBus.add(new MiniBus(nameArray[2],infoArray[2],imageArray[2]));
                mAllData.addAll(miniBus);
                listView = findViewById(R.id.listViewLandMarkDetail);
                adapter = new CustomListAdapter(this,
                        R.layout.listview_layout, miniBus);
                listView.setAdapter(adapter);
                break;
            case "โรงเรียนแก่นนครวิทยาลัย":
                miniBus = new ArrayList<>();
                miniBus.add(new MiniBus(nameArray[1],infoArray[1],imageArray[1]));
                miniBus.add(new MiniBus(nameArray[2],infoArray[2],imageArray[2]));
                miniBus.add(new MiniBus(nameArray[6],infoArray[6],imageArray[6]));
                miniBus.add(new MiniBus(nameArray[7],infoArray[7],imageArray[7]));
                miniBus.add(new MiniBus(nameArray[9],infoArray[9],imageArray[9]));
                mAllData.addAll(miniBus);
                listView = findViewById(R.id.listViewLandMarkDetail);
                adapter = new CustomListAdapter(this,
                        R.layout.listview_layout, miniBus);
                listView.setAdapter(adapter);
                break;
            case "เซ็นทรัลพลาซ่าขอนแก่น":
                miniBus = new ArrayList<>();
                miniBus.add(new MiniBus(nameArray[1],infoArray[1],imageArray[1]));
                miniBus.add(new MiniBus(nameArray[4],infoArray[4],imageArray[4]));
                mAllData.addAll(miniBus);
                listView = findViewById(R.id.listViewLandMarkDetail);
                adapter = new CustomListAdapter(this,
                        R.layout.listview_layout, miniBus);
                listView.setAdapter(adapter);
                break;
            case "ประตูน้ำขอนแก่น":
                miniBus = new ArrayList<>();
                miniBus.add(new MiniBus(nameArray[1],infoArray[1],imageArray[1]));
                miniBus.add(new MiniBus(nameArray[2],infoArray[2],imageArray[2]));
                miniBus.add(new MiniBus(nameArray[4],infoArray[4],imageArray[4]));
                miniBus.add(new MiniBus(nameArray[7],infoArray[7],imageArray[7]));
                miniBus.add(new MiniBus(nameArray[9],infoArray[9],imageArray[9]));
                mAllData.addAll(miniBus);
                listView = findViewById(R.id.listViewLandMarkDetail);
                adapter = new CustomListAdapter(this,
                        R.layout.listview_layout, miniBus);
                listView.setAdapter(adapter);
                break;
            case "เทสโก้ โลตัส ขอนแก่น":
                miniBus = new ArrayList<>();
                miniBus.add(new MiniBus(nameArray[6],infoArray[6],imageArray[6]));
                miniBus.add(new MiniBus(nameArray[7],infoArray[7],imageArray[7]));
                miniBus.add(new MiniBus(nameArray[9],infoArray[9],imageArray[9]));
                mAllData.addAll(miniBus);
                listView = findViewById(R.id.listViewLandMarkDetail);
                adapter = new CustomListAdapter(this,
                        R.layout.listview_layout, miniBus);
                listView.setAdapter(adapter);
                break;
            case "เทสโก้ โลตัส เอ็กซ์ตร้า":
                miniBus = new ArrayList<>();
                miniBus.add(new MiniBus(nameArray[2],infoArray[2],imageArray[2]));
                miniBus.add(new MiniBus(nameArray[14],infoArray[14],imageArray[14]));
                miniBus.add(new MiniBus(nameArray[15],infoArray[15],imageArray[15]));
                mAllData.addAll(miniBus);
                listView = findViewById(R.id.listViewLandMarkDetail);
                adapter = new CustomListAdapter(this,
                        R.layout.listview_layout, miniBus);
                listView.setAdapter(adapter);
                break;
            case "มหาวิทยาลัยขอนแก่น":
                miniBus = new ArrayList<>();
                miniBus.add(new MiniBus(nameArray[2],infoArray[2],imageArray[2]));
                miniBus.add(new MiniBus(nameArray[3],infoArray[3],imageArray[3]));
                miniBus.add(new MiniBus(nameArray[5],infoArray[5],imageArray[5]));
                miniBus.add(new MiniBus(nameArray[7],infoArray[7],imageArray[7]));
                miniBus.add(new MiniBus(nameArray[14],infoArray[14],imageArray[14]));
                miniBus.add(new MiniBus(nameArray[15],infoArray[15],imageArray[15]));
                mAllData.addAll(miniBus);
                listView = findViewById(R.id.listViewLandMarkDetail);
                adapter = new CustomListAdapter(this,
                        R.layout.listview_layout, miniBus);
                listView.setAdapter(adapter);
                break;
            case "ตลาดต้นตาล":
                miniBus = new ArrayList<>();
                miniBus.add(new MiniBus(nameArray[4],infoArray[4],imageArray[4]));
                miniBus.add(new MiniBus(nameArray[6],infoArray[6],imageArray[6]));
                miniBus.add(new MiniBus(nameArray[8],infoArray[8],imageArray[8]));
                mAllData.addAll(miniBus);
                listView = findViewById(R.id.listViewLandMarkDetail);
                adapter = new CustomListAdapter(this,
                        R.layout.listview_layout, miniBus);
                listView.setAdapter(adapter);
                break;
            case "ตลาดอู้ฟู":
                miniBus = new ArrayList<>();
                miniBus.add(new MiniBus(nameArray[1],infoArray[1],imageArray[1]));
                miniBus.add(new MiniBus(nameArray[2],infoArray[2],imageArray[2]));
                mAllData.addAll(miniBus);
                listView = findViewById(R.id.listViewLandMarkDetail);
                adapter = new CustomListAdapter(this,
                        R.layout.listview_layout, miniBus);
                listView.setAdapter(adapter);
                break;
            case "บิ๊กซี ขอนแก่น":
                miniBus = new ArrayList<>();
                miniBus.add(new MiniBus(nameArray[4],infoArray[4],imageArray[4]));
                miniBus.add(new MiniBus(nameArray[5],infoArray[5],imageArray[5]));
                mAllData.addAll(miniBus);
                listView = findViewById(R.id.listViewLandMarkDetail);
                adapter = new CustomListAdapter(this,
                        R.layout.listview_layout, miniBus);
                listView.setAdapter(adapter);
                break;
            case "โรงพยาบาลศรีนครินทร์":
                miniBus = new ArrayList<>();
                miniBus.add(new MiniBus(nameArray[2],infoArray[2],imageArray[2]));
                miniBus.add(new MiniBus(nameArray[14],infoArray[14],imageArray[14]));
                miniBus.add(new MiniBus(nameArray[15],infoArray[15],imageArray[15]));
                mAllData.addAll(miniBus);
                listView = findViewById(R.id.listViewLandMarkDetail);
                adapter = new CustomListAdapter(this,
                        R.layout.listview_layout, miniBus);
                listView.setAdapter(adapter);
                break;
            case "ตลาดเทศบาล":
                miniBus = new ArrayList<>();
                miniBus.add(new MiniBus(nameArray[0],infoArray[0],imageArray[0]));
                miniBus.add(new MiniBus(nameArray[1],infoArray[1],imageArray[1]));
                miniBus.add(new MiniBus(nameArray[2],infoArray[2],imageArray[2]));
                miniBus.add(new MiniBus(nameArray[3],infoArray[3],imageArray[3]));
                miniBus.add(new MiniBus(nameArray[4],infoArray[4],imageArray[4]));
                miniBus.add(new MiniBus(nameArray[5],infoArray[5],imageArray[5]));
                miniBus.add(new MiniBus(nameArray[6],infoArray[6],imageArray[6]));
                miniBus.add(new MiniBus(nameArray[7],infoArray[7],imageArray[7]));
                miniBus.add(new MiniBus(nameArray[9],infoArray[9],imageArray[9]));
                miniBus.add(new MiniBus(nameArray[10],infoArray[10],imageArray[10]));
                miniBus.add(new MiniBus(nameArray[12],infoArray[12],imageArray[12]));
                miniBus.add(new MiniBus(nameArray[13],infoArray[13],imageArray[13]));
                mAllData.addAll(miniBus);
                listView = findViewById(R.id.listViewLandMarkDetail);
                adapter = new CustomListAdapter(this,
                        R.layout.listview_layout, miniBus);
                listView.setAdapter(adapter);
                break;
            case "ตลาดบางลำพู":
                miniBus = new ArrayList<>();
                miniBus.add(new MiniBus(nameArray[0],infoArray[0],imageArray[0]));
                miniBus.add(new MiniBus(nameArray[1],infoArray[1],imageArray[1]));
                miniBus.add(new MiniBus(nameArray[2],infoArray[2],imageArray[2]));
                miniBus.add(new MiniBus(nameArray[3],infoArray[3],imageArray[3]));
                miniBus.add(new MiniBus(nameArray[9],infoArray[9],imageArray[9]));
                miniBus.add(new MiniBus(nameArray[14],infoArray[14],imageArray[14]));
                miniBus.add(new MiniBus(nameArray[15],infoArray[15],imageArray[15]));
                miniBus.add(new MiniBus(nameArray[17],infoArray[17],imageArray[17]));
                mAllData.addAll(miniBus);
                listView = findViewById(R.id.listViewLandMarkDetail);
                adapter = new CustomListAdapter(this,
                        R.layout.listview_layout, miniBus);
                listView.setAdapter(adapter);
                break;
            case "วิทยาลัยเทคนิคขอนแก่น":
                miniBus = new ArrayList<>();
                miniBus.add(new MiniBus(nameArray[0],infoArray[0],imageArray[0]));
                miniBus.add(new MiniBus(nameArray[1],infoArray[1],imageArray[1]));
                miniBus.add(new MiniBus(nameArray[13],infoArray[13],imageArray[13]));
                mAllData.addAll(miniBus);
                listView = findViewById(R.id.listViewLandMarkDetail);
                adapter = new CustomListAdapter(this,
                        R.layout.listview_layout, miniBus);
                listView.setAdapter(adapter);
                break;
            case "มหาวิทยาลัยเทคโนโลยีราชมงคลอีสาน":
                miniBus = new ArrayList<>();
                miniBus.add(new MiniBus(nameArray[0],infoArray[0],imageArray[0]));
                miniBus.add(new MiniBus(nameArray[1],infoArray[1],imageArray[1]));
                miniBus.add(new MiniBus(nameArray[13],infoArray[13],imageArray[13]));
                mAllData.addAll(miniBus);
                listView = findViewById(R.id.listViewLandMarkDetail);
                adapter = new CustomListAdapter(this,
                        R.layout.listview_layout, miniBus);
                listView.setAdapter(adapter);
                break;
            case "สถานีตำรวจภูธรเมืองขอนแก่น":
                miniBus = new ArrayList<>();
                miniBus.add(new MiniBus(nameArray[0],infoArray[0],imageArray[0]));
                miniBus.add(new MiniBus(nameArray[1],infoArray[1],imageArray[1]));
                miniBus.add(new MiniBus(nameArray[5],infoArray[5],imageArray[5]));
                miniBus.add(new MiniBus(nameArray[7],infoArray[7],imageArray[7]));
                miniBus.add(new MiniBus(nameArray[16],infoArray[16],imageArray[16]));
                mAllData.addAll(miniBus);
                listView = findViewById(R.id.listViewLandMarkDetail);
                adapter = new CustomListAdapter(this,
                        R.layout.listview_layout, miniBus);
                listView.setAdapter(adapter);
                break;
            case "โรงพยาบาลศูนย์ขอนแก่น":
                miniBus = new ArrayList<>();
                miniBus.add(new MiniBus(nameArray[0],infoArray[0],imageArray[0]));
                miniBus.add(new MiniBus(nameArray[13],infoArray[13],imageArray[13]));
                miniBus.add(new MiniBus(nameArray[17],infoArray[17],imageArray[17]));
                mAllData.addAll(miniBus);
                listView = findViewById(R.id.listViewLandMarkDetail);
                adapter = new CustomListAdapter(this,
                        R.layout.listview_layout, miniBus);
                listView.setAdapter(adapter);
                break;
            case "บขส.3":
                miniBus = new ArrayList<>();
                miniBus.add(new MiniBus(nameArray[1],infoArray[1],imageArray[1]));
                miniBus.add(new MiniBus(nameArray[2],infoArray[2],imageArray[2]));
                miniBus.add(new MiniBus(nameArray[4],infoArray[4],imageArray[4]));
                miniBus.add(new MiniBus(nameArray[9],infoArray[9],imageArray[9]));
                mAllData.addAll(miniBus);
                listView = findViewById(R.id.listViewLandMarkDetail);
                adapter = new CustomListAdapter(this,
                        R.layout.listview_layout, miniBus);
                listView.setAdapter(adapter);
                break;
            case "แม็คโคร ขอนแก่น":
                miniBus = new ArrayList<>();
                miniBus.add(new MiniBus(nameArray[1],infoArray[1],imageArray[1]));
                miniBus.add(new MiniBus(nameArray[2],infoArray[2],imageArray[2]));
                miniBus.add(new MiniBus(nameArray[4],infoArray[4],imageArray[4]));
                miniBus.add(new MiniBus(nameArray[7],infoArray[7],imageArray[7]));
                mAllData.addAll(miniBus);
                listView = findViewById(R.id.listViewLandMarkDetail);
                adapter = new CustomListAdapter(this,
                        R.layout.listview_layout, miniBus);
                listView.setAdapter(adapter);
                break;
            case "ศาลากลาง จังหวัดขอนแก่น":
                miniBus = new ArrayList<>();
                miniBus.add(new MiniBus(nameArray[9],infoArray[9],imageArray[9]));
                miniBus.add(new MiniBus(nameArray[16],infoArray[16],imageArray[16]));
                mAllData.addAll(miniBus);
                listView = findViewById(R.id.listViewLandMarkDetail);
                adapter = new CustomListAdapter(this,
                        R.layout.listview_layout, miniBus);
                listView.setAdapter(adapter);
                break;
            case "เทศบาลนครขอนแก่น":
                miniBus = new ArrayList<>();
                miniBus.add(new MiniBus(nameArray[4],infoArray[4],imageArray[4]));
                miniBus.add(new MiniBus(nameArray[8],infoArray[8],imageArray[8]));
                mAllData.addAll(miniBus);
                listView = findViewById(R.id.listViewLandMarkDetail);
                adapter = new CustomListAdapter(this,
                        R.layout.listview_layout, miniBus);
                listView.setAdapter(adapter);
                break;
            case "ที่ว่าการอําเภอเมืองขอนแก่น":
                miniBus = new ArrayList<>();
                miniBus.add(new MiniBus(nameArray[7],infoArray[7],imageArray[7]));
                mAllData.addAll(miniBus);
                listView = findViewById(R.id.listViewLandMarkDetail);
                adapter = new CustomListAdapter(this,
                        R.layout.listview_layout, miniBus);
                listView.setAdapter(adapter);
                break;
            case "วิทยาลัย อาชีวศึกษา ขอนแก่น":
                miniBus = new ArrayList<>();
                miniBus.add(new MiniBus(nameArray[8],infoArray[8],imageArray[8]));
                miniBus.add(new MiniBus(nameArray[12],infoArray[12],imageArray[12]));
                mAllData.addAll(miniBus);
                listView = findViewById(R.id.listViewLandMarkDetail);
                adapter = new CustomListAdapter(this,
                        R.layout.listview_layout, miniBus);
                listView.setAdapter(adapter);
                break;
            case "ตึกคอม ขอนแก่น":
                miniBus = new ArrayList<>();
                miniBus.add(new MiniBus(nameArray[8],infoArray[8],imageArray[8]));
                miniBus.add(new MiniBus(nameArray[10],infoArray[10],imageArray[10]));
                mAllData.addAll(miniBus);
                listView = findViewById(R.id.listViewLandMarkDetail);
                adapter = new CustomListAdapter(this,
                        R.layout.listview_layout, miniBus);
                listView.setAdapter(adapter);
                break;
            default:
                break;

        }


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.pop_out, R.anim.pop_out_exit);
    }
}
