package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DVORSELEX1150 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dvorselex1150);

    }
    public void daily (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsDVORSELEX1150DailyActivity.class);
        startActivity(intent);

    }

   /* public void weeklyClicked (View view){

        Intent intent = new Intent(getApplicationContext(),NavAidsDVORSELEX1150WeeklyActivity.class);
        startActivity(intent);


    }

    public void monthly (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsDVORSELEX1150MonthlyActivity.class);
        startActivity(intent);

    }

    public void quarterly (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsDVORSELEX1150QuarterlyActivity.class);
        startActivity(intent);

    }



    public void halfYearlyClicked (View view){

        Intent intent = new Intent(getApplicationContext(), DVORSELEX1150SixMonthly.class);
        startActivity(intent);

    }*/

}

