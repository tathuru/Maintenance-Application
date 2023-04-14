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

public class LlzThalesWfrActivity extends AppCompatActivity {

    private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
    private MySignature mySignature = new MySignature(this);
    private int selectedID;//Copy
    private String selectedName;//Copy
    private EditText[] editTextArray;//Copy
    private Switch[] switchArray= {};//Copy
    private Spinner[] spinnerArray={};//Copy
    private String thisActivityName = "LlzThalesWfrActivity"; //Change Here as per your class name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llz_thales_wfr);

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
                editText160,editText161, editText162,editText163, editText164, editText165, editText166, editText167, editText168,editText169, editText170, editText171, editText172, editText173, editText174, editText175, editText176,
                editText177, editText178, editText179, editText180, editText181, editText182, editText183, editText184, editText185, editText186, editText187, editText188,editText189,editText190, editText191, editText192, editText193,
                editText194,editText195, editText196, editText197, editText198,editText199, editText200, editText201, editText202, editText203, editText204, editText205, editText206, editText207, editText208,editText209, editText210,
                editText211, editText212, editText213, editText214, editText215, editText216, editText217, editText218, editText219, editText220, editText221, editText222, editText223, editText224,editText225, editText226, editText227,
                editText228, editText229, editText230, editText231, editText232, editText233, editText234, editText235, editText236, editText237, editText238, editText239, editText240, editText241, editText242, editText243, editText244,
                editText245, editText246, editText247, editText248, editText249, editText250, editText251, editText252,editText253, editText254, editText255, editText256, editText257, editText258,editText259,editText260;

        editTextArray = new EditText[]{
                editText1 = (EditText)  findViewById(R.id.editTextLlzThalesWFRRWY),

                editText2 = (EditText)  findViewById(R.id.editTextLlzThalesWFRNmlTx1DDM9035),
                editText3 = (EditText)  findViewById(R.id.editTextLlzThalesWFRNmlTx1SDM9035),
                editText4 = (EditText)  findViewById(R.id.editTextLlzThalesWFRNmlTx1RF9035),
                editText5 = (EditText)  findViewById(R.id.editTextLlzThalesWFRObsTx1DDM9035),
                editText6 = (EditText)  findViewById(R.id.editTextLlzThalesWFRObsTx1SDM9035),
                editText7 = (EditText)  findViewById(R.id.editTextLlzThalesWFRObsTx1RF9035),
                editText8 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2DDM9035),
                editText9 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2SDM9035),
                editText10 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2RF9035),
                editText11 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2DDM9035),
                editText12 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2SDM9035),
                editText13 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2RF9035),

                editText14 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1DDM9030),
                editText15 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1SDM9030),
                editText16 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1RF9030),
                editText17 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1DDM9030),
                editText18 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1SDM9030),
                editText19 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1RF9030),
                editText20 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2DDM9030),
                editText21 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2SDM9030),
                editText22 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2RF9030),
                editText23 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2DDM9030),
                editText24 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2SDM9030),
                editText25 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2RF9030),

                editText26 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1DDM9025),
                editText27 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1SDM9025),
                editText28 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1RF9025),
                editText29 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1DDM9025),
                editText30 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1SDM9025),
                editText31 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1RF9025),
                editText32 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2DDM9025),
                editText33 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2SDM9025),
                editText34 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2RF9025),
                editText35 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2DDM9025),
                editText36 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2SDM9025),
                editText37 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2RF9025),

                editText38 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1DDM9020),
                editText39 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1SDM9020),
                editText40 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1RF9020),
                editText41 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1DDM9020),
                editText42 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1SDM9020),
                editText43 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1RF9020),
                editText44 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2DDM9020),
                editText45 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2SDM9020),
                editText46 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2RF9020),
                editText47 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2DDM9020),
                editText48  = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2SDM9020),
                editText49 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2RF9020),

                editText50 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1DDM9015),
                editText51 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1SDM9015),
                editText52 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1RF9015),
                editText53 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1DDM9015),
                editText54 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1SDM9015),
                editText55 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1RF9015),
                editText56 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2DDM9015),
                editText57 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2SDM9015),
                editText58 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2RF9015),
                editText59 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2DDM9015),
                editText60 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2SDM9015),
                editText61 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2RF9015),

                editText62 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1DDM9010),
                editText63 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1SDM9010),
                editText64 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1RF9010),
                editText65 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1DDM9010),
                editText66 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1SDM9010),
                editText67 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1RF9010),
                editText68 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2DDM9010),
                editText69 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2SDM9010),
                editText70 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2RF9010),
                editText71 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2DDM9010),
                editText72 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2SDM9010),
                editText73 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2RF9010),

                editText74 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1DDM905),
                editText75 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1SDM905),
                editText76 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1RF905),
                editText77 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1DDM905),
                editText78 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1SDM905),
                editText79 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1RF905),
                editText80 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2DDM905),
                editText81 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2SDM905),
                editText82 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2RF905),
                editText83 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2DDM905),
                editText84 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2SDM905),
                editText85 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2RF905),

                editText86 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1DDM90W),
                editText87 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1SDM90W),
                editText88 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1RF90W),
                editText89 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1DDM90W),
                editText90 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1SDM90W),
                editText91 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1RF90W),
                editText92 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2DDM90W),
                editText93 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2SDM90W),
                editText94 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2RF90W),
                editText95 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2DDM90W),
                editText96 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2SDM90W),
                editText97 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2RF90W),

                editText98 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1DDM900),
                editText99 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1SDM900),
                editText100 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1RF900),
                editText101 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1DDM900),
                editText102 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1SDM900),
                editText103 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1RF900),
                editText104 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2DDM900),
                editText105 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2SDM900),
                editText106 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2RF900),
                editText107 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2DDM900),
                editText108 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2SDM900),
                editText109 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2RF900),

                editText110 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1DDM90N),
                editText111 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1SDM90N),
                editText112 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1RF90N),
                editText113 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1DDM90N),
                editText114 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1SDM90N),
                editText115 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1RF90N),
                editText116 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2DDM90N),
                editText117 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2SDM90N),
                editText118 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2RF90N),
                editText119 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2DDM90N),
                editText120 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2SDM90N),
                editText121 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2RF90N),

                editText122 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1DDMCL),
                editText123 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1SDMCL),
                editText124 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1RFCL),
                editText125 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1DDMCL),
                editText126 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1SDMCL),
                editText127 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1RFCL),
                editText128 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2DDMCL),
                editText129 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2SDMCL),
                editText130 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2RFCL),
                editText131 = (EditText)  findViewById(R.id.editTextLlzThalesWFRObsTx2DDMCL),
                editText132 = (EditText)  findViewById(R.id.editTextLlzThalesWFRObsTx2SDMCL),
                editText133 = (EditText)  findViewById(R.id.editTextLlzThalesWFRObsTx2RFCL),

                editText134 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1DDM150N),
                editText135 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1SDM150N),
                editText136 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1RF150N),
                editText137 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1DDM150N),
                editText138 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1SDM150N),
                editText139 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1RF150N),
                editText140 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2DDM150N),
                editText141 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2SDM150N),
                editText142 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2RF150N),
                editText143 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2DDM150N),
                editText144 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2SDM150N),
                editText145 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2RF150N),

                editText146 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1DDM1500),
                editText147 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1SDM1500),
                editText148 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1RF1500),
                editText149 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1DDM1500),
                editText150 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1SDM1500),
                editText151 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1RF1500),
                editText152 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2DDM1500),
                editText153 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2SDM1500),
                editText154 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2RF1500),
                editText155 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2DDM1500),
                editText156 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2SDM1500),
                editText157 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2RF1500),

                editText158 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1DDM150W),
                editText159 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1SDM150W),
                editText160 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1RF150W),
                editText161 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1DDM150W),
                editText162 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1SDM150W),
                editText163 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1RF150W),
                editText164 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2DDM150W),
                editText165 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2SDM150W),
                editText166 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2RF150W),
                editText167 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2DDM150W),
                editText168 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2SDM150W),
                editText169 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2RF150W),

                editText170 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1DDM1505),
                editText171 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1SDM1505),
                editText172 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1RF1505),
                editText173 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1DDM1505),
                editText174 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1SDM1505),
                editText175 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1RF1505),
                editText176 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2DDM1505),
                editText177 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2SDM1505),
                editText178 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2RF1505),
                editText179 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2DDM1505),
                editText180 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2SDM1505),
                editText181 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2RF1505),

                editText182 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1DDM15010),
                editText183 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1SDM15010),
                editText184 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1RF15010),
                editText185 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1DDM15010),
                editText186 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1SDM15010),
                editText187 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1RF15010),
                editText188 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2DDM15010),
                editText189 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2SDM15010),
                editText190 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2RF15010),
                editText191 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2DDM15010),
                editText192 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2SDM15010),
                editText193 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2RF15010),

                editText194 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1DDM15015),
                editText195 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1SDM15015),
                editText196 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1RF15015),
                editText197 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1DDM15015),
                editText198 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1SDM15015),
                editText199 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1RF15015),
                editText200 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2DDM15015),
                editText201 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2SDM15015),
                editText202 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2RF15015),
                editText203 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2DDM15015),
                editText204 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2SDM15015),
                editText205 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2RF15015),

                editText206 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1DDM15020),
                editText207 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1SDM15020),
                editText208 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1RF15020),
                editText209 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1DDM15020),
                editText210 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1SDM15020),
                editText211 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1RF15020),
                editText212 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2DDM15020),
                editText213 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2SDM15020),
                editText214 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2RF15020),
                editText215 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2DDM15020),
                editText216 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2SDM15020),
                editText217 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2RF15020),

                editText218 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1DDM15025),
                editText219 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1SDM15025),
                editText220 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1RF15025),
                editText221 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1DDM15025),
                editText222 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1SDM15025),
                editText223 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1RF15025),
                editText224 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2DDM15025),
                editText225 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2SDM15025),
                editText226 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2RF15025),
                editText227 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2DDM15025),
                editText228 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2SDM15025),
                editText229 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2RF15025),

                editText230 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1DDM15030),
                editText231 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1SDM15030),
                editText232 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1RF15030),
                editText233 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1DDM15030),
                editText234 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1SDM15030),
                editText235 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1RF15030),
                editText236 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2DDM15030),
                editText237 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2SDM15030),
                editText238 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2RF15030),
                editText239 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2DDM15030),
                editText240 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2SDM15030),
                editText241 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2RF15030),

                editText242 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1DDM15035),
                editText243 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1SDM15035),
                editText244 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx1RF15035),
                editText245 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1DDM15035),
                editText246 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1SDM15035),
                editText247 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx1RF15035),
                editText248 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2DDM15035),
                editText249 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2SDM15035),
                editText250 = (EditText) findViewById(R.id.editTextLlzThalesWFRNmlTx2RF15035),
                editText251 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2DDM15035),
                editText252 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2SDM15035),
                editText253 = (EditText) findViewById(R.id.editTextLlzThalesWFRObsTx2RF15035),

                editText254 = (EditText) findViewById(R.id.editTextLlzThalesWFR90Hz1),
                editText255 = (EditText) findViewById(R.id.editTextLlzThalesWFR90Hz2),
                editText256 = (EditText) findViewById(R.id.editTextLlzThalesWFR150Hz1),
                editText257 = (EditText) findViewById(R.id.editTextLlzThalesWFR150Hz2),
                editText258 = (EditText) findViewById(R.id.editTextLlzThalesWFR1020Hz1),
                editText259 = (EditText) findViewById(R.id.editTextLlzThalesWFR1020Hz2),
                editText260 = (EditText) findViewById(R.id.editTextLlzThalesWFRRemarks)};

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

        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.llzthaleswfr1);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);

        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(11);

        int[] editTextXPixel = {135,64,108,150,202,248,291,409,454,495,548,592,635,64,108,150,202,248,291,409,454,495,548,592,635,
                64,108,150,202,248,291,409,454,495,548,592,635,64,108,150,202,248,291,409,454,495,548,592,635,64,108,150,202,248,291,409,454,495,548,592,635,
                64,108,150,202,248,291,409,454,495,548,592,635,64,108,150,202,248,291,409,454,495,548,592,635,64,108,150,202,248,291,409,454,495,548,592,635,
                64,108,150,202,248,291,409,454,495,548,592,635,64,108,150,202,248,291,409,454,495,548,592,635,64,108,150,202,248,291,409,454,495,548,592,635,
                64,108,150,202,248,291,409,454,495,548,592,635,64,108,150,202,248,291,409,454,495,548,592,635,64,108,150,202,248,291,409,454,495,548,592,635,
                64,108,150,202,248,291,409,454,495,548,592,635,64,108,150,202,248,291,409,454,495,548,592,635,64,108,150,202,248,291,409,454,495,548,592,635,
                64,108,150,202,248,291,409,454,495,548,592,635,64,108,150,202,248,291,409,454,495,548,592,635,64,108,150,202,248,291,409,454,495,548,592,635,
                64,108,150,202,248,291,409,454,495,548,592,635,185,285,185,285,185,285};
        int[] editTextYPixel = {161,271,271,271,271,271,271,271,271,271,271,271,271,294,294,294,294,294,294,294,294,294,294,294,294,
                317,317,317,317,317,317,317,317,317,317,317,317,339,339,339,339,339,339,339,339,339,339,339,339,362,362,362,362,362,362,362,362,362,362,362,362,
                384,384,384,384,384,384,384,384,384,384,384,384,407,407,407,407,407,407,407,407,407,407,407,407,429,429,429,429,429,429,429,429,429,429,429,429,
                452,452,452,452,452,452,452,452,452,452,452,452,473,473,473,473,473,473,473,473,473,473,473,473,496,496,496,496,496,496,496,496,496,496,496,496,
                519,519,519,519,519,519,519,519,519,519,519,519,542,542,542,542,542,542,542,542,542,542,542,542,565,565,565,565,565,565,565,565,565,565,565,565,
                588,588,588,588,588,588,588,588,588,588,588,588,610,610,610,610,610,610,610,610,610,610,610,610,632,632,632,632,632,632,632,632,632,632,632,632,
                654,654,654,654,654,654,654,654,654,654,654,654,678,678,678,678,678,678,678,678,678,678,678,678,700,700,700,700,700,700,700,700,700,700,700,700,
                723,723,723,723,723,723,723,723,723,723,723,723,854,854,874,874,895,895};



        // Change till here as per requirements ----------------------------------------------------

        //Fixed for all activity--------------------------------------------------------------------

        for(int i = 0; i < editTextXPixel.length; i++){
            canvas.drawText( editTextDataForPDF[i],editTextXPixel[i],editTextYPixel[i],titlePaint);
        }

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
        String strData = sdf.format(calendar.getTime());
        // Fixed till here--------------------------------------------------------------------------

        // Change as per your requirement-----------------------------------------------------------
        titlePaint.setTextSize(11);

        canvas.drawText(strData,480,160,titlePaint);//Printing Date on PDF

        myPdfdocument.finishPage(myPage1);


        //---------------------End of Page 1---------------

        //----------------------Page 2---------------------

        PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(723, 1024, 2).create();

        // start a page
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);

        canvas = myPage2.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.llzthaleswfr2);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(11);

        int[] editTextXPixel2 = {50};
        int[] editTextYPixel2 = {165};

        for(int i = 0; i < editTextXPixel2.length; i++){
            canvas.drawText( editTextDataForPDF[i+editTextXPixel.length],editTextXPixel2[i],editTextYPixel2[i],titlePaint);
        }

        titlePaint.setTextSize(12);
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 90, 220, paint);

        myPdfdocument.finishPage(myPage2);

        //-------------------------End of Page 2-----------------


        ActivityCompat.requestPermissions(this, new String[]{

                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Navigation/LLZThales/Weekly Field/";// Change Here------------------
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //String targetPdf = directory_path + "test.pdf";
        //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
        String fileName = "Weekly Field LLZ Thales " + strData + ".pdf"; // Change Here--------------------------
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
        myFunctions.saveToParse(targetPdf, fileName,"ILS","Weekly",outputEditText,MyFunctions.specificCode("w"),"outputSwitch", "outputSpinner");// Change Here-----------------------

        // This function will send eMail using JavaMailAPI
        //myFunctions.sendEmail(String To, String Subject, String Message,String targetPdf,String desired_Filename)
        myFunctions.sendEmail(PersonalDetailsActivity.emailTo + "@aai.aero",
                "Weekly Field Maintenance of Thales LLZ done.",//Change Here-----------------------------
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