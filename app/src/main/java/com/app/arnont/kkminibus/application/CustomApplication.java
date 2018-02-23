package com.app.arnont.kkminibus.application;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import com.akexorcist.localizationactivity.core.LocalizationApplicationDelegate;

/**
 * Created by arnont on 2/23/18.
 */

public class CustomApplication extends Application {
    LocalizationApplicationDelegate localizationDelegate = new LocalizationApplicationDelegate(this);

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(localizationDelegate.attachBaseContext(base));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        localizationDelegate.onConfigurationChanged(this);
    }

    @Override
    public Context getApplicationContext() {
        return localizationDelegate.getApplicationContext(super.getApplicationContext());
    }
}
