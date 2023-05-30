package com.aaiaero.emaintenance;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

public class DmeMopiensActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dme_mopiens);


    }

    public void daily (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsDMEMaru310and320DailyActivity.class);
        startActivity(intent);


    }

    public void weekly (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsDMEMaru310and320WeeklyActivity.class);
        startActivity(intent);


    }



    public void monthly (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsDMEMaru310and320MonthlyActivity.class);
        startActivity(intent);

    }

    public void halfYearly (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsDMEMaru310and320SixMonthlyActivity.class);
        startActivity(intent);

    }

    public void yearly (View view){

        Intent intent = new Intent(getApplicationContext(), NavAidsDMEMaru310and320AnnualActivity.class);
        startActivity(intent);



    }

}