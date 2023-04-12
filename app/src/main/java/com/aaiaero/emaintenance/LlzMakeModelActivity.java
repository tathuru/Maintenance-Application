package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LlzMakeModelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llz_make_model);

        Button normarc70, normarc35, asii, thales, indra;

        normarc70 = (Button) findViewById(R.id.normarc70);
        normarc35 = (Button) findViewById(R.id.normarc35);
        asii = (Button) findViewById(R.id.asii);
        thales = (Button) findViewById(R.id.thales);
        indra = (Button) findViewById(R.id.indra);

        normarc70.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), NavigationLlzNormarc7000Activity.class);
                startActivity(intent);
            }
        });

        normarc35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        asii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),NavigationLlzAsiiActivity.class);
                startActivity(intent);
            }
        });

        thales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), NavigationLlzThales420Activity.class);
                startActivity(intent);

            }
        });

        indra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), NavigationLlzIndra70Activity.class);
                startActivity(intent);

            }
        });
    }
}