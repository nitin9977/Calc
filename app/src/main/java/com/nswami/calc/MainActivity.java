package com.nswami.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
//import java.lang.strings;

public class MainActivity extends AppCompatActivity {

    private Button num1;
    private Button num2;
    private Button num3;
    private Button num4;
    private Button num5;
    private Button num6;
    private Button num7;
    private Button num8;
    private Button num9;
    private Button num0;
    private Button div;
    private Button mul;
    private Button add;
    private Button sub;
    private Button clr;
    private Button eq;
    private TextView info;
    private TextView result;
    private TextView val1_t;
    private TextView val2_t;

    private final char ADD = '+';
    private final char SUB = '-';
    private final char MUL = '*';
    private final char DIV = '/';
    private final char EQ = '0';

    private double val1 = Double.NaN;
    private double val2=0;

    private char action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUIViews();

        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText() + "0");
            }
        });
        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText() + "1");
            }
        });
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText() + "2");
            }
        });
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText() + "3");
            }
        });
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText() + "4");
            }
        });
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText() + "5");
            }
        });
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText() + "6");
            }
        });
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText() + "7");
            }
        });
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText() + "8");
            }
        });
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText() + "9");
            }
        });
        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText() + "0");
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                action = ADD;
                result.setText(String.valueOf(val1) + "+");
                //val1_t.setText(String.valueOf(val1));
                info.setText(null);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                action = SUB;
                result.setText(String.valueOf(val1) + "-");
                //val1_t.setText(String.valueOf(val1));
                info.setText(null);
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                action = MUL;
                result.setText(String.valueOf(val1) + "*");
                //val1_t.setText(String.valueOf(val1));
                info.setText(null);
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                action = DIV;
                result.setText(String.valueOf(val1) + "/");
                //val1_t.setText(String.valueOf(val1));
                info.setText(null);
            }
        });
        eq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                action = EQ;
                result.setText(result.getText().toString() + String.valueOf(val2) + "=" + String.valueOf(val1));
                //val1_t.setText(String.valueOf(val1));
                val2_t.setText(String.valueOf(val2));
                info.setText(null);
            }
        });
        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(info.getText().length() > 0){
                    CharSequence name = info.getText().toString();
                    info.setText(name.subSequence(0,name.length()-1));
                }
                else{
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    result.setText(null);
                    info.setText(null);
                }
            }
        });

    }

    private void setupUIViews(){
        val1 = 0;
        num0 = (Button)findViewById(R.id.button0);
        num1 = (Button)findViewById(R.id.button1);
        num2 = (Button)findViewById(R.id.button2);
        num3 = (Button)findViewById(R.id.button3);
        num4 = (Button)findViewById(R.id.button4);
        num5 = (Button)findViewById(R.id.button5);
        num6 = (Button)findViewById(R.id.button6);
        num7 = (Button)findViewById(R.id.button7);
        num8 = (Button)findViewById(R.id.button8);
        num9 = (Button)findViewById(R.id.button9);
        add = (Button)findViewById(R.id.button_add);
        div = (Button)findViewById(R.id.button_div);
        sub = (Button)findViewById(R.id.button_sub);
        mul = (Button)findViewById(R.id.button_mul);
        eq = (Button)findViewById(R.id.button_eq);
        clr = (Button)findViewById(R.id.button_clr);
        info = (TextView)findViewById(R.id.textView_ctrl);
        result = (TextView)findViewById(R.id.textView_result);
        val1_t = (TextView)findViewById(R.id.textView_val1);
        val2_t = (TextView)findViewById(R.id.textView_val2);
    }

    private void compute(){
        if(!Double.isNaN(val1)){
            val2 = Double.parseDouble(info.getText().toString());
            val2_t.setText(String.valueOf(val2));
            switch (action){
                case ADD:
                    val1 = val1 + val2;
                    break;
                case SUB:
                    val1 = val1 - val2;
                    break;
                case MUL:
                    val1 = val1 * val2;
                    break;
                case DIV:
                    val1 = val1 / val2;
                    break;
                case EQ:
                    break;
            }
        }
        else{
            val1 = Double.parseDouble(info.getText().toString());
            val1_t.setText(String.valueOf(val1));
        }
    }
}
