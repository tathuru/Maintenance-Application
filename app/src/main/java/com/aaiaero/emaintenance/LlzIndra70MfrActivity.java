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

public class LlzIndra70MfrActivity extends AppCompatActivity {

    private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
    private MySignature mySignature = new MySignature(this);
    private int selectedID;//Copy
    private String selectedName;//Copy
    private EditText[] editTextArray;//Copy
    private Switch[] switchArray= {};//Copy
    private Spinner[] spinnerArray={};//Copy
    private String thisActivityName = "LlzIndra70MfrActivity"; //Change Here as per your class name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llz_indra70_mfr);
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
                editText245, editText246, editText247, editText248, editText249, editText250, editText251, editText252,editText253, editText254, editText255, editText256, editText257, editText258,editText259;

        editTextArray = new EditText[]{
                editText1 = (EditText)  findViewById(R.id.editTextLlzIndra70MFRRWY),
                editText2 = (EditText)  findViewById(R.id.editTextLlzIndra70MFRCat),
                editText3 = (EditText)  findViewById(R.id.editTextLlzIndra70MFRFrequency),
                editText4 = (EditText)  findViewById(R.id.editTextLlzIndra70MFRIdent),

                editText5 = (EditText)  findViewById(R.id.editTextLlzIndra70MFRNmlTx1DDM9035),
                editText6 = (EditText)  findViewById(R.id.editTextLlzIndra70MFRNmlTx1SDM9035),
                editText7 = (EditText)  findViewById(R.id.editTextLlzIndra70MFRNmlTx1RF9035),
                editText8 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1DDM9035),
                editText9 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1SDM9035),
                editText10 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1RF9035),
                editText11 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1DDM9030),
                editText12 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1SDM9030),
                editText13 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1RF9030),
                editText14 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1DDM9030),
                editText15 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1SDM9030),
                editText16 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1RF9030),
                editText17 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1DDM9025),
                editText18 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1SDM9025),
                editText19 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1RF9025),
                editText20 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1DDM9025),
                editText21 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1SDM9025),
                editText22 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1RF9025),
                editText23 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1DDM9020),
                editText24 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1SDM9020),
                editText25 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1RF9020),
                editText26 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1DDM9020),
                editText27 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1SDM9020),
                editText28 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1RF9020),
                editText29 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1DDM9015),
                editText30 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1SDM9015),
                editText31 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1RF9015),
                editText32 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1DDM9015),
                editText33 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1SDM9015),
                editText34 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1RF9015),
                editText35 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1DDM9010),
                editText36 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1SDM9010),
                editText37 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1RF9010),
                editText38 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1DDM9010),
                editText39 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1SDM9010),
                editText40 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1RF9010),
                editText41 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1DDM905),
                editText42 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1SDM905),
                editText43 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1RF905),
                editText44 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1DDM905),
                editText45 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1SDM905),
                editText46 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1RF905),
                editText47 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1DDM90W),
                editText48  = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1SDM90W),
                editText49 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1RF90W),
                editText50 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1DDM90W),
                editText51 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1SDM90W),
                editText52 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1RF90W),
                editText53 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1DDM900),
                editText54 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1SDM900),
                editText55 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1RF900),
                editText56 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1DDM900),
                editText57 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1SDM900),
                editText58 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1RF900),
                editText59 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1DDM90N),
                editText60 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1SDM90N),
                editText61 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1RF90N),
                editText62 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1DDM90N),
                editText63 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1SDM90N),
                editText64 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1RF90N),
                editText65 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1DDMCL),
                editText66 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1SDMCL),
                editText67 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1RFCL),
                editText68 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1DDMCL),
                editText69 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1SDMCL),
                editText70 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1RFCL),
                editText71 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1DDM150N),
                editText72 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1SDM150N),
                editText73 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1RF150N),
                editText74 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1DDM150N),
                editText75 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1SDM150N),
                editText76 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1RF150N),
                editText77 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1DDM1500),
                editText78 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1SDM1500),
                editText79 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1RF1500),
                editText80 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1DDM1500),
                editText81 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1SDM1500),
                editText82 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1RF1500),
                editText83 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1DDM150W),
                editText84 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1SDM150W),
                editText85 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1RF150W),
                editText86 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1DDM150W),
                editText87 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1SDM150W),
                editText88 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1RF150W),
                editText89 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1DDM1505),
                editText90 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1SDM1505),
                editText91 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1RF1505),
                editText92 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1DDM1505),
                editText93 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1SDM1505),
                editText94 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1RF1505),
                editText95 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1DDM15010),
                editText96 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1SDM15010),
                editText97 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1RF15010),
                editText98 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1DDM15010),
                editText99 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1SDM15010),
                editText100 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1RF15010),
                editText101 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1DDM15015),
                editText102 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1SDM15015),
                editText103 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1RF15015),
                editText104 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1DDM15015),
                editText105 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1SDM15015),
                editText106 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1RF15015),
                editText107 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1DDM15020),
                editText108 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1SDM15020),
                editText109 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1RF15020),
                editText110 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1DDM15020),
                editText111 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1SDM15020),
                editText112 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1RF15020),
                editText113 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1DDM15025),
                editText114 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1SDM15025),
                editText115 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1RF15025),
                editText116 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1DDM15025),
                editText117 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1SDM15025),
                editText118 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1RF15025),
                editText119 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1DDM15030),
                editText120 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1SDM15030),
                editText121 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1RF15030),
                editText122 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1DDM15030),
                editText123 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1SDM15030),
                editText124 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1RF15030),
                editText125 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1DDM15035),
                editText126 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1SDM15035),
                editText127 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx1RF15035),
                editText128 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1DDM15035),
                editText129 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1SDM15035),
                editText130 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx1RF15035),

                editText131 = (EditText)  findViewById(R.id.editTextLlzIndra70MFRNmlTx2DDM9035),
                editText132 = (EditText)  findViewById(R.id.editTextLlzIndra70MFRNmlTx2SDM9035),
                editText133 = (EditText)  findViewById(R.id.editTextLlzIndra70MFRNmlTx2RF9035),
                editText134 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2DDM9035),
                editText135 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2SDM9035),
                editText136 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2RF9035),
                editText137 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2DDM9030),
                editText138 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2SDM9030),
                editText139 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2RF9030),
                editText140 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2DDM9030),
                editText141 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2SDM9030),
                editText142 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2RF9030),
                editText143 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2DDM9025),
                editText144 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2SDM9025),
                editText145 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2RF9025),
                editText146 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2DDM9025),
                editText147 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2SDM9025),
                editText148 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2RF9025),
                editText149 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2DDM9020),
                editText150 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2SDM9020),
                editText151 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2RF9020),
                editText152 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2DDM9020),
                editText153 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2SDM9020),
                editText154 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2RF9020),
                editText155 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2DDM9015),
                editText156 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2SDM9015),
                editText157 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2RF9015),
                editText158 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2DDM9015),
                editText159 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2SDM9015),
                editText160 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2RF9015),
                editText161 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2DDM9010),
                editText162 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2SDM9010),
                editText163 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2RF9010),
                editText164 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2DDM9010),
                editText165 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2SDM9010),
                editText166 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2RF9010),
                editText167 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2DDM905),
                editText168 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2SDM905),
                editText169 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2RF905),
                editText170 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2DDM905),
                editText171 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2SDM905),
                editText172 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2RF905),
                editText173 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2DDM90W),
                editText174 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2SDM90W),
                editText175 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2RF90W),
                editText176 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2DDM90W),
                editText177 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2SDM90W),
                editText178 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2RF90W),
                editText179 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2DDM900),
                editText180 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2SDM900),
                editText181 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2RF900),
                editText182 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2DDM900),
                editText183 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2SDM900),
                editText184 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2RF900),
                editText185 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2DDM90N),
                editText186 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2SDM90N),
                editText187 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2RF90N),
                editText188 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2DDM90N),
                editText189 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2SDM90N),
                editText190 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2RF90N),
                editText191 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2DDMCL),
                editText192 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2SDMCL),
                editText193 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2RFCL),
                editText194 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2DDMCL),
                editText195 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2SDMCL),
                editText196 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2RFCL),
                editText197 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2DDM150N),
                editText198 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2SDM150N),
                editText199 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2RF150N),
                editText200 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2DDM150N),
                editText201 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2SDM150N),
                editText202 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2RF150N),
                editText203 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2DDM1500),
                editText204 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2SDM1500),
                editText205 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2RF1500),
                editText206 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2DDM1500),
                editText207 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2SDM1500),
                editText208 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2RF1500),
                editText209 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2DDM150W),
                editText210 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2SDM150W),
                editText211 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2RF150W),
                editText212 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2DDM150W),
                editText213 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2SDM150W),
                editText214 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2RF150W),
                editText215 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2DDM1505),
                editText216 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2SDM1505),
                editText217 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2RF1505),
                editText218 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2DDM1505),
                editText219 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2SDM1505),
                editText220 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2RF1505),
                editText221 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2DDM15010),
                editText222 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2SDM15010),
                editText223 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2RF15010),
                editText224 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2DDM15010),
                editText225 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2SDM15010),
                editText226 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2RF15010),
                editText227 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2DDM15015),
                editText228 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2SDM15015),
                editText229 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2RF15015),
                editText230 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2DDM15015),
                editText231 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2SDM15015),
                editText232 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2RF15015),
                editText233 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2DDM15020),
                editText234 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2SDM15020),
                editText235 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2RF15020),
                editText236 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2DDM15020),
                editText237 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2SDM15020),
                editText238 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2RF15020),
                editText239 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2DDM15025),
                editText240 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2SDM15025),
                editText241 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2RF15025),
                editText242 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2DDM15025),
                editText243 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2SDM15025),
                editText244 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2RF15025),
                editText245 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2DDM15030),
                editText246 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2SDM15030),
                editText247 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2RF15030),
                editText248 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2DDM15030),
                editText249 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2SDM15030),
                editText250 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2RF15030),
                editText251 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2DDM15035),
                editText252 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2SDM15035),
                editText253 = (EditText) findViewById(R.id.editTextLlzIndra70MFRNmlTx2RF15035),
                editText254 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2DDM15035),
                editText255 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2SDM15035),
                editText256 = (EditText) findViewById(R.id.editTextLlzIndra70MFRObsTx2RF15035),
                editText257 = (EditText) findViewById(R.id.editTextLlzIndra70MFRRemarks)};

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

        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.llzindra70mfr1);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);

        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(11);

        int[] editTextXPixel = {145,209,318,447,125,190,260,405,490,570,125,190,260,405,490,570,125,190,260,405,490,570,125,190,260,405,490,570,125,190,260,405,490,570,
                125,190,260,405,490,570,125,190,260,405,490,570,125,190,260,405,490,570,125,190,260,405,490,570,125,190,260,405,490,570,125,190,260,405,490,570,
                125,190,260,405,490,570,125,190,260,405,490,570,125,190,260,405,490,570,125,190,260,405,490,570,125,190,260,405,490,570,125,190,260,405,490,570,
                125,190,260,405,490,570,125,190,260,405,490,570,125,190,260,405,490,570,125,190,260,405,490,570};
        int[] editTextYPixel = {139,139,139,139,332,332,332,332,332,332,359,359,359,359,359,359,385,385,385,385,385,385,412,412,412,412,412,412,439,439,439,439,439,439,
                466,466,466,466,466,466,493,493,493,493,493,493,520,520,520,520,520,520,548,548,548,548,548,548,575,575,575,575,575,575,602,602,602,602,602,602,
                628,628,628,628,628,628,655,655,655,655,655,655,682,682,682,682,682,682,710,710,710,710,710,710,737,737,737,737,737,737,765,765,765,765,765,765,
                791,791,791,791,791,791,817,817,817,817,817,817,845,845,845,845,845,845,871,871,871,871,871,871};



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

        canvas.drawText(strData,582,139,titlePaint);//Printing Date on PDF

        myPdfdocument.finishPage(myPage1);


        //---------------------End of Page 1---------------

        //----------------------Page 2---------------------

        PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(723, 1024, 2).create();

        // start a page
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);

        canvas = myPage2.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.llzindra70mfr2);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(11);

        int[] editTextXPixel2 = {175,238,302,435,515,590,175,238,302,435,515,590,175,238,302,435,515,590,175,238,302,435,515,590,175,238,302,435,515,590,175,238,302,435,515,590,
                175,238,302,435,515,590,175,238,302,435,515,590,175,238,302,435,515,590,175,238,302,435,515,590,175,238,302,435,515,590,175,238,302,435,515,590,
                175,238,302,435,515,590,175,238,302,435,515,590,175,238,302,435,515,590,175,238,302,435,515,590,175,238,302,435,515,590,175,238,302,435,515,590,
                175,238,302,435,515,590,175,238,302,435,515,590,175,238,302,435,515,590,150};
        int[] editTextYPixel2 = {206,206,206,206,206,206,230,230,230,230,230,230,255,255,255,255,255,255,282,282,282,282,282,282,307,307,307,307,307,307,332,332,332,332,332,332,
                357,357,357,357,357,357,383,383,383,383,383,383,409,409,409,409,409,409,434,434,434,434,434,434,458,458,458,458,458,458,484,484,484,484,484,484,
                510,510,510,510,510,510,535,535,535,535,535,535,561,561,561,561,561,561,586,586,586,586,586,586,611,611,611,611,611,611,636,636,636,636,636,636,
                662,662,662,662,662,662,688,688,688,688,688,688,712,712,712,712,712,712,795};

        for(int i = 0; i < editTextXPixel2.length; i++){
            canvas.drawText( editTextDataForPDF[i+editTextXPixel.length],editTextXPixel2[i],editTextYPixel2[i],titlePaint);
        }

        myPdfdocument.finishPage(myPage2);

        //-------------------------End of Page 2-----------------

        //----------------------Page 3---------------------

        PdfDocument.PageInfo myPageInfo3 = new PdfDocument.PageInfo.Builder(723, 1024, 3).create();

        // start a page
        PdfDocument.Page myPage3 = myPdfdocument.startPage(myPageInfo3);

        canvas = myPage3.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.llzindra70mfr3);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(12);
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 90, 290, paint);

        myPdfdocument.finishPage(myPage3);

        //-------------------------End of Page 3-----------------

        ActivityCompat.requestPermissions(this, new String[]{

                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Navigation/LLZIndra70/Monthly Field/";// Change Here------------------
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //String targetPdf = directory_path + "test.pdf";
        //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
        String fileName = "Monthly Field LLZ Indra70 " + strData + ".pdf"; // Change Here--------------------------
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
        myFunctions.saveToParse(targetPdf, fileName,"ILS","Monthly",outputEditText,MyFunctions.specificCode("m"),"outputSwitch", "outputSpinner");// Change Here-----------------------

        // This function will send eMail using JavaMailAPI
        //myFunctions.sendEmail(String To, String Subject, String Message,String targetPdf,String desired_Filename)
        myFunctions.sendEmail(PersonalDetailsActivity.emailTo + "@aai.aero",
                "Monthly Field Maintenance of Indra70 LLZ done.",//Change Here-----------------------------
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