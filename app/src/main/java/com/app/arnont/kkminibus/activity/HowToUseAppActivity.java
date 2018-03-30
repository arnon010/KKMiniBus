package com.app.arnont.kkminibus.activity;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;
import android.view.View;

import com.akexorcist.localizationactivity.ui.LocalizationActivity;
import com.app.arnont.kkminibus.R;

public class HowToUseAppActivity extends LocalizationActivity {

    TextView txtHowTo;
    ImageView imgHowTo;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_use_app);

        Toolbar toolbar = findViewById(R.id.toolbarHowTo);
        toolbar.setTitle(R.string.how_to_use);
        setActionBar(toolbar);
        getSupportActionBar().hide();
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        txtHowTo = findViewById(R.id.txtHowTo);
        imgHowTo = findViewById(R.id.imgHowTo);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.pop_out, R.anim.pop_out_exit);
    }


}
