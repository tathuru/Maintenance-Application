
package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

public class DvorMakeModelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dvor_make_model);

        Button thales, selex, gecl, mopiens;

        thales = (Button) findViewById(R.id.thales);
        selex = (Button) findViewById(R.id.selex);
        gecl = (Button) findViewById(R.id.gecl);
        mopiens = (Button) findViewById(R.id.mopiens);

        thales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(),ADSBActivity.class);
                //startActivity(intent);
            }
        });

        selex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        gecl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(),ADSBActivity.class);
                //startActivity(intent);
            }
        });

        mopiens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),DvorMopiensActivity.class);
                startActivity(intent);

            }
        });
    }
}