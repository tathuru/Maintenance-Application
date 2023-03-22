package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DvorGcel757Activity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dvor_gcel757);

        setTitle("GCEL DVOR  Maintenance");


        Intent intent = getIntent();

    }

    public void dailyClicked (View view){


        Intent intent = new Intent(getApplicationContext(),NavAidsDVORGcel757DailyActivity.class);
        startActivity(intent);


    }

    public void quarterly (View view){


        Intent intent = new Intent(getApplicationContext(),NavAidsDVORGcel757QuarterlyActivity.class);
        startActivity(intent);


    }

    public void weeklyClicked (View view){


        Intent intent = new Intent(getApplicationContext(),NavAidsDVORGcel757WeeklyActivity.class);
        startActivity(intent);


    }



    public void monthly (View view){

        Intent intent = new Intent(getApplicationContext(),NavAidsDVORGcel757MonthlyActivity.class);
        startActivity(intent);

    }


    public void monthlygc (View view){

        Intent intent = new Intent(getApplicationContext(),NavAidsDVORGcel757MonthlyGroundChecksActivity.class);
        startActivity(intent);

    }


    public void halfYearlyClicked (View view){

        Intent intent = new Intent(getApplicationContext(),NavAidsDVORGcel757SixMonthlyActivity.class);
        startActivity(intent);


    }



}

