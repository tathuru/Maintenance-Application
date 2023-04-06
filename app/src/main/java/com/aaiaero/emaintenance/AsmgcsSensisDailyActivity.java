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

public class AsmgcsSensisDailyActivity extends AppCompatActivity {

    Button smr, ruref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asmgcs_sensis_daily);

        setTitle("Daily SENSIS ASMGCS Maintenance");

        smr = (Button) findViewById(R.id.smr);
        ruref = (Button) findViewById(R.id.ruref);


        Intent intent = getIntent();

    }

    public void smrClicked (View view){

        Intent intent = new Intent(getApplicationContext(),AsmgcsSmrSensisDailyActivity.class);
        startActivity(intent);


    }

    public void rurefClicked (View view){
        Intent intent = new Intent(getApplicationContext(),AsmgcsRuReftransSensisDailyActivity.class);
        startActivity(intent);


    }
}
