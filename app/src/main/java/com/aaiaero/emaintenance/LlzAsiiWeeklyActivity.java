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

public class LlzAsiiWeeklyActivity extends AppCompatActivity {

    private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
    private MySignature mySignature = new MySignature(this);
    private int selectedID;//Copy
    private String selectedName;//Copy
    private EditText[] editTextArray;//Copy
    private Switch[] switchArray={};//Copy
    private Spinner[] spinnerArray={};//Copy
    private String thisActivityName = "LlzAsiiWeeklyActivity"; //Change Here as per your class name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llz_asii_weekly);
        //Define and Initialize all EditTexts serially here
        EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8,editText9, editText10, editText11, editText12, editText13, editText14, editText15, editText16, editText17, editText18,
                editText19, editText20, editText21, editText22, editText23, editText24,editText25, editText26, editText27, editText28, editText29, editText30, editText31, editText32, editText33, editText34, editText35, editText36,
                editText37, editText38, editText39, editText40, editText41, editText42, editText43, editText44, editText45, editText46, editText47, editText48, editText49, editText50, editText51, editText52, editText53, editText54,
                editText55, editText56, editText57, editText58,editText59, editText60,editText61, editText62,editText63, editText64, editText65, editText66, editText67, editText68,editText69, editText70, editText71, editText72,
                editText73, editText74, editText75, editText76, editText77, editText78, editText79, editText80, editText81, editText82, editText83, editText84, editText85, editText86, editText87, editText88,editText89,editText90,
                editText91, editText92, editText93, editText94,editText95, editText96, editText97, editText98,editText99, editText100, editText101, editText102, editText103, editText104, editText105, editText106, editText107, editText108,
                editText109, editText110, editText111, editText112, editText113, editText114, editText115, editText116, editText117, editText118, editText119, editText120, editText121, editText122, editText123, editText124,editText125,
                editText126, editText127, editText128, editText129, editText130, editText131, editText132, editText133, editText134, editText135, editText136, editText137, editText138, editText139, editText140, editText141, editText142,
                editText143, editText144, editText145;

        editTextArray = new EditText[]{
                editText1 = (EditText)  findViewById(R.id.editTextLlzAsiiWeeklyStation),
                editText2 = (EditText)  findViewById(R.id.editTextLlzAsiiWeeklyChOnAir),
                editText3 = (EditText)  findViewById(R.id.editTextLlzAsiiWeeklyCat),
                editText4 = (EditText)  findViewById(R.id.editTextLlzAsiiWeeklyFrequency),
                editText5 = (EditText)  findViewById(R.id.editTextLlzAsiiWeeklyMon15DC),
                editText6 = (EditText)  findViewById(R.id.editTextLlzAsiiWeeklyMon25DC),
                editText7 = (EditText)  findViewById(R.id.editTextLlzAsiiWeeklyMon112DC),
                editText8 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon212DC),
                editText9 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon112VDC),
                editText10 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon212VDC),
                editText11 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon124DC),
                editText12 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon224DC),
                editText13 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon124DCTx1),
                editText14 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon224DCTx1),
                editText15 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon124DCTx2),
                editText16 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon224DCTx2),
                editText17 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1Batt1),
                editText18 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2Batt1),
                editText19 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1Batt2),
                editText20 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2Batt2),
                editText21 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1AcMains),
                editText22 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2AcMains),
                editText23 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyNomTx1Mod90),
                editText24 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyNomTx2Mod90),
                editText25 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyObsTx1Mod90),
                editText26 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyObsTx2Mod90),
                editText27 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyNomTx1Mod150),
                editText28 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyNomTx2Mod150),
                editText29 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyObsTx1Mod150),
                editText30 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyObsTx2Mod150),
                editText31 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyNomTx1ModInt),
                editText32 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyNomTx2ModInt),
                editText33 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyObsTx1ModInt),
                editText34 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyObsTx2ModInt),
                editText35 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyNomTx1ModSby),
                editText36 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyNomTx2ModSby),
                editText37 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyObsTx1ModSby),
                editText38 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyObsTx2ModSby),
                editText39 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyNomTx1ModFFM),
                editText40 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyNomTx2ModFFM),
                editText41 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyObsTx1ModFFM),
                editText42 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyObsTx2ModFFM),
                editText43 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyNomTx1ModField),
                editText44 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyNomTx2ModField),
                editText45 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyObsTx1ModField),
                editText46 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyObsTx2ModField),

                editText47 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1IntNomCrsRF),
                editText48  = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1IntObsCrsRF),
                editText49 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1SbyNomCrsRF),
                editText50 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1SbyObsCrsRF),
                editText51 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2IntNomCrsRF),
                editText52 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2IntObsCrsRF),
                editText53 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2SbyNomCrsRF),
                editText54 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2SbyObsCrsRF),

                editText55 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1IntNomCrsDDM),
                editText56 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1IntObsCrsDDM),
                editText57 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1SbyNomCrsDDM),
                editText58 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1SbyObsCrsDDM),
                editText59 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2IntNomCrsDDM),
                editText60 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2IntObsCrsDDM),
                editText61 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2SbyNomCrsDDM),
                editText62 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2SbyObsCrsDDM),

                editText63 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1IntNomCrsSDM),
                editText64 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1IntObsCrsSDM),
                editText65 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1SbyNomCrsSDM),
                editText66 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1SbyObsCrsSDM),
                editText67 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2IntNomCrsSDM),
                editText68 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2IntObsCrsSDM),
                editText69 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2SbyNomCrsSDM),
                editText70 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2SbyObsCrsSDM),

                editText71 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1IntNomCrsIdent),
                editText72 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1IntObsCrsIdent),
                editText73 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1SbyNomCrsIdent),
                editText74 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1SbyObsCrsIdent),
                editText75 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2IntNomCrsIdent),
                editText76 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2IntObsCrsIdent),
                editText77 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2SbyNomCrsIdent),
                editText78 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2SbyObsCrsIdent),

                editText79 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1IntNomCrsWidth),
                editText80 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1IntObsCrsWidth),
                editText81 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1SbyNomCrsWidth),
                editText82 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1SbyObsCrsWidth),
                editText83 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2IntNomCrsWidth),
                editText84 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2IntObsCrsWidth),
                editText85 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2SbyNomCrsWidth),
                editText86 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2SbyObsCrsWidth),

                editText87 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1IntNomClrRF),
                editText88 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1IntObsClrRF),
                editText89 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1SbyNomClrRF),
                editText90 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1SbyObsClrRF),
                editText91 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2IntNomClrRF),
                editText92 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2IntObsClrRF),
                editText93 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2SbyNomClrRF),
                editText94 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2SbyObsClrRF),

                editText95 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1IntNomClrDDM),
                editText96 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1IntObsClrDDM),
                editText97 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1SbyNomClrDDM),
                editText98 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1SbyObsClrDDM),
                editText99 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2IntNomClrDDM),
                editText100 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2IntObsClrDDM),
                editText101 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2SbyNomClrDDM),
                editText102 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2SbyObsClrDDM),

                editText103 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1IntNomClrSDM),
                editText104 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1IntObsClrSDM),
                editText105 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1SbyNomClrSDM),
                editText106 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1SbyObsClrSDM),
                editText107 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2IntNomClrSDM),
                editText108 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2IntObsClrSDM),
                editText109 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2SbyNomClrSDM),
                editText110 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2SbyObsClrSDM),

                editText111 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1IntNomClrIdent),
                editText112 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1IntObsClrIdent),
                editText113 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1SbyNomClrIdent),
                editText114 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1SbyObsClrIdent),
                editText115 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2IntNomClrIdent),
                editText116 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2IntObsClrIdent),
                editText117 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2SbyNomClrIdent),
                editText118 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2SbyObsClrIdent),

                editText119 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1IntNomClrWidth),
                editText120 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1IntObsClrWidth),
                editText121 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1SbyNomClrWidth),
                editText122 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1SbyObsClrWidth),
                editText123 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2IntNomClrWidth),
                editText124 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2IntObsClrWidth),
                editText125 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2SbyNomClrWidth),
                editText126 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2SbyObsClrWidth),

                editText127 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1IntNomRFFreq),
                editText128 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1IntObsRFFreq),
                editText129 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1SbyNomRFFreq),
                editText130 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon1SbyObsRFFreq),
                editText131 = (EditText)  findViewById(R.id.editTextLlzAsiiWeeklyMon2IntNomRFFreq),
                editText132 = (EditText)  findViewById(R.id.editTextLlzAsiiWeeklyMon2IntObsRFFreq),
                editText133 = (EditText)  findViewById(R.id.editTextLlzAsiiWeeklyMon2SbyNomRFFreq),
                editText134 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyMon2SbyObsRFFreq),

                editText135 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyFFMNomRF),
                editText136 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyFFMObsRF),
                editText137 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyFFMNomDDM),
                editText138 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyFFMObsDDM),
                editText139 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyFFMNomSDM),
                editText140 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyFFMObsSDM),
                editText141 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyChange),
                editText142 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklOpsRemote),
                editText143 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklCritical),
                editText144 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklField),
                editText145 = (EditText) findViewById(R.id.editTextLlzAsiiWeeklyRemarks)};

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

        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.llzasiiweekly1);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);

        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(11);

        int[] editTextXPixel = {130,347,464,596,230,415,230,415,230,415,230,415,230,415,230,415,230,415,230,415,230,415,265,325,401,486,265,325,401,486};
        int[] editTextYPixel = {202,202,202,235,367,367,394,394,421,421,448,448,482,482,526,526,565,565,593,593,620,620,732,732,732,732,790,790,790,790};



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

        canvas.drawText(strData,560,202,titlePaint);//Printing Date on PDF

        myPdfdocument.finishPage(myPage1);


        //---------------------End of Page 1---------------

        //----------------------Page 2---------------------

        PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(723, 1024, 2).create();

        // start a page
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);

        canvas = myPage2.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.llzasiiweekly2);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(11);

        int[] editTextXPixel2 = {280,339,405,490,280,339,405,490,280,339,405,490,280,339,405,490,248,303,354,410,461,514,566,620,248,303,354,410,461,514,566,620,
                248,303,354,410,461,514,566,620,248,303,354,410,461,514,566,620,248,303,354,410,461,514,566,620,248,303,354,410,461,514,566,620,248,303,354,410,461,514,566,620,
                248,303,354,410,461,514,566,620,248,303,354,410,461,514,566,620,248,303,354,410,461,514,566,620,248,303,354,410,461,514,566,620};
        int[] editTextYPixel2 = {164,164,164,164,203,203,203,203,230,230,230,230,260,260,260,260,433,433,433,433,433,433,433,433,472,472,472,472,472,472,472,472,
                511,511,511,511,511,511,511,511,552,552,552,552,552,552,552,552,603,603,603,603,603,603,603,603,665,665,665,665,665,665,665,665,705,705,705,705,705,705,705,705,
                743,743,743,743,743,743,743,743,783,783,783,783,783,783,783,783,826,826,826,826,826,826,826,826,870,870,870,870,870,870,870,870};


        for(int i = 0; i < editTextXPixel2.length; i++){
            canvas.drawText( editTextDataForPDF[i+editTextXPixel.length],editTextXPixel2[i],editTextYPixel2[i],titlePaint);
        }


        myPdfdocument.finishPage(myPage2);

        //-------------------------End of Page 2-----------------

        //----------------------Page 3---------------------

        PdfDocument.PageInfo myPageInfo3 = new PdfDocument.PageInfo.Builder(723, 1024, 3).create();

        // start a page
        PdfDocument.Page myPage3 = myPdfdocument.startPage(myPageInfo3);

        canvas = myPage3.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.llzasiiweekly3);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(12);

        int[] editTextXPixel3 = {430,555,430,555,430,555,440,440,440,440,126};
        int[] editTextYPixel3 = {240,240,290,290,340,340,398,456,520,580,659};


        for(int i = 0; i < editTextXPixel3.length; i++){
            canvas.drawText( editTextDataForPDF[i+editTextXPixel.length+editTextXPixel2.length],editTextXPixel3[i],editTextYPixel3[i],titlePaint);
        }


        titlePaint.setTextSize(12);
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 70, 720, paint);


        myPdfdocument.finishPage(myPage3);

        //-------------------------End of Page 3-----------------



        ActivityCompat.requestPermissions(this, new String[]{

                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Navigation/LlzASII/Weekly/";// Change Here------------------
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //String targetPdf = directory_path + "test.pdf";
        //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
        String fileName = "Weekly LLZ ASII" + strData + ".pdf"; // Change Here--------------------------
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
        myFunctions.saveToParse(targetPdf, fileName,"ILS","Weekly",outputEditText,MyFunctions.specificCode("w"),"outputSwitch", "outputSpinner");// Change Here-----------------------

        // This function will send eMail using JavaMailAPI
        //myFunctions.sendEmail(String To, String Subject, String Message,String targetPdf,String desired_Filename)
        myFunctions.sendEmail(PersonalDetailsActivity.emailTo + "@aai.aero",
                "Weekly Maintenance of ASII LLZ done.",//Change Here-----------------------------
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