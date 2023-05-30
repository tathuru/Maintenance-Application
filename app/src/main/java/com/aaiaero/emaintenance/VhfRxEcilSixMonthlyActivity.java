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

public class VhfRxEcilSixMonthlyActivity extends AppCompatActivity {
    private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
    private MySignature mySignature = new MySignature(this);
    private int selectedID;//Copy
    private String selectedName;//Copy
    private EditText[] editTextArray;//Copy
    private Switch[] switchArray = {};//Copy
    private Spinner[] spinnerArray = {};//Copy
    private String thisActivityName = "VhfRxEcilSixmONTHLYActivity"; //Change Here as per your class name
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vhf_rx_ecil_six_monthly);


        //Define and Initialize all EditTexts serially here
        EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8, editText9, editText10, editText11, editText12, editText13, editText14, editText15, editText16, editText17, editText18, editText19, editText20,
                editText21, editText22, editText23, editText24, editText25, editText26, editText27, editText28, editText29, editText30, editText31, editText32, editText33, editText34, editText35, editText36, editText37, editText38, editText39, editText40,
                editText41, editText42, editText43, editText44, editText45, editText46, editText47, editText48, editText49, editText50, editText51, editText52, editText53, editText54, editText55, editText56, editText57, editText58, editText59, editText60,
                editText61, editText62, editText63, editText64, editText65, editText66, editText67, editText68, editText69, editText70, editText71, editText72, editText73, editText74, editText75, editText76, editText77, editText78, editText79, editText80,
                editText81, editText82, editText83, editText84, editText85, editText86, editText87, editText88, editText89, editText90, editText91, editText92, editText93, editText94, editText95, editText96, editText97, editText98, editText99, editText100,
                editText101, editText102, editText103, editText104, editText105, editText106, editText107, editText108, editText109, editText110, editText111, editText112, editText113, editText114, editText115, editText116, editText117, editText118, editText119,
                editText120, editText121, editText122, editText123, editText124, editText125, editText126, editText127, editText128, editText129, editText130, editText131, editText132, editText133, editText134, editText135, editText136, editText137, editText138,
                editText139, editText140, editText141, editText142, editText143, editText144, editText145, editText146, editText147, editText148, editText149, editText150, editText151, editText152, editText153, editText154, editText155, editText156, editText157,
                editText158, editText159, editText160, editText161, editText162, editText163, editText164, editText165, editText166, editText167, editText168, editText169, editText170, editText171, editText172, editText173, editText174, editText175, editText176, editText177,
                editText178, editText179, editText180, editText181, editText182, editText183, editText184, editText185, editText186, editText187, editText188, editText189, editText190, editText191, editText192, editText193, editText194, editText195, editText196,
                editText197, editText198, editText199, editText200, editText201, editText202, editText203, editText204, editText205, editText206, editText207, editText208, editText209, editText210, editText211, editText212, editText213, editText214, editText215, editText216,
                editText217, editText218, editText219, editText220, editText221, editText222, editText223, editText224, editText225, editText226, editText227, editText228, editText229, editText230, editText231, editText232, editText233, editText234, editText235, editText236,
                editText237, editText238, editText239, editText240, editText241, editText242, editText243, editText244;

         editTextArray = new EditText[]{
                editText1 = (EditText) findViewById(R.id.editTextVhfRxEcilSixStation),
                editText2 = (EditText) findViewById(R.id.editTextVhfRxEcilSixRegion),
                editText3 = (EditText) findViewById(R.id.editTextVhfRxEcilSixRx1),
                editText4 = (EditText) findViewById(R.id.editTextVhfRxEcilSixRx2),
                editText5 = (EditText) findViewById(R.id.editTextVhfRxEcilSixRx3),
                editText6 = (EditText) findViewById(R.id.editTextVhfRxEcilSixRx4),
                editText7 = (EditText) findViewById(R.id.editTextVhfRxEcilSixRx5),
                editText8 = (EditText) findViewById(R.id.editTextVhfRxEcilSixRx6),
                editText9 = (EditText) findViewById(R.id.editTextVhfRxEcilSixFreq1),
                editText10 = (EditText) findViewById(R.id.editTextVhfRxEcilSixFreq2),
                editText11 = (EditText) findViewById(R.id.editTextVhfRxEcilSixFreq3),
                editText12 = (EditText) findViewById(R.id.editTextVhfRxEcilSixFreq4),
                editText13 = (EditText) findViewById(R.id.editTextVhfRxEcilSixFreq5),
                editText14 = (EditText) findViewById(R.id.editTextVhfRxEcilSixFreq6),
                editText15 = (EditText) findViewById(R.id.editTextVhfRxEcilSixLoc1),
                editText16 = (EditText) findViewById(R.id.editTextVhfRxEcilSixLoc2),
                editText17 = (EditText) findViewById(R.id.editTextVhfRxEcilSixLoc3),
                editText18 = (EditText) findViewById(R.id.editTextVhfRxEcilSixLoc4),
                editText19 = (EditText) findViewById(R.id.editTextVhfRxEcilSixLoc5),
                editText20 = (EditText) findViewById(R.id.editTextVhfRxEcilSixLoc6),
                editText21 = (EditText) findViewById(R.id.editTextVhfRxEcilSixClean1),
                editText22 = (EditText) findViewById(R.id.editTextVhfRxEcilSixClean2),
                editText23 = (EditText) findViewById(R.id.editTextVhfRxEcilSixClean3),
                editText24 = (EditText) findViewById(R.id.editTextVhfRxEcilSixClean4),
                editText25 = (EditText) findViewById(R.id.editTextVhfRxEcilSixClean5),
                editText26 = (EditText) findViewById(R.id.editTextVhfRxEcilSixClean6),
                editText27 = (EditText) findViewById(R.id.editTextVhfRxEcilSixUnreg1),
                editText28 = (EditText) findViewById(R.id.editTextVhfRxEcilSixUnreg2),
                editText29 = (EditText) findViewById(R.id.editTextVhfRxEcilSixUnreg3),
                editText30 = (EditText) findViewById(R.id.editTextVhfRxEcilSixUnreg4),
                editText31 = (EditText) findViewById(R.id.editTextVhfRxEcilSixUnreg5),
                editText32 = (EditText) findViewById(R.id.editTextVhfRxEcilSixUnreg6),
                editText33 = (EditText) findViewById(R.id.editTextVhfRxEcilSixBit1),
                editText34 = (EditText) findViewById(R.id.editTextVhfRxEcilSixBit2),
                editText35 = (EditText) findViewById(R.id.editTextVhfRxEcilSixBit3),
                editText36 = (EditText) findViewById(R.id.editTextVhfRxEcilSixBit4),
                editText37 = (EditText) findViewById(R.id.editTextVhfRxEcilSixBit5),
                editText38 = (EditText) findViewById(R.id.editTextVhfRxEcilSixBit6),
                editText39 = (EditText) findViewById(R.id.editTextVhfRxEcilSixIF1),
                editText40 = (EditText) findViewById(R.id.editTextVhfRxEcilSixIF2),
                editText41 = (EditText) findViewById(R.id.editTextVhfRxEcilSixIF3),
                editText42 = (EditText) findViewById(R.id.editTextVhfRxEcilSixIF4),
                editText43 = (EditText) findViewById(R.id.editTextVhfRxEcilSixIF5),
                editText44 = (EditText) findViewById(R.id.editTextVhfRxEcilSixIF6),
                editText45 = (EditText) findViewById(R.id.editTextVhfRxEcilSixDCLed1),
                editText46 = (EditText) findViewById(R.id.editTextVhfRxEcilSixDCLed2),
                editText47 = (EditText) findViewById(R.id.editTextVhfRxEcilSixDCLed3),
                editText48 = (EditText) findViewById(R.id.editTextVhfRxEcilSixDCLed4),
                editText49 = (EditText) findViewById(R.id.editTextVhfRxEcilSixDCLed5),
                editText50 = (EditText) findViewById(R.id.editTextVhfRxEcilSixDCLed6),
                editText51 = (EditText) findViewById(R.id.editTextVhfRxEcilSixACLed1),
                editText52 = (EditText) findViewById(R.id.editTextVhfRxEcilSixACLed2),
                editText53 = (EditText) findViewById(R.id.editTextVhfRxEcilSixACLed3),
                editText54 = (EditText) findViewById(R.id.editTextVhfRxEcilSixACLed4),
                editText55 = (EditText) findViewById(R.id.editTextVhfRxEcilSixACLed5),
                editText56 = (EditText) findViewById(R.id.editTextVhfRxEcilSixACLed6),
                editText57 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg1),
                editText58 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg2),
                editText59 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg3),
                editText60 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg4),
                editText61 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg5),
                editText62 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg6),
                editText63 = (EditText) findViewById(R.id.editTextVhfRxEcilSixInput1),
                editText64 = (EditText) findViewById(R.id.editTextVhfRxEcilSixInput2),
                editText65 = (EditText) findViewById(R.id.editTextVhfRxEcilSixInput3),
                editText66 = (EditText) findViewById(R.id.editTextVhfRxEcilSixInput4),
                editText67 = (EditText) findViewById(R.id.editTextVhfRxEcilSixInput5),
                editText68 = (EditText) findViewById(R.id.editTextVhfRxEcilSixInput6),
                editText69 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg101),
                editText70 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg102),
                editText71 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg103),
                editText72 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg104),
                editText73 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg105),
                editText74 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg106),
                editText75 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg51),
                editText76 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg52),
                editText77 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg53),
                editText78 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg54),
                editText79 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg55),
                editText80 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg56),
                editText81 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg121),
                editText82 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg122),
                editText83 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg123),
                editText84 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg124),
                editText85 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg125),
                editText86 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg126),
                editText87 = (EditText) findViewById(R.id.editTextVhfRxEcilSixSynth1),
                editText88 = (EditText) findViewById(R.id.editTextVhfRxEcilSixSynth2),
                editText89 = (EditText) findViewById(R.id.editTextVhfRxEcilSixSynth3),
                editText90 = (EditText) findViewById(R.id.editTextVhfRxEcilSixSynth4),
                editText91 = (EditText) findViewById(R.id.editTextVhfRxEcilSixSynth5),
                editText92 = (EditText) findViewById(R.id.editTextVhfRxEcilSixSynth6),
                editText93 = (EditText) findViewById(R.id.editTextVhfRxEcilSixFreqChk1),
                editText94 = (EditText) findViewById(R.id.editTextVhfRxEcilSixFreqChk2),
                editText95 = (EditText) findViewById(R.id.editTextVhfRxEcilSixFreqChk3),
                editText96 = (EditText) findViewById(R.id.editTextVhfRxEcilSixFreqChk4),
                editText97 = (EditText) findViewById(R.id.editTextVhfRxEcilSixFreqChk5),
                editText98 = (EditText) findViewById(R.id.editTextVhfRxEcilSixFreqChk6),
                editText99 = (EditText) findViewById(R.id.editTextVhfRxEcilSixSens1),
                editText100 = (EditText) findViewById(R.id.editTextVhfRxEcilSixSens2),
                editText101 = (EditText) findViewById(R.id.editTextVhfRxEcilSixSens3),
                editText102 = (EditText) findViewById(R.id.editTextVhfRxEcilSixSens4),
                editText103 = (EditText) findViewById(R.id.editTextVhfRxEcilSixSens5),
                editText104 = (EditText) findViewById(R.id.editTextVhfRxEcilSixSens6),
                editText105 = (EditText) findViewById(R.id.editTextVhfRxEcilSixMute1),
                editText106 = (EditText) findViewById(R.id.editTextVhfRxEcilSixMute2),
                editText107 = (EditText) findViewById(R.id.editTextVhfRxEcilSixMute3),
                editText108 = (EditText) findViewById(R.id.editTextVhfRxEcilSixMute4),
                editText109 = (EditText) findViewById(R.id.editTextVhfRxEcilSixMute5),
                editText110 = (EditText) findViewById(R.id.editTextVhfRxEcilSixMute6),
                editText111 = (EditText) findViewById(R.id.editTextVhfRxEcilSixAntChk1),
                editText112 = (EditText) findViewById(R.id.editTextVhfRxEcilSixAntChk2),
                editText113 = (EditText) findViewById(R.id.editTextVhfRxEcilSixAntChk3),
                editText114 = (EditText) findViewById(R.id.editTextVhfRxEcilSixAntChk4),
                editText115 = (EditText) findViewById(R.id.editTextVhfRxEcilSixAntChk5),
                editText116 = (EditText) findViewById(R.id.editTextVhfRxEcilSixAntChk6),
                editText117 = (EditText) findViewById(R.id.editTextVhfRxEcilSixStatus1),
                editText118 = (EditText) findViewById(R.id.editTextVhfRxEcilSixStatus2),
                editText119 = (EditText) findViewById(R.id.editTextVhfRxEcilSixStatus3),
                editText120 = (EditText) findViewById(R.id.editTextVhfRxEcilSixStatus4),
                editText121 = (EditText) findViewById(R.id.editTextVhfRxEcilSixStatus5),
                editText122 = (EditText) findViewById(R.id.editTextVhfRxEcilSixStatus6),
                editText123 = (EditText) findViewById(R.id.editTextVhfRxEcilSixRemarks1),
                editText124 = (EditText) findViewById(R.id.editTextVhfRxEcilSixRx7),
                editText125 = (EditText) findViewById(R.id.editTextVhfRxEcilSixRx8),
                editText126 = (EditText) findViewById(R.id.editTextVhfRxEcilSixRx9),
                editText127 = (EditText) findViewById(R.id.editTextVhfRxEcilSixRx10),
                editText128 = (EditText) findViewById(R.id.editTextVhfRxEcilSixRx11),
                editText129 = (EditText) findViewById(R.id.editTextVhfRxEcilSixRx12),
                editText130 = (EditText) findViewById(R.id.editTextVhfRxEcilSixFreq7),
                editText131 = (EditText) findViewById(R.id.editTextVhfRxEcilSixFreq8),
                editText132 = (EditText) findViewById(R.id.editTextVhfRxEcilSixFreq9),
                editText133 = (EditText) findViewById(R.id.editTextVhfRxEcilSixFreq10),
                editText134 = (EditText) findViewById(R.id.editTextVhfRxEcilSixFreq11),
                editText135 = (EditText) findViewById(R.id.editTextVhfRxEcilSixFreq12),
                editText136 = (EditText) findViewById(R.id.editTextVhfRxEcilSixLoc7),
                editText137 = (EditText) findViewById(R.id.editTextVhfRxEcilSixLoc8),
                editText138 = (EditText) findViewById(R.id.editTextVhfRxEcilSixLoc9),
                editText139 = (EditText) findViewById(R.id.editTextVhfRxEcilSixLoc10),
                editText140 = (EditText) findViewById(R.id.editTextVhfRxEcilSixLoc11),
                editText141 = (EditText) findViewById(R.id.editTextVhfRxEcilSixLoc12),
                editText142 = (EditText) findViewById(R.id.editTextVhfRxEcilSixClean7),
                editText143 = (EditText) findViewById(R.id.editTextVhfRxEcilSixClean8),
                editText144 = (EditText) findViewById(R.id.editTextVhfRxEcilSixClean9),
                editText145 = (EditText) findViewById(R.id.editTextVhfRxEcilSixClean10),
                editText146 = (EditText) findViewById(R.id.editTextVhfRxEcilSixClean11),
                editText147 = (EditText) findViewById(R.id.editTextVhfRxEcilSixClean12),
                editText148 = (EditText) findViewById(R.id.editTextVhfRxEcilSixUnreg7),
                editText149 = (EditText) findViewById(R.id.editTextVhfRxEcilSixUnreg8),
                editText150 = (EditText) findViewById(R.id.editTextVhfRxEcilSixUnreg9),
                editText151 = (EditText) findViewById(R.id.editTextVhfRxEcilSixUnreg10),
                editText152 = (EditText) findViewById(R.id.editTextVhfRxEcilSixUnreg11),
                editText153 = (EditText) findViewById(R.id.editTextVhfRxEcilSixUnreg12),
                editText154 = (EditText) findViewById(R.id.editTextVhfRxEcilSixBit7),
                editText155 = (EditText) findViewById(R.id.editTextVhfRxEcilSixBit8),
                editText156 = (EditText) findViewById(R.id.editTextVhfRxEcilSixBit9),
                editText157 = (EditText) findViewById(R.id.editTextVhfRxEcilSixBit10),
                editText158 = (EditText) findViewById(R.id.editTextVhfRxEcilSixBit11),
                editText159 = (EditText) findViewById(R.id.editTextVhfRxEcilSixBit12),
                editText160 = (EditText) findViewById(R.id.editTextVhfRxEcilSixIF7),
                editText161 = (EditText) findViewById(R.id.editTextVhfRxEcilSixIF8),
                editText162 = (EditText) findViewById(R.id.editTextVhfRxEcilSixIF9),
                editText163 = (EditText) findViewById(R.id.editTextVhfRxEcilSixIF10),
                editText164 = (EditText) findViewById(R.id.editTextVhfRxEcilSixIF11),
                editText165 = (EditText) findViewById(R.id.editTextVhfRxEcilSixIF12),
                editText166 = (EditText) findViewById(R.id.editTextVhfRxEcilSixDCLed7),
                editText167 = (EditText) findViewById(R.id.editTextVhfRxEcilSixDCLed8),
                editText168 = (EditText) findViewById(R.id.editTextVhfRxEcilSixDCLed9),
                editText169 = (EditText) findViewById(R.id.editTextVhfRxEcilSixDCLed10),
                editText170 = (EditText) findViewById(R.id.editTextVhfRxEcilSixDCLed11),
                editText171 = (EditText) findViewById(R.id.editTextVhfRxEcilSixDCLed12),
                editText172 = (EditText) findViewById(R.id.editTextVhfRxEcilSixACLed7),
                editText173 = (EditText) findViewById(R.id.editTextVhfRxEcilSixACLed8),
                editText174 = (EditText) findViewById(R.id.editTextVhfRxEcilSixACLed9),
                editText175 = (EditText) findViewById(R.id.editTextVhfRxEcilSixACLed10),
                editText176 = (EditText) findViewById(R.id.editTextVhfRxEcilSixACLed11),
                editText177 = (EditText) findViewById(R.id.editTextVhfRxEcilSixACLed12),
                editText178 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg7),
                editText179 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg8),
                editText180 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg9),
                editText181 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg10),
                editText182 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg11),
                editText183 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg12),
                editText184 = (EditText) findViewById(R.id.editTextVhfRxEcilSixInput7),
                editText185 = (EditText) findViewById(R.id.editTextVhfRxEcilSixInput8),
                editText186 = (EditText) findViewById(R.id.editTextVhfRxEcilSixInput9),
                editText187 = (EditText) findViewById(R.id.editTextVhfRxEcilSixInput10),
                editText188 = (EditText) findViewById(R.id.editTextVhfRxEcilSixInput11),
                editText189 = (EditText) findViewById(R.id.editTextVhfRxEcilSixInput12),
                editText190 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg107),
                editText191 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg108),
                editText192 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg109),
                editText193 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg1010),
                editText194 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg1011),
                editText195 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg1012),
                editText196 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg57),
                editText197 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg58),
                editText198 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg59),
                editText199 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg510),
                editText200 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg511),
                editText201 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg512),
                editText202 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg127),
                editText203 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg128),
                editText204 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg129),
                editText205 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg1210),
                editText206 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg1211),
                editText207 = (EditText) findViewById(R.id.editTextVhfRxEcilSixReg1212),
                editText208 = (EditText) findViewById(R.id.editTextVhfRxEcilSixSynth7),
                editText209 = (EditText) findViewById(R.id.editTextVhfRxEcilSixSynth8),
                editText210 = (EditText) findViewById(R.id.editTextVhfRxEcilSixSynth9),
                editText211 = (EditText) findViewById(R.id.editTextVhfRxEcilSixSynth10),
                editText212 = (EditText) findViewById(R.id.editTextVhfRxEcilSixSynth11),
                editText213 = (EditText) findViewById(R.id.editTextVhfRxEcilSixSynth12),
                editText214 = (EditText) findViewById(R.id.editTextVhfRxEcilSixFreqChk7),
                editText215 = (EditText) findViewById(R.id.editTextVhfRxEcilSixFreqChk8),
                editText216 = (EditText) findViewById(R.id.editTextVhfRxEcilSixFreqChk9),
                editText217 = (EditText) findViewById(R.id.editTextVhfRxEcilSixFreqChk10),
                editText218 = (EditText) findViewById(R.id.editTextVhfRxEcilSixFreqChk11),
                editText219 = (EditText) findViewById(R.id.editTextVhfRxEcilSixFreqChk12),
                editText220 = (EditText) findViewById(R.id.editTextVhfRxEcilSixSens7),
                editText221 = (EditText) findViewById(R.id.editTextVhfRxEcilSixSens8),
                editText222 = (EditText) findViewById(R.id.editTextVhfRxEcilSixSens9),
                editText223 = (EditText) findViewById(R.id.editTextVhfRxEcilSixSens10),
                editText224 = (EditText) findViewById(R.id.editTextVhfRxEcilSixSens11),
                editText225 = (EditText) findViewById(R.id.editTextVhfRxEcilSixSens12),
                editText226 = (EditText) findViewById(R.id.editTextVhfRxEcilSixMute7),
                editText227 = (EditText) findViewById(R.id.editTextVhfRxEcilSixMute8),
                editText228 = (EditText) findViewById(R.id.editTextVhfRxEcilSixMute9),
                editText229 = (EditText) findViewById(R.id.editTextVhfRxEcilSixMute10),
                editText230 = (EditText) findViewById(R.id.editTextVhfRxEcilSixMute11),
                editText231 = (EditText) findViewById(R.id.editTextVhfRxEcilSixMute12),
                editText232 = (EditText) findViewById(R.id.editTextVhfRxEcilSixAntChk7),
                editText233 = (EditText) findViewById(R.id.editTextVhfRxEcilSixAntChk8),
                editText234 = (EditText) findViewById(R.id.editTextVhfRxEcilSixAntChk9),
                editText235 = (EditText) findViewById(R.id.editTextVhfRxEcilSixAntChk10),
                editText236 = (EditText) findViewById(R.id.editTextVhfRxEcilSixAntChk11),
                editText237 = (EditText) findViewById(R.id.editTextVhfRxEcilSixAntChk12),
                editText238 = (EditText) findViewById(R.id.editTextVhfRxEcilSixStatus7),
                editText239 = (EditText) findViewById(R.id.editTextVhfRxEcilSixStatus8),
                editText240 = (EditText) findViewById(R.id.editTextVhfRxEcilSixStatus9),
                editText241 = (EditText) findViewById(R.id.editTextVhfRxEcilSixStatus10),
                editText242 = (EditText) findViewById(R.id.editTextVhfRxEcilSixStatus11),
                editText243 = (EditText) findViewById(R.id.editTextVhfRxEcilSixStatus12),
                editText244 = (EditText) findViewById(R.id.editTextVhfRxEcilSixRemarks2)};

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

        Button signDocument = (Button) findViewById(R.id.button11);
        Button submitSchedule = (Button) findViewById(R.id.button10);

        submitSchedule.setVisibility(android.view.View.INVISIBLE);
        signDocument.setVisibility(android.view.View.VISIBLE);

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

        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.vhfrxecilsixmonthly1);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);

        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(12);

        int[] editTextXPixel = {183,500,288,358,427,497,569,639,288,358,427,497,569,639,288,358,427,497,569,639,288,358,427,497,569,639,288,358,427,497,569,639,288,358,427,497,569,639,
                288,358,427,497,569,639,288,358,427,497,569,639,288,358,427,497,569,639,288,358,427,497,569,639,288,358,427,497,569,639,288,358,427,497,569,639,288,358,427,497,569,639,
                288,358,427,497,569,639,288,358,427,497,569,639,288,358,427,497,569,639,288,358,427,497,569,639,288,358,427,497,569,639,288,358,427,497,569,639,288,358,427,497,569,639,194};
        int[] editTextYPixel = {179,179,231,231,231,231,231,231,251,251,251,251,251,251,273,273,273,273,273,273,314,314,314,314,314,314,366,366,366,366,366,366,401,401,401,401,401,401,
                442,442,442,442,442,442,478,478,478,478,478,478,513,513,513,513,513,513,541,541,541,541,541,541,584,584,584,584,584,584,604,604,604,604,604,604,642,642,642,642,642,642,
                647,647,647,647,647,647,679,679,679,679,679,679,713,713,713,713,713,713,739,739,739,739,739,739,759,759,759,759,759,759,790,790,790,790,790,790,832,832,832,832,832,832,855};



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

        canvas.drawText(strData,581,200,titlePaint);//Printing Date on PDF

        myPdfdocument.finishPage(myPage1);


        //---------------------End of Page 1---------------

        //----------------------Page 2---------------------

        PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(723, 1024, 2).create();

        // start a page
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);

        canvas = myPage2.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.vhfrxecilsixmonthly2);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);

        int[] editTextXPixel2 = {288,358,427,497,569,639,288,358,427,497,569,639,288,358,427,497,569,639,288,358,427,497,569,639,288,358,427,497,569,639,288,358,427,497,569,639,
                288,358,427,497,569,639,288,358,427,497,569,639,288,358,427,497,569,639,288,358,427,497,569,639,288,358,427,497,569,639,288,358,427,497,569,639,288,358,427,497,569,639,
                288,358,427,497,569,639,288,358,427,497,569,639,288,358,427,497,569,639,288,358,427,497,569,639,288,358,427,497,569,639,288,358,427,497,569,639,288,358,427,497,569,639,194};
        int[] editTextYPixel2 = {117,117,117,117,117,117,140,140,140,140,140,140,161,161,161,161,161,161,205,205,205,205,205,205,262,262,262,262,262,262,297,297,297,297,297,297,
                340,340,340,340,340,340,381,381,381,381,381,381,414,414,414,414,414,414,442,442,442,442,442,442,484,484,484,484,484,484,505,505,505,505,505,505,527,527,527,527,527,527,
                549,549,549,549,549,549,581,581,581,581,581,581,614,614,614,614,614,614,642,642,642,642,642,642,662,662,662,662,662,662,694,694,694,694,694,694,733,733,733,733,733,733,758};



        for(int i = 0; i < editTextXPixel2.length; i++){
            canvas.drawText( editTextDataForPDF[i+editTextXPixel.length],editTextXPixel2[i],editTextYPixel2[i],titlePaint);
        }


        titlePaint.setTextSize(12);
        paint.setTextAlign(Paint.Align.LEFT);

        canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 64, 775, paint);

        myPdfdocument.finishPage(myPage2);

        //-------------------------End of Page 2-----------------



        ActivityCompat.requestPermissions(this, new String[]{

                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Communication/VHFRxEcil/SixMonthly/";// Change Here------------------
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //String targetPdf = directory_path + "test.pdf";
        //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
        String fileName = "Six Monthly VHF RX ECIL " + strData + ".pdf"; // Change Here--------------------------
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
                "Six Monthly Maintenance of ECIL VHF Rx done.",//Change Here-----------------------------
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