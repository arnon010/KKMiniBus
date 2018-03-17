package com.app.arnont.kkminibus.fragment;

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

import com.app.arnont.kkminibus.R;



public class ItemListDialogFragment extends BottomSheetDialogFragment {

    private LinearLayout mBottomSheet;

    private ImageView mLeftArrow;

    private ImageView mRightArrow;

    TextView firstLineBottomSheet , secondLineBottomSheet;
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

        String savedExtra = getActivity().getIntent().getStringExtra("minibus");
        firstLineBottomSheet = view.findViewById(R.id.firstLineBottomSheet);
        firstLineBottomSheet.setText(savedExtra);
        String savedExtra2 = getActivity().getIntent().getStringExtra("btsMinibus2");
        secondLineBottomSheet = view.findViewById(R.id.secondLineBottomSheet);
        secondLineBottomSheet.setText(savedExtra2);
        Integer savedExtra3 = getActivity().getIntent().getIntExtra("image",0);
        iconBottomSheet = view.findViewById(R.id.iconBottomSheet);
        iconBottomSheet.setImageResource(savedExtra3);

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
        int colorFrom = getResources().getColor(R.color.black);
        int colorTo = getResources().getColor(R.color.blackAlpha60);
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
