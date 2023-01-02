package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DmeMakeModelActivity extends AppCompatActivity {

    public void asii1118 (View view){

        Intent intent = new Intent(getApplicationContext(),DMEASII1118AND1119.class);
        startActivity(intent);


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dme_make_model);

        Button thales, mopiens, gecl, other;

        thales = (Button) findViewById(R.id.thales);
        mopiens = (Button) findViewById(R.id.mopiens);
        gecl = (Button) findViewById(R.id.gecl);
        other = (Button) findViewById(R.id.other);

        thales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),DmeThalesActivity.class);
                startActivity(intent);
            }
        });

        mopiens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),DmeMopiensActivity.class);
                startActivity(intent);

            }
        });

        gecl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DmeGcelActivity.class);
                startActivity(intent);
            }
        });

        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}