package com.example.shailesh.contacts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.*;

import com.example.shailesh.R;

import java.math.BigInteger;
import java.util.ArrayList;

public class Contacts extends AppCompatActivity {

    ListView contactList;

    ArrayList<String> contactName = new ArrayList<String>();
    ArrayList<String> contactNumber = new ArrayList<String>();

    Cursor cursor;
    private static final int READ_CONTACTS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        permissionCheck();

        contactList = findViewById(R.id.contact_list_view);
        ContactAdapter ca = new ContactAdapter(getApplicationContext(), contactName, contactNumber);
        contactList.setAdapter(ca);
        contactList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView number = (TextView) view.findViewById(R.id.contact_number);
                String callNumber = number.getText().toString().substring(7);
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + callNumber));

                //permissions for calling
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                   ActivityCompat.requestPermissions(Contacts.this,new String[]{Manifest.permission.CALL_PHONE},1);
                }else
                {
                    startActivity(intent);
                }
            }
        });


    }

    public void permissionCheck() {
        //checking for permission of reading contacts
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS);
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            getContacts();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, READ_CONTACTS);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==READ_CONTACTS)
        {
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                getContacts();
            }else
            {
                Toast.makeText(getApplicationContext(),"permission required",Toast.LENGTH_LONG).show();
            }
        }
    }

    //getting contacts

    public void getContacts()
    {
     cursor=getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,ContactsContract.Contacts.DISPLAY_NAME+" ASC") ;

     while(cursor.moveToNext())
     {
         String name=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
         String number=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
         //adding to arrayList
         contactName.add(name);
         contactNumber.add(number);
     }
     cursor.close();
    }
}
