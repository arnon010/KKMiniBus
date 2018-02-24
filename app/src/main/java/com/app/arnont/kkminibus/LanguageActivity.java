package com.app.arnont.kkminibus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.akexorcist.localizationactivity.ui.LocalizationActivity;

public class LanguageActivity extends LocalizationActivity implements View.OnClickListener {


    Switch switchLanguage;
    Button btn_th, btn_en;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        btn_th = findViewById(R.id.btn_th);
        btn_en = findViewById(R.id.btn_en);

        btn_th.setOnClickListener(this);
        btn_en.setOnClickListener(this);

//        switchLanguageMode();
    }



    private void switchLanguageMode() {
        if (switchLanguage != null) {
        switchLanguage.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    switchLanguage.setText("EN");
                    setLanguage("en");
                } else {
                    switchLanguage.setText("TH");
                    setLanguage("th");
                }
            }
        });
    }
    }


    @Override
    public void onClick(View v) {

        int id = v.getId();
        if (id == R.id.btn_en) {
            setLanguage("en");
        } else if (id == R.id.btn_th) {
            setLanguage(("th"));
        }


    }
}
