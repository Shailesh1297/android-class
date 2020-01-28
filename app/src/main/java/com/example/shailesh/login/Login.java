package com.example.shailesh.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shailesh.MainActivity;
import com.example.shailesh.R;

public class Login extends AppCompatActivity {

    TextView lbl_email,lbl_password;
    EditText et1,et2;
    //Button bt_login;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        addWidgets();

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),""+sum(),Toast.LENGTH_LONG).show();
            }
        });
    }

    int sum()
    {
        return Integer.parseInt(et1.getText().toString())+Integer.parseInt(et2.getText().toString());
    }

    private void addWidgets()
    {
        iv=findViewById(R.id.iv_login);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
    }
}
