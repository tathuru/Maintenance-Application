package com.aaiaero.emaintenance;

import android.app.AlertDialog;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.IsoFields;
import java.util.Date;
import java.util.Locale;

public class MyFunctions {

    private Context context;
    private String outputEditTextData = "";
    private String switchData = "";
    private String spinnerData = "";

    public MyFunctions(Context context1) {
        this.context = context1;
    }

    /*@Override
    public void onCreate() {
        super.onCreate();

    }*/

    // To add data in Local DB
    public void addToDB(View view, EditText[] editTextArray, Switch[] switchArray, Spinner[] spinnerArray, String formName, String activityName){

        Boolean allDataEntered = getEditTextData(editTextArray);

        if (allDataEntered){//Checks for all edit Text Filled by user
            //Log.i("outputData",outputEditTextData);
            AddData(formName ,activityName,outputEditTextData,getSwitchStatus(switchArray), getSpinnerStatus(spinnerArray) ); //Calls AddData function to put data in Local DB
        }else {// If some edit Text not filled by user show toast
            //------------------------------------------------------------------------
            new AlertDialog.Builder(context)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Data Missing Alert!")
                    .setMessage("Do you really want to save this form in Local DB with some empty/missing fields?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            AddData(formName ,activityName,outputEditTextData,getSwitchStatus(switchArray), getSpinnerStatus(spinnerArray) ); //Calls AddData function to put data in Local DB
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();
            //------------------------------------------------------------------------

            toastMessage("Some fields Missing");
        }
    }

    // Function to delete entry from local DB
    public void deleteFromDB( View view, int selectedID, String selectedName ){
        DatabaseHelper m1DatabaseHelper = new DatabaseHelper(context);
        m1DatabaseHelper.deleteName(selectedID,selectedName);
        toastMessage("removed from database");
    }

    public Boolean getEditTextData(EditText... editTexts){
        outputEditTextData = "";
        String mergeFrom = "__XY__";
        Boolean allDataEntered = true;

        for (EditText editText : editTexts) {

            /*if (editText.getText().toString().isEmpty()) {

                editText.setError("This filed can't be Blanked");
                allDataEntered = false;

            } else {

                outputEditTextData = outputEditTextData + editText.getText().toString() + mergeFrom;
            }*/

            if (editText.getText().toString().isEmpty()) {

                outputEditTextData = outputEditTextData + " " + mergeFrom;
                editText.setError("This filed can't be Blanked");
                allDataEntered = false;

            } else {

                outputEditTextData = outputEditTextData + editText.getText().toString() + mergeFrom;
            }

        }
        return allDataEntered;
    }

    public String getEditTextDataForPDF(EditText... editTexts){
        outputEditTextData = "";
        String mergeFrom = "__XY__";

        for (EditText editText : editTexts) {

            if (editText.getText().toString().isEmpty()) {
                outputEditTextData = outputEditTextData + " " + mergeFrom;
                //editText.setError("This filed can't be Blanked");

            } else {
                outputEditTextData = outputEditTextData + editText.getText().toString() + mergeFrom;
            }

        }
        return outputEditTextData;
    }

    public void AddData(String newEntry, String stringValue, String editTextData, String switchData, String spinnerData) {
        DatabaseHelper m1DatabaseHelper = new DatabaseHelper(context);
        boolean insertData = m1DatabaseHelper.addData(newEntry,stringValue,editTextData,switchData,spinnerData);

        if (insertData) {
            toastMessage("Data Successfully Inserted!");
        } else {
            toastMessage("Something went wrong");
        }
    }

    public void toastMessage(String message){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }

    public void putData(String[] seperatedData, EditText... editTexts){

        Boolean lenghtIsSame = (seperatedData.length == editTexts.length);
        if( lenghtIsSame ) {

            for (int i = 0; i < seperatedData.length; i++) {
                editTexts[i].setText(seperatedData[i]);
            }
        }

    }

    public String[] seperateEditText(String editTextData){
        String[] seperatedData = editTextData.split("__XY__");
        return seperatedData;
    }

    public Boolean saveToParse(String targetPdf, String fileName, String Equipment, String Schedule_Type,String EditTextData, String specificCode, String SwitchData, String SpinnerData){

        final Boolean[] uploadedToServer = {false};

        byte[] data = convertPDFToByteArray(targetPdf);

        ParseFile file1 = new ParseFile(fileName, data);

        ParseQuery<ParseUser> query = ParseUser.getQuery();
        //Toast.makeText(this, ParseUser.getCurrentUser().getUsername(), Toast.LENGTH_SHORT).show();


        ParseObject test = new ParseObject("TestPdf");
        if ((MainActivity.a_log).matches("")) {
            test.put("username", ParseUser.getCurrentUser().getUsername());
            //test.put("Station", ParseUser.getCurrentUser().getUsername());
            test.put("Station", PersonalDetailsActivity.airportNameICAO);

        } else {
            test.put("username", MainActivity.a_log);
            //test.put("Station", MainActivity.a_log);
            test.put("Station", PersonalDetailsActivity.airportNameICAO);
        }

        //test.put("username","VEAT-Others");
        test.put("name", fileName);
        test.put("Equipment", Equipment);

        test.put("SpecificCode", specificCode);
        test.put("Schedule_Type", Schedule_Type);
        test.put("EditTextData", EditTextData);

        test.put("PersonalDetails", PersonalDetailsActivity.naam + "__XY__" + PersonalDetailsActivity.design + "__XY__" + PersonalDetailsActivity.EmpID + "__XY__" + MainActivity.latLong1 + "__XY__" + PersonalDetailsActivity.strDate);
        test.put("dateTime", PersonalDetailsActivity.strDate);
        test.put("SwitchData", SwitchData);
        test.put("SpinnerData", SpinnerData);
        test.put("pdfFile", file1);
        test.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException ex) {
                if (ex == null) {
                    toastMessage("Data saved to Server.");
                    Log.i("Parse Result", "Successful!");
                    uploadedToServer[0] = true;

                } else {
                    Log.i("Parse Result", "Failed " + ex.toString());
                    uploadedToServer[0] = false;
                    toastMessage("Server is not available.");

                }
            }
        });
        //SurvADSBComsoftDailyActivity.dataUploaded = true;
        return uploadedToServer[0];
    }

    public byte[] convertPDFToByteArray(String pathPDF) {

        InputStream inputStream = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {

            inputStream = new FileInputStream(pathPDF);

            byte[] buffer = new byte[4096];
            baos = new ByteArrayOutputStream();

            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return baos.toByteArray();
    }

    public void sendEmail(String mEmail, String mSubject, String mMessage, String targetPdf, String fileName) {



        JavaMailAPI javaMailAPI = new JavaMailAPI(context, mEmail, mSubject, mMessage, targetPdf,fileName);

        javaMailAPI.execute();
        toastMessage("Email Sent to UIC");
        return;
    }

    public void toLogoutActivity(){

        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Saving data to server and sending eMail."); // Setting Message
        progressDialog.setTitle("Saving Data Please Wait...!!!"); // Setting Title
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
        progressDialog.show(); // Display Progress Dialog
        progressDialog.setCancelable(false);
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(10000);
                    Intent intent = new Intent(context,LogOutActivity.class);
                    context.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                progressDialog.dismiss();
            }
        }).start();



    }

    //-------------Saving Spinner and Switch Data------------
    //Getting Spinner position for selected Items
    public String getSpinnerStatus (Spinner... spinners){

        spinnerData = "";

        for (Spinner eachSpinner : spinners){
            //spinnerData = spinnerData + eachSpinner.getSelectedItem().toString() + "__XY__";
            spinnerData = spinnerData + Integer.toString(eachSpinner.getSelectedItemPosition()) + "__XY__";

        }

        return spinnerData;
    }

    //Getting Spinner position for selected Items String Value for PDF printing
    public String getSpinnerStatusForPDF (Spinner... spinners){

        String spinnerDataForPDF = "";

        for (Spinner eachSpinner : spinners){
            spinnerDataForPDF = spinnerDataForPDF + eachSpinner.getSelectedItem().toString() + "__XY__";
            //spinnerData = spinnerData + Integer.toString(eachSpinner.getSelectedItemPosition()) + "__XY__";

        }

        return spinnerDataForPDF;
    }

    //Getting Spinner position for selected Items
    public String getSwitchStatus (Switch... switches){

        switchData = "";

        for (Switch eachSwitch : switches){
            if (eachSwitch.isChecked()){
                switchData = switchData + "1" + "__XY__";
            }else {
                switchData = switchData + "0" + "__XY__";
            }
        }

        return switchData;
    }

    //Getting Spinner position for selected Items String Value for PDF printing
    public String getSwitchStatusForPDF (Switch... switches){

        String switchDataForPDF = "";

        for (Switch eachSwitch : switches){
            if (eachSwitch.isChecked()){
                switchDataForPDF = switchDataForPDF + eachSwitch.getTextOn() + "__XY__";
            }else {
                switchDataForPDF = switchDataForPDF + eachSwitch.getTextOff() + "__XY__";
            }
        }

        return switchDataForPDF;
    }

    //Putting spinners in saved position
    public void putSpinnerData(String[] seperatedSpinnerData, Spinner... spinners){
        boolean lenghtIsSame = (seperatedSpinnerData.length == spinners.length);
        if( lenghtIsSame ) {

            for (int i = 0; i < seperatedSpinnerData.length; i++) {
                spinners[i].setSelection(Integer.valueOf(seperatedSpinnerData[i]));
            }
        }
    }

    //Putting switches in saved position
    public void putSwitchData(String[] switchData, Switch... switches){
        Boolean lenghtIsSame = (switchData.length == switches.length);
        if( lenghtIsSame ) {

            for (int i = 0; i < switchData.length; i++) {
                if (switchData[i].matches("1")) switches[i].setChecked(true);
                else switches[i].setChecked(false);
            }
        }
    }

    public String[] seperateSwitchData(String switchData){
        String[] seperatedSwitchData = switchData.split("__XY__");
        return seperatedSwitchData;
    }

    public String[] seperateSpinnerData(String spinnerData){
        String[] seperatedSpinnerData = spinnerData.split("__XY__");
        return seperatedSpinnerData;
    }

    static public String specificCode(String string){

        String output;

        ZonedDateTime now = ZonedDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
        int weekNo = now.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
        Date date = new Date();
        LocalDate today = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int dayNo = today.getDayOfMonth();
        int monthNo = today.getMonthValue();
        int yearNo = today.getYear();
        String formattedDate = today.format(DateTimeFormatter. ofPattern("dd-MM-yyyy"));

        switch(string) {
            case "w": // For Weekly Code
                output = String.valueOf(weekNo) + "/" + String.valueOf(yearNo);
                break;
            case "fn": // For Fort Nightly Code
                int fortNightlyNo = dayNo / 15 + 1;
                output = String.valueOf(fortNightlyNo) + "/" + String.valueOf(monthNo) + "/" + String.valueOf(yearNo);
                break;
            case "m": // For Monthly Code
                output = String.valueOf(monthNo) + "/" + String.valueOf(yearNo);
                break;
            case "q": // For Quarterly Code
                int quarterNo = monthNo / 3 + 1;
                output = String.valueOf(quarterNo) + "/" + String.valueOf(yearNo);
                break;
            case "sm": // For Six Monthly Code
                int sixMonthNo = monthNo / 6 + 1;
                output = String.valueOf(sixMonthNo) + "/" + String.valueOf(yearNo);
                break;
            case "y": // For Yearly Code
                output = String.valueOf(yearNo);
                break;

            case "d":  // For daily Code
            default:
                output = formattedDate;
                break;
        }

        return output;
    }


}
