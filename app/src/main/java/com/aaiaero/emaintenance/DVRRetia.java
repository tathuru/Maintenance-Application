package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DVRRetia extends AppCompatActivity {


    public void dailyClicked (View view){

        Intent intent = new Intent(getApplicationContext(), VHFDVRRETIADailyActivity.class);
        startActivity(intent);


    }

    public void recording (View view){

        Intent intent = new Intent(getApplicationContext(),VHFDVRRETIADailyRecordingActivity.class);
        startActivity(intent);

    }


    public void monthly (View view){

       // Intent intent = new Intent(getApplicationContext(), NavAidsDVORThales432MonthlyActivity.class);
        //startActivity(intent);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dvrretia);
    }
}