package com.app.arnontproject.kkminibus.activity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import com.akexorcist.localizationactivity.ui.LocalizationActivity;
import com.app.arnontproject.kkminibus.R;
import com.app.arnontproject.kkminibus.fragment.ItemListDialogFragment;

public class DetailMiniBusActivity extends LocalizationActivity {

    TextView txtMiniBusDetail;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_mini_bus);

        Toolbar toolbar = findViewById(R.id.toolbarDetailMiniBus);
        toolbar.setTitle(R.string.detail_mini_bus);
        setActionBar(toolbar);
        getSupportActionBar().hide();
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


        ItemListDialogFragment fragment = ItemListDialogFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container,fragment).commit();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.pop_out, R.anim.pop_out_exit);
    }
}
