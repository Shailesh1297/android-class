package com.example.shailesh.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shailesh.R;

import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Calculator extends AppCompatActivity implements View.OnClickListener{
    TextView calcScreen;
    LinearLayout ll;
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,add,sub,mul,div,clr,eql;
    String operand;
    int ao;
    boolean reset,eqn,op;
    StringTokenizer tk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        calcScreen=(TextView)findViewById(R.id.calcscreen);
        addButtons();
        //setting font face
        Typeface tf=Typeface.createFromAsset(getAssets(),"fonts/digital-7.ttf");
        calcScreen.setTypeface(tf);

        reset=true;
        eqn=false;
        operand="";
        op=false;

       }
    @Override
    public void onClick(View v)
    {
        if(b0==v)
        {
            if(reset){
                calcScreen.setText("0");
                reset=false;
            }else {
                operand=calcScreen.getText().toString();
                operand+="0";
                calcScreen.setText(operand);
            }
            op=false;


        }else if(b1==v)
        {
            if(reset) {
                calcScreen.setText("1");
                reset=false;
            }else {
                operand=calcScreen.getText().toString();
                operand+="1";
                calcScreen.setText(operand);
            }
            op=false;
        }else if(b2==v)
        {
            if(reset) {
                calcScreen.setText("2");
                reset=false;
            }else {
                operand=calcScreen.getText().toString();
                operand+="2";
                calcScreen.setText(operand);
            }
            op=false;
        }else if(b3==v)
        {
            if(reset){
                calcScreen.setText("3");
                reset=false;
            }else {
                operand=calcScreen.getText().toString();
                operand+="3";
                calcScreen.setText(operand);
            }
            op=false;
        }else if(b4==v)
        {
            if(reset){
                calcScreen.setText("4");
                reset=false;
            }else {
               operand=calcScreen.getText().toString();
                operand+="4";
                calcScreen.setText(operand);
            }
            op=false;
        }else if(b5==v)
        {
            if(reset){
                calcScreen.setText("5");
                reset=false;
            }else {
                operand=calcScreen.getText().toString();
                operand+="5";
                calcScreen.setText(operand);
            }
            op=false;
        }else if(b6==v)
        {
            if(reset){
                calcScreen.setText("6");
                reset=false;
            }else{
                operand=calcScreen.getText().toString();
                operand+="6";
                calcScreen.setText(operand);
            }
            op=false;
        }else if(b7==v)
        {
            if(reset) {
                calcScreen.setText("7");
                reset=false;
            }else {
               operand=calcScreen.getText().toString();
                operand+="7";
                calcScreen.setText(operand);
            }
            op=false;
        }else if(b8==v)
        {
            if(reset){
                calcScreen.setText("8");
                reset=false;
            }else{
               operand=calcScreen.getText().toString();
                operand+="8";
                calcScreen.setText(operand);
            }
            op=false;
        }else if(b9==v)
        {
            if(reset){
                calcScreen.setText("9");
                reset=false;
            }else {
               operand=calcScreen.getText().toString();
                operand+="9";
                calcScreen.setText(operand);
            }
            op=false;
        }else if(add==v)
        {

            if(eqn){

                if(!op)
                    getResult();
                else
                    operand=calcScreen.getText().toString().substring(0,calcScreen.getText().toString().length()-1);

            } else
            {
                eqn=true;
            }

            operand+="+";
            ao=1;
            calcScreen.setText(operand);
            op=true;




        }else if(sub==v)
        {
            if(eqn){

                if(!op)
                    getResult();
                else
                    operand=calcScreen.getText().toString().substring(0,calcScreen.getText().toString().length()-1);

            } else
            {
                eqn=true;
            }
            operand+="-";
            ao=2;
            calcScreen.setText(operand);
            op=true;

        }else if(div==v)
        {
            if(eqn){

                if(!op)
                     getResult();
                    else
                        operand=calcScreen.getText().toString().substring(0,calcScreen.getText().toString().length()-1);
                 } else
                {
                    eqn=true;
                }

            operand+="/";
            ao=3;
            calcScreen.setText(operand);
            op=true;
        }else if(mul==v)
        {
            if(eqn){

                if(!op) {
                    getResult();

                }else
                {
                    operand=calcScreen.getText().toString().substring(0,calcScreen.getText().toString().length()-1);
                }


            } else
            {
                eqn=true;
            }

            operand+="*";
            ao=4;
            calcScreen.setText(operand);
            op=true;
        }else if(clr==v)
        {
           calcScreen.setText("0");
           ao=0;
           reset=true;
           eqn=false;

        }else if(eql==v)
        {
           if(eqn)
           {
               getResult();
               calcScreen.setText(operand);
               ao=0;
           }
        }

        Log.d("operand",operand);

    }

    private void getResult()
    {

        switch(ao)
        {
            case 1:
                 tk=new StringTokenizer(calcScreen.getText().toString(),"+");
                 operand=""+(Integer.parseInt(tk.nextToken())+Integer.parseInt(tk.nextToken()));

                break;
            case 2:
                tk=new StringTokenizer(calcScreen.getText().toString(),"-");

                operand=""+(Integer.parseInt(tk.nextToken())-Integer.parseInt(tk.nextToken()));

                break;
            case 3:
                tk=new StringTokenizer(calcScreen.getText().toString(),"/");
                operand=""+(Integer.parseInt(tk.nextToken())/Integer.parseInt(tk.nextToken()));
                break;
            case 4:
                tk=new StringTokenizer(calcScreen.getText().toString(),"*");
                operand=""+(Integer.parseInt(tk.nextToken())*Integer.parseInt(tk.nextToken()));
                break;
            case 5:
                break;
        }
    }

    void addButtons()
    {
        ll=findViewById(R.id.mainLayout);
        b0=(Button)ll.findViewById(R.id.button0);
        b1=(Button)ll.findViewById(R.id.button1);
        b2=(Button)ll.findViewById(R.id.button2);
        b3=(Button)ll.findViewById(R.id.button3);
        b4=(Button)ll.findViewById(R.id.button4);
        b5=(Button)ll.findViewById(R.id.button5);
        b6=(Button)ll.findViewById(R.id.button6);
        b7=(Button)ll.findViewById(R.id.button7);
        b8=(Button)ll.findViewById(R.id.button8);
        b9=(Button)ll.findViewById(R.id.button9);
        add=(Button)ll.findViewById(R.id.buttonAdd);
        sub=(Button)ll.findViewById(R.id.buttonSub);
        mul=(Button)ll.findViewById(R.id.buttonMul);
        div=(Button)ll.findViewById(R.id.buttonDiv);
        clr=(Button)ll.findViewById(R.id.buttonClear);
        eql=(Button)ll.findViewById(R.id.buttonEql);

        b0.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);
        clr.setOnClickListener(this);
        eql.setOnClickListener(this);

    }
}
