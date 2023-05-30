package com.aaiaero.emaintenance;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;

public class NavigationLlzThales420Activity extends AppCompatActivity {

    public void dailyClicked (View view){

        Intent intent = new Intent(getApplicationContext(), LlzThalesDailyActivity.class);
        startActivity(intent);

    }

    public void weeklyClicked (View view){
        Intent intent = new Intent(getApplicationContext(),LlzThalesWeeklyActivity.class);
        startActivity(intent);

    }


    public void monthlyClicked (View view){
        Intent intent = new Intent(getApplicationContext(),LlzThalesMonthlyActivity.class);
        startActivity(intent);
    }
    public void quarterlyClicked (View view){

        Intent intent = new Intent(getApplicationContext(),LlzThalesQuarterlyActivity.class);
        startActivity(intent);
    }
    public void wfrClicked (View view){
        Intent intent = new Intent(getApplicationContext(),LlzThalesWfrActivity.class);
        startActivity(intent);


    }
    public void annualClicked (View view){
        Intent intent = new Intent(getApplicationContext(),LlzThalesAnnualActivity.class);
        startActivity(intent);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_llz_thales420);

        setTitle("Thales LLZ Maintenance");

    }

}