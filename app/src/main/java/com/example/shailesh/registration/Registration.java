package com.example.shailesh.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.shailesh.R;

public class Registration extends AppCompatActivity {

    EditText name,mobile,email,city,state;
    Button rButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        addWidgets();
        rButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calintent=new Intent(getBaseContext(), RegisterData.class);
                calintent.putExtra("Name",name.getText().toString());
                startActivity(calintent);
            }
        });


    }

  public  void addWidgets()
    {
        name=findViewById(R.id.registerName);
        mobile=findViewById(R.id.registerMobile);
        email=findViewById(R.id.registerEmail);
        city=findViewById(R.id.registerCity);
        state=findViewById(R.id.registerState);
        rButton=findViewById(R.id.registerButton);
    }

}
