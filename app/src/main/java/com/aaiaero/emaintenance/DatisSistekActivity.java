package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DatisSistekActivity extends AppCompatActivity {
    public void dailyClicked (View view){

        Intent intent = new Intent(getApplicationContext(), DatisSistekDailyActivity.class);
        startActivity(intent);


    }

    public void monthly (View view){

        Intent intent = new Intent(getApplicationContext(), DatisSistekMonthlyActivity.class);
        startActivity(intent);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datis_sistek);
    }
}