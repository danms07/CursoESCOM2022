package com.hms.demoandroid.cursoescom;

import android.util.Log;

import com.huawei.hms.push.HmsMessageService;
import com.huawei.hms.push.RemoteMessage;

public class HMSPushService extends HmsMessageService {
    @Override
    public void onNewToken(String token) {
        //Reportar el token al servidor
        Log.e("token",token);
        super.onNewToken(token);
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
    }
}
