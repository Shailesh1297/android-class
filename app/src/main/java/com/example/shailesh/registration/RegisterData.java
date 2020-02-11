package com.example.shailesh.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.shailesh.R;

public class RegisterData extends AppCompatActivity {
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_data);
        tv=findViewById(R.id.showText);
        tv.setText(getIntent().getStringExtra("Name"));

    }
}
