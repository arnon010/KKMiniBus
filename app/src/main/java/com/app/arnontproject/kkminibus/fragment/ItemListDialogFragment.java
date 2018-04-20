package com.app.arnontproject.kkminibus.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.arnontproject.kkminibus.R;



public class ItemListDialogFragment extends BottomSheetDialogFragment {

    private LinearLayout mBottomSheet, ln1, ln2, ln3, ln4, ln5, ln6, ln7, ln8, ln9, ln10, ln11, ln12, ln13, ln14;

    private ImageView mLeftArrow;

    private ImageView mRightArrow;

    TextView firstLineBottomSheet , secondLineBottomSheet , txtMiniBusRoute1,txtMiniBusRoute2,txtMiniBusRoute3,txtMiniBusRoute4,
            txtMiniBusRoute5,txtMiniBusRoute6,txtMiniBusRoute7,txtMiniBusRoute8,txtMiniBusRoute9,txtMiniBusRoute10,txtMiniBusRoute11,
            txtMiniBusRoute12,txtMiniBusRoute13,txtMiniBusRoute14,txtMiniBusRoute15,txtMiniBusRoute16,txtMiniBusRoute17,txtMiniBusRoute18,
            txtMiniBusRoute19,txtMiniBusRoute20,txtMiniBusRoute21,txtMiniBusRoute22,txtMiniBusRoute23,txtMiniBusRoute24,txtMiniBusRoute25,
            txtMiniBusRoute26,txtMiniBusRoute27, txtMiniBusRoute28;
    ImageView iconBottomSheet;





    public ItemListDialogFragment() {
        // Required empty public constructor
    }

    public static ItemListDialogFragment newInstance() {
        return new ItemListDialogFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list_dialog, container, false);

        // find container view
        mBottomSheet = view.findViewById(R.id.bottom_sheet);

        // find arrows
        mLeftArrow = view.findViewById(R.id.bottom_sheet_left_arrow);
        mRightArrow = view.findViewById(R.id.bottom_sheet_right_arrow);

        txtMiniBusRoute1 = view.findViewById(R.id.txtMiniBusRoute1);
        txtMiniBusRoute2 = view.findViewById(R.id.txtMiniBusRoute2);
        txtMiniBusRoute3 = view.findViewById(R.id.txtMiniBusRoute3);
        txtMiniBusRoute4 = view.findViewById(R.id.txtMiniBusRoute4);
        txtMiniBusRoute5 = view.findViewById(R.id.txtMiniBusRoute5);
        txtMiniBusRoute6 = view.findViewById(R.id.txtMiniBusRoute6);
        txtMiniBusRoute7 = view.findViewById(R.id.txtMiniBusRoute7);
        txtMiniBusRoute8 = view.findViewById(R.id.txtMiniBusRoute8);
        txtMiniBusRoute9 = view.findViewById(R.id.txtMiniBusRoute9);
        txtMiniBusRoute10 = view.findViewById(R.id.txtMiniBusRoute10);
        txtMiniBusRoute11 = view.findViewById(R.id.txtMiniBusRoute11);
        txtMiniBusRoute12 = view.findViewById(R.id.txtMiniBusRoute12);
        txtMiniBusRoute13 = view.findViewById(R.id.txtMiniBusRoute13);
        txtMiniBusRoute14 = view.findViewById(R.id.txtMiniBusRoute14);
        txtMiniBusRoute15 = view.findViewById(R.id.txtMiniBusRoute15);
        txtMiniBusRoute16 = view.findViewById(R.id.txtMiniBusRoute16);
        txtMiniBusRoute17 = view.findViewById(R.id.txtMiniBusRoute17);
        txtMiniBusRoute18 = view.findViewById(R.id.txtMiniBusRoute18);
        txtMiniBusRoute19 = view.findViewById(R.id.txtMiniBusRoute19);
        txtMiniBusRoute20 = view.findViewById(R.id.txtMiniBusRoute20);
        txtMiniBusRoute21 = view.findViewById(R.id.txtMiniBusRoute21);
        txtMiniBusRoute22 = view.findViewById(R.id.txtMiniBusRoute22);
        txtMiniBusRoute23 = view.findViewById(R.id.txtMiniBusRoute23);
        txtMiniBusRoute24 = view.findViewById(R.id.txtMiniBusRoute24);
        txtMiniBusRoute25 = view.findViewById(R.id.txtMiniBusRoute25);
        txtMiniBusRoute26 = view.findViewById(R.id.txtMiniBusRoute26);
        txtMiniBusRoute27 = view.findViewById(R.id.txtMiniBusRoute27);
        txtMiniBusRoute28 = view.findViewById(R.id.txtMiniBusRoute28);


        ln1 = view.findViewById(R.id.ln1);
        ln2 = view.findViewById(R.id.ln2);
        ln3 = view.findViewById(R.id.ln3);
        ln4 = view.findViewById(R.id.ln4);
        ln5 = view.findViewById(R.id.ln5);
        ln6 = view.findViewById(R.id.ln6);
        ln7 = view.findViewById(R.id.ln7);
        ln8 = view.findViewById(R.id.ln8);
        ln9 = view.findViewById(R.id.ln9);
        ln10 = view.findViewById(R.id.ln10);
        ln11 = view.findViewById(R.id.ln11);
        ln12 = view.findViewById(R.id.ln12);
        ln13 = view.findViewById(R.id.ln13);
        ln14 = view.findViewById(R.id.ln14);

        String savedExtra = getActivity().getIntent().getStringExtra("minibus");
        firstLineBottomSheet = view.findViewById(R.id.firstLineBottomSheet);
        firstLineBottomSheet.setText(savedExtra);
        String savedExtra2 = getActivity().getIntent().getStringExtra("btsMinibus2");
        secondLineBottomSheet = view.findViewById(R.id.secondLineBottomSheet);
        secondLineBottomSheet.setText(savedExtra2);
        Integer savedExtra3 = getActivity().getIntent().getIntExtra("image",0);
        iconBottomSheet = view.findViewById(R.id.iconBottomSheet);
        iconBottomSheet.setImageResource(savedExtra3);


        if (firstLineBottomSheet.getText().toString().equals("สาย 2 : บ้านโคกฟันโปง – บ้านโคกน้อย\nบ.โคกฟันโปง, บ.หัวทุ่ง, บ.คำไฮ, เซ็นทรัลพลาซ่า ขอนแก่น, ศาลหลักเมือง ขอนแก่น, บขส.1, โรงเรียนขอนแก่นวิทยายน, ตลาดบางลำภู, ตลาดเทศบาล, โรงเรียนกัลยาณวัตร, สถานีตํารวจภูธรเมืองขอนแก่น, เซ็นโทซ่า, ไปรษณีย์ขอนแก่น, วัดศรีจันทร์, เรือนจำขอนแก่น, วิทยาลัยเทคนิคขอนแก่น, โรงพยาบาลศูนย์ขอนแก่น, มหาวิทยาลัยเทคโนโลยีราชมงคลอีสาน, ตลาดหนองใหญ่, บ.พระคือ, บ.หนองโพธิ์, บ.หนองแสง, บ.โคกน้อย")) {
            txtMiniBusRoute1.setText(R.string.ban_khok_fan_pong_line2);
            txtMiniBusRoute2.setText(R.string.ban_hua_thong_line2);
            txtMiniBusRoute3.setText(R.string.ban_hua_hi_line2);
            txtMiniBusRoute4.setText(R.string.central_plaza_khonkaen_line2);
            txtMiniBusRoute5.setText(R.string.chao_por_lak_muang_khonkaen_shrine_line2);
            txtMiniBusRoute6.setText(R.string.bus_terminal_1_line2);
            txtMiniBusRoute7.setText(R.string.khonkaen_wittayayon_school_line2);
            txtMiniBusRoute8.setText(R.string.bang_lamphu_market_line2);
            txtMiniBusRoute9.setText(R.string.municipal_market_line2);
            txtMiniBusRoute10.setText(R.string.kanlayanawat_school_line2);
            txtMiniBusRoute11.setText(R.string.khonkaen_metropolitan_police_station_line2);
            txtMiniBusRoute12.setText(R.string.sentosa_khonkaen_line2);
            txtMiniBusRoute13.setText(R.string.khon_kaen_post_office_line2);
            txtMiniBusRoute14.setText(R.string.wat_sri_chan_line2);
            txtMiniBusRoute15.setText(R.string.khon_kaen_prison_line2);
            txtMiniBusRoute16.setText(R.string.northeastern_vocation_institute_khonkaen_technical_college_line2);
            txtMiniBusRoute17.setText(R.string.medical_education_center_khonkaen_hospital_line2);
            txtMiniBusRoute18.setText(R.string.rajamangala_university_of_technology_isan_line2);
            txtMiniBusRoute19.setText(R.string.nong_yai_market_line2);
            txtMiniBusRoute20.setText(R.string.ban_phra_khue_line2);
            txtMiniBusRoute21.setText(R.string.ban_nong_pho_line2);
            txtMiniBusRoute22.setText(R.string.ban_nong_sang_line2);
            txtMiniBusRoute23.setText(R.string.ban_khok_noi_line2);


            ln13.setVisibility(View.GONE);
            ln14.setVisibility(View.GONE);
        }
        else if (firstLineBottomSheet.getText().toString().equals("สาย 3 : บขส.3 – บ้านพรหมนิมิตร\nบขส. 3, แม็คโคร ขอนแก่น, ประตูน้ำขอนแก่น, ตลาดอู้ฟู, โรงเรียนแก่นนครวิทยาลัย, ศาลหลักเมือง ขอนแก่น, เซ็นทรัลพลาซ่า ขอนแก่น, โรงบาลราชพฤกษ์ ขอนแก่น, บขส.1, โรงเรียนขอนแก่นวิทยายน, ตลาดบางลำภู, ตลาดเทศบาล, โรงเรียนกัลยาณวัตร, สถานีตํารวจภูธรเมืองขอนแก่น, ไปรษณีย์ขอนแก่น, วิทยาลัยเทคนิคขอนแก่น, มหาวิทยาลัยเทคโนโลยีราชมงคลอีสาน, ตลาดหนองใหญ่, บ.ท่าหิน, บ.พรหมนิมิตร")) {
            txtMiniBusRoute1.setText(R.string.bus_terminal_3_line3);
            txtMiniBusRoute2.setText(R.string.makro_khon_kaen_line3);
            txtMiniBusRoute3.setText(R.string.watergate_market_khonkaen_line3);
            txtMiniBusRoute4.setText(R.string.wufoo_market_line3);
            txtMiniBusRoute5.setText(R.string.kaen_nakhon_wittayalai_school_line3);
            txtMiniBusRoute6.setText(R.string.chao_por_lak_muang_khonkaen_shrine_line3);
            txtMiniBusRoute7.setText(R.string.central_plaza_khonkaen_line3);
            txtMiniBusRoute8.setText(R.string.ratchaphruek_hospital_line3);
            txtMiniBusRoute9.setText(R.string.bus_terminal_1_line3);
            txtMiniBusRoute10.setText(R.string.khonkaen_wittayayon_school_line3);
            txtMiniBusRoute11.setText(R.string.bang_lamphu_market_line3);
            txtMiniBusRoute12.setText(R.string.municipal_market_line3);
            txtMiniBusRoute13.setText(R.string.kanlayanawat_school_line3);
            txtMiniBusRoute14.setText(R.string.khonkaen_metropolitan_police_station_line3);
            txtMiniBusRoute15.setText(R.string.khonkaen_post_office_line3);
            txtMiniBusRoute16.setText(R.string.northeastern_vocation_institute_khonkaen_technical_college_line3);
            txtMiniBusRoute17.setText(R.string.rajamangala_university_of_technology_isan_line3);
            txtMiniBusRoute18.setText(R.string.nong_yai_market_line3);
            txtMiniBusRoute19.setText(R.string.ban_tha_hin_line3);
            txtMiniBusRoute20.setText(R.string.ban_promnimit_line3);

            ln11.setVisibility(View.GONE);
            ln12.setVisibility(View.GONE);
            ln13.setVisibility(View.GONE);
            ln14.setVisibility(View.GONE);
        }
        else if (firstLineBottomSheet.getText().toString().equals("สาย 4 : บขส.3 – บ้านหนองน้ำเกลี้ยง\nบขส.3, แม็คโคร ขอนแก่น, ประตูน้ำขอนแก่น, ตลาดอู้ฟู, ขอนแก่นแหอวน, โรงเรียนแก่นนครวิทยาลัย, โรงเรียนโสตศึกษาขอนแก่น, สนามกีฬากลางขอนแก่น, โรงเรียนเทศบาลวัดกลาง, แฟรี่พลาซ่า, ตลาดเทศบาล, ตลาดบางลำภู, โรงเรียนขอนแก่นวิทยายน, บขส.1, ศูนย์หัวใจสิริกิตขอนแก่น, โรงพยาบาลศรีนครินทร์, มหาวิทยาลัยขอนแก่น, โลตัสเอ็กซ์ตร้า, บ.สำราญ, บ.หนองน้ำเกลี้ยง")) {
            txtMiniBusRoute1.setText(R.string.bus_terminal_3_line4);
            txtMiniBusRoute2.setText(R.string.makro_khonkaen_line4);
            txtMiniBusRoute3.setText(R.string.watergate_market_khonkaen_line4);
            txtMiniBusRoute4.setText(R.string.wufoo_market_line4);
            txtMiniBusRoute5.setText(R.string.khonkaen_filament_industry_line4);
            txtMiniBusRoute6.setText(R.string.kaen_nakhon_wittayalai_school_line4);
            txtMiniBusRoute7.setText(R.string.khon_kaen_deaf_school_line4);
            txtMiniBusRoute8.setText(R.string.khonkaen_sports_stadium_line4);
            txtMiniBusRoute9.setText(R.string.wat_klang_municipal_school_line4);
            txtMiniBusRoute10.setText(R.string.fairy_plaza_line4);
            txtMiniBusRoute11.setText(R.string.municipal_market_line4);
            txtMiniBusRoute12.setText(R.string.bang_lamphu_market_line4);
            txtMiniBusRoute13.setText(R.string.khonkaen_wittayayon_school_line4);
            txtMiniBusRoute14.setText(R.string.bus_terminal_1_line4);
            txtMiniBusRoute15.setText(R.string.sirikit_heart_center_line4);
            txtMiniBusRoute16.setText(R.string.srinagarind_hospital_line4);
            txtMiniBusRoute17.setText(R.string.khonkaen_university_line4);
            txtMiniBusRoute18.setText(R.string.lotus_extra_khonkhon_line4);
            txtMiniBusRoute19.setText(R.string.ban_samram_line4);
            txtMiniBusRoute20.setText(R.string.ban_nong_nam_kieng_line4);

            ln11.setVisibility(View.GONE);
            ln12.setVisibility(View.GONE);
            ln13.setVisibility(View.GONE);
            ln14.setVisibility(View.GONE);
        }
        else if (firstLineBottomSheet.getText().toString().equals("สาย 5 : ตลาดหนองไผ่ล้อม – บ้านทุ่ม\nตลาดหนองไผ่ล้อม, ตลาดเทศบาล, ตลาดบางลำภู, โรงเรียนขอนแก่นวิทยายน, เซ็นโทซ่า, ศูนย์ประชุมกาญจนาภิเษก, มหาวิทยาลัยขอนแก่น, สถาบันพัฒนาฝีมือแรงงานขอนแก่น, บ.ทุ่ม")) {
            txtMiniBusRoute1.setText(R.string.nongpailom_market_line5);
            txtMiniBusRoute2.setText(R.string.municipal_market_line5);
            txtMiniBusRoute3.setText(R.string.bang_lamphu_market_line5);
            txtMiniBusRoute4.setText(R.string.khonkaen_wittayayon_school_line5);
            txtMiniBusRoute5.setText(R.string.sentosa_khonkaen_line5);
            txtMiniBusRoute6.setText(R.string.khonkaen_cytocare_line5);
            txtMiniBusRoute7.setText(R.string.khonkaen_university_line5);
            txtMiniBusRoute8.setText(R.string.khonkaen_institude_for_skill_development_line5);
            txtMiniBusRoute9.setText(R.string.ban_thum_line5);

            ln6.setVisibility(View.GONE);
            ln7.setVisibility(View.GONE);
            ln8.setVisibility(View.GONE);
            ln9.setVisibility(View.GONE);
            ln10.setVisibility(View.GONE);
            ln11.setVisibility(View.GONE);
            ln12.setVisibility(View.GONE);
            ln13.setVisibility(View.GONE);
            ln14.setVisibility(View.GONE);
        }
        else if (firstLineBottomSheet.getText().toString().equals("สาย 6 : ตลาดเทศบาล 1 – บ้านเหล่านกชุม\nตลาดเทศบาล, เทศบาลนครขอนแก่น, ศาลหลักเมืองขอนแก่น, เซ็นทรัลพลาซ่าขอนแก่น, บิ๊กซีขอนแก่น, ตลาดต้นตาล, โฮมโปรขอนแก่น, แม็คโครขอนแก่น, ประตูน้ำขอนแก่น, เทสโก้โลตัสขอนแก่น, บขส.3, บ.กุดกว้าง, บ.ท่าพระ, บ.หนองหญ้าแพรก, บ.ท่าแร่, บ.โนนเขวา, บ.เหล่านกชุม")) {
            txtMiniBusRoute1.setText(R.string.municipal_market_line6);
            txtMiniBusRoute2.setText(R.string.municipal_office_khonkaen_line6);
            txtMiniBusRoute3.setText(R.string.chao_por_lak_muang_khonkaen_shrine_line6);
            txtMiniBusRoute4.setText(R.string.central_plaza_khonkaen_line6);
            txtMiniBusRoute5.setText(R.string.big_c_khonkaen_line6);
            txtMiniBusRoute6.setText(R.string.ton_tann_market_line6);
            txtMiniBusRoute7.setText(R.string.home_pro_khonkaen_line6);
            txtMiniBusRoute8.setText(R.string.makro_khonkaen_line6);
            txtMiniBusRoute9.setText(R.string.watergate_market_khonkaen_line6);
            txtMiniBusRoute10.setText(R.string.tesco_lotus_khonkaen_line6);
            txtMiniBusRoute11.setText(R.string.bus_terminal_3_line6);
            txtMiniBusRoute12.setText(R.string.ban_kut_kwang_line6);
            txtMiniBusRoute13.setText(R.string.ban_tha_phra_line6);
            txtMiniBusRoute14.setText(R.string.ban_nong_ya_phraek_line6);
            txtMiniBusRoute15.setText(R.string.ban_tha_rae_line6);
            txtMiniBusRoute16.setText(R.string.ban_non_khawao_line6);
            txtMiniBusRoute17.setText(R.string.ban_lao_nok_chum_line6);

            ln10.setVisibility(View.GONE);
            ln11.setVisibility(View.GONE);
            ln12.setVisibility(View.GONE);
            ln13.setVisibility(View.GONE);
            ln14.setVisibility(View.GONE);
        }
        else if (firstLineBottomSheet.getText().toString().equals("สาย 8 : สามเหลี่ยม – บ้านดอนบม\nมหาวิทยาลัยขอนแก่น, เซ็นโทซ่า, บขส.1, บขส.2, สถานีตํารวจภูธรเมืองขอนแก่น, โรงเรียนขอนแก่นวิทยายน, โรงเรียนกัลยาณวัตร, ตลาดเทศบาล, แฟรี่พลาซ่า, เมืองเก่า, บึงแก่นนคร, บ.ดอนบม")) {
            txtMiniBusRoute1.setText(R.string.khonkaen_university_line8);
            txtMiniBusRoute2.setText(R.string.sentosa_khonkaen_line8);
            txtMiniBusRoute3.setText(R.string.bus_terminal_1_line8);
            txtMiniBusRoute4.setText(R.string.bus_terminal_2_line8);
            txtMiniBusRoute5.setText(R.string.khonkaen_metropolitan_police_station_line8);
            txtMiniBusRoute6.setText(R.string.khonkaen_wittayayon_school_line8);
            txtMiniBusRoute7.setText(R.string.kanlayanawat_school_line8);
            txtMiniBusRoute8.setText(R.string.municipal_market_line8);
            txtMiniBusRoute9.setText(R.string.fairy_plaza_line8);
            txtMiniBusRoute10.setText(R.string.muang_kao_line8);
            txtMiniBusRoute11.setText(R.string.bueng_kaen_nakhon_line8);
            txtMiniBusRoute12.setText(R.string.don_bom_line8);

            ln7.setVisibility(View.GONE);
            ln8.setVisibility(View.GONE);
            ln9.setVisibility(View.GONE);
            ln10.setVisibility(View.GONE);
            ln11.setVisibility(View.GONE);
            ln12.setVisibility(View.GONE);
            ln13.setVisibility(View.GONE);
            ln14.setVisibility(View.GONE);
        }
        else if (firstLineBottomSheet.getText().toString().equals("สาย 9 : สามเหลี่ยม – บ้านสะอาด\nบ.สามเหลี่ยม, บขส.1, บขส.2, โรงเรียนขอนแก่นวิทยายน, ไปรษณีย์ขอนแก่น, ตลาดเทศบาล, แฟรี่พลาซ่า, สนามกีฬากลางขอนแก่น, โรงเรียนแก่นนครวิทยาลัย, ตลาดต้นตาล, มหาวิทยาลัยภาคตะวันออกเฉียงเหนือ, บ.กอก, บ.โจด, บ.สะอาด")) {
            txtMiniBusRoute1.setText(R.string.ban_sam_liam_line9);
            txtMiniBusRoute2.setText(R.string.bus_terminal_1_line9);
            txtMiniBusRoute3.setText(R.string.bus_terminal_2_line9);
            txtMiniBusRoute4.setText(R.string.khonkaen_wittayayon_school_line9);
            txtMiniBusRoute5.setText(R.string.khonkaen_post_office_line9);
            txtMiniBusRoute6.setText(R.string.municipal_market_line9);
            txtMiniBusRoute7.setText(R.string.fairy_plaza_line9);
            txtMiniBusRoute8.setText(R.string.khonkaen_sports_stadium_line9);
            txtMiniBusRoute9.setText(R.string.kaen_nakhon_wittayalai_school_line9);
            txtMiniBusRoute10.setText(R.string.ton_tann_market_line9);
            txtMiniBusRoute11.setText(R.string.north_eastern_university_line9);
            txtMiniBusRoute12.setText(R.string.ban_kok_line9);
            txtMiniBusRoute13.setText(R.string.ban_chot_line9);
            txtMiniBusRoute14.setText(R.string.ban_sa_at_line9);

            ln8.setVisibility(View.GONE);
            ln9.setVisibility(View.GONE);
            ln10.setVisibility(View.GONE);
            ln11.setVisibility(View.GONE);
            ln12.setVisibility(View.GONE);
            ln13.setVisibility(View.GONE);
            ln14.setVisibility(View.GONE);
        }
        else if (firstLineBottomSheet.getText().toString().equals("สาย 10 : มหาวิทยาลัยขอนแก่น – สนามม้า\nมหาวิทยาลัยขอนแก่น, บขส.1, ที่ว่าการอําเภอเมืองขอนแก่น, บ.บะขาม, เรือนจำขอนแก่น, บขส.2, โรงเรียนขอนแก่นวิทยายน, ไปรษณีย์ขอนแก่น, สถานีตํารวจภูธรเมืองขอนแก่น, ตลาดเทศบาล, แฟรี่พลาซ่า, สนามกีฬากลางขอนแก่น, โรงเรียนแก่นนครวิทยาลัย, ประตูน้ำขอนแก่น, แม็คโครขอนแก่น, เทสโก้โลตัสขอนแก่น")) {
            txtMiniBusRoute1.setText(R.string.khonkaen_university_line10);
            txtMiniBusRoute2.setText(R.string.bus_terminal_1_line10);
            txtMiniBusRoute3.setText(R.string.district_khonkaen_line10);
            txtMiniBusRoute4.setText(R.string.ban_bakham_line10);
            txtMiniBusRoute5.setText(R.string.khonkaen_prison_line10);
            txtMiniBusRoute6.setText(R.string.bus_terminal_2_line10);
            txtMiniBusRoute7.setText(R.string.khonkaen_wittayayon_school_line10);
            txtMiniBusRoute8.setText(R.string.khonkaen_post_office_line10);
            txtMiniBusRoute9.setText(R.string.khonkaen_metropolitan_police_station_line10);
            txtMiniBusRoute10.setText(R.string.municipal_market_line10);
            txtMiniBusRoute11.setText(R.string.fairy_plaza_line10);
            txtMiniBusRoute12.setText(R.string.khonkaen_sports_stadium_line10);
            txtMiniBusRoute13.setText(R.string.kaen_nakhon_wittayalai_school_line10);
            txtMiniBusRoute14.setText(R.string.watergate_market_khonkaen_line10);
            txtMiniBusRoute15.setText(R.string.makro_khonkaen_line10);
            txtMiniBusRoute16.setText(R.string.tesco_lotus_khonkaen_line10);

            ln9.setVisibility(View.GONE);
            ln10.setVisibility(View.GONE);
            ln11.setVisibility(View.GONE);
            ln12.setVisibility(View.GONE);
            ln13.setVisibility(View.GONE);
            ln14.setVisibility(View.GONE);
        }
        else if (firstLineBottomSheet.getText().toString().equals("สาย 11 : บ้านโนนสวรรค์ – บ้านขามเจริญ\nบ.โนนสวรรค์, ตลาดหนองใหญ่, วิทยาลัยอาชีวศึกษาขอนแก่น, บขส.2, โรงเรียนขอนแก่นวิทยายน, ตึกคอมขอนแก่น, เทศบาลนครขอนแก่น, ตลาดต้นตาล, บ.โคกฟันโปง")) {
            txtMiniBusRoute1.setText(R.string.ban_non_swan_line11);
            txtMiniBusRoute2.setText(R.string.nong_yai_market_line11);
            txtMiniBusRoute3.setText(R.string.khonkaen_vocational_education_college_line11);
            txtMiniBusRoute4.setText(R.string.bus_terminal_2_line11);
            txtMiniBusRoute5.setText(R.string.khonkaen_wittayayon_school_line11);
            txtMiniBusRoute6.setText(R.string.tukcom_khonkaen_line11);
            txtMiniBusRoute7.setText(R.string.municipal_office_khonkaen_line11);
            txtMiniBusRoute8.setText(R.string.ton_tann_market_line11);
            txtMiniBusRoute9.setText(R.string.ban_khok_fan_pong_line11);


            ln6.setVisibility(View.GONE);
            ln7.setVisibility(View.GONE);
            ln8.setVisibility(View.GONE);
            ln9.setVisibility(View.GONE);
            ln10.setVisibility(View.GONE);
            ln11.setVisibility(View.GONE);
            ln12.setVisibility(View.GONE);
            ln13.setVisibility(View.GONE);
            ln14.setVisibility(View.GONE);
        }
        else if (firstLineBottomSheet.getText().toString().equals("สาย 12 : พิพิธภัณฑ์ – รร.ท่าพระวิทยายน\nศาลากลางจังหวัดขอนแก่น, บขส.1, โรงเรียนขอนแก่นวิทยายน, ตลาดบางลำภู, ตลาดเทศบาล, โรงเรียนแก่นนครวิทยาลัย, ประตูน้ำขอนแก่น, เทสโก้โลตัสขอนแก่น, บขส.3, บ.โนนตุ่น, บ.กุดกว้าง, บ.ท่าพระ, บ.หนองบัวดีหมี")) {
            txtMiniBusRoute1.setText(R.string.city_hall_in_khonkaen_line12);
            txtMiniBusRoute2.setText(R.string.bus_terminal_1_line12);
            txtMiniBusRoute3.setText(R.string.khonkaen_wittayayon_school_line12);
            txtMiniBusRoute4.setText(R.string.bang_lamphu_market_line12);
            txtMiniBusRoute5.setText(R.string.municipal_market_line12);
            txtMiniBusRoute6.setText(R.string.kaen_nakhon_wittayalai_school_line12);
            txtMiniBusRoute7.setText(R.string.watergate_market_khonkaen_line12);
            txtMiniBusRoute8.setText(R.string.tesco_lotus_khonkaen_line12);
            txtMiniBusRoute9.setText(R.string.bus_terminal_3_line12);
            txtMiniBusRoute10.setText(R.string.ban_non_tun_line12);
            txtMiniBusRoute11.setText(R.string.ban_kut_kwang_line12);
            txtMiniBusRoute12.setText(R.string.ban_tha_phra_line12);
            txtMiniBusRoute13.setText(R.string.ban_nong_bua_di_mi_line12);

            ln8.setVisibility(View.GONE);
            ln9.setVisibility(View.GONE);
            ln10.setVisibility(View.GONE);
            ln11.setVisibility(View.GONE);
            ln12.setVisibility(View.GONE);
            ln13.setVisibility(View.GONE);
            ln14.setVisibility(View.GONE);
        }
        else if (firstLineBottomSheet.getText().toString().equals("สาย 13 : บ้านน้อยนิเวศน์ – บ้านสว่างมรรคา\nบ้านน้อยนิเวศน์, บขส.1, ตลาด อ.จิระ ขอนแก่น, ตึกคอมขอนแก่น, โรงเรียนกัลยาณวัตรม, ตลาดเทศบาล, โรงเรียนเทศบาลสวนสนุก, บึงแก่นนคร, บ.ตูม, บ.ดอนบม, บ.ดอนแดง, บ้านดอนหัน")) {
            txtMiniBusRoute1.setText(R.string.ban_noi_ni_wad_line13);
            txtMiniBusRoute2.setText(R.string.bus_terminal_1_line13);
            txtMiniBusRoute3.setText(R.string.a_jira_market_line13);
            txtMiniBusRoute4.setText(R.string.tukcom_khonkaen_line13);
            txtMiniBusRoute5.setText(R.string.kanlayanawat_school_line13);
            txtMiniBusRoute6.setText(R.string.municipal_market_line13);
            txtMiniBusRoute7.setText(R.string.suan_sanuk_municipal_school_line13);
            txtMiniBusRoute8.setText(R.string.bueng_kaen_nakhon_line13);
            txtMiniBusRoute9.setText(R.string.ban_tum_line13);
            txtMiniBusRoute10.setText(R.string.ban_don_bom_line13);
            txtMiniBusRoute11.setText(R.string.ban_dong_noi_line13);
            txtMiniBusRoute12.setText(R.string.ban_don_dang_line13);
            txtMiniBusRoute13.setText(R.string.ban_don_chan_line13);

            ln8.setVisibility(View.GONE);
            ln9.setVisibility(View.GONE);
            ln10.setVisibility(View.GONE);
            ln11.setVisibility(View.GONE);
            ln12.setVisibility(View.GONE);
            ln13.setVisibility(View.GONE);
            ln14.setVisibility(View.GONE);
        }
        else if (firstLineBottomSheet.getText().toString().equals("สาย 16 : บ้านโนนทัน – วัดป่าอดุลยาราม\nบ.โนนทัน, ตลาดโนนทัน, โรงพยาบาลจิตเวชขอนแก่น, เรือนจำขอนแก่น, โรงเรียนกัลยาณวัตร, บขส.1, บ.สามเหลี่ยม")) {
            txtMiniBusRoute1.setText(R.string.ban_non_tan_line16);
            txtMiniBusRoute2.setText(R.string.non_tan_market_line16);
            txtMiniBusRoute3.setText(R.string.khonkaen_rajanagarindra_psychiatric_hospital_line16);
            txtMiniBusRoute4.setText(R.string.khonkaen_prison_line16);
            txtMiniBusRoute5.setText(R.string.kanlayanawat_school_line16);
            txtMiniBusRoute6.setText(R.string.bus_terminal_1_line16);
            txtMiniBusRoute7.setText(R.string.ban_sam_liam_line16);


            ln5.setVisibility(View.GONE);
            ln6.setVisibility(View.GONE);
            ln7.setVisibility(View.GONE);
            ln8.setVisibility(View.GONE);
            ln9.setVisibility(View.GONE);
            ln10.setVisibility(View.GONE);
            ln11.setVisibility(View.GONE);
            ln12.setVisibility(View.GONE);
            ln13.setVisibility(View.GONE);
            ln14.setVisibility(View.GONE);
        }
        else if (firstLineBottomSheet.getText().toString().equals("สาย 17 : บ้านโนนทัน – บ้านโคกท่า\nบ.โนนทัน, บึงแก่นนคร, โรงเรียนเทศบาลสวนสนุก, แฟรี่พลาซ่า, ตลาดเทศบาล, โรงเรียนกัลยาณวัตร, วิทยาลัยอาชีวศึกษาขอนแก่น, ตลาดบ้านดอน, ค่ายศรีพัชรินทร์, โรงเรียนขามแก่นนคร, บ.โกทา, บ.หนองหิน, บ.ห้วยชัน, บ.โคกท่า")) {
            txtMiniBusRoute1.setText(R.string.ban_non_tan_line17);
            txtMiniBusRoute2.setText(R.string.bueng_kaen_nakhon_line17);
            txtMiniBusRoute3.setText(R.string.suan_sanuk_municipal_school_line17);
            txtMiniBusRoute4.setText(R.string.fairy_plaza_line17);
            txtMiniBusRoute5.setText(R.string.municipal_market_line17);
            txtMiniBusRoute6.setText(R.string.kanlayanawat_school_line17);
            txtMiniBusRoute7.setText(R.string.khonkaen_vocational_education_college_line17);
            txtMiniBusRoute8.setText(R.string.ban_don_market_line17);
            txtMiniBusRoute9.setText(R.string.khai_sri_patcharin_line17);
            txtMiniBusRoute10.setText(R.string.khamkaen_nakhon_school_line17);
            txtMiniBusRoute11.setText(R.string.ban_kotha_line17);
            txtMiniBusRoute12.setText(R.string.ban_nong_hin_line17);
            txtMiniBusRoute13.setText(R.string.ban_hui_chan_line17);
            txtMiniBusRoute14.setText(R.string.ban_khok_tha_line17);

            ln8.setVisibility(View.GONE);
            ln9.setVisibility(View.GONE);
            ln10.setVisibility(View.GONE);
            ln11.setVisibility(View.GONE);
            ln12.setVisibility(View.GONE);
            ln13.setVisibility(View.GONE);
            ln14.setVisibility(View.GONE);
        }
        else if (firstLineBottomSheet.getText().toString().equals("สาย 18 : โรงเรียนกัลยาณวัตร – บ้านโนนพอง\nโรงเรียนกัลยาณวัตร, เรือนจำขอนแก่น, วิทยาลัยเทคนิคขอนแก่น, โรงพยาบาลศูนย์ขอนแก่น, มหาวิทยาลัยเทคโนโลยีราชมงคลอีสาน, ตลาดหนองใหญ่, บ.แอ่วมอง, บ.สงเปือย, บ.โนนพอง")) {
            txtMiniBusRoute1.setText(R.string.kanlayanawat_school_line18);
            txtMiniBusRoute2.setText(R.string.khonkaen_prison_line18);
            txtMiniBusRoute3.setText(R.string.northeastern_vocation_institute_khonkaen_technical_college_line18);
            txtMiniBusRoute4.setText(R.string.medical_education_center_khonkaen_hospital_line18);
            txtMiniBusRoute5.setText(R.string.rajamangala_university_of_technology_isan_line18);
            txtMiniBusRoute6.setText(R.string.nong_yai_market_line18);
            txtMiniBusRoute7.setText(R.string.ban_awe_mong_line18);
            txtMiniBusRoute8.setText(R.string.ban_song_pueai_line18);
            txtMiniBusRoute9.setText(R.string.ban_non_phon_line18);

            ln6.setVisibility(View.GONE);
            ln7.setVisibility(View.GONE);
            ln8.setVisibility(View.GONE);
            ln9.setVisibility(View.GONE);
            ln10.setVisibility(View.GONE);
            ln11.setVisibility(View.GONE);
            ln12.setVisibility(View.GONE);
            ln13.setVisibility(View.GONE);
            ln14.setVisibility(View.GONE);
        }
        else if (firstLineBottomSheet.getText().toString().equals("สาย 19 : ตลาดหนองไผ่ล้อม – บ้านโนนเรือง\nตลาดหนองไผ่ล้อม, ตลาดเทศบาล, ตลาดบางลำภู, โรงเรียนขอนแก่นวิทยายน, >บขส.1, ศูนย์หัวใจสิริกิตขอนแก่น, โรงพยาบาลศรีนครินทร์ขอนแก่น, มหาวิทยาลัยขอนแก่น, โลตัสเอ็กซ์ตร้า, บ.โนนเมือง, บ.โนนเรือง")) {
            txtMiniBusRoute1.setText(R.string.nong_phai_lom_market_line19);
            txtMiniBusRoute2.setText(R.string.municipal_market_line19);
            txtMiniBusRoute3.setText(R.string.bang_lamphu_market_line19);
            txtMiniBusRoute4.setText(R.string.khonkaen_wittayayon_school_line19);
            txtMiniBusRoute5.setText(R.string.bus_terminal_1_line19);
            txtMiniBusRoute6.setText(R.string.sirikit_heart_center_line19);
            txtMiniBusRoute7.setText(R.string.srinagarind_hospital_line19);
            txtMiniBusRoute8.setText(R.string.khonkaen_university_line19);
            txtMiniBusRoute9.setText(R.string.lotus_extra_khonkhon_line19);
            txtMiniBusRoute10.setText(R.string.ban_non_muang_line19);
            txtMiniBusRoute11.setText(R.string.ban_non_raug_line19);

            ln7.setVisibility(View.GONE);
            ln8.setVisibility(View.GONE);
            ln9.setVisibility(View.GONE);
            ln10.setVisibility(View.GONE);
            ln11.setVisibility(View.GONE);
            ln12.setVisibility(View.GONE);
            ln13.setVisibility(View.GONE);
            ln14.setVisibility(View.GONE);
        }
        else if (firstLineBottomSheet.getText().toString().equals("สาย 20 : ตลาดหนองไผ่ล้อม – บ้านกลางฮุง\nตลาดหนองไผ่ล้อม, ตลาดเทศบาล, ตลาดบางลำภู, โรงเรียนขอนแก่นวิทยายน, บขส.1, ศูนย์หัวใจสิริกิตขอนแก่น, โรงพยาบาลศรีนครินทร์ขอนแก่น, มหาวิทยาลัยขอนแก่น, โลตัสเอ็กซ์ตร้า, บ.โคกนางาม, บ.หนองค้า, บ.กลางฮุง")) {
            txtMiniBusRoute1.setText(R.string.nong_phai_lom_market_line20);
            txtMiniBusRoute2.setText(R.string.municipal_market_line20);
            txtMiniBusRoute3.setText(R.string.bang_lamphu_market_line20);
            txtMiniBusRoute4.setText(R.string.khonkaen_wittayayon_school_line20);
            txtMiniBusRoute5.setText(R.string.bus_terminal_1_line20);
            txtMiniBusRoute6.setText(R.string.sirikit_heart_center_line20);
            txtMiniBusRoute7.setText(R.string.srinagarind_hospital_line20);
            txtMiniBusRoute8.setText(R.string.khonkaen_university_line20);
            txtMiniBusRoute9.setText(R.string.lotus_extra_khon_khon_line20);
            txtMiniBusRoute10.setText(R.string.ban_khok_na_ngam_line20);
            txtMiniBusRoute11.setText(R.string.ban_nong_khla_line20);
            txtMiniBusRoute12.setText(R.string.ban_klang_hung_line20);

            ln7.setVisibility(View.GONE);
            ln8.setVisibility(View.GONE);
            ln9.setVisibility(View.GONE);
            ln10.setVisibility(View.GONE);
            ln11.setVisibility(View.GONE);
            ln12.setVisibility(View.GONE);
            ln13.setVisibility(View.GONE);
            ln14.setVisibility(View.GONE);
        }
        else if (firstLineBottomSheet.getText().toString().equals("สาย 21 : บ้านโนนเขวา – บ้านดอนยาง\nบ.โนนเขวา, บ.เหล่านกชุม, บ.บือ, บ.โนนทัน, บึงแก่นนคร, แฟรี่พลาซ่า, ตลาดเทศบาล, โรงเรียนกัลยาณวัตร, สถานีตํารวจภูธรเมืองขอนแก่น, โรงเรียนขอนแก่นวิทยายน, บขส.1, ศาลากลางจังหวัดขอนแก่น, ตลาดบ้านดอน, บ.ดองยาง")) {
            txtMiniBusRoute1.setText(R.string.ban_non_khawao_line21);
            txtMiniBusRoute2.setText(R.string.ban_lao_nok_chum_line21);
            txtMiniBusRoute3.setText(R.string.ban_bue_line21);
            txtMiniBusRoute4.setText(R.string.ban_non_tan_line21);
            txtMiniBusRoute5.setText(R.string.bueng_kaen_nakhon_line21);
            txtMiniBusRoute6.setText(R.string.fairy_plaza_line21);
            txtMiniBusRoute7.setText(R.string.municipal_market_line21);
            txtMiniBusRoute8.setText(R.string.kanlayanawat_school_line21);
            txtMiniBusRoute9.setText(R.string.khonkaen_metropolitan_police_station_line21);
            txtMiniBusRoute10.setText(R.string.khonkaen_wittayayon_school_line21);
            txtMiniBusRoute11.setText(R.string.bus_terminal_1_line21);
            txtMiniBusRoute12.setText(R.string.city_hall_in_khonkaen_line21);
            txtMiniBusRoute13.setText(R.string.ban_don_market_line21);
            txtMiniBusRoute14.setText(R.string.ban_don_yang_line21);

            ln7.setVisibility(View.GONE);
            ln8.setVisibility(View.GONE);
            ln9.setVisibility(View.GONE);
            ln10.setVisibility(View.GONE);
            ln11.setVisibility(View.GONE);
            ln12.setVisibility(View.GONE);
            ln13.setVisibility(View.GONE);
            ln14.setVisibility(View.GONE);
        }
        else if (firstLineBottomSheet.getText().toString().equals("สาย 22 : บ้านหนองไฮ- บ้านดอนหญ้านาง\nบ.หนองไฮ, ตลาดหนองใหญ่, โรงพยาบาลศูนย์ขอนแก่น, เรือนจำขอนแก่น, สถานีตํารวจภูธรเมืองขอนแก่น, ตลาดเทศบาล, ตลาดบางลำภู, โรงเรียนขอนแก่นวิทยายน, บขส.1, ไปรษณีย์ขอนแก่น, บ.ดอนหญ้านาง")) {
            txtMiniBusRoute1.setText(R.string.ban_nong_hai_line22);
            txtMiniBusRoute2.setText(R.string.nong_yai_market);
            txtMiniBusRoute3.setText(R.string.medical_education_center_khonkaen_hospital_line22);
            txtMiniBusRoute4.setText(R.string.khon_kaen_prison_line22);
            txtMiniBusRoute5.setText(R.string.khon_kaen_metropolitan_police_station_line22);
            txtMiniBusRoute6.setText(R.string.municipal_market_line22);
            txtMiniBusRoute7.setText(R.string.bang_lamphu_market_line22);
            txtMiniBusRoute8.setText(R.string.khon_kaen_wittayayon_school_line22);
            txtMiniBusRoute9.setText(R.string.bus_terminal_1_line22);
            txtMiniBusRoute10.setText(R.string.khonkaen_post_office_line22);
            txtMiniBusRoute11.setText(R.string.ban_don_ya_nang_line22);

            ln7.setVisibility(View.GONE);
            ln8.setVisibility(View.GONE);
            ln9.setVisibility(View.GONE);
            ln10.setVisibility(View.GONE);
            ln11.setVisibility(View.GONE);
            ln12.setVisibility(View.GONE);
            ln13.setVisibility(View.GONE);
            ln14.setVisibility(View.GONE);
        }
        else if (firstLineBottomSheet.getText().toString().equals("สาย 23 : ตลาดเทศบาล 1 – บ้านห้วยเตย\nตลาดเทศบาล, ตลาดเทศบาล, บ.โนนตุ่น, บ.ท่าพระ, บ.หนองบัวดีหมี, บ.หนองแวง, บ.ห้วยเตย")) {
            txtMiniBusRoute1.setText(R.string.municipal_market_line23);
            txtMiniBusRoute2.setText(R.string.bueng_kaen_nakhon_line23);
            txtMiniBusRoute3.setText(R.string.ban_non_tun_line23);
            txtMiniBusRoute4.setText(R.string.ban_tha_phra_line23);
            txtMiniBusRoute5.setText(R.string.ban_nong_bua_di_mi_line23);
            txtMiniBusRoute6.setText(R.string.ban_nong_waeng_line23);
            txtMiniBusRoute7.setText(R.string.ban_huai_toei_line23);

            ln5.setVisibility(View.GONE);
            ln6.setVisibility(View.GONE);
            ln7.setVisibility(View.GONE);
            ln8.setVisibility(View.GONE);
            ln9.setVisibility(View.GONE);
            ln10.setVisibility(View.GONE);
            ln11.setVisibility(View.GONE);
            ln12.setVisibility(View.GONE);
            ln13.setVisibility(View.GONE);
            ln14.setVisibility(View.GONE);
        }









        initializeBottomSheet();

        return view;
    }

    private void initializeBottomSheet() {

        // init the bottom sheet behavior
        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(mBottomSheet);

        // change the state of the bottom sheet
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

        // change the state of the bottom sheet
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

        // set callback for changes
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                if (isAdded()) {
                    transitionBottomSheetBackgroundColor(slideOffset);
                    animateBottomSheetArrows(slideOffset);
                }
            }
        });
    }

    private void transitionBottomSheetBackgroundColor(float slideOffset) {
        int colorFrom = getResources().getColor(R.color.white);
        int colorTo = getResources().getColor(R.color.white);
        mBottomSheet.setBackgroundColor(interpolateColor(slideOffset,
                colorFrom, colorTo));
    }

    private void animateBottomSheetArrows(float slideOffset) {
        mLeftArrow.setRotation(slideOffset * -180);
        mRightArrow.setRotation(slideOffset * 180);
    }

    // Helper method to interpolate colors
    private int interpolateColor(float fraction, int startValue, int endValue) {
        int startA = (startValue >> 24) & 0xff;
        int startR = (startValue >> 16) & 0xff;
        int startG = (startValue >> 8) & 0xff;
        int startB = startValue & 0xff;
        int endA = (endValue >> 24) & 0xff;
        int endR = (endValue >> 16) & 0xff;
        int endG = (endValue >> 8) & 0xff;
        int endB = endValue & 0xff;
        return ((startA + (int) (fraction * (endA - startA))) << 24) |
                ((startR + (int) (fraction * (endR - startR))) << 16) |
                ((startG + (int) (fraction * (endG - startG))) << 8) |
                ((startB + (int) (fraction * (endB - startB))));
    }
}
