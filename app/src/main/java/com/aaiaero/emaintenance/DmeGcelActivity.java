package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DmeGcelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dme_gcel);


    }

    public void daily (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsDMEGcel752DailyActivity.class);
        startActivity(intent);


    }

    public void weekly (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsDMEGcel752WeeklyActivity.class);
        startActivity(intent);


    }

    public void monthly(View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsDMEGcel752MonthlyActivity.class);
        startActivity(intent);

    }



    public void halfYearly (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsDMEGcel752SixMonthlyActivity.class);
        startActivity(intent);


    }
}