package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DMEIntelcanN9040 extends AppCompatActivity {

    public void daily (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsDMEINTELCANN9040DailyActivity.class);
        startActivity(intent);


    }

    public void weekly (View view){

        Intent intent = new Intent(getApplicationContext(),NavAidsDMEINTELCANN9040WeeklyActivity.class);
        startActivity(intent);


    }



    public void monthly (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsDMEINTELCANN9040MonthlyActivity.class);
        startActivity(intent);

    }

    public void sixmonthly (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsDMEINTELCANN9040SixMonthlyActivity.class);
        startActivity(intent);

    }

    public void annual (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsDMEINTELCANN9040AnnualActivity.class);
        startActivity(intent);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dmeintelcan_n9040);
    }
}