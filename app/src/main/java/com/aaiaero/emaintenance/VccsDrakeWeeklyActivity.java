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

public class VccsDrakeWeeklyActivity extends AppCompatActivity {

    private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
    private MySignature mySignature = new MySignature(this);
    private int selectedID;//Copy
    private String selectedName;//Copy
    private EditText[] editTextArray;//Copy
    private Switch[] switchArray={};//Copy
    private Spinner[] spinnerArray={};//Copy
    private String thisActivityName = "VccsDrakeWeeklyActivity"; //Change Here as per your class name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vccs_drake_weekly);

        //Define and Initialize all EditTexts serially here
        EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8,editText9, editText10, editText11, editText12, editText13, editText14, editText15, editText16, editText17, editText18, editText19, editText20,
                editText21, editText22, editText23, editText24,editText25, editText26, editText27, editText28, editText29, editText30, editText31, editText32, editText33, editText34, editText35, editText36, editText37, editText38, editText39, editText40,
                editText41, editText42, editText43, editText44, editText45, editText46, editText47, editText48, editText49, editText50, editText51, editText52, editText53, editText54, editText55, editText56, editText57, editText58,editText59, editText60,
                editText61, editText62,editText63, editText64, editText65, editText66, editText67, editText68,editText69, editText70, editText71, editText72, editText73, editText74, editText75, editText76, editText77, editText78, editText79, editText80,
                editText81, editText82, editText83, editText84, editText85, editText86, editText87, editText88,editText89,editText90, editText91, editText92, editText93, editText94,editText95, editText96, editText97, editText98,editText99, editText100,
                editText101, editText102, editText103, editText104, editText105, editText106, editText107, editText108, editText109, editText110, editText111, editText112, editText113, editText114, editText115, editText116, editText117, editText118, editText119;

        editTextArray = new EditText[]{
                editText1 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklyStation),
                editText2 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklyRegion),
                editText3 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysADMC01D5),
                editText4 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBDMC01D5),
                editText5 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysADMC01D4),
                editText6 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBDMC01D4),
                editText7 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysADMC01D3),
                editText8 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBDMC01D3),
                editText9 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysADMC01D2),
                editText10 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBDMC01D2),
                editText11 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysADMC02D5),
                editText12 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBDMC02D5),
                editText13 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysADMC02D4),
                editText14 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBDMC02D4),
                editText15 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysADMC02D3),
                editText16 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBDMC02D3),
                editText17 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysADMC02D2),
                editText18 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBDMC02D2),
                editText19 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysAMPC1D1),
                editText20 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBMPC1D1),
                editText21 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysAMPC1D2),
                editText22 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBMPC1D2),
                editText23 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysAMPC1D3),
                editText24 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBMPC1D3),
                editText25 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysAMPC1D4),
                editText26 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBMPC1D4),
                editText27 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysAMPC2D1),
                editText28 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBMPC2D1),
                editText29 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysAMPC2D2),
                editText30 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBMPC2D2),
                editText31 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysAMPC2D3),
                editText32 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBMPC2D3),
                editText33 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysAMPC2D4),
                editText34 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBMPC2D4),
                editText35 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysACOD15),
                editText36 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBCOD15),
                editText37 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysACOD15V),
                editText38 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBCOD15V),
                editText39 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysACOD1),
                editText40 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBCOD1),
                editText41 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysACOD25),
                editText42 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBCOD25),
                editText43 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysACOD25V),
                editText44 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBCOD25V),
                editText45 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysACOD2),
                editText46 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBCOD2),
                editText47 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysACOD35),
                editText48 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBCOD35),
                editText49 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysACOD35V),
                editText50 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBCOD35V),
                editText51 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysACOD3),
                editText52 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBCOD3),
                editText53 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysAHI1D15),
                editText54 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBHI1D15),
                editText55 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysAHI1D16),
                editText56 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBHI1D16),
                editText57 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysAHI1D14),
                editText58 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBHI1D14),
                editText59 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysAHI1D7),
                editText60 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBHI1D7),
                editText61 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysAHI1D9),
                editText62 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBHI1D9),
                editText63 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysAHI1D11),
                editText64 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBHI1D11),
                editText65 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysAHI1D10),
                editText66 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBHI1D10),
                editText67 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysAHI2D15),
                editText68 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBHI2D15),
                editText69 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysAHI2D16),
                editText70 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBHI2D16),
                editText71 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysAHI2D14),
                editText72 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBHI2D14),
                editText73 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysAHI2D7),
                editText74 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBHI2D7),
                editText75 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysAHI2D9),
                editText76 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBHI2D9),
                editText77 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysAHI2D11),
                editText78 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBHI2D11),
                editText79 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysAHI2D10),
                editText80 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBHI2D10),
                editText81 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysAHI3D15),
                editText82 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBHI3D15),
                editText83 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysAHI3D16),
                editText84 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBHI3D16),
                editText85 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysAHI3D14),
                editText86 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBHI3D14),
                editText87 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysAHI3D7),
                editText88 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBHI3D7),
                editText89 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysAHI3D9),
                editText90 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBHI3D9),
                editText91 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysAHI3D11),
                editText92 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBHI3D11),
                editText93 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysAHI3D10),
                editText94 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBHI3D10),
                editText95 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysARadioPS),
                editText96 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBRadioPS),
                editText97 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysARadioA),
                editText98 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBRadioA),
                editText99 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysARadioB),
                editText100 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBRadioB),
                editText101 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysAPBXPS),
                editText102 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBPBXPS),
                editText103 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysAPBXA),
                editText104 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBPBXA),
                editText105 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysAPBXB),
                editText106 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBPBXB),
                editText107 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysAASUPS),
                editText108 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBASUPS),
                editText109 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysAASUA),
                editText110 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBASUA),
                editText111 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysAASUB),
                editText112 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBASUB),
                editText113 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysAPDU1),
                editText114 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBPDU1),
                editText115 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysAPDU2),
                editText116 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBPDU2),
                editText117 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysAFan),
                editText118 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklySysBFan),
                editText119 = (EditText) findViewById(R.id.editTextVccsDrakeWeeklyRemarks)};

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

        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.vccsdrakeweekly1);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);

        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(12);

        int[] editTextXPixel = {190,585,480,585,480,585,480,585,480,585,480,585,480,585,480,585,480,585};
        int[] editTextYPixel = {230,230,353,353,371,371,430,430,525,525,600,600,633,633,690,690,795,795};




        // Change till here as per requirements ----------------------------------------------------

        //Fixed for all activity--------------------------------------------------------------------

        for(int i = 0; i < editTextXPixel.length; i++){
            canvas.drawText( editTextDataForPDF[i],editTextXPixel[i],editTextYPixel[i],titlePaint);
        }


        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
        String strData = sdf.format(calendar.getTime());
        // Fixed till here--------------------------------------------------------------------------

        // Change as per your requirement-----------------------------------------------------------
        titlePaint.setTextSize(12);

        canvas.drawText(strData,573,250,titlePaint);//Printing Date on PDF

        myPdfdocument.finishPage(myPage1);


        //---------------------End of Page 1---------------

        //----------------------Page 2---------------------

        PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(723, 1024, 2).create();

        // start a page
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);

        canvas = myPage2.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.vccsdrakeweekly2);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel2 = {475,583,475,583,475,583,475,583,475,583,475,583,475,583,475,583,475,583,475,583,475,583,475,583,475,583,475,583,475,583,475,583,475,583};
        int[] editTextYPixel2 = {148,148,185,185,220,220,256,256,312,312,347,347,381,381,414,414,453,453,488,488,527,527,618,618,651,651,690,690,741,741,777,777,820,820};

        for(int i = 0; i < editTextXPixel2.length; i++){
            canvas.drawText( editTextDataForPDF[i+18],editTextXPixel2[i],editTextYPixel2[i],titlePaint);
        }

        myPdfdocument.finishPage(myPage2);

        //-------------------------End of Page 2-----------------
        //----------------------Page 3---------------------

        PdfDocument.PageInfo myPageInfo3 = new PdfDocument.PageInfo.Builder(723, 1024, 3).create();

        // start a page
        PdfDocument.Page myPage3 = myPdfdocument.startPage(myPageInfo3);

        canvas = myPage3.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.vccsdrakeweekly3);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel3 = {475,575,475,575,475,575,475,575,475,575,475,575,475,575,475,575,475,575,475,575,475,575,475,575,475,575,475,575,475,575,475,575,475,575,
                475,575,475,575,475,575};
        int[] editTextYPixel3 = {137,137,172,172,208,208,244,244,280,280,316,316,352,352,407,407,442,442,477,477,513,513,548,548,583,583,621,621,675,675,711,711,746,746,
                781,781,817,817,853,853};

        for(int i = 0; i < editTextXPixel3.length; i++){
            canvas.drawText( editTextDataForPDF[i+52],editTextXPixel3[i],editTextYPixel3[i],titlePaint);
        }

        myPdfdocument.finishPage(myPage3);

        //-------------------------End of Page 3-----------------
        //----------------------Page 4---------------------

        PdfDocument.PageInfo myPageInfo4 = new PdfDocument.PageInfo.Builder(723, 1024, 4).create();

        // start a page
        PdfDocument.Page myPage4 = myPdfdocument.startPage(myPageInfo4);
        canvas = myPage4.getCanvas();

        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.vccsdrakeweekly4);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);



        titlePaint.setTextSize(12);

        int[] editTextXPixel4 = {475,580,475,580,475,580,475,580,475,580,475,580,475,580,475,580,475,580,475,580,475,580,475,580,475,580,143};
        int[] editTextYPixel4 = {143,143,178,178,204,204,235,235,265,265,295,295,325,325,368,368,397,397,448,448,535,535,613,613,661,661,713};

        for(int i = 0; i < editTextXPixel4.length; i++){
            canvas.drawText( editTextDataForPDF[i+92],editTextXPixel4[i],editTextYPixel4[i],titlePaint);
        }

        titlePaint.setTextSize(12);
        //canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.photo,210,270, false), 50, 350, paint);
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 80, 753, paint);

        myPdfdocument.finishPage(myPage4);

        //-------------------------End of Page 4-----------------



        ActivityCompat.requestPermissions(this, new String[]{

                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Communication/Vccs/Drake/Weekly/";// Change Here------------------
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //String targetPdf = directory_path + "test.pdf";
        //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
        String fileName = "Weekly VCCS Drake " + strData + ".pdf"; // Change Here--------------------------
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
        myFunctions.saveToParse(targetPdf, fileName,"VCCS","Weekly",outputEditText,MyFunctions.specificCode("w"),"outputSwitch", "outputSpinner");// Change Here-----------------------

        // This function will send eMail using JavaMailAPI
        //myFunctions.sendEmail(String To, String Subject, String Message,String targetPdf,String desired_Filename)
        myFunctions.sendEmail(PersonalDetailsActivity.emailTo + "@aai.aero",
                "Weekly Maintenance of VCCS Drake done.",//Change Here-----------------------------
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