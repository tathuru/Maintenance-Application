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

public class GpThalesWeeklyActivity extends AppCompatActivity {

    private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
    private MySignature mySignature = new MySignature(this);
    private int selectedID;//Copy
    private String selectedName;//Copy
    private EditText[] editTextArray;//Copy
    private Switch[] switchArray;//Copy
    private Spinner[] spinnerArray = {};//Copy
    private String thisActivityName = "GpThalesWeeklyActivity"; //Change Here as per your class name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gp_thales_weekly);
        //Define and Initialize all EditTexts serially here
        EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8,editText9, editText10, editText11, editText12, editText13, editText14, editText15, editText16, editText17, editText18,
                editText19, editText20, editText21, editText22, editText23, editText24,editText25, editText26, editText27, editText28, editText29, editText30, editText31, editText32, editText33, editText34, editText35, editText36,
                editText37, editText38, editText39, editText40, editText41, editText42, editText43, editText44, editText45, editText46, editText47, editText48, editText49, editText50, editText51, editText52, editText53, editText54,
                editText55, editText56, editText57, editText58,editText59, editText60,editText61, editText62,editText63, editText64, editText65, editText66, editText67, editText68,editText69, editText70, editText71, editText72,
                editText73, editText74, editText75, editText76, editText77, editText78, editText79, editText80, editText81, editText82, editText83, editText84, editText85, editText86, editText87, editText88,editText89,editText90,
                editText91, editText92, editText93, editText94,editText95, editText96, editText97, editText98,editText99, editText100, editText101, editText102, editText103, editText104, editText105, editText106, editText107, editText108,
                editText109, editText110, editText111, editText112, editText113, editText114, editText115, editText116, editText117, editText118, editText119, editText120, editText121, editText122, editText123, editText124,editText125,
                editText126, editText127, editText128, editText129, editText130, editText131, editText132, editText133, editText134, editText135, editText136, editText137, editText138, editText139, editText140, editText141, editText142,
                editText143, editText144, editText145, editText146, editText147, editText148, editText149, editText150;

        editTextArray = new EditText[]{
                editText1 = (EditText)  findViewById(R.id.editTextGpThalesWeeklyStation),
                editText2 = (EditText)  findViewById(R.id.editTextGpThalesWeeklyRWY),
                editText3 = (EditText)  findViewById(R.id.editTextGpThalesWeeklyCat),
                editText4 = (EditText)  findViewById(R.id.editTextGpThalesWeeklyFrequency),
                editText5 = (EditText)  findViewById(R.id.editTextGpThalesWeeklyTimeObs),
                editText6 = (EditText)  findViewById(R.id.editTextGpThalesWeeklyTime),
                editText7 = (EditText)  findViewById(R.id.editTextGpThalesWeeklyCRSSDM1),
                editText8 = (EditText)  findViewById(R.id.editTextGpThalesWeeklyCRSSDM2),
                editText9  = (EditText) findViewById(R.id.editTextGpThalesWeeklyCRS901),
                editText10 = (EditText) findViewById(R.id.editTextGpThalesWeeklyCRS902),
                editText11 = (EditText) findViewById(R.id.editTextGpThalesWeeklyCRS1501),
                editText12 = (EditText) findViewById(R.id.editTextGpThalesWeeklyCRS1502),
                editText13 = (EditText) findViewById(R.id.editTextGpThalesWeeklyCLRSDM1),
                editText14 = (EditText) findViewById(R.id.editTextGpThalesWeeklyCLRSDM2),
                editText15 = (EditText) findViewById(R.id.editTextGpThalesWeeklyCLR901),
                editText16 = (EditText) findViewById(R.id.editTextGpThalesWeeklyCLR902),
                editText17 = (EditText) findViewById(R.id.editTextGpThalesWeeklyCLR1501),
                editText18 = (EditText) findViewById(R.id.editTextGpThalesWeeklyCLR1502),
                editText19 = (EditText) findViewById(R.id.editTextGpThalesWeeklyDC51),
                editText20 = (EditText) findViewById(R.id.editTextGpThalesWeeklyDC52),
                editText21 = (EditText) findViewById(R.id.editTextGpThalesWeeklyDC151),
                editText22 = (EditText) findViewById(R.id.editTextGpThalesWeeklyDC152),
                editText23 = (EditText) findViewById(R.id.editTextGpThalesWeeklyDC15V1),
                editText24 = (EditText) findViewById(R.id.editTextGpThalesWeeklyDC15V2),
                editText25 = (EditText) findViewById(R.id.editTextGpThalesWeeklyDC241),
                editText26 = (EditText) findViewById(R.id.editTextGpThalesWeeklyDC242),
                editText27 = (EditText) findViewById(R.id.editTextGpThalesWeeklyDC541),
                editText28 = (EditText) findViewById(R.id.editTextGpThalesWeeklyDC542),
                editText29 = (EditText) findViewById(R.id.editTextGpThalesWeeklyBatt),

                editText30 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCRSCSBFWD1),
                editText31 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTxACRSCSBFWD),
                editText32 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCRSCSBFWD2),
                editText33 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTxBCRSCSBFWD),
                editText34 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCRSCSBVSWR1),
                editText35 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTxACRSCSBVSWR),
                editText36 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCRSCSBVSWR2),
                editText37 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTxBCRSCSBVSWR),
                editText38 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCRSSBOFWD1),
                editText39 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTxACRSSBOFWD),
                editText40 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCRSSBOFWD2),
                editText41 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTxBCRSSBOFWD),
                editText42 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCRSSBOVSWR1),
                editText43 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTxACRSSBOVSWR),
                editText44 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCRSSBOVSWR2),
                editText45 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTxBCRSSBOVSWR),
                editText46 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCRSDC1),
                editText47 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTxACRSDC),
                editText48 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCRSDC2),
                editText49 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTxBCRSDC),
                editText50 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCRSDDM1),
                editText51 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTxACRSDDM),
                editText52 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCRSDDM2),
                editText53 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTxBCRSDDM),
                editText54 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCRSSDM1),
                editText55 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTxACRSSDM),
                editText56 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCRSSDM2),
                editText57 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTxBCRSSDM),
                editText58 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCRSSig1),
                editText59 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTxACRSSig),
                editText60 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCRSSig2),
                editText61 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTxBCRSSig),
                editText62 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCLRCSBFWD1),
                editText63 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTxACLRCSBFWD),
                editText64 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCLRCSBFWD2),
                editText65 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTxBCLRCSBFWD),
                editText66 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCLRCSBVSWR1),
                editText67 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTxACLRCSBVSWR),
                editText68 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCLRCSBVSWR2),
                editText69 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTxBCLRCSBVSWR),
                editText70 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCRSCSB2FWD1),
                editText71 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTxACRSCSB2FWD),
                editText72 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCRSCSB2FWD2),
                editText73 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTxBCRSCSB2FWD),
                editText74 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCRSCSB2VSWR1),
                editText75 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTxACRSCSB2VSWR),
                editText76 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCRSCSB2VSWR2),
                editText77 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTxBCRSCSB2VSWR),
                editText78 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCLRDC1),
                editText79 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTxACLRDC),
                editText80 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCLRDC2),
                editText81 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTxBCLRDC),
                editText82 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCLRDDM1),
                editText83 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTxACLRDDM),
                editText84 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCLRDDM2),
                editText85 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTxBCLRDDM),
                editText86 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCLRSDM1),
                editText87 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTxACLRSDM),
                editText88 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCLRSDM2),
                editText89 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTxBCLRSDM),
                editText90 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCLRSig1),
                editText91 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTxACLRSig),
                editText92 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCLRSig2),
                editText93 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTxBCLRSig),

                editText94 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCRSRF1),
                editText95 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTx1CRSRF),
                editText96 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCRSRF2),
                editText97 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTx2CRSRF),
                editText98 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCRS1DDM1),
                editText99 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTx1CRS1DDM),
                editText100 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCRS1DDM2),
                editText101 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTx2CRS1DDM),
                editText102 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCRS1SDM1),
                editText103 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTx1CRS1SDM),
                editText104 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCRS1SDM2),
                editText105 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTx2CRS1SDM),
                editText106 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCRS901),
                editText107 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTx1CRS90),
                editText108 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCRS902),
                editText109 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTx2CRS90),
                editText110 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCRS1501),
                editText111 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTx1CRS150),
                editText112 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCRS1502),
                editText113 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTx2CRS150),
                editText114 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCRSSBOI1),
                editText115 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTx1CRSSBOI),
                editText116 = (EditText)  findViewById(R.id.editTextGpThalesWeeklyNmlCRSSBOI2),
                editText117 = (EditText)  findViewById(R.id.editTextGpThalesWeeklyTx2CRSSBOI),
                editText118 = (EditText)  findViewById(R.id.editTextGpThalesWeeklyNmlCRSSBOQ1),
                editText119 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTx1CRSSBOQ),
                editText120 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCRSSBOQ2),
                editText121 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTx2CRSSBOQ),
                editText122 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCLRRF1),
                editText123 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTx1CLRRF),
                editText124 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCLRRF2),
                editText125 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTx2CLRRF),
                editText126 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCLR1DDM1),
                editText127 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTx1CLR1DDM1),
                editText128 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCLR1DDM2),
                editText129 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTx2CLR1DDM),
                editText130 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCLR1SDM1),
                editText131 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTx1CLR1SDM),
                editText132 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCLR1SDM2),
                editText133 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTx2CLR1SDM),
                editText134 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCLR901),
                editText135 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTx1CLR90),
                editText136 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCLR902),
                editText137 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTx2CLR90),
                editText138 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCLR1501),
                editText139 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTx1CLR150),
                editText140 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCLR1502),
                editText141 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTx2CLR150),
                editText142 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCRS2I1),
                editText143 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTx1CRS2I),
                editText144 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCRS2I2),
                editText145 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTx2CRS2I),
                editText146 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCRS2Q1),
                editText147 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTx1CRS2Q),
                editText148 = (EditText) findViewById(R.id.editTextGpThalesWeeklyNmlCRS2Q2),
                editText149 = (EditText) findViewById(R.id.editTextGpThalesWeeklyTx2CRS2Q),
                editText150 = (EditText) findViewById(R.id.editTextGpThalesWeeklyRemarks)};

        //Define and Initialize all Switches serially here
        Switch  switch1,switch2;
        switchArray = new Switch[]{
                switch1 = (Switch) findViewById(R.id.switchGpThalesWeeklyEquipHolds),
                switch2 = (Switch) findViewById(R.id.switchGpThalesWeeklyChangeOver)};

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

        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.gpthalesweekly1);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);

        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(12);

        int[] editTextXPixel = {136,103,235,360,475,475,420,500,420,500,420,500,420,500,420,500,420,500,420,500,420,500,420,500,420,500,420,500,475};
        int[] editTextYPixel = {182,208,208,208,304,325,366,366,388,388,409,409,430,430,452,452,472,472,523,523,555,555,585,585,615,615,638,638,670};

        int[] switchXPixel = {595,595};
        int[] switchYPixel = {701,741};

        // Change till here as per requirements ----------------------------------------------------

        //Fixed for all activity--------------------------------------------------------------------

        for(int i = 0; i < editTextXPixel.length; i++){
            canvas.drawText( editTextDataForPDF[i],editTextXPixel[i],editTextYPixel[i],titlePaint);
        }
        for(int i = 0; i < switchXPixel.length; i++){
            canvas.drawText( switchDataForPDF[i],switchXPixel[i],switchYPixel[i],titlePaint);
        }


        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
        String strData = sdf.format(calendar.getTime());
        // Fixed till here--------------------------------------------------------------------------

        // Change as per your requirement-----------------------------------------------------------
        titlePaint.setTextSize(12);

        canvas.drawText(strData,568,208,titlePaint);//Printing Date on PDF

        myPdfdocument.finishPage(myPage1);


        //---------------------End of Page 1---------------

        //----------------------Page 2---------------------

        PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(723, 1024, 2).create();

        // start a page
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);

        canvas = myPage2.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.gpthalesweekly2);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel2 = {210,325,425,527,210,325,425,527,210,325,425,527,210,325,425,527,210,325,425,527,210,325,425,527,210,325,425,527,
                210,325,425,527,210,325,425,527,210,325,425,527,210,325,425,527,210,325,425,527,210,325,425,527,210,325,425,527,210,325,425,527,
                210,325,425,527,};
        int[] editTextYPixel2 = {210,210,210,210,240,240,240,240,270,270,270,270,302,302,302,302,332,332,332,332,364,364,364,364,395,395,395,395,
                430,430,430,430,465,465,465,465,496,496,496,496,528,528,528,528,559,559,559,559,588,588,588,588,620,620,620,620,651,651,651,651,
                685,685,685,685};

        for(int i = 0; i < editTextXPixel2.length; i++){
            canvas.drawText( editTextDataForPDF[i+29],editTextXPixel2[i],editTextYPixel2[i],titlePaint);
        }

        myPdfdocument.finishPage(myPage2);

        //-------------------------End of Page 2-----------------
        //----------------------Page 3---------------------

        PdfDocument.PageInfo myPageInfo3 = new PdfDocument.PageInfo.Builder(723, 1024, 3).create();

        // start a page
        PdfDocument.Page myPage3 = myPdfdocument.startPage(myPageInfo3);

        canvas = myPage3.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.gpthalesweekly3);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel3 = {210,325,425,527,210,325,425,527,210,325,425,527,210,325,425,527,210,325,425,527,210,325,425,527,210,325,425,527,
                210,325,425,527,210,325,425,527,210,325,425,527,210,325,425,527,210,325,425,527,210,325,425,527,210,325,425,527,155};
        int[] editTextYPixel3 = {215,215,215,215,238,238,238,238,260,260,260,260,282,282,282,282,306,306,306,306,328,328,328,328,350,350,350,350,
                373,373,373,373,395,395,395,395,418,418,418,418,440,440,440,440,463,463,463,463,485,485,485,485,510,510,510,510,545};


        for(int i = 0; i < editTextXPixel3.length; i++){
            canvas.drawText( editTextDataForPDF[i+93],editTextXPixel3[i],editTextYPixel3[i],titlePaint);
        }

        titlePaint.setTextSize(12);
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 75, 610, paint);

        myPdfdocument.finishPage(myPage3);

        //-------------------------End of Page 3-----------------


        ActivityCompat.requestPermissions(this, new String[]{

                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Navigation/GPthales/Weekly/";// Change Here------------------
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //String targetPdf = directory_path + "test.pdf";
        //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
        String fileName = "Weekly GP Thales " + strData + ".pdf"; // Change Here--------------------------
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
        myFunctions.saveToParse(targetPdf, fileName,"ILS","Weekly",outputEditText,MyFunctions.specificCode("w"),outputSwitch, "outputSpinner");// Change Here-----------------------

        // This function will send eMail using JavaMailAPI
        //myFunctions.sendEmail(String To, String Subject, String Message,String targetPdf,String desired_Filename)
        myFunctions.sendEmail(PersonalDetailsActivity.emailTo + "@aai.aero",
                "Weekly Maintenance of Thales GP done.",//Change Here-----------------------------
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