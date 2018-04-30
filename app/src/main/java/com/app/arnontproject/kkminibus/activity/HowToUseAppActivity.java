package com.app.arnontproject.kkminibus.activity;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;
import android.view.View;

import com.akexorcist.localizationactivity.ui.LocalizationActivity;
import com.app.arnontproject.kkminibus.R;
import com.app.arnontproject.kkminibus.adapter.ZoomableImageView;

public class HowToUseAppActivity extends LocalizationActivity {

    TextView txtHowTo;

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

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.howto_01);
        ZoomableImageView touch = findViewById(R.id.imgHowTo);
        touch.setImageBitmap(bitmap);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.pop_out, R.anim.pop_out_exit);
    }


}
