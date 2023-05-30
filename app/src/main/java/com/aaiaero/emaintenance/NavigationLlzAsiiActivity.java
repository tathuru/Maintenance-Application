package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NavigationLlzAsiiActivity extends AppCompatActivity {

    public void dailyClicked (View view){

        Intent intent = new Intent(getApplicationContext(), LlzAsiiDailyActivity.class);
        startActivity(intent);

    }

    public void weeklyClicked (View view){
        Intent intent = new Intent(getApplicationContext(), LlzAsiiWeeklyActivity.class);
        startActivity(intent);

    }


    public void monthlyClicked (View view){
        Intent intent = new Intent(getApplicationContext(), LlzAsiiMonthlyActivity.class);
        startActivity(intent);
    }
    public void quarterlyClicked (View view){

        Intent intent = new Intent(getApplicationContext(), LlzAsiiQuarterly1Activity.class);
        startActivity(intent);
    }
    public void quarterly2Clicked (View view){
        Intent intent = new Intent(getApplicationContext(), LlzAsiiQuarterly2Activity.class);
        startActivity(intent);

    }
    public void annualClicked (View view){
        Intent intent = new Intent(getApplicationContext(), LlzAsiiAnnualActivity.class);
        startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_llz_asii);

        setTitle("ASII LLZ Maintenance");

    }
}