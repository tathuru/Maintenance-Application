package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DVRActivity extends AppCompatActivity {

    public void retiaClicked (View view){

        Intent intent = new Intent(getApplicationContext(), DVRRetia.class);
        startActivity(intent);

    }

    public void ricochetClicked (View view){

        Intent intent = new Intent(getApplicationContext(),DVRRicochet.class);
        startActivity(intent);

    }


    public void ricochetipClicked (View view){

        Intent intent = new Intent(getApplicationContext(),DVRRicochetIP.class);
        startActivity(intent);

    }
    public void voxtronicClicked (View view){

        Intent intent = new Intent(getApplicationContext(), DVRVoxtronic.class);
        startActivity(intent);


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dvractivity);
    }
}