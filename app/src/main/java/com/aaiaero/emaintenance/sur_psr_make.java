package com.aaiaero.emaintenance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class sur_psr_make extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sur_psr_make);
        Button ngosco, raytheon, selex, indra, eldis4;

        ngosco = (Button) findViewById(R.id.ngosco);
        raytheon = (Button) findViewById(R.id.raytheon);
        selex = (Button) findViewById(R.id.selex);
        indra = (Button) findViewById(R.id.indra);
        eldis4 = (Button) findViewById(R.id.eldis4);

        ngosco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SurMssrNgoscoActivity.class);
                startActivity(intent);
            }
        });

        raytheon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        selex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),sur_psr_selex.class);
                startActivity(intent);

            }
        });

        indra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        eldis4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),sur_psr_eldis4.class);
                startActivity(intent);
            }
        });
    }
}
