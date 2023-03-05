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

public class LlzAsiiDailyActivity extends AppCompatActivity {

    private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
    private MySignature mySignature = new MySignature(this);
    private int selectedID;//Copy
    private String selectedName;//Copy
    private EditText[] editTextArray;//Copy
    private Switch[] switchArray;//Copy
    private Spinner[] spinnerArray={};//Copy
    private String thisActivityName = "LlzAsiiDailyActivity"; //Change Here as per your class name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llz_asii_daily);

        //Define and Initialize all EditTexts serially here
        EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8,editText9, editText10, editText11, editText12, editText13, editText14, editText15, editText16, editText17, editText18,
                editText19, editText20, editText21, editText22, editText23, editText24,editText25, editText26, editText27, editText28, editText29, editText30, editText31, editText32, editText33, editText34, editText35,
                editText36, editText37, editText38, editText39, editText40, editText41, editText42, editText43, editText44, editText45, editText46, editText47, editText48, editText49, editText50, editText51, editText52,
                editText53, editText54, editText55, editText56, editText57, editText58,editText59, editText60,editText61, editText62,editText63, editText64, editText65, editText66, editText67, editText68,editText69,
                editText70, editText71, editText72, editText73, editText74, editText75, editText76, editText77, editText78, editText79, editText80, editText81, editText82, editText83, editText84, editText85, editText86, editText87, editText88,editText89,editText90,
                editText91, editText92, editText93, editText94,editText95, editText96, editText97, editText98,editText99;

        editTextArray = new EditText[]{
                editText1 = (EditText) findViewById(R.id.editTextLlzAsiiDailyStation),
                editText2 = (EditText) findViewById(R.id.editTextLlzAsiiDailyChOnAir),
                editText3 = (EditText) findViewById(R.id.editTextLlzAsiiDailyCat),
                editText4 = (EditText) findViewById(R.id.editTextLlzAsiiDailyFrequency),
                editText5 = (EditText) findViewById(R.id.editTextLlzAsiiDailyRoomTemp),
                editText6 = (EditText) findViewById(R.id.editTextLlzAsiiDailyMainsVoltage),
                editText7 = (EditText) findViewById(R.id.editTextLlzAsiiDailyMainsFreq),
                editText8 = (EditText) findViewById(R.id.editTextLlzAsiiDailyUpsOp),
                editText9 = (EditText) findViewById(R.id.editTextLlzAsiiDailyTxOnAir),
                editText10 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNom1CRSPOSDDM),
                editText11 = (EditText) findViewById(R.id.editTextLlzAsiiDailyMon1CRSPOSDDM),
                editText12 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNom2CRSPOSDDM),
                editText13 = (EditText) findViewById(R.id.editTextLlzAsiiDailyMon2CRSPOSDDM),
                editText14 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNom1CRSWidthDDM),
                editText15 = (EditText) findViewById(R.id.editTextLlzAsiiDailyMon1CRSWidthDDM),
                editText16 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNom2CRSWidthDDM),
                editText17 = (EditText) findViewById(R.id.editTextLlzAsiiDailyMon2CRSWidthDDM),
                editText18 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNom1CLRPOSDDM),
                editText19 = (EditText) findViewById(R.id.editTextLlzAsiiDailyMon1CLRPOSDDM),
                editText20 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNom2CLRPOSDDM),
                editText21 = (EditText) findViewById(R.id.editTextLlzAsiiDailyMon2CLRPOSDDM),
                editText22 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNom1CLRWidthDDM),
                editText23 = (EditText) findViewById(R.id.editTextLlzAsiiDailyMon1CLRWidthDDM),
                editText24 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNom2CLRWidthDDM),
                editText25 = (EditText) findViewById(R.id.editTextLlzAsiiDailyMon2CLRWidthDDM),
                editText26 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNom1FFMDDM),
                editText27 = (EditText) findViewById(R.id.editTextLlzAsiiDailyMon1FFMDDM),
                editText28 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNom2FFMDDM),
                editText29 = (EditText) findViewById(R.id.editTextLlzAsiiDailyMon2FFMDDM),
                editText30 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNom1IdentCode),
                editText31 = (EditText) findViewById(R.id.editTextLlzAsiiDailyMon1IdentCode),
                editText32 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNom2IdentCode),
                editText33 = (EditText) findViewById(R.id.editTextLlzAsiiDailyMon2IdentCode),
                editText34 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNom1CRSPwr),
                editText35 = (EditText) findViewById(R.id.editTextLlzAsiiDailyMon1CRSPwr),
                editText36 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNom2CRSPwr),
                editText37 = (EditText) findViewById(R.id.editTextLlzAsiiDailyMon2CRSPwr),
                editText38 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNom1CRSCSBFwd),
                editText39 = (EditText) findViewById(R.id.editTextLlzAsiiDailyMon1CRSCSBFwd),
                editText40 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNom2CRSCSBFwd),
                editText41 = (EditText) findViewById(R.id.editTextLlzAsiiDailyMon2CRSCSBFwd),
                editText42 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNom1CRSCSBRef),
                editText43 = (EditText) findViewById(R.id.editTextLlzAsiiDailyMon1CRSCSBRef),
                editText44 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNom2CRSCSBRef),
                editText45 = (EditText) findViewById(R.id.editTextLlzAsiiDailyMon2CRSCSBRef),
                editText46 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNom1CRSSBOFwd),
                editText47 = (EditText) findViewById(R.id.editTextLlzAsiiDailyMon1CRSSBOFwd),
                editText48 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNom2CRSSBOFwd),
                editText49 = (EditText) findViewById(R.id.editTextLlzAsiiDailyMon2CRSSBOFwd),
                editText50 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNom1CRSSBORef),
                editText51 = (EditText) findViewById(R.id.editTextLlzAsiiDailyMon1CRSSBORef),
                editText52 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNom2CRSSBORef),
                editText53 = (EditText) findViewById(R.id.editTextLlzAsiiDailyMon2CRSSBORef),
                editText54 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNom1CLRPwr),
                editText55 = (EditText) findViewById(R.id.editTextLlzAsiiDailyMon1CLRPwr),
                editText56 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNom2CLRPwr),
                editText57 = (EditText) findViewById(R.id.editTextLlzAsiiDailyMon2CLRPwr),
                editText58 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNom1CLRCSBFwd),
                editText59 = (EditText) findViewById(R.id.editTextLlzAsiiDailyMon1CLRCSBFwd),
                editText60 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNom2CLRCSBFwd),
                editText61 = (EditText) findViewById(R.id.editTextLlzAsiiDailyMon2CLRCSBFwd),
                editText62 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNom1CLRCSBRef),
                editText63 = (EditText) findViewById(R.id.editTextLlzAsiiDailyMon1CLRCSBRef),
                editText64 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNom2CLRCSBRef),
                editText65 = (EditText) findViewById(R.id.editTextLlzAsiiDailyMon2CLRCSBRef),
                editText66 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNom1CLRSBOFwd),
                editText67 = (EditText) findViewById(R.id.editTextLlzAsiiDailyMon1CLRSBOFwd),
                editText68 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNom2CLRSBOFwd),
                editText69 = (EditText) findViewById(R.id.editTextLlzAsiiDailyMon2CLRSBOFwd),
                editText70 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNom1CLRSBORef),
                editText71 = (EditText) findViewById(R.id.editTextLlzAsiiDailyMon1CLRSBORef),
                editText72 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNom2CLRSBORef),
                editText73 = (EditText) findViewById(R.id.editTextLlzAsiiDailyMon2CLRSBORef),
                editText74 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNomTx1FieldDDM),
                editText75 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNomTx2FieldDDM),
                editText76 = (EditText) findViewById(R.id.editTextLlzAsiiDailyObsTx1FieldDDM),
                editText77 = (EditText) findViewById(R.id.editTextLlzAsiiDailyObsTx2FieldDDM),
                editText78 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNomTx1FieldWidth90),
                editText79 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNomTx2FieldWidth90),
                editText80 = (EditText) findViewById(R.id.editTextLlzAsiiDailyObsTx1FieldWidth90),
                editText81 = (EditText) findViewById(R.id.editTextLlzAsiiDailyObsTx2FieldWidth90),
                editText82 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNomTx1FieldWidth150),
                editText83 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNomTx2FieldWidth150),
                editText84 = (EditText) findViewById(R.id.editTextLlzAsiiDailyObsTx1FieldWidth150),
                editText85 = (EditText) findViewById(R.id.editTextLlzAsiiDailyObsTx2FieldWidth150),
                editText86 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNomTx1IntPOSDDM),
                editText87 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNomTx2IntPOSDDM),
                editText88 = (EditText) findViewById(R.id.editTextLlzAsiiDailyObsTx1IntPOSDDM),
                editText89 = (EditText) findViewById(R.id.editTextLlzAsiiDailyObsTx2IntPOSDDM),
                editText90 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNomTx1FieldPOS),
                editText91 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNomTx2FieldPOS),
                editText92 = (EditText) findViewById(R.id.editTextLlzAsiiDailyObsTx1FieldPOS),
                editText93 = (EditText) findViewById(R.id.editTextLlzAsiiDailyObsTx2FieldPOS),
                editText94 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNomTx1FFMPOSDDM),
                editText95 = (EditText) findViewById(R.id.editTextLlzAsiiDailyNomTx2FFMPOSDDM),
                editText96 = (EditText) findViewById(R.id.editTextLlzAsiiDailyObsTx1FFMPOSDDM),
                editText97 = (EditText) findViewById(R.id.editTextLlzAsiiDailyObsTx2FFMPOSDDM),
                editText98 = (EditText) findViewById(R.id.editTextLlzAsiiDailyLlzTwr),
                editText99 = (EditText) findViewById(R.id.editTextLlzAsiiDailyRemarks)};

        //Define and Initialize all Switches serially here
        Switch  switch1,switch2,switch3,switch4,switch5,switch6,switch7,switch8,switch9;
        switchArray = new Switch[]{
                switch1 = (Switch) findViewById(R.id.switchLlzAsiiDailyRoomClean),
                switch2 = (Switch) findViewById(R.id.switchLlzAsiiDailyStatusAc),
                switch3 = (Switch) findViewById(R.id.switchLlzAsiiDailyStatusMast),
                switch4 = (Switch) findViewById(R.id.switchLlzAsiiDailyStatusInt),
                switch5 = (Switch) findViewById(R.id.switchLlzAsiiDailyStatusFar),
                switch6 = (Switch) findViewById(R.id.switchLlzAsiiDailyUPS),
                switch7 = (Switch) findViewById(R.id.switchLlzAsiiDailyBatt),
                switch8 = (Switch) findViewById(R.id.switchLlzAsiiDailyRCU),
                switch9 = (Switch) findViewById(R.id.switchLlzAsiiDailyStatusTwr)};

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

        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.llzasiidaily1);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);

        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(12);

        int[] editTextXPixel = {125,330,446,603,578,578,578,578,578,295,359,427,493,295,359,427,493,295,359,427,493,295,359,427,493,295,359,427,493,
                295,359,427,493,295,359,427,493,295,359,427,493,295,359,427,493,295,359,427,493};
        int[] editTextYPixel = {140,140,140,168,311,340,360,385,413,580,580,580,580,610,610,610,610,640,640,640,640,670,670,670,670,700,700,700,700,
                728,728,728,728,755,755,755,755,782,782,782,782,810,810,810,810,838,838,838,838};

        int[] switchXPixel = {578,578,578,578,578};
        int[] switchYPixel = {223,255,283,438,465};


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

        canvas.drawText(strData,563,141,titlePaint);//Printing Date on PDF

        myPdfdocument.finishPage(myPage1);


        //---------------------End of Page 1---------------

        //----------------------Page 2---------------------

        PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(723, 1024, 2).create();

        // start a page
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);

        canvas = myPage2.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.llzasiidaily2);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel2 = {295,360,429,493,295,360,429,493,295,360,429,493,295,360,429,493,295,360,429,493,295,360,429,493,
                285,349,425,493,285,349,425,493,285,349,425,493,285,349,425,493,285,349,425,493,285,349,425,493,505,110};
        int[] editTextYPixel2 = {114,114,114,114,144,144,144,144,170,170,170,170,197,197,197,197,224,224,224,224,251,251,251,251,
                387,387,387,387,420,420,420,420,465,465,465,465,598,598,598,598,638,638,638,638,670,670,670,670,795,862};

        int[] switchXPixel2 = {505,505,505,505};
        int[] switchYPixel2 = {695,725,751,773};

        for(int i = 0; i < editTextXPixel2.length; i++){
            canvas.drawText( editTextDataForPDF[i+editTextXPixel.length],editTextXPixel2[i],editTextYPixel2[i],titlePaint);
        }

        for(int i = 0; i < switchXPixel2.length; i++){
            canvas.drawText( switchDataForPDF[i+switchXPixel.length],switchXPixel2[i],switchYPixel2[i],titlePaint);
        }

        myPdfdocument.finishPage(myPage2);

        //-------------------------End of Page 2-----------------

        //----------------------Page 3---------------------

        PdfDocument.PageInfo myPageInfo3 = new PdfDocument.PageInfo.Builder(723, 1024, 3).create();

        // start a page
        PdfDocument.Page myPage3 = myPdfdocument.startPage(myPageInfo3);

        canvas = myPage3.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.llzasiidaily3);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(12);
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 70, 130, paint);


        myPdfdocument.finishPage(myPage3);

        //-------------------------End of Page 3-----------------



        ActivityCompat.requestPermissions(this, new String[]{

                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Navigation/LlzASII/Daily/";// Change Here------------------
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //String targetPdf = directory_path + "test.pdf";
        //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
        String fileName = "Daily LLZ ASII" + strData + ".pdf"; // Change Here--------------------------
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
                "Daily Maintenance of ASII LLZ done.",//Change Here-----------------------------
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