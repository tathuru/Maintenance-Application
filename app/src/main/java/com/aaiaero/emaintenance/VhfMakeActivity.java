package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VhfMakeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vhf_make);

        Button ote, pae, jotron, ecil;

        ote = (Button) findViewById(R.id.ote);
        pae = (Button) findViewById(R.id.pae);
        jotron = (Button) findViewById(R.id.jotron);
        ecil = (Button) findViewById(R.id.ecil);

        ote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), VhfOteTxRxActivity.class);
                startActivity(intent);
            }
        });

        pae.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), VhfPaeTxRxActivity.class);
                startActivity(intent);

            }
        });

        jotron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), VhfJotronTxRxActivity.class);
                startActivity(intent);

            }
        });

        ecil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), VhfEcilTxRxActivity.class);
                startActivity(intent);

            }
        });
    }
}