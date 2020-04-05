package com.example.shailesh.broadcasting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.shailesh.R;

public class Broadcast extends AppCompatActivity {
    Switch wifiSwitch;
    private WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);

        wifiManager=(WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        wifiSwitch=findViewById(R.id.wifi_switch);

        wifiSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b)
                {
                    wifiManager.setWifiEnabled(true);
                    wifiSwitch.setText("ON");
                }else {
                    wifiManager.setWifiEnabled(false);
                   wifiSwitch.setText("OFF");
                }
            }
        });


    }

    @Override
    protected void onStart()
    {
        super.onStart();
        IntentFilter intentFilter=new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION);
        registerReceiver(wifiStateReceiver,intentFilter);

    }
    @Override
    protected void onStop()
    {
        super.onStop();
        unregisterReceiver(wifiStateReceiver);

    }


    private BroadcastReceiver wifiStateReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            int wifiState=intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE,WifiManager.WIFI_STATE_UNKNOWN);

            if(wifiState==WifiManager.WIFI_STATE_ENABLED)
            {
                wifiSwitch.setChecked(true);
                wifiSwitch.setText("ON");
            }

            if(wifiState==WifiManager.WIFI_STATE_DISABLED)
            {
                wifiSwitch.setChecked(false);
                wifiSwitch.setText("OFF");
            }

        }
    };
}
