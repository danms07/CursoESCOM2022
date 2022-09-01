package com.hms.demoandroid.cursoescom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.hms.demoandroid.cursoescom.services.AnalyticsService;

import java.util.Date;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener
{
    private static final String TAG = "ESCOM - MainActivity";
    private final AnalyticsService aService = new AnalyticsService();
    private int nClicks = 0;
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
}