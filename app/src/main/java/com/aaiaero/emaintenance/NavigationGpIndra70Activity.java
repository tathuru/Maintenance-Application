package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NavigationGpIndra70Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_gp_indra70);
        setTitle("Indra (Normarc) 7000 GP Maintenance");

    }
    public void dailyClicked (View view){

        Intent intent = new Intent(getApplicationContext(), GpIndra70DailyActivity.class);
        startActivity(intent);


    }

    public void weeklyClicked (View view){

       Intent intent = new Intent(getApplicationContext(),GpIndra70WeeklyActivity.class);
       startActivity(intent);


    }

      public void monthlyClicked (View view){

        Intent intent = new Intent(getApplicationContext(),GpIndra70MonthlyActivity.class);
        startActivity(intent);

    }

    public void quarterlyClicked (View view){

        Intent intent = new Intent(getApplicationContext(),GpIndra70QuarterlyActivity.class);
        startActivity(intent);

    }

    public void sixmonthlyClicked (View view){

        Intent intent = new Intent(getApplicationContext(),GpIndra70SixActivity.class);
        startActivity(intent);

    }

    public void annualClicked (View view){

       Intent intent = new Intent(getApplicationContext(),GpIndra70AnnualActivity.class);
       startActivity(intent);

    }

}