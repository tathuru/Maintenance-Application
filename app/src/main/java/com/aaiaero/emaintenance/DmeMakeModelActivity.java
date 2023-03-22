
package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DmeMakeModelActivity extends AppCompatActivity {

    public void thales (View view){


        Intent intent = new Intent(getApplicationContext(),DmeThalesActivity.class);
        startActivity(intent);


    }

    public void mopiens (View view){


        Intent intent = new Intent(getApplicationContext(),DmeMopiensActivity.class);
        startActivity(intent);


    }

    public void asii (View view){


        Intent intent = new Intent(getApplicationContext(),DMEASII1118AND1119.class);
        startActivity(intent);


    }

    public void selex (View view){


        Intent intent = new Intent(getApplicationContext(),DMESELEX1118AAND1119A.class);
        startActivity(intent);


    }

    public void gcel (View view){


        Intent intent = new Intent(getApplicationContext(),DmeGcelActivity.class);
        startActivity(intent);


    }

    public void intelcan (View view){


        Intent intent = new Intent(getApplicationContext(),DMEIntelcanN9040.class);
        startActivity(intent);


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dme_make_model);


    }
}

