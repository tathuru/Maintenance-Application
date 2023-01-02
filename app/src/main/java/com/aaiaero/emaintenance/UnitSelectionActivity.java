package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.ByteArrayOutputStream;

public class UnitSelectionActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_selection);

        setTitle("Unit for Maintenance");

        Button comm, nav, sur, automation, amss, gagan, other;
        comm = (Button) findViewById(R.id.comm);
        nav = (Button) findViewById(R.id.nav);
        sur = (Button) findViewById(R.id.sur);
        automation = (Button) findViewById(R.id.automation);
        amss = (Button) findViewById(R.id.amss);
        gagan = (Button) findViewById(R.id.gagan);
        other = (Button) findViewById(R.id.others);

        Intent intent = getIntent();

        comm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ERActivity.class);
                startActivity(intent);
            }
        });

        nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),NavAidsActivity.class);
                startActivity(intent);

            }
        });

        sur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),SurveillanceActivity.class);
                startActivity(intent);

            }
        });

        automation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),AutomationActivity.class);
                startActivity(intent);

            }
        });

        amss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),AmssActivity.class);
                startActivity(intent);

            }
        });

        gagan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }


}
