
package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

public class DvorMakeModelActivity extends AppCompatActivity {

    public void thales (View view){


        Intent intent = new Intent(getApplicationContext(),DVORTHALES432.class);
        startActivity(intent);


    }

    public void mopiens (View view){


        Intent intent = new Intent(getApplicationContext(),DvorMopiensActivity.class);
        startActivity(intent);


    }

    public void asii (View view){


        Intent intent = new Intent(getApplicationContext(),DVORASII1150.class);
        startActivity(intent);


    }

    public void selex (View view){


        Intent intent = new Intent(getApplicationContext(),DVORSELEX1150.class);
        startActivity(intent);


    }

    public void gcel755 (View view){


        Intent intent = new Intent(getApplicationContext(),DvorGcel755Activity.class);
        startActivity(intent);


    }

    public void gcel757 (View view){


        Intent intent = new Intent(getApplicationContext(),DvorGcel757Activity.class);
        startActivity(intent);


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dvor_make_model);


    }
}