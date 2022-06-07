package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.parse.DeleteCallback;
import com.parse.ParseUser;

public class LogOutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_out);

        setTitle("AAI CNS Maintenance App");
        Button logOutButton = (Button) findViewById(R.id.logOutbutton);
        Button toListSchedules = (Button) findViewById(R.id.listViewActivity);

        toListSchedules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),FillOrChooseActivity.class);
                startActivity(intent);
            }
        });

        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ParseUser.logOut();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()){
            case R.id.webGoogle:
                Intent intent = new Intent(getApplicationContext(),CheckSchedules.class);
                intent.putExtra("siteName", "https://www.google.com/");
                startActivity(intent);
                return true;
            case R.id.checkSchedules:
                Intent intent1 = new Intent(getApplicationContext(),CheckSchedules.class);
                intent1.putExtra("siteName", "http://deepaksinghtest-com.stackstaging.com/parse_login/");
                startActivity(intent1);
                return true;
            case R.id.settings:
                Log.i("Menu item Selected","Settings");
                return true;
            case R.id.help:
                Log.i("Menu item Selected","Help");
                return true;
            default:
                return false;
        }
    }

}
