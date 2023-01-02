package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DVORASII1150SixMonthly extends AppCompatActivity {

    public void sixmonthly (View view){

        Intent intent = new Intent(getApplicationContext(),NavAidsDVORASII1150SixMonthlyActivity.class);
        startActivity(intent);


    }

    public void vswr (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsDVORASII1150SixMonthlyVSWRActivity.class);
        startActivity(intent);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dvorasii1150_six_monthly);
    }
}