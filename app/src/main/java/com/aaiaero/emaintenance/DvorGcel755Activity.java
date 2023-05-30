package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DvorGcel755Activity extends AppCompatActivity {

    Button daily, weekly, fortnightly, monthly, quarterly, halfYearly, yearly, miscellaneous;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dvor_gcel755);

        setTitle("GCEL DVOR  Maintenance");

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


        Intent intent = new Intent(getApplicationContext(),NavAidsDVORGcel755DailyActivity.class);
        startActivity(intent);


    }

    public void weeklyClicked (View view){


        Intent intent = new Intent(getApplicationContext(),NavAidsDVORGcel755WeeklyActivity.class);
        startActivity(intent);


    }

    public void quarterly (View view){


        Intent intent = new Intent(getApplicationContext(),NavAidsDVORGcel755QuarterlyActivity.class);
        startActivity(intent);


    }




    public void monthly (View view){

        Intent intent = new Intent(getApplicationContext(),NavAidsDVORGcel755MonthlyActivity.class);
        startActivity(intent);

    }


    public void monthlygc (View view){

        Intent intent = new Intent(getApplicationContext(),NavAidsDVORGcel755MonthlyGroundChecksActivity.class);
        startActivity(intent);

    }


    public void halfYearlyClicked (View view){

        Intent intent = new Intent(getApplicationContext(),NavAidsDVORGcel755SixMonthlyActivity.class);
        startActivity(intent);


    }



}