package com.example.shailesh.contacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shailesh.R;

import java.util.ArrayList;

public class ContactAdapter extends BaseAdapter {
    Context context;
    ArrayList<String>contactName;
    ArrayList<String>contactNumber;
    LayoutInflater layoutInflater;

    ContactAdapter(Context context, ArrayList<String>name,ArrayList<String>number)
    {
        this.context=context;
        contactName=name;
        contactNumber=number;
        layoutInflater=LayoutInflater.from(context);


    }
    @Override
    public int getCount() {
        return contactName.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView name,number;
        ImageView call;
        view=layoutInflater.inflate(R.layout.contact_list,null);
        name=(TextView)view.findViewById(R.id.contact_name);
        number=(TextView)view.findViewById(R.id.contact_number);
        call=(ImageView)view.findViewById(R.id.call_img);
        name.setText("Name:"+contactName.get(i));
        number.setText("Number:"+contactNumber.get(i));
        return view;
    }
}
