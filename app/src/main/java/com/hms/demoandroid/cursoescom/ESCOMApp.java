package com.hms.demoandroid.cursoescom;

import android.app.Application;

import com.hms.demoandroid.cursoescom.services.AnalyticsService;
import com.huawei.hms.maps.MapsInitializer;

public class ESCOMApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // Init analytics
        AnalyticsService.initAnalytics(getApplicationContext());
        //Init Maps
        MapsInitializer.initialize(this);
        MapsInitializer.setApiKey("DAEDAH4Tl4akWW3JgL+7VkN++SamtfAwRvbhXbdYknw3ff4Xt//i1LooSWb5WjQMajzEyIZWXDPOTq69+HuDQVhq74ohwq6K17LHIQ==");

    }
}
