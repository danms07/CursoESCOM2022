package com.hms.demoandroid.cursoescom.services;

import android.content.Context;
import android.os.Bundle;

import com.huawei.hms.analytics.HiAnalytics;
import com.huawei.hms.analytics.HiAnalyticsInstance;
import com.huawei.hms.analytics.HiAnalyticsTools;

public class AnalyticsService {
    private static HiAnalyticsInstance INSTANCE = null;

    public static void initAnalytics(Context context) {
        if (INSTANCE == null) {
            HiAnalyticsTools.enableLog();
            INSTANCE = HiAnalytics.getInstance(context);
        }
    }

    public void setUserProfile(String name) throws Exception {
        if (INSTANCE == null) throw new Exception("Analytics not init");

        INSTANCE.setUserProfile("userKey",name);
    }

    public void sendEvent(String name, Bundle data) throws Exception {
        if (INSTANCE == null) throw new Exception("Analytics not init");

        INSTANCE.onEvent(name, data);
    }
}
