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

public class VhfTxPaeDailyActivity extends AppCompatActivity {
    private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
    private MySignature mySignature = new MySignature(this);
    private int selectedID;//Copy
    private String selectedName;//Copy
    private EditText[] editTextArray;//Copy
    private Switch[] switchArray={};//Copy
    private Spinner[] spinnerArray={};//Copy
    private String thisActivityName = "VhfTxPaeDailyActivity"; //Change Here as per your class name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vhf_tx_pae_daily);

        //Define and Initialize all EditTexts serially here
        EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8,editText9, editText10, editText11, editText12, editText13, editText14, editText15, editText16, editText17, editText18, editText19, editText20,
                editText21, editText22, editText23, editText24,editText25, editText26, editText27, editText28, editText29, editText30, editText31, editText32, editText33, editText34, editText35, editText36, editText37, editText38, editText39, editText40,
                editText41, editText42, editText43, editText44, editText45, editText46, editText47, editText48, editText49, editText50, editText51, editText52, editText53, editText54, editText55, editText56, editText57, editText58,editText59, editText60,
                editText61, editText62,editText63, editText64, editText65, editText66, editText67, editText68,editText69, editText70, editText71, editText72, editText73, editText74, editText75, editText76, editText77, editText78, editText79, editText80,
                editText81, editText82, editText83, editText84, editText85, editText86, editText87, editText88,editText89,editText90, editText91, editText92, editText93, editText94,editText95, editText96, editText97, editText98,editText99, editText100;

        editTextArray = new EditText[]{
                editText1 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyStation),
                editText2 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyRegion),
                editText3 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyTx1),
                editText4 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyTx2),
                editText5 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyTx3),
                editText6 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyTx4),
                editText7 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyTx5),
                editText8 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyTx6),
                editText9 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyFreq1),
                editText10 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyFreq2),
                editText11 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyFreq3),
                editText12 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyFreq4),
                editText13 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyFreq5),
                editText14 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyFreq6),
                editText15 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyBit1),
                editText16 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyBit2),
                editText17 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyBit3),
                editText18 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyBit4),
                editText19 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyBit5),
                editText20 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyBit6),
                editText21 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyACPwr1),
                editText22 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyACPwr2),
                editText23 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyACPwr3),
                editText24 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyACPwr4),
                editText25 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyACPwr5),
                editText26 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyACPwr6),
                editText27 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyStatus1),
                editText28 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyStatus2),
                editText29 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyStatus3),
                editText30 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyStatus4),
                editText31 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyStatus5),
                editText32 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyStatus6),
                editText33 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyTxChk1),
                editText34 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyTxChk2),
                editText35 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyTxChk3),
                editText36 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyTxChk4),
                editText37 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyTxChk5),
                editText38 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyTxChk6),
                editText39 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyTxnChk1),
                editText40 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyTxnChk2),
                editText41 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyTxnChk3),
                editText42 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyTxnChk4),
                editText43 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyTxnChk5),
                editText44 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyTxnChk6),
                editText45 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyACDC1),
                editText46 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyACDC2),
                editText47 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyACDC3),
                editText48 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyACDC4),
                editText49 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyACDC5),
                editText50 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyACDC6),
                editText51 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyRemarks1),
                editText52 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyTx7),
                editText53 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyTx8),
                editText54 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyTx9),
                editText55 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyTx10),
                editText56 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyTx11),
                editText57 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyTx12),
                editText58 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyFreq7),
                editText59 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyFreq8),
                editText60 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyFreq9),
                editText61 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyFreq10),
                editText62 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyFreq11),
                editText63 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyFreq12),
                editText64 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyBit7),
                editText65 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyBit8),
                editText66 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyBit9),
                editText67 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyBit10),
                editText68 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyBit11),
                editText69 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyBit12),
                editText70 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyACPwr7),
                editText71 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyACPwr8),
                editText72 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyACPwr9),
                editText73 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyACPwr10),
                editText74 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyACPwr11),
                editText75 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyACPwr12),
                editText76 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyStatus7),
                editText77 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyStatus8),
                editText78 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyStatus9),
                editText79 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyStatus10),
                editText80 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyStatus11),
                editText81 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyStatus12),
                editText82 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyTxChk7),
                editText83 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyTxChk8),
                editText84 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyTxChk9),
                editText85 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyTxChk10),
                editText86 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyTxChk11),
                editText87 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyTxChk12),
                editText88 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyTxnChk7),
                editText89 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyTxnChk8),
                editText90 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyTxnChk9),
                editText91 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyTxnChk10),
                editText92 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyTxnChk11),
                editText93 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyTxnChk12),
                editText94 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyACDC7),
                editText95 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyACDC8),
                editText96 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyACDC9),
                editText97 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyACDC10),
                editText98 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyACDC11),
                editText99 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyACDC12),
                editText100 = (EditText) findViewById(R.id.editTextVhfTxPaeDailyRemarks2)};

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

        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.vhftxpaedaily1);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);

        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(12);

        int[] editTextXPixel = {184,530,274,353,424,490,557,622,274,353,424,490,557,622,274,353,424,490,557,622,274,353,424,490,557,622,
                274,353,424,490,557,622,274,353,424,490,557,622,274,353,424,490,557,622,274,353,424,490,557,622,181};
        int[] editTextYPixel = {155,155,252,252,252,252,252,252,298,298,298,298,298,298,395,395,395,395,395,395,442,442,442,442,442,442,
                487,487,487,487,487,487,535,535,535,535,535,535,580,580,580,580,580,580,624,624,624,624,624,624,660};



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

        canvas.drawText(strData,518,190,titlePaint);//Printing Date on PDF

        myPdfdocument.finishPage(myPage1);


        //---------------------End of Page 1---------------

        //----------------------Page 2---------------------

        PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(723, 1024, 2).create();

        // start a page
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);

        canvas = myPage2.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.vhftxpaedaily2);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel2 = {275,352,425,490,556,622,274,350,425,490,556,622,274,350,425,490,556,622,274,350,425,490,556,622,
                274,350,425,490,556,622,274,350,425,490,556,622,274,350,425,490,556,622,274,350,425,490,556,622,182};
        int[] editTextYPixel2 = {126,126,126,126,126,126,172,172,172,172,172,172,265,265,265,265,265,265,312,312,312,312,312,312,
                360,360,360,360,360,360,407,407,407,407,407,407,452,452,452,452,452,452,500,500,500,500,500,500,533};



        for(int i = 0; i < editTextXPixel2.length; i++){
            canvas.drawText( editTextDataForPDF[i+51],editTextXPixel2[i],editTextYPixel2[i],titlePaint);
        }


        titlePaint.setTextSize(12);
        paint.setTextAlign(Paint.Align.LEFT);

        canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 75, 590, paint);

        myPdfdocument.finishPage(myPage2);

        //-------------------------End of Page 2-----------------



        ActivityCompat.requestPermissions(this, new String[]{

                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Communication/VHFTxPae/Daily/";// Change Here------------------
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //String targetPdf = directory_path + "test.pdf";
        //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
        String fileName = "Daily VHF TX PAE " + strData + ".pdf"; // Change Here--------------------------
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
                "Daily Maintenance of Pae VHF Tx done.",//Change Here-----------------------------
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
