package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NavigationGpAsiiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_gp_asii);

        setTitle("ASII GP Maintenance");
    }

    public void dailyClicked (View view){

        Intent intent = new Intent(getApplicationContext(), GpAsiiDailyActivity.class);
        startActivity(intent);


    }

    public void weeklyClicked (View view){

       Intent intent = new Intent(getApplicationContext(),GpAsiiWeeklyActivity.class);
       startActivity(intent);


    }

    public void monthlyClicked (View view){

         Intent intent = new Intent(getApplicationContext(),GpAsiiMonthlyActivity.class);
         startActivity(intent);

    }

    public void quarterlyClicked (View view){

        Intent intent = new Intent(getApplicationContext(),GpAsiiQuarterlyActivity.class);
        startActivity(intent);

    }

    public void sixmonthlyClicked (View view){



    }

    public void annualClicked (View view){

        Intent intent = new Intent(getApplicationContext(),GpAsiiAnnualActivity.class);
        startActivity(intent);

    }

}