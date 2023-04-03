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

public class AsmgcsHittYearlyActivity extends AppCompatActivity {

    Button smr,cps;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asmgcs_hitt_yearly);

        setTitle("Yearly HITT ASMGCS Maintenance");

        smr = (Button) findViewById(R.id.smr);
        cps = (Button) findViewById(R.id.cps);


        Intent intent = getIntent();

    }

    public void smrClicked (View view){

        Intent intent = new Intent(getApplicationContext(),AsmgcsHittSmrSiteBiteMeasurementActivity.class);
        startActivity(intent);

    }

    public void cpsClicked (View view){
        Intent intent = new Intent(getApplicationContext(),AsmgcsHittCpsSiteYearlyActivity.class);
        startActivity(intent);

    }
}
