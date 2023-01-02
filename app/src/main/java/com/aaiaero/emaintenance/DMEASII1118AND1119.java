package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DMEASII1118AND1119 extends AppCompatActivity {

    public void daily (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsDMEASII1118and1119DailyActivity.class);
        startActivity(intent);


    }

    public void weekly (View view){

        Intent intent = new Intent(getApplicationContext(),NavAidsDMEASII1118and1119WeeklyActivity.class);
        startActivity(intent);


    }



    public void monthly (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsDMEASII1118and1119MonthlyActivity.class);
        startActivity(intent);

    }

    public void quarterly (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsDMEASII1118and1119QuarterlyActivity.class);
        startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dmeasii1118_and1119);
    }
}