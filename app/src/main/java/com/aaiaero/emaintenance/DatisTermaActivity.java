package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DatisTermaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datis_terma);

        Button daily, weekly;

        daily = (Button) findViewById(R.id.daily);
        weekly = (Button) findViewById(R.id.weekly);

        daily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),DatisTermaDailyActivity.class);
                startActivity(intent);
            }
        });


        weekly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),DatisTermaWeeklyActivity.class);
                startActivity(intent);
            }
        });
    }
}