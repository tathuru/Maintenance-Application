package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.ByteArrayOutputStream;

public class DvorMopiensActivity extends AppCompatActivity {

    Button daily, weekly, fortnightly, monthly, quarterly, halfYearly, yearly, miscellaneous;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dvor_mopiens);

        setTitle("MOPIENS DVOR  Maintenance");

        daily = (Button) findViewById(R.id.daily);
        weekly = (Button) findViewById(R.id.weekly);
        fortnightly = (Button) findViewById(R.id.fortnightly);
        monthly = (Button) findViewById(R.id.monthly);
        quarterly = (Button) findViewById(R.id.quarterly);
        halfYearly = (Button) findViewById(R.id.halfYearly);
        yearly = (Button) findViewById(R.id.yearly);
        miscellaneous = (Button) findViewById(R.id.miscellaneous);

        Intent intent = getIntent();

    }

    public void dailyClicked (View view){


        Intent intent = new Intent(getApplicationContext(),DVORMopiensDailyActivity.class);
        startActivity(intent);


    }

    public void weeklyClicked (View view){


        Intent intent = new Intent(getApplicationContext(),DVORMopiensWeeklyActivity.class);
        startActivity(intent);


    }

    public void fortnightlyClicked (View view){



    }

    public void monthlyClicked (View view){
        Intent intent = new Intent(getApplicationContext(),DVORMopiensMonthlyActivity.class);
        startActivity(intent);

    }

    public void quaterlyClicked (View view){



    }

    public void halfYearlyClicked (View view){

        Intent intent = new Intent(getApplicationContext(),DVORMopiensSixMonthlyActivity.class);
        startActivity(intent);


    }

    public void yearlyClicked (View view){

        Intent intent = new Intent(getApplicationContext(),DVORMopiensAnnuallyActivity.class);
        startActivity(intent);



    }

    public void miscellaneousClicked (View view){
        // Launch the Others Equipment Room Activity



    }
}