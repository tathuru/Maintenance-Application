package com.aaiaero.emaintenance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
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
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
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

public class VHFDVRRETIADailyRecordingActivity extends AppCompatActivity {

    private MyFunctions myFunctions = new MyFunctions(this);//--1--//Add this
    private MySignature mySignature = new MySignature(this);
    private int selectedID;//Copy
    private String selectedName;//Copy
    private EditText[] editTextArray;//Copy
    private Switch[] switchArray = {};//Copy
    private Spinner[] spinnerArray = {};//Copy

    public String Date;

    private String thisActivityName = "VHFDVRRETIADailyRecordingActivity"; //Change Here as per your class name

    public void click(View view1) {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
    Switch switch1 ;


    public void channel (View view){


        switch1 = (Switch) findViewById(R.id.switch1);

        LinearLayout layout = (LinearLayout)  findViewById(R.id.layout);


        if (switch1.isChecked()){

            layout.setVisibility(View.VISIBLE);

        }

        else {
            layout.setVisibility(View.GONE);
        }

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vhfdvrretiadaily_recording);

        EditText editText1,editText2,editText3,editText4,editText5,editText6,editText7,editText8,editText9,editText10,editText11,editText12,editText13,
                editText14,editText15,editText16,editText17,editText18,editText19,editText20,editText21,editText22,editText23,editText24,editText25,editText26,
                editText27,editText28,editText29,editText30,editText31,editText32,editText33,editText34,editText35,editText36,editText37,editText38,
                editText39,editText40,editText41,editText42,editText43,editText44,editText45,editText46,editText47,editText48,editText49,editText50,
                editText51,editText52,editText53,editText54,editText55,editText56,editText57,editText58,editText59,editText60,editText61,editText62,
                editText63,editText64,editText65,editText66,editText67,editText68,editText69,editText70,editText71,editText72,editText73,editText74,
                editText75,editText76,editText77,editText78,editText79,editText80,editText81,editText82,editText83,editText84,editText85,editText86,
                editText87,editText88,editText89,editText90,editText91,editText92,editText93,editText94,editText95,editText96,editText97,editText98,
                editText99,editText100,editText101,editText102,editText103,editText104,editText105,editText106,editText107,editText108,editText109,editText110,
                editText111,editText112,editText113,editText114,editText115,editText116,editText117,editText118,editText119,editText120,editText121,editText122,
                editText123,editText124,editText125,editText126,editText127,editText128,editText129,editText130,editText131,editText132,editText133,editText134,
                editText135,editText136,editText137,editText138,editText139,editText140,editText141,editText142,editText143,editText144,editText145,editText146,
                editText147,editText148,editText149,editText150,editText151,editText152,editText153,editText154,editText155,editText156,editText157,editText158,
                editText159,editText160,editText161,editText162,editText163,editText164,editText165,editText166,editText167,editText168,editText169,editText170,
                editText171,editText172,editText173,editText174,editText175,editText176,editText177,editText178,editText179,editText180,editText181,editText182,
                editText183,editText184,editText185,editText186,editText187,editText188,editText189,editText190,editText191,editText192,editText193,editText194,
                editText195,editText196,editText197,editText198,editText199,editText200,editText201,editText202,editText203,editText204,editText205,editText206,
                editText207,editText208,editText209,editText210,editText211,editText212,editText213,editText214,editText215,editText216,editText217,editText218,
                editText219,editText220,editText221,editText222,editText223,editText224,editText225,editText226,editText227,editText228,editText229,editText230,
                editText231,editText232,editText233,editText234,editText235,editText236,editText237,editText238,editText239,editText240,editText241,editText242,
                editText243,editText244,editText245,editText246,editText247,editText248, editText249,editText250,editText251,editText252,editText253,editText254,
                editText255,editText256,editText257,editText258,editText259,editText260,editText261,editText262,editText263,editText264,editText265,editText266,
                editText267,editText268,editText269,editText270,editText271,editText272,editText273,editText274,editText275,editText276,editText277,editText278,editText279,
                editText280,editText281,editText282,editText283,editText284,editText285,editText286,editText287,editText288,editText289,editText290,editText291,editText292,
                editText293,editText294,editText295,editText296,editText297,editText298,editText299,editText300,editText301,editText302,editText303,editText304,editText305,
                editText306,editText307,editText308,editText309,editText310,editText311,editText312,editText313,editText314,editText315,editText316,editText317,editText318,
                editText319,editText320,editText321,editText322,editText323,editText324,editText325,editText326,editText327,editText328,editText329,editText330,editText331,
                editText332,editText333,editText334,editText335,editText336,editText337,editText338,editText339,editText340,editText341,editText342,editText343,editText344,
                editText345,editText346,editText347,editText348,editText349,editText350,editText351,editText352,editText353,editText354,editText355,editText356,editText357,
                editText358,editText359,editText360,editText361,editText362,editText363,editText364,editText365,editText366,editText367,editText368,editText369,editText370,
                editText371,editText372,editText373,editText374,editText375,editText376,editText377,editText378,editText379,editText380,editText381,editText382,editText383,
                editText384,editText385,editText386,editText387,editText388;
        editTextArray =  new EditText[] {
                editText1 = (EditText) findViewById(R.id.editText1),
                editText2 = (EditText) findViewById(R.id.editText2),
                editText3 = (EditText) findViewById(R.id.editText3),
                editText4 = (EditText) findViewById(R.id.editText4),
                editText5 = (EditText) findViewById(R.id.editText5),
                editText6 = (EditText) findViewById(R.id.editText6),
                editText7 = (EditText) findViewById(R.id.editText7),
                editText8 = (EditText) findViewById(R.id.editText8),
                editText9 = (EditText) findViewById(R.id.editText9),
                editText10 = (EditText) findViewById(R.id.editText10),
                editText11 = (EditText) findViewById(R.id.editText11),
                editText12 = (EditText) findViewById(R.id.editText12),
                editText13 = (EditText) findViewById(R.id.editText13),
                editText14 = (EditText) findViewById(R.id.editText14),
                editText15 = (EditText) findViewById(R.id.editText15),
                editText16 = (EditText) findViewById(R.id.editText16),
                editText17 = (EditText) findViewById(R.id.editText17),
                editText18 = (EditText) findViewById(R.id.editText18),
                editText19 = (EditText) findViewById(R.id.editText19),
                editText20 = (EditText) findViewById(R.id.editText20),
                editText21 = (EditText) findViewById(R.id.editText21),
                editText22 = (EditText) findViewById(R.id.editText22),
                editText23 = (EditText) findViewById(R.id.editText23),
                editText24 = (EditText) findViewById(R.id.editText24),
                editText25 = (EditText) findViewById(R.id.editText25),
                editText26 = (EditText) findViewById(R.id.editText26),
                editText27 = (EditText) findViewById(R.id.editText27),
                editText28 = (EditText) findViewById(R.id.editText28),
                editText29 = (EditText) findViewById(R.id.editText29),
                editText30 = (EditText) findViewById(R.id.editText30),
                editText31 = (EditText) findViewById(R.id.editText31),
                editText32 = (EditText) findViewById(R.id.editText32),
                editText33 = (EditText) findViewById(R.id.editText33),
                editText34 = (EditText) findViewById(R.id.editText34),
                editText35 = (EditText) findViewById(R.id.editText35),
                editText36 = (EditText) findViewById(R.id.editText36),
                editText37 = (EditText) findViewById(R.id.editText37),
                editText38 = (EditText) findViewById(R.id.editText38),
                editText39 = (EditText) findViewById(R.id.editText39),
                editText40 = (EditText) findViewById(R.id.editText40),
                editText41 = (EditText) findViewById(R.id.editText41),
                editText42 = (EditText) findViewById(R.id.editText42),
                editText43 = (EditText) findViewById(R.id.editText43),
                editText44 = (EditText) findViewById(R.id.editText44),
                editText45 = (EditText) findViewById(R.id.editText45),
                editText46 = (EditText) findViewById(R.id.editText46),
                editText47 = (EditText) findViewById(R.id.editText47),
                editText48 = (EditText) findViewById(R.id.editText48),
                editText49 = (EditText) findViewById(R.id.editText49),
                editText50 = (EditText) findViewById(R.id.editText50),
                editText51 = (EditText) findViewById(R.id.editText51),
                editText52 = (EditText) findViewById(R.id.editText52),
                editText53 = (EditText) findViewById(R.id.editText53),
                editText54 = (EditText) findViewById(R.id.editText54),
                editText55 = (EditText) findViewById(R.id.editText55),
                editText56 = (EditText) findViewById(R.id.editText56),
                editText57 = (EditText) findViewById(R.id.editText57),
                editText58 = (EditText) findViewById(R.id.editText58),
                editText59 = (EditText) findViewById(R.id.editText59),
                editText60 = (EditText) findViewById(R.id.editText60),
                editText61 = (EditText) findViewById(R.id.editText61),
                editText62 = (EditText) findViewById(R.id.editText62),
                editText63 = (EditText) findViewById(R.id.editText63),
                editText64 = (EditText) findViewById(R.id.editText64),
                editText65 = (EditText) findViewById(R.id.editText65),
                editText66 = (EditText) findViewById(R.id.editText66),
                editText67 = (EditText) findViewById(R.id.editText67),
                editText68 = (EditText) findViewById(R.id.editText68),
                editText69 = (EditText) findViewById(R.id.editText69),
                editText70 = (EditText) findViewById(R.id.editText70),
                editText71 = (EditText) findViewById(R.id.editText71),
                editText72 = (EditText) findViewById(R.id.editText72),
                editText73 = (EditText) findViewById(R.id.editText73),
                editText74 = (EditText) findViewById(R.id.editText74),
                editText75 = (EditText) findViewById(R.id.editText75),
                editText76 = (EditText) findViewById(R.id.editText76),
                editText77 = (EditText) findViewById(R.id.editText77),
                editText78 = (EditText) findViewById(R.id.editText78),
                editText79 = (EditText) findViewById(R.id.editText79),
                editText80 = (EditText) findViewById(R.id.editText80),
                editText81 = (EditText) findViewById(R.id.editText81),
                editText82 = (EditText) findViewById(R.id.editText82),
                editText83 = (EditText) findViewById(R.id.editText83),
                editText84 = (EditText) findViewById(R.id.editText84),
                editText85 = (EditText) findViewById(R.id.editText85),
                editText86 = (EditText) findViewById(R.id.editText86),
                editText87 = (EditText) findViewById(R.id.editText87),
                editText88 = (EditText) findViewById(R.id.editText88),
                editText89 = (EditText) findViewById(R.id.editText89),
                editText90 = (EditText) findViewById(R.id.editText90),
                editText91 = (EditText) findViewById(R.id.editText91),
                editText92 = (EditText) findViewById(R.id.editText92),
                editText93 = (EditText) findViewById(R.id.editText93),
                editText94 = (EditText) findViewById(R.id.editText94),
                editText95 = (EditText) findViewById(R.id.editText95),
                editText96 = (EditText) findViewById(R.id.editText96),
                editText97 = (EditText) findViewById(R.id.editText97),
                editText98 = (EditText) findViewById(R.id.editText98),
                editText99 = (EditText) findViewById(R.id.editText99),
                editText100 = (EditText) findViewById(R.id.editText100),
                editText101 = (EditText) findViewById(R.id.editText101),
                editText102 = (EditText) findViewById(R.id.editText102),
                editText103 = (EditText) findViewById(R.id.editText103),
                editText104 = (EditText) findViewById(R.id.editText104),
                editText105 = (EditText) findViewById(R.id.editText105),
                editText106 = (EditText) findViewById(R.id.editText106),
                editText107 = (EditText) findViewById(R.id.editText107),
                editText108 = (EditText) findViewById(R.id.editText108),
                editText109 = (EditText) findViewById(R.id.editText109),
                editText110 = (EditText) findViewById(R.id.editText110),
                editText111 = (EditText) findViewById(R.id.editText111),
                editText112 = (EditText) findViewById(R.id.editText112),
                editText113 = (EditText) findViewById(R.id.editText113),
                editText114 = (EditText) findViewById(R.id.editText114),
                editText115 = (EditText) findViewById(R.id.editText115),
                editText116 = (EditText) findViewById(R.id.editText116),
                editText117 = (EditText) findViewById(R.id.editText117),
                editText118 = (EditText) findViewById(R.id.editText118),
                editText119 = (EditText) findViewById(R.id.editText119),
                editText120 = (EditText) findViewById(R.id.editText120),
                editText121 = (EditText) findViewById(R.id.editText121),
                editText122 = (EditText) findViewById(R.id.editText122),
                editText123 = (EditText) findViewById(R.id.editText123),
                editText124 = (EditText) findViewById(R.id.editText124),
                editText125 = (EditText) findViewById(R.id.editText125),
                editText126 = (EditText) findViewById(R.id.editText126),
                editText127 = (EditText) findViewById(R.id.editText127),
                editText128 = (EditText) findViewById(R.id.editText128),
                editText129 = (EditText) findViewById(R.id.editText129),
                editText130 = (EditText) findViewById(R.id.editText130),
                editText131 = (EditText) findViewById(R.id.editText131),
                editText132 = (EditText) findViewById(R.id.editText132),
                editText133 = (EditText) findViewById(R.id.editText133),
                editText134 = (EditText) findViewById(R.id.editText134),
                editText135 = (EditText) findViewById(R.id.editText135),
                editText136 = (EditText) findViewById(R.id.editText136),
                editText137 = (EditText) findViewById(R.id.editText137),
                editText138 = (EditText) findViewById(R.id.editText138),
                editText139 = (EditText) findViewById(R.id.editText139),
                editText140 = (EditText) findViewById(R.id.editText140),
                editText141 = (EditText) findViewById(R.id.editText141),
                editText142 = (EditText) findViewById(R.id.editText142),
                editText143 = (EditText) findViewById(R.id.editText143),
                editText144 = (EditText) findViewById(R.id.editText144),
                editText145 = (EditText) findViewById(R.id.editText145),
                editText146 = (EditText) findViewById(R.id.editText146),
                editText147 = (EditText) findViewById(R.id.editText147),
                editText148 = (EditText) findViewById(R.id.editText148),
                editText149 = (EditText) findViewById(R.id.editText149),
                editText150 = (EditText) findViewById(R.id.editText150),
                editText151 = (EditText) findViewById(R.id.editText151),
                editText152 = (EditText) findViewById(R.id.editText152),
                editText153 = (EditText) findViewById(R.id.editText153),
                editText154 = (EditText) findViewById(R.id.editText154),
                editText155 = (EditText) findViewById(R.id.editText155),
                editText156 = (EditText) findViewById(R.id.editText156),
                editText157 = (EditText) findViewById(R.id.editText157),
                editText158 = (EditText) findViewById(R.id.editText158),
                editText159 = (EditText) findViewById(R.id.editText159),
                editText160 = (EditText) findViewById(R.id.editText160),
                editText161 = (EditText) findViewById(R.id.editText161),
                editText162 = (EditText) findViewById(R.id.editText162),
                editText163 = (EditText) findViewById(R.id.editText163),
                editText164 = (EditText) findViewById(R.id.editText164),
                editText165 = (EditText) findViewById(R.id.editText165),
                editText166 = (EditText) findViewById(R.id.editText166),
                editText167 = (EditText) findViewById(R.id.editText167),
                editText168 = (EditText) findViewById(R.id.editText168),
                editText169 = (EditText) findViewById(R.id.editText169),
                editText170 = (EditText) findViewById(R.id.editText170),
                editText171 = (EditText) findViewById(R.id.editText171),
                editText172 = (EditText) findViewById(R.id.editText172),
                editText173 = (EditText) findViewById(R.id.editText173),
                editText174 = (EditText) findViewById(R.id.editText174),
                editText175 = (EditText) findViewById(R.id.editText175),
                editText176 = (EditText) findViewById(R.id.editText176),
                editText177 = (EditText) findViewById(R.id.editText177),
                editText178 = (EditText) findViewById(R.id.editText178),
                editText179 = (EditText) findViewById(R.id.editText179),
                editText180 = (EditText) findViewById(R.id.editText180),
                editText181 = (EditText) findViewById(R.id.editText181),
                editText182 = (EditText) findViewById(R.id.editText182),
                editText183 = (EditText) findViewById(R.id.editText183),
                editText184 = (EditText) findViewById(R.id.editText184),
                editText185 = (EditText) findViewById(R.id.editText185),
                editText186 = (EditText) findViewById(R.id.editText186),
                editText187 = (EditText) findViewById(R.id.editText187),
                editText188 = (EditText) findViewById(R.id.editText188),
                editText189 = (EditText) findViewById(R.id.editText189),
                editText190 = (EditText) findViewById(R.id.editText190),
                editText191 = (EditText) findViewById(R.id.editText191),
                editText192 = (EditText) findViewById(R.id.editText192),
                editText193 = (EditText) findViewById(R.id.editText193),
                editText194 = (EditText) findViewById(R.id.editText194),
                editText195 = (EditText) findViewById(R.id.editText195),
                editText196 = (EditText) findViewById(R.id.editText196),
                editText197 = (EditText) findViewById(R.id.editText197),
                editText198 = (EditText) findViewById(R.id.editText198),
                editText199 = (EditText) findViewById(R.id.editText199),
                editText200 = (EditText) findViewById(R.id.editText200),
                editText201 = (EditText) findViewById(R.id.editText201),
                editText202 = (EditText) findViewById(R.id.editText202),
                editText203 = (EditText) findViewById(R.id.editText203),
                editText204 = (EditText) findViewById(R.id.editText204),
                editText205 = (EditText) findViewById(R.id.editText205),
                editText206 = (EditText) findViewById(R.id.editText206),
                editText207 = (EditText) findViewById(R.id.editText207),
                editText208 = (EditText) findViewById(R.id.editText208),
                editText209 = (EditText) findViewById(R.id.editText209),
                editText210 = (EditText) findViewById(R.id.editText210),
                editText211 = (EditText) findViewById(R.id.editText211),
                editText212 = (EditText) findViewById(R.id.editText212),
                editText213 = (EditText) findViewById(R.id.editText213),
                editText214 = (EditText) findViewById(R.id.editText214),
                editText215 = (EditText) findViewById(R.id.editText215),
                editText216 = (EditText) findViewById(R.id.editText216),
                editText217 = (EditText) findViewById(R.id.editText217),
                editText218 = (EditText) findViewById(R.id.editText218),
                editText219 = (EditText) findViewById(R.id.editText219),
                editText220 = (EditText) findViewById(R.id.editText220),
                editText221 = (EditText) findViewById(R.id.editText221),
                editText222 = (EditText) findViewById(R.id.editText222),
                editText223 = (EditText) findViewById(R.id.editText223),
                editText224 = (EditText) findViewById(R.id.editText224),
                editText225 = (EditText) findViewById(R.id.editText225),
                editText226 = (EditText) findViewById(R.id.editText226),
                editText227 = (EditText) findViewById(R.id.editText227),
                editText228 = (EditText) findViewById(R.id.editText228),
                editText229 = (EditText) findViewById(R.id.editText229),
                editText230 = (EditText) findViewById(R.id.editText230),
                editText231 = (EditText) findViewById(R.id.editText231),
                editText232 = (EditText) findViewById(R.id.editText232),
                editText233 = (EditText) findViewById(R.id.editText233),
                editText234 = (EditText) findViewById(R.id.editText234),
                editText235 = (EditText) findViewById(R.id.editText235),
                editText236 = (EditText) findViewById(R.id.editText236),
                editText237 = (EditText) findViewById(R.id.editText237),
                editText238 = (EditText) findViewById(R.id.editText238),
                editText239 = (EditText) findViewById(R.id.editText239),
                editText240 = (EditText) findViewById(R.id.editText240),
                editText241 = (EditText) findViewById(R.id.editText241),
                editText242 = (EditText) findViewById(R.id.editText242),
                editText243 = (EditText) findViewById(R.id.editText243),
                editText244 = (EditText) findViewById(R.id.editText244),
                editText245 = (EditText) findViewById(R.id.editText245),
                editText246 = (EditText) findViewById(R.id.editText246),
                editText247 = (EditText) findViewById(R.id.editText247),
                editText248 = (EditText) findViewById(R.id.editText248),
                editText249 = (EditText) findViewById(R.id.editText249),
                editText250 = (EditText) findViewById(R.id.editText250),
                editText251 = (EditText) findViewById(R.id.editText251),
                editText252 = (EditText) findViewById(R.id.editText252),
                editText253 = (EditText) findViewById(R.id.editText253),
                editText254 = (EditText) findViewById(R.id.editText254),
                editText255 = (EditText) findViewById(R.id.editText255),
                editText256 = (EditText) findViewById(R.id.editText256),
                editText257 = (EditText) findViewById(R.id.editText257),
                editText258 = (EditText) findViewById(R.id.editText258),
                editText259 = (EditText) findViewById(R.id.editText259),
                editText260 = (EditText) findViewById(R.id.editText260),
                editText261 = (EditText) findViewById(R.id.editText261),
                editText262 = (EditText) findViewById(R.id.editText262),
                editText263 = (EditText) findViewById(R.id.editText263),
                editText264 = (EditText) findViewById(R.id.editText264),
                editText265 = (EditText) findViewById(R.id.editText265),
                editText266 = (EditText) findViewById(R.id.editText266),
                editText267 = (EditText) findViewById(R.id.editText267),
                editText268 = (EditText) findViewById(R.id.editText268),
                editText269 = (EditText) findViewById(R.id.editText269),
                editText270 = (EditText) findViewById(R.id.editText270),
                editText271 = (EditText) findViewById(R.id.editText271),
                editText272 = (EditText) findViewById(R.id.editText272),
                editText273 = (EditText) findViewById(R.id.editText273),
                editText274 = (EditText) findViewById(R.id.editText274),
                editText275 = (EditText) findViewById(R.id.editText275),
                editText276 = (EditText) findViewById(R.id.editText276),
                editText277 = (EditText) findViewById(R.id.editText277),
                editText278 = (EditText) findViewById(R.id.editText278),
                editText279 = (EditText) findViewById(R.id.editText279),
                editText280 = (EditText) findViewById(R.id.editText280),
                editText281 = (EditText) findViewById(R.id.editText281),
                editText282 = (EditText) findViewById(R.id.editText282),
                editText283 = (EditText) findViewById(R.id.editText283),
                editText284 = (EditText) findViewById(R.id.editText284),
                editText285 = (EditText) findViewById(R.id.editText285),
                editText286 = (EditText) findViewById(R.id.editText286),
                editText287 = (EditText) findViewById(R.id.editText287),
                editText288 = (EditText) findViewById(R.id.editText288),
                editText289 = (EditText) findViewById(R.id.editText289),
                editText290 = (EditText) findViewById(R.id.editText290),
                editText291 = (EditText) findViewById(R.id.editText291),
                editText292 = (EditText) findViewById(R.id.editText292),
                editText293 = (EditText) findViewById(R.id.editText293),
                editText294 = (EditText) findViewById(R.id.editText294),
                editText295 = (EditText) findViewById(R.id.editText295),
                editText296 = (EditText) findViewById(R.id.editText296),
                editText297 = (EditText) findViewById(R.id.editText297),
                editText298 = (EditText) findViewById(R.id.editText298),
                editText299 = (EditText) findViewById(R.id.editText299),
                editText300 = (EditText) findViewById(R.id.editText300),
                editText301 = (EditText) findViewById(R.id.editText301),
                editText302 = (EditText) findViewById(R.id.editText302),
                editText303 = (EditText) findViewById(R.id.editText303),
                editText304 = (EditText) findViewById(R.id.editText304),
                editText305 = (EditText) findViewById(R.id.editText305),
                editText306 = (EditText) findViewById(R.id.editText306),
                editText307 = (EditText) findViewById(R.id.editText307),
                editText308 = (EditText) findViewById(R.id.editText308),
                editText309 = (EditText) findViewById(R.id.editText309),
                editText310 = (EditText) findViewById(R.id.editText310),
                editText311 = (EditText) findViewById(R.id.editText311),
                editText312 = (EditText) findViewById(R.id.editText312),
                editText313 = (EditText) findViewById(R.id.editText313),
                editText314 = (EditText) findViewById(R.id.editText314),
                editText315 = (EditText) findViewById(R.id.editText315),
                editText316 = (EditText) findViewById(R.id.editText316),
                editText317 = (EditText) findViewById(R.id.editText317),
                editText318 = (EditText) findViewById(R.id.editText318),
                editText319 = (EditText) findViewById(R.id.editText319),
                editText320 = (EditText) findViewById(R.id.editText320),
                editText321 = (EditText) findViewById(R.id.editText321),
                editText322 = (EditText) findViewById(R.id.editText322),
                editText323 = (EditText) findViewById(R.id.editText323),
                editText324 = (EditText) findViewById(R.id.editText324),
                editText325 = (EditText) findViewById(R.id.editText325),
                editText326 = (EditText) findViewById(R.id.editText326),
                editText327 = (EditText) findViewById(R.id.editText327),
                editText328 = (EditText) findViewById(R.id.editText328),
                editText329 = (EditText) findViewById(R.id.editText329),
                editText330 = (EditText) findViewById(R.id.editText330),
                editText331 = (EditText) findViewById(R.id.editText331),
                editText332 = (EditText) findViewById(R.id.editText332),
                editText333 = (EditText) findViewById(R.id.editText333),
                editText334 = (EditText) findViewById(R.id.editText334),
                editText335 = (EditText) findViewById(R.id.editText335),
                editText336 = (EditText) findViewById(R.id.editText336),
                editText337 = (EditText) findViewById(R.id.editText337),
                editText338 = (EditText) findViewById(R.id.editText338),
                editText339 = (EditText) findViewById(R.id.editText339),
                editText340 = (EditText) findViewById(R.id.editText340),
                editText341 = (EditText) findViewById(R.id.editText341),
                editText342 = (EditText) findViewById(R.id.editText342),
                editText343 = (EditText) findViewById(R.id.editText343),
                editText344 = (EditText) findViewById(R.id.editText344),
                editText345 = (EditText) findViewById(R.id.editText345),
                editText346 = (EditText) findViewById(R.id.editText346),
                editText347 = (EditText) findViewById(R.id.editText347),
                editText348 = (EditText) findViewById(R.id.editText348),
                editText349 = (EditText) findViewById(R.id.editText349),
                editText350 = (EditText) findViewById(R.id.editText350),
                editText351 = (EditText) findViewById(R.id.editText351),
                editText352 = (EditText) findViewById(R.id.editText352),
                editText353 = (EditText) findViewById(R.id.editText353),
                editText354 = (EditText) findViewById(R.id.editText354),
                editText355 = (EditText) findViewById(R.id.editText355),
                editText356 = (EditText) findViewById(R.id.editText356),
                editText357 = (EditText) findViewById(R.id.editText357),
                editText358 = (EditText) findViewById(R.id.editText358),
                editText359 = (EditText) findViewById(R.id.editText359),
                editText360 = (EditText) findViewById(R.id.editText360),
                editText361 = (EditText) findViewById(R.id.editText361),
                editText362 = (EditText) findViewById(R.id.editText362),
                editText363 = (EditText) findViewById(R.id.editText363),
                editText364 = (EditText) findViewById(R.id.editText364),
                editText365 = (EditText) findViewById(R.id.editText365),
                editText366 = (EditText) findViewById(R.id.editText366),
                editText367 = (EditText) findViewById(R.id.editText367),
                editText368 = (EditText) findViewById(R.id.editText368),
                editText369 = (EditText) findViewById(R.id.editText369),
                editText370 = (EditText) findViewById(R.id.editText370),
                editText371 = (EditText) findViewById(R.id.editText371),
                editText372 = (EditText) findViewById(R.id.editText372),
                editText373 = (EditText) findViewById(R.id.editText373),
                editText374 = (EditText) findViewById(R.id.editText374),
                editText375 = (EditText) findViewById(R.id.editText375),
                editText376 = (EditText) findViewById(R.id.editText376),
                editText377 = (EditText) findViewById(R.id.editText377),
                editText378 = (EditText) findViewById(R.id.editText378),
                editText379 = (EditText) findViewById(R.id.editText379),
                editText380 = (EditText) findViewById(R.id.editText380),
                editText381 = (EditText) findViewById(R.id.editText381),
                editText382 = (EditText) findViewById(R.id.editText382),
                editText383 = (EditText) findViewById(R.id.editText383),
                editText384 = (EditText) findViewById(R.id.editText384),
                editText385 = (EditText) findViewById(R.id.editText385),
                editText386 = (EditText) findViewById(R.id.editText386),
                editText387 = (EditText) findViewById(R.id.editText387),
                editText388 = (EditText) findViewById(R.id.editText388)};


       Switch switch1;

        switchArray = new Switch[]{

                switch1 = (Switch) findViewById(R.id.switch1)};



        TextView textViewN = (TextView) findViewById(R.id.textViewN);
        textViewN.setText("Name: " + PersonalDetailsActivity.naam);
        TextView textViewD = (TextView) findViewById(R.id.textViewD);
        textViewD.setText("Designation: " + PersonalDetailsActivity.design);
        TextView textViewE = (TextView) findViewById(R.id.textViewE);
        textViewE.setText("Emp No.: " + PersonalDetailsActivity.EmpID);
        TextView textViewL = (TextView) findViewById(R.id.textViewL);
        textViewL.setText("Location: " + MainActivity.latLong1);

        TextView textView = (TextView) findViewById(R.id.textViewDate);

        SimpleDateFormat date1 = new SimpleDateFormat("dd.MM.yyyy, HH:mm");
        Date = date1.format(new Date());
        textView.setText(Date);


        Intent receivedIntent = getIntent();
        //now get the itemID we passed as an extra
        selectedID = receivedIntent.getIntExtra("id", -1); //NOTE: -1 is just the default value
        if (selectedID == -1) {

        } else {
            //now get the name we passed as an extra
            selectedName = receivedIntent.getStringExtra("name");
            String selectedEditTextData = receivedIntent.getStringExtra("editTextData");
            String selectedSwitchData = receivedIntent.getStringExtra("switchData");
            //String selectedSpinnerData = receivedIntent.getStringExtra("spinnerData");
            //Log.i("received Data1 = ", selectedSwitchData);
            //Log.i("received Data2 = ", selectedSpinnerData);
            String[] seperatedData = myFunctions.seperateEditText(selectedEditTextData);
            String[] seperatedSwitchData = myFunctions.seperateSwitchData(selectedSwitchData);
            // String[] seperatedSpinnerData = myFunctions.seperateSpinnerData(selectedSpinnerData);

            //Log.d("RxArr=",Arrays.toString(seperatedData));
            myFunctions.putData(seperatedData, editTextArray);
            myFunctions.putSwitchData(seperatedSwitchData, switchArray);
            // myFunctions.putSpinnerData(seperatedSpinnerData, spinnerArray);
            //Log.i("received Data = ", selectedEditTextData);

        }

        Button signDocument = (Button) findViewById(R.id.button11);
        Button submitSchedule = (Button) findViewById(R.id.button10);
        Button channel = (Button) findViewById(R.id.switch1);

        submitSchedule.setVisibility(View.INVISIBLE);
        signDocument.setVisibility(View.VISIBLE);

        signDocument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySignature.dialog_action(submitSchedule, signDocument);


            }
        });

      //  switch1 = (Switch) findViewById(R.id.switch1);

        LinearLayout layout = (LinearLayout)  findViewById(R.id.layout);


        if (switch1.isChecked()){

            layout.setVisibility(View.VISIBLE);

        }

        else {
            layout.setVisibility(View.GONE);
        }

      /* channel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Switch switch1 = (Switch) findViewById(R.id.switch1);

                LinearLayout layout = (LinearLayout)  findViewById(R.id.layout);


                if (switch1.isChecked()){

                    layout.setVisibility(View.VISIBLE);

                }

                else {
                    layout.setVisibility(View.GONE);
                }
            }

        });*/

        submitSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (switch1.isChecked()) {

                    generatePDF1();

                }

                else {
                    generatePDF2();
                }
            }

        });
    }
    private void generatePDF1() {

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



        PdfDocument.PageInfo myPageInfo1 = new PdfDocument.PageInfo.Builder(1275, 1650, 1).create();

        // start a page
        PdfDocument.Page myPage1 = myPdfdocument.startPage(myPageInfo1);
        Canvas canvas = myPage1.getCanvas();


        Bitmap bmp, scaledbmp;


//--------------------------------------------------------------------------------------------
        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.dvrretiadailyrecordingchecks1);
        scaledbmp = Bitmap.createScaledBitmap(bmp, 1275, 1650, false);
//--------------------------------------------------------------------------------------------
        canvas.drawBitmap(scaledbmp, 0, 0, paint);


        titlePaint.setTextSize(20);
        paint.setTextAlign(Paint.Align.LEFT);
        //canvas.drawText("Name: " + PersonalDetailsActivity.naam ,1500,32,titlePaint);
        //canvas.drawText("Desig: " + PersonalDetailsActivity.design ,1500,64,titlePaint);
        //canvas.drawText("Emp No.: " + PersonalDetailsActivity.EmpID ,1500,96,titlePaint);
        //canvas.drawText("Location: " + MainActivity.latLong1,1500,128,titlePaint);
        //canvas.drawBitmap(PersonalDetailsActivity.photo, 540, 4, paint);
        //--------------------------------Change as per your requirement------------------------------------------------------
        //canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,500,510, false), 1325, 2720, paint);
        //canvas.drawBitmap(PersonalDetailsActivity.sigNature, 1325, 2720, paint);
        titlePaint.setTextSize(20);

        int[] editTextXPixel1 = {241,931,1013,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000};
        int[] editTextYPixel1 = {285,285,312,602,633,664,695,726,757,788,819,850,881,912,943,974,1005,1036,1067,1098,1127,1160,1191,1222,1253,1284,1315,1346,1377,1408,1439,1470,1501,1529,1560,602,633,664,695,726,757,788,819,850,881,912,943,974,1005,1036,1067,1098,1127,1160,1191,1222,1253,1284,1315,1346,1377,1408,1439,1470,1501,1529,1560,602,633,664,695,726,757,788,819,850,881,912,943,974,1005,1036,1067,1098,1127,1160,1191,1222,1253,1284,1315,1346,1377,1408,1439,1470,1501,1529,1560};




        // Change till here as per requirements ----------------------------------------------------

        //Fixed for all activity--------------------------------------------------------------------

        for (int i = 0; i < editTextXPixel1.length; i++) {
            canvas.drawText(editTextDataForPDF[i], editTextXPixel1[i], editTextYPixel1[i], titlePaint);
        }



        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy_HHmm");
        String strData = sdf.format(calendar.getTime());
        // Fixed till here--------------------------------------------------------------------------

        // Change as per your requirement-----------------------------------------------------------
        titlePaint.setTextSize(20);

        canvas.drawText(Date, 219,312, titlePaint);//Printing Date on PDF

        myPdfdocument.finishPage(myPage1);


        PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(1275, 1650, 2).create();

        // start a page
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);

        canvas = myPage2.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.dvrretiadailyrecordingchecks2);
        scaledbmp = Bitmap.createScaledBitmap(bmp, 1275, 1650, false);
        canvas.drawBitmap(scaledbmp, 0, 0, paint);

        titlePaint.setTextSize(20);  //Change here
        paint.setTextAlign(Paint.Align.LEFT);

        int[] editTextXPixel2 = {490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000};
        int[] editTextYPixel2 = {345,376,407,438,469,500,531,562,593,624,655,686,717,748,779,810,841,872,903,934,965,996,1027,1058,1089,1120,1151,1182,1213,1244,1275,1306,345,376,407,438,469,500,531,562,593,624,655,686,717,748,779,810,841,872,903,934,965,996,1027,1058,1089,1120,1151,1182,1213,1244,1275,1306,345,376,407,438,469,500,531,562,593,624,655,686,717,748,779,810,841,872,903,934,965,996,1027,1058,1089,1120,1151,1182,1213,1244,1275,1306};


        // Change till here as per requirements ----------------------------------------------------

        //Fixed for all activity--------------------------------------------------------------------

        for (int i = 0; i < editTextXPixel2.length; i++) {
            canvas.drawText(editTextDataForPDF[i + editTextXPixel1.length], editTextXPixel2[i], editTextYPixel2[i], titlePaint);
        }


        myPdfdocument.finishPage(myPage2);


        PdfDocument.PageInfo myPageInfo3 = new PdfDocument.PageInfo.Builder(1275, 1650, 3).create();

// start a page
        PdfDocument.Page myPage3 = myPdfdocument.startPage(myPageInfo3);

        canvas = myPage3.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.dvrretiadailyrecordingchecks3);
        scaledbmp = Bitmap.createScaledBitmap(bmp, 1275, 1650, false);
        canvas.drawBitmap(scaledbmp, 0, 0, paint);

        titlePaint.setTextSize(20);  //Change here
        paint.setTextAlign(Paint.Align.LEFT);

        int[] editTextXPixel3 = {490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000};
        int[] editTextYPixel3 = {311,344,375,406,434,468,499,530,558,590,619,651,682,713,747,778,809,836,867,902,929,960,991,1023,1053,1085,1116,1145,1179,1209,1240,1270,311,344,375,406,434,468,499,530,558,590,619,651,682,713,747,778,809,836,867,902,929,960,991,1023,1053,1085,1116,1145,1179,1209,1240,1270,311,344,375,406,434,468,499,530,558,590,619,651,682,713,747,778,809,836,867,902,929,960,991,1023,1053,1085,1116,1145,1179,1209,1240,1270};


// Change till here as per requirements ----------------------------------------------------

//Fixed for all activity--------------------------------------------------------------------

        for (int i = 0; i < editTextXPixel3.length; i++) {
            canvas.drawText(editTextDataForPDF[i + editTextXPixel1.length+editTextXPixel2.length], editTextXPixel3[i], editTextYPixel3[i], titlePaint);
        }


        myPdfdocument.finishPage(myPage3);

        PdfDocument.PageInfo myPageInfo4 = new PdfDocument.PageInfo.Builder(1275, 1650, 4).create();

// start a page
        PdfDocument.Page myPage4 = myPdfdocument.startPage(myPageInfo4);

        canvas = myPage4.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.dvrretiadailyrecordingchecks4);
        scaledbmp = Bitmap.createScaledBitmap(bmp, 1275, 1650, false);
        canvas.drawBitmap(scaledbmp, 0, 0, paint);

        titlePaint.setTextSize(20);  //Change here
        paint.setTextAlign(Paint.Align.LEFT);

        int[] editTextXPixel4 = {490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000};
        int[] editTextYPixel4 = {311,344,375,406,434,468,499,530,558,590,619,651,682,713,747,778,807,836,867,902,929,960,991,1023,1053,1085,1116,1145,1179,1209,1240,1270,311,344,375,406,434,468,499,530,558,590,619,651,682,713,747,778,807,836,867,902,929,960,991,1023,1053,1085,1116,1145,1179,1209,1240,1270,311,344,375,406,434,468,499,530,558,590,619,651,682,713,747,778,807,836,867,902,929,960,991,1023,1053,1085,1116,1145,1179,1209,1240,1270};


// Change till here as per requirements ----------------------------------------------------

//Fixed for all activity--------------------------------------------------------------------

        for (int i = 0; i < editTextXPixel4.length; i++) {
            canvas.drawText(editTextDataForPDF[i + editTextXPixel1.length+editTextXPixel2.length+editTextXPixel3.length], editTextXPixel4[i], editTextYPixel4[i], titlePaint);
        }


        myPdfdocument.finishPage(myPage4);

        PdfDocument.PageInfo myPageInfo5 = new PdfDocument.PageInfo.Builder(1275, 1650, 5).create();

// start a page
        PdfDocument.Page myPage5 = myPdfdocument.startPage(myPageInfo5);

        canvas = myPage5.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.dvrretiadailyrecordingcheckslast);
        scaledbmp = Bitmap.createScaledBitmap(bmp, 1275, 1650, false);
        canvas.drawBitmap(scaledbmp, 0, 0, paint);

        titlePaint.setTextSize(20);  //Change here
        paint.setTextAlign(Paint.Align.LEFT);

        int[] editTextXPixel5 = {105};
        int[] editTextYPixel5 = {290};


// Change till here as per requirements ----------------------------------------------------

//Fixed for all activity--------------------------------------------------------------------

        for (int i = 0; i < editTextXPixel5.length; i++) {
            canvas.drawText(editTextDataForPDF[i + editTextXPixel1.length+editTextXPixel2.length+editTextXPixel3.length + editTextXPixel4.length], editTextXPixel5[i], editTextYPixel5[i], titlePaint);
        }


        canvas.drawBitmap(Bitmap.createScaledBitmap(MySignature.sigNature, 390, 370, false), 639,977, paint);


        myPdfdocument.finishPage(myPage5);


        ActivityCompat.requestPermissions(this, new String[]{

                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);

        //----------------------Change-----------------------------------------------------------------------------
        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Communication/DVR/RETIA/Daily Shift Recording Checks/";// Change Here------------------
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }


        //String targetPdf = directory_path + "test.pdf";
        //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
        String fileName = "VHF_DVR_Daily_Recordings" + strData + ".pdf"; // Change Here--------------------------
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

         myFunctions.saveToParse(targetPdf, fileName, "DVR", "Daily", outputEditText, MyFunctions.specificCode("d"),"outputSwitch", "outputSpinner");// Change Here-----------------------

        // This function will send eMail using JavaMailAPI
        //myFunctions.sendEmail(String To, String Subject, String Message,String targetPdf,String desired_Filename)


        myFunctions.sendEmail(PersonalDetailsActivity.emailTo + "@aai.aero",
                "Daily Channel Recording Checks of DVR RETIA -  done.",//Change Here-----------------------------
                "Maintenance Schedule is attached. Please verify.", targetPdf, fileName);
        //---------------------------------------------------------------------------------------------------------


        myFunctions.toLogoutActivity();




    }

    private void generatePDF2() {

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



        PdfDocument.PageInfo myPageInfo1 = new PdfDocument.PageInfo.Builder(1275, 1650, 1).create();

        // start a page
        PdfDocument.Page myPage1 = myPdfdocument.startPage(myPageInfo1);
        Canvas canvas = myPage1.getCanvas();


        Bitmap bmp, scaledbmp;


//--------------------------------------------------------------------------------------------
        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.dvrretiadailyrecordingchecks1);
        scaledbmp = Bitmap.createScaledBitmap(bmp, 1275, 1650, false);
//--------------------------------------------------------------------------------------------
        canvas.drawBitmap(scaledbmp, 0, 0, paint);


        titlePaint.setTextSize(20);
        paint.setTextAlign(Paint.Align.LEFT);
        //canvas.drawText("Name: " + PersonalDetailsActivity.naam ,1500,32,titlePaint);
        //canvas.drawText("Desig: " + PersonalDetailsActivity.design ,1500,64,titlePaint);
        //canvas.drawText("Emp No.: " + PersonalDetailsActivity.EmpID ,1500,96,titlePaint);
        //canvas.drawText("Location: " + MainActivity.latLong1,1500,128,titlePaint);
        //canvas.drawBitmap(PersonalDetailsActivity.photo, 540, 4, paint);
        //--------------------------------Change as per your requirement------------------------------------------------------
        //canvas.drawBitmap(Bitmap.createScaledBitmap(PersonalDetailsActivity.sigNature,500,510, false), 1325, 2720, paint);
        //canvas.drawBitmap(PersonalDetailsActivity.sigNature, 1325, 2720, paint);
        titlePaint.setTextSize(20);
        int[] editTextXPixel1 = {241,931,1013,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000};
        int[] editTextYPixel1 = {285,285,312,602,633,664,695,726,757,788,819,850,881,912,943,974,1005,1036,1067,1098,1129,1160,1191,1222,1253,1284,1315,1346,1377,1408,1439,1470,1501,1529,1560,602,633,664,695,726,757,788,819,850,881,912,943,974,1005,1036,1067,1098,1129,1160,1191,1222,1253,1284,1315,1346,1377,1408,1439,1470,1501,1529,1560,602,633,664,695,726,757,788,819,850,881,912,943,974,1005,1036,1067,1098,1129,1160,1191,1222,1253,1284,1315,1346,1377,1408,1439,1470,1501,1529,1560};


        // Change till here as per requirements ----------------------------------------------------

        //Fixed for all activity--------------------------------------------------------------------

        for (int i = 0; i < editTextXPixel1.length; i++) {
            canvas.drawText(editTextDataForPDF[i], editTextXPixel1[i], editTextYPixel1[i], titlePaint);
        }


        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy_HHmm");
        String strData = sdf.format(calendar.getTime());
        // Fixed till here--------------------------------------------------------------------------

        // Change as per your requirement-----------------------------------------------------------
        titlePaint.setTextSize(20);

        canvas.drawText(Date, 219,312, titlePaint);//Printing Date on PDF

        myPdfdocument.finishPage(myPage1);


        PdfDocument.PageInfo myPageInfo2 = new PdfDocument.PageInfo.Builder(1275, 1650, 2).create();

        // start a page
        PdfDocument.Page myPage2 = myPdfdocument.startPage(myPageInfo2);

        canvas = myPage2.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.dvrretiadailyrecordingchecks2);
        scaledbmp = Bitmap.createScaledBitmap(bmp, 1275, 1650, false);
        canvas.drawBitmap(scaledbmp, 0, 0, paint);

        titlePaint.setTextSize(20);  //Change here
        paint.setTextAlign(Paint.Align.LEFT);


        int[] editTextXPixel2 = {490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,490,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,825,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000};
        int[] editTextYPixel2 = {345,376,407,438,469,500,531,562,593,624,655,686,717,748,779,810,841,872,903,934,965,996,1027,1058,1089,1120,1151,1182,1213,1244,1275,1306,345,376,407,438,469,500,531,562,593,624,655,686,717,748,779,810,841,872,903,934,965,996,1027,1058,1089,1120,1151,1182,1213,1244,1275,1306,345,376,407,438,469,500,531,562,593,624,655,686,717,748,779,810,841,872,903,934,965,996,1027,1058,1089,1120,1151,1182,1213,1244,1275,1306};



        // Change till here as per requirements ----------------------------------------------------

        //Fixed for all activity--------------------------------------------------------------------

        for (int i = 0; i < editTextXPixel2.length; i++) {
            canvas.drawText(editTextDataForPDF[i + editTextXPixel1.length], editTextXPixel2[i], editTextYPixel2[i], titlePaint);
        }


        myPdfdocument.finishPage(myPage2);




        PdfDocument.PageInfo myPageInfo3 = new PdfDocument.PageInfo.Builder(1275, 1650, 3).create();

// start a page
        PdfDocument.Page myPage3 = myPdfdocument.startPage(myPageInfo3);

        canvas = myPage3.getCanvas();
        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.dvrretiadailyrecordingcheckslast);
        scaledbmp = Bitmap.createScaledBitmap(bmp, 1275, 1650, false);
        canvas.drawBitmap(scaledbmp, 0, 0, paint);

        titlePaint.setTextSize(20);  //Change here
        paint.setTextAlign(Paint.Align.LEFT);

        canvas.drawText(editTextArray[387].getText().toString() ,105,290,titlePaint);

        canvas.drawBitmap(Bitmap.createScaledBitmap(MySignature.sigNature, 390, 370, false), 639,977, paint);


        myPdfdocument.finishPage(myPage3);


        ActivityCompat.requestPermissions(this, new String[]{

                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);

        //----------------------Change-----------------------------------------------------------------------------
        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Maintenance Schedules/Communication/DVR/RETIA/Daily Shift Recording Checks/";// Change Here------------------
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }


        //String targetPdf = directory_path + "test.pdf";
        //String fileName = "Daily ADSB " + dateFormat.format(dateObj) + ".pdf";
        String fileName = "VHF_DVR_Daily_Recordings" + strData + ".pdf"; // Change Here--------------------------
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

         myFunctions.saveToParse(targetPdf, fileName, "DVR", "Daily", outputEditText, MyFunctions.specificCode("d"),"outputSwitch", "outputSpinner");// Change Here-----------------------

        // This function will send eMail using JavaMailAPI
        //myFunctions.sendEmail(String To, String Subject, String Message,String targetPdf,String desired_Filename)


        myFunctions.sendEmail(PersonalDetailsActivity.emailTo + "@aai.aero",
                "Daily Channel Recording Checks of DVR RETIA -  done.",//Change Here-----------------------------
                "Maintenance Schedule is attached. Please verify.", targetPdf, fileName);
        //---------------------------------------------------------------------------------------------------------


        myFunctions.toLogoutActivity();




    }



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
}

