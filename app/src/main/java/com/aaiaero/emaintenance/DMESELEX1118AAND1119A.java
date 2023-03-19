package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DMESELEX1118AAND1119A extends AppCompatActivity {

    public void daily (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsDMESELEX1118Aand1119ADailyActivity.class);
        startActivity(intent);


    }

   public void weekly (View view){

        Intent intent = new Intent(getApplicationContext(),NavAidsDMESELEX1118Aand1119AWeeklyActivity.class);
        startActivity(intent);


    }



    public void monthly (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsDMESELEX1118Aand1119AMonthlyActivity.class);
        startActivity(intent);

    }

    public void quarterly (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsDMESELEX1118Aand1119AQuarterlyActivity.class);
        startActivity(intent);

    }

    public void halfyearly (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsDMESELEX1118Aand1119AHalfYearlyActivity.class);
        startActivity(intent);

    }

    public void yearly (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsDMESELEX1118Aand1119AYearlyActivity.class);
        startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dmeselex1118_aand1119);
    }
}

