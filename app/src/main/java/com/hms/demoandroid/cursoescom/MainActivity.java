package com.hms.demoandroid.cursoescom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.hms.demoandroid.cursoescom.services.AnalyticsService;
import com.huawei.hms.maps.CameraUpdate;
import com.huawei.hms.maps.CameraUpdateFactory;
import com.huawei.hms.maps.HuaweiMap;
import com.huawei.hms.maps.MapView;
import com.huawei.hms.maps.MapsInitializer;
import com.huawei.hms.maps.OnMapReadyCallback;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.MarkerOptions;

import java.util.Date;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, OnMapReadyCallback
{
    private static final String TAG = "ESCOM - MainActivity";
    private final AnalyticsService aService = new AnalyticsService();
    private int nClicks = 0;
    private MapView mapView;
    /* AppCompatActivity */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /* MainActivity */
    private void initView() {
        findViewById(R.id.button).setOnClickListener(this);
        mapView=findViewById(R.id.mapView);
        mapView.onCreate(null);
        mapView.getMapAsync(this);
    }

    /* View.OnClickListener */
    @Override
    public void onClick(View v) {
        nClicks++;
        Bundle data = new Bundle();

        Toast.makeText(
                getApplicationContext(),
                "Clicks: " + nClicks,
                Toast.LENGTH_SHORT
        ).show();
        data.putString("Date", new Date().toString());
        data.putInt("nClicks", nClicks);

        try {
            aService.sendEvent("MyButtonClick", data);
        } catch (Exception e) {
            Log.e(TAG, "Analytics not init");
        }
    }

    @Override
    public void onMapReady(HuaweiMap huaweiMap) {
        if(huaweiMap!=null){
            //Hacer algo con el mapa
            LatLng escom = new LatLng(19.5041795,-99.1467116);
            MarkerOptions markerEscom=new MarkerOptions();
            markerEscom.position(escom);
            huaweiMap.addMarker(markerEscom);

            CameraUpdate cameraUpdate= CameraUpdateFactory.newLatLngZoom(escom,15f);
            huaweiMap.animateCamera(cameraUpdate);
        }
    }
}