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

public class LlzThalesWeeklyActivity extends AppCompatActivity {

    private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
    private MySignature mySignature = new MySignature(this);
    private int selectedID;//Copy
    private String selectedName;//Copy
    private EditText[] editTextArray;//Copy
    private Switch[] switchArray;//Copy
    private Spinner[] spinnerArray = {};//Copy
    private String thisActivityName = "LlzThalesWeeklyActivity"; //Change Here as per your class name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llz_thales_weekly);


        //Define and Initialize all EditTexts serially here
        EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8,editText9, editText10, editText11, editText12, editText13, editText14, editText15, editText16, editText17, editText18,
                editText19, editText20, editText21, editText22, editText23, editText24,editText25, editText26, editText27, editText28, editText29, editText30, editText31, editText32, editText33, editText34, editText35, editText36,
                editText37, editText38, editText39, editText40, editText41, editText42, editText43, editText44, editText45, editText46, editText47, editText48, editText49, editText50, editText51, editText52, editText53, editText54,
                editText55, editText56, editText57, editText58,editText59, editText60,editText61, editText62,editText63, editText64, editText65, editText66, editText67, editText68,editText69, editText70, editText71, editText72,
                editText73, editText74, editText75, editText76, editText77, editText78, editText79, editText80, editText81, editText82, editText83, editText84, editText85, editText86, editText87, editText88,editText89,editText90,
                editText91, editText92, editText93, editText94,editText95, editText96, editText97, editText98,editText99, editText100, editText101, editText102, editText103, editText104, editText105, editText106, editText107, editText108,
                editText109, editText110, editText111, editText112, editText113, editText114, editText115, editText116, editText117, editText118, editText119, editText120, editText121, editText122, editText123, editText124,editText125,
                editText126, editText127, editText128, editText129, editText130, editText131, editText132, editText133, editText134, editText135, editText136, editText137, editText138, editText139, editText140, editText141, editText142,
                editText143, editText144, editText145, editText146, editText147, editText148, editText149, editText150, editText151, editText152, editText153, editText154, editText155, editText156, editText157, editText158,editText159,
                editText160,editText161, editText162,editText163, editText164, editText165, editText166, editText167;

        editTextArray = new EditText[]{
                editText1 = (EditText)  findViewById(R.id.editTextLlzThalesWeeklyStation),
                editText2 = (EditText)  findViewById(R.id.editTextLlzThalesWeeklyRWY),
                editText3 = (EditText)  findViewById(R.id.editTextLlzThalesWeeklyCat),
                editText4 = (EditText)  findViewById(R.id.editTextLlzThalesWeeklyFrequency),
                editText5 = (EditText)  findViewById(R.id.editTextLlzThalesWeeklyIdent),
                editText6 = (EditText)  findViewById(R.id.editTextLlzThalesWeeklyTimeObs),
                editText7 = (EditText)  findViewById(R.id.editTextLlzThalesWeeklyTime),
                editText8 = (EditText)  findViewById(R.id.editTextLlzThalesWeeklyCRSSDM1),
                editText9 = (EditText)  findViewById(R.id.editTextLlzThalesWeeklyCRSSDM2),
                editText10 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyCRS901),
                editText11 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyCRS902),
                editText12 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyCRS1501),
                editText13 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyCRS1502),
                editText14 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyCRS10201),
                editText15 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyCRS10202),
                editText16 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyCLRSDM1),
                editText17 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyCLRSDM2),
                editText18 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyCLR901),
                editText19 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyCLR902),
                editText20 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyCLR1501),
                editText21 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyCLR1502),
                editText22 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyCLR10201),
                editText23 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyCLR10202),
                editText24 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyCourseTx1),
                editText25 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyCourseTx2),
                editText26 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyCourseShiftTx1),
                editText27 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyCourseShiftTx2),
                editText28 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyDisSenTx1),
                editText29 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyDisSenTx2),
                editText30 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyCLRSigTx1),
                editText31 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyCLRSigTx2),
                editText32 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyRedPowerTx1),
                editText33 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyRedPowerTx2),
                editText34 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTotalTimeTx1),
                editText35 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTotalTimeTx2),
                editText36 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyDC51),
                editText37 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyDC52),
                editText38 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyDC151),
                editText39 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyDC152),
                editText40 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyDC15V1),
                editText41 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyDC15V2),
                editText42 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyDC241),
                editText43 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyDC242),
                editText44 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyDC541),
                editText45 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyDC542),
                editText46 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyBatt),

                editText47 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCRSCSBFWD1),
                editText48 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTxACRSCSBFWD),
                editText49 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCRSCSBFWD2),
                editText50 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTxBCRSCSBFWD),
                editText51 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCRSCSBVSWR1),
                editText52 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTxACRSCSBVSWR),
                editText53 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCRSCSBVSWR2),
                editText54 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTxBCRSCSBVSWR),
                editText55 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCRSSBOFWD1),
                editText56 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTxACRSSBOFWD),
                editText57 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCRSSBOFWD2),
                editText58 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTxBCRSSBOFWD),
                editText59 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCRSSBOVSWR1),
                editText60 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTxACRSSBOVSWR),
                editText61 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCRSSBOVSWR2),
                editText62 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTxBCRSSBOVSWR),
                editText63 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCRSDC1),
                editText64 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTxACRSDC),
                editText65 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCRSDC2),
                editText66 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTxBCRSDC),
                editText67 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCRSDDM1),
                editText68 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTxACRSDDM),
                editText69 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCRSDDM2),
                editText70 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTxBCRSDDM),
                editText71 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCRSSDM1),
                editText72 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTxACRSSDM),
                editText73 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCRSSDM2),
                editText74 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTxBCRSSDM),
                editText75 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCRSSig1),
                editText76 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTxACRSSig),
                editText77 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCRSSig2),
                editText78 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTxBCRSSig),
                editText79 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCLRCSBFWD1),
                editText80 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTxACLRCSBFWD),
                editText81 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCLRCSBFWD2),
                editText82 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTxBCLRCSBFWD),
                editText83 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCLRCSBVSWR1),
                editText84 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTxACLRCSBVSWR),
                editText85 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCLRCSBVSWR2),
                editText86 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTxBCLRCSBVSWR),
                editText87 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCLRSBOFWD1),
                editText88 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTxACLRSBOFWD),
                editText89 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCLRSBOFWD2),
                editText90 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTxBCLRSBOFWD),
                editText91 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCLRSBOVSWR1),
                editText92 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTxACLRSBOVSWR),
                editText93 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCLRSBOVSWR2),
                editText94 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTxBCLRSBOVSWR),
                editText95 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCLRDC1),
                editText96 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTxACLRDC),
                editText97 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCLRDC2),
                editText98 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTxBCLRDC),
                editText99 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCLRDDM1),
                editText100 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTxACLRDDM),
                editText101 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCLRDDM2),
                editText102 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTxBCLRDDM),
                editText103 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCLRSDM1),
                editText104 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTxACLRSDM),
                editText105 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCLRSDM2),
                editText106 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTxBCLRSDM),
                editText107 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCLRSig1),
                editText108 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTxACLRSig),
                editText109 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCLRSig2),
                editText110 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTxBCLRSig),

                editText111 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCRSRF1),
                editText112 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTx1CRSRF),
                editText113 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCRSRF2),
                editText114 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTx2CRSRF),
                editText115 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCRS1DDM1),
                editText116 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTx1CRS1DDM),
                editText117 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCRS1DDM2),
                editText118 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTx2CRS1DDM),
                editText119 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCRS1SDM1),
                editText120 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTx1CRS1SDM),
                editText121 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCRS1SDM2),
                editText122 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTx2CRS1SDM),
                editText123 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCRS901),
                editText124 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTx1CRS90),
                editText125 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCRS902),
                editText126 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTx2CRS90),
                editText127 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCRS1501),
                editText128 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTx1CRS150),
                editText129 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCRS1502),
                editText130 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTx2CRS150),
                editText131 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCRSSBOI1),
                editText132 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTx1CRSSBOI),
                editText133 = (EditText)  findViewById(R.id.editTextLlzThalesWeeklyNmlCRSSBOI2),
                editText134 = (EditText)  findViewById(R.id.editTextLlzThalesWeeklyTx2CRSSBOI),
                editText135 = (EditText)  findViewById(R.id.editTextLlzThalesWeeklyNmlCRSSBOQ1),
                editText136 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTx1CRSSBOQ),
                editText137 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCRSSBOQ2),
                editText138 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTx2CRSSBOQ),
                editText139 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCLRRF1),
                editText140 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTx1CLRRF),
                editText141 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCLRRF2),
                editText142 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTx2CLRRF),
                editText143 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCLR1DDM1),
                editText144 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTx1CLR1DDM1),
                editText145 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCLR1DDM2),
                editText146 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTx2CLR1DDM),
                editText147 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCLR1SDM1),
                editText148 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTx1CLR1SDM),
                editText149 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCLR1SDM2),
                editText150 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTx2CLR1SDM),
                editText151 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCLR901),
                editText152 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTx1CLR90),
                editText153 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCLR902),
                editText154 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTx2CLR90),
                editText155 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCLR1501),
                editText156 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTx1CLR150),
                editText157 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCLR1502),
                editText158 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTx2CLR150),
                editText159 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCLR2I1),
                editText160 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTx1CLR2I),
                editText161 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCLR2I2),
                editText162 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTx2CLR2I),
                editText163 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCLR2Q1),
                editText164 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTx1CLR2Q),
                editText165 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyNmlCLR2Q2),
                editText166 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyTx2CLR2Q),
                editText167 = (EditText) findViewById(R.id.editTextLlzThalesWeeklyRemarks)};

        //Define and Initialize all Switches serially here
        Switch  switch1,switch2;
        switchArray = new Switch[]{
                switch1 = (Switch) findViewById(R.id.switchLlzThalesWeeklyEquipHolds),
                switch2 = (Switch) findViewById(R.id.switchLlzThalesWeeklyChangeOver)};

        //Define and Initialize all Spinners serially here
//        Spinner spinner1,spinner2,spinner3,spinner4,spinner5,spinner6,spinner7,spinner8,spinner9;
//        spinnerArray = new Spinner[]{
//                spinner9 = (Spinner) findViewById(R.id.spinner9),
//                spinner6 = (Spinner) findViewById(R.id.spinner6),
//                spinner8 = (Spinner) findViewById(R.id.spinner8),
//                spinner5 = (Spinner) findViewById(R.id.spinner5),
//                spinner7 = (Spinner) findViewById(R.id.spinner7),
//                spinner4 = (Spinner) findViewById(R.id.spinner4),
//                spinner3 = (Spinner) findViewById(R.id.spinner3),
//                spinner2 = (Spinner) findViewById(R.id.spinner2),
//                spinner1 = (Spinner) findViewById(R.id.spinner1)};

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

        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.llzthalesweekly1);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);

        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(12);

        int[] editTextXPixel = {121,97,206,315,446,485,485,435,515,435,515,435,515,435,515,435,515,435,515,435,515,435,515,435,515,435,515,
                435,515,435,515,435,515,435,515,430,510,430,510};
        int[] editTextYPixel = {138,163,163,163,163,259,280,322,322,343,343,364,364,386,386,406,406,429,429,449,449,470,470,500,500,580,580,
                635,635,685,685,752,752,807,807,885,885,904,904};



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

        canvas.drawText(strData,555,163,titlePaint);//Printing Date on PDF

        myPdfdocument.finishPage(myPage1);


        //---------------------End of Page 1---------------

        //----------------------Page 2---------------------

        PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(723, 1024, 2).create();

        // start a page
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);

        canvas = myPage2.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.llzthalesweekly2);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel2 = {430,510,430,510,430,510,480,230,335,435,545,230,335,435,545,230,335,435,545,230,335,435,545,230,335,435,545,230,335,435,545,230,335,435,545,
                230,335,435,545,230,335,435,545,230,335,435,545,230,335,435,545,230,335,435,545,230,335,435,545,230,335,435,545,230,335,435,545,230,335,435,545};
        int[] editTextYPixel2 = {130,130,145,145,167,167,193,396,396,396,396,420,420,420,420,445,445,445,445,470,470,470,470,495,495,495,495,520,520,520,520,543,543,543,543,
                570,570,570,570,597,597,597,597,622,622,622,622,645,645,645,645,670,670,670,670,695,695,695,695,720,720,720,720,744,744,744,744,775,775,775,775};

        int[] switchXPixel = {525,525};
        int[] switchYPixel = {222,275};


        for(int i = 0; i < editTextXPixel2.length; i++){
            canvas.drawText( editTextDataForPDF[i+39],editTextXPixel2[i],editTextYPixel2[i],titlePaint);
        }
        for(int i = 0; i < switchXPixel.length; i++){
            canvas.drawText( switchDataForPDF[i],switchXPixel[i],switchYPixel[i],titlePaint);
        }
        myPdfdocument.finishPage(myPage2);

        //-------------------------End of Page 2-----------------
        //----------------------Page 3---------------------

        PdfDocument.PageInfo myPageInfo3 = new PdfDocument.PageInfo.Builder(723, 1024, 3).create();

        // start a page
        PdfDocument.Page myPage3 = myPdfdocument.startPage(myPageInfo3);

        canvas = myPage3.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.llzthalesweekly3);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel3 = {225,340,435,530,225,340,435,530,225,340,435,530,225,340,435,530,225,340,435,530,225,340,435,530,225,340,435,530,
                225,340,435,530,225,340,435,530,225,340,435,530,225,340,435,530,225,340,435,530,225,340,435,530,225,340,435,530,160};
        int[] editTextYPixel3 = {118,118,118,118,146,146,146,146,173,173,173,173,200,200,200,200,227,227,227,227,255,255,255,255,280,280,280,280,
                308,308,308,308,336,336,336,336,365,365,365,365,392,392,392,392,418,418,418,418,446,446,446,446,473,473,473,473,559};


        for(int i = 0; i < editTextXPixel3.length; i++){
            canvas.drawText( editTextDataForPDF[i+110],editTextXPixel3[i],editTextYPixel3[i],titlePaint);
        }

        titlePaint.setTextSize(12);
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 70, 610, paint);

        myPdfdocument.finishPage(myPage3);

        //-------------------------End of Page 3-----------------


        ActivityCompat.requestPermissions(this, new String[]{

                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Navigation/LLZthales/Weekly/";// Change Here------------------
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //String targetPdf = directory_path + "test.pdf";
        //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
        String fileName = "Weekly LLZ Thales " + strData + ".pdf"; // Change Here--------------------------
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
                "Weekly Maintenance of Thales LLZ done.",//Change Here-----------------------------
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