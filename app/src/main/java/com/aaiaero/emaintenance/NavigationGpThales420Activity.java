package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class NavigationGpThales420Activity extends AppCompatActivity {

    Button daily, weekly, fortnightly, monthly, quarterly, halfYearly, yearly, miscellaneous;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_gp_thales420);

        setTitle("Thales GP Maintenance");

        daily = (Button) findViewById(R.id.daily);
        weekly = (Button) findViewById(R.id.weekly);
        fortnightly = (Button) findViewById(R.id.fortnightly);
        monthly = (Button) findViewById(R.id.monthly);
        quarterly = (Button) findViewById(R.id.quarterly);
        halfYearly = (Button) findViewById(R.id.halfYearly);
        yearly = (Button) findViewById(R.id.yearly);
        miscellaneous = (Button) findViewById(R.id.miscellaneous);

        Intent intent = getIntent();

    }

    public void dailyClicked (View view){

        Intent intent = new Intent(getApplicationContext(), GpThalesDailyActivity.class);
        startActivity(intent);


    }

    public void weeklyClicked (View view){

        Intent intent = new Intent(getApplicationContext(),GpThalesWeeklyActivity.class);
        startActivity(intent);


    }

    public void fortnightlyClicked (View view){




    }

    public void monthlyClicked (View view){

        Intent intent = new Intent(getApplicationContext(),GpThalesMonthlyActivity.class);
        startActivity(intent);

    }

    public void quaterlyClicked (View view){

        Intent intent = new Intent(getApplicationContext(),GpThalesQuarterlyActivity.class);
        startActivity(intent);

    }

    public void halfYearlyClicked (View view){



    }

    public void yearlyClicked (View view){

        Intent intent = new Intent(getApplicationContext(),GpThalesAnnualActivity.class);
        startActivity(intent);

    }

    public void miscellaneousClicked (View view){
        // Launch the Others Equipment Room Activity



    }
}