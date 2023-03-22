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

public class NavAidsDVORASII1150MonthlyActivity extends AppCompatActivity {

    private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
    private MySignature mySignature = new MySignature(this);
    private int selectedID;//Copy
    private String selectedName;//Copy
    private EditText[] editTextArray;//Copy
    private Switch[] switchArray ={};//Copy
    private Spinner[] spinnerArray = {};//Copy

    public  String Date;
    TextView textView1,textView2,textView3,textView4;

    private String thisActivityName = "NavAidsDVORASII1150MonthlyActivity"; //Change Here as per your class name

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
        setContentView(R.layout.activity_nav_aids_dvorasii1150_monthly);

        EditText editText1,editText2,editText3,editText4,editText5,editText6,editText7,editText8,editText9,editText10,
                editText11,editText12,editText13,editText14,editText15,editText16,editText17,editText18,editText19,
                editText20,editText21,editText22,editText23,editText24,editText25,editText26,editText27,editText28,
                editText29,editText30,editText31,editText32,editText33,editText34,editText35,editText36,editText37,
                editText38,editText39,editText40,editText41,editText42,editText43,editText44,editText45,editText46,
                editText47,editText48,editText49,editText50,editText51,editText52,editText53,editText54,editText55,
                editText56,editText57,editText58,editText59,editText60,editText61,editText62,editText63,editText64,
                editText65,editText66,editText67,editText68,editText69,editText70,editText71,editText72,editText73,
                editText74,editText75,editText76,editText77,editText78,editText79,editText80,editText81,editText82,
                editText83,editText84,editText85,editText86,editText87,editText88,editText89,editText90,editText91,
                editText92,editText93,editText94,editText95,editText96,editText97,editText98,editText99,editText100,
                editText101,editText102,editText103,editText104,editText105,editText106,editText107,editText108,
                editText109;
        editTextArray = new EditText[]{

                editText1 = (EditText) findViewById(R.id.editText1),
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
                editText109 = (EditText) findViewById(R.id.editText109)};




        TextView textViewN = (TextView) findViewById(R.id.textViewN);
        textViewN.setText("Name: " + PersonalDetailsActivity.naam);
        TextView textViewD = (TextView) findViewById(R.id.textViewD);
        textViewD.setText("Designation: " + PersonalDetailsActivity.design);
        TextView textViewE = (TextView) findViewById(R.id.textViewE);
        textViewE.setText("Emp No.: " + PersonalDetailsActivity.EmpID);
        TextView textViewL = (TextView) findViewById(R.id.textViewL);
        textViewL.setText("Location: " + MainActivity.latLong1);

        TextView textView = (TextView) findViewById(R.id.textViewDate);

        textView1 = findViewById(R.id.textView1);

        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);

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
        Button error1 = (Button) findViewById(R.id.button1);
        Button error2 = (Button) findViewById(R.id.button2);

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

        error1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                e1();

            }
        });

        error2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                e2();

            }
        });



    }

    public void e1 () {

        float min = 0f, max = 0f;
        int i;

        for (i = 0; i < 48; i++) {



                for (int j = 0; j < editTextArray[i +2].length(); j++) {

                    if (Float.parseFloat(editTextArray[i + 2].getText().toString()) < min) {

                        min = Float.parseFloat(editTextArray[i + 2].getText().toString());
                    }
                }
                for (int k = 0; k < editTextArray[i + 2].length(); k++) {

                    if (Float.parseFloat(editTextArray[i + 2].getText().toString()) > max) {

                        max = Float.parseFloat(editTextArray[i + 2].getText().toString());
                    }
                }

                editTextArray[50].setText(String.valueOf(max - min));



        }

    }


    public void e2 () {


        float min = 0f, max =0f;
        int i;

        for (i = 0; i < 48; i++) {


                for (int j = 0; j < editTextArray[i + 51].length(); j++) {

                    if (Float.parseFloat(editTextArray[i + 51].getText().toString()) < min) {

                        min = Float.parseFloat(editTextArray[i + 51].getText().toString());
                    }
                }
                for (int k = 0; k < editTextArray[i + 51].length(); k++) {

                    if (Float.parseFloat(editTextArray[i + 51].getText().toString()) > max) {

                        max = Float.parseFloat(editTextArray[i + 51].getText().toString());
                    }
                }

                editTextArray[99].setText(String.valueOf(max - min));

        }


    }
    private void generatePDF() {

        // Fixed for all activity-------------------------------------------------------------------

        String outputEditText = myFunctions.getEditTextDataForPDF(editTextArray);

        String[] editTextDataForPDF = myFunctions.seperateEditText(outputEditText);


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
        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.dvorasii1150monthly1);
        scaledbmp = Bitmap.createScaledBitmap(bmp, 1384,1792, false);
//--------------------------------------------------------------------------------------------
        canvas.drawBitmap(scaledbmp, 0, 0, paint);


        titlePaint.setTextSize(20);
        paint.setTextAlign(Paint.Align.LEFT);

        titlePaint.setTextSize(20);

        int[] editTextXPixel1 = {247,696,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,505,1030,1030,1030,
                1030,1030,1030,1030,1030,1030,1030,1030,1030,1030,1030,1030,1030,1030,1030,1030,1030,1030,1030,1030,1030,471};
        int[] editTextYPixel1 = {256,256,538,567,599,629,660,690,719,751,781,812,841,872,904,934,963,992,1026,1056,1085,1115,1147,
                1177,1209,1239,538,567,599,629,660,690,719,751,781,812,841,872,904,934,963,992,1026,1056,1085,1115,1147,1177,1209,1239,1298};




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

        canvas.drawText(Date, 1056,256, titlePaint);//Printing Date on PDF

        //canvas.drawBitmap(PersonalDetailsActivity.photo, 550, 21, paint);

        myPdfdocument.finishPage(myPage1);


        PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(1384,1792, 2).create();

        // start a page
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);

        canvas = myPage2.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.dvorasii1150monthly2);
        scaledbmp = Bitmap.createScaledBitmap(bmp, 1384,1792, false);
        canvas.drawBitmap(scaledbmp, 0, 0, paint);

        titlePaint.setTextSize(20);  //Change here
        paint.setTextAlign(Paint.Align.LEFT);

        int[] editTextXPixel2 = {510,510,510,510,510,510,510,510,510,510,510,510,510,510,510,510,510,510,510,510,510,510,510,510,1040,1040,
                1040,1040,1040,1040,1040,1040,1040,1040,1040,1040,1040,1040,1040,1040,1040,1040,1040,1040,1040,1040,1040,1040,483,628,628,628,628,847,847,847,847};
        int[] editTextYPixel2= {380,410,440,470,500,530,560,592,622,653,683,713,746,776,806,837,866,
        895,928,958,988,1020,1049,1081,380,410,440,470,500,530,560,592,622,653,683,713,746,776,806,837,866,
                895,928,958,988,1020,1049,1081,1167,1328,1357,1384,1413,1328,1357,1384,1413};

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
        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.dvorasii1150monthly3);
        scaledbmp = Bitmap.createScaledBitmap(bmp, 1384,1792, false);
        canvas.drawBitmap(scaledbmp, 0, 0, paint);

        titlePaint.setTextSize(20);  //Change here
        paint.setTextAlign(Paint.Align.LEFT);

        int[] editTextXPixel3 = {207};
        int[] editTextYPixel3= {263};

        // Change till here as per requirements ----------------------------------------------------

        //Fixed for all activity--------------------------------------------------------------------

        for (int i = 0; i < editTextXPixel3.length; i++) {
            canvas.drawText(editTextDataForPDF[i + editTextXPixel1.length+editTextXPixel2.length], editTextXPixel3[i], editTextYPixel3[i], titlePaint);
        }


        canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,410,400, false), 692,750, paint);
        myPdfdocument.finishPage(myPage3);




        ActivityCompat.requestPermissions(this, new String[]{

                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);

        //----------------------Change-----------------------------------------------------------------------------
        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Nav - Aids/DVOR/ASII - 1150/Monthly/";// Change Here------------------
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //String targetPdf = directory_path + "test.pdf";
        //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
        String fileName = "DVOR_ASII_1150_Monthly_" + strData + ".pdf"; // Change Here--------------------------
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

        myFunctions.saveToParse(targetPdf, fileName, "DVOR", "Monthly", outputEditText, MyFunctions.specificCode("m"),"outputSwitch", "outputSpinner");// Change Here-----------------------

        // This function will send eMail using JavaMailAPI
        //myFunctions.sendEmail(String To, String Subject, String Message,String targetPdf,String desired_Filename)
        //
        myFunctions.sendEmail(PersonalDetailsActivity.emailTo + "@aai.aero",
        "Monthly Maintenance of DVOR ASII - 1150 done.",//Change Here-----------------------------
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