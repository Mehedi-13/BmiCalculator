package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private android.widget.Button calculate;
    private TextView currentHeiht, currentagE,currentWeighT;
   private ImageView increMentage, increMentWeight,decrementAge,decreMentWeight;
    private SeekBar seekBar;
    private RelativeLayout male, female;

    private int  intAge=22,intWeight=55,currentprogress;
    private String intProgress="170",typeofUser="0",weight2="55",age2="32";
   



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        calculate= findViewById(R.id.calculator);
        currentHeiht= findViewById(R.id.currentHeight);
        currentagE= findViewById(R.id.currentAge);
        currentWeighT= findViewById(R.id.currentWeight);

        increMentage= findViewById(R.id.incrementAge);
        increMentWeight= findViewById(R.id.incrementWeight);
        decrementAge= findViewById(R.id.decrementAge);
        decreMentWeight= findViewById(R.id.decrementWeight);

        seekBar= findViewById(R.id.seekbarforHeight);
        male= findViewById(R.id.male);
        female= findViewById(R.id.female);




        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.male_female_focus));
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.male_female_no_focuse));
                typeofUser="Male";
            }
        });


        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.male_female_focus));
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.male_female_no_focuse));
                typeofUser="Female";
            }
        });


        seekBar.setMax(300);
        seekBar.setProgress(170);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentprogress=progress;
                intProgress=String.valueOf(currentprogress);
                currentHeiht.setText(intProgress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        increMentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intAge= intAge+1;
                age2=String.valueOf(intAge);
                currentagE.setText(age2);
            }
        });


        decrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intAge= intAge-1;
                age2=String.valueOf(intAge);
                currentagE.setText(age2);
            }
        });


        increMentWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intWeight= intWeight+1;
                weight2=String.valueOf(intWeight);
                currentWeighT.setText(weight2);
            }
        });

        decreMentWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intWeight= intWeight-1;
                weight2=String.valueOf(intWeight);
                currentWeighT.setText(weight2);
            }
        });






        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (typeofUser.equals("0")){
                    Toast.makeText(MainActivity.this, "Select your Gender First", Toast.LENGTH_SHORT).show();
                }
                else if (intProgress.equals("0")){
                    Toast.makeText(MainActivity.this, "Select your Height First", Toast.LENGTH_SHORT).show();
                }
                else if (intAge==0 || intAge<0){
                    Toast.makeText(MainActivity.this, "Age is Incorrect", Toast.LENGTH_SHORT).show();
                }
                else if (intWeight==0 || intWeight<0){
                    Toast.makeText(MainActivity.this, "Weight is Incorrect", Toast.LENGTH_SHORT).show();
                }
                else {

                    Intent intent= new Intent( MainActivity.this,BmiActivity.class);
                   intent.putExtra("gender",typeofUser);
                   intent.putExtra("height",intProgress);
                   intent.putExtra("weight",weight2);
                   intent.putExtra("age",age2);
                    startActivity(intent);

                }



            }
        });
    }
}