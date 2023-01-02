package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DatisAcamsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datis_acams);

        Button daily, monthly;

        daily = (Button) findViewById(R.id.daily);
        monthly = (Button) findViewById(R.id.monthly);

        daily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),DatisAcamsDailyActivity.class);
                startActivity(intent);
            }
        });


        monthly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),DatisAcamsMonthlyActivity.class);
                startActivity(intent);
            }
        });

    }
}