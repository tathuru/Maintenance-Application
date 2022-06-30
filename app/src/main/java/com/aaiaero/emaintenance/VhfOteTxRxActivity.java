package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VhfOteTxRxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vhf_ote_tx_rx);

        Button tx, rx;

        tx = (Button) findViewById(R.id.tx);
        rx = (Button) findViewById(R.id.rx);


        tx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),VhfOteTxActivity.class);
                startActivity(intent);
            }
        });

        rx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),VhfOteRxActivity.class);
                startActivity(intent);

            }
        });

    }
}