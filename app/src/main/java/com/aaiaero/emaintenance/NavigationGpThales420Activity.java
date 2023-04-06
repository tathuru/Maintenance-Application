package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class NavigationGpThales420Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_gp_thales420);

        setTitle("Thales GP Maintenance");

    }

    public void dailyClicked (View view){

        Intent intent = new Intent(getApplicationContext(), GpThalesDailyActivity.class);
        startActivity(intent);


    }

    public void weeklyClicked (View view){

        Intent intent = new Intent(getApplicationContext(),GpThalesWeeklyActivity.class);
        startActivity(intent);


    }

    public void monthlyClicked (View view){

        Intent intent = new Intent(getApplicationContext(),GpThalesMonthlyActivity.class);
        startActivity(intent);

    }

    public void quarterlyClicked (View view){

        Intent intent = new Intent(getApplicationContext(),GpThalesQuarterlyActivity.class);
        startActivity(intent);

    }

    public void sixmonthlyClicked (View view){



    }

    public void annualClicked (View view){

        Intent intent = new Intent(getApplicationContext(),GpThalesAnnualActivity.class);
        startActivity(intent);

    }

}