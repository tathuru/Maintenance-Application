package com.aaiaero.emaintenance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class PersonalDetailsActivity extends AppCompatActivity implements View.OnClickListener{

    private static final int CAMERA_REQUEST = 1888;
    private ImageView imageView;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;
    public static Bitmap photo, sigNature;
    EditText editText;
    boolean imageTaken = false;
    Spinner spinnerP;
    EditText email, empppID;

    public static String naam, design;

    private TextView textView;
    public static String emailTo, EmpID;
    private final String TAG = "TextEditor";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);

        Intent intent = getIntent();

        setTitle("Personal Details");

        email = (EditText) findViewById(R.id.editTextEmail);



        Button button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editTextP);
        spinnerP = (Spinner) findViewById(R.id.spinnerP);
        empppID = (EditText) findViewById(R.id.editTextEmpID);



        TextView locationTextView = (TextView) findViewById(R.id.locationTextView);
        locationTextView.setText("Location: " + MainActivity.latLong1);

        this.imageView = (ImageView)this.findViewById(R.id.imageViewSelf);
        Button photoButton = (Button) this.findViewById(R.id.button1);

        RelativeLayout relativeLayoutPersonal = (RelativeLayout) findViewById(R.id.relativeLayoutPersonal);
        //ImageView imageViewSelf = (ImageView) findViewById(R.id.imageViewSelf);
        TextView textView6 = (TextView) findViewById(R.id.textView6);

        relativeLayoutPersonal.setOnClickListener(this);
        imageView.setOnClickListener(this);
        textView6.setOnClickListener(this);
        locationTextView.setOnClickListener(this);

        textView = (TextView) findViewById(R.id.textView2);
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                isKeyboardShown(textView.getRootView());
            }
        });

        ActivityCompat.requestPermissions(this,new String[]{ android.Manifest.permission.CAMERA}, PackageManager.PERMISSION_GRANTED);

        photoButton.setOnClickListener(new View.OnClickListener() {

            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onClick(View v)
            {

                if (checkSelfPermission(android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
                {
                    requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_PERMISSION_CODE);
                }
                else
                {
                    Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, CAMERA_REQUEST);
                }
            }
        });


    }

    @Override
    public void onClick(View view) {

        if (( view.getId() == R.id.relativeLayoutPersonal ||  view.getId() == R.id.imageViewSelf ||
                view.getId() == R.id.textView6 || view.getId() == R.id.locationTextView ) && isKeyboardShown(textView.getRootView() )){

            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            imageTaken = true;
            photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == MY_CAMERA_PERMISSION_CODE)
        {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(this, "camera permission granted", Toast.LENGTH_LONG).show();
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
            else
            {
                Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show();
            }
        }


    }

    public void verifyClicked (View view){

        if (imageTaken) {

            if (editText.getText().toString().length() != 0 &&
                    spinnerP.getSelectedItemId() != 0 && empppID.getText().toString().length() != 0) {
                //Go to next Intent
                String editText2 = spinnerP.getSelectedItem().toString();

                naam = editText.getText().toString();
                design = editText2;
                EmpID = empppID.getText().toString();


                Intent intent = new Intent(getApplicationContext(), FillOrChooseActivity.class);
                startActivity(intent);

            } else {

                Toast.makeText(this, "Some Fields Missing.", Toast.LENGTH_SHORT).show();

            }

        }else Toast.makeText(this, "Please Take Selfie.", Toast.LENGTH_SHORT).show();

    }

    private boolean isKeyboardShown(View rootView) {
        /* 128dp = 32dp * 4, minimum button height 32dp and generic 4 rows soft keyboard */
        final int SOFT_KEYBOARD_HEIGHT_DP_THRESHOLD = 128;

        Rect r = new Rect();
        rootView.getWindowVisibleDisplayFrame(r);
        DisplayMetrics dm = rootView.getResources().getDisplayMetrics();
        /* heightDiff = rootView height - status bar height (r.top) - visible frame height (r.bottom - r.top) */
        int heightDiff = rootView.getBottom() - r.bottom;
        /* Threshold size: dp to pixels, multiply with display density */
        boolean isKeyboardShown = heightDiff > SOFT_KEYBOARD_HEIGHT_DP_THRESHOLD * dm.density;

        Log.d(TAG, "isKeyboardShown ? " + isKeyboardShown + ", heightDiff:" + heightDiff + ", density:" + dm.density
                + "root view height:" + rootView.getHeight() + ", rect:" + r);

        return isKeyboardShown;
    }

    // Fetch the stored data in onResume()
    // Because this is what will be called
    // when the app opens again
    @Override
    protected void onResume() {
        super.onResume();

        // Fetching the stored data
        // from the SharedPreference
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);

        String s1 = sh.getString("name", "");
        //int a = sh.getInt("age", 0);

        // Setting the fetched data
        // in the EditTexts
        email.setText(s1);
        emailTo = email.getText().toString();
        //age.setText(String.valueOf(a));
    }

    // Store the data in the SharedPreference
    // in the onPause() method
    // When the user closes the application
    // onPause() will be called
    // and data will be stored
    @Override
    protected void onPause() {
        super.onPause();

        // Creating a shared pref object
        // with a file name "MySharedPref"
        // in private mode
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        // write all the data entered by the user in SharedPreference and apply
        myEdit.putString("name", email.getText().toString());

        emailTo = email.getText().toString();
        //myEdit.putInt("age", Integer.parseInt(age.getText().toString()));
        myEdit.apply();
    }


}
