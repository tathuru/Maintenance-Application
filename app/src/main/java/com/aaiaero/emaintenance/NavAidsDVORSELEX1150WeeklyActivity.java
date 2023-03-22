package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
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
import android.view.inputmethod.InputMethodManager;
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

public class NavAidsDVORSELEX1150WeeklyActivity extends AppCompatActivity {


    private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
    private MySignature mySignature = new MySignature(this);
    private int selectedID;//Copy
    private String selectedName;//Copy
    private EditText[] editTextArray;//Copy
    private Switch[] switchArray;//Copy
    private Spinner[] spinnerArray = {};//Copy

    public  String Date;

    private String thisActivityName = "NavAidsDVORSELEX1150WeeklyActivity"; //Change Here as per your class name


    public void click(View view1) {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_aids_dvorselex1150_weekly);

        EditText editText1,editText2,editText3,editText4,editText5,editText6,editText7,editText8,
                editText9,editText10,editText11,editText12,editText13,editText14,editText15,
                editText16,editText17,editText18,editText19,editText20,editText21,editText22,editText23,editText24,editText25,editText26,editText27,
                editText28,editText29,editText30,editText31,editText32,editText33,editText34,editText35,editText36,editText37,editText38,editText39,
                editText40,editText41,editText42,editText43,editText44,editText45,editText46,editText47,editText48,editText49,editText50,editText51,editText52,
                editText53,editText54,editText55,editText56,editText57,editText58,editText59,editText60,editText61,editText62,editText63,editText64,editText65,
                editText66,editText67,editText68,editText69,editText70,editText71,editText72,editText73,editText74,editText75,editText76,editText77,editText78,
                editText79,editText80,editText81,editText82,editText83,editText84,editText85,editText86,editText87,editText88,editText89,editText90,editText91,
                editText92,editText93,editText94,editText95,editText96,editText97,editText98,editText99,editText100,editText101,editText102,editText103,editText104,
                editText105,editText106,editText107,editText108,editText109,editText110,editText111,editText112,editText113,editText114,editText115,editText116,
                editText117,editText118,editText119,editText120,editText121,editText122,editText123,editText124,editText125,editText126,editText127,editText128,
                editText129,editText130,editText131,editText132,editText133,editText134,editText135,editText136,editText137,editText138,editText139,editText140,
                editText141,editText142,editText143,editText144,editText145,editText146,editText147,editText148,editText149,editText150,editText151,editText152,
                editText153,editText154,editText155,editText156,editText157,editText158,editText159,editText160,editText161,editText162,editText163,editText164,
                editText165,editText166,editText167,editText168,editText169,editText170,editText171,editText172,editText173,editText174,editText175,editText176,
                editText177;

        editTextArray =  new EditText[] { editText1 = (EditText) findViewById(R.id.editText1),
                editText2 = (EditText) findViewById(R.id.editText2),
                editText3 = (EditText) findViewById(R.id.editText3),
                editText4 = (EditText) findViewById(R.id.editText4),
                editText5 = (EditText) findViewById(R.id.editText5),
                editText6 = (EditText) findViewById(R.id.editText6),
                editText7 = (EditText) findViewById(R.id.editText7),
                editText8 = (EditText) findViewById(R.id.editText8),
                editText9 = (EditText) findViewById(R.id.editText9),
                editText10 = (EditText) findViewById(R.id.editText10),
                editText11 = (EditText) findViewById(R.id.editText11),
                editText12 = (EditText) findViewById(R.id.editText12),
                editText13 = (EditText) findViewById(R.id.editText13),
                editText14 = (EditText) findViewById(R.id.editText14),
                editText15 = (EditText) findViewById(R.id.editText15),
                editText16 = (EditText) findViewById(R.id.editText16),
                editText17 = (EditText) findViewById(R.id.editText17),
                editText18 = (EditText) findViewById(R.id.editText18),
                editText19 = (EditText) findViewById(R.id.editText19),
                editText20 = (EditText) findViewById(R.id.editText20),
                editText21 = (EditText) findViewById(R.id.editText21),
                editText22 = (EditText) findViewById(R.id.editText22),
                editText23 = (EditText) findViewById(R.id.editText23),
                editText24 = (EditText) findViewById(R.id.editText24),
                editText25 = (EditText) findViewById(R.id.editText25),
                editText26 = (EditText) findViewById(R.id.editText26),
                editText27 = (EditText) findViewById(R.id.editText27),
                editText28 = (EditText) findViewById(R.id.editText28),
                editText29 = (EditText) findViewById(R.id.editText29),
                editText30 = (EditText) findViewById(R.id.editText30),
                editText31 = (EditText) findViewById(R.id.editText31),
                editText32 = (EditText) findViewById(R.id.editText32),
                editText33 = (EditText) findViewById(R.id.editText33),
                editText34 = (EditText) findViewById(R.id.editText34),
                editText35 = (EditText) findViewById(R.id.editText35),
                editText36 = (EditText) findViewById(R.id.editText36),
                editText37 = (EditText) findViewById(R.id.editText37),
                editText38 = (EditText) findViewById(R.id.editText38),
                editText39 = (EditText) findViewById(R.id.editText39),
                editText40 = (EditText) findViewById(R.id.editText40),
                editText41 = (EditText) findViewById(R.id.editText41),
                editText42 = (EditText) findViewById(R.id.editText42),
                editText43 = (EditText) findViewById(R.id.editText43),
                editText44 = (EditText) findViewById(R.id.editText44),
                editText45 = (EditText) findViewById(R.id.editText45),
                editText46 = (EditText) findViewById(R.id.editText46),
                editText47 = (EditText) findViewById(R.id.editText47),
                editText48 = (EditText) findViewById(R.id.editText48),
                editText49 = (EditText) findViewById(R.id.editText49),
                editText50 = (EditText) findViewById(R.id.editText50),
                editText51 = (EditText) findViewById(R.id.editText51),
                editText52 = (EditText) findViewById(R.id.editText52),
                editText53 = (EditText) findViewById(R.id.editText53),
                editText54 = (EditText) findViewById(R.id.editText54),
                editText55 = (EditText) findViewById(R.id.editText55),
                editText56 = (EditText) findViewById(R.id.editText56),
                editText57 = (EditText) findViewById(R.id.editText57),
                editText58 = (EditText) findViewById(R.id.editText58),
                editText59 = (EditText) findViewById(R.id.editText59),
                editText60 = (EditText) findViewById(R.id.editText60),
                editText61 = (EditText) findViewById(R.id.editText61),
                editText62 = (EditText) findViewById(R.id.editText62),
                editText63 = (EditText) findViewById(R.id.editText63),
                editText64 = (EditText) findViewById(R.id.editText64),
                editText65 = (EditText) findViewById(R.id.editText65),
                editText66 = (EditText) findViewById(R.id.editText66),
                editText67 = (EditText) findViewById(R.id.editText67),
                editText68 = (EditText) findViewById(R.id.editText68),
                editText69 = (EditText) findViewById(R.id.editText69),
                editText70 = (EditText) findViewById(R.id.editText70),
                editText71 = (EditText) findViewById(R.id.editText71),
                editText72 = (EditText) findViewById(R.id.editText72),
                editText73 = (EditText) findViewById(R.id.editText73),
                editText74 = (EditText) findViewById(R.id.editText74),
                editText75 = (EditText) findViewById(R.id.editText75),
                editText76 = (EditText) findViewById(R.id.editText76),
                editText77 = (EditText) findViewById(R.id.editText77),
                editText78 = (EditText) findViewById(R.id.editText78),
                editText79 = (EditText) findViewById(R.id.editText79),
                editText80 = (EditText) findViewById(R.id.editText80),
                editText81 = (EditText) findViewById(R.id.editText81),
                editText82 = (EditText) findViewById(R.id.editText82),
                editText83 = (EditText) findViewById(R.id.editText83),
                editText84 = (EditText) findViewById(R.id.editText84),
                editText85 = (EditText) findViewById(R.id.editText85),
                editText86 = (EditText) findViewById(R.id.editText86),
                editText87 = (EditText) findViewById(R.id.editText87),
                editText88 = (EditText) findViewById(R.id.editText88),
                editText89 = (EditText) findViewById(R.id.editText89),
                editText90 = (EditText) findViewById(R.id.editText90),
                editText91 = (EditText) findViewById(R.id.editText91),
                editText92 = (EditText) findViewById(R.id.editText92),
                editText93 = (EditText) findViewById(R.id.editText93),
                editText94 = (EditText) findViewById(R.id.editText94),
                editText95 = (EditText) findViewById(R.id.editText95),
                editText96 = (EditText) findViewById(R.id.editText96),
                editText97 = (EditText) findViewById(R.id.editText97),
                editText98 = (EditText) findViewById(R.id.editText98),
                editText99 = (EditText) findViewById(R.id.editText99),
                editText100 = (EditText) findViewById(R.id.editText100),
                editText101 = (EditText) findViewById(R.id.editText101),
                editText102 = (EditText) findViewById(R.id.editText102),
                editText103 = (EditText) findViewById(R.id.editText103),
                editText104 = (EditText) findViewById(R.id.editText104),
                editText105 = (EditText) findViewById(R.id.editText105),
                editText106 = (EditText) findViewById(R.id.editText106),
                editText107 = (EditText) findViewById(R.id.editText107),
                editText108 = (EditText) findViewById(R.id.editText108),
                editText109 = (EditText) findViewById(R.id.editText109),
                editText110 = (EditText) findViewById(R.id.editText110),
                editText111 = (EditText) findViewById(R.id.editText111),
                editText112 = (EditText) findViewById(R.id.editText112),
                editText113 = (EditText) findViewById(R.id.editText113),
                editText114 = (EditText) findViewById(R.id.editText114),
                editText115 = (EditText) findViewById(R.id.editText115),
                editText116 = (EditText) findViewById(R.id.editText116),
                editText117 = (EditText) findViewById(R.id.editText117),
                editText118 = (EditText) findViewById(R.id.editText118),
                editText119 = (EditText) findViewById(R.id.editText119),
                editText120 = (EditText) findViewById(R.id.editText120),
                editText121 = (EditText) findViewById(R.id.editText121),
                editText122 = (EditText) findViewById(R.id.editText122),
                editText123 = (EditText) findViewById(R.id.editText123),
                editText124 = (EditText) findViewById(R.id.editText124),
                editText125 = (EditText) findViewById(R.id.editText125),
                editText126 = (EditText) findViewById(R.id.editText126),
                editText127 = (EditText) findViewById(R.id.editText127),
                editText128 = (EditText) findViewById(R.id.editText128),
                editText129 = (EditText) findViewById(R.id.editText129),
                editText130 = (EditText) findViewById(R.id.editText130),
                editText131 = (EditText) findViewById(R.id.editText131),
                editText132 = (EditText) findViewById(R.id.editText132),
                editText133 = (EditText) findViewById(R.id.editText133),
                editText134 = (EditText) findViewById(R.id.editText134),
                editText135 = (EditText) findViewById(R.id.editText135),
                editText136 = (EditText) findViewById(R.id.editText136),
                editText137 = (EditText) findViewById(R.id.editText137),
                editText138 = (EditText) findViewById(R.id.editText138),
                editText139 = (EditText) findViewById(R.id.editText139),
                editText140 = (EditText) findViewById(R.id.editText140),
                editText141 = (EditText) findViewById(R.id.editText141),
                editText142 = (EditText) findViewById(R.id.editText142),
                editText143 = (EditText) findViewById(R.id.editText143),
                editText144 = (EditText) findViewById(R.id.editText144),
                editText145 = (EditText) findViewById(R.id.editText145),
                editText146 = (EditText) findViewById(R.id.editText146),
                editText147 = (EditText) findViewById(R.id.editText147),
                editText148 = (EditText) findViewById(R.id.editText148),
                editText149 = (EditText) findViewById(R.id.editText149),
                editText150 = (EditText) findViewById(R.id.editText150),
                editText151 = (EditText) findViewById(R.id.editText151),
                editText152 = (EditText) findViewById(R.id.editText152),
                editText153 = (EditText) findViewById(R.id.editText153),
                editText154 = (EditText) findViewById(R.id.editText154),
                editText155 = (EditText) findViewById(R.id.editText155),
                editText156 = (EditText) findViewById(R.id.editText156),
                editText157 = (EditText) findViewById(R.id.editText157),
                editText158 = (EditText) findViewById(R.id.editText158),
                editText159 = (EditText) findViewById(R.id.editText159),
                editText160 = (EditText) findViewById(R.id.editText160),
                editText161 = (EditText) findViewById(R.id.editText161),
                editText162 = (EditText) findViewById(R.id.editText162),
                editText163 = (EditText) findViewById(R.id.editText163),
                editText164 = (EditText) findViewById(R.id.editText164),
                editText165 = (EditText) findViewById(R.id.editText168),
                editText166 = (EditText) findViewById(R.id.editText169),
                editText167 = (EditText) findViewById(R.id.editText165),
                editText168 = (EditText) findViewById(R.id.editText166),
                editText169 = (EditText) findViewById(R.id.editText167),
                editText170 = (EditText) findViewById(R.id.editText170),
                editText171 = (EditText) findViewById(R.id.editText171),
                editText172 = (EditText) findViewById(R.id.editText172),
                editText173 = (EditText) findViewById(R.id.editText173),
                editText174 = (EditText) findViewById(R.id.editText174),
                editText175 = (EditText) findViewById(R.id.editText175),
                editText176 = (EditText) findViewById(R.id.editText176),
                editText177 = (EditText) findViewById(R.id.editText177)};


        Switch switch1, switch2;

        switchArray = new Switch[]{

                switch1 = (Switch) findViewById(R.id.switch1),
                switch2 = (Switch) findViewById(R.id.switch2)};


        TextView textViewN = (TextView) findViewById(R.id.textViewN);
        textViewN.setText("Name: " + PersonalDetailsActivity.naam);
        TextView textViewD = (TextView) findViewById(R.id.textViewD);
        textViewD.setText("Designation: " + PersonalDetailsActivity.design);
        TextView textViewE = (TextView) findViewById(R.id.textViewE);
        textViewE.setText("Emp No.: " + PersonalDetailsActivity.EmpID);
        TextView textViewL = (TextView) findViewById(R.id.textViewL);
        textViewL.setText("Location: " + MainActivity.latLong1);

        TextView textView = (TextView) findViewById(R.id.textViewDate);

        SimpleDateFormat date1 = new SimpleDateFormat("dd.MM.yyyy, HH:mm");
        Date = date1.format(new Date());
        textView.setText(Date);


        Intent receivedIntent = getIntent();
        //now get the itemID we passed as an extra
        selectedID = receivedIntent.getIntExtra("id", -1); //NOTE: -1 is just the default value
        if (selectedID == -1) {

        } else {
            //now get the name we passed as an extra
            selectedName = receivedIntent.getStringExtra("name");
            String selectedEditTextData = receivedIntent.getStringExtra("editTextData");
            String selectedSwitchData = receivedIntent.getStringExtra("switchData");
            //String selectedSpinnerData = receivedIntent.getStringExtra("spinnerData");
            //Log.i("received Data1 = ", selectedSwitchData);
            //Log.i("received Data2 = ", selectedSpinnerData);
            String[] seperatedData = myFunctions.seperateEditText(selectedEditTextData);
            String[] seperatedSwitchData = myFunctions.seperateSwitchData(selectedSwitchData);
            // String[] seperatedSpinnerData = myFunctions.seperateSpinnerData(selectedSpinnerData);

            //Log.d("RxArr=",Arrays.toString(seperatedData));
            myFunctions.putData(seperatedData, editTextArray);
            myFunctions.putSwitchData(seperatedSwitchData, switchArray);
            // myFunctions.putSpinnerData(seperatedSpinnerData, spinnerArray);
            //Log.i("received Data = ", selectedEditTextData);

        }

        Button signDocument = (Button) findViewById(R.id.button11);
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
    }
    private void generatePDF() {

        // Fixed for all activity-------------------------------------------------------------------

        String outputEditText = myFunctions.getEditTextDataForPDF(editTextArray);

        String[] editTextDataForPDF = myFunctions.seperateEditText(outputEditText);

        String outputSwitch = myFunctions.getSwitchStatusForPDF(switchArray);

        String[] switchDataForPDF = myFunctions.seperateSwitchData(outputSwitch);

        //  String outputSpinner = myFunctions.getSpinnerStatusForPDF(spinnerArray);

        //String[] spinnerDataForPDF = myFunctions.seperateSpinnerData(outputSpinner);

        PdfDocument myPdfdocument = new PdfDocument();

        Paint paint = new Paint();
        Paint titlePaint = new Paint();

        // Change below as per requirement-----------------------------------------------------------
        // crate a page description
        PdfDocument.PageInfo myPageInfo1 = new PdfDocument.PageInfo.Builder(1384,1792, 1).create();

        // start a page
        PdfDocument.Page myPage1 = myPdfdocument.startPage(myPageInfo1);
        Canvas canvas = myPage1.getCanvas();


        Bitmap bmp, scaledbmp;


//--------------------------------------------------------------------------------------------
        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.dvorselex1150weekly1);
        scaledbmp = Bitmap.createScaledBitmap(bmp, 1384,1792, false);
//--------------------------------------------------------------------------------------------
        canvas.drawBitmap(scaledbmp, 0, 0, paint);


        titlePaint.setTextSize(20);
        paint.setTextAlign(Paint.Align.LEFT);

        titlePaint.setTextSize(20);

        int[] editTextXPixel1 = {348,701,870,870,870,870,870,870,870,870,870,870,870,870,870,870,870,870,870,870,870,870,870,870,870,870,870,
                1065,1065,1065,1065,1065,1065,1065,1065,1065,1065,1065,1065,1065,1065,1065,1065,1065,1065,1065,1065,1065,1065,1065,1065,1065};
        int[] editTextYPixel1 = {238,238,384,429,476,523,568,644,693,737,811,858,908,956,1005,1054,1103,1150,1204,1250,1298,1349,1396,1448,1496,1548,1586,
                384,429,476,523,568,644,693,737,811,858,908,956,1005,1054,1103,1150,1204,1250,1298,1349,1396,1448,1496,1548,1586};




        // Change till here as per requirements ----------------------------------------------------

        //Fixed for all activity--------------------------------------------------------------------

        for (int i = 0; i < editTextXPixel1.length; i++) {
            canvas.drawText(editTextDataForPDF[i], editTextXPixel1[i], editTextYPixel1[i], titlePaint);
        }




        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_HH_mm");
        String strData = sdf.format(calendar.getTime());
        // Fixed till here--------------------------------------------------------------------------

        // Change as per your requirement-----------------------------------------------------------
        titlePaint.setTextSize(20);

        canvas.drawText(Date, 1020,238, titlePaint);//Printing Date on PDF


        myPdfdocument.finishPage(myPage1);


        PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(1384,1792, 2).create();

        // start a page
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);

        canvas = myPage2.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.dvorselex1150weekly2);
        scaledbmp = Bitmap.createScaledBitmap(bmp, 1384,1792, false);
        canvas.drawBitmap(scaledbmp, 0, 0, paint);

        titlePaint.setTextSize(20);  //Change here
        paint.setTextAlign(Paint.Align.LEFT);

        int[] editTextXPixel2 = {880,880,880,880,880,880,880,880,880,880,880,880,880,880,880,880,880,880,880,880,880,880,1070,1070
                ,1070,1070,1070,1070,1070,1070,1070,1070,1070,1070,1070,1070,1070,1070,1070,1070,1070,1070,1070,1070};
        int[] editTextYPixel2 = {201,429,479,534,581,634,723,780,829,875,930,978,1025,1080,1184,1239,1289,1332,1434,1485,1539,1587,
                201,429,479,534,581,634,723,780,829,875,930,978,1025,1080,1184,1239,1289,1332,1434,1485,1539,1587};



        // Change till here as per requirements ----------------------------------------------------

        //Fixed for all activity--------------------------------------------------------------------

        for (int i = 0; i < editTextXPixel2.length; i++) {
            canvas.drawText(editTextDataForPDF[i + editTextXPixel1.length], editTextXPixel2[i], editTextYPixel2[i], titlePaint);
        }

        myPdfdocument.finishPage(myPage2);

        PdfDocument.PageInfo myPageInfo3 = new PdfDocument.PageInfo.Builder(1384,1792, 3).create();

        // start a page
        PdfDocument.Page myPage3 = myPdfdocument.startPage(myPageInfo3);

        canvas = myPage3.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.dvorselex1150weekly3);
        scaledbmp = Bitmap.createScaledBitmap(bmp, 1384,1792, false);
        canvas.drawBitmap(scaledbmp, 0, 0, paint);

        titlePaint.setTextSize(20);  //Change here
        paint.setTextAlign(Paint.Align.LEFT);

        int[] editTextXPixel3 = {880,880,880,880,880,880,880,880,880,880,880,880,880,880,880,880,880,880,880,880,880,880,880,880,880,
                1070,1070,1070,1070,1070,1070,1070,1070,1070,1070,1070,1070,1070,1070,1070,1070,1070,1070,1070,1070,1070,1070,1070,1070,1070};
        int[] editTextYPixel3 = {250,300,353,400,449,500,679,726,772,820,873,914,1006,1056,1105,1155,1205,1256,1305,1356,1402,1454,1496,1545,1624,
                250,300,353,400,449,500,679,726,772,820,873,914,1006,1056,1105,1155,1205,1256,1305,1356,1402,1454,1496,1545,1624};



        // Change till here as per requirements ----------------------------------------------------

        //Fixed for all activity--------------------------------------------------------------------

        for (int i = 0; i < editTextXPixel3.length; i++) {
            canvas.drawText(editTextDataForPDF[i + editTextXPixel1.length+editTextXPixel2.length], editTextXPixel3[i], editTextYPixel3[i], titlePaint);
        }

        myPdfdocument.finishPage(myPage3);

        PdfDocument.PageInfo myPageInfo4 = new PdfDocument.PageInfo.Builder(1384,1792, 4).create();

        // start a page
        PdfDocument.Page myPage4 = myPdfdocument.startPage(myPageInfo4);

        canvas = myPage4.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.dvorselex1150weekly4);
        scaledbmp = Bitmap.createScaledBitmap(bmp, 1384,1792, false);
        canvas.drawBitmap(scaledbmp, 0, 0, paint);

        titlePaint.setTextSize(20);  //Change here
        paint.setTextAlign(Paint.Align.LEFT);

        int[] editTextXPixel4 = {870,870,870,870,870,870,870,870,870,870,870,870,870,870,870,1050,1050,1050,1050,1050,1050,1050,1050,1050,1050,1050,1050
                ,1050,1050,1050,248};
        int[] editTextYPixel4 = {198,245,296,338,414,461,508,555,606,775,826,890,942,1004,1064,198,245,296,338,414,461,508,555,606,775,826,890,942,1004,1064,1244};

        int[] switchXPixel1 = {870,870};
        int[] switchYPixel1 = {1123,1178};


        // Change till here as per requirements ----------------------------------------------------

        //Fixed for all activity--------------------------------------------------------------------

        for (int i = 0; i < editTextXPixel4.length; i++) {
            canvas.drawText(editTextDataForPDF[i + editTextXPixel1.length+editTextXPixel2.length+editTextXPixel3.length], editTextXPixel4[i], editTextYPixel4[i], titlePaint);
        }

        for(int i = 0; i < switchXPixel1.length; i++){
            canvas.drawText(switchDataForPDF[i],switchXPixel1[i],switchYPixel1[i],titlePaint);
        }

        canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,300,350, false) ,730,1260, paint);
        myPdfdocument.finishPage(myPage4);



        ActivityCompat.requestPermissions(this, new String[]{

                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);

        //----------------------Change-----------------------------------------------------------------------------
        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Nav - Aids/DVOR/SELEX - 1150/Weekly/";// Change Here------------------
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //String targetPdf = directory_path + "test.pdf";
        //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
        String fileName = "DVOR_SELEX_1150_Weekly_" + strData + ".pdf"; // Change Here--------------------------
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

        myFunctions.saveToParse(targetPdf, fileName, "DVOR", "Weekly", outputEditText, MyFunctions.specificCode("w"),outputSwitch, "outputSpinner");// Change Here-----------------------

        // This function will send eMail using JavaMailAPI
        //myFunctions.sendEmail(String To, String Subject, String Message,String targetPdf,String desired_Filename)


        myFunctions.sendEmail(PersonalDetailsActivity.emailTo + "@aai.aero",
                "Weekly Maintenance of DVOR SELEX - 1150 done.",//Change Here-----------------------------
                "Maintenance Schedule is attached. Please verify.", targetPdf, fileName);
        //---------------------------------------------------------------------------------------------------------


        myFunctions.toLogoutActivity();
    }
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.sub_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Copy this function in your activity completely without any change
    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        super.onOptionsItemSelected(item);

        switch (item.getItemId()) {

            case R.id.putInDB:
                final AlertDialog.Builder alert = new AlertDialog.Builder(this);
                View mView = getLayoutInflater().inflate(R.layout.custom_dialog, null);
                final EditText desiredFormName = (EditText) mView.findViewById(R.id.txt_input);
                Button btn_cancel = (Button) mView.findViewById(R.id.btn_cancel);
                Button btn_okay = (Button) mView.findViewById(R.id.btn_okay);
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
                        myFunctions.addToDB(view, editTextArray, switchArray, spinnerArray, formName, thisActivityName);
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
                                Intent intent = new Intent(getApplicationContext(), ListDataActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
                return true;

            case R.id.showDB:
                Intent intent = new Intent(getApplicationContext(), ListDataActivity.class);
                startActivity(intent);
                return true;

            case R.id.logout:
                myFunctions.toLogoutActivity();
                return true;

            default:
                return false;
        }
    }

    // Fixed for all activity-------------------------------------------------------------------

}

