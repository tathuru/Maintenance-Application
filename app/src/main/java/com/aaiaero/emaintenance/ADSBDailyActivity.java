package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
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
import android.widget.ImageView;
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

public class ADSBDailyActivity extends AppCompatActivity {

        private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
        private MySignature mySignature = new MySignature(this);
        private int selectedID;//Copy
        private String selectedName;//Copy
        private EditText[] editTextArray;//Copy
        private Switch[] switchArray;//Copy
        private Spinner[] spinnerArray;//Copy

        private String thisActivityName = "ADSBDailyActivity"; //Change Here as per your class name

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_adsbcomsoft_daily);

            //Define and Initialize all EditTexts serially here
            EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8;

            editTextArray = new EditText[]{
                    editText1 = (EditText) findViewById(R.id.editText15),
                    editText2 = (EditText) findViewById(R.id.editText16),
                    editText3 = (EditText) findViewById(R.id.editText17),
                    editText4 = (EditText) findViewById(R.id.editText13),
                    editText5 = (EditText) findViewById(R.id.editText14),
                    editText6 = (EditText) findViewById(R.id.editText11),
                    editText7 = (EditText) findViewById(R.id.editText12)};

            //Define and Initialize all Switches serially here
            Switch switch2,switch3,switch4,switch5,switch6,switch7,switch8,switch9,switch10,switch11,switch12;
            switchArray = new Switch[]{
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
                    switch12 = (Switch) findViewById(R.id.switch12)};

            //Define and Initialize all Spinners serially here
            Spinner spinner1,spinner2,spinner3,spinner4,spinner5,spinner6,spinner7,spinner8,spinner9;
            spinnerArray = new Spinner[]{
                    spinner9 = (Spinner) findViewById(R.id.spinner9),
                    spinner6 = (Spinner) findViewById(R.id.spinner6),
                    spinner8 = (Spinner) findViewById(R.id.spinner8),
                    spinner5 = (Spinner) findViewById(R.id.spinner5),
                    spinner7 = (Spinner) findViewById(R.id.spinner7),
                    spinner4 = (Spinner) findViewById(R.id.spinner4),
                    spinner3 = (Spinner) findViewById(R.id.spinner3),
                    spinner2 = (Spinner) findViewById(R.id.spinner2),
                    spinner1 = (Spinner) findViewById(R.id.spinner1)};

            //---------------------To Set View in Current Activity------------------
            // Fixed for all the activity---------------------------------------------------------------
            ImageView imageView10 = (ImageView) findViewById(R.id.imageView10);
            //imageView10.setImageBitmap(PersonalDetailsActivity.photo);
            TextView textView7 = (TextView) findViewById(R.id.textView7);
            textView7.setText("Name: " + PersonalDetailsActivity.naam);
            TextView textView8 = (TextView) findViewById(R.id.textView8);
            textView8.setText("Designation: " + PersonalDetailsActivity.design);
            TextView textView10 = (TextView) findViewById(R.id.textView118);
            textView10.setText("Emp No.: " + PersonalDetailsActivity.EmpID);
            TextView textView9 = (TextView) findViewById(R.id.textView9);
            textView9.setText("Location: " + MainActivity.latLong1);

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

            String outputSpinner = myFunctions.getSpinnerStatusForPDF(spinnerArray);

            String[] spinnerDataForPDF = myFunctions.seperateSpinnerData(outputSpinner);

            PdfDocument myPdfdocument = new PdfDocument();

            Paint paint = new Paint();
            Paint titlePaint = new Paint();

            // Change below as per requirement-----------------------------------------------------------
            // crate a page description
            PdfDocument.PageInfo myPageInfo1 = new PdfDocument.PageInfo.Builder(2048, 3332, 1).create();

            // start a page
            PdfDocument.Page myPage1 = myPdfdocument.startPage(myPageInfo1);
            Canvas canvas = myPage1.getCanvas();


            Bitmap bmp,scaledbmp;

            bmp = BitmapFactory.decodeResource(getResources(),R.drawable.maint);
            scaledbmp = Bitmap.createScaledBitmap(bmp,2048,2932,false);

            canvas.drawBitmap(scaledbmp,0 , 0, paint);


            titlePaint.setTextSize(30);
            paint.setTextAlign(Paint.Align.LEFT);
            canvas.drawText("Name: " + PersonalDetailsActivity.naam ,1500,32,titlePaint);
            canvas.drawText("Desig: " + PersonalDetailsActivity.design ,1500,64,titlePaint);
            canvas.drawText("Emp No.: " + PersonalDetailsActivity.EmpID ,1500,96,titlePaint);
            canvas.drawText("Location: " + MainActivity.latLong1,1500,128,titlePaint);
            //canvas.drawBitmap(PersonalDetailsActivity.photo, 1630, 130, paint);
            canvas.drawBitmap(PersonalDetailsActivity.sigNature, 1325, 2720, paint);
            titlePaint.setTextSize(30);

            int[] editTextXPixel = {1400,1400,1400,1400,1400,1400,1400};
            int[] editTextYPixel = {686,727,1774,2234,2278,2446,2488};

            int[] switchXPixel = {1400,1400,1400,1400,1400,1400,1400,1400,1400,1400,1400};
            int[] switchYPixel = {645,768,809,950,1623,2023,2190,2319,2403,2530,2660};

            int[] spinnerXPixel = {1400,1400,1400,1400,1400,1400,1400,1400,1400};
            int[] spinnerYPixel = {1070,1143,1216,1289,1362,1435,1550,1690,1901};

            // Change till here as per requirements ----------------------------------------------------

            //Fixed for all activity--------------------------------------------------------------------

            for(int i = 0; i < editTextDataForPDF.length; i++){
                canvas.drawText( editTextDataForPDF[i],editTextXPixel[i],editTextYPixel[i],titlePaint);
            }

            for(int i = 0; i < switchDataForPDF.length; i++){
                canvas.drawText( switchDataForPDF[i],switchXPixel[i],switchYPixel[i],titlePaint);
            }

            for(int i = 0; i < spinnerDataForPDF.length; i++){
                canvas.drawText( spinnerDataForPDF[i],spinnerXPixel[i],spinnerYPixel[i],titlePaint);
            }


            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
            String strData = sdf.format(calendar.getTime());
            // Fixed till here--------------------------------------------------------------------------

            // Change as per your requirement-----------------------------------------------------------
            titlePaint.setTextSize(40);

            canvas.drawText(strData,1568,425,titlePaint);//Printing Date on PDF

            myPdfdocument.finishPage(myPage1);


            //---------------------End of Page 1---------------

            //----------------------Page 2---------------------

        /*PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(725, 1023, 2).create();

        // start a page
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);

        canvas = myPage2.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.surv_adsb_comsoft_daily_1);
        scaledbmp = Bitmap.createScaledBitmap(bmp,725,1023,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);
        myPdfdocument.finishPage(myPage2);*/

            //-------------------------End of Page 2-----------------



            ActivityCompat.requestPermissions(this, new String[]{

                    Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);

            //----------------------Change-----------------------------------------------------------------------------
            String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Equipment Room/ADSB/Weekly/";// Change Here------------------
            File file = new File(directory_path);
            if (!file.exists()) {
                file.mkdirs();
            }
            //String targetPdf = directory_path + "test.pdf";
            //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
            String fileName = "Weekly ADSB " + strData + ".pdf"; // Change Here--------------------------
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

            myFunctions.saveToParse(targetPdf, fileName,"ADSB","Weekly",outputEditText,MyFunctions.specificCode("d"),outputSwitch, outputSpinner);// Change Here-----------------------

            // This function will send eMail using JavaMailAPI
            //myFunctions.sendEmail(String To, String Subject, String Message,String targetPdf,String desired_Filename)


            myFunctions.sendEmail(PersonalDetailsActivity.emailTo + "@aai.aero",
                    "Weekly Maintenance of Comsoft ADSB done.",//Change Here-----------------------------
                    "Maintenance Schedule is attached. Please verify.", targetPdf, fileName);
            //---------------------------------------------------------------------------------------------------------


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
        //--------------------------Change Most Important---------------------------------------------
        //----At last don't forget to put an entry in Switch Case of ListDataActivity.java------------
        //--------------------------------------------------------------------------------------------

}