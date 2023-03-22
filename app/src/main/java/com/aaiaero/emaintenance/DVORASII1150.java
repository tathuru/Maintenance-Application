package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DVORASII1150 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dvorasii1150);

    }
    public void daily (View view){

       Intent intent = new Intent(getApplicationContext(), NavAidsDVORASII1150DailyActivity.class);
       startActivity(intent);

    }

    public void weeklyClicked (View view){

        Intent intent = new Intent(getApplicationContext(),NavAidsDVORASII1150WeeklyActivity.class);
        startActivity(intent);


    }

    public void monthly (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsDVORASII1150MonthlyActivity.class);
        startActivity(intent);

    }

    public void quarterly (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsDVORASII1150QuarterlyActivity.class);
        startActivity(intent);

    }



    public void halfYearlyClicked (View view){

        Intent intent = new Intent(getApplicationContext(), DVORASII1150SixMonthly.class);
        startActivity(intent);

    }

    }
