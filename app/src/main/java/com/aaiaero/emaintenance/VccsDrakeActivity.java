package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VccsDrakeActivity extends AppCompatActivity {

    Button daily, weekly;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vccs_drake);
        setTitle("VCCS DDrake Maintenance");

        daily = (Button) findViewById(R.id.daily);
        weekly = (Button) findViewById(R.id.weekly);

        Intent intent = getIntent();
    }
    public void dailyClicked (View view){


        Intent intent = new Intent(getApplicationContext(),VccsDrakeDailyActivity.class);
        startActivity(intent);


    }

    public void weeklyClicked (View view){

        Intent intent = new Intent(getApplicationContext(),VccsDrakeWeeklyActivity.class);
        startActivity(intent);
    }
}