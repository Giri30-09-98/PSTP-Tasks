package com.example.assign3calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText gp;
    private EditText gp1;
    private Button gpadd;
    private Button gpsub;
    private Button gpmul;
    private Button gpdiv;
    private Button gpc;
    private TextView txtresult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gp=(EditText) findViewById(R.id.gp);
        gp1=(EditText) findViewById(R.id.gp1);
        gpadd=(Button) findViewById(R.id.gpadd);
        gpsub=(Button) findViewById(R.id.gpsub);
        gpmul=(Button) findViewById(R.id.gpmul);
        gpdiv=(Button) findViewById(R.id.gpdiv);
        gpc=(Button) findViewById(R.id.gpc);
        txtresult=(TextView) findViewById(R.id.textview);
        gpadd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if((gp.getText().length()>0) && (gp1.getText().length()>0))
                    {
                        double oper1 = Double.parseDouble(gp.getText().toString());
                        double oper2 = Double.parseDouble(gp1.getText().toString());
                        double result = oper1 + oper2;
                        txtresult.setText(Double.toString(result));
                    }
                    else{
                        Toast toast= Toast.makeText(MainActivity.this,"Enter The Required Numbers",Toast.LENGTH_LONG);
                        toast.show();
                    }
                }
            });
//Subtraction
gpsub.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if((gp.getText().length()>0) && (gp1.getText().length()>0))
                    {
                        double oper1 = Double.parseDouble(gp.getText().toString());
                        double oper2 = Double.parseDouble(gp1.getText().toString());
                        double result = oper1 - oper2;
                        txtresult.setText(Double.toString(result));
                    }
                    else{
                        Toast toast= Toast.makeText(MainActivity.this,"Enter The Required Numbers",Toast.LENGTH_LONG);
                        toast.show();
                    }

                }
            });
// Multiplication
gpmul.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if((gp.getText().length()>0) && (gp1.getText().length()>0))
                    {
                        double oper1 = Double.parseDouble(gp.getText().toString());
                        double oper2 = Double.parseDouble(gp1.getText().toString());
                        double result = oper1 * oper2;
                        txtresult.setText(Double.toString(result));
                    }
                    else{
                        Toast toast= Toast.makeText(MainActivity.this,"Enter The Required Numbers",Toast.LENGTH_LONG);
                        toast.show();
                    }
                }
            });
// Division
gpdiv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if((gp.getText().length()>0) && (gp1.getText().length()>0))
                    {
                        double oper1 = Double.parseDouble(gp.getText().toString());
                        double oper2 = Double.parseDouble(gp1.getText().toString());
                        double result = oper1 / oper2;

                        txtresult.setText(Double.toString(result));
                    }
                    else{
                        Toast toast= Toast.makeText(MainActivity.this,"Enter The Required Numbers",Toast.LENGTH_LONG);
                        toast.show();
                    }
                }
            });
// Reset Feilds
gpc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    gp.setText("");
                    gp1.setText("");
                    txtresult.setText("0.00");
                    gp.requestFocus();
                }
            });

        }
    }

