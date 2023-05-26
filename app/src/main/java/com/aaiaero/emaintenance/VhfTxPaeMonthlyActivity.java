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

public class VhfTxPaeMonthlyActivity extends AppCompatActivity {
    private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
    private MySignature mySignature = new MySignature(this);
    private int selectedID;//Copy
    private String selectedName;//Copy
    private EditText[] editTextArray;//Copy
    private Switch[] switchArray={};//Copy
    private Spinner[] spinnerArray={};//Copy
    private String thisActivityName = "VhfTxPaeMonthlyActivity"; //Change Here as per your class name


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vhf_tx_pae_monthly);

        //Define and Initialize all EditTexts serially here
        EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8,editText9, editText10, editText11, editText12, editText13, editText14, editText15, editText16, editText17, editText18, editText19, editText20,
                editText21, editText22, editText23, editText24,editText25, editText26, editText27, editText28, editText29, editText30, editText31, editText32, editText33, editText34, editText35, editText36, editText37, editText38, editText39, editText40,
                editText41, editText42, editText43, editText44, editText45, editText46, editText47, editText48, editText49, editText50, editText51, editText52, editText53, editText54, editText55, editText56, editText57, editText58,editText59, editText60,
                editText61, editText62,editText63, editText64, editText65, editText66, editText67, editText68,editText69, editText70, editText71, editText72, editText73, editText74, editText75, editText76, editText77, editText78, editText79, editText80,
                editText81, editText82, editText83, editText84, editText85, editText86, editText87, editText88,editText89,editText90, editText91, editText92, editText93, editText94,editText95, editText96, editText97, editText98,editText99, editText100,
                editText101, editText102, editText103, editText104, editText105, editText106, editText107, editText108, editText109, editText110, editText111, editText112, editText113, editText114, editText115, editText116, editText117, editText118, editText119,
                editText120, editText121, editText122, editText123, editText124,editText125, editText126, editText127, editText128, editText129, editText130, editText131, editText132, editText133, editText134, editText135, editText136, editText137, editText138,
                editText139, editText140, editText141, editText142, editText143, editText144, editText145, editText146, editText147, editText148, editText149, editText150, editText151, editText152, editText153, editText154, editText155, editText156, editText157,
                editText158,editText159, editText160,editText161, editText162,editText163, editText164, editText165, editText166, editText167, editText168,editText169, editText170, editText171, editText172, editText173, editText174, editText175, editText176, editText177,
                editText178, editText179, editText180, editText181, editText182, editText183, editText184, editText185, editText186, editText187, editText188,editText189,editText190, editText191, editText192, editText193, editText194,editText195, editText196;

        editTextArray = new EditText[]{
                editText1 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyStation),
                editText2 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyRegion),
                editText3 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyTx1),
                editText4 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyTx2),
                editText5 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyTx3),
                editText6 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyTx4),
                editText7 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyTx5),
                editText8 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyTx6),
                editText9 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyFreq1),
                editText10 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyFreq2),
                editText11 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyFreq3),
                editText12 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyFreq4),
                editText13 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyFreq5),
                editText14 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyFreq6),
                editText15 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPowerFwd1),
                editText16 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPowerFwd2),
                editText17 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPowerFwd3),
                editText18 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPowerFwd4),
                editText19 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPowerFwd5),
                editText20 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPowerFwd6),
                editText21 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPowerRefl1),
                editText22 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPowerRefl2),
                editText23 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPowerRefl3),
                editText24 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPowerRefl4),
                editText25 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPowerRefl5),
                editText26 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPowerRefl6),
                editText27 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyLineIP1),
                editText28 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyLineIP2),
                editText29 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyLineIP3),
                editText30 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyLineIP4),
                editText31 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyLineIP5),
                editText32 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyLineIP6),
                editText33 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyInhibit1),
                editText34 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyInhibit2),
                editText35 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyInhibit3),
                editText36 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyInhibit4),
                editText37 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyInhibit5),
                editText38 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyInhibit6),
                editText39 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyTimeout1),
                editText40 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyTimeout2),
                editText41 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyTimeout3),
                editText42 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyTimeout4),
                editText43 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyTimeout5),
                editText44 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyTimeout6),
                editText45 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyModDepth1),
                editText46 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyModDepth2),
                editText47 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyModDepth3),
                editText48 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyModDepth4),
                editText49 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyModDepth5),
                editText50 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyModDepth6),
                editText51 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyVogad1),
                editText52 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyVogad2),
                editText53 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyVogad3),
                editText54 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyVogad4),
                editText55 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyVogad5),
                editText56 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyVogad6),
                editText57 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyKey1),
                editText58 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyKey2),
                editText59 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyKey3),
                editText60 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyKey4),
                editText61 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyKey5),
                editText62 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyKey6),
                editText63 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyReady1),
                editText64 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyReady2),
                editText65 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyReady3),
                editText66 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyReady4),
                editText67 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyReady5),
                editText68 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyReady6),
                editText69 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPPTIP1),
                editText70 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPPTIP2),
                editText71 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPPTIP3),
                editText72 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPPTIP4),
                editText73 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPPTIP5),
                editText74 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPPTIP6),
                editText75 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPhanPPT1),
                editText76 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPhanPPT2),
                editText77 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPhanPPT3),
                editText78 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPhanPPT4),
                editText79 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPhanPPT5),
                editText80 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPhanPPT6),
                editText81 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPPTRef1),
                editText82 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPPTRef2),
                editText83 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPPTRef3),
                editText84 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPPTRef4),
                editText85 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPPTRef5),
                editText86 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPPTRef6),
                editText87 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPPTop1),
                editText88 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPPTop2),
                editText89 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPPTop3),
                editText90 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPPTop4),
                editText91 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPPTop5),
                editText92 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPPTop6),
                editText93 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyBit1),
                editText94 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyBit2),
                editText95 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyBit3),
                editText96 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyBit4),
                editText97 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyBit5),
                editText98 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyBit6),
                editText99 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyRemarks1),
                editText100 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyTx7),
                editText101 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyTx8),
                editText102 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyTx9),
                editText103 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyTx10),
                editText104 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyTx11),
                editText105 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyTx12),
                editText106 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyFreq7),
                editText107 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyFreq8),
                editText108 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyFreq9),
                editText109 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyFreq10),
                editText110 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyFreq11),
                editText111 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyFreq12),
                editText112 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPowerFwd7),
                editText113 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPowerFwd8),
                editText114 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPowerFwd9),
                editText115 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPowerFwd10),
                editText116 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPowerFwd11),
                editText117 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPowerFwd12),
                editText118 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPowerRefl7),
                editText119 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPowerRefl8),
                editText120 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPowerRefl9),
                editText121 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPowerRefl10),
                editText122 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPowerRefl11),
                editText123 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPowerRefl12),
                editText124 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyLineIP7),
                editText125 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyLineIP8),
                editText126 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyLineIP9),
                editText127 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyLineIP10),
                editText128 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyLineIP11),
                editText129 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyLineIP12),
                editText130 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyInhibit7),
                editText131 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyInhibit8),
                editText132 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyInhibit9),
                editText133 = (EditText)  findViewById(R.id.editTextVhfTxPaeMonthlyInhibit10),
                editText134 = (EditText)  findViewById(R.id.editTextVhfTxPaeMonthlyInhibit11),
                editText135 = (EditText)  findViewById(R.id.editTextVhfTxPaeMonthlyInhibit12),
                editText136 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyTimeout7),
                editText137 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyTimeout8),
                editText138 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyTimeout9),
                editText139 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyTimeout10),
                editText140 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyTimeout11),
                editText141 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyTimeout12),
                editText142 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyModDepth7),
                editText143 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyModDepth8),
                editText144 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyModDepth9),
                editText145 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyModDepth10),
                editText146 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyModDepth11),
                editText147 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyModDepth12),
                editText148 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyVogad7),
                editText149 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyVogad8),
                editText150 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyVogad9),
                editText151 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyVogad10),
                editText152 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyVogad11),
                editText153 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyVogad12),
                editText154 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyKey7),
                editText155 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyKey8),
                editText156 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyKey9),
                editText157 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyKey10),
                editText158 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyKey11),
                editText159 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyKey12),
                editText160 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyReady7),
                editText161 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyReady8),
                editText162 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyReady9),
                editText163 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyReady10),
                editText164 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyReady11),
                editText165 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyReady12),
                editText166 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPPTIP7),
                editText167 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPPTIP8),
                editText168 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPPTIP9),
                editText169 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPPTIP10),
                editText170 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPPTIP11),
                editText171 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPPTIP12),
                editText172 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPhanPPT7),
                editText173 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPhanPPT8),
                editText174 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPhanPPT9),
                editText175 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPhanPPT10),
                editText176 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPhanPPT11),
                editText177 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPhanPPT12),
                editText178 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPPTRef7),
                editText179 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPPTRef8),
                editText180 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPPTRef9),
                editText181 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPPTRef10),
                editText182 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPPTRef11),
                editText183 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPPTRef12),
                editText184 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPPTop7),
                editText185 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPPTop8),
                editText186 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPPTop9),
                editText187 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPPTop10),
                editText188 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPPTop11),
                editText189 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyPPTop12),
                editText190 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyBit7),
                editText191 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyBit8),
                editText192 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyBit9),
                editText193 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyBit10),
                editText194 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyBit11),
                editText195 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyBit12),
                editText196 = (EditText) findViewById(R.id.editTextVhfTxPaeMonthlyRemarks2)};

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

        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.vhftxpaemonthly1);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);

        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(12);

        int[] editTextXPixel = {165,523,325,386,447,506,568,628,325,386,447,506,568,628,325,386,447,506,568,628,325,386,447,506,568,628,
                325,386,447,506,568,628,325,386,447,506,568,628,325,386,447,506,568,628,325,386,447,506,568,628,325,386,447,506,568,628,
                325,386,447,506,568,628,325,386,447,506,568,628,325,386,447,506,568,628,325,386,447,506,568,628,325,386,447,506,568,628,
                325,386,447,506,568,628,325,386,447,506,568,628,191};
        int[] editTextYPixel = {150,150,220,220,220,220,220,220,248,248,248,248,248,248,293,293,293,293,293,293,321,321,321,321,321,321,
                351,351,351,351,351,351,378,378,378,378,378,378,404,404,404,404,404,404,430,430,430,430,430,430,459,459,459,459,459,459,
                490,490,490,490,490,490,542,542,542,542,542,542,568,568,568,568,568,568,597,597,597,597,597,597,626,626,626,626,626,626,
                660,660,660,660,660,660,686,686,686,686,686,686,709};



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

        canvas.drawText(strData,512,175,titlePaint);//Printing Date on PDF

        myPdfdocument.finishPage(myPage1);


        //---------------------End of Page 1---------------

        //----------------------Page 2---------------------

        PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(723, 1024, 2).create();

        // start a page
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);

        canvas = myPage2.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.vhftxpaemonthly2);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel2 = {326,387,448,507,568,627,326,387,448,507,568,627,326,387,448,507,568,627,326,387,448,507,568,627,
                326,387,448,507,568,627,326,387,448,507,568,627,326,387,448,507,568,627,326,387,448,507,568,627,326,387,448,507,568,627,
                326,387,448,507,568,627,326,387,448,507,568,627,326,387,448,507,568,627,326,387,448,507,568,627,326,387,448,507,568,627,
                326,387,448,507,568,627,326,387,448,507,568,627,192};
        int[] editTextYPixel2 = {116,116,116,116,116,116,142,142,142,142,142,142,190,190,190,190,190,190,218,218,218,218,218,218,
                245,245,245,245,245,245,273,273,273,273,273,273,300,300,300,300,300,300,330,330,330,330,330,330,355,355,355,355,355,355,
                390,390,390,390,390,390,439,439,439,439,439,439,468,468,468,468,468,468,495,495,495,495,495,495,523,523,523,523,523,523,
                558,558,558,558,558,558,584,584,584,584,584,584,605};



        for(int i = 0; i < editTextXPixel2.length; i++){
            canvas.drawText( editTextDataForPDF[i+99],editTextXPixel2[i],editTextYPixel2[i],titlePaint);
        }


        titlePaint.setTextSize(12);
        paint.setTextAlign(Paint.Align.LEFT);

        canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 75, 644, paint);

        myPdfdocument.finishPage(myPage2);

        //-------------------------End of Page 2-----------------



        ActivityCompat.requestPermissions(this, new String[]{

                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Communication/VHFTxPae/Monthly/";// Change Here------------------
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //String targetPdf = directory_path + "test.pdf";
        //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
        String fileName = "Monthly VHF TX PAE " + strData + ".pdf"; // Change Here--------------------------
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
        myFunctions.saveToParse(targetPdf, fileName,"VHF","Monthly",outputEditText,MyFunctions.specificCode("m"),"outputSwitch", "outputSpinner");// Change Here-----------------------

        // This function will send eMail using JavaMailAPI
        //myFunctions.sendEmail(String To, String Subject, String Message,String targetPdf,String desired_Filename)
        myFunctions.sendEmail(PersonalDetailsActivity.emailTo + "@aai.aero",
                "Monthly Maintenance of Pae VHF Tx done.",//Change Here-----------------------------
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