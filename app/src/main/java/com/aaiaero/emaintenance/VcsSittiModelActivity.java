package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VcsSittiModelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vcs_sitti_model);

        Button m600s, m800ip;

        m600s = (Button) findViewById(R.id.m600s);
        m800ip = (Button) findViewById(R.id.m800ip);


        m600s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),VcsSittiM600sActivity.class);
                startActivity(intent);
            }
        });

        m800ip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),VcsSittiM800ipActivity.class);
                startActivity(intent);

            }
        });

    }
}