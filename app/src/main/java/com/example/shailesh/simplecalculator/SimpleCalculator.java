package com.example.shailesh.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shailesh.R;

import java.lang.reflect.Array;

public class SimpleCalculator extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    EditText operand_1,operand_2;
    TextView result;
    Button calculate;
    Spinner op_spinner;
    String []operators={"+","-","*","/","%"};
    String op="+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_calculator);
        addWidget();

        ArrayAdapter aa=new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,operators);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        op_spinner.setAdapter(aa);
        op_spinner.setOnItemSelectedListener(this);

        calculate.setOnClickListener(this);
    }

    void addWidget()
    {
        operand_1=findViewById(R.id.operand_1);
        operand_2=findViewById(R.id.operand_2);
        calculate=findViewById(R.id.calculate);
        op_spinner=findViewById(R.id.operator_spinner);
        result=findViewById(R.id.result);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               op=operators[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        int a=Integer.parseInt(operand_1.getText().toString());
        int b=Integer.parseInt(operand_2.getText().toString());

        if(op=="+")
        {
            result.setText(""+(a+b));
            toast(""+(a+b));
        }
        if(op=="-")
        {
            result.setText(""+(a-b));
            toast(""+(a-b));
        }
        if(op=="*")
        {
            result.setText(""+(a*b));
            toast(""+(a*b));
        }
        if(op=="/")
        {
            result.setText(""+(a/b));
            toast(""+(a/b));
        }
        if(op=="%")
        {
            result.setText(""+(a%b));
            toast(""+(a%b));
        }
    }

    void toast(String msg)
    {
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }
}
