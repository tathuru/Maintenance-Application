package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ERActivity extends AppCompatActivity {

    Button vhf, dvr, datis, vcs, rcag, uah, adsb, others1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_er);

        setTitle("Equipment Room Components");

        vhf = (Button) findViewById(R.id.vhf);
        dvr = (Button) findViewById(R.id.dvr);
        datis = (Button) findViewById(R.id.datis);
        vcs = (Button) findViewById(R.id.vcs);
        rcag = (Button) findViewById(R.id.rcag);
        uah = (Button) findViewById(R.id.uah);
        adsb = (Button) findViewById(R.id.adsb);
        others1 = (Button) findViewById(R.id.others1);

        Intent intent = getIntent();

        //Test
        //test2

    }

    public void vhfClicked (View view){
        // Launch the VHF Equipment Room Activity
        Intent intent = new Intent(getApplicationContext(), VhfMakeActivity.class);
        startActivity(intent);



    }

    public void dvrClicked (View view){
        // Launch the DVR Equipment Room Activity
        Intent intent = new Intent(getApplicationContext(), DVRActivity.class);
        startActivity(intent);


    }

    public void datisClicked (View view){
        // Launch the DATISEquipment Room Activity

        Intent intent = new Intent(getApplicationContext(), DatisMakeActivity.class);
        startActivity(intent);

    }

    public void vcsClicked (View view){

        Intent intent = new Intent(getApplicationContext(), VcsMakeActivity.class);
        startActivity(intent);



    }

    public void rcagClicked (View view){
        // Launch the RCAG Equipment Room Activity



    }

    public void uahClicked (View view){
        // Launch the UAH Equipment Room Activity



    }

    public void adsbClicked (View view){
        // Launch the ADSB Equipment Room Activity
        Intent intent = new Intent(getApplicationContext(),ADSBMakeModelActivity.class);
        startActivity(intent);



    }

    public void others1Clicked (View view){
        // Launch the Others Equipment Room Activity



    }
}
