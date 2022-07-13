package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class VhfOteTxActivity extends AppCompatActivity {

    Button daily, weekly, fortnightly, monthly, quarterly, halfYearly, yearly, miscellaneous;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vhf_ote_tx);

        setTitle("OTE TX Maintenance");

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
        // Launch the VHF Equipment Room Activity

        Intent intent = new Intent(getApplicationContext(),VhfTxOteDailyActivity.class);
        startActivity(intent);


    }

    public void weeklyClicked (View view){
        // Launch the DVR Equipment Room Activity
        //Intent intent = new Intent(getApplicationContext(),ADSBDailyActivity.class);
        // startActivity(intent);


    }

    public void fortnightlyClicked (View view){
        // Launch the DATISEquipment Room Activity



    }

    public void monthlyClicked (View view){
        // Launch the VCS Equipment Room Activity

        Intent intent = new Intent(getApplicationContext(),VhfTxOteMonthlyActivity.class);
        startActivity(intent);

    }

    public void quaterlyClicked (View view){
        // Launch the RCAG Equipment Room Activity



    }

    public void halfYearlyClicked (View view){

        Intent intent = new Intent(getApplicationContext(),VhfTxOteSixActivity.class);
        startActivity(intent);


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