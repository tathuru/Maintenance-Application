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

public class AsmgcsHittMonthlyActivity extends AppCompatActivity {

    Button smr,cms;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asmgcs_hitt_monthly);

        setTitle("Monthly HITT ASMGCS Maintenance");

        smr = (Button) findViewById(R.id.smr);
        cms = (Button) findViewById(R.id.cms);


        Intent intent = getIntent();

    }

    public void smrClicked (View view){

        Intent intent = new Intent(getApplicationContext(),AsmgcsHittSmrSiteMonthlyActivity.class);
        startActivity(intent);

    }

    public void cmsClicked (View view){
        Intent intent = new Intent(getApplicationContext(),AsmgcsHittCmsSiteMonthlyActivity.class);
        startActivity(intent);

    }
}
