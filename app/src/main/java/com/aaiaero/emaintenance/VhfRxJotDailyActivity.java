package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.AlertDialog;
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

public class VhfRxJotDailyActivity extends AppCompatActivity {

    private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
    private MySignature mySignature = new MySignature(this);
    private int selectedID;//Copy
    private String selectedName;//Copy
    private EditText[] editTextArray;//Copy
    private Switch[] switchArray={};//Copy
    private Spinner[] spinnerArray={};//Copy
    private String thisActivityName = "VhfRxJotDailyActivity"; //Change Here as per your class name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vhf_rx_jot_daily);


        //Define and Initialize all EditTexts serially here
        EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8,editText9, editText10, editText11, editText12, editText13, editText14, editText15, editText16, editText17, editText18, editText19, editText20,
                editText21, editText22, editText23, editText24,editText25, editText26, editText27, editText28, editText29, editText30, editText31, editText32, editText33, editText34, editText35, editText36, editText37, editText38, editText39, editText40,
                editText41, editText42, editText43, editText44, editText45, editText46, editText47, editText48, editText49, editText50, editText51, editText52, editText53, editText54, editText55, editText56, editText57, editText58,editText59, editText60,
                editText61, editText62,editText63, editText64, editText65, editText66, editText67, editText68,editText69, editText70, editText71, editText72, editText73, editText74, editText75, editText76, editText77, editText78, editText79, editText80,
                editText81, editText82, editText83, editText84, editText85, editText86, editText87, editText88,editText89,editText90, editText91, editText92, editText93, editText94,editText95, editText96, editText97, editText98,editText99, editText100,
                editText101, editText102, editText103, editText104, editText105, editText106, editText107, editText108, editText109, editText110, editText111, editText112, editText113, editText114, editText115, editText116, editText117, editText118, editText119,
                editText120, editText121, editText122, editText123, editText124,editText125, editText126, editText127, editText128, editText129, editText130, editText131, editText132, editText133, editText134, editText135, editText136, editText137;

        editTextArray = new EditText[]{
                editText1 = (EditText) findViewById(R.id.editTextVhfRxJotDailyStation),
                editText2 = (EditText) findViewById(R.id.editTextVhfRxJotDailyRegion),
                editText3 = (EditText) findViewById(R.id.editTextVhfRxJotDailyMake),
                editText4 = (EditText) findViewById(R.id.editTextVhfRxJotDailyRx1),
                editText5 = (EditText) findViewById(R.id.editTextVhfRxJotDailyRx2),
                editText6 = (EditText) findViewById(R.id.editTextVhfRxJotDailyRx3),
                editText7 = (EditText) findViewById(R.id.editTextVhfRxJotDailyRx4),
                editText8 = (EditText) findViewById(R.id.editTextVhfRxJotDailyRx5),
                editText9 = (EditText) findViewById(R.id.editTextVhfRxJotDailyRx6),
                editText10 = (EditText) findViewById(R.id.editTextVhfRxJotDailyFreq1),
                editText11 = (EditText) findViewById(R.id.editTextVhfRxJotDailyFreq2),
                editText12 = (EditText) findViewById(R.id.editTextVhfRxJotDailyFreq3),
                editText13 = (EditText) findViewById(R.id.editTextVhfRxJotDailyFreq4),
                editText14 = (EditText) findViewById(R.id.editTextVhfRxJotDailyFreq5),
                editText15 = (EditText) findViewById(R.id.editTextVhfRxJotDailyFreq6),
                editText16 = (EditText) findViewById(R.id.editTextVhfRxJotDailyStatus1),
                editText17 = (EditText) findViewById(R.id.editTextVhfRxJotDailyStatus2),
                editText18 = (EditText) findViewById(R.id.editTextVhfRxJotDailyStatus3),
                editText19 = (EditText) findViewById(R.id.editTextVhfRxJotDailyStatus4),
                editText20 = (EditText) findViewById(R.id.editTextVhfRxJotDailyStatus5),
                editText21 = (EditText) findViewById(R.id.editTextVhfRxJotDailyStatus6),
                editText22 = (EditText) findViewById(R.id.editTextVhfRxJotDailyBite1),
                editText23 = (EditText) findViewById(R.id.editTextVhfRxJotDailyBite2),
                editText24 = (EditText) findViewById(R.id.editTextVhfRxJotDailyBite3),
                editText25 = (EditText) findViewById(R.id.editTextVhfRxJotDailyBite4),
                editText26 = (EditText) findViewById(R.id.editTextVhfRxJotDailyBite5),
                editText27 = (EditText) findViewById(R.id.editTextVhfRxJotDailyBite6),
                editText28 = (EditText) findViewById(R.id.editTextVhfRxJotDailyRSSI1),
                editText29 = (EditText) findViewById(R.id.editTextVhfRxJotDailyRSSI2),
                editText30 = (EditText) findViewById(R.id.editTextVhfRxJotDailyRSSI3),
                editText31 = (EditText) findViewById(R.id.editTextVhfRxJotDailyRSSI4),
                editText32 = (EditText) findViewById(R.id.editTextVhfRxJotDailyRSSI5),
                editText33 = (EditText) findViewById(R.id.editTextVhfRxJotDailyRSSI6),
                editText34 = (EditText) findViewById(R.id.editTextVhfRxJotDailyCN1),
                editText35 = (EditText) findViewById(R.id.editTextVhfRxJotDailyCN2),
                editText36 = (EditText) findViewById(R.id.editTextVhfRxJotDailyCN3),
                editText37 = (EditText) findViewById(R.id.editTextVhfRxJotDailyCN4),
                editText38 = (EditText) findViewById(R.id.editTextVhfRxJotDailyCN5),
                editText39 = (EditText) findViewById(R.id.editTextVhfRxJotDailyCN6),
                editText40 = (EditText) findViewById(R.id.editTextVhfRxJotDailyTemp1),
                editText41 = (EditText) findViewById(R.id.editTextVhfRxJotDailyTemp2),
                editText42 = (EditText) findViewById(R.id.editTextVhfRxJotDailyTemp3),
                editText43 = (EditText) findViewById(R.id.editTextVhfRxJotDailyTemp4),
                editText44 = (EditText) findViewById(R.id.editTextVhfRxJotDailyTemp5),
                editText45 = (EditText) findViewById(R.id.editTextVhfRxJotDailyTemp6),
                editText46 = (EditText) findViewById(R.id.editTextVhfRxJotDailyACpre1),
                editText47 = (EditText) findViewById(R.id.editTextVhfRxJotDailyACpre2),
                editText48 = (EditText) findViewById(R.id.editTextVhfRxJotDailyACpre3),
                editText49 = (EditText) findViewById(R.id.editTextVhfRxJotDailyACpre4),
                editText50 = (EditText) findViewById(R.id.editTextVhfRxJotDailyACpre5),
                editText51 = (EditText) findViewById(R.id.editTextVhfRxJotDailyACpre6),
                editText52 = (EditText) findViewById(R.id.editTextVhfRxJotDailyDCpre1),
                editText53 = (EditText) findViewById(R.id.editTextVhfRxJotDailyDCpre2),
                editText54 = (EditText) findViewById(R.id.editTextVhfRxJotDailyDCpre3),
                editText55 = (EditText) findViewById(R.id.editTextVhfRxJotDailyDCpre4),
                editText56 = (EditText) findViewById(R.id.editTextVhfRxJotDailyDCpre5),
                editText57 = (EditText) findViewById(R.id.editTextVhfRxJotDailyDCpre6),
                editText58 = (EditText) findViewById(R.id.editTextVhfRxJotDailyACDC1),
                editText59 = (EditText) findViewById(R.id.editTextVhfRxJotDailyACDC2),
                editText60 = (EditText) findViewById(R.id.editTextVhfRxJotDailyACDC3),
                editText61 = (EditText) findViewById(R.id.editTextVhfRxJotDailyACDC4),
                editText62 = (EditText) findViewById(R.id.editTextVhfRxJotDailyACDC5),
                editText63 = (EditText) findViewById(R.id.editTextVhfRxJotDailyACDC6),
                editText64 = (EditText) findViewById(R.id.editTextVhfRxJotDailyLoud1),
                editText65 = (EditText) findViewById(R.id.editTextVhfRxJotDailyLoud2),
                editText66 = (EditText) findViewById(R.id.editTextVhfRxJotDailyLoud3),
                editText67 = (EditText) findViewById(R.id.editTextVhfRxJotDailyLoud4),
                editText68 = (EditText) findViewById(R.id.editTextVhfRxJotDailyLoud5),
                editText69 = (EditText) findViewById(R.id.editTextVhfRxJotDailyLoud6),
                editText70 = (EditText) findViewById(R.id.editTextVhfRxJotDailyRemarks1),
                editText71 = (EditText) findViewById(R.id.editTextVhfRxJotDailyRx7),
                editText72 = (EditText) findViewById(R.id.editTextVhfRxJotDailyRx8),
                editText73 = (EditText) findViewById(R.id.editTextVhfRxJotDailyRx9),
                editText74 = (EditText) findViewById(R.id.editTextVhfRxJotDailyRx10),
                editText75 = (EditText) findViewById(R.id.editTextVhfRxJotDailyRx11),
                editText76 = (EditText) findViewById(R.id.editTextVhfRxJotDailyRx12),
                editText77 = (EditText) findViewById(R.id.editTextVhfRxJotDailyFreq7),
                editText78 = (EditText) findViewById(R.id.editTextVhfRxJotDailyFreq8),
                editText79 = (EditText) findViewById(R.id.editTextVhfRxJotDailyFreq9),
                editText80 = (EditText) findViewById(R.id.editTextVhfRxJotDailyFreq10),
                editText81 = (EditText) findViewById(R.id.editTextVhfRxJotDailyFreq11),
                editText82 = (EditText) findViewById(R.id.editTextVhfRxJotDailyFreq12),
                editText83 = (EditText) findViewById(R.id.editTextVhfRxJotDailyStatus7),
                editText84 = (EditText) findViewById(R.id.editTextVhfRxJotDailyStatus8),
                editText85 = (EditText) findViewById(R.id.editTextVhfRxJotDailyStatus9),
                editText86 = (EditText) findViewById(R.id.editTextVhfRxJotDailyStatus10),
                editText87 = (EditText) findViewById(R.id.editTextVhfRxJotDailyStatus11),
                editText88 = (EditText) findViewById(R.id.editTextVhfRxJotDailyStatus12),
                editText89 = (EditText) findViewById(R.id.editTextVhfRxJotDailyBite7),
                editText90 = (EditText) findViewById(R.id.editTextVhfRxJotDailyBite8),
                editText91 = (EditText) findViewById(R.id.editTextVhfRxJotDailyBite9),
                editText92 = (EditText) findViewById(R.id.editTextVhfRxJotDailyBite10),
                editText93 = (EditText) findViewById(R.id.editTextVhfRxJotDailyBite11),
                editText94 = (EditText) findViewById(R.id.editTextVhfRxJotDailyBite12),
                editText95 = (EditText) findViewById(R.id.editTextVhfRxJotDailyRSSI7),
                editText96 = (EditText) findViewById(R.id.editTextVhfRxJotDailyRSSI8),
                editText97 = (EditText) findViewById(R.id.editTextVhfRxJotDailyRSSI9),
                editText98 = (EditText) findViewById(R.id.editTextVhfRxJotDailyRSSI10),
                editText99 = (EditText) findViewById(R.id.editTextVhfRxJotDailyRSSI11),
                editText100 = (EditText) findViewById(R.id.editTextVhfRxJotDailyRSSI12),
                editText101 = (EditText) findViewById(R.id.editTextVhfRxJotDailyCN7),
                editText102 = (EditText) findViewById(R.id.editTextVhfRxJotDailyCN8),
                editText103 = (EditText) findViewById(R.id.editTextVhfRxJotDailyCN9),
                editText104 = (EditText) findViewById(R.id.editTextVhfRxJotDailyCN10),
                editText105 = (EditText) findViewById(R.id.editTextVhfRxJotDailyCN11),
                editText106 = (EditText) findViewById(R.id.editTextVhfRxJotDailyCN12),
                editText107 = (EditText) findViewById(R.id.editTextVhfRxJotDailyTemp7),
                editText108 = (EditText) findViewById(R.id.editTextVhfRxJotDailyTemp8),
                editText109 = (EditText) findViewById(R.id.editTextVhfRxJotDailyTemp9),
                editText110 = (EditText) findViewById(R.id.editTextVhfRxJotDailyTemp10),
                editText111 = (EditText) findViewById(R.id.editTextVhfRxJotDailyTemp11),
                editText112 = (EditText) findViewById(R.id.editTextVhfRxJotDailyTemp12),
                editText113 = (EditText) findViewById(R.id.editTextVhfRxJotDailyACpre7),
                editText114 = (EditText) findViewById(R.id.editTextVhfRxJotDailyACpre8),
                editText115 = (EditText) findViewById(R.id.editTextVhfRxJotDailyACpre9),
                editText116 = (EditText) findViewById(R.id.editTextVhfRxJotDailyACpre10),
                editText117 = (EditText) findViewById(R.id.editTextVhfRxJotDailyACpre11),
                editText118 = (EditText) findViewById(R.id.editTextVhfRxJotDailyACpre12),
                editText119 = (EditText) findViewById(R.id.editTextVhfRxJotDailyDCpre7),
                editText120 = (EditText) findViewById(R.id.editTextVhfRxJotDailyDCpre8),
                editText121 = (EditText) findViewById(R.id.editTextVhfRxJotDailyDCpre9),
                editText122 = (EditText) findViewById(R.id.editTextVhfRxJotDailyDCpre10),
                editText123 = (EditText) findViewById(R.id.editTextVhfRxJotDailyDCpre11),
                editText124 = (EditText) findViewById(R.id.editTextVhfRxJotDailyDCpre12),
                editText125 = (EditText) findViewById(R.id.editTextVhfRxJotDailyACDC7),
                editText126 = (EditText) findViewById(R.id.editTextVhfRxJotDailyACDC8),
                editText127 = (EditText) findViewById(R.id.editTextVhfRxJotDailyACDC9),
                editText128 = (EditText) findViewById(R.id.editTextVhfRxJotDailyACDC10),
                editText129 = (EditText) findViewById(R.id.editTextVhfRxJotDailyACDC11),
                editText130 = (EditText) findViewById(R.id.editTextVhfRxJotDailyACDC12),
                editText131 = (EditText) findViewById(R.id.editTextVhfRxJotDailyLoud7),
                editText132 = (EditText) findViewById(R.id.editTextVhfRxJotDailyLoud8),
                editText133 = (EditText)  findViewById(R.id.editTextVhfRxJotDailyLoud9),
                editText134 = (EditText)  findViewById(R.id.editTextVhfRxJotDailyLoud10),
                editText135 = (EditText)  findViewById(R.id.editTextVhfRxJotDailyLoud11),
                editText136 = (EditText) findViewById(R.id.editTextVhfRxJotDailyLoud12),
                editText137 = (EditText) findViewById(R.id.editTextVhfRxJotDailyRemarks2)};

//Define and Initialize all Switches serially here

//Define and Initialize all Spinners serially here


//---------------------To Set View in Current Activity------------------

        TextView textView7 = (TextView) findViewById(R.id.textView7);
        textView7.setText("Name: " + PersonalDetailsActivity.naam);
        TextView textView8 = (TextView) findViewById(R.id.textView8);
        textView8.setText("Designation: " + PersonalDetailsActivity.design);
        TextView textView10 = (TextView) findViewById(R.id.textView118);
        textView10.setText("Emp No.: " + PersonalDetailsActivity.EmpID);
        TextView textView9 = (TextView) findViewById(R.id.textView9);
        textView9.setText("Location: " + MainActivity.latLong1);

        TextView textViewDate = (TextView) findViewById(R.id.textViewDate);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yyyy HH:mm");
        String strData = sdf.format(calendar.getTime());
        textViewDate.setText(strData);

        Intent receivedIntent = getIntent();
        //now get the itemID we passed as an extra
        selectedID = receivedIntent.getIntExtra("id", -1); //NOTE: -1 is just the default value
        if (selectedID == -1) {

        } else {
            //now get the name we passed as an extra
            selectedName = receivedIntent.getStringExtra("name");
            String selectedEditTextData = receivedIntent.getStringExtra("editTextData");
            String selectedSwitchData = receivedIntent.getStringExtra("switchData");
            String selectedSpinnerData = receivedIntent.getStringExtra("spinnerData");
            //Log.i("received Data1 = ", selectedSwitchData);
            //Log.i("received Data2 = ", selectedSpinnerData);
            String[] seperatedData = myFunctions.seperateEditText(selectedEditTextData);
            String[] seperatedSwitchData = myFunctions.seperateSwitchData(selectedSwitchData);
            String[] seperatedSpinnerData = myFunctions.seperateSpinnerData(selectedSpinnerData);

            //Log.d("RxArr=",Arrays.toString(seperatedData));
            myFunctions.putData(seperatedData, editTextArray);
            myFunctions.putSwitchData(seperatedSwitchData, switchArray);
            myFunctions.putSpinnerData(seperatedSpinnerData, spinnerArray);
            //Log.i("received Data = ", selectedEditTextData);

        }

        Button signDocument = (Button) findViewById(R.id.button11) ;
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
        // Fixed for all activity-------------------------------------------------------------------

    }
    private void generatePDF(){

        // Fixed for all activity-------------------------------------------------------------------

        String outputEditText = myFunctions.getEditTextDataForPDF(editTextArray);

        String[] editTextDataForPDF = myFunctions.seperateEditText(outputEditText);


//        String outputSpinner = myFunctions.getSpinnerStatusForPDF(spinnerArray);
//
//        String[] spinnerDataForPDF = myFunctions.seperateSpinnerData(outputSpinner);

        PdfDocument myPdfdocument = new PdfDocument();

        Paint paint = new Paint();
        Paint titlePaint = new Paint();

        // Change below as per requirement-----------------------------------------------------------
        // crate a page description
        PdfDocument.PageInfo myPageInfo1 = new PdfDocument.PageInfo.Builder(723, 1024, 1).create();

        // start a page
        PdfDocument.Page myPage1 = myPdfdocument.startPage(myPageInfo1);
        Canvas canvas = myPage1.getCanvas();


        Bitmap bmp,scaledbmp;

        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.vhfrxjotdaily1);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);

        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(12);

        int[] editTextXPixel = {244,558,180,191,273,357,438,520,602,191,273,357,438,520,602,191,273,357,438,520,602,
                191,273,357,438,520,602,191,273,357,438,520,602,191,273,357,438,520,602,191,273,357,438,520,602,
                191,273,357,438,520,602,191,273,357,438,520,602,191,273,357,438,520,602,191,273,357,438,520,602,70};
        int[] editTextYPixel = {150,150,168,210,210,210,210,210,210,242,242,242,242,242,242,278,278,278,278,278,278,
                318,318,318,318,318,318,376,376,376,376,376,376,405,405,405,405,405,405,438,438,438,438,438,438,
                474,474,474,474,474,474,510,510,510,510,510,510,550,550,550,550,550,550,596,596,596,596,596,596,660};



        // Change till here as per requirements ----------------------------------------------------

        //Fixed for all activity--------------------------------------------------------------------

        for(int i = 0; i < editTextXPixel.length; i++){
            canvas.drawText( editTextDataForPDF[i],editTextXPixel[i],editTextYPixel[i],titlePaint);
        }


    /*    for(int i = 0; i < spinnerDataForPDF.length; i++){
            canvas.drawText( spinnerDataForPDF[i],spinnerXPixel[i],spinnerYPixel[i],titlePaint);
        }
*/

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
        String strData = sdf.format(calendar.getTime());
        // Fixed till here--------------------------------------------------------------------------

        // Change as per your requirement-----------------------------------------------------------
        titlePaint.setTextSize(12);

        canvas.drawText(strData,538,168,titlePaint);//Printing Date on PDF

        myPdfdocument.finishPage(myPage1);


        //---------------------End of Page 1---------------

        //----------------------Page 2---------------------

        PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(723, 1024, 2).create();

        // start a page
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);

        canvas = myPage2.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.vhfrxjotdaily2);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel2 = {192,274,356,440,520,601,192,274,356,440,520,601,192,274,356,440,520,601,192,274,356,440,520,601,
                192,274,356,440,520,601,192,274,356,440,520,601,192,274,356,440,520,601,192,274,356,440,520,601,
                192,274,356,440,520,601,192,274,356,440,520,601,192,274,356,440,520,601,75};
        int[] editTextYPixel2 = {137,137,137,137,137,137,168,168,168,168,168,168,205,205,205,205,205,205,245,245,245,245,245,245,
                304,304,304,304,304,304,333,333,333,333,333,333,368,368,368,368,368,368,402,402,402,402,402,402,
                438,438,438,438,438,438,482,482,482,482,482,482,525,525,525,525,525,525,576};



        for(int i = 0; i < editTextXPixel2.length; i++){
            canvas.drawText( editTextDataForPDF[i+70],editTextXPixel2[i],editTextYPixel2[i],titlePaint);
        }


        titlePaint.setTextSize(12);
        paint.setTextAlign(Paint.Align.LEFT);

        canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 75, 620, paint);

        myPdfdocument.finishPage(myPage2);

        //-------------------------End of Page 2-----------------



        ActivityCompat.requestPermissions(this, new String[]{

                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Communication/VHFRxJotron/Daily/";// Change Here------------------
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //String targetPdf = directory_path + "test.pdf";
        //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
        String fileName = "Daily VHF RX JOTRON " + strData + ".pdf"; // Change Here--------------------------
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
        //myFunctions.saveToParse(String targetPdf, String fileName, String Equipment,String Schedule_Type,String EditTextData)
        myFunctions.saveToParse(targetPdf, fileName,"VHF","Daily",outputEditText,MyFunctions.specificCode("d"),"outputSwitch", "outputSpinner");// Change Here-----------------------

        // This function will send eMail using JavaMailAPI
        //myFunctions.sendEmail(String To, String Subject, String Message,String targetPdf,String desired_Filename)
        myFunctions.sendEmail(PersonalDetailsActivity.emailTo + "@aai.aero",
                "Daily Maintenance of JOTRON VHF Rx done.",//Change Here-----------------------------
                "Maintenance Schedule is attached. Please verify.", targetPdf, fileName);


        myFunctions.toLogoutActivity();
    }

    //Copy this function in your activity completely without any change
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.sub_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Copy this function in your activity completely without any change
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()){

            case R.id.putInDB:
                final AlertDialog.Builder alert = new AlertDialog.Builder(this);
                View mView = getLayoutInflater().inflate(R.layout.custom_dialog,null);
                final EditText desiredFormName = (EditText)mView.findViewById(R.id.txt_input);
                Button btn_cancel = (Button)mView.findViewById(R.id.btn_cancel);
                Button btn_okay = (Button)mView.findViewById(R.id.btn_okay);
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
                        myFunctions.addToDB(view ,editTextArray,switchArray,spinnerArray,formName, thisActivityName);
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
                                Intent intent = new Intent(getApplicationContext(),ListDataActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
                return true;

            case R.id.showDB:
                Intent intent = new Intent(getApplicationContext(),ListDataActivity.class);
                startActivity(intent);
                return true;

            case R.id.logout:
                myFunctions.toLogoutActivity();
                return true;

            default:
                return false;
        }
    }

    //----At last don't forget to put an entry in Switch Case of ListDataActivity.java------------


}