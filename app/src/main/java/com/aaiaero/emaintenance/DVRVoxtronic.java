package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DVRVoxtronic extends AppCompatActivity {
    public void dailyAaeon (View view){

        Intent intent = new Intent(getApplicationContext(), DvrVoxtronicAaeonDailyActivity.class);
        startActivity(intent);


    }

    public void monthlyAaeon (View view){

        Intent intent = new Intent(getApplicationContext(),DvrVoxtronicAaeonMonthlyActivity.class);
        startActivity(intent);

    }
    public void dailyDynalog (View view){

        Intent intent = new Intent(getApplicationContext(), DvrVoxtronicDynalogDailyActivity.class);
        startActivity(intent);


    }

    public void monthlyDynalog (View view){

        Intent intent = new Intent(getApplicationContext(),DvrVoxtronicDynalogMonthlyActivity.class);
        startActivity(intent);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dvrvoxtronic_aaeon);
    }
}