package com.example.shailesh.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shailesh.R;

public class ImplicitIntent extends AppCompatActivity {

    TextView explicit_txt;
    Button implicit_but;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);

        implicit_but=findViewById(R.id.implicit_intent);

        //Implicit Intent
        implicit_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.google.com/"));
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Implicit-Intent",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void onResume()
    {
        super.onResume();
        Toast.makeText(getApplicationContext(),"Explicit-Intent",Toast.LENGTH_LONG);
    }
}
