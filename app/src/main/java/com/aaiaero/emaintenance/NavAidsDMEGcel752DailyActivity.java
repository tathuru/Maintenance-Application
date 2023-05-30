package com.aaiaero.emaintenance;

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

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class NavAidsDMEGcel752DailyActivity extends AppCompatActivity {

    private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
    private MySignature mySignature = new MySignature(this);
    private int selectedID;//Copy
    private String selectedName;//Copy
    private EditText[] editTextArray;//Copy
    private Switch[] switchArray;//Copy
    private Spinner[] spinnerArray = {};//Copy

    public  String Date;

    private String thisActivityName = "NavAidsDMEGcel752DailyActivity"; //Change Here as per your class name

    public void click(View view) {

        closeKeyBoard();

    }


    public void closeKeyBoard() {
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
        setContentView(R.layout.activity_nav_aids_dmegcel_752_daily);


        EditText editText1,editText2,editText3,editText4,editText5,editText6, editText7,editText8,
                editText9,editText10,editText11,editText12, editText13,editText14,editText15,
                editText16, editText17,editText18,editText19,editText20,editText21,editText22,editText23;


        editTextArray =  new EditText[] { editText1 = (EditText) findViewById(R.id.editText1),
                editText2 = (EditText) findViewById(R.id.editText2),
                editText3 = (EditText) findViewById(R.id.editText3),
                editText4 = (EditText) findViewById(R.id.editText4),
                editText5 = (EditText) findViewById(R.id.editText5),
                editText6 = (EditText) findViewById(R.id.editText6),
                editText7 = (EditText) findViewById(R.id.editText7),
                editText8 = (EditText) findViewById(R.id.editText8),
                editText9 = (EditText) findViewById(R.id.editText9),
                editText10 =(EditText) findViewById(R.id.editText10),
                editText11 =(EditText)  findViewById(R.id.editText11),
                editText12 = (EditText) findViewById(R.id.editText12),
                editText13 =(EditText)  findViewById(R.id.editText13),
                editText14 = (EditText) findViewById(R.id.editText14),
                editText15 = (EditText) findViewById(R.id.editText15),
                editText16 = (EditText) findViewById(R.id.editText16),
                editText17 = (EditText) findViewById(R.id.editText17),
                editText18 = (EditText) findViewById(R.id.editText18),
                editText19 = (EditText) findViewById(R.id.editText19),
                editText20 = (EditText) findViewById(R.id.editText20),
                editText21 = (EditText) findViewById(R.id.editText21),
                editText22 = (EditText) findViewById(R.id.editText22),
                editText23 = (EditText) findViewById(R.id.editText23)};



        Switch switch1,switch2,switch3,switch4,switch5,switch6,switch7,switch8,switch9,switch10,switch11,
                switch12,switch13,switch14,switch15,switch16,switch17,switch18,switch19,switch20,switch21,
                switch22,switch23,switch24,switch25,switch26;


        switchArray = new Switch[]{    switch1 = (Switch) findViewById(R.id.switch1),
                switch2 = (Switch) findViewById(R.id.switch2),
                switch3 = (Switch) findViewById(R.id.switch3),
                switch4 = (Switch) findViewById(R.id.switch4),
                switch5 = (Switch) findViewById(R.id.switch5),
                switch6 = (Switch) findViewById(R.id.switch6),
                switch7 = (Switch) findViewById(R.id.switch7),
                switch8 = (Switch) findViewById(R.id.switch8),
                switch9 = (Switch) findViewById(R.id.switch9),
                switch10 = (Switch) findViewById(R.id.switch10),
                switch11 = (Switch) findViewById(R.id.switch11),
                switch12 = (Switch) findViewById(R.id.switch12),
                switch13 = (Switch) findViewById(R.id.switch13),
                switch14 = (Switch) findViewById(R.id.switch14),
                switch15 = (Switch) findViewById(R.id.switch15),
                switch16 = (Switch) findViewById(R.id.switch16),
                switch17 = (Switch) findViewById(R.id.switch17),
                switch18 = (Switch) findViewById(R.id.switch18),
                switch19 = (Switch) findViewById(R.id.switch19),
                switch20 = (Switch) findViewById(R.id.switch20),
                switch21 = (Switch) findViewById(R.id.switch21),
                switch22 = (Switch) findViewById(R.id.switch22),
                switch23 = (Switch) findViewById(R.id.switch23),
                switch24 = (Switch) findViewById(R.id.switch24),
                switch25 = (Switch) findViewById(R.id.switch25),
                switch26 = (Switch) findViewById(R.id.switch26)};


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


    private void generatePDF(){

        // Fixed for all activity-------------------------------------------------------------------

        String outputEditText = myFunctions.getEditTextDataForPDF(editTextArray);

        String[] editTextDataForPDF = myFunctions.seperateEditText(outputEditText);

        String outputSwitch = myFunctions.getSwitchStatusForPDF(switchArray);

        String[] switchDataForPDF = myFunctions.seperateSwitchData(outputSwitch);



        PdfDocument myPdfdocument = new PdfDocument();

        Paint paint = new Paint();
        Paint titlePaint = new Paint();

        // Change below as per requirement-----------------------------------------------------------
        // crate a page description
        PdfDocument.PageInfo myPageInfo1 = new PdfDocument.PageInfo.Builder(723, 1023, 1).create();


        // start a page
        PdfDocument.Page myPage1 = myPdfdocument.startPage(myPageInfo1);
        Canvas canvas = myPage1.getCanvas();


        Bitmap bmp,scaledbmp;

        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.dmegcel752daily1);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1023,false);

        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(13);  //Change here
        paint.setTextAlign(Paint.Align.LEFT);
        //canvas.drawText(PersonalDetails.name ,1900,2435,titlePaint);
        //canvas.drawText(PersonalDetails.designation ,1900,2480,titlePaint);
        //canvas.drawText(PersonalDetails.EmpID ,1900,2365,titlePaint);
        //canvas.drawText("Emp. No." ,1752,2365,titlePaint);
        //canvas.drawText("Location: " +MainActivity.latitude + " , "+ MainActivity.longitude,1600,661,titlePaint);
        // canvas.drawBitmap(PersonalDetails.captureImage, 1713, 205, paint);
        // canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.photo, 350, 400, false), 1996, 70, paint);
        titlePaint.setTextSize(13);

        int[] editTextXPixel1 = {181,325,500,500,500,500};
        int[] editTextYPixel1 = {168,168,350,368,385,403};

        int[] switchXPixel1 = {500,500,500,500,500,500,500,500,500,500,500,500,500};
        int[] switchYPixel1 = {298,316,333,420,446,458,480,506,523,541,565,587,605};


        for(int i = 0; i <editTextXPixel1.length; i++){
            canvas.drawText( editTextDataForPDF[i],editTextXPixel1[i],editTextYPixel1[i],titlePaint);
        }

        for(int i = 0; i < switchXPixel1.length; i++){
            canvas.drawText( switchDataForPDF[i],switchXPixel1[i],switchYPixel1[i],titlePaint);
        }




        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy_HHmm");
        String strData = sdf.format(calendar.getTime());
        // Fixed till here--------------------------------------------------------------------------

        // Change as per your requirement-----------------------------------------------------------
        titlePaint.setTextSize(13);

        canvas.drawText(Date, 427, 168, titlePaint);

        // canvas.drawBitmap(Bitmap.createScaledBitmap(MySignature.sigNature,650,500, false),429, 2115, paint);
        // canvas.drawText(strData,1705,577,titlePaint);//Printing Date on PDF

        myPdfdocument.finishPage(myPage1);


        //---------------------End of Page 1---------------

        PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(723, 1023, 2).create();

        // start a page
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);

        canvas = myPage2.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.dmegcel752daily2);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1023,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(13);  //Change here
        paint.setTextAlign(Paint.Align.LEFT);

        int[] editTextXPixel2 = {530,530,530,530,530,530,530,530,530,530,530,530,530,530};
        int[] editTextYPixel2 = {225,248,270,293,317,340,365,410,432,454,478,497,518,541};

        int[] switchXPixel2 = {530,530,530,530,530,530,530,530};
        int[] switchYPixel2 = {568,607,671,695,718,741,765,790};


        // Change till here as per requirements ----------------------------------------------------

        //Fixed for all activity--------------------------------------------------------------------

        for(int i = 0; i < editTextXPixel2.length; i++){
            canvas.drawText( editTextDataForPDF[i+editTextXPixel1.length],editTextXPixel2[i],editTextYPixel2[i],titlePaint);
        }

        for(int i = 0; i < switchXPixel2.length; i++){
            canvas.drawText( switchDataForPDF[i+switchXPixel1.length],switchXPixel2[i],switchYPixel2[i],titlePaint);
        }
        //----------------------Page 2---------------------


        myPdfdocument.finishPage(myPage2);


        PdfDocument.PageInfo myPageInfo3 = new PdfDocument.PageInfo.Builder(723, 1023, 3).create();

        // start a page
        PdfDocument.Page myPage3 = myPdfdocument.startPage(myPageInfo3);

        canvas = myPage3.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.dmegcel752daily3);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1023,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(13);  //Change here
        paint.setTextAlign(Paint.Align.LEFT);

        int[] editTextXPixel3 = {530,530,103};
        int[] editTextYPixel3 = {328,350,406};

        int[] switchXPixel3 = {530,530,530,530};
        int[] switchYPixel3 = {175,234,256,281};


        // Change till here as per requirements ----------------------------------------------------

        //Fixed for all activity--------------------------------------------------------------------

        for(int i = 0; i < editTextXPixel3.length; i++){
            canvas.drawText( editTextDataForPDF[i+editTextXPixel1.length+editTextXPixel2.length],editTextXPixel3[i],editTextYPixel3[i],titlePaint);
        }

        for(int i = 0; i < switchXPixel3.length; i++){
            canvas.drawText( switchDataForPDF[i+switchXPixel1.length+switchXPixel2.length],switchXPixel3[i],switchYPixel3[i],titlePaint);
        }

        canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature, 290, 270, false), 343, 535, paint);
        myPdfdocument.finishPage(myPage3);

        //-------------------------End of Page 2-----------------



        ActivityCompat.requestPermissions(this, new String[]{

                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Nav - Aids/DME/GCEL - 752/Daily/";// Change Here------------------
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //String targetPdf = directory_path + "test.pdf";
        //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
        String fileName = "DME_GCEL_752_Daily_" + strData + ".pdf"; // Change Here--------------------------
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
        // myFunctions.saveToParse(String targetPdf, String fileName, String Equipment,String Schedule_Type,String EditTextData)

        myFunctions.saveToParse(targetPdf, fileName,"DME","Daily",outputEditText,MyFunctions.specificCode("d"),outputSwitch, "outputSpinner");// Change Here-----------------------

        // This function will send eMail using JavaMailAPI

        myFunctions.sendEmail(PersonalDetailsActivity.emailTo + "@aai.aero",
          "Daily Maintenance of DME GCEL 752 done.",//Change Here-----------------------------
          "Maintenance Schedule is attached. Please verify.", targetPdf, fileName);
        //---------------------------------------------------------------------------------------------------------


        myFunctions.toLogoutActivity();
    }

    //Copy this function in your activity completely without any change
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
