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

public class GpIndra70SixActivity extends AppCompatActivity {

    private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
    private MySignature mySignature = new MySignature(this);
    private int selectedID;//Copy
    private String selectedName;//Copy
    private EditText[] editTextArray;//Copy
    private Switch[] switchArray;//Copy
    private Spinner[] spinnerArray={};//Copy
    private String thisActivityName = "GpIndra70SixActivity"; //Change Here as per your class name


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gp_indra70_six);
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
                editText245, editText246, editText247, editText248, editText249, editText250, editText251, editText252,editText253, editText254, editText255, editText256, editText257, editText258,editText259, editText260, editText261, editText262, editText263,
                editText264, editText265, editText266, editText267,editText268, editText269, editText270, editText271, editText272, editText273, editText274, editText275, editText276, editText277, editText278, editText279, editText280, editText281, editText282,
                editText283,editText284, editText285, editText286, editText287, editText288, editText289, editText290, editText291, editText292, editText293, editText294, editText295, editText296, editText297, editText298, editText299, editText300, editText301,
                editText302, editText303, editText304, editText305, editText306, editText307, editText308,editText309, editText310, editText311, editText312, editText313, editText314, editText315, editText316, editText317, editText318, editText319, editText320,
                editText321, editText322, editText323, editText324,editText325, editText326, editText327, editText328, editText329, editText330, editText331, editText332, editText333, editText334, editText335, editText336, editText337, editText338, editText339,
                editText340, editText341, editText342, editText343, editText344, editText345, editText346, editText347, editText348, editText349, editText350, editText351, editText352,editText353, editText354, editText355, editText356, editText357, editText358,
                editText359, editText360, editText361, editText362, editText363, editText364, editText365, editText366, editText367,editText368, editText369, editText370, editText371, editText372, editText373, editText374, editText375, editText376, editText377,
                editText378, editText379, editText380, editText381, editText382, editText383,editText384, editText385, editText386, editText387, editText388, editText389, editText390, editText391, editText392, editText393, editText394, editText395, editText396,
                editText397, editText398, editText399, editText400, editText401, editText402;

        editTextArray = new EditText[]{
                editText1 = (EditText)  findViewById(R.id.editTextGpIndra70SixStation),
                editText2 = (EditText)  findViewById(R.id.editTextGpIndra70SixModel),
                editText3 = (EditText)  findViewById(R.id.editTextGpIndra70SixRWY),
                editText4 = (EditText)  findViewById(R.id.editTextGpIndra70SixCat),
                editText5 = (EditText)  findViewById(R.id.editTextGpIndra70SixFrequency),

                editText6 = (EditText)  findViewById(R.id.editTextGpIndra70SixUnitMon1CLDDM),
                editText7 = (EditText) findViewById(R.id.editTextGpIndra70SixLowMon1CLDDM),
                editText8 = (EditText) findViewById(R.id.editTextGpIndra70SixHighMon1CLDDM),
                editText9 = (EditText) findViewById(R.id.editTextGpIndra70SixWaLowMon1CLDDM),
                editText10 = (EditText) findViewById(R.id.editTextGpIndra70SixWaHighMon1CLDDM),
                editText11 = (EditText) findViewById(R.id.editTextGpIndra70SixLowMon2CLDDM),
                editText12 = (EditText) findViewById(R.id.editTextGpIndra70SixHighMon2CLDDM),
                editText13 = (EditText) findViewById(R.id.editTextGpIndra70SixWaLowMon2CLDDM),
                editText14 = (EditText) findViewById(R.id.editTextGpIndra70SixWaHighMon2CLDDM),

                editText15 = (EditText) findViewById(R.id.editTextGpIndra70SixUnitMon1CLSDM),
                editText16 = (EditText) findViewById(R.id.editTextGpIndra70SixLowMon1CLSDM),
                editText17 = (EditText) findViewById(R.id.editTextGpIndra70SixHighMon1CLSDM),
                editText18 = (EditText) findViewById(R.id.editTextGpIndra70SixWaLowMon1CLSDM),
                editText19 = (EditText) findViewById(R.id.editTextGpIndra70SixWaHighMon1CLSDM),
                editText20 = (EditText) findViewById(R.id.editTextGpIndra70SixLowMon2CLSDM),
                editText21 = (EditText) findViewById(R.id.editTextGpIndra70SixHighMon2CLSDM),
                editText22 = (EditText) findViewById(R.id.editTextGpIndra70SixWaLowMon2CLSDM),
                editText23 = (EditText) findViewById(R.id.editTextGpIndra70SixWaHighMon2CLSDM),

                editText24 = (EditText) findViewById(R.id.editTextGpIndra70SixUnitMon1CLRF),
                editText25 = (EditText) findViewById(R.id.editTextGpIndra70SixLowMon1CLRF),
                editText26 = (EditText) findViewById(R.id.editTextGpIndra70SixHighMon1CLRF),
                editText27 = (EditText) findViewById(R.id.editTextGpIndra70SixWaLowMon1CLRF),
                editText28 = (EditText) findViewById(R.id.editTextGpIndra70SixWaHighMon1CLRF),
                editText29 = (EditText) findViewById(R.id.editTextGpIndra70SixLowMon2CLRF),
                editText30 = (EditText) findViewById(R.id.editTextGpIndra70SixHighMon2CLRF),
                editText31 = (EditText) findViewById(R.id.editTextGpIndra70SixWaLowMon2CLRF),
                editText32 = (EditText) findViewById(R.id.editTextGpIndra70SixWaHighMon2CLRF),

                editText33 = (EditText) findViewById(R.id.editTextGpIndra70SixUnitMon1DSDDM),
                editText34 = (EditText) findViewById(R.id.editTextGpIndra70SixLowMon1DSDDM),
                editText35 = (EditText) findViewById(R.id.editTextGpIndra70SixHighMon1DSDDM),
                editText36 = (EditText) findViewById(R.id.editTextGpIndra70SixWaLowMon1DSDDM),
                editText37 = (EditText) findViewById(R.id.editTextGpIndra70SixWaHighMon1DSDDM),
                editText38 = (EditText) findViewById(R.id.editTextGpIndra70SixLowMon2DSDDM),
                editText39 = (EditText) findViewById(R.id.editTextGpIndra70SixHighMon2DSDDM),
                editText40 = (EditText) findViewById(R.id.editTextGpIndra70SixWaLowMon2DSDDM),
                editText41 = (EditText) findViewById(R.id.editTextGpIndra70SixWaHighMon2DSDDM),

                editText42 = (EditText) findViewById(R.id.editTextGpIndra70SixUnitMon1DSSDM),
                editText43 = (EditText) findViewById(R.id.editTextGpIndra70SixLowMon1DSSDM),
                editText44 = (EditText) findViewById(R.id.editTextGpIndra70SixHighMon1DSSDM),
                editText45 = (EditText) findViewById(R.id.editTextGpIndra70SixWaLowMon1DSSDM),
                editText46 = (EditText) findViewById(R.id.editTextGpIndra70SixWaHighMon1DSSDM),
                editText47  = (EditText) findViewById(R.id.editTextGpIndra70SixLowMon2DSSDM),
                editText48 = (EditText) findViewById(R.id.editTextGpIndra70SixHighMon2DSSDM),
                editText49 = (EditText) findViewById(R.id.editTextGpIndra70SixWaLowMon2DSSDM),
                editText50 = (EditText) findViewById(R.id.editTextGpIndra70SixWaHighMon2DSSDM),

                editText51 = (EditText) findViewById(R.id.editTextGpIndra70SixUnitMon1DSRF),
                editText52 = (EditText) findViewById(R.id.editTextGpIndra70SixLowMon1DSRF),
                editText53 = (EditText) findViewById(R.id.editTextGpIndra70SixHighMon1DSRF),
                editText54 = (EditText) findViewById(R.id.editTextGpIndra70SixWaLowMon1DSRF),
                editText55 = (EditText) findViewById(R.id.editTextGpIndra70SixWaHighMon1DSRF),
                editText56 = (EditText) findViewById(R.id.editTextGpIndra70SixLowMon2DSRF),
                editText57 = (EditText) findViewById(R.id.editTextGpIndra70SixHighMon2DSRF),
                editText58 = (EditText) findViewById(R.id.editTextGpIndra70SixWaLowMon2DSRF),
                editText59 = (EditText) findViewById(R.id.editTextGpIndra70SixWaHighMon2DSRF),

                editText60 = (EditText) findViewById(R.id.editTextGpIndra70SixUnitMon1NFDDM),
                editText61 = (EditText) findViewById(R.id.editTextGpIndra70SixLowMon1NFDDM),
                editText62 = (EditText) findViewById(R.id.editTextGpIndra70SixHighMon1NFDDM),
                editText63 = (EditText) findViewById(R.id.editTextGpIndra70SixWaLowMon1NFDDM),
                editText64 = (EditText) findViewById(R.id.editTextGpIndra70SixWaHighMon1NFDDM),
                editText65 = (EditText) findViewById(R.id.editTextGpIndra70SixLowMon2NFDDM),
                editText66 = (EditText) findViewById(R.id.editTextGpIndra70SixHighMon2NFDDM),
                editText67 = (EditText) findViewById(R.id.editTextGpIndra70SixWaLowMon2NFDDM),
                editText68 = (EditText) findViewById(R.id.editTextGpIndra70SixWaHighMon2NFDDM),

                editText69 = (EditText) findViewById(R.id.editTextGpIndra70SixUnitMon1NFSDM),
                editText70 = (EditText) findViewById(R.id.editTextGpIndra70SixLowMon1NFSDM),
                editText71 = (EditText) findViewById(R.id.editTextGpIndra70SixHighMon1NFSDM),
                editText72 = (EditText) findViewById(R.id.editTextGpIndra70SixWaLowMon1NFSDM),
                editText73 = (EditText) findViewById(R.id.editTextGpIndra70SixWaHighMon1NFSDM),
                editText74 = (EditText) findViewById(R.id.editTextGpIndra70SixLowMon2NFSDM),
                editText75 = (EditText) findViewById(R.id.editTextGpIndra70SixHighMon2NFSDM),
                editText76 = (EditText) findViewById(R.id.editTextGpIndra70SixWaLowMon2NFSDM),
                editText77 = (EditText) findViewById(R.id.editTextGpIndra70SixWaHighMon2NFSDM),

                editText78 = (EditText) findViewById(R.id.editTextGpIndra70SixUnitMon1NFRF),
                editText79 = (EditText) findViewById(R.id.editTextGpIndra70SixLowMon1NFRF),
                editText80 = (EditText) findViewById(R.id.editTextGpIndra70SixHighMon1NFRF),
                editText81 = (EditText) findViewById(R.id.editTextGpIndra70SixWaLowMon1NFRF),
                editText82 = (EditText) findViewById(R.id.editTextGpIndra70SixWaHighMon1NFRF),
                editText83 = (EditText) findViewById(R.id.editTextGpIndra70SixLowMon2NFRF),
                editText84 = (EditText) findViewById(R.id.editTextGpIndra70SixHighMon2NFRF),
                editText85 = (EditText) findViewById(R.id.editTextGpIndra70SixWaLowMon2NFRF),
                editText86 = (EditText) findViewById(R.id.editTextGpIndra70SixWaHighMon2NFRF),

                editText87 = (EditText) findViewById(R.id.editTextGpIndra70SixUnitMon1CLRDDM),
                editText88 = (EditText) findViewById(R.id.editTextGpIndra70SixLowMon1CLRDDM),
                editText89 = (EditText) findViewById(R.id.editTextGpIndra70SixHighMon1CLRDDM),
                editText90 = (EditText) findViewById(R.id.editTextGpIndra70SixWaLowMon1CLRDDM),
                editText91 = (EditText) findViewById(R.id.editTextGpIndra70SixWaHighMon1CLRDDM),
                editText92 = (EditText) findViewById(R.id.editTextGpIndra70SixLowMon2CLRDDM),
                editText93 = (EditText) findViewById(R.id.editTextGpIndra70SixHighMon2CLRDDM),
                editText94 = (EditText) findViewById(R.id.editTextGpIndra70SixWaLowMon2CLRDDM),
                editText95 = (EditText) findViewById(R.id.editTextGpIndra70SixWaHighMon2CLRDDM),

                editText96 = (EditText) findViewById(R.id.editTextGpIndra70SixUnitMon1CLRSDM),
                editText97 = (EditText) findViewById(R.id.editTextGpIndra70SixLowMon1CLRSDM),
                editText98 = (EditText) findViewById(R.id.editTextGpIndra70SixHighMon1CLRSDM),
                editText99 = (EditText) findViewById(R.id.editTextGpIndra70SixWaLowMon1CLRSDM),
                editText100 = (EditText) findViewById(R.id.editTextGpIndra70SixWaHighMon1CLRSDM),
                editText101 = (EditText) findViewById(R.id.editTextGpIndra70SixLowMon2CLRSDM),
                editText102 = (EditText) findViewById(R.id.editTextGpIndra70SixHighMon2CLRSDM),
                editText103 = (EditText) findViewById(R.id.editTextGpIndra70SixWaLowMon2CLRSDM),
                editText104 = (EditText) findViewById(R.id.editTextGpIndra70SixWaHighMon2CLRSDM),

                editText105 = (EditText) findViewById(R.id.editTextGpIndra70SixUnitMon1CLRRF),
                editText106 = (EditText) findViewById(R.id.editTextGpIndra70SixLowMon1CLRRF),
                editText107 = (EditText) findViewById(R.id.editTextGpIndra70SixHighMon1CLRRF),
                editText108 = (EditText) findViewById(R.id.editTextGpIndra70SixWaLowMon1CLRRF),
                editText109 = (EditText) findViewById(R.id.editTextGpIndra70SixWaHighMon1CLRRF),
                editText110 = (EditText) findViewById(R.id.editTextGpIndra70SixLowMon2CLRRF),
                editText111 = (EditText) findViewById(R.id.editTextGpIndra70SixHighMon2CLRRF),
                editText112 = (EditText) findViewById(R.id.editTextGpIndra70SixWaLowMon2CLRRF),
                editText113 = (EditText) findViewById(R.id.editTextGpIndra70SixWaHighMon2CLRRF),

                editText114 = (EditText) findViewById(R.id.editTextGpIndra70SixUnitMon1Diff),
                editText115 = (EditText) findViewById(R.id.editTextGpIndra70SixLowMon1Diff),
                editText116 = (EditText) findViewById(R.id.editTextGpIndra70SixHighMon1Diff),
                editText117 = (EditText) findViewById(R.id.editTextGpIndra70SixWaLowMon1Diff),
                editText118 = (EditText) findViewById(R.id.editTextGpIndra70SixWaHighMon1Diff),
                editText119 = (EditText) findViewById(R.id.editTextGpIndra70SixLowMon2Diff),
                editText120 = (EditText) findViewById(R.id.editTextGpIndra70SixHighMon2Diff),
                editText121 = (EditText) findViewById(R.id.editTextGpIndra70SixWaLowMon2Diff),
                editText122 = (EditText) findViewById(R.id.editTextGpIndra70SixWaHighMon2Diff),

                editText123 = (EditText) findViewById(R.id.editTextGpIndra70SixUnitMon1CLIDMOD),
                editText124 = (EditText) findViewById(R.id.editTextGpIndra70SixLowMon1CLIDMOD),
                editText125 = (EditText) findViewById(R.id.editTextGpIndra70SixHighMon1CLIDMOD),
                editText126 = (EditText) findViewById(R.id.editTextGpIndra70SixWaLowMon1CLIDMOD),
                editText127 = (EditText) findViewById(R.id.editTextGpIndra70SixWaHighMon1CLIDMOD),
                editText128 = (EditText) findViewById(R.id.editTextGpIndra70SixLowMon2CLIDMOD),
                editText129 = (EditText) findViewById(R.id.editTextGpIndra70SixHighMon2CLIDMOD),
                editText130 = (EditText)  findViewById(R.id.editTextGpIndra70SixWaLowMon2CLIDMOD),
                editText131 = (EditText)  findViewById(R.id.editTextGpIndra70SixWaHighMon2CLIDMOD),

                editText132 = (EditText)  findViewById(R.id.editTextGpIndra70SixUnitMon1CLIdAct),
                editText133 = (EditText) findViewById(R.id.editTextGpIndra70SixLowMon1CLIdAct),
                editText134 = (EditText) findViewById(R.id.editTextGpIndra70SixHighMon1CLIdAct),
                editText135 = (EditText) findViewById(R.id.editTextGpIndra70SixWaLowMon1CLIdAct),
                editText136 = (EditText) findViewById(R.id.editTextGpIndra70SixWaHighMon1CLIdAct),
                editText137 = (EditText) findViewById(R.id.editTextGpIndra70SixLowMon2CLIdAct),
                editText138 = (EditText) findViewById(R.id.editTextGpIndra70SixHighMon2CLIdAct),
                editText139 = (EditText) findViewById(R.id.editTextGpIndra70SixWaLowMon2CLIdAct),
                editText140 = (EditText) findViewById(R.id.editTextGpIndra70SixWaHighMon2CLIdAct),

                editText141 = (EditText) findViewById(R.id.editTextGpIndra70SixUnitMon1CLRIDMOD),
                editText142 = (EditText) findViewById(R.id.editTextGpIndra70SixLowMon1CLRIDMOD),
                editText143 = (EditText) findViewById(R.id.editTextGpIndra70SixHighMon1CLRIDMOD),
                editText144 = (EditText) findViewById(R.id.editTextGpIndra70SixWaLowMon1CLRIDMOD),
                editText145 = (EditText) findViewById(R.id.editTextGpIndra70SixWaHighMon1CLRIDMOD),
                editText146 = (EditText) findViewById(R.id.editTextGpIndra70SixLowMon2CLRIDMOD),
                editText147 = (EditText) findViewById(R.id.editTextGpIndra70SixHighMon2CLRIDMOD),
                editText148 = (EditText) findViewById(R.id.editTextGpIndra70SixWaLowMon2CLRIDMOD),
                editText149 = (EditText) findViewById(R.id.editTextGpIndra70SixWaHighMon2CLRIDMOD),

                editText150 = (EditText) findViewById(R.id.editTextGpIndra70SixUnitMon1CLRIdAct),
                editText151 = (EditText) findViewById(R.id.editTextGpIndra70SixLowMon1CLRIdAct),
                editText152 = (EditText) findViewById(R.id.editTextGpIndra70SixHighMon1CLRIdAct),
                editText153 = (EditText) findViewById(R.id.editTextGpIndra70SixWaLowMon1CLRIdAct),
                editText154 = (EditText) findViewById(R.id.editTextGpIndra70SixWaHighMon1CLRIdAct),
                editText155 = (EditText) findViewById(R.id.editTextGpIndra70SixLowMon2CLRIdAct),
                editText156 = (EditText) findViewById(R.id.editTextGpIndra70SixHighMon2CLRIdAct),
                editText157 = (EditText) findViewById(R.id.editTextGpIndra70SixWaLowMon2CLRIdAct),
                editText158 = (EditText) findViewById(R.id.editTextGpIndra70SixWaHighMon2CLRIdAct),

                editText159 = (EditText) findViewById(R.id.editTextGpIndra70SixUnitMon1SelfDDM),
                editText160 = (EditText) findViewById(R.id.editTextGpIndra70SixLowMon1SelfDDM),
                editText161 = (EditText) findViewById(R.id.editTextGpIndra70SixHighMon1SelfDDM),
                editText162 = (EditText) findViewById(R.id.editTextGpIndra70SixWaLowMon1SelfDDM),
                editText163 = (EditText) findViewById(R.id.editTextGpIndra70SixWaHighMon1SelfDDM),
                editText164 = (EditText) findViewById(R.id.editTextGpIndra70SixLowMon2SelfDDM),
                editText165 = (EditText) findViewById(R.id.editTextGpIndra70SixHighMon2SelfDDM),
                editText166 = (EditText) findViewById(R.id.editTextGpIndra70SixWaLowMon2SelfDDM),
                editText167 = (EditText) findViewById(R.id.editTextGpIndra70SixWaHighMon2SelfDDM),

                editText168 = (EditText) findViewById(R.id.editTextGpIndra70SixUnitMon1SelfSDM),
                editText169 = (EditText) findViewById(R.id.editTextGpIndra70SixLowMon1SelfSDM),
                editText170 = (EditText) findViewById(R.id.editTextGpIndra70SixHighMon1SelfSDM),
                editText171 = (EditText) findViewById(R.id.editTextGpIndra70SixWaLowMon1SelfSDM),
                editText172 = (EditText) findViewById(R.id.editTextGpIndra70SixWaHighMon1SelfSDM),
                editText173 = (EditText) findViewById(R.id.editTextGpIndra70SixLowMon2SelfSDM),
                editText174 = (EditText) findViewById(R.id.editTextGpIndra70SixHighMon2SelfSDM),
                editText175 = (EditText) findViewById(R.id.editTextGpIndra70SixWaLowMon2SelfSDM),
                editText176 = (EditText) findViewById(R.id.editTextGpIndra70SixWaHighMon2SelfSDM),

                editText177 = (EditText) findViewById(R.id.editTextGpIndra70SixUnitMon1SelfRF),
                editText178 = (EditText) findViewById(R.id.editTextGpIndra70SixLowMon1SelfRF),
                editText179 = (EditText) findViewById(R.id.editTextGpIndra70SixHighMon1SelfRF),
                editText180 = (EditText) findViewById(R.id.editTextGpIndra70SixWaLowMon1SelfRF),
                editText181 = (EditText) findViewById(R.id.editTextGpIndra70SixWaHighMon1SelfRF),
                editText182 = (EditText) findViewById(R.id.editTextGpIndra70SixLowMon2SelfRF),
                editText183 = (EditText) findViewById(R.id.editTextGpIndra70SixHighMon2SelfRF),
                editText184 = (EditText) findViewById(R.id.editTextGpIndra70SixWaLowMon2SelfRF),
                editText185 = (EditText) findViewById(R.id.editTextGpIndra70SixWaHighMon2SelfRF),

                editText186 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1LowCRS5),
                editText187 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1HighCRS5),
                editText188 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2LowCRS5),
                editText189 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2HighCRS5),
                editText190 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1LowCRS85),
                editText191 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1HighCRS85),
                editText192 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2LowCRS85),
                editText193 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2HighCRS85),
                editText194 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1LowCRS27CSB),
                editText195 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1HighCRS27CSB),
                editText196 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2LowCRS27CSB),
                editText197 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2HighCRS27CSB),
                editText198 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1LowCRS27SBO),
                editText199 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1HighCRS27SBO),
                editText200 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2LowCRS27SBO),
                editText201 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2HighCRS27SBO),
                editText202 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1LowCRS15),
                editText203 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1HighCRS15),
                editText204 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2LowCRS15),
                editText205 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2HighCRS15),
                editText206 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1LowCRSCSBFwdP),
                editText207 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1HighCRSCSBFwdP),
                editText208 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2LowCRSCSBFwdP),
                editText209 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2HighCRSCSBFwdP),
                editText210 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1LowCRSCSBRev),
                editText211 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1HighCRSCSBRev),
                editText212 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2LowCRSCSBRev),
                editText213 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2HighCRSCSBRev),
                editText214 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1LowCRSSBOFwdP),
                editText215 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1HighCRSSBOFwdP),
                editText216 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2LowCRSSBOFwdP),
                editText217 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2HighCRSSBOFwdP),
                editText218 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1LowCRSSBORev),
                editText219 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1HighCRSSBORev),
                editText220 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2LowCRSSBORev),
                editText221 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2HighCRSSBORev),
                editText222 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1LowCRSCSBI),
                editText223 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1HighCRSCSBI),
                editText224 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2LowCRSCSBI),
                editText225 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2HighCRSCSBI),
                editText226 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1LowCRSCSBQ),
                editText227 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1HighCRSCSBQ),
                editText228 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2LowCRSCSBQ),
                editText229 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2HighCRSCSBQ),
                editText230 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1LowCRSSBOI),
                editText231 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1HighCRSSBOI),
                editText232 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2LowCRSSBOI),
                editText233 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2HighCRSSBOI),
                editText234 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1LowCRSSBOQ),
                editText235 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1HighCRSSBOQ),
                editText236 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2LowCRSSBOQ),
                editText237 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2HighCRSSBOQ),
                editText238 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1LowCRSRevP),
                editText239 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1HighCRSRevP),
                editText240 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2LowCRSRevP),
                editText241 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2HighCRSRevP),
                editText242 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1LowCRSTemp),
                editText243 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1HighCRSTemp),
                editText244 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2LowCRSTemp),
                editText245 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2HighCRSTemp),
                editText246 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1LowCLR5),
                editText247 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1HighCLR5),
                editText248 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2LowCLR5),
                editText249 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2HighCLR5),
                editText250 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1LowCLR85),
                editText251 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1HighCLR85),
                editText252 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2LowCLR85),
                editText253 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2HighCLR85),
                editText254 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1LowCLR27CSB),
                editText255 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1HighCLR27CSB),
                editText256 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2LowCLR27CSB),
                editText257 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2HighCLR27CSB),
                editText258 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1LowCLR27SBO),
                editText259 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1HighCLR27SBO),
                editText260 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2LowCLR27SBO),
                editText261 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2HighCLR27SBO),
                editText262 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1LowCLR15),
                editText263 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1HighCLR15),
                editText264 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2LowCLR15),
                editText265 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2HighCLR15),
                editText266 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1LowCLRCSBFwdP),
                editText267 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1HighCLRCSBFwdP),
                editText268 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2LowCLRCSBFwdP),
                editText269 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2HighCLRCSBFwdP),
                editText270 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1LowCLRCSBRev),
                editText271 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1HighCLRCSBRev),
                editText272 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2LowCLRCSBRev),
                editText273 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2HighCLRCSBRev),
                editText274 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1LowCLRSBOFwdP),
                editText275 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1HighCLRSBOFwdP),
                editText276 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2LowCLRSBOFwdP),
                editText277 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2HighCLRSBOFwdP),
                editText278 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1LowCLRSBORev),
                editText279 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1HighCLRSBORev),
                editText280 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2LowCLRSBORev),
                editText281 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2HighCLRSBORev),
                editText282 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1LowCLRCSBI),
                editText283 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1HighCLRCSBI),
                editText284 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2LowCLRCSBI),
                editText285 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2HighCLRCSBI),
                editText286 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1LowCLRCSBQ),
                editText287 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1HighCLRCSBQ),
                editText288 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2LowCLRCSBQ),
                editText289 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2HighCLRCSBQ),
                editText290 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1LowCLRSBOI),
                editText291 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1HighCLRSBOI),
                editText292 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2LowCLRSBOI),
                editText293 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2HighCLRSBOI),
                editText294 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1LowCLRSBOQ),
                editText295 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1HighCLRSBOQ),
                editText296 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2LowCLRSBOQ),
                editText297 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2HighCLRSBOQ),
                editText298 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1LowCLRRevP),
                editText299 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1HighCLRRevP),
                editText300 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2LowCLRRevP),
                editText301 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2HighCLRRevP),
                editText302 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1LowCLRTemp),
                editText303 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1HighCLRTemp),
                editText304 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2LowCLRTemp),
                editText305 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2HighCLRTemp),
                editText306 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1LowCOUCSBA),
                editText307 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1HighCOUCSBA),
                editText308 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2LowCOUCSBA),
                editText309 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2HighCOUCSBA),
                editText310 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1LowCOUSBOA),
                editText311 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1HighCOUSBOA),
                editText312 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2LowCOUSBOA),
                editText313 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2HighCOUSBOA),
                editText314 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1LowCLRCSBA),
                editText315 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1HighCLRCSBA),
                editText316 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2LowCLRCSBA),
                editText317 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2HighCLRCSBA),
                editText318 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1LowCLRSBOA),
                editText319 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1HighCLRSBOA),
                editText320 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2LowCLRSBOA),
                editText321 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2HighCLRSBOA),

                editText322 = (EditText) findViewById(R.id.editTextGpIndra70SixPs1Low15),
                editText323 = (EditText) findViewById(R.id.editTextGpIndra70SixPs1High15),
                editText324 = (EditText) findViewById(R.id.editTextGpIndra70SixPs2Low15),
                editText325 = (EditText) findViewById(R.id.editTextGpIndra70SixPs2High15),
                editText326 = (EditText) findViewById(R.id.editTextGpIndra70SixPs1Low5),
                editText327 = (EditText) findViewById(R.id.editTextGpIndra70SixPs1High5),
                editText328 = (EditText) findViewById(R.id.editTextGpIndra70SixPs2Low5),
                editText329 = (EditText) findViewById(R.id.editTextGpIndra70SixPs2High5),
                editText330 = (EditText) findViewById(R.id.editTextGpIndra70SixPs1Low85),
                editText331 = (EditText) findViewById(R.id.editTextGpIndra70SixPs1High85),
                editText332 = (EditText) findViewById(R.id.editTextGpIndra70SixPs2Low85),
                editText333 = (EditText) findViewById(R.id.editTextGpIndra70SixPs2High85),
                editText334 = (EditText) findViewById(R.id.editTextGpIndra70SixPs1Low15V),
                editText335 = (EditText) findViewById(R.id.editTextGpIndra70SixPs1High15V),
                editText336 = (EditText) findViewById(R.id.editTextGpIndra70SixPs2Low15V),
                editText337 = (EditText) findViewById(R.id.editTextGpIndra70SixPs2High15V),

                editText338 = (EditText) findViewById(R.id.editTextGpIndra70SixB2DMLMon15),
                editText339 = (EditText) findViewById(R.id.editTextGpIndra70SixB2DMLMon25),
                editText340 = (EditText) findViewById(R.id.editTextGpIndra70SixB2DMLMon1STS),
                editText341 = (EditText) findViewById(R.id.editTextGpIndra70SixB2DMLMon2STS),
                editText342 = (EditText) findViewById(R.id.editTextGpIndra70SixB2DMLMon1DSPPFO),
                editText343 = (EditText) findViewById(R.id.editTextGpIndra70SixB2DMLMon2DSPPFO),
                editText344 = (EditText) findViewById(R.id.editTextGpIndra70SixB2DMLMon1DSPERR),
                editText345 = (EditText) findViewById(R.id.editTextGpIndra70SixB2DMLMon2DSPERR),
                editText346 = (EditText) findViewById(R.id.editTextGpIndra70SixB2DMLMon1RST),
                editText347 = (EditText) findViewById(R.id.editTextGpIndra70SixB2DMLMon2RST),
                editText348 = (EditText) findViewById(R.id.editTextGpIndra70SixB2DMLMon1SyncERR),
                editText349 = (EditText) findViewById(R.id.editTextGpIndra70SixB2DMLMon2SyncERR),
                editText350 = (EditText) findViewById(R.id.editTextGpIndra70SixB2DMLMon115),
                editText351 = (EditText) findViewById(R.id.editTextGpIndra70SixB2DMLMon215),
                editText352 = (EditText) findViewById(R.id.editTextGpIndra70SixB2DMLMon115V),
                editText353 = (EditText) findViewById(R.id.editTextGpIndra70SixB2DMLMon215V),

                editText354 = (EditText) findViewById(R.id.editTextGpIndra70SixB3DMLMon18),
                editText355 = (EditText) findViewById(R.id.editTextGpIndra70SixB3DMLMon28),
                editText356 = (EditText) findViewById(R.id.editTextGpIndra70SixB3DMLMon115),
                editText357 = (EditText) findViewById(R.id.editTextGpIndra70SixB3DMLMon215),
                editText358 = (EditText) findViewById(R.id.editTextGpIndra70SixB3DMLMon1Vint),
                editText359 = (EditText) findViewById(R.id.editTextGpIndra70SixB3DMLMon2Vint),
                editText360 = (EditText) findViewById(R.id.editTextGpIndra70SixB3DMLMon1FPGARst),
                editText361 = (EditText) findViewById(R.id.editTextGpIndra70SixB3DMLMon2FPGARst),
                editText362 = (EditText) findViewById(R.id.editTextGpIndra70SixB3DMLMon1FPGAErr),
                editText363 = (EditText) findViewById(R.id.editTextGpIndra70SixB3DMLMon2FPGAErr),
                editText364 = (EditText) findViewById(R.id.editTextGpIndra70SixB3DMLMon1SEU),
                editText365 = (EditText) findViewById(R.id.editTextGpIndra70SixB3DMLMon2SEU),
                editText366 = (EditText) findViewById(R.id.editTextGpIndra70SixB3DMLMon1ADC),
                editText367 = (EditText) findViewById(R.id.editTextGpIndra70SixB3DMLMon2ADC),
                editText368 = (EditText) findViewById(R.id.editTextGpIndra70SixB3DMLMon1PLL),
                editText369 = (EditText) findViewById(R.id.editTextGpIndra70SixB3DMLMon2PLL),
                editText370 = (EditText) findViewById(R.id.editTextGpIndra70SixB3DMLMon1FLASH),
                editText371 = (EditText) findViewById(R.id.editTextGpIndra70SixB3DMLMon2FLASH),

                editText372 = (EditText) findViewById(R.id.editTextGpIndra70SixB4DMLMon1FPGA),
                editText373 = (EditText) findViewById(R.id.editTextGpIndra70SixB4DMLMon2FPGA),
                editText374 = (EditText) findViewById(R.id.editTextGpIndra70SixB4DMLMon1CLPD),
                editText375 = (EditText) findViewById(R.id.editTextGpIndra70SixB4DMLMon2CLPD),
                editText376 = (EditText) findViewById(R.id.editTextGpIndra70SixB4DMLMon15),
                editText377 = (EditText) findViewById(R.id.editTextGpIndra70SixB4DMLMon25),
                editText378 = (EditText) findViewById(R.id.editTextGpIndra70SixB4DMLMon115),
                editText379 = (EditText) findViewById(R.id.editTextGpIndra70SixB4DMLMon215),
                editText380 = (EditText) findViewById(R.id.editTextGpIndra70SixB4DMLMon1Vint),
                editText381 = (EditText) findViewById(R.id.editTextGpIndra70SixB4DMLMon2Vint),

                editText382 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1CRSCSBFwd),
                editText383 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2CRSCSBFwd),
                editText384 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1CRSSBOFwd),
                editText385 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2CRSSBOFwd),
                editText386 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1CRSCSBLoop),
                editText387 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2CRSCSBLoop),
                editText388 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1CRSSBOLoop),
                editText389 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2CRSSBOLoop),
                editText390 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1CLRCSBFwd),
                editText391 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2CLRCSBFwd),
                editText392 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1CLRSBOFwd),
                editText393 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2CLRSBOFwd),
                editText394 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1CLRCSBLoop),
                editText395 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2CLRCSBLoop),
                editText396 = (EditText) findViewById(R.id.editTextGpIndra70SixTx1CLRSBOLoop),
                editText397 = (EditText) findViewById(R.id.editTextGpIndra70SixTx2CLRSBOLoop),
                editText398 = (EditText) findViewById(R.id.editTextGpIndra70SixSetTx1Morse),
                editText399 = (EditText) findViewById(R.id.editTextGpIndra70SixSetTx2Morse),

                editText400 = (EditText) findViewById(R.id.editTextGpIndra70SixSwitchTx1Morse),
                editText401 = (EditText) findViewById(R.id.editTextGpIndra70SixSwitchTx2Morse),
                editText402 = (EditText) findViewById(R.id.editTextGpIndra70SixRemarks)};

//Define and Initialize all Switches serially here

        Switch  switch1,switch2,switch3,switch4;
        switchArray = new Switch[]{
                switch1 = (Switch) findViewById(R.id.switchGpIndra70SixSwitchTx190),
                switch2 = (Switch) findViewById(R.id.switchGpIndra70SixSwitchTx290),
                switch3 = (Switch) findViewById(R.id.switchGpIndra70SixSwitchTx1150),
                switch4 = (Switch) findViewById(R.id.switchGpIndra70SixSwitchTx2150)};
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

        String outputSwitch = myFunctions.getSwitchStatusForPDF(switchArray);

        String[] switchDataForPDF = myFunctions.seperateSwitchData(outputSwitch);

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

        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.gpindra70six1);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);

        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(11);

        int[] editTextXPixel = {121,596,100,200,392,186,243,287,335,404,458,516,570,641,186,243,287,335,404,458,516,570,641,186,243,287,335,404,458,516,570,641,
                186,243,287,335,404,458,516,570,641,186,243,287,335,404,458,516,570,641,186,243,287,335,404,458,516,570,641,186,243,287,335,404,458,516,570,641,
                186,243,287,335,404,458,516,570,641,186,243,287,335,404,458,516,570,641,186,243,287,335,404,458,516,570,641,186,243,287,335,404,458,516,570,641,
                186,243,287,335,404,458,516,570,641,186,243,287,335,404,458,516,570,641,186,243,287,335,404,458,516,570,641,186,243,287,335,404,458,516,570,641,
                186,243,287,335,404,458,516,570,641,186,243,287,335,404,458,516,570,641,186,243,287,335,404,458,516,570,641,186,243,287,335,404,458,516,570,641,
                186,243,287,335,404,458,516,570,641};
        int[] editTextYPixel = {179,179,212,212,212,332,332,332,332,332,332,332,332,332,355,355,355,355,355,355,355,355,355,380,380,380,380,380,380,380,380,380,
                401,401,401,401,401,401,401,401,401,427,427,427,427,427,427,427,427,427,450,450,450,450,450,450,450,450,450,474,474,474,474,474,474,474,474,474,
                496,496,496,496,496,496,496,496,496,521,521,521,521,521,521,521,521,521,546,546,546,546,546,546,546,546,546,569,569,569,569,569,569,569,569,569,
                591,591,591,591,591,591,591,591,591,615,615,615,615,615,615,615,615,615,639,639,639,639,639,639,639,639,639,662,662,662,662,662,662,662,662,662,
                686,686,686,686,686,686,686,686,686,709,709,709,709,709,709,709,709,709,733,733,733,733,733,733,733,733,733,758,758,758,758,758,758,758,758,758,
                780,780,780,780,780,780,780,780,780};



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

        canvas.drawText(strData,560,212,titlePaint);//Printing Date on PDF

        myPdfdocument.finishPage(myPage1);


        //---------------------End of Page 1---------------

        //----------------------Page 2---------------------

        PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(723, 1024, 2).create();

        // start a page
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);

        canvas = myPage2.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.gpindra70six2);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(11);

        int[] editTextXPixel2 = {275,395,505,610,275,395,505,610,275,395,505,610,275,395,505,610,275,395,505,610,275,395,505,610,275,395,505,610,
                275,395,505,610,275,395,505,610,275,395,505,610,275,395,505,610,275,395,505,610,275,395,505,610,275,395,505,610,275,395,505,610,
                275,395,505,610,275,395,505,610,275,395,505,610,275,395,505,610,275,395,505,610,275,395,505,610,275,395,505,610,275,395,505,610};
        int[] editTextYPixel2 = {262,262,262,262,289,289,289,289,316,316,316,316,344,344,344,344,373,373,373,373,400,400,400,400,427,427,427,427,
                454,454,454,454,482,482,482,482,510,510,510,510,537,537,537,537,565,565,565,565,593,593,593,593,620,620,620,620,649,649,649,649,
                704,704,704,704,732,732,732,732,758,758,758,758,786,786,786,786,814,814,814,814,842,842,842,842,869,869,869,869,897,897,897,897};

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
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.gpindra70six3);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(11);

        int[] editTextXPixel3 = {275,395,505,610,275,395,505,610,275,395,505,610,275,395,505,610,275,395,505,610,275,395,505,610,275,395,505,610,
                275,395,505,610,275,395,505,610,275,395,505,610,275,395,505,610,275,395,505,610,275,395,505,610,275,395,505,610,275,395,505,610,
                500,615,500,615,500,615,500,615,500,615,500,615};
        int[] editTextYPixel3 = {121,121,121,121,150,150,150,150,176,176,176,176,204,204,204,204,231,231,231,231,260,260,260,260,285,285,285,285,
                314,314,314,314,341,341,341,341,369,369,369,369,398,398,398,398,506,506,506,506,533,533,533,533,561,561,561,561,590,590,590,590,
                750,750,778,778,811,811,838,838,868,868,894,894};

        for(int i = 0; i < editTextXPixel3.length; i++){
            canvas.drawText( editTextDataForPDF[i+editTextXPixel.length+editTextXPixel2.length],editTextXPixel3[i],editTextYPixel3[i],titlePaint);
        }


        myPdfdocument.finishPage(myPage3);

        //-------------------------End of Page 3-----------------

        //----------------------Page 4---------------------

        PdfDocument.PageInfo myPageInfo4 = new PdfDocument.PageInfo.Builder(723, 1024, 4).create();

        // start a page
        PdfDocument.Page myPage4 = myPdfdocument.startPage(myPageInfo4);

        canvas = myPage4.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.gpindra70six4);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(11);

        int[] editTextXPixel4 = {500,615,500,615,500,615,500,615,500,615,500,615,500,615,500,615,500,615,500,615,500,615,500,615,500,615,500,615,500,615,500,615};
        int[] editTextYPixel4 = {124,124,153,153,235,235,268,268,299,299,332,332,363,363,395,395,428,428,459,459,490,490,549,549,576,576,601,601,628,628,661,661};

        for(int i = 0; i < editTextXPixel4.length; i++){
            canvas.drawText( editTextDataForPDF[i+editTextXPixel.length+editTextXPixel2.length+editTextXPixel3.length],editTextXPixel4[i],editTextYPixel4[i],titlePaint);
        }

        myPdfdocument.finishPage(myPage4);

        //-------------------------End of Page 4-----------------

        //----------------------Page 5---------------------

        PdfDocument.PageInfo myPageInfo5 = new PdfDocument.PageInfo.Builder(723, 1024, 5).create();

        // start a page
        PdfDocument.Page myPage5 = myPdfdocument.startPage(myPageInfo5);

        canvas = myPage5.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.gpindra70six5);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(12);

        int[] editTextXPixel5 = {305,462,305,462,305,462,305,462,305,462,305,462,305,462,305,462,305,462,500,595,100};
        int[] editTextYPixel5 = {215,215,237,237,258,258,281,281,302,302,325,325,345,345,367,367,389,389,508,508,558};

        int[] switchXPixel5 = {500,595,500,595};
        int[] switchYPixel5 = {473,473,490,490};


        for(int i = 0; i < editTextXPixel5.length; i++){
            canvas.drawText( editTextDataForPDF[i+editTextXPixel.length+editTextXPixel2.length+editTextXPixel3.length+editTextXPixel4.length],editTextXPixel5[i],editTextYPixel5[i],titlePaint);
        }

        for(int i = 0; i < switchXPixel5.length; i++){
            canvas.drawText( switchDataForPDF[i],switchXPixel5[i],switchYPixel5[i],titlePaint);
        }

        titlePaint.setTextSize(12);
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 100, 605, paint);


        myPdfdocument.finishPage(myPage5);

        //-------------------------End of Page 5-----------------



        ActivityCompat.requestPermissions(this, new String[]{

                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Navigation/GPIndra70/Six Monthly/";// Change Here------------------
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //String targetPdf = directory_path + "test.pdf";
        //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
        String fileName = "Six Monthly GP Indra70 " + strData + ".pdf"; // Change Here--------------------------
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
        myFunctions.saveToParse(targetPdf, fileName,"ILS","Six Monthly",outputEditText,MyFunctions.specificCode("sm"),outputSwitch, "outputSpinner");// Change Here-----------------------

        // This function will send eMail using JavaMailAPI
        //myFunctions.sendEmail(String To, String Subject, String Message,String targetPdf,String desired_Filename)
        myFunctions.sendEmail(PersonalDetailsActivity.emailTo + "@aai.aero",
                "Six Monthly Maintenance of Indra70 GP done.",//Change Here-----------------------------
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