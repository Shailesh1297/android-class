package com.example.shailesh.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.shailesh.MainActivity;
import com.example.shailesh.R;

public class WeightConverter extends AppCompatActivity {

    EditText et_kg,et_pounds;
    Button kg_lbs,lbs_kg,menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_converter);

        et_kg=findViewById(R.id.et_kgs);
        et_pounds=findViewById(R.id.et_pound);

        kg_lbs=findViewById(R.id.kg_to_pound);
        lbs_kg=findViewById(R.id.pound_to_kg);
        menu=findViewById(R.id.menu_btn);


        kg_lbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float weight=Float.parseFloat(et_kg.getText().toString());
                weight= (float) ((Float)weight*2.21);
                et_pounds.setText(""+weight);

            }
        });

        lbs_kg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float weight=Float.parseFloat(et_pounds.getText().toString());
                weight= (float)((Float)weight*0.45);
                et_kg.setText(""+weight);
            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
