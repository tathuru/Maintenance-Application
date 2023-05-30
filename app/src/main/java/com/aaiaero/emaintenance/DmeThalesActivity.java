package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DmeThalesActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dme_thales);


    }

    public void daily (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsDMEThales415and435DailyActivity.class);
        startActivity(intent);


    }

    public void weekly (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsDMEThales415and435WeeklyActivity.class);
        startActivity(intent);


    }


    public void monthly (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsDMEThales415and435MonthlyActivity.class);
        startActivity(intent);

    }



    public void halfYearly (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsDMEThales415and435SixMonthlyActivity.class);
        startActivity(intent);

    }

    public void yearly (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsDMEThales415and435AnnualActivity.class);
        startActivity(intent);



    }


}