package com.aaiaero.emaintenance;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class NavAidsDVORThales432DailyActivity extends AppCompatActivity {

    private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
    private MySignature mySignature = new MySignature(this);
    private int selectedID;//Copy
    private String selectedName;//Copy
    private EditText[] editTextArray;//Copy
    private Switch[] switchArray;//Copy
    private Spinner[] spinnerArray = {};//Copy

    public  String Date;

    private String thisActivityName = "NavAidsDVORThales432DailyActivity"; //Change Here as per your class name

    public void click(View view1) {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_aids_dvorthales432_daily);

        EditText editText1,editText2,editText3,editText4,editText5,editText6, editText7,editText8,
                editText9;


        editTextArray =  new EditText[] { editText1 = (EditText) findViewById(R.id.editText1),
                editText2 = (EditText) findViewById(R.id.editText2),
                editText3 = (EditText) findViewById(R.id.editText3),
                editText4 = (EditText) findViewById(R.id.editText4),
                editText5 = (EditText) findViewById(R.id.editText5),
                editText6 = (EditText) findViewById(R.id.editText6),
                editText7 = (EditText) findViewById(R.id.editText7),
                editText8 = (EditText) findViewById(R.id.editText8),
                editText9 = (EditText) findViewById(R.id.editText9)};



        Switch switch1,switch2,switch3,switch4,switch5,switch6,switch7,switch8,switch9,switch10,switch11,switch12;


        switchArray = new Switch[]{    switch1 = (Switch) findViewById(R.id.switch1),
                switch2 = (Switch) findViewById(R.id.switch2),
                switch3 = (Switch) findViewById(R.id.switch3),
                switch4 = (Switch) findViewById(R.id.switch4),
                switch5 = (Switch) findViewById(R.id.switch5),
                switch6 = (Switch) findViewById(R.id.switch6),
                switch7 = (Switch) findViewById(R.id.switch7),
                switch8 = (Switch) findViewById(R.id.switch8),
                switch9 = (Switch) findViewById(R.id.switch9),
                switch10 = (Switch) findViewById(R.id.switch10),
                switch11 = (Switch) findViewById(R.id.switch11),
                switch12 = (Switch) findViewById(R.id.switch12)};

        TextView textViewN = (TextView) findViewById(R.id.textViewN);
        textViewN.setText("Name: " + PersonalDetailsActivity.naam);
        TextView textViewD = (TextView) findViewById(R.id.textViewD);
        textViewD.setText("Designation: " + PersonalDetailsActivity.design);
        TextView textViewE = (TextView) findViewById(R.id.textViewE);
        textViewE.setText("Emp No.: " + PersonalDetailsActivity.EmpID);
        TextView textViewL = (TextView) findViewById(R.id.textViewL);
        textViewL.setText("Location: " + MainActivity.latLong1);

        TextView textView = (TextView) findViewById(R.id.textViewDate);

        SimpleDateFormat date1 = new SimpleDateFormat("dd.MM.yyyy, HH:mm");
        Date = date1.format(new Date());
        textView.setText(Date);


        Intent receivedIntent = getIntent();
        //now get the itemID we passed as an extra
        selectedID = receivedIntent.getIntExtra("id", -1); //NOTE: -1 is just the default value
        if (selectedID == -1) {

        } else {
            //now get the name we passed as an extra
            selectedName = receivedIntent.getStringExtra("name");
            String selectedEditTextData = receivedIntent.getStringExtra("editTextData");
            String selectedSwitchData = receivedIntent.getStringExtra("switchData");
            //String selectedSpinnerData = receivedIntent.getStringExtra("spinnerData");
            //Log.i("received Data1 = ", selectedSwitchData);
            //Log.i("received Data2 = ", selectedSpinnerData);
            String[] seperatedData = myFunctions.seperateEditText(selectedEditTextData);
            String[] seperatedSwitchData = myFunctions.seperateSwitchData(selectedSwitchData);
            // String[] seperatedSpinnerData = myFunctions.seperateSpinnerData(selectedSpinnerData);

            //Log.d("RxArr=",Arrays.toString(seperatedData));
            myFunctions.putData(seperatedData, editTextArray);
            myFunctions.putSwitchData(seperatedSwitchData, switchArray);
            // myFunctions.putSpinnerData(seperatedSpinnerData, spinnerArray);
            //Log.i("received Data = ", selectedEditTextData);

        }

        Button signDocument = (Button) findViewById(R.id.button11);
        Button submitSchedule = (Button) findViewById(R.id.button10);

        submitSchedule.setVisibility(View.INVISIBLE);
        signDocument.setVisibility(View.VISIBLE);

        signDocument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySignature.dialog_action(submitSchedule, signDocument);

            }
        });

        submitSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                generatePDF();

            }

        });
    }


    private void generatePDF() {

        // Fixed for all activity-------------------------------------------------------------------

        String outputEditText = myFunctions.getEditTextDataForPDF(editTextArray);

        String[] editTextDataForPDF = myFunctions.seperateEditText(outputEditText);

        String outputSwitch = myFunctions.getSwitchStatusForPDF(switchArray);

        String[] switchDataForPDF = myFunctions.seperateSwitchData(outputSwitch);


        PdfDocument myPdfdocument = new PdfDocument();

        Paint paint = new Paint();
        Paint titlePaint = new Paint();

        // Change below as per requirement-----------------------------------------------------------
        // crate a page description
        PdfDocument.PageInfo myPageInfo1 = new PdfDocument.PageInfo.Builder(1384, 1792, 1).create();


        // start a page
        PdfDocument.Page myPage1 = myPdfdocument.startPage(myPageInfo1);
        Canvas canvas = myPage1.getCanvas();


        Bitmap bmp, scaledbmp;

        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.dvorthales432daily);
        scaledbmp = Bitmap.createScaledBitmap(bmp, 1384, 1792, false);

        canvas.drawBitmap(scaledbmp, 0, 0, paint);


        paint.setTextAlign(Paint.Align.LEFT);

        titlePaint.setTextSize(20);

        int[] editTextXPixel1 = {286, 317, 745, 1035, 1035, 1035, 1035, 1035, 180};
        int[] editTextYPixel1 = {247, 313, 313, 538, 599, 657, 688, 1075, 1185};

        int[] switchXPixel1 = {1035, 1035, 1035, 1035, 1035, 1035, 1035, 1035, 1035, 1035, 1035, 1035};
        int[] switchYPixel1 = {465, 498, 720, 754, 784, 818, 849, 892, 944, 980, 1026, 1109};


        for (int i = 0; i < editTextXPixel1.length; i++) {
            canvas.drawText(editTextDataForPDF[i], editTextXPixel1[i], editTextYPixel1[i], titlePaint);
        }

        for (int i = 0; i < switchXPixel1.length; i++) {
            canvas.drawText(switchDataForPDF[i], switchXPixel1[i], switchYPixel1[i], titlePaint);
        }


        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy_HHmm");
        String strData = sdf.format(calendar.getTime());
        // Fixed till here--------------------------------------------------------------------------

        // Change as per your requirement-----------------------------------------------------------
        titlePaint.setTextSize(20);

        canvas.drawText(Date, 997, 312, titlePaint);


        canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature, 350, 330, false), 713, 1285, paint);

        myPdfdocument.finishPage(myPage1);


        //---------------------End of Page 1---------------


        //-------------------------End of Page 2-----------------


        ActivityCompat.requestPermissions(this, new String[]{

                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Nav - Aids/DVOR/Thales - 432/Daily/";// Change Here------------------
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //String targetPdf = directory_path + "test.pdf";
        //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
        String fileName = "DVOR_THALES_432_Daily_" + strData + ".pdf"; // Change Here--------------------------
        String targetPdf = directory_path + fileName;
        File filePath = new File(targetPdf);
        try {
            myPdfdocument.writeTo(new FileOutputStream(filePath));
            //Toast.makeText(this, "Done", Toast.LENGTH_LONG).show();
            //done = true;
        } catch (IOException e) {
            Log.e("main", "error " + e.toString());
            Toast.makeText(this, "Something wrong: " + e.toString(), Toast.LENGTH_LONG).show();
        }
        myPdfdocument.close();

        String specificCode = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());// Change Here----------------------------
        //This function saves all the data to parse Server
        // myFunctions.saveToParse(String targetPdf, String fileName, String Equipment,String Schedule_Type,String EditTextData)

        myFunctions.saveToParse(targetPdf, fileName, "DVOR", "Daily", outputEditText, MyFunctions.specificCode("d"), outputSwitch, "outputSpinner");// Change Here-----------------------

        // This function will send eMail using JavaMailAPI

        myFunctions.sendEmail(PersonalDetailsActivity.emailTo + "@aai.aero",
                "Daily Maintenance of DVOR THALES 432 done.",//Change Here-----------------------------
                "Maintenance Schedule is attached. Please verify.", targetPdf, fileName);
        //---------------------------------------------------------------------------------------------------------

        myFunctions.toLogoutActivity();

    }

    //Copy this function in your activity completely without any change
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.sub_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Copy this function in your activity completely without any change
    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        super.onOptionsItemSelected(item);

        switch (item.getItemId()) {

            case R.id.putInDB:
                final AlertDialog.Builder alert = new AlertDialog.Builder(this);
                View mView = getLayoutInflater().inflate(R.layout.custom_dialog, null);
                final EditText desiredFormName = (EditText) mView.findViewById(R.id.txt_input);
                Button btn_cancel = (Button) mView.findViewById(R.id.btn_cancel);
                Button btn_okay = (Button) mView.findViewById(R.id.btn_okay);
                alert.setView(mView);
                final AlertDialog alertDialog = alert.create();
                alertDialog.setCanceledOnTouchOutside(false);
                btn_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
                btn_okay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        View view = findViewById(R.id.putInDB);
                        String formName = desiredFormName.getText().toString();
                        myFunctions.addToDB(view, editTextArray, switchArray, spinnerArray, formName, thisActivityName);
                        alertDialog.dismiss();
                    }
                });
                alertDialog.show();
                return true;

            case R.id.deleteFromDB:
                View view1 = findViewById(R.id.deleteFromDB);
                new AlertDialog.Builder(this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Delete Alert")
                        .setMessage("Do you really want to delete this entry permanently from Local DB?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                myFunctions.deleteFromDB(view1, selectedID, selectedName);
                                Intent intent = new Intent(getApplicationContext(), ListDataActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
                return true;

            case R.id.showDB:
                Intent intent = new Intent(getApplicationContext(), ListDataActivity.class);
                startActivity(intent);
                return true;

            case R.id.logout:
                myFunctions.toLogoutActivity();
                return true;

            default:
                return false;
        }
    }

}

