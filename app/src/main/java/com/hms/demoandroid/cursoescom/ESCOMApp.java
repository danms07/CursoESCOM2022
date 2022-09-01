package com.hms.demoandroid.cursoescom;

import android.app.Application;

import com.hms.demoandroid.cursoescom.services.AnalyticsService;

public class ESCOMApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // Init analytics
        AnalyticsService.initAnalytics(getApplicationContext());
    }
}
