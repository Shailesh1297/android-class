package com.example.shailesh.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.shailesh.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOne extends Fragment {
    Button bmi;
    EditText weight,height;
    TextView tv;
    public FragmentOne() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_one, container, false);
       bmi=(Button)view.findViewById(R.id.bmi_calc);
       weight=(EditText)view.findViewById(R.id.weight);
       height=(EditText)view.findViewById(R.id.height);
       tv=(TextView)view.findViewById(R.id.bmi_txt);

       bmi.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               float wt=Float.parseFloat(weight.getText().toString());
               float ht=Float.parseFloat(height.getText().toString())/100;
               float b=wt/(ht*ht);


               if(b<18.5)
               {
                tv.setText("BMI:"+String.format("%.2f",b)+" "+"Thin");

               }else if(b>25.0)
               {
                   tv.setText("BMI:"+String.format("%.2f",b)+" "+"OverWeight");
               }else
               {
                   tv.setText("BMI:"+String.format("%.2f",b)+" "+"Normal");
               }
           }
       });


        return view;

    }
}
