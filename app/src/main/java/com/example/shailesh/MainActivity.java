package com.example.shailesh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.shailesh.calculator.Calculator;
import com.example.shailesh.simplecalculator.SimpleCalculator;

public class MainActivity extends AppCompatActivity {
   Button butCalc,butLog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(MainActivity.this,"OnCreate",Toast.LENGTH_LONG).show();
                                //getApplicationContext()

        butCalc=(Button)findViewById(R.id.butCalc);
        butLog=findViewById(R.id.btnLogin);

        butLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calintent=new Intent(getBaseContext(), SimpleCalculator.class);
                startActivity(calintent);
            }
        });
        butCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent calintent=new Intent(getBaseContext(),Calculator.class);
                startActivity(calintent);

            }
        });
    }

    public void toast(String msg)
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
