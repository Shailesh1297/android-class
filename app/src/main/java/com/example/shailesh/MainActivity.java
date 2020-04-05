package com.example.shailesh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.shailesh.broadcasting.Broadcast;
import com.example.shailesh.calculator.Calculator;

import com.example.shailesh.contacts.Contacts;
import com.example.shailesh.database.DatabaseSqlite;
import com.example.shailesh.fragments.MyFragment;
import com.example.shailesh.intents.ImplicitIntent;
import com.example.shailesh.simplecalculator.SimpleCalculator;

public class MainActivity extends AppCompatActivity {
   Button butCalc,butLog,butReg,butCP,butBR,butFR,butDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(MainActivity.this,"OnCreate",Toast.LENGTH_LONG).show();
                                //getApplicationContext()

        butCalc=(Button)findViewById(R.id.butCalc);
        butLog=findViewById(R.id.btnLogin);
        butReg=findViewById(R.id.reg);
        butCP=findViewById(R.id.content_provider_but);
        butBR=findViewById(R.id.broadcast_receiver_but);
        butFR=findViewById(R.id.fragment_but);
        butDB=findViewById(R.id.sql_but);

        //simple calculator
        butLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calintent=new Intent(getBaseContext(), SimpleCalculator.class);
                startActivity(calintent);
            }
        });


        //advance calculator
        butCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent calintent=new Intent(getBaseContext(),Calculator.class);
                startActivity(calintent);

            }
        });

        //Explicit Intent
        butReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(), ImplicitIntent.class);

                startActivity(intent);
            }
        });

        //content provider
        butCP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  intent=new Intent(getApplicationContext(), Contacts.class);
                startActivity(intent);
            }
        });
     //broadcast Receiver
        butBR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  intent=new Intent(getApplicationContext(), Broadcast.class);
                startActivity(intent);
            }
        });

        //fragment manager
        butFR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  intent=new Intent(getApplicationContext(), MyFragment.class);
                startActivity(intent);
            }
        });

        //databse sqlite
        butDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  intent=new Intent(getApplicationContext(), DatabaseSqlite.class);
                startActivity(intent);
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
