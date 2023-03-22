package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class NavigationLlzIndra70Activity extends AppCompatActivity {

    Button daily, weekly, wfr, monthly, quarterly, halfYearly, yearly, mfr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_llz_indra70);

        setTitle("INDRA LLZ Maintenance");

        daily = (Button) findViewById(R.id.daily);
        weekly = (Button) findViewById(R.id.weekly);
        wfr = (Button) findViewById(R.id.wfr);
        monthly = (Button) findViewById(R.id.monthly);
        quarterly = (Button) findViewById(R.id.quarterly);
        halfYearly = (Button) findViewById(R.id.halfYearly);
        yearly = (Button) findViewById(R.id.yearly);
        mfr = (Button) findViewById(R.id.mfr);

        Intent intent = getIntent();

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

    public void quaterlyClicked (View view){

        Intent intent = new Intent(getApplicationContext(),LlzIndra70QuarterlyActivity.class);
        startActivity(intent);

    }

    public void halfYearlyClicked (View view){

        Intent intent = new Intent(getApplicationContext(),LlzIndra70SixActivity.class);
        startActivity(intent);


    }

    public void yearlyClicked (View view){

        Intent intent = new Intent(getApplicationContext(),LlzIndra70AnnualActivity.class);
        startActivity(intent);

    }

    public void mfrClicked (View view){
        // Launch the Others Equipment Room Activity
        Intent intent = new Intent(getApplicationContext(),LlzIndra70MfrActivity.class);
        startActivity(intent);




    }
}