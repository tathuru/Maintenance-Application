package com.aaiaero.emaintenance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class sur_psr_eldis4 extends AppCompatActivity {


        Button daily, weekly,upsdaily, fortnightly, monthly, quarterly, halfYearly, yearly, miscellaneous;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sur_psr_eldis4);//xml file name you want to bond with this java file
        setTitle("ELDIS 4 PSR Maintenance");

        daily = (Button) findViewById(R.id.dailypsr);
        upsdaily = (Button) findViewById(R.id.upsdailypsr);
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

        Intent intent = new Intent(getApplicationContext(),psr_eldis_4_rl200_daily.class);
        startActivity(intent);


    }
    public void upsdailyClicked (View view){

        Intent intent = new Intent(getApplicationContext(),sur_eldis4ups_daily.class);
        startActivity(intent);


    }

        public void weeklyClicked (View view){



    }

        public void fortnightlyClicked (View view){
        // Launch the DATISEquipment Room Activity



    }

        public void monthlyClicked (View view){



    }

        public void quaterlyClicked (View view){
        // Launch the RCAG Equipment Room Activity



    }

        public void halfYearlyClicked (View view){
        // Launch the UAH Equipment Room Activity



    }

        public void yearlyClicked (View view){
        // Launch the ADSB Equipment Room Activity
        //Intent intent = new Intent(getApplicationContext(),ADSBActivity.class);
        //startActivity(intent);



    }

        public void miscellaneousClicked (View view){
        // Launch the Others Equipment Room Activity



    }
    }
