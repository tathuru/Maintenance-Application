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

public class VhfTxOteSixActivity extends AppCompatActivity {

    private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
    private MySignature mySignature = new MySignature(this);
    private int selectedID;//Copy
    private String selectedName;//Copy
    private EditText[] editTextArray;//Copy
    private Switch[] switchArray = {};//Copy
    private Spinner[] spinnerArray = {};//Copy
    private String thisActivityName = "VhfTxOteSixActivity"; //Change Here as per your class name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vhf_tx_ote_six);

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
                editText1 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyStation),
                editText2 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyRegion),
                editText3 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTx1),
                editText4 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTx2),
                editText5 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTx3),
                editText6 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTx4),
                editText7 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTx5),
                editText8 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTx6),
                editText9 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyFreq1),
                editText10 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyFreq2),
                editText11 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyFreq3),
                editText12 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyFreq4),
                editText13 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyFreq5),
                editText14 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyFreq6),
                editText15 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyLoc1),
                editText16 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyLoc2),
                editText17 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyLoc3),
                editText18 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyLoc4),
                editText19 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyLoc5),
                editText20 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyLoc6),
                editText21 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyClean1),
                editText22 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyClean2),
                editText23 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyClean3),
                editText24 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyClean4),
                editText25 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyClean5),
                editText26 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyClean6),
                editText27 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyPowerModule1),
                editText28 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyPowerModule2),
                editText29 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyPowerModule3),
                editText30 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyPowerModule4),
                editText31 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyPowerModule5),
                editText32 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyPowerModule6),
                editText33 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTxModule1),
                editText34 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTxModule2),
                editText35 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTxModule3),
                editText36 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTxModule4),
                editText37 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTxModule5),
                editText38 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTxModule6),
                editText39 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyBase1),
                editText40 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyBase2),
                editText41 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyBase3),
                editText42 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyBase4),
                editText43 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyBase5),
                editText44 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyBase6),
                editText45 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyCP1),
                editText46 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyCP2),
                editText47 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyCP3),
                editText48 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyCP4),
                editText49 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyCP5),
                editText50 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyCP6),
                editText51 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyRefOsc1),
                editText52 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyRefOsc2),
                editText53 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyRefOsc3),
                editText54 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyRefOsc4),
                editText55 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyRefOsc5),
                editText56 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyRefOsc6),
                editText57 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyFrw1),
                editText58 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyFrw2),
                editText59 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyFrw3),
                editText60 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyFrw4),
                editText61 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyFrw5),
                editText62 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyFrw6),
                editText63 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyRef1),
                editText64 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyRef2),
                editText65 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyRef3),
                editText66 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyRef4),
                editText67 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyRef5),
                editText68 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyRef6),
                editText69 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyMod1),
                editText70 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyMod2),
                editText71 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyMod3),
                editText72 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyMod4),
                editText73 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyMod5),
                editText74 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyMod6),
                editText75 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTemp1),
                editText76 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTemp2),
                editText77 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTemp3),
                editText78 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTemp4),
                editText79 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTemp5),
                editText80 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTemp6),
                editText81 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyPhyChk1),
                editText82 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyPhyChk2),
                editText83 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyPhyChk3),
                editText84 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyPhyChk4),
                editText85 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyPhyChk5),
                editText86 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyPhyChk6),
                editText87 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTxStatus1),
                editText88 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTxStatus2),
                editText89 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTxStatus3),
                editText90 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTxStatus4),
                editText91 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTxStatus5),
                editText92 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTxStatus6),
                editText93 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyWrk1),
                editText94 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyWrk2),
                editText95 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyWrk3),
                editText96 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyWrk4),
                editText97 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyWrk5),
                editText98 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyWrk6),
                editText99 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyRemarks1),
                editText100 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTx7),
                editText101 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTx8),
                editText102 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTx9),
                editText103 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTx10),
                editText104 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTx11),
                editText105 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTx12),
                editText106 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyFreq7),
                editText107 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyFreq8),
                editText108 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyFreq9),
                editText109 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyFreq10),
                editText110 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyFreq11),
                editText111 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyFreq12),
                editText112 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyLoc7),
                editText113 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyLoc8),
                editText114 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyLoc9),
                editText115 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyLoc10),
                editText116 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyLoc11),
                editText117 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyLoc12),
                editText118 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyClean7),
                editText119 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyClean8),
                editText120 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyClean9),
                editText121 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyClean10),
                editText122 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyClean11),
                editText123 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyClean12),
                editText124 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyPowerModule7),
                editText125 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyPowerModule8),
                editText126 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyPowerModule9),
                editText127 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyPowerModule10),
                editText128 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyPowerModule11),
                editText129 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyPowerModule12),
                editText130 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTxModule7),
                editText131 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTxModule8),
                editText132 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTxModule9),
                editText133 = (EditText)  findViewById(R.id.editTextVhfTxOteSixmonthlyTxModule10),
                editText134 = (EditText)  findViewById(R.id.editTextVhfTxOteSixmonthlyTxModule11),
                editText135 = (EditText)  findViewById(R.id.editTextVhfTxOteSixmonthlyTxModule12),
                editText136 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyBase7),
                editText137 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyBase8),
                editText138 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyBase9),
                editText139 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyBase10),
                editText140 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyBase11),
                editText141 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyBase12),
                editText142 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyCP7),
                editText143 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyCP8),
                editText144 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyCP9),
                editText145 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyCP10),
                editText146 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyCP11),
                editText147 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyCP12),
                editText148 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyRefOsc7),
                editText149 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyRefOsc8),
                editText150 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyRefOsc9),
                editText151 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyRefOsc10),
                editText152 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyRefOsc11),
                editText153 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyRefOsc12),
                editText154 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyFrw7),
                editText155 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyFrw8),
                editText156 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyFrw9),
                editText157 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyFrw10),
                editText158 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyFrw11),
                editText159 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyFrw12),
                editText160 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyRef7),
                editText161 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyRef8),
                editText162 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyRef9),
                editText163 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyRef10),
                editText164 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyRef11),
                editText165 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyRef12),
                editText166 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyMod7),
                editText167 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyMod8),
                editText168 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyMod9),
                editText169 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyMod10),
                editText170 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyMod11),
                editText171 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyMod12),
                editText172 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTemp7),
                editText173 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTemp8),
                editText174 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTemp9),
                editText175 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTemp10),
                editText176 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTemp11),
                editText177 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTemp12),
                editText178 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyPhyChk7),
                editText179 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyPhyChk8),
                editText180 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyPhyChk9),
                editText181 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyPhyChk10),
                editText182 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyPhyChk11),
                editText183 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyPhyChk12),
                editText184 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTxStatus7),
                editText185 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTxStatus8),
                editText186 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTxStatus9),
                editText187 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTxStatus10),
                editText188 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTxStatus11),
                editText189 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyTxStatus12),
                editText190 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyWrk7),
                editText191 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyWrk8),
                editText192 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyWrk9),
                editText193 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyWrk10),
                editText194 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyWrk11),
                editText195 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyWrk12),
                editText196 = (EditText) findViewById(R.id.editTextVhfTxOteSixmonthlyRemarks2)};

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

        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.vhftxotesix1);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);

        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(12);

        int[] editTextXPixel = {165,520,365,420,475,530,584,640,365,420,475,530,584,640,365,420,475,530,584,640,365,420,475,530,584,640,
                365,420,475,530,584,640,365,420,475,530,584,640,365,420,475,530,584,640,365,420,475,530,584,640,365,420,475,530,584,640,
                365,420,475,530,584,640,365,420,475,530,584,640,365,420,475,530,584,640,365,420,475,530,584,640,365,420,475,530,584,640,
                365,420,475,530,584,640,365,420,475,530,584,640,234};
        int[] editTextYPixel = {180,180,240,240,240,240,240,240,267,267,267,267,267,267,300,300,300,300,300,300,350,350,350,350,350,350,
                386,386,386,386,386,386,420,420,420,420,420,420,450,450,450,450,450,450,483,483,483,483,483,483,518,518,518,518,518,518,
                585,585,585,585,585,585,630,630,630,630,630,630,648,648,648,648,648,648,666,666,666,666,666,666,688,688,688,688,688,688,
                728,728,728,728,728,728,762,762,762,762,762,762,782};



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

        canvas.drawText(strData,510,204,titlePaint);//Printing Date on PDF

        myPdfdocument.finishPage(myPage1);


        //---------------------End of Page 1---------------

        //----------------------Page 2---------------------

        PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(723, 1024, 2).create();

        // start a page
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);

        canvas = myPage2.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.vhftxotesix2);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel2 = {366,420,475,530,584,640,366,420,475,530,584,640,366,420,475,530,584,640,366,420,475,530,584,640,
                366,420,475,530,584,640,366,420,475,530,584,640,366,420,475,530,584,640,366,420,475,530,584,640,366,420,475,530,584,640,
                366,420,475,530,584,640,366,420,475,530,584,640,366,420,475,530,584,640,366,420,475,530,584,640,366,420,475,530,584,640,
                366,420,475,530,584,640,366,420,475,530,584,640,232};
        int[] editTextYPixel2 = {113,113,113,113,113,113,140,140,140,140,140,140,172,172,172,172,172,172,222,222,222,222,222,222,
                260,260,260,260,260,260,293,293,293,293,293,293,323,323,323,323,323,323,354,354,354,354,354,354,390,390,390,390,390,390,
                455,455,455,455,455,455,502,502,502,502,502,502,521,521,521,521,521,521,538,538,538,538,538,538,565,565,565,565,565,565,
                600,600,600,600,600,600,635,635,635,635,635,635,655};



        for(int i = 0; i < editTextXPixel2.length; i++){
            canvas.drawText( editTextDataForPDF[i+99],editTextXPixel2[i],editTextYPixel2[i],titlePaint);
        }


        titlePaint.setTextSize(12);
        paint.setTextAlign(Paint.Align.LEFT);

        canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 75, 725, paint);

        myPdfdocument.finishPage(myPage2);

        //-------------------------End of Page 2-----------------



        ActivityCompat.requestPermissions(this, new String[]{

                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Communication/VHFTxOte/Six Monthly/";// Change Here------------------
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //String targetPdf = directory_path + "test.pdf";
        //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
        String fileName = "Six Monthly VHF TX OTE " + strData + ".pdf"; // Change Here--------------------------
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
        myFunctions.saveToParse(targetPdf, fileName,"VHF","Six Monthly",outputEditText,MyFunctions.specificCode("sm"),"outputSwitch", "outputSpinner");// Change Here-----------------------

        // This function will send eMail using JavaMailAPI
        //myFunctions.sendEmail(String To, String Subject, String Message,String targetPdf,String desired_Filename)
        myFunctions.sendEmail(PersonalDetailsActivity.emailTo + "@aai.aero",
                "Six Monthly Maintenance of Ote VHF Tx done.",//Change Here-----------------------------
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