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

public class LlzIndra70SixActivity extends AppCompatActivity {
    private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
    private MySignature mySignature = new MySignature(this);
    private int selectedID;//Copy
    private String selectedName;//Copy
    private EditText[] editTextArray;//Copy
    private Switch[] switchArray;//Copy
    private Spinner[] spinnerArray={};//Copy
    private String thisActivityName = "LlzIndra70SixActivity"; //Change Here as per your class name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llz_indra70_six);
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
                editText397, editText398, editText399, editText400, editText401, editText402, editText403, editText404, editText405, editText406, editText407, editText408,editText409, editText410, editText411, editText412, editText413, editText414, editText415,
                editText416, editText417, editText418, editText419, editText420, editText421, editText422, editText423, editText424,editText425, editText426, editText427, editText428, editText429, editText430, editText431, editText432, editText433, editText434,
                editText435, editText436, editText437, editText438, editText439, editText440, editText441, editText442, editText443, editText444, editText445, editText446, editText447, editText448, editText449, editText450, editText451, editText452,editText453,
                editText454, editText455, editText456, editText457, editText458, editText459, editText460, editText461, editText462, editText463, editText464, editText465, editText466, editText467,editText468, editText469, editText470, editText471, editText472,
                editText473, editText474, editText475, editText476, editText477, editText478, editText479, editText480, editText481, editText482, editText483,editText484, editText485, editText486, editText487, editText488, editText489, editText490, editText491,
                editText492, editText493, editText494, editText495, editText496, editText497, editText498, editText499,editText500, editText501, editText502;

        editTextArray = new EditText[]{
                editText1 = (EditText)  findViewById(R.id.editTextLlzIndra70SixStation),
                editText2 = (EditText)  findViewById(R.id.editTextLlzIndra70SixModel),
                editText3 = (EditText)  findViewById(R.id.editTextLlzIndra70SixRWY),
                editText4 = (EditText)  findViewById(R.id.editTextLlzIndra70SixCat),
                editText5 = (EditText)  findViewById(R.id.editTextLlzIndra70SixFrequency),
                editText6 = (EditText)  findViewById(R.id.editTextLlzIndra70SixIdent),

                editText7 = (EditText)  findViewById(R.id.editTextLlzIndra70SixUnitMon1CLDDM),
                editText8 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon1CLDDM),
                editText9 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon1CLDDM),
                editText10 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon1CLDDM),
                editText11 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon1CLDDM),
                editText12 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon2CLDDM),
                editText13 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon2CLDDM),
                editText14 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon2CLDDM),
                editText15 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon2CLDDM),

                editText16 = (EditText) findViewById(R.id.editTextLlzIndra70SixUnitMon1CLSDM),
                editText17 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon1CLSDM),
                editText18 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon1CLSDM),
                editText19 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon1CLSDM),
                editText20 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon1CLSDM),
                editText21 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon2CLSDM),
                editText22 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon2CLSDM),
                editText23 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon2CLSDM),
                editText24 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon2CLSDM),

                editText25 = (EditText) findViewById(R.id.editTextLlzIndra70SixUnitMon1CLRF),
                editText26 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon1CLRF),
                editText27 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon1CLRF),
                editText28 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon1CLRF),
                editText29 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon1CLRF),
                editText30 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon2CLRF),
                editText31 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon2CLRF),
                editText32 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon2CLRF),
                editText33 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon2CLRF),

                editText34 = (EditText) findViewById(R.id.editTextLlzIndra70SixUnitMon1DSDDM),
                editText35 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon1DSDDM),
                editText36 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon1DSDDM),
                editText37 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon1DSDDM),
                editText38 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon1DSDDM),
                editText39 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon2DSDDM),
                editText40 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon2DSDDM),
                editText41 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon2DSDDM),
                editText42 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon2DSDDM),

                editText43 = (EditText) findViewById(R.id.editTextLlzIndra70SixUnitMon1DSSDM),
                editText44 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon1DSSDM),
                editText45 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon1DSSDM),
                editText46 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon1DSSDM),
                editText47 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon1DSSDM),
                editText48  = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon2DSSDM),
                editText49 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon2DSSDM),
                editText50 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon2DSSDM),
                editText51 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon2DSSDM),

                editText52 = (EditText) findViewById(R.id.editTextLlzIndra70SixUnitMon1DSRF),
                editText53 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon1DSRF),
                editText54 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon1DSRF),
                editText55 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon1DSRF),
                editText56 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon1DSRF),
                editText57 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon2DSRF),
                editText58 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon2DSRF),
                editText59 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon2DSRF),
                editText60 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon2DSRF),

                editText61 = (EditText) findViewById(R.id.editTextLlzIndra70SixUnitMon1NFDDM),
                editText62 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon1NFDDM),
                editText63 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon1NFDDM),
                editText64 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon1NFDDM),
                editText65 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon1NFDDM),
                editText66 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon2NFDDM),
                editText67 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon2NFDDM),
                editText68 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon2NFDDM),
                editText69 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon2NFDDM),

                editText70 = (EditText) findViewById(R.id.editTextLlzIndra70SixUnitMon1NFSDM),
                editText71 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon1NFSDM),
                editText72 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon1NFSDM),
                editText73 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon1NFSDM),
                editText74 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon1NFSDM),
                editText75 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon2NFSDM),
                editText76 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon2NFSDM),
                editText77 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon2NFSDM),
                editText78 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon2NFSDM),

                editText79 = (EditText) findViewById(R.id.editTextLlzIndra70SixUnitMon1NFRF),
                editText80 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon1NFRF),
                editText81 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon1NFRF),
                editText82 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon1NFRF),
                editText83 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon1NFRF),
                editText84 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon2NFRF),
                editText85 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon2NFRF),
                editText86 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon2NFRF),
                editText87 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon2NFRF),

                editText88 = (EditText) findViewById(R.id.editTextLlzIndra70SixUnitMon1CLRDDM),
                editText89 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon1CLRDDM),
                editText90 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon1CLRDDM),
                editText91 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon1CLRDDM),
                editText92 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon1CLRDDM),
                editText93 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon2CLRDDM),
                editText94 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon2CLRDDM),
                editText95 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon2CLRDDM),
                editText96 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon2CLRDDM),

                editText97 = (EditText) findViewById(R.id.editTextLlzIndra70SixUnitMon1CLRSDM),
                editText98 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon1CLRSDM),
                editText99 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon1CLRSDM),
                editText100 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon1CLRSDM),
                editText101 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon1CLRSDM),
                editText102 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon2CLRSDM),
                editText103 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon2CLRSDM),
                editText104 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon2CLRSDM),
                editText105 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon2CLRSDM),

                editText106 = (EditText) findViewById(R.id.editTextLlzIndra70SixUnitMon1CLRRF),
                editText107 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon1CLRRF),
                editText108 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon1CLRRF),
                editText109 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon1CLRRF),
                editText110 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon1CLRRF),
                editText111 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon2CLRRF),
                editText112 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon2CLRRF),
                editText113 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon2CLRRF),
                editText114 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon2CLRRF),

                editText115 = (EditText) findViewById(R.id.editTextLlzIndra70SixUnitMon1Diff),
                editText116 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon1Diff),
                editText117 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon1Diff),
                editText118 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon1Diff),
                editText119 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon1Diff),
                editText120 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon2Diff),
                editText121 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon2Diff),
                editText122 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon2Diff),
                editText123 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon2Diff),

                editText124 = (EditText) findViewById(R.id.editTextLlzIndra70SixUnitMon1CLIDMOD),
                editText125 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon1CLIDMOD),
                editText126 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon1CLIDMOD),
                editText127 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon1CLIDMOD),
                editText128 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon1CLIDMOD),
                editText129 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon2CLIDMOD),
                editText130 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon2CLIDMOD),
                editText131 = (EditText)  findViewById(R.id.editTextLlzIndra70SixWaLowMon2CLIDMOD),
                editText132 = (EditText)  findViewById(R.id.editTextLlzIndra70SixWaHighMon2CLIDMOD),

                editText133 = (EditText)  findViewById(R.id.editTextLlzIndra70SixUnitMon1CLIdAct),
                editText134 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon1CLIdAct),
                editText135 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon1CLIdAct),
                editText136 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon1CLIdAct),
                editText137 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon1CLIdAct),
                editText138 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon2CLIdAct),
                editText139 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon2CLIdAct),
                editText140 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon2CLIdAct),
                editText141 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon2CLIdAct),

                editText142 = (EditText) findViewById(R.id.editTextLlzIndra70SixUnitMon1CLRIDMOD),
                editText143 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon1CLRIDMOD),
                editText144 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon1CLRIDMOD),
                editText145 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon1CLRIDMOD),
                editText146 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon1CLRIDMOD),
                editText147 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon2CLRIDMOD),
                editText148 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon2CLRIDMOD),
                editText149 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon2CLRIDMOD),
                editText150 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon2CLRIDMOD),

                editText151 = (EditText) findViewById(R.id.editTextLlzIndra70SixUnitMon1CLRIdAct),
                editText152 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon1CLRIdAct),
                editText153 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon1CLRIdAct),
                editText154 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon1CLRIdAct),
                editText155 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon1CLRIdAct),
                editText156 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon2CLRIdAct),
                editText157 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon2CLRIdAct),
                editText158 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon2CLRIdAct),
                editText159 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon2CLRIdAct),

                editText160 = (EditText) findViewById(R.id.editTextLlzIndra70SixUnitMon1DCO),
                editText161 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon1DCO),
                editText162 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon1DCO),
                editText163 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon1DCO),
                editText164 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon1DCO),
                editText165 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon2DCO),
                editText166 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon2DCO),
                editText167 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon2DCO),
                editText168 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon2DCO),

                editText169 = (EditText) findViewById(R.id.editTextLlzIndra70SixUnitMon1DC1),
                editText170 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon1DC1),
                editText171 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon1DC1),
                editText172 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon1DC1),
                editText173 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon1DC1),
                editText174 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon2DC1),
                editText175 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon2DC1),
                editText176 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon2DC1),
                editText177 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon2DC1),

                editText178 = (EditText) findViewById(R.id.editTextLlzIndra70SixUnitMon1DC2),
                editText179 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon1DC2),
                editText180 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon1DC2),
                editText181 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon1DC2),
                editText182 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon1DC2),
                editText183 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon2DC2),
                editText184 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon2DC2),
                editText185 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon2DC2),
                editText186 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon2DC2),

                editText187 = (EditText) findViewById(R.id.editTextLlzIndra70SixUnitMon1DC3),
                editText188 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon1DC3),
                editText189 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon1DC3),
                editText190 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon1DC3),
                editText191 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon1DC3),
                editText192 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon2DC3),
                editText193 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon2DC3),
                editText194 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon2DC3),
                editText195 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon2DC3),

                editText196 = (EditText) findViewById(R.id.editTextLlzIndra70SixUnitMon1ADDM),
                editText197 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon1ADDM),
                editText198 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon1ADDM),
                editText199 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon1ADDM),
                editText200 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon1ADDM),
                editText201 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon2ADDM),
                editText202 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon2ADDM),
                editText203 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon2ADDM),
                editText204 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon2ADDM),

                editText205 = (EditText) findViewById(R.id.editTextLlzIndra70SixUnitMon1ASDM),
                editText206 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon1ASDM),
                editText207 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon1ASDM),
                editText208 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon1ASDM),
                editText209 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon1ASDM),
                editText210 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon2ASDM),
                editText211 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon2ASDM),
                editText212 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon2ASDM),
                editText213 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon2ASDM),

                editText214 = (EditText) findViewById(R.id.editTextLlzIndra70SixUnitMon1ARF),
                editText215 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon1ARF),
                editText216 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon1ARF),
                editText217 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon1ARF),
                editText218 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon1ARF),
                editText219 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon2ARF),
                editText220 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon2ARF),
                editText221 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon2ARF),
                editText222 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon2ARF),

                editText223 = (EditText) findViewById(R.id.editTextLlzIndra70SixUnitMon1BDDM),
                editText224 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon1BDDM),
                editText225 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon1BDDM),
                editText226 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon1BDDM),
                editText227 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon1BDDM),
                editText228 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon2BDDM),
                editText229 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon2BDDM),
                editText230 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon2BDDM),
                editText231 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon2BDDM),

                editText232 = (EditText) findViewById(R.id.editTextLlzIndra70SixUnitMon1BSDM),
                editText233 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon1BSDM),
                editText234 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon1BSDM),
                editText235 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon1BSDM),
                editText236 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon1BSDM),
                editText237 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon2BSDM),
                editText238 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon2BSDM),
                editText239 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon2BSDM),
                editText240 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon2BSDM),

                editText241 = (EditText) findViewById(R.id.editTextLlzIndra70SixUnitMon1BRF),
                editText242 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon1BRF),
                editText243 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon1BRF),
                editText244 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon1BRF),
                editText245 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon1BRF),
                editText246 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon2BRF),
                editText247 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon2BRF),
                editText248 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon2BRF),
                editText249 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon2BRF),

                editText250 = (EditText) findViewById(R.id.editTextLlzIndra70SixUnitMon1Exe),
                editText251 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon1Exe),
                editText252 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon1Exe),
                editText253 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon1Exe),
                editText254 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon1Exe),
                editText255 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon2Exe),
                editText256 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon2Exe),
                editText257 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon2Exe),
                editText258 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon2Exe),

                editText259 = (EditText) findViewById(R.id.editTextLlzIndra70SixUnitMon1SelfDDM),
                editText260 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon1SelfDDM),
                editText261 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon1SelfDDM),
                editText262 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon1SelfDDM),
                editText263 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon1SelfDDM),
                editText264 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon2SelfDDM),
                editText265 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon2SelfDDM),
                editText266 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon2SelfDDM),
                editText267 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon2SelfDDM),

                editText268 = (EditText) findViewById(R.id.editTextLlzIndra70SixUnitMon1SelfSDM),
                editText269 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon1SelfSDM),
                editText270 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon1SelfSDM),
                editText271 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon1SelfSDM),
                editText272 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon1SelfSDM),
                editText273 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon2SelfSDM),
                editText274 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon2SelfSDM),
                editText275 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon2SelfSDM),
                editText276 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon2SelfSDM),

                editText277 = (EditText) findViewById(R.id.editTextLlzIndra70SixUnitMon1SelfRF),
                editText278 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon1SelfRF),
                editText279 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon1SelfRF),
                editText280 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon1SelfRF),
                editText281 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon1SelfRF),
                editText282 = (EditText) findViewById(R.id.editTextLlzIndra70SixLowMon2SelfRF),
                editText283 = (EditText) findViewById(R.id.editTextLlzIndra70SixHighMon2SelfRF),
                editText284 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaLowMon2SelfRF),
                editText285 = (EditText) findViewById(R.id.editTextLlzIndra70SixWaHighMon2SelfRF),

                editText286 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1LowCRS5),
                editText287 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1HighCRS5),
                editText288 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2LowCRS5),
                editText289 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2HighCRS5),
                editText290 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1LowCRS85),
                editText291 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1HighCRS85),
                editText292 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2LowCRS85),
                editText293 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2HighCRS85),
                editText294 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1LowCRS27CSB),
                editText295 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1HighCRS27CSB),
                editText296 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2LowCRS27CSB),
                editText297 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2HighCRS27CSB),
                editText298 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1LowCRS27SBO),
                editText299 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1HighCRS27SBO),
                editText300 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2LowCRS27SBO),
                editText301 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2HighCRS27SBO),
                editText302 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1LowCRS15),
                editText303 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1HighCRS15),
                editText304 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2LowCRS15),
                editText305 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2HighCRS15),
                editText306 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1LowCRSCSBFwdP),
                editText307 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1HighCRSCSBFwdP),
                editText308 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2LowCRSCSBFwdP),
                editText309 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2HighCRSCSBFwdP),
                editText310 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1LowCRSCSBRev),
                editText311 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1HighCRSCSBRev),
                editText312 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2LowCRSCSBRev),
                editText313 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2HighCRSCSBRev),
                editText314 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1LowCRSSBOFwdP),
                editText315 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1HighCRSSBOFwdP),
                editText316 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2LowCRSSBOFwdP),
                editText317 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2HighCRSSBOFwdP),
                editText318 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1LowCRSSBORev),
                editText319 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1HighCRSSBORev),
                editText320 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2LowCRSSBORev),
                editText321 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2HighCRSSBORev),
                editText322 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1LowCRSCSBI),
                editText323 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1HighCRSCSBI),
                editText324 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2LowCRSCSBI),
                editText325 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2HighCRSCSBI),
                editText326 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1LowCRSCSBQ),
                editText327 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1HighCRSCSBQ),
                editText328 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2LowCRSCSBQ),
                editText329 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2HighCRSCSBQ),
                editText330 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1LowCRSSBOI),
                editText331 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1HighCRSSBOI),
                editText332 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2LowCRSSBOI),
                editText333 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2HighCRSSBOI),
                editText334 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1LowCRSSBOQ),
                editText335 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1HighCRSSBOQ),
                editText336 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2LowCRSSBOQ),
                editText337 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2HighCRSSBOQ),
                editText338 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1LowCRSRevP),
                editText339 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1HighCRSRevP),
                editText340 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2LowCRSRevP),
                editText341 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2HighCRSRevP),
                editText342 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1LowCRSTemp),
                editText343 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1HighCRSTemp),
                editText344 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2LowCRSTemp),
                editText345 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2HighCRSTemp),
                editText346 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1LowCLR5),
                editText347 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1HighCLR5),
                editText348 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2LowCLR5),
                editText349 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2HighCLR5),
                editText350 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1LowCLR85),
                editText351 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1HighCLR85),
                editText352 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2LowCLR85),
                editText353 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2HighCLR85),
                editText354 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1LowCLR27CSB),
                editText355 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1HighCLR27CSB),
                editText356 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2LowCLR27CSB),
                editText357 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2HighCLR27CSB),
                editText358 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1LowCLR27SBO),
                editText359 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1HighCLR27SBO),
                editText360 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2LowCLR27SBO),
                editText361 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2HighCLR27SBO),
                editText362 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1LowCLR15),
                editText363 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1HighCLR15),
                editText364 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2LowCLR15),
                editText365 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2HighCLR15),
                editText366 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1LowCLRCSBFwdP),
                editText367 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1HighCLRCSBFwdP),
                editText368 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2LowCLRCSBFwdP),
                editText369 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2HighCLRCSBFwdP),
                editText370 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1LowCLRCSBRev),
                editText371 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1HighCLRCSBRev),
                editText372 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2LowCLRCSBRev),
                editText373 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2HighCLRCSBRev),
                editText374 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1LowCLRSBOFwdP),
                editText375 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1HighCLRSBOFwdP),
                editText376 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2LowCLRSBOFwdP),
                editText377 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2HighCLRSBOFwdP),
                editText378 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1LowCLRSBORev),
                editText379 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1HighCLRSBORev),
                editText380 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2LowCLRSBORev),
                editText381 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2HighCLRSBORev),
                editText382 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1LowCLRCSBI),
                editText383 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1HighCLRCSBI),
                editText384 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2LowCLRCSBI),
                editText385 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2HighCLRCSBI),
                editText386 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1LowCLRCSBQ),
                editText387 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1HighCLRCSBQ),
                editText388 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2LowCLRCSBQ),
                editText389 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2HighCLRCSBQ),
                editText390 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1LowCLRSBOI),
                editText391 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1HighCLRSBOI),
                editText392 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2LowCLRSBOI),
                editText393 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2HighCLRSBOI),
                editText394 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1LowCLRSBOQ),
                editText395 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1HighCLRSBOQ),
                editText396 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2LowCLRSBOQ),
                editText397 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2HighCLRSBOQ),
                editText398 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1LowCLRRevP),
                editText399 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1HighCLRRevP),
                editText400 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2LowCLRRevP),
                editText401 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2HighCLRRevP),
                editText402 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1LowCLRTemp),
                editText403 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1HighCLRTemp),
                editText404 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2LowCLRTemp),
                editText405 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2HighCLRTemp),
                editText406 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1LowCOUCSBA),
                editText407 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1HighCOUCSBA),
                editText408 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2LowCOUCSBA),
                editText409 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2HighCOUCSBA),
                editText410 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1LowCOUSBOA),
                editText411 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1HighCOUSBOA),
                editText412 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2LowCOUSBOA),
                editText413 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2HighCOUSBOA),
                editText414 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1LowCLRCSBA),
                editText415 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1HighCLRCSBA),
                editText416 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2LowCLRCSBA),
                editText417 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2HighCLRCSBA),
                editText418 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1LowCLRSBOA),
                editText419 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1HighCLRSBOA),
                editText420 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2LowCLRSBOA),
                editText421 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2HighCLRSBOA),

                editText422 = (EditText) findViewById(R.id.editTextLlzIndra70SixPs1Low15),
                editText423 = (EditText) findViewById(R.id.editTextLlzIndra70SixPs1High15),
                editText424 = (EditText) findViewById(R.id.editTextLlzIndra70SixPs2Low15),
                editText425 = (EditText) findViewById(R.id.editTextLlzIndra70SixPs2High15),
                editText426 = (EditText) findViewById(R.id.editTextLlzIndra70SixPs1Low5),
                editText427 = (EditText) findViewById(R.id.editTextLlzIndra70SixPs1High5),
                editText428 = (EditText) findViewById(R.id.editTextLlzIndra70SixPs2Low5),
                editText429 = (EditText) findViewById(R.id.editTextLlzIndra70SixPs2High5),
                editText430 = (EditText) findViewById(R.id.editTextLlzIndra70SixPs1Low85),
                editText431 = (EditText) findViewById(R.id.editTextLlzIndra70SixPs1High85),
                editText432 = (EditText) findViewById(R.id.editTextLlzIndra70SixPs2Low85),
                editText433 = (EditText) findViewById(R.id.editTextLlzIndra70SixPs2High85),
                editText434 = (EditText) findViewById(R.id.editTextLlzIndra70SixPs1Low15V),
                editText435 = (EditText) findViewById(R.id.editTextLlzIndra70SixPs1High15V),
                editText436 = (EditText) findViewById(R.id.editTextLlzIndra70SixPs2Low15V),
                editText437 = (EditText) findViewById(R.id.editTextLlzIndra70SixPs2High15V),

                editText438 = (EditText) findViewById(R.id.editTextLlzIndra70SixB2DMLMon15),
                editText439 = (EditText) findViewById(R.id.editTextLlzIndra70SixB2DMLMon25),
                editText440 = (EditText) findViewById(R.id.editTextLlzIndra70SixB2DMLMon1STS),
                editText441 = (EditText) findViewById(R.id.editTextLlzIndra70SixB2DMLMon2STS),
                editText442 = (EditText) findViewById(R.id.editTextLlzIndra70SixB2DMLMon1DSPPFO),
                editText443 = (EditText) findViewById(R.id.editTextLlzIndra70SixB2DMLMon2DSPPFO),
                editText444 = (EditText) findViewById(R.id.editTextLlzIndra70SixB2DMLMon1DSPERR),
                editText445 = (EditText) findViewById(R.id.editTextLlzIndra70SixB2DMLMon2DSPERR),
                editText446 = (EditText) findViewById(R.id.editTextLlzIndra70SixB2DMLMon1RST),
                editText447 = (EditText) findViewById(R.id.editTextLlzIndra70SixB2DMLMon2RST),
                editText448 = (EditText) findViewById(R.id.editTextLlzIndra70SixB2DMLMon1SyncERR),
                editText449 = (EditText) findViewById(R.id.editTextLlzIndra70SixB2DMLMon2SyncERR),
                editText450 = (EditText) findViewById(R.id.editTextLlzIndra70SixB2DMLMon115),
                editText451 = (EditText) findViewById(R.id.editTextLlzIndra70SixB2DMLMon215),
                editText452 = (EditText) findViewById(R.id.editTextLlzIndra70SixB2DMLMon115V),
                editText453 = (EditText) findViewById(R.id.editTextLlzIndra70SixB2DMLMon215V),

                editText454 = (EditText) findViewById(R.id.editTextLlzIndra70SixB3DMLMon18),
                editText455 = (EditText) findViewById(R.id.editTextLlzIndra70SixB3DMLMon28),
                editText456 = (EditText) findViewById(R.id.editTextLlzIndra70SixB3DMLMon115),
                editText457 = (EditText) findViewById(R.id.editTextLlzIndra70SixB3DMLMon215),
                editText458 = (EditText) findViewById(R.id.editTextLlzIndra70SixB3DMLMon1Vint),
                editText459 = (EditText) findViewById(R.id.editTextLlzIndra70SixB3DMLMon2Vint),
                editText460 = (EditText) findViewById(R.id.editTextLlzIndra70SixB3DMLMon1FPGARst),
                editText461 = (EditText) findViewById(R.id.editTextLlzIndra70SixB3DMLMon2FPGARst),
                editText462 = (EditText) findViewById(R.id.editTextLlzIndra70SixB3DMLMon1FPGAErr),
                editText463 = (EditText) findViewById(R.id.editTextLlzIndra70SixB3DMLMon2FPGAErr),
                editText464 = (EditText) findViewById(R.id.editTextLlzIndra70SixB3DMLMon1SEU),
                editText465 = (EditText) findViewById(R.id.editTextLlzIndra70SixB3DMLMon2SEU),
                editText466 = (EditText) findViewById(R.id.editTextLlzIndra70SixB3DMLMon1ADC),
                editText467 = (EditText) findViewById(R.id.editTextLlzIndra70SixB3DMLMon2ADC),
                editText468 = (EditText) findViewById(R.id.editTextLlzIndra70SixB3DMLMon1PLL),
                editText469 = (EditText) findViewById(R.id.editTextLlzIndra70SixB3DMLMon2PLL),
                editText470 = (EditText) findViewById(R.id.editTextLlzIndra70SixB3DMLMon1FLASH),
                editText471 = (EditText) findViewById(R.id.editTextLlzIndra70SixB3DMLMon2FLASH),

                editText472 = (EditText) findViewById(R.id.editTextLlzIndra70SixB4DMLMon1FPGA),
                editText473 = (EditText) findViewById(R.id.editTextLlzIndra70SixB4DMLMon2FPGA),
                editText474 = (EditText) findViewById(R.id.editTextLlzIndra70SixB4DMLMon1CLPD),
                editText475 = (EditText) findViewById(R.id.editTextLlzIndra70SixB4DMLMon2CLPD),
                editText476 = (EditText) findViewById(R.id.editTextLlzIndra70SixB4DMLMon15),
                editText477 = (EditText) findViewById(R.id.editTextLlzIndra70SixB4DMLMon25),
                editText478 = (EditText) findViewById(R.id.editTextLlzIndra70SixB4DMLMon115),
                editText479 = (EditText) findViewById(R.id.editTextLlzIndra70SixB4DMLMon215),
                editText480 = (EditText) findViewById(R.id.editTextLlzIndra70SixB4DMLMon1Vint),
                editText481 = (EditText) findViewById(R.id.editTextLlzIndra70SixB4DMLMon2Vint),

                editText482 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1CRSCSBFwd),
                editText483 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2CRSCSBFwd),
                editText484 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1CRSSBOFwd),
                editText485 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2CRSSBOFwd),
                editText486 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1CRSCSBLoop),
                editText487 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2CRSCSBLoop),
                editText488 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1CRSSBOLoop),
                editText489 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2CRSSBOLoop),
                editText490 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1CLRCSBFwd),
                editText491 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2CLRCSBFwd),
                editText492 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1CLRSBOFwd),
                editText493 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2CLRSBOFwd),
                editText494 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1CLRCSBLoop),
                editText495 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2CLRCSBLoop),
                editText496 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx1CLRSBOLoop),
                editText497 = (EditText) findViewById(R.id.editTextLlzIndra70SixTx2CLRSBOLoop),
                editText498 = (EditText) findViewById(R.id.editTextLlzIndra70SixSetTx1Morse),
                editText499 = (EditText) findViewById(R.id.editTextLlzIndra70SixSetTx2Morse),

                editText500 = (EditText) findViewById(R.id.editTextLlzIndra70SixSwitchTx1Morse),
                editText501 = (EditText) findViewById(R.id.editTextLlzIndra70SixSwitchTx2Morse),
                editText502 = (EditText) findViewById(R.id.editTextLlzIndra70SixRemarks)};

        //Define and Initialize all Switches serially here
        Switch  switch1,switch2,switch3,switch4;
        switchArray = new Switch[]{
                switch1 = (Switch) findViewById(R.id.switchLlzIndra70SixSwitchTx190),
                switch2 = (Switch) findViewById(R.id.switchLlzIndra70SixSwitchTx290),
                switch3 = (Switch) findViewById(R.id.switchLlzIndra70SixSwitchTx1150),
                switch4 = (Switch) findViewById(R.id.switchLlzIndra70SixSwitchTx2150)};

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

        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.llzindra70six1);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);

        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(11);

        int[] editTextXPixel = {121,593,95,193,312,470,204,244,286,334,404,456,515,568,640,204,244,286,334,404,456,515,568,640,204,244,286,334,404,456,515,568,640,
                204,244,286,334,404,456,515,568,640,204,244,286,334,404,456,515,568,640,204,244,286,334,404,456,515,568,640,204,244,286,334,404,456,515,568,640,
                204,244,286,334,404,456,515,568,640,204,244,286,334,404,456,515,568,640,204,244,286,334,404,456,515,568,640,204,244,286,334,404,456,515,568,640,
                204,244,286,334,404,456,515,568,640,204,244,286,334,404,456,515,568,640,204,244,286,334,404,456,515,568,640,204,244,286,334,404,456,515,568,640,
                204,244,286,334,404,456,515,568,640, 204,244,286,334,404,456,515,568,640,204,244,286,334,404,456,515,568,640,204,244,286,334,404,456,515,568,640,
                204,244,286,334,404,456,515,568,640, 204,244,286,334,404,456,515,568,640,204,244,286,334,404,456,515,568,640,204,244,286,334,404,456,515,568,640,
                204,244,286,334,404,456,515,568,640};
        int[] editTextYPixel = {156,156,190,190,190,190,298,298,298,298,298,298,298,298,298,322,322,322,322,322,322,322,322,322,346,346,346,346,346,346,346,346,346,
                368,368,368,368,368,368,368,368,368,393,393,393,393,393,393,393,393,393,415,415,415,415,415,415,415,415,415,438,438,438,438,438,438,438,438,438,
                463,463,463,463,463,463,463,463,463,487,487,487,487,487,487,487,487,487,510,510,510,510,510,510,510,510,510,534,534,534,534,534,534,534,534,534,
                558,558,558,558,558,558,558,558,558,581,581,581,581,581,581,581,581,581,605,605,605,605,605,605,605,605,605,630,630,630,630,630,630,630,630,630,
                651,651,651,651,651,651,651,651,651,678,678,678,678,678,678,678,678,678,701,701,701,701,701,701,701,701,701,724,724,724,724,724,724,724,724,724,
                748,748,748,748,748,748,748,748,748,770,770,770,770,770,770,770,770,770,793,793,793,793,793,793,793,793,793,819,819,819,819,819,819,819,819,819,
                845,845,845,845,845,845,845,845,845};



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

        canvas.drawText(strData,569,191,titlePaint);//Printing Date on PDF

        myPdfdocument.finishPage(myPage1);


        //---------------------End of Page 1---------------

        //----------------------Page 2---------------------

        PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(723, 1024, 2).create();

        // start a page
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);

        canvas = myPage2.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.llzindra70six2);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(11);

        int[] editTextXPixel2 = {193,251,292,340,409,464,521,573,621,193,251,292,340,409,464,521,573,621,193,251,292,340,409,464,521,573,621,193,251,292,340,409,464,521,573,621,
                193,251,292,340,409,464,521,573,621,193,251,292,340,409,464,521,573,621,193,251,292,340,409,464,521,573,621,275,400,500,580,275,400,500,580,
                275,400,500,580,275,400,500,580,275,400,500,580,275,400,500,580,275,400,500,580,275,400,500,580,275,400,500,580,275,400,500,580,275,400,500,580,
                275,400,500,580,275,400,500,580,275,400,500,580};
        int[] editTextYPixel2 = {195,195,195,195,195,195,195,195,195,219,219,219,219,219,219,219,219,219,243,243,243,243,243,243,243,243,243,265,265,265,265,265,265,265,265,265,
                290,290,290,290,290,290,290,290,290,313,313,313,313,313,313,313,313,313,336,336,336,336,336,336,336,336,336,470,470,470,470,498,498,498,498,
                525,525,525,525,552,552,552,552,582,582,582,582,609,609,609,609,636,636,636,636,663,663,663,663,692,692,692,692,719,719,719,719,747,747,747,747,
                774,774,774,774,800,800,800,800,828,828,828,828};

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
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.llzindra70six3);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);


        titlePaint.setTextSize(11);

        int[] editTextXPixel3 = {270,390,500,580,270,390,500,580,270,390,500,580,270,390,500,580,270,390,500,580,270,390,500,580,270,390,500,580,270,390,500,580,
                270,390,500,580,270,390,500,580,270,390,500,580,270,390,500,580,270,390,500,580,270,390,500,580,270,390,500,580,270,390,500,580,270,390,500,580,
                270,390,500,580,270,390,500,580,270,390,500,580,270,390,500,580,270,390,500,580,270,390,500,580,270,390,500,580};
        int[] editTextYPixel3 = {154,154,154,154,209,209,209,209,238,238,238,238,265,265,265,265,293,293,293,293,321,321,321,321,346,346,346,346,376,376,376,376,
                404,404,404,404,431,431,431,431,458,458,458,458,486,486,486,486,514,514,514,514,541,541,541,541,569,569,569,569,596,596,596,596,624,624,624,624,
                651,651,651,651,680,680,680,680,707,707,707,707,792,792,792,792,819,819,819,819,848,848,848,848,875,875,875,875};

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
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.llzindra70six4);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(11);

        int[] editTextXPixel4 = {492,565,492,565,492,565,492,565,492,565,492,565,492,565,492,565,492,565,492,565,492,565,492,565,492,565,492,565,492,565,
                492,565,492,565,492,565,492,565,492,565};
        int[] editTextYPixel4 = {234,234,266,266,296,296,325,325,359,359,390,390,422,422,454,454,540,540,570,570,602,602,634,634,668,668,698,698,729,729,
                762,762,795,795,859,859,891,891,922,922};

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
        bmp = BitmapFactory.decodeResource(getResources(),R.drawable.llzindra70six5);
        scaledbmp = Bitmap.createScaledBitmap(bmp,723,1024,false);
        canvas.drawBitmap(scaledbmp,0 , 0, paint);

        titlePaint.setTextSize(12);

        int[] editTextXPixel5 = {492,565,492,565,360,520,360,520,360,520,360,520,360,520,360,520,360,520,360,520,360,520,500,595,70};
        int[] editTextYPixel5 = {124,124,157,157,235,235,258,258,282,282,305,305,328,328,350,350,373,373,396,396,419,419,542,542,585};

        int[] switchXPixel5 = {500,595,500,595};
        int[] switchYPixel5 = {505,505,524,524};


        for(int i = 0; i < editTextXPixel5.length; i++){
            canvas.drawText( editTextDataForPDF[i+editTextXPixel.length+editTextXPixel2.length+editTextXPixel3.length+editTextXPixel4.length],editTextXPixel5[i],editTextYPixel5[i],titlePaint);
        }

        for(int i = 0; i < switchXPixel5.length; i++){
            canvas.drawText( switchDataForPDF[i],switchXPixel5[i],switchYPixel5[i],titlePaint);
        }



        titlePaint.setTextSize(12);
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,290,270, false), 70, 650, paint);


        myPdfdocument.finishPage(myPage5);

        //-------------------------End of Page 5-----------------



        ActivityCompat.requestPermissions(this, new String[]{

                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Navigation/LLZIndra70/Six Monthly/";// Change Here------------------
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //String targetPdf = directory_path + "test.pdf";
        //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
        String fileName = "Six Monthly LLZ Indra70 " + strData + ".pdf"; // Change Here--------------------------
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
                "Six Monthly Maintenance of Indra70 LLZ done.",//Change Here-----------------------------
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