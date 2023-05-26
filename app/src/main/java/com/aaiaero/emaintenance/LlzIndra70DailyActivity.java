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

public class LlzIndra70DailyActivity extends AppCompatActivity {

    private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
    private MySignature mySignature = new MySignature(this);
    private int selectedID;//Copy
    private String selectedName;//Copy
    private EditText[] editTextArray;//Copy
    private Switch[] switchArray;//Copy
    private Spinner[] spinnerArray={};//Copy
    private String thisActivityName = "LlzIndra70DailyActivity"; //Change Here as per your class name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llz_indra70_daily);

        //Define and Initialize all EditTexts serially here
        EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8,editText9, editText10, editText11, editText12, editText13, editText14, editText15, editText16, editText17, editText18,
                editText19, editText20, editText21, editText22, editText23, editText24,editText25, editText26, editText27, editText28, editText29, editText30, editText31, editText32, editText33, editText34, editText35,
                editText36, editText37, editText38, editText39, editText40, editText41, editText42, editText43, editText44, editText45, editText46, editText47, editText48, editText49, editText50, editText51, editText52,
                editText53, editText54, editText55, editText56, editText57, editText58,editText59, editText60,editText61, editText62,editText63, editText64, editText65, editText66, editText67, editText68,editText69,
                editText70, editText71, editText72, editText73, editText74, editText75, editText76, editText77, editText78, editText79, editText80, editText81, editText82, editText83, editText84, editText85, editText86;

        editTextArray = new EditText[]{
                editText1 = (EditText) findViewById(R.id.editTextLlzIndra70DailyStation),
                editText2 = (EditText) findViewById(R.id.editTextLlzIndra70DailyModel),
                editText3 = (EditText) findViewById(R.id.editTextLlzIndra70DailyRWY),
                editText4 = (EditText) findViewById(R.id.editTextLlzIndra70DailyCat),
                editText5 = (EditText) findViewById(R.id.editTextLlzIndra70DailyFrequency),
                editText6 = (EditText) findViewById(R.id.editTextLlzIndra70DailyIdent),
                editText7 = (EditText) findViewById(R.id.editTextLlzIndra70DailyRoomTemp),
                editText8 = (EditText) findViewById(R.id.editTextLlzIndra70DailyHumidity),
                editText9 = (EditText) findViewById(R.id.editTextLlzIndra70DailyMainsVoltage),
                editText10 = (EditText) findViewById(R.id.editTextLlzIndra70DailyMainsFreq),
                editText11 = (EditText) findViewById(R.id.editTextLlzIndra70DailyTxOnAir),
                editText12 = (EditText) findViewById(R.id.editTextLlzIndra70DailyStatusMonStb),
                editText13 = (EditText) findViewById(R.id.editTextLlzIndra70DailyStatusFar),
                editText14 = (EditText) findViewById(R.id.editTextLlzIndra70DailyStatusBirdFFM),
                editText15 = (EditText) findViewById(R.id.editTextLlzIndra70DailyCLDDMMainMon1),
                editText16 = (EditText) findViewById(R.id.editTextLlzIndra70DailyCLDDMMainMon2),
                editText17 = (EditText) findViewById(R.id.editTextLlzIndra70DailyCLDDMStbMon),
                editText18 = (EditText) findViewById(R.id.editTextLlzIndra70DailyCLSDMMainMon1),
                editText19 = (EditText) findViewById(R.id.editTextLlzIndra70DailyCLSDMMainMon2),
                editText20 = (EditText) findViewById(R.id.editTextLlzIndra70DailyCLSDMStbMon),
                editText21 = (EditText) findViewById(R.id.editTextLlzIndra70DailyCLRFMainMon1),
                editText22 = (EditText) findViewById(R.id.editTextLlzIndra70DailyCLRFMainMon2),
                editText23 = (EditText) findViewById(R.id.editTextLlzIndra70DailyCLRFStbMon),
                editText24 = (EditText) findViewById(R.id.editTextLlzIndra70DailyDSDDMMainMon1),
                editText25 = (EditText) findViewById(R.id.editTextLlzIndra70DailyDSDDMMainMon2),
                editText26 = (EditText) findViewById(R.id.editTextLlzIndra70DailyDSDDMStbMon),
                editText27 = (EditText) findViewById(R.id.editTextLlzIndra70DailyDSSDMMainMon1),
                editText28 = (EditText) findViewById(R.id.editTextLlzIndra70DailyDSSDMMainMon2),
                editText29 = (EditText) findViewById(R.id.editTextLlzIndra70DailyDSSDMStbMon),
                editText30 = (EditText) findViewById(R.id.editTextLlzIndra70DailyDSRFMainMon1),
                editText31 = (EditText) findViewById(R.id.editTextLlzIndra70DailyDSRFMainMon2),
                editText32 = (EditText) findViewById(R.id.editTextLlzIndra70DailyDSRFStbMon),
                editText33 = (EditText) findViewById(R.id.editTextLlzIndra70DailyNFDDMMainMon1),
                editText34 = (EditText) findViewById(R.id.editTextLlzIndra70DailyNFDDMMainMon2),
                editText35 = (EditText) findViewById(R.id.editTextLlzIndra70DailyNFDDMStbMon),
                editText36 = (EditText) findViewById(R.id.editTextLlzIndra70DailyNFSDMMainMon1),
                editText37 = (EditText) findViewById(R.id.editTextLlzIndra70DailyNFSDMMainMon2),
                editText38 = (EditText) findViewById(R.id.editTextLlzIndra70DailyNFSDMStbMon),
                editText39 = (EditText) findViewById(R.id.editTextLlzIndra70DailyNFRFMainMon1),
                editText40 = (EditText) findViewById(R.id.editTextLlzIndra70DailyNFRFMainMon2),
                editText41 = (EditText) findViewById(R.id.editTextLlzIndra70DailyNFRFStbMon),
                editText42 = (EditText) findViewById(R.id.editTextLlzIndra70DailyCLRDDMMainMon1),
                editText43 = (EditText) findViewById(R.id.editTextLlzIndra70DailyCLRDDMMainMon2),
                editText44 = (EditText) findViewById(R.id.editTextLlzIndra70DailyCLRDDMStbMon),
                editText45 = (EditText) findViewById(R.id.editTextLlzIndra70DailyCLRSDMMainMon1),
                editText46 = (EditText) findViewById(R.id.editTextLlzIndra70DailyCLRSDMMainMon2),
                editText47 = (EditText) findViewById(R.id.editTextLlzIndra70DailyCLRSDMStbMon),
                editText48 = (EditText) findViewById(R.id.editTextLlzIndra70DailyCLRRFMainMon1),
                editText49 = (EditText) findViewById(R.id.editTextLlzIndra70DailyCLRRFMainMon2),
                editText50 = (EditText) findViewById(R.id.editTextLlzIndra70DailyCLRRFStbMon),
                editText51 = (EditText) findViewById(R.id.editTextLlzIndra70DailyFFMDDMMainMon1),
                editText52 = (EditText) findViewById(R.id.editTextLlzIndra70DailyFFMDDMMainMon2),
                editText53 = (EditText) findViewById(R.id.editTextLlzIndra70DailyFFMDDMStbMon),
                editText54 = (EditText) findViewById(R.id.editTextLlzIndra70DailyFFMSDMMainMon1),
                editText55 = (EditText) findViewById(R.id.editTextLlzIndra70DailyFFMSDMMainMon2),
                editText56 = (EditText) findViewById(R.id.editTextLlzIndra70DailyFFMSDMStbMon),
                editText57 = (EditText) findViewById(R.id.editTextLlzIndra70DailyFFMRFMainMon1),
                editText58 = (EditText) findViewById(R.id.editTextLlzIndra70DailyFFMRFMainMon2),
                editText59 = (EditText) findViewById(R.id.editTextLlzIndra70DailyFFMRFStbMon),
                editText60 = (EditText) findViewById(R.id.editTextLlzIndra70DailyDfMon1),
                editText61 = (EditText) findViewById(R.id.editTextLlzIndra70DailyDfMon2),
                editText62 = (EditText) findViewById(R.id.editTextLlzIndra70DailyDCLoop1),
                editText63 = (EditText) findViewById(R.id.editTextLlzIndra70DailyDCLoop2),
                editText64 = (EditText) findViewById(R.id.editTextLlzIndra70DailyDCLoop3),
                editText65 = (EditText) findViewById(R.id.editTextLlzIndra70DailyDCLoop4),
                editText66 = (EditText) findViewById(R.id.editTextLlzIndra70DailyTx1DDMWidth150),
                editText67 = (EditText) findViewById(R.id.editTextLlzIndra70DailyTx1SDMWidth150),
                editText68 = (EditText) findViewById(R.id.editTextLlzIndra70DailyTx1RFWidth150),
                editText69 = (EditText) findViewById(R.id.editTextLlzIndra70DailyTx2DDMWidth150),
                editText70 = (EditText) findViewById(R.id.editTextLlzIndra70DailyTx2SDMWidth150),
                editText71 = (EditText) findViewById(R.id.editTextLlzIndra70DailyTx2RFWidth150),
                editText72 = (EditText) findViewById(R.id.editTextLlzIndra70DailyTx1DDMCL),
                editText73 = (EditText) findViewById(R.id.editTextLlzIndra70DailyTx1SDMCL),
                editText74 = (EditText) findViewById(R.id.editTextLlzIndra70DailyTx1RFCL),
                editText75 = (EditText) findViewById(R.id.editTextLlzIndra70DailyTx2DDMCL),
                editText76 = (EditText) findViewById(R.id.editTextLlzIndra70DailyTx2SDMCL),
                editText77 = (EditText) findViewById(R.id.editTextLlzIndra70DailyTx2RFCL),
                editText78 = (EditText) findViewById(R.id.editTextLlzIndra70DailyTx1DDMWidth90),
                editText79 = (EditText) findViewById(R.id.editTextLlzIndra70DailyTx1SDMWidth90),
                editText80 = (EditText) findViewById(R.id.editTextLlzIndra70DailyTx1RFWidth90),
                editText81 = (EditText) findViewById(R.id.editTextLlzIndra70DailyTx2DDMWidth90),
                editText82 = (EditText) findViewById(R.id.editTextLlzIndra70DailyTx2SDMWidth90),
                editText83 = (EditText) findViewById(R.id.editTextLlzIndra70DailyTx2RFWidth90),
                editText84 = (EditText) findViewById(R.id.editTextLlzIndra70DailyBatt1),
                editText85 = (EditText) findViewById(R.id.editTextLlzIndra70DailyBatt2),
                editText86 = (EditText) findViewById(R.id.editTextLlzIndra70DailyRemarks)};

        //Define and Initialize all Switches serially here
        Switch  switch1,switch2,switch3,switch4,switch5,switch6,switch7,switch8,switch9,switch10,switch11,switch12,
                switch13,switch14,switch15,switch16,switch17,switch18,switch19,switch20,switch21,switch22,switch23,switch24,switch25;
        switchArray = new Switch[]{
                switch1 = (Switch) findViewById(R.id.switchLlzIndra70DailyRoomClean),
                switch2 = (Switch) findViewById(R.id.switchLlzIndra70DailyStatusAc),
                switch3 = (Switch) findViewById(R.id.switchLlzIndra70DailyStatusMast),
                switch4 = (Switch) findViewById(R.id.switchLlzIndra70DailyEquipHoldsOnUps),
                switch5 = (Switch) findViewById(R.id.switchLlzIndra70DailyStatusMonitorExe),
                switch6 = (Switch) findViewById(R.id.switchLlzIndra70DailyStatusNearField),
                switch7 = (Switch) findViewById(R.id.switchLlzIndra70DailyStatusBirdRad),
                switch8 = (Switch) findViewById(R.id.switchLlzIndra70DailyStatusBirdMon),
                switch9 = (Switch) findViewById(R.id.switchLlzIndra70DailyStatusCriticalArea),
                switch10 = (Switch) findViewById(R.id.switchLlzIndra70DailyRemoteStatusER),
                switch11 = (Switch) findViewById(R.id.switchLlzIndra70DailyRemoteStatusAtc),
                switch12 = (Switch) findViewById(R.id.switchLlzIndra70DailyParam),
                switch13 = (Switch) findViewById(R.id.switchLlzIndra70DailyDisagr),
                switch14= (Switch) findViewById(R.id.switchLlzIndra70DailyBatt),
                switch15 = (Switch) findViewById(R.id.switchLlzIndra70DailyIdent),
                switch16 = (Switch) findViewById(R.id.switchLlzIndra70DailyMaint),
                switch17 = (Switch) findViewById(R.id.switchLlzIndra70DailyStandby),
                switch18 = (Switch) findViewById(R.id.switchLlzIndra70DailyCourseTx1),
                switch19 = (Switch) findViewById(R.id.switchLlzIndra70DailyCourseTx2),
                switch20 = (Switch) findViewById(R.id.switchLlzIndra70DailyClearanceTx1),
                switch21 = (Switch) findViewById(R.id.switchLlzIndra70DailyClearanceTx2),
                switch22 = (Switch) findViewById(R.id.switchLlzIndra70DailyTxtoAirTx1),
                switch23 = (Switch) findViewById(R.id.switchLlzIndra70DailyTxtoAirTx2),
                switch24 = (Switch) findViewById(R.id.switchLlzIndra70DailyMainTx1),
                switch25 = (Switch) findViewById(R.id.switchLlzIndra70DailyMainTx2)};

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

        String outputSwitch = myFunctions.getSwitchStatusForPDF(switchArray);

        String[] switchDataForPDF = myFunctions.seperateSwitchData(outputSwitch);

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

        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.llzindra70daily1);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);

        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(12);

        int[] editTextXPixel = {124,595,100,193,314,472,585,585,585,585,585,585,585,585};
        int[] editTextYPixel = {165,165,198,198,198,198,370,395,432,465,547,597,647,705};

        int[] switchXPixel = {585,585,585,585,585,585,585,585,585,585,585};
        int[] switchYPixel = {288,310,336,516,578,631,673,687,745,775,795};


        // Change till here as per requirements ----------------------------------------------------

        //Fixed for all activity--------------------------------------------------------------------

        for(int i = 0; i < editTextXPixel.length; i++){
            canvas.drawText( editTextDataForPDF[i],editTextXPixel[i],editTextYPixel[i],titlePaint);
        }

        for(int i = 0; i < switchXPixel.length; i++){
            canvas.drawText( switchDataForPDF[i],switchXPixel[i],switchYPixel[i],titlePaint);
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

        canvas.drawText(strData,570,198,titlePaint);//Printing Date on PDF

        myPdfdocument.finishPage(myPage1);


        //---------------------End of Page 1---------------

        //----------------------Page 2---------------------

        PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(723, 1024, 2).create();

        // start a page
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);

        canvas = myPage2.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.llzindra70daily2);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel2 = {334,421,509,334,421,509,334,421,509,334,421,509,334,421,509,334,421,509,334,421,509,334,421,509,334,421,509,
                                334,421,509,334,421,509,334,421,509,334,421,509,334,421,509,334,421,509};
        int[] editTextYPixel2 = {222,222,222,282,282,282,313,313,313,344,344,344,376,376,376,407,407,407,450,450,450,505,505,505,535,535,535,
                                563,563,563,588,588,588,617,617,617,665,665,665,712,712,712,743,743,743};

        for(int i = 0; i < editTextXPixel2.length; i++){
            canvas.drawText( editTextDataForPDF[i+14],editTextXPixel2[i],editTextYPixel2[i],titlePaint);
        }

        myPdfdocument.finishPage(myPage2);

        //-------------------------End of Page 2-----------------

        //----------------------Page 3---------------------

        PdfDocument.PageInfo myPageInfo3 = new PdfDocument.PageInfo.Builder(723, 1024, 3).create();

        // start a page
        PdfDocument.Page myPage3 = myPdfdocument.startPage(myPageInfo3);

        canvas = myPage3.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.llzindra70daily3);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel3 = {357,570,255,358,453,570,162,250,340,415,504,585,162,250,340,415,504,585,162,250,340,415,504,585};
        int[] editTextYPixel3 = {190,190,320,320,320,320,547,547,547,547,547,547,584,584,584,584,584,584,618,618,618,618,618,618};

        int[] switchXPixel3 = {390,390};
        int[] switchYPixel3 = {780,830};


        for(int i = 0; i < editTextXPixel3.length; i++){
            canvas.drawText( editTextDataForPDF[i+59],editTextXPixel3[i],editTextYPixel3[i],titlePaint);
        }


        for(int i = 0; i < switchXPixel3.length; i++){
            canvas.drawText( switchDataForPDF[i+11],switchXPixel3[i],switchYPixel3[i],titlePaint);
        }

        myPdfdocument.finishPage(myPage3);

        //-------------------------End of Page 3-----------------

        //----------------------Page 4---------------------

        PdfDocument.PageInfo myPageInfo4 = new PdfDocument.PageInfo.Builder(723, 1024, 4).create();

        // start a page
        PdfDocument.Page myPage4 = myPdfdocument.startPage(myPageInfo4);

        canvas = myPage4.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.llzindra70daily4);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(12);

        int[] editTextXPixel4 = {465,465};
        int[] editTextYPixel4 = {689,736};

        int[] switchXPixel4 = {390,390,390,390,380,490,380,490,380,490,380,490};
        int[] switchYPixel4 = {120,172,222,273,438,438,490,490,543,543,590,590};


        for(int i = 0; i < editTextXPixel4.length; i++){
            canvas.drawText( editTextDataForPDF[i+83],editTextXPixel4[i],editTextYPixel4[i],titlePaint);
        }

        for(int i = 0; i < switchXPixel4.length; i++){
            canvas.drawText( switchDataForPDF[i+13],switchXPixel4[i],switchYPixel4[i],titlePaint);
        }

        myPdfdocument.finishPage(myPage4);

        //-------------------------End of Page 4-----------------

        //----------------------Page 5---------------------

        PdfDocument.PageInfo myPageInfo5 = new PdfDocument.PageInfo.Builder(723, 1024, 5).create();

        // start a page
        PdfDocument.Page myPage5 = myPdfdocument.startPage(myPageInfo5);

        canvas = myPage5.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.llzindra70daily5);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(12);

        canvas.drawText( editTextDataForPDF[85],70,125,titlePaint);

        titlePaint.setTextSize(12);
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 70, 190, paint);


        myPdfdocument.finishPage(myPage5);

        //-------------------------End of Page 5-----------------



        ActivityCompat.requestPermissions(this, new String[]{

                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Navigation/LLZIndra70/Daily/";// Change Here------------------
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //String targetPdf = directory_path + "test.pdf";
        //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
        String fileName = "Daily LLZ Indra70 " + strData + ".pdf"; // Change Here--------------------------
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
        myFunctions.saveToParse(targetPdf, fileName,"ILS","Daily",outputEditText,MyFunctions.specificCode("d"),outputSwitch, "outputSpinner");// Change Here-----------------------

        // This function will send eMail using JavaMailAPI
        //myFunctions.sendEmail(String To, String Subject, String Message,String targetPdf,String desired_Filename)
        myFunctions.sendEmail(PersonalDetailsActivity.emailTo + "@aai.aero",
                "Daily Maintenance of Indra70 LLZ done.",//Change Here-----------------------------
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