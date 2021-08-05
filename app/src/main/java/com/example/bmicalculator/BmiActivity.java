package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BmiActivity extends AppCompatActivity {

    private android.widget.Button reCalculate;
    private TextView display,category,gender;
    Intent intent;
    ImageView imageView;
    String mBMI;
    float intBMI;

    String weight, height;
    float intHight,intWeight;
    RelativeLayout background;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));
        getSupportActionBar().setTitle("Result");
        ColorDrawable colorDrawable= new ColorDrawable(Color.parseColor("#1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        reCalculate= findViewById(R.id.recalculatBMI);
        display= findViewById(R.id.bmiDisplay);
        category= findViewById(R.id.bmiCat);
        background= findViewById(R.id.contentLayout);
        imageView=findViewById(R.id.imageView);
        gender=findViewById(R.id.genderDisplay);

        intent=getIntent();

        height= intent.getStringExtra("height");
        weight= intent.getStringExtra("weight");

        intHight= Float.parseFloat(height);
        intWeight= Float.parseFloat(weight);



        intHight=intHight/100;

        intBMI= intWeight/(intHight*intHight);

        mBMI=Float.toString(intBMI);

        if (intBMI<=16){
            category.setText("Severe Thinness");
            background.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.crosss);
        }
        else if (intBMI<=16.9 && intBMI>16){
            category.setText("Moderate Thinness");
            background.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.warning);
        }
        else if (intBMI<18.4 && intBMI>=17){
            category.setText("Mild Thinness");
            background.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.warning);
        }
        else if (intBMI<=25 && intBMI>=18.4){
            category.setText("Normal");
           // background.setBackgroundColor(Color.YELLOW);
            imageView.setImageResource(R.drawable.ok);
        }

        else if (intBMI<=29.4 && intBMI>25){
            category.setText("Overweight");
            background.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.warning);
        }
        else{
            category.setText("Obese Class I");
            background.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.warning);
        }


        gender.setText(intent.getStringExtra("gender"));
        display.setText(mBMI);
















        reCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(BmiActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}