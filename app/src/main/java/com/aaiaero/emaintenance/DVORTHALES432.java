package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DVORTHALES432 extends AppCompatActivity {

    public void dailyClicked (View view){

         Intent intent = new Intent(getApplicationContext(), NavAidsDVORThales432DailyActivity.class);
         startActivity(intent);


    }

    public void monthly (View view){

        Intent intent = new Intent(getApplicationContext(), DVORTHALESMONTHLY.class);
        startActivity(intent);

    }

    public void weekly (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsDVORThales432WeeklyActivity.class);
        startActivity(intent);

    }

    public void quarterly (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsDVORThales432QuarterlyActivity.class);
        startActivity(intent);

    }

    public void sixmonthly (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsDVORThales432SixMonthlyActivity.class);
        startActivity(intent);

    }

    public void annual (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsDVORThales432AnnualActivity.class);
        startActivity(intent);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dvorthales432);
    }
}