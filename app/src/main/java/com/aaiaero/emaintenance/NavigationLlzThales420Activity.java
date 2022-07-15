package com.aaiaero.emaintenance;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;

public class NavigationLlzThales420Activity extends AppCompatActivity {

    Button daily, weekly, fortnightly, monthly, quarterly, halfYearly, yearly, miscellaneous;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_llz_thales420);

        setTitle("Thales LLZ Maintenance");

        daily = (Button) findViewById(R.id.daily);
        weekly = (Button) findViewById(R.id.weekly);
        fortnightly = (Button) findViewById(R.id.fortnightly);
        monthly = (Button) findViewById(R.id.monthly);
        quarterly = (Button) findViewById(R.id.quarterly);
        halfYearly = (Button) findViewById(R.id.halfYearly);
        yearly = (Button) findViewById(R.id.yearly);
        miscellaneous = (Button) findViewById(R.id.miscellaneous);

        Intent intent = getIntent();

    }

    public void dailyClicked (View view){


        Intent intent = new Intent(getApplicationContext(), LlzThalesDailyActivity.class);
        startActivity(intent);


    }

    public void weeklyClicked (View view){

        Intent intent = new Intent(getApplicationContext(),LlzThalesWeeklyActivity.class);
        startActivity(intent);


    }

    public void fortnightlyClicked (View view){




    }

    public void monthlyClicked (View view){

        Intent intent = new Intent(getApplicationContext(),LlzThalesMonthlyActivity.class);
        startActivity(intent);


    }

    public void quaterlyClicked (View view){

        Intent intent = new Intent(getApplicationContext(),LlzThalesQuarterlyActivity.class);
        startActivity(intent);



    }

    public void halfYearlyClicked (View view){




    }

    public void yearlyClicked (View view){

        Intent intent = new Intent(getApplicationContext(),LlzThalesAnnualActivity.class);
        startActivity(intent);

    }

    public void miscellaneousClicked (View view){
        // Launch the Others  Activity



    }
}