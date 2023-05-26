package com.aaiaero.emaintenance;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

public class SurAsmgcsMakeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sur_asmgcs_make);

        Button sensis, hitt, selex, saab;

        sensis = (Button) findViewById(R.id.sensis);
        hitt = (Button) findViewById(R.id.hitt);
        selex = (Button) findViewById(R.id.selex);
        saab = (Button) findViewById(R.id.saab);

        sensis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AsmgcsSensisActivity.class);
                startActivity(intent);
            }
        });

        hitt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AsmgcsHittActivity.class);
                startActivity(intent);

            }
        });

        selex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AsmgcsSelexActivity.class);
                startActivity(intent);

            }
        });

        saab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SurMssrIndraActivity.class);
                startActivity(intent);

            }
        });

    }
}