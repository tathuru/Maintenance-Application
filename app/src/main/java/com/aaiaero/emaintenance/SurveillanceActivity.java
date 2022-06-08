package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SurveillanceActivity extends AppCompatActivity {

    Button psr, mssr, asmgcs, adsb, others;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surveillance);

        setTitle("Surveillance Components");

        psr = (Button) findViewById(R.id.psr);
        mssr = (Button) findViewById(R.id.mssr);
        asmgcs = (Button) findViewById(R.id.asmgcs);
        adsb = (Button) findViewById(R.id.adsb);
        others = (Button) findViewById(R.id.others);

        Intent intent = getIntent();

    }

    public void psrClicked (View view){
        // Launch the VHF Equipment Room Activity



    }

    public void mssrClicked (View view){
        Intent intent = new Intent(getApplicationContext(),SurMssrMakeActivity.class);
        startActivity(intent);



    }

    public void asmgcsClicked (View view){
        // Launch the DATISEquipment Room Activity



    }

    public void adsbClicked (View view){
        // Launch the ADSB Equipment Room Activity
        Intent intent = new Intent(getApplicationContext(),ADSBMakeModelActivity.class);
        startActivity(intent);



    }

    public void othersClicked (View view){
        // Launch the Others Equipment Room Activity



    }
}
