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

public class VhfTxJotWeeklyActivity extends AppCompatActivity {

    private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
    private MySignature mySignature = new MySignature(this);
    private int selectedID;//Copy
    private String selectedName;//Copy
    private EditText[] editTextArray;//Copy
    private Switch[] switchArray={};//Copy
    private Spinner[] spinnerArray={};//Copy
    private String thisActivityName = "VhfTxJotWeeklyActivity"; //Change Here as per your class name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vhf_tx_jot_weekly);
        //Define and Initialize all EditTexts serially here
        EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8,editText9, editText10, editText11, editText12, editText13, editText14, editText15, editText16, editText17, editText18, editText19, editText20,
                editText21, editText22, editText23, editText24,editText25, editText26, editText27, editText28, editText29, editText30, editText31, editText32, editText33, editText34, editText35, editText36, editText37, editText38, editText39, editText40,
                editText41, editText42, editText43, editText44, editText45, editText46, editText47, editText48, editText49, editText50, editText51, editText52, editText53, editText54, editText55, editText56, editText57, editText58,editText59, editText60,
                editText61, editText62,editText63, editText64, editText65, editText66, editText67, editText68,editText69, editText70, editText71, editText72, editText73, editText74, editText75, editText76, editText77, editText78, editText79, editText80,
                editText81, editText82, editText83, editText84, editText85, editText86, editText87, editText88,editText89,editText90, editText91, editText92, editText93, editText94,editText95, editText96, editText97, editText98,editText99, editText100,
                editText101, editText102, editText103, editText104, editText105, editText106, editText107, editText108, editText109, editText110, editText111, editText112, editText113, editText114, editText115, editText116, editText117, editText118, editText119,
                editText120, editText121, editText122, editText123, editText124,editText125, editText126, editText127, editText128, editText129, editText130, editText131, editText132, editText133, editText134, editText135, editText136, editText137, editText138,
                editText139, editText140, editText141, editText142, editText143, editText144, editText145, editText146, editText147, editText148, editText149, editText150, editText151, editText152, editText153, editText154, editText155, editText156, editText157,
                editText158,editText159, editText160,editText161, editText162,editText163, editText164, editText165, editText166, editText167, editText168,editText169, editText170, editText171, editText172, editText173;

        editTextArray = new EditText[]{
                editText1 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyStation),
                editText2 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyRegion),
                editText3 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyMake),
                editText4 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyTx1),
                editText5 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyTx2),
                editText6 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyTx3),
                editText7 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyTx4),
                editText8 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyTx5),
                editText9 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyTx6),
                editText10 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyFreq1),
                editText11 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyFreq2),
                editText12 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyFreq3),
                editText13 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyFreq4),
                editText14 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyFreq5),
                editText15 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyFreq6),
                editText16 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyBatt1),
                editText17 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyBatt2),
                editText18 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyBatt3),
                editText19 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyBatt4),
                editText20 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyBatt5),
                editText21 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyBatt6),
                editText22 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyPhyChk1),
                editText23 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyPhyChk2),
                editText24 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyPhyChk3),
                editText25 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyPhyChk4),
                editText26 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyPhyChk5),
                editText27 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyPhyChk6),
                editText28 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyMod1),
                editText29 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyMod2),
                editText30 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyMod3),
                editText31 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyMod4),
                editText32 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyMod5),
                editText33 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyMod6),
                editText34 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyCur1),
                editText35 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyCur2),
                editText36 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyCur3),
                editText37 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyCur4),
                editText38 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyCur5),
                editText39 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyCur6),
                editText40 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly28V1),
                editText41 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly28V2),
                editText42 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly28V3),
                editText43 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly28V4),
                editText44 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly28V5),
                editText45 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly28V6),
                editText46 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly12V1),
                editText47 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly12V2),
                editText48 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly12V3),
                editText49 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly12V4),
                editText50 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly12V5),
                editText51 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly12V6),
                editText52 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly6V1),
                editText53 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly6V2),
                editText54 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly6V3),
                editText55 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly6V4),
                editText56 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly6V5),
                editText57 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly6V6),
                editText58 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly5V1),
                editText59 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly5V2),
                editText60 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly5V3),
                editText61 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly5V4),
                editText62 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly5V5),
                editText63 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly5V6),
                editText64 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly33V1),
                editText65 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly33V2),
                editText66 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly33V3),
                editText67 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly33V4),
                editText68 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly33V5),
                editText69 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly33V6),
                editText70 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyPSUTemp1),
                editText71 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyPSUTemp2),
                editText72 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyPSUTemp3),
                editText73 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyPSUTemp4),
                editText74 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyPSUTemp5),
                editText75 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyPSUTemp6),
                editText76 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyPSUCur1),
                editText77 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyPSUCur2),
                editText78 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyPSUCur3),
                editText79 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyPSUCur4),
                editText80 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyPSUCur5),
                editText81 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyPSUCur6),
                editText82 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyRemarks1),
                editText83 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyTx7),
                editText84 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyTx8),
                editText85 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyTx9),
                editText86 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyTx10),
                editText87 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyTx11),
                editText88 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyTx12),
                editText89 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyFreq7),
                editText90 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyFreq8),
                editText91 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyFreq9),
                editText92 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyFreq10),
                editText93 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyFreq11),
                editText94 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyFreq12),
                editText95 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyBatt7),
                editText96 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyBatt8),
                editText97 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyBatt9),
                editText98 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyBatt10),
                editText99 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyBatt11),
                editText100 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyBatt12),
                editText101 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyPhyChk7),
                editText102 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyPhyChk8),
                editText103 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyPhyChk9),
                editText104 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyPhyChk10),
                editText105 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyPhyChk11),
                editText106 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyPhyChk12),
                editText107 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyMod7),
                editText108 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyMod8),
                editText109 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyMod9),
                editText110 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyMod10),
                editText111 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyMod11),
                editText112 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyMod12),
                editText113 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyCur7),
                editText114 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyCur8),
                editText115 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyCur9),
                editText116 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyCur10),
                editText117 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyCur11),
                editText118 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyCur12),
                editText119 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly28V7),
                editText120 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly28V8),
                editText121 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly28V9),
                editText122 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly28V10),
                editText123 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly28V11),
                editText124 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly28V12),
                editText125 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly12V7),
                editText126 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly12V8),
                editText127 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly12V9),
                editText128 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly12V10),
                editText129 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly12V11),
                editText130 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly12V12),
                editText131 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly6V7),
                editText132 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly6V8),
                editText133 = (EditText)  findViewById(R.id.editTextVhfTxJotWeekly6V9),
                editText134 = (EditText)  findViewById(R.id.editTextVhfTxJotWeekly6V10),
                editText135 = (EditText)  findViewById(R.id.editTextVhfTxJotWeekly6V11),
                editText136 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly6V12),
                editText137 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly5V7),
                editText138 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly5V8),
                editText139 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly5V9),
                editText140 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly5V10),
                editText141 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly5V11),
                editText142 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly5V12),
                editText143 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly33V7),
                editText144 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly33V8),
                editText145 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly33V9),
                editText146 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly33V10),
                editText147 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly33V11),
                editText148 = (EditText) findViewById(R.id.editTextVhfTxJotWeekly33V12),
                editText149 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyPSUTemp7),
                editText150 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyPSUTemp8),
                editText151 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyPSUTemp9),
                editText152 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyPSUTemp10),
                editText153 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyPSUTemp11),
                editText154 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyPSUTemp12),
                editText155 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyPSUCur7),
                editText156 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyPSUCur8),
                editText157 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyPSUCur9),
                editText158 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyPSUCur10),
                editText159 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyPSUCur11),
                editText160 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyPSUCur12),
                editText161 = (EditText) findViewById(R.id.editTextVhfTxJotWeeklyRemarks2)};

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

        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.vhftxjotweekly1);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);

        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(12);

        int[] editTextXPixel = {244,558,182,195,280,366,450,537,623,195,280,366,450,537,623,195,280,366,450,537,623,195,280,366,450,537,623,
                195,280,366,450,537,623,195,280,366,450,537,623,195,280,366,450,537,623,195,280,366,450,537,623,195,280,366,450,537,623,
                195,280,366,450,537,623,195,280,366,450,537,623,195,280,366,450,537,623,195,280,366,450,537,623,85};
        int[] editTextYPixel = {163,163,201,244,244,244,244,244,244,272,272,272,272,272,272,305,305,305,305,305,305,345,345,345,345,345,345,
                406,406,406,406,406,406,435,435,435,435,435,435,462,462,462,462,462,462,488,488,488,488,488,488,516,516,516,516,516,516,
                545,545,545,545,545,545,573,573,573,573,573,573,605,605,605,605,605,605,642,642,642,642,642,642,702};



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

        canvas.drawText(strData,544,201,titlePaint);//Printing Date on PDF

        myPdfdocument.finishPage(myPage1);


        //---------------------End of Page 1---------------

        //----------------------Page 2---------------------

        PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(723, 1024, 2).create();

        // start a page
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);

        canvas = myPage2.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.vhftxjotweekly2);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel2 = {174,260,348,434,520,605,174,260,348,434,520,605,174,260,348,434,520,605,174,260,348,434,520,605,
                174,260,348,434,520,605,174,260,348,434,520,605,174,260,348,434,520,605,174,260,348,434,520,605,174,260,348,434,520,605,
                174,260,348,434,520,605,174,260,348,434,520,605,174,260,348,434,520,605,174,260,348,434,520,605,75};
        int[] editTextYPixel2 = {103,103,103,103,103,103,129,129,129,129,129,129,161,161,161,161,161,161,203,203,203,203,203,203,
                263,263,263,263,263,263,292,292,292,292,292,292,320,320,320,320,320,320,348,348,348,348,348,348,375,375,375,375,375,375,
                405,405,405,405,405,405,432,432,432,432,432,432,468,468,468,468,468,468,498,498,498,498,498,498,555};



        for(int i = 0; i < editTextXPixel2.length; i++){
            canvas.drawText( editTextDataForPDF[i+82],editTextXPixel2[i],editTextYPixel2[i],titlePaint);
        }


        titlePaint.setTextSize(12);
        paint.setTextAlign(Paint.Align.LEFT);

        canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 75, 610, paint);

        myPdfdocument.finishPage(myPage2);

        //-------------------------End of Page 2-----------------



        ActivityCompat.requestPermissions(this, new String[]{

                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Communication/VHFTxJotron/Weekly/";// Change Here------------------
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //String targetPdf = directory_path + "test.pdf";
        //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
        String fileName = "Weekly VHF TX JOTRON " + strData + ".pdf"; // Change Here--------------------------
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
        myFunctions.saveToParse(targetPdf, fileName,"VHF","Weekly",outputEditText,MyFunctions.specificCode("w"),"outputSwitch", "outputSpinner");// Change Here-----------------------

        // This function will send eMail using JavaMailAPI
        //myFunctions.sendEmail(String To, String Subject, String Message,String targetPdf,String desired_Filename)
        myFunctions.sendEmail(PersonalDetailsActivity.emailTo + "@aai.aero",
                "Weekly Maintenance of JOTRON VHF Tx done.",//Change Here-----------------------------
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