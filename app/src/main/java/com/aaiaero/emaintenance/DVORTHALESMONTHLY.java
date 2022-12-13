package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DVORTHALESMONTHLY extends AppCompatActivity {

    public void monthly (View view){

        Intent intent = new Intent(getApplicationContext(),NavAidsDVORThales432MonthlyActivity.class);
        startActivity(intent);


    }

    public void monthlyannex (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsDVORThales432MonthlyAnnex1Activity.class);
        startActivity(intent);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dvorthalesmonthly);
    }
}