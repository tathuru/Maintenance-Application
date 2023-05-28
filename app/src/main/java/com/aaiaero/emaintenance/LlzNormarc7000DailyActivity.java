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
import android.widget.ImageView;
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

public class LlzNormarc7000DailyActivity extends AppCompatActivity {

    private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
    private MySignature mySignature = new MySignature(this);
    private int selectedID;//Copy
    private String selectedName;//Copy
    private EditText[] editTextArray;//Copy
    private Switch[] switchArray = {};//Copy
    private Spinner[] spinnerArray = {};//Copy
    private String thisActivityName = "LlzNormarc7000DailyActivity"; //Change Here as per your class name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llz_normarc7000_daily);

        //Define and Initialize all EditTexts serially here
        EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8,editText9, editText10, editText11, editText12, editText13, editText14, editText15, editText16,
                editText17, editText18, editText19, editText20, editText21, editText22, editText23, editText24,editText25, editText26, editText27, editText28, editText29, editText30, editText31, editText32,
                editText33, editText34, editText35, editText36, editText37, editText38, editText39, editText40, editText41, editText42, editText43, editText44, editText45, editText46, editText47, editText48,
                editText49, editText50, editText51, editText52, editText53, editText54, editText55, editText56, editText57, editText58,editText59, editText60,editText61, editText62,editText63, editText64,
                editText65, editText66, editText67, editText68,editText69, editText70, editText71, editText72, editText73, editText74, editText75, editText76, editText77, editText78, editText79, editText80,
                editText81, editText82, editText83, editText84, editText85, editText86, editText87, editText88,editText89,editText90, editText91, editText92, editText93, editText94, editText95, editText96, editText97, editText98;

        editTextArray = new EditText[]{
                editText1 = (EditText) findViewById(R.id.editTextLlzNormarcDailyStation),
                editText2 = (EditText) findViewById(R.id.editTextLlzNormarcDailyModel),
                editText3 = (EditText) findViewById(R.id.editTextLlzNormarcDailyRWY),
                editText4 = (EditText) findViewById(R.id.editTextLlzNormarcDailyCat),
                editText5 = (EditText) findViewById(R.id.editTextLlzNormarcDailyFrequency),
                editText6 = (EditText) findViewById(R.id.editTextLlzNormarcDailyIdent),
                editText7 = (EditText) findViewById(R.id.editTextLlzNormarcDailyRoomTemp),
                editText8 = (EditText) findViewById(R.id.editTextLlzNormarcDailyHumidity),
                editText9 = (EditText) findViewById(R.id.editTextLlzNormarcDailyMainsVoltage),
                editText10 = (EditText) findViewById(R.id.editTextLlzNormarcDailyMainsFreq),
                editText11 = (EditText) findViewById(R.id.editTextLlzNormarcDailyTxOnAir),
                editText12 = (EditText) findViewById(R.id.editTextLlzNormarcDailyCLDDMMainMon1),
                editText13 = (EditText) findViewById(R.id.editTextLlzNormarcDailyCLDDMMainMon2),
                editText14 = (EditText) findViewById(R.id.editTextLlzNormarcDailyCLDDMStbMon1),
                editText15 = (EditText) findViewById(R.id.editTextLlzNormarcDailyCLDDMStbMon2),
                editText16 = (EditText) findViewById(R.id.editTextLlzNormarcDailyCLSDMMainMon1),
                editText17 = (EditText) findViewById(R.id.editTextLlzNormarcDailyCLSDMMainMon2),
                editText18 = (EditText) findViewById(R.id.editTextLlzNormarcDailyCLSDMStbMon1),
                editText19 = (EditText) findViewById(R.id.editTextLlzNormarcDailyCLSDMStbMon2),
                editText20 = (EditText) findViewById(R.id.editTextLlzNormarcDailyCLRFMainMon1),
                editText21 = (EditText) findViewById(R.id.editTextLlzNormarcDailyCLRFMainMon2),
                editText22 = (EditText) findViewById(R.id.editTextLlzNormarcDailyCLRFStbMon1),
                editText23 = (EditText) findViewById(R.id.editTextLlzNormarcDailyCLRFStbMon2),
                editText24 = (EditText) findViewById(R.id.editTextLlzNormarcDailyDSDDMMainMon1),
                editText25 = (EditText) findViewById(R.id.editTextLlzNormarcDailyDSDDMMainMon2),
                editText26 = (EditText) findViewById(R.id.editTextLlzNormarcDailyDSDDMStbMon1),
                editText27 = (EditText) findViewById(R.id.editTextLlzNormarcDailyDSDDMStbMon2),
                editText28 = (EditText) findViewById(R.id.editTextLlzNormarcDailyDSSDMMainMon1),
                editText29 = (EditText) findViewById(R.id.editTextLlzNormarcDailyDSSDMMainMon2),
                editText30 = (EditText) findViewById(R.id.editTextLlzNormarcDailyDSSDMStbMon1),
                editText31 = (EditText) findViewById(R.id.editTextLlzNormarcDailyDSSDMStbMon2),
                editText32 = (EditText) findViewById(R.id.editTextLlzNormarcDailyDSRFMainMon1),
                editText33 = (EditText) findViewById(R.id.editTextLlzNormarcDailyDSRFMainMon2),
                editText34 = (EditText) findViewById(R.id.editTextLlzNormarcDailyDSRFStbMon1),
                editText35 = (EditText) findViewById(R.id.editTextLlzNormarcDailyDSRFStbMon2),
                editText36 = (EditText) findViewById(R.id.editTextLlzNormarcDailyNFDDMMainMon1),
                editText37 = (EditText) findViewById(R.id.editTextLlzNormarcDailyNFDDMMainMon2),
                editText38 = (EditText) findViewById(R.id.editTextLlzNormarcDailyNFDDMStbMon1),
                editText39 = (EditText) findViewById(R.id.editTextLlzNormarcDailyNFDDMStbMon2),
                editText40 = (EditText) findViewById(R.id.editTextLlzNormarcDailyNFSDMMainMon1),
                editText41 = (EditText) findViewById(R.id.editTextLlzNormarcDailyNFSDMMainMon2),
                editText42 = (EditText) findViewById(R.id.editTextLlzNormarcDailyNFSDMStbMon1),
                editText43 = (EditText) findViewById(R.id.editTextLlzNormarcDailyNFSDMStbMon2),
                editText44 = (EditText) findViewById(R.id.editTextLlzNormarcDailyNFRFMainMon1),
                editText45 = (EditText) findViewById(R.id.editTextLlzNormarcDailyNFRFMainMon2),
                editText46 = (EditText) findViewById(R.id.editTextLlzNormarcDailyNFRFStbMon1),
                editText47 = (EditText) findViewById(R.id.editTextLlzNormarcDailyNFRFStbMon2),
                editText48 = (EditText) findViewById(R.id.editTextLlzNormarcDailyCLRDDMMainMon1),
                editText49 = (EditText) findViewById(R.id.editTextLlzNormarcDailyCLRDDMMainMon2),
                editText50 = (EditText) findViewById(R.id.editTextLlzNormarcDailyCLRDDMStbMon1),
                editText51 = (EditText) findViewById(R.id.editTextLlzNormarcDailyCLRDDMStbMon2),
                editText52 = (EditText) findViewById(R.id.editTextLlzNormarcDailyCLRSDMMainMon1),
                editText53 = (EditText) findViewById(R.id.editTextLlzNormarcDailyCLRSDMMainMon2),
                editText54 = (EditText) findViewById(R.id.editTextLlzNormarcDailyCLRSDMStbMon1),
                editText55 = (EditText) findViewById(R.id.editTextLlzNormarcDailyCLRSDMStbMon2),
                editText56 = (EditText) findViewById(R.id.editTextLlzNormarcDailyCLRRFMainMon1),
                editText57 = (EditText) findViewById(R.id.editTextLlzNormarcDailyCLRRFMainMon2),
                editText58 = (EditText) findViewById(R.id.editTextLlzNormarcDailyCLRRFStbMon1),
                editText59 = (EditText) findViewById(R.id.editTextLlzNormarcDailyCLRRFStbMon2),
                editText60 = (EditText) findViewById(R.id.editTextLlzNormarcDailyFFMDDMMainMon1),
                editText61 = (EditText) findViewById(R.id.editTextLlzNormarcDailyFFMDDMMainMon2),
                editText62 = (EditText) findViewById(R.id.editTextLlzNormarcDailyFFMDDMStbMon1),
                editText63 = (EditText) findViewById(R.id.editTextLlzNormarcDailyFFMDDMStbMon2),
                editText64 = (EditText) findViewById(R.id.editTextLlzNormarcDailyFFMSDMMainMon1),
                editText65 = (EditText) findViewById(R.id.editTextLlzNormarcDailyFFMSDMMainMon2),
                editText66 = (EditText) findViewById(R.id.editTextLlzNormarcDailyFFMSDMStbMon1),
                editText67 = (EditText) findViewById(R.id.editTextLlzNormarcDailyFFMSDMStbMon2),
                editText68 = (EditText) findViewById(R.id.editTextLlzNormarcDailyFFMRFMainMon1),
                editText69 = (EditText) findViewById(R.id.editTextLlzNormarcDailyFFMRFMainMon2),
                editText70 = (EditText) findViewById(R.id.editTextLlzNormarcDailyFFMRFStbMon1),
                editText71 = (EditText) findViewById(R.id.editTextLlzNormarcDailyFFMRFStbMon2),
                editText72 = (EditText) findViewById(R.id.editTextLlzNormarcDailyDfMon1),
                editText73 = (EditText) findViewById(R.id.editTextLlzNormarcDailyDfMon2),
                editText74 = (EditText) findViewById(R.id.editTextLlzNormarcDailyDCLoop1),
                editText75 = (EditText) findViewById(R.id.editTextLlzNormarcDailyDCLoop2),
                editText76 = (EditText) findViewById(R.id.editTextLlzNormarcDailyDCLoop3),
                editText77 = (EditText) findViewById(R.id.editTextLlzNormarcDailyDCLoop4),
                editText78 = (EditText) findViewById(R.id.editTextLlzNormarcDailyAzimuthTx1DDMCL),
                editText79 = (EditText) findViewById(R.id.editTextLlzNormarcDailyAzimuthTx1SDMCL),
                editText80 = (EditText) findViewById(R.id.editTextLlzNormarcDailyAzimuthTx1RFCL),
                editText81 = (EditText) findViewById(R.id.editTextLlzNormarcDailyAzimuthTx2DDMCL),
                editText82 = (EditText) findViewById(R.id.editTextLlzNormarcDailyAzimuthTx2SDMCL),
                editText83 = (EditText) findViewById(R.id.editTextLlzNormarcDailyAzimuthTx2RFCL),
                editText84 = (EditText) findViewById(R.id.editTextLlzNormarcDailyAzimuthTx1DDMWidth90),
                editText85 = (EditText) findViewById(R.id.editTextLlzNormarcDailyAzimuthTx1SDMWidth90),
                editText86 = (EditText) findViewById(R.id.editTextLlzNormarcDailyAzimuthTx1RFWidth90),
                editText87 = (EditText) findViewById(R.id.editTextLlzNormarcDailyAzimuthTx2DDMWidth90),
                editText88 = (EditText) findViewById(R.id.editTextLlzNormarcDailyAzimuthTx2SDMWidth90),
                editText89 = (EditText) findViewById(R.id.editTextLlzNormarcDailyAzimuthTx2RFWidth90),
                editText90 = (EditText) findViewById(R.id.editTextLlzNormarcDailyAzimuthTx1DDMWidth150),
                editText91 = (EditText) findViewById(R.id.editTextLlzNormarcDailyAzimuthTx1SDMWidth150),
                editText92 = (EditText) findViewById(R.id.editTextLlzNormarcDailyAzimuthTx1RFWidth150),
                editText93 = (EditText) findViewById(R.id.editTextLlzNormarcDailyAzimuthTx2DDMWidth150),
                editText94 = (EditText) findViewById(R.id.editTextLlzNormarcDailyAzimuthTx2SDMWidth150),
                editText95 = (EditText) findViewById(R.id.editTextLlzNormarcDailyAzimuthTx2RFWidth150),
                editText96 = (EditText) findViewById(R.id.editTextLlzNormarcDailySMPSPS1),
                editText97 = (EditText) findViewById(R.id.editTextLlzNormarcDailySMPSPS2),
                editText98 = (EditText) findViewById(R.id.editTextLlzNormarcDailyRemarks)};

        //Define and Initialize all Switches serially here
        Switch  switch1,switch2,switch3,switch4,switch5,switch6,switch7,switch8,switch9,switch10,switch11,switch12,
                switch13,switch14,switch15,switch16,switch17,switch18,switch19,switch20,switch21,switch22,switch23,switch24,switch25;
        switchArray = new Switch[]{
                switch1 = (Switch) findViewById(R.id.switchLlzNormarcDailyRoomClean),
                switch2 = (Switch) findViewById(R.id.switchLlzNormarcDailyStatusAc),
                switch3 = (Switch) findViewById(R.id.switchLlzNormarcDailyStatusMast),
                switch4 = (Switch) findViewById(R.id.switchLlzNormarcDailyEquipmentHoldsOnUps),
                switch5 = (Switch) findViewById(R.id.switchLlzNormarcDailyStatusMonitorExe),
                switch6 = (Switch) findViewById(R.id.switchLlzNormarcDailyStatusMonitorStandby),
                switch7 = (Switch) findViewById(R.id.switchLlzNormarcDailyStatusNearField),
                switch8 = (Switch) findViewById(R.id.switchLlzNormarcDailyStatusBirdSpike),
                switch9 = (Switch) findViewById(R.id.switchLlzNormarcDailyStatusCriticalArea),
                switch10 = (Switch) findViewById(R.id.switchLlzNormarcDailyRemoteStatusER),
                switch11 = (Switch) findViewById(R.id.switchLlzNormarcDailyRemoteStatusAtc),
                switch12 = (Switch) findViewById(R.id.switchLlzNormarcDailyParam),
                switch13 = (Switch) findViewById(R.id.switchLlzNormarcDailyDisagr),
                switch14= (Switch) findViewById(R.id.switchLlzNormarcDailyBatt),
                switch15 = (Switch) findViewById(R.id.switchLlzNormarcDailyIdent),
                switch16 = (Switch) findViewById(R.id.switchLlzNormarcDailyMaint),
                switch17 = (Switch) findViewById(R.id.switchLlzNormarcDailyStandby),
                switch18 = (Switch) findViewById(R.id.switchLlzNormarcDailyCourseTx1),
                switch19 = (Switch) findViewById(R.id.switchLlzNormarcDailyCourseTx2),
                switch20 = (Switch) findViewById(R.id.switchLlzNormarcDailyClearanceTx1),
                switch21 = (Switch) findViewById(R.id.switchLlzNormarcDailyClearanceTx2),
                switch22 = (Switch) findViewById(R.id.switchLlzNormarcDailyTxtoAirTx1),
                switch23 = (Switch) findViewById(R.id.switchLlzNormarcDailyTxtoAirTx2),
                switch24 = (Switch) findViewById(R.id.switchLlzNormarcDailyMainTx1),
                switch25 = (Switch) findViewById(R.id.switchLlzNormarcDailyMainTx2)};

        //Define and Initialize all Spinners serially here

        // Fixed for all the activity---------------------------------------------------------------
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

        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.llznormarcdaily1);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);

        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(12);

        int[] editTextXPixel = {106,605,77,204,350,510,530,530,530,530,530,305,385,465,545,305,385,465,545,305,385,465,545,305,385,465,545,305,385,465,545,305,385,465,545};
        int[] editTextYPixel = {132,132,153,153,153,153,272,291,319,355,415,670,670,670,670,733,733,733,733,756,756,756,756,787,787,787,787,823,823,823,823,846,846,846,846};

        int[] switchXPixel = {530,530,530,530,530,530,530,530,530,530,530};
        int[] switchYPixel = {212,237,252,389,436,452,484,512,540,565,578};


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

        canvas.drawText(strData,599,153,titlePaint);//Printing Date on PDF

        myPdfdocument.finishPage(myPage1);


        //---------------------End of Page 1---------------

        //----------------------Page 2---------------------

        PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(723, 1024, 2).create();

        // start a page
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);

        canvas = myPage2.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.llznormarcdaily2);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel2 = {300,375,445,535,300,375,445,535,300,375,445,535,300,375,445,535,300,375,445,535,300,375,445,535,300,375,445,535,300,375,445,535,300,375,445,535
                ,320,520,235,320,417,520,125,205,286,358,440,520,125,205,286,358,440,520};
        int[] editTextYPixel2 = {125,125,125,125,182,182,182,182,208,208,208,208,234,234,234,234,255,255,255,255,280,280,280,280,325,325,325,325,385,385,385,385,406,406,406,406
                ,525,525,605,605,605,605,845,845,845,845,845,845,878,878,878,878,878,878};

        for(int i = 0; i < editTextXPixel2.length; i++){
            canvas.drawText( editTextDataForPDF[i+35],editTextXPixel2[i],editTextYPixel2[i],titlePaint);
        }

        myPdfdocument.finishPage(myPage2);

        //-------------------------End of Page 2-----------------
        //----------------------Page 3---------------------

        PdfDocument.PageInfo myPageInfo3 = new PdfDocument.PageInfo.Builder(723, 1024, 3).create();

        // start a page
        PdfDocument.Page myPage3 = myPdfdocument.startPage(myPageInfo3);

        canvas = myPage3.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.llznormarcdaily3);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel3 = {121,202,285,355,437,511,455,566};
        int[] editTextYPixel3 = {108,108,108,108,108,108,855,855};

        int[] switchXPixel3 = {340,340,340,340,340,340,330,425,330,425,330,425,330,425};
        int[] switchYPixel3 = {223,270,315,360,405,452,630,630,675,675,725,725,765,765};


        for(int i = 0; i < editTextXPixel3.length; i++){
            canvas.drawText( editTextDataForPDF[i+89],editTextXPixel3[i],editTextYPixel3[i],titlePaint);
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
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.llznormarcdaily4);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);



        titlePaint.setTextSize(12);
        paint.setTextAlign(Paint.Align.LEFT);

        titlePaint.setTextSize(12);
        //canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.photo,210,270, false), 50, 350, paint);

        canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 400, 350, paint);
        titlePaint.setTextSize(12);

        canvas.drawText( editTextDataForPDF[97],60,108,titlePaint);

        myPdfdocument.finishPage(myPage4);

        //-------------------------End of Page 4-----------------



        ActivityCompat.requestPermissions(this, new String[]{

                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Navigation/LLZNormarc/Daily/";// Change Here------------------
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //String targetPdf = directory_path + "test.pdf";
        //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
        String fileName = "Daily LLZ Normarc " + strData + ".pdf"; // Change Here--------------------------
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
                "Daily Maintenance of Normarc LLZ done.",//Change Here-----------------------------
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