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

public class VhfTxOteDailyActivity extends AppCompatActivity {

    private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
    private MySignature mySignature = new MySignature(this);
    private int selectedID;//Copy
    private String selectedName;//Copy
    private EditText[] editTextArray;//Copy
    private Switch[] switchArray = {};//Copy
    private Spinner[] spinnerArray = {};//Copy
    private String thisActivityName = "VhfTxOteDailyActivity"; //Change Here as per your class name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vhf_tx_ote_daily);

        //Define and Initialize all EditTexts serially here
        EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8,editText9, editText10, editText11, editText12, editText13, editText14, editText15, editText16, editText17, editText18, editText19, editText20,
                editText21, editText22, editText23, editText24,editText25, editText26, editText27, editText28, editText29, editText30, editText31, editText32, editText33, editText34, editText35, editText36, editText37, editText38, editText39, editText40,
                editText41, editText42, editText43, editText44, editText45, editText46, editText47, editText48, editText49, editText50, editText51, editText52, editText53, editText54, editText55, editText56, editText57, editText58,editText59, editText60,
                editText61, editText62,editText63, editText64, editText65, editText66, editText67, editText68,editText69, editText70, editText71, editText72, editText73, editText74, editText75, editText76, editText77, editText78, editText79, editText80,
                editText81, editText82, editText83, editText84, editText85, editText86, editText87, editText88,editText89,editText90, editText91, editText92, editText93, editText94,editText95, editText96, editText97, editText98,editText99, editText100,
                editText101, editText102, editText103, editText104, editText105, editText106, editText107, editText108, editText109, editText110, editText111, editText112, editText113, editText114, editText115, editText116, editText117, editText118, editText119,
                editText120, editText121, editText122, editText123, editText124,editText125, editText126, editText127, editText128, editText129, editText130, editText131, editText132, editText133, editText134, editText135, editText136, editText137, editText138,
                editText139, editText140, editText141, editText142, editText143, editText144, editText145, editText146, editText147, editText148 ;

        editTextArray = new EditText[]{
                editText1 = (EditText) findViewById(R.id.editTextVhfTxOteDailyStation),
                editText2 = (EditText) findViewById(R.id.editTextVhfTxOteDailyRegion),
                editText3 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTx1),
                editText4 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTx2),
                editText5 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTx3),
                editText6 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTx4),
                editText7 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTx5),
                editText8 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTx6),
                editText9 = (EditText) findViewById(R.id.editTextVhfTxOteDailyFreq1),
                editText10 = (EditText) findViewById(R.id.editTextVhfTxOteDailyFreq2),
                editText11 = (EditText) findViewById(R.id.editTextVhfTxOteDailyFreq3),
                editText12 = (EditText) findViewById(R.id.editTextVhfTxOteDailyFreq4),
                editText13 = (EditText) findViewById(R.id.editTextVhfTxOteDailyFreq5),
                editText14 = (EditText) findViewById(R.id.editTextVhfTxOteDailyFreq6),
                editText15 = (EditText) findViewById(R.id.editTextVhfTxOteDailyLoc1),
                editText16 = (EditText) findViewById(R.id.editTextVhfTxOteDailyLoc2),
                editText17 = (EditText) findViewById(R.id.editTextVhfTxOteDailyLoc3),
                editText18 = (EditText) findViewById(R.id.editTextVhfTxOteDailyLoc4),
                editText19 = (EditText) findViewById(R.id.editTextVhfTxOteDailyLoc5),
                editText20 = (EditText) findViewById(R.id.editTextVhfTxOteDailyLoc6),
                editText21 = (EditText) findViewById(R.id.editTextVhfTxOteDailyAcPower1),
                editText22 = (EditText) findViewById(R.id.editTextVhfTxOteDailyAcPower2),
                editText23 = (EditText) findViewById(R.id.editTextVhfTxOteDailyAcPower3),
                editText24 = (EditText) findViewById(R.id.editTextVhfTxOteDailyAcPower4),
                editText25 = (EditText) findViewById(R.id.editTextVhfTxOteDailyAcPower5),
                editText26 = (EditText) findViewById(R.id.editTextVhfTxOteDailyAcPower6),
                editText27 = (EditText) findViewById(R.id.editTextVhfTxOteDailyStatus1),
                editText28 = (EditText) findViewById(R.id.editTextVhfTxOteDailyStatus2),
                editText29 = (EditText) findViewById(R.id.editTextVhfTxOteDailyStatus3),
                editText30 = (EditText) findViewById(R.id.editTextVhfTxOteDailyStatus4),
                editText31 = (EditText) findViewById(R.id.editTextVhfTxOteDailyStatus5),
                editText32 = (EditText) findViewById(R.id.editTextVhfTxOteDailyStatus6),
                editText33 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTrans1),
                editText34 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTrans2),
                editText35 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTrans3),
                editText36 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTrans4),
                editText37 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTrans5),
                editText38 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTrans6),
                editText39 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTxn1),
                editText40 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTxn2),
                editText41 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTxn3),
                editText42 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTxn4),
                editText43 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTxn5),
                editText44 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTxn6),
                editText45 = (EditText) findViewById(R.id.editTextVhfTxOteDailyACDC1),
                editText46 = (EditText) findViewById(R.id.editTextVhfTxOteDailyACDC2),
                editText47 = (EditText) findViewById(R.id.editTextVhfTxOteDailyACDC3),
                editText48 = (EditText) findViewById(R.id.editTextVhfTxOteDailyACDC4),
                editText49 = (EditText) findViewById(R.id.editTextVhfTxOteDailyACDC5),
                editText50 = (EditText) findViewById(R.id.editTextVhfTxOteDailyACDC6),
                editText51 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTemp1),
                editText52 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTemp2),
                editText53 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTemp3),
                editText54 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTemp4),
                editText55 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTemp5),
                editText56 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTemp6),
                editText57 = (EditText) findViewById(R.id.editTextVhfTxOteDailyVSWR1),
                editText58 = (EditText) findViewById(R.id.editTextVhfTxOteDailyVSWR2),
                editText59 = (EditText) findViewById(R.id.editTextVhfTxOteDailyVSWR3),
                editText60 = (EditText) findViewById(R.id.editTextVhfTxOteDailyVSWR4),
                editText61 = (EditText) findViewById(R.id.editTextVhfTxOteDailyVSWR5),
                editText62 = (EditText) findViewById(R.id.editTextVhfTxOteDailyVSWR6),
                editText63 = (EditText) findViewById(R.id.editTextVhfTxOteDailyRFop1),
                editText64 = (EditText) findViewById(R.id.editTextVhfTxOteDailyRFop2),
                editText65 = (EditText) findViewById(R.id.editTextVhfTxOteDailyRFop3),
                editText66 = (EditText) findViewById(R.id.editTextVhfTxOteDailyRFop4),
                editText67 = (EditText) findViewById(R.id.editTextVhfTxOteDailyRFop5),
                editText68 = (EditText) findViewById(R.id.editTextVhfTxOteDailyRFop6),
                editText69 = (EditText) findViewById(R.id.editTextVhfTxOteDailyMod1),
                editText70 = (EditText) findViewById(R.id.editTextVhfTxOteDailyMod2),
                editText71 = (EditText) findViewById(R.id.editTextVhfTxOteDailyMod3),
                editText72 = (EditText) findViewById(R.id.editTextVhfTxOteDailyMod4),
                editText73 = (EditText) findViewById(R.id.editTextVhfTxOteDailyMod5),
                editText74 = (EditText) findViewById(R.id.editTextVhfTxOteDailyMod6),
                editText75 = (EditText) findViewById(R.id.editTextVhfTxOteDailyRemarks1),
                editText76 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTx7),
                editText77 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTx8),
                editText78 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTx9),
                editText79 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTx10),
                editText80 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTx11),
                editText81 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTx12),
                editText82 = (EditText) findViewById(R.id.editTextVhfTxOteDailyFreq7),
                editText83 = (EditText) findViewById(R.id.editTextVhfTxOteDailyFreq8),
                editText84 = (EditText) findViewById(R.id.editTextVhfTxOteDailyFreq9),
                editText85 = (EditText) findViewById(R.id.editTextVhfTxOteDailyFreq10),
                editText86 = (EditText) findViewById(R.id.editTextVhfTxOteDailyFreq11),
                editText87 = (EditText) findViewById(R.id.editTextVhfTxOteDailyFreq12),
                editText88 = (EditText) findViewById(R.id.editTextVhfTxOteDailyLoc7),
                editText89 = (EditText) findViewById(R.id.editTextVhfTxOteDailyLoc8),
                editText90 = (EditText) findViewById(R.id.editTextVhfTxOteDailyLoc9),
                editText91 = (EditText) findViewById(R.id.editTextVhfTxOteDailyLoc10),
                editText92 = (EditText) findViewById(R.id.editTextVhfTxOteDailyLoc11),
                editText93 = (EditText) findViewById(R.id.editTextVhfTxOteDailyLoc12),
                editText94 = (EditText) findViewById(R.id.editTextVhfTxOteDailyAcPower7),
                editText95 = (EditText) findViewById(R.id.editTextVhfTxOteDailyAcPower8),
                editText96 = (EditText) findViewById(R.id.editTextVhfTxOteDailyAcPower9),
                editText97 = (EditText) findViewById(R.id.editTextVhfTxOteDailyAcPower10),
                editText98 = (EditText) findViewById(R.id.editTextVhfTxOteDailyAcPower11),
                editText99 = (EditText) findViewById(R.id.editTextVhfTxOteDailyAcPower12),
                editText100 = (EditText) findViewById(R.id.editTextVhfTxOteDailyStatus7),
                editText101 = (EditText) findViewById(R.id.editTextVhfTxOteDailyStatus8),
                editText102 = (EditText) findViewById(R.id.editTextVhfTxOteDailyStatus9),
                editText103 = (EditText) findViewById(R.id.editTextVhfTxOteDailyStatus10),
                editText104 = (EditText) findViewById(R.id.editTextVhfTxOteDailyStatus11),
                editText105 = (EditText) findViewById(R.id.editTextVhfTxOteDailyStatus12),
                editText106 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTrans7),
                editText107 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTrans8),
                editText108 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTrans9),
                editText109 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTrans10),
                editText110 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTrans11),
                editText111 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTrans12),
                editText112 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTxn7),
                editText113 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTxn8),
                editText114 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTxn9),
                editText115 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTxn10),
                editText116 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTxn11),
                editText117 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTxn12),
                editText118 = (EditText) findViewById(R.id.editTextVhfTxOteDailyACDC7),
                editText119 = (EditText) findViewById(R.id.editTextVhfTxOteDailyACDC8),
                editText120 = (EditText) findViewById(R.id.editTextVhfTxOteDailyACDC9),
                editText121 = (EditText) findViewById(R.id.editTextVhfTxOteDailyACDC10),
                editText122 = (EditText) findViewById(R.id.editTextVhfTxOteDailyACDC11),
                editText123 = (EditText) findViewById(R.id.editTextVhfTxOteDailyACDC12),
                editText124 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTemp7),
                editText125 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTemp8),
                editText126 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTemp9),
                editText127 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTemp10),
                editText128 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTemp11),
                editText129 = (EditText) findViewById(R.id.editTextVhfTxOteDailyTemp12),
                editText130 = (EditText) findViewById(R.id.editTextVhfTxOteDailyVSWR7),
                editText131 = (EditText) findViewById(R.id.editTextVhfTxOteDailyVSWR8),
                editText132 = (EditText) findViewById(R.id.editTextVhfTxOteDailyVSWR9),
                editText133 = (EditText)  findViewById(R.id.editTextVhfTxOteDailyVSWR10),
                editText134 = (EditText)  findViewById(R.id.editTextVhfTxOteDailyVSWR11),
                editText135 = (EditText)  findViewById(R.id.editTextVhfTxOteDailyVSWR12),
                editText136 = (EditText) findViewById(R.id.editTextVhfTxOteDailyRFop7),
                editText137 = (EditText) findViewById(R.id.editTextVhfTxOteDailyRFop8),
                editText138 = (EditText) findViewById(R.id.editTextVhfTxOteDailyRFop9),
                editText139 = (EditText) findViewById(R.id.editTextVhfTxOteDailyRFop10),
                editText140 = (EditText) findViewById(R.id.editTextVhfTxOteDailyRFop11),
                editText141 = (EditText) findViewById(R.id.editTextVhfTxOteDailyRFop12),
                editText142 = (EditText) findViewById(R.id.editTextVhfTxOteDailyMod7),
                editText143 = (EditText) findViewById(R.id.editTextVhfTxOteDailyMod8),
                editText144 = (EditText) findViewById(R.id.editTextVhfTxOteDailyMod9),
                editText145 = (EditText) findViewById(R.id.editTextVhfTxOteDailyMod10),
                editText146 = (EditText) findViewById(R.id.editTextVhfTxOteDailyMod11),
                editText147 = (EditText) findViewById(R.id.editTextVhfTxOteDailyMod12),
                editText148 = (EditText) findViewById(R.id.editTextVhfTxOteDailyRemarks2)};

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

        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.vhftxotedaily1);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);

        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(12);

        int[] editTextXPixel = {180,540,269,340,408,479,547,615,269,340,408,479,547,615,269,340,408,479,547,615,269,340,408,479,547,615,
                269,340,408,479,547,615,269,340,408,479,547,615,269,340,408,479,547,615,269,340,408,479,547,615,269,340,408,479,547,615,
                269,340,408,479,547,615,269,340,408,479,547,615,269,340,408,479,547,615,160};
        int[] editTextYPixel = {200,200,285,285,285,285,285,285,324,324,324,324,324,324,359,359,359,359,359,359,413,413,413,413,413,413,
                440,440,440,440,440,440,470,470,470,470,470,470,502,502,502,502,502,502,539,539,539,539,539,539,596,596,596,596,596,596,
                623,623,623,623,623,623,653,653,653,653,653,653,685,685,685,685,685,685,710};



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

        canvas.drawText(strData,530,223,titlePaint);//Printing Date on PDF

        myPdfdocument.finishPage(myPage1);


        //---------------------End of Page 1---------------

        //----------------------Page 2---------------------

        PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(723, 1024, 2).create();

        // start a page
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);

        canvas = myPage2.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.vhftxotedaily2);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel2 = {270,339,409,479,548,615,270,339,409,479,548,615,270,339,409,479,548,615,270,339,409,479,548,615,
                270,339,409,479,548,615,270,339,409,479,548,615,270,339,409,479,548,615,270,339,409,479,548,615,270,339,409,479,548,615,
                270,339,409,479,548,615,270,339,409,479,548,615,270,339,409,479,548,615,170};
        int[] editTextYPixel2 = {155,155,155,155,155,155,185,185,185,185,185,185,223,223,223,223,223,223,284,284,284,284,284,284,
                312,312,312,312,312,312,343,343,343,343,343,343,377,377,377,377,377,377,410,410,410,410,410,410,465,465,465,465,465,465,
                493,493,493,493,493,493,528,528,528,528,528,528,555,555,555,555,555,555,585};



        for(int i = 0; i < editTextXPixel2.length; i++){
            canvas.drawText( editTextDataForPDF[i+75],editTextXPixel2[i],editTextYPixel2[i],titlePaint);
        }


        titlePaint.setTextSize(12);
        paint.setTextAlign(Paint.Align.LEFT);

        canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 75, 650, paint);

        myPdfdocument.finishPage(myPage2);

        //-------------------------End of Page 2-----------------



        ActivityCompat.requestPermissions(this, new String[]{

                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Communication/VHFTxOte/Daily/";// Change Here------------------
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //String targetPdf = directory_path + "test.pdf";
        //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
        String fileName = "Daily VHF TX OTE " + strData + ".pdf"; // Change Here--------------------------
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
                "Daily Maintenance of Ote VHF Tx done.",//Change Here-----------------------------
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
