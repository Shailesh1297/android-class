package com.example.shailesh.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.shailesh.R;
import com.example.shailesh.converter.WeightConverter;

public class Splash extends AppCompatActivity {

    boolean handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        handler=new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(getBaseContext(), WeightConverter.class);
                startActivity(intent);
                finish();

            }
        },2000);
    }
}
