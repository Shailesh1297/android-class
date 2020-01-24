package com.example.shailesh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(MainActivity.this,"OnCreate",Toast.LENGTH_LONG).show();
                                //getApplicationContext()
    }

    protected void toast(String msg)
    {
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }
@Override
    protected void onStart()
    {
        super.onStart();
        toast("OnStart");
       // Toast.makeText(getApplicationContext(),"OnStart",Toast.LENGTH_SHORT).show();
    }
@Override
    protected  void onPause()
    {
        super.onPause();
        toast("OnPause");

    }
@Override
    protected void onResume()
    {
        super.onResume();
        toast("OnResume");
    }
@Override
    protected void onDestroy()
    {
        super.onDestroy();
        toast("OnDestroy");
    }
    @Override
    protected void onRestart()
    {
        super.onRestart();
        toast("OnRestart");
    }
}
