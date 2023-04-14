package com.aaiaero.emaintenance;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.graphics.Bitmap;
        import android.graphics.BitmapFactory;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;

        import java.io.ByteArrayOutputStream;

public class AsmgcsHittCmsSiteSixMonthlyActivity extends AppCompatActivity {

    Button emc, antenna, cabinet, fault, mast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asmgcs_hitt_cms_site_six_monthly);

        setTitle("Six Monthly MLAT HITT ASMGCS Maintenance");

        emc = (Button) findViewById(R.id.emc);
        antenna = (Button) findViewById(R.id.antenna);
        cabinet = (Button) findViewById(R.id.cabinet);
        fault = (Button) findViewById(R.id.fault);
        mast = (Button) findViewById(R.id.mast);


        Intent intent = getIntent();

    }

    public void emcClicked (View view){

        Intent intent = new Intent(getApplicationContext(),AsmgcsHittMlatsEmcSixMonthlyActivity.class);
        startActivity(intent);

    }
    public void antennaClicked (View view){
        Intent intent = new Intent(getApplicationContext(),AsmgcsHittMlatsAntennaSixMonthlyActivity.class);
        startActivity(intent);

    }
    public void cabinetClicked (View view){
        Intent intent = new Intent(getApplicationContext(),AsmgcsHittMlatsCabinetSixMonthlyActivity.class);
        startActivity(intent);

    }
    public void faultClicked (View view){
        Intent intent = new Intent(getApplicationContext(),AsmgcsHittMlatsFaultSixMonthlyActivity.class);
        startActivity(intent);

    }
    public void mastClicked (View view){
        Intent intent = new Intent(getApplicationContext(),AsmgcsHittMlatsMastSixMonthlyActivity.class);
        startActivity(intent);

    }
}
