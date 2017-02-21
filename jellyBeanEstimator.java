//***************************************************************************
//Joshua Fung
//CMSC 355 2017
//Programming Assignment 2
//Jelly Bean Counter App project
//***************************************************************************
package com.example.fungu.beancalculator;
//imports all different widgets and packages
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;

public class jellyBeanEstimator extends AppCompatActivity {
//initializes variables
    public TextView jellybeanLen;
    public TextView jellybeanDia;
    public TextView jarSize;
    private TextView jellyAnswer;
    private TextView jellyAnswer1;


    private EditText editLen;
    private EditText editDia;
    private EditText editSize;

    private Button calculate;
    private double jarSpace;
    private double beanSize;
    private double totalBeans;

    public String streditSize;
    public String streditLen;
    public String streditDia;
    public float roundedTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bean_calculator);

        editLen = (EditText) findViewById(R.id.editLen); //sets EditText widgets to variables
        editDia = (EditText) findViewById(R.id.editDia);
        editSize = (EditText) findViewById(R.id.editSize);
        calculate = (Button) findViewById(R.id.calculate);
        jellyAnswer1 = (TextView) findViewById(R.id.jellyAnswer1);


        calculate.setOnClickListener(new View.OnClickListener() //sets button on click

        {

            public void onClick(View v) { //when button is clicked...
                double a, b, c;  //initializes variables as doubles

                streditSize = editSize.getText().toString(); //converts numbers to strings
                streditLen = editLen.getText().toString();
                streditDia = editDia.getText().toString();





                if (!streditLen.trim().equals("") && (!streditDia.trim().equals("") && !streditSize.trim().equals("") && //exception handeling
                        !streditLen.equals("0") && !streditDia.equals("0") && !streditSize.equals("0"))) {
                    a = Double.parseDouble(editSize.getText().toString()); //parses the strings as doubles
                    b = Double.parseDouble(editDia.getText().toString());
                    c = Double.parseDouble(editLen.getText().toString());




                    jarSpace = a * (0.545); //gets actual size of jar by multiplying load factor
                    beanSize = (Math.PI / 6) * (Math.pow(b, 2)) * c; //equation that gets bean volume
                    totalBeans = jarSpace / beanSize; // equation that finds total number of beans

                    roundedTotal = new Float( Math.round(totalBeans)); //rounds answer to nearest whole number


                    jellyAnswer1.setText(String.valueOf(roundedTotal + " Beans in the jar")); //sets answer to edittext box
                }
                else {


                        jellyAnswer1.setText("Please complete all fields with positive numbers greater than 0"); //message when user inputs wrong
                    }
                }



        });
    }
}
