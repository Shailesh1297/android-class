package com.example.shailesh.database;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shailesh.R;

public class DatabaseSqlite extends AppCompatActivity implements View.OnClickListener {

    EditText name,email;
    Button insert,retrieve;
    DatabaseHelper dh;
    SQLiteDatabase sql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_sqlite);
        name=findViewById(R.id.data_name);
        email=findViewById(R.id.data_email);
        insert=findViewById(R.id.insert_data);
        retrieve=findViewById(R.id.show_data);

        dh=new DatabaseHelper(this);

        insert.setOnClickListener(this);
        retrieve.setOnClickListener(this);

    }


    @Override
    public void onClick(View v)
    {
        String st_name=name.getText().toString();
        String st_email=email.getText().toString();

        if(v==insert)
        {
            if(TextUtils.isEmpty(st_name)||TextUtils.isEmpty(st_email))
            {
                Toast.makeText(getApplicationContext(),"All Fields are Required",Toast.LENGTH_LONG).show();
            }else
            {
                boolean isInserted=dh.insertData(st_name,st_email);
                if(isInserted)
                {
                    name.setText("");
                    email.setText("");
                    Toast.makeText(getApplicationContext(),"Data Inserted",Toast.LENGTH_LONG).show();
                }else
                {
                    Toast.makeText(getApplicationContext(),"Data NOT Inserted",Toast.LENGTH_LONG).show();
                }
            }

        }

        if(v==retrieve)
        {
            Cursor result=dh.getData();

            if(result.getCount()==0)
            {
                showData("Alert","Nothing Found");
            }else
            {
                StringBuffer sb=new StringBuffer();
                while(result.moveToNext())
                {
                    sb.append("ID:"+result.getString(0)+"\n");
                    sb.append("Name:"+result.getString(1)+"\n");
                    sb.append("Email:"+result.getString(2)+"\n\n");
                }
                showData("Data",sb.toString());
            }

        }
    }

    public void showData(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
