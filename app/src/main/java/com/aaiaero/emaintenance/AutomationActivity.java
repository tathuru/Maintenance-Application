package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AutomationActivity extends AppCompatActivity {

    Button rayChennai, rayMumbai, selex, indraKolkata, indraab1, indrab2c, indraDelhi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_automation);

        setTitle("Automation Components");

        rayChennai = (Button) findViewById(R.id.rayChennai);
        rayMumbai = (Button) findViewById(R.id.rayMumbai);
        selex = (Button) findViewById(R.id.selex);
        indraKolkata = (Button) findViewById(R.id.indraKolkata);
        indraab1 = (Button) findViewById(R.id.indraab1);
        indraDelhi = (Button) findViewById(R.id.indraDelhi);
        indrab2c = (Button) findViewById(R.id.indrab2c);

        Intent intent = getIntent();

    }

    public void rayChennaiClicked (View view){




    }

    public void rayMumbaiClicked (View view){
        Intent intent = new Intent(getApplicationContext(),SurMssrMakeActivity.class);
        startActivity(intent);



    }

    public void selexClicked (View view){




    }

    public void indraKolkataClicked (View view){
        // Launch the ADSB Equipment Room Activity
        Intent intent = new Intent(getApplicationContext(),ADSBMakeModelActivity.class);
        startActivity(intent);



    }

    public void indraab1Clicked (View view){
        // Launch the Others Equipment Room Activity



    }
    public void indraDelhiClicked (View view){
        // Launch the ADSB Equipment Room Activity
        Intent intent = new Intent(getApplicationContext(),ADSBMakeModelActivity.class);
        startActivity(intent);



    }

    public void indrab2cClicked (View view){

        Intent intent = new Intent(getApplicationContext(),IndraB2cActivity.class);
        startActivity(intent);

    }
}