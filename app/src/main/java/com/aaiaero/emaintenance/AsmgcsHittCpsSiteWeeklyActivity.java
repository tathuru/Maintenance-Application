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

public class AsmgcsHittCpsSiteWeeklyActivity extends AppCompatActivity {

    Button odd, even;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asmgcs_hitt_cps_site_weekly);

        setTitle("Weekly CPS_SITE HITT ASMGCS Maintenance");

        odd = (Button) findViewById(R.id.odd);
        even = (Button) findViewById(R.id.even);

        Intent intent = getIntent();

    }

    public void oddClicked (View view){

        Intent intent = new Intent(getApplicationContext(),AsmgcsHittCpsSiteOddWeeklyActivity.class);
        startActivity(intent);

    }

    public void evenClicked (View view){
        Intent intent = new Intent(getApplicationContext(),AsmgcsHittCpsSiteEvenWeeklyActivity.class);
        startActivity(intent);

    }

}
