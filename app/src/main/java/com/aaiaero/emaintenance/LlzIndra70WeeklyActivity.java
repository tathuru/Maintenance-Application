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

public class LlzIndra70WeeklyActivity extends AppCompatActivity {
    private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
    private MySignature mySignature = new MySignature(this);
    private int selectedID;//Copy
    private String selectedName;//Copy
    private EditText[] editTextArray;//Copy
    private Switch[] switchArray;//Copy
    private Spinner[] spinnerArray={};//Copy
    private String thisActivityName = "LlzIndra70WeeklyActivity"; //Change Here as per your class name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llz_indra70_weekly);

        //Define and Initialize all EditTexts serially here
        EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8,editText9, editText10, editText11, editText12, editText13, editText14, editText15, editText16,
                editText17, editText18, editText19, editText20, editText21, editText22, editText23, editText24,editText25, editText26, editText27, editText28, editText29, editText30, editText31, editText32,
                editText33, editText34, editText35, editText36, editText37, editText38, editText39, editText40, editText41, editText42, editText43, editText44, editText45, editText46, editText47, editText48,
                editText49, editText50, editText51, editText52, editText53, editText54, editText55, editText56, editText57, editText58,editText59, editText60,editText61, editText62,editText63, editText64,
                editText65, editText66, editText67, editText68,editText69, editText70, editText71, editText72, editText73, editText74, editText75, editText76, editText77, editText78, editText79, editText80,
                editText81, editText82, editText83, editText84, editText85, editText86, editText87, editText88,editText89,editText90, editText91, editText92, editText93, editText94;

        editTextArray = new EditText[]{
                editText1 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyStation),
                editText2 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyModel),
                editText3 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyRWY),
                editText4 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyCat),
                editText5 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyFrequency),
                editText6 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyIdent),
                editText7 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyTimeObs),
                editText8 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyTimeILS),
                editText9 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyTime),
                editText10 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyCourseTx1),
                editText11 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyCourseTx2),
                editText12 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyCourseShiftTx1),
                editText13 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyCourseShiftTx2),
                editText14 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyDisSenTx1),
                editText15 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyDisSenTx2),
                editText16 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyCLRSigTx1),
                editText17 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyCLRSigTx2),
                editText18 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyRedPowerTx1),
                editText19 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyRedPowerTx2),
                editText20 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyTotalTimeTx1),
                editText21 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyTotalTimeTx2),
                editText22 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyUPSVolt1),
                editText23 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyUPSVolt2),
                editText24 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyUPSFreq1),
                editText25 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyUPSFreq2),
                editText26 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyBatteryVolt1),
                editText27 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyBatteryVolt2),
                editText28 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyBatteryBD1),
                editText29 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyBatteryBD2),
                editText30 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyBatt10min1),
                editText31 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyBatt10min2),
                editText32 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyBatteryAD1),
                editText33 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyBatteryAD2),
                editText34 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyBatteryClean1),
                editText35 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyBatteryClean2),
                editText36 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyDevCL1),
                editText37 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyDevCL2),
                editText38 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyDevWP901),
                editText39 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyDevWP902),
                editText40 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyDevWP1501),
                editText41 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyDevWP1502),
                editText42 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyDevRF1),
                editText43 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyDevRF2),
                editText44 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyDevDDM901),
                editText45 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyDevDDM902),
                editText46 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyDevDDM1501),
                editText47 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyDevDDM1502),
                editText48 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyCRSV1),
                editText49 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyCRSV2),
                editText50 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyCRSCSB1),
                editText51 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyCRSCSB2),
                editText52 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyCRSSBO1),
                editText53 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyCRSSBO2),
                editText54 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyCRSCSBI1),
                editText55 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyCRSCBSI2),
                editText56 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyCRSCSBQ1),
                editText57 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyCRSCBSQ2),
                editText58 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyCRSSBOI1),
                editText59 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyCRSSBOI2),
                editText60 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyCRSSBOQ1),
                editText61 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyCRSSBOQ2),
                editText62 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyCLRV1),
                editText63 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyCLRV2),
                editText64 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyCLRCSB1),
                editText65 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyCLRCSB2),
                editText66 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyCLRSBO1),
                editText67 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyCLRSBO2),
                editText68 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyCLRCSBI1),
                editText69 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyCLRCSBI2),
                editText70 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyCLRCSBQ1),
                editText71 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyCLRCSBQ2),
                editText72 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyCLRSBOI1),
                editText73 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyCLRSBOI2),
                editText74 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyCLRSBOQ1),
                editText75 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyCLRSBOQ2),
                editText76 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyRMS1),
                editText77 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyRMSB1),
                editText78 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyPS11),
                editText79 = (EditText) findViewById(R.id.editTextLlzIndra70Weekly5PS11),
                editText80 = (EditText) findViewById(R.id.editTextLlzIndra70Weekly8PS11),
                editText81 = (EditText) findViewById(R.id.editTextLlzIndra70Weekly15PS11),
                editText82 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyPS21),
                editText83 = (EditText) findViewById(R.id.editTextLlzIndra70Weekly5PS21),
                editText84 = (EditText) findViewById(R.id.editTextLlzIndra70Weekly8PS21),
                editText85 = (EditText) findViewById(R.id.editTextLlzIndra70Weekly15PS21),
                editText86 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyCOUCSB1),
                editText87 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyCOUCSB2),
                editText88 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyCOUSBO1),
                editText89 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyCOUSBO2),
                editText90 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyCLRCSBA1),
                editText91 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyCLRCSBA2),
                editText92 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyCLRSBOA1),
                editText93 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyCLRSBOA2),
                editText94 = (EditText) findViewById(R.id.editTextLlzIndra70WeeklyRemarks),};

        //Define and Initialize all Switches serially here
        Switch  switch1,switch2,switch3,switch4,switch5,switch6,switch7,switch8;
        switchArray = new Switch[]{
                switch1 = (Switch) findViewById(R.id.switchLlzIndra70WeeklyChangeOver),
                switch2 = (Switch) findViewById(R.id.switchLlzIndra70WeeklyControlFun),
                switch3 = (Switch) findViewById(R.id.switchLlzIndra70WeeklyCLIdent1),
                switch4 = (Switch) findViewById(R.id.switchLlzIndra70WeeklyCLIdent2),
                switch5 = (Switch) findViewById(R.id.switchLlzIndra70WeeklyCLRIdent1),
                switch6 = (Switch) findViewById(R.id.switchLlzIndra70WeeklyCLRIdent2),
                switch7 = (Switch) findViewById(R.id.switchLlzIndra70WeeklySelf1),
                switch8 = (Switch) findViewById(R.id.switchLlzIndra70WeeklySelf2)};

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

        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.llzindra70weekly1);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);

        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(12);

        int[] editTextXPixel = {92,565,68,164,285,440,510,510,510,370,485,436,515,436,515,436,515,436,515,436,515,310,445,310,445,310,445};
        int[] editTextYPixel = {112,112,145,145,145,145,203,222,245,365,365,510,510,575,575,625,625,705,705,760,760,820,820,838,838,853,853};



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

        canvas.drawText(strData,540,145,titlePaint);//Printing Date on PDF

        myPdfdocument.finishPage(myPage1);


        //---------------------End of Page 1---------------

        //----------------------Page 2---------------------

        PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(723, 1024, 2).create();

        // start a page
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);

        canvas = myPage2.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.llzindra70weekly2);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel2 = {315,450,315,450,315,450,315,450,465,560,465,560,465,560,465,560,465,560,465,560,
                340,455,340,455,340,455,340,455,340,455,340,455,340,455,340,455,340,455};
        int[] editTextYPixel2 = {116,116,133,133,150,150,168,168,479,479,497,497,513,513,530,530,547,547,565,565,
                670,670,692,692,713,713,735,735,756,756,778,778,800,800,842,842,864,864};

        int[] switchXPixel = {525,525,375,470,375,470,375,470};
        int[] switchYPixel = {237,254,342,342,360,360,376,376};


        for(int i = 0; i < editTextXPixel2.length; i++){
            canvas.drawText( editTextDataForPDF[i+27],editTextXPixel2[i],editTextYPixel2[i],titlePaint);
        }
        for(int i = 0; i < switchXPixel.length; i++){
            canvas.drawText( switchDataForPDF[i],switchXPixel[i],switchYPixel[i],titlePaint);
        }
        myPdfdocument.finishPage(myPage2);

        //-------------------------End of Page 2-----------------
        //----------------------Page 3---------------------

        PdfDocument.PageInfo myPageInfo3 = new PdfDocument.PageInfo.Builder(723, 1024, 3).create();

        // start a page
        PdfDocument.Page myPage3 = myPdfdocument.startPage(myPageInfo3);

        canvas = myPage3.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.llzindra70weekly3);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel3 = {340,460,340,460,340,460,340,460,340,460,360,360,360,360,360,360,360,360,360,360,325,420,325,420,325,420,325,420,60};
        int[] editTextYPixel3 = {86,86,109,109,132,132,154,154,177,177,233,251,268,286,303,321,338,356,373,390,425,425,443,443,460,460,477,477,550};


        for(int i = 0; i < editTextXPixel3.length; i++){
            canvas.drawText( editTextDataForPDF[i+65],editTextXPixel3[i],editTextYPixel3[i],titlePaint);
        }

        titlePaint.setTextSize(12);
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 75, 620, paint);

        myPdfdocument.finishPage(myPage3);

        //-------------------------End of Page 3-----------------


        ActivityCompat.requestPermissions(this, new String[]{

                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Navigation/LLZIndra70/Weekly/";// Change Here------------------
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //String targetPdf = directory_path + "test.pdf";
        //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
        String fileName = "Weekly LLZ Indra70 " + strData + ".pdf"; // Change Here--------------------------
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
        myFunctions.saveToParse(targetPdf, fileName,"LLZ Indra70","Weekly",outputEditText,specificCode);// Change Here-----------------------

        // This function will send eMail using JavaMailAPI
        //myFunctions.sendEmail(String To, String Subject, String Message,String targetPdf,String desired_Filename)
        myFunctions.sendEmail(PersonalDetailsActivity.emailTo + "@aai.aero",
                "Weekly Maintenance of Indra70 LLZ done.",//Change Here-----------------------------
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