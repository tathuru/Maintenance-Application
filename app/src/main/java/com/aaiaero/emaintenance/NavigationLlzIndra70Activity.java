package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class NavigationLlzIndra70Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_llz_indra70);

        setTitle("INDRA (NORMARC) 70XX LLZ Maintenance");

    }

    public void dailyClicked (View view){

        Intent intent = new Intent(getApplicationContext(), LlzIndra70DailyActivity.class);
        startActivity(intent);


    }

    public void weeklyClicked (View view){

        Intent intent = new Intent(getApplicationContext(),LlzIndra70WeeklyActivity.class);
        startActivity(intent);


    }

    public void wfrClicked (View view){

        Intent intent = new Intent(getApplicationContext(),LlzIndra70WfrActivity.class);
        startActivity(intent);

    }

    public void monthlyClicked (View view){

        Intent intent = new Intent(getApplicationContext(),LlzIndra70MonthlyActivity.class);
        startActivity(intent);

    }

    public void quarterlyClicked (View view){

        Intent intent = new Intent(getApplicationContext(),LlzIndra70QuarterlyActivity.class);
        startActivity(intent);

    }

    public void sixmonthlyClicked (View view){

        Intent intent = new Intent(getApplicationContext(),LlzIndra70SixActivity.class);
        startActivity(intent);


    }

    public void annualClicked (View view){

        Intent intent = new Intent(getApplicationContext(),LlzIndra70AnnualActivity.class);
        startActivity(intent);

    }

    public void mfrClicked (View view){
        // Launch the Others Equipment Room Activity
        Intent intent = new Intent(getApplicationContext(),LlzIndra70MfrActivity.class);
        startActivity(intent);


    }
}