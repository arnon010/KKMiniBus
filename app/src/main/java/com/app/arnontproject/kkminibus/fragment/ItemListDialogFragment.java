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
