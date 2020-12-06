package com.example.app_encuentralo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.ContentValues;
import android.content.Intent;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.app_encuentralo.entidades.Producto;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_inicio);
        inicializar();


        Button btnIngresar = findViewById(R.id.btnIngresar);
        Button btnRegistrar = findViewById(R.id.btnRegistrar);
        btnIngresar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Login1.class);
                startActivity(intent);
            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,registro1.class);
                startActivity(intent);
            }
        });
    }

    private void inicializar(){

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"bd_encuentralo",null,1);
        SQLiteDatabase db = conn.getWritableDatabase();
        db.beginTransaction();

        Producto[] productos =new Producto[186];
        productos[0] = new Producto("PV001105","alitas de pollo sadia bolsa 1kg","POLLO","PLAZA VEA",11.6);
        productos[0] = new Producto("PV001105","alitas de pollo sadia bolsa 1kg","POLLO","PLAZA VEA",11.6);
        productos[1] = new Producto("MT001105","alitas de pollo sadia bolsa 1kg","POLLO","METRO",11.9);
        productos[2] = new Producto("PV001042","apio x unidad","VEGETALES","PLAZA VEA",1.69);
        productos[3] = new Producto("PV001041","arveja","VEGETALES","PLAZA VEA",5.49);
        productos[4] = new Producto("MT001041","arveja","VEGETALES","METRO",6.29154617715092);
        productos[5] = new Producto("PV001108","baby chicken congelado redondos","POLLO","PLAZA VEA",14.2);
        productos[6] = new Producto("MT001108","baby chicken congelado redondos","POLLO","METRO",14.1468900259937);
        productos[7] = new Producto("PV001083","bebida de almendras laive caja 1l","LECHES","PLAZA VEA",9.99);
        productos[8] = new Producto("MT001083","bebida de almendras laive caja 1l","LECHES","METRO",10.3991253667281);
        productos[9] = new Producto("PV001082","bebida evaporada soy vida lata 400g paquete 6un","LECHES","PLAZA VEA",12.8);
        productos[10] = new Producto("MT001082","bebida evaporada soy vida lata 400g paquete 6un","LECHES","METRO",13.7560165343904);
        productos[11] = new Producto("PV001040","brocoli","VEGETALES","PLAZA VEA",3.7);
        productos[12] = new Producto("PV001037","camote amarillo procesado","VEGETALES","PLAZA VEA",2);
        productos[13] = new Producto("PV001047","cebolla blanca","VEGETALES","PLAZA VEA",2.59);
        productos[14] = new Producto("PV001028","cebolla roja bell's bolsa 2kg","VEGETALES","PLAZA VEA",1.99);
        productos[15] = new Producto("PV001048","champiñon entero bell's bandeja 200g","VEGETALES","PLAZA VEA",5.8);
        productos[16] = new Producto("MT001048","champiñon entero bell's bandeja 200g","VEGETALES","METRO",6.27729172813488);
        productos[17] = new Producto("PV001031","choclo x unidad","VEGETALES","PLAZA VEA",1.69);
        productos[18] = new Producto("PV001103","corazon de pollo","POLLO","PLAZA VEA",9.99);
        productos[19] = new Producto("MT001103","corazon de pollo","POLLO","METRO",10.071901386155);
        productos[20] = new Producto("PV001065","crema de leche bravo crem caja 500ml 1un","LECHES","PLAZA VEA",7.39);
        productos[21] = new Producto("MT001065","crema de leche bravo crem caja 500ml 1un","LECHES","METRO",7.50023178213356);
        productos[22] = new Producto("PV001063","crema de leche gloria bolsa 946ml","LECHES","PLAZA VEA",14.9);
        productos[23] = new Producto("MT001063","crema de leche gloria bolsa 946ml","LECHES","METRO",15.4642463207703);
        productos[24] = new Producto("PV001066","crema de leche laive bolsa 946ml","LECHES","PLAZA VEA",15.9);
        productos[25] = new Producto("MT001066","crema de leche laive bolsa 946ml","LECHES","METRO",16.1020197262696);
        productos[26] = new Producto("PV001064","crema de leche nestle lata 300g","LECHES","PLAZA VEA",8.9);
        productos[27] = new Producto("MT001064","crema de leche nestle lata 300g","LECHES","METRO",9.10471053102487);
        productos[28] = new Producto("PV001067","crema de leche president entera uht caja 200ml","LECHES","PLAZA VEA",10.69);
        productos[29] = new Producto("MT001067","crema de leche president entera uht caja 200ml","LECHES","METRO",11.1717587752287);
        productos[30] = new Producto("PV001062","crema de leche uht gloria caja 250ml","LECHES","PLAZA VEA",6.39);
        productos[31] = new Producto("PV001046","culantro x unidad","VEGETALES","PLAZA VEA",1.7);
        productos[32] = new Producto("MT001046","culantro x unidad","VEGETALES","METRO",2.51851346127353);
        productos[33] = new Producto("PV001038","espinaca bell's bolsa 350g","VEGETALES","PLAZA VEA",4.5);
        productos[34] = new Producto("MT001038","espinaca bell's bolsa 350g","VEGETALES","METRO",5.49536047403793);
        productos[35] = new Producto("PV001073","evaporada laive sin lactosa caja 500g paquete 6un","LECHES","PLAZA VEA",18.9);
        productos[36] = new Producto("MT001073","evaporada laive sin lactosa caja 500g paquete 6un","LECHES","METRO",19.6034213205059);
        productos[37] = new Producto("PV001088","filete de pechuga de pollo","POLLO","PLAZA VEA",23.99);
        productos[38] = new Producto("PV001096","filete de pechuga de pollo","POLLO","PLAZA VEA",20.99);
        productos[39] = new Producto("MT001096","filete de pechuga de pollo","POLLO","METRO",21.0913973162773);
        productos[40] = new Producto("MT001088","filete de pechuga de pollo","POLLO","METRO",24.8494472265621);
        productos[41] = new Producto("PV001094","filete de pechuga importado sadia bolsa 1kg","POLLO","PLAZA VEA",12.9);
        productos[42] = new Producto("MT001094","filete de pechuga importado sadia bolsa 1kg","POLLO","METRO",13.2663131963816);
        productos[43] = new Producto("PV001107","filete de pierna de pollo","POLLO","PLAZA VEA",20.9);
        productos[44] = new Producto("MT001107","filete de pierna de pollo","POLLO","METRO",21.8660352099322);
        productos[45] = new Producto("PV001106","filete parrillero de pollo","POLLO","PLAZA VEA",17.99);
        productos[46] = new Producto("MT001106","filete parrillero de pollo","POLLO","METRO",18.5706809030891);
        productos[47] = new Producto("PV001086","gallina con menudencia sadia","POLLO","PLAZA VEA",4.9);
        productos[48] = new Producto("MT001086","gallina con menudencia sadia","POLLO","METRO",5.85822359388808);
        productos[49] = new Producto("PV001012","granadilla oxapampa x unidad","FRUTAS","PLAZA VEA",0.49);
        productos[50] = new Producto("MT001012","granadilla oxapampa x unidad","FRUTAS","METRO",0.529183779777588);
        productos[51] = new Producto("PV001097","higado de pollo","POLLO","PLAZA VEA",5.9);
        productos[52] = new Producto("MT001097","higado de pollo","POLLO","METRO",6.20425267345243);
        productos[53] = new Producto("PV001057","huevos blancos la calera paquete 15un","LÁCTEOS Y HUEVOS","PLAZA VEA",6.9);
        productos[54] = new Producto("MT001057","huevos blancos la calera paquete 15un","LÁCTEOS Y HUEVOS","METRO",7.39962136616886);
        productos[55] = new Producto("PV001061","huevos de codorniz bell's bandeja 18un","LÁCTEOS Y HUEVOS","PLAZA VEA",4.99);
        productos[56] = new Producto("MT001061","huevos de codorniz bell's bandeja 18un","LÁCTEOS Y HUEVOS","METRO",5.03496170385599);
        productos[57] = new Producto("PV001056","huevos de codorniz bell's bandeja 24un","LÁCTEOS Y HUEVOS","PLAZA VEA",6.49);
        productos[58] = new Producto("PV001052","huevos de codorniz la calera bandeja 18un","LÁCTEOS Y HUEVOS","PLAZA VEA",4.79);
        productos[59] = new Producto("PV001049","huevos de gallina bell's pardos bandeja 15un","LÁCTEOS Y HUEVOS","PLAZA VEA",5.9);
        productos[60] = new Producto("MT001049","huevos de gallina bell's pardos bandeja 15un","LÁCTEOS Y HUEVOS","METRO",6.58877369860048);
        productos[61] = new Producto("PV001051","huevos de gallina la calera de corral bandeja 12un","LÁCTEOS Y HUEVOS","PLAZA VEA",8.99);
        productos[62] = new Producto("MT001051","huevos de gallina la calera de corral bandeja 12un","LÁCTEOS Y HUEVOS","METRO",9.6416400530376);
        productos[63] = new Producto("PV001054","huevos de gallina la calera pardos jumbo bandeja 15un","LÁCTEOS Y HUEVOS","PLAZA VEA",8.49);
        productos[64] = new Producto("PV001059","huevos la calera super jumbo paquete 10un","LÁCTEOS Y HUEVOS","PLAZA VEA",8.29);
        productos[65] = new Producto("PV001058","huevos organicos pachacamac caja 12un","LÁCTEOS Y HUEVOS","PLAZA VEA",17.9);
        productos[66] = new Producto("MT001058","huevos organicos pachacamac caja 12un","LÁCTEOS Y HUEVOS","METRO",18.4920692204664);
        productos[67] = new Producto("PV001053","huevos pardos bell's paquete 30un","LÁCTEOS Y HUEVOS","PLAZA VEA",11.49);
        productos[68] = new Producto("MT001053","huevos pardos bell's paquete 30un","LÁCTEOS Y HUEVOS","METRO",12.1228695015142);
        productos[69] = new Producto("PV001060","huevos pardos bell's regulares paquete 8un","LÁCTEOS Y HUEVOS","PLAZA VEA",3.99);
        productos[70] = new Producto("PV001055","huevos pardos gallinas libres bandeja 12un","LÁCTEOS Y HUEVOS","PLAZA VEA",11.79);
        productos[71] = new Producto("MT001055","huevos pardos gallinas libres bandeja 12un","LÁCTEOS Y HUEVOS","METRO",12.3223409489689);
        productos[72] = new Producto("PV001050","huevos pardos la calera paquete 30un","LÁCTEOS Y HUEVOS","PLAZA VEA",12.69);
        productos[73] = new Producto("MT001050","huevos pardos la calera paquete 30un","LÁCTEOS Y HUEVOS","METRO",13.6611191856244);
        productos[74] = new Producto("PV001070","leche evaporada gloria light paquete 6un lata 400g","LECHES","PLAZA VEA",19.99);
        productos[75] = new Producto("MT001070","leche evaporada gloria light paquete 6un lata 400g","LECHES","METRO",20.911218260442);
        productos[76] = new Producto("PV001069","leche evaporada gloria niños paquete 6un lata 400g","LECHES","PLAZA VEA",19.99);
        productos[77] = new Producto("PV001071","leche evaporada gloria sin lactosa paquete 6un lata 400g","LECHES","PLAZA VEA",19.99);
        productos[78] = new Producto("MT001071","leche evaporada gloria sin lactosa paquete 6un lata 400g","LECHES","METRO",20.8642245992675);
        productos[79] = new Producto("PV001076","leche evaporada laive sin lactosa caja 350g paquete 6un","LECHES","PLAZA VEA",18.99);
        productos[80] = new Producto("MT001076","leche evaporada laive sin lactosa caja 350g paquete 6un","LECHES","METRO",19.5757887403288);
        productos[81] = new Producto("PV001080","leche fresca laive sin lactosa paquete 4un caja 1l","LECHES","PLAZA VEA",18.29);
        productos[82] = new Producto("MT001080","leche fresca laive sin lactosa paquete 4un caja 1l","LECHES","METRO",18.6371051015174);
        productos[83] = new Producto("PV001084","leche gloria evaporada entera lata 400g","LECHES","PLAZA VEA",3.2);
        productos[84] = new Producto("MT001084","leche gloria evaporada entera lata 400g","LECHES","METRO",3.64204338219541);
        productos[85] = new Producto("PV001068","leche gloria evaporada entera lata 400g paquete 6un","LECHES","PLAZA VEA",18.99);
        productos[86] = new Producto("MT001068","leche gloria evaporada entera lata 400g paquete 6un","LECHES","METRO",19.0962500551175);
        productos[87] = new Producto("PV001075","leche gloria uht entera bolsa 900ml paquete 3un","LECHES","PLAZA VEA",9.99);
        productos[88] = new Producto("MT001075","leche gloria uht entera bolsa 900ml paquete 3un","LECHES","METRO",10.2026200124759);
        productos[89] = new Producto("PV001081","leche uht gloria entera pack 3un x 1l","LECHES","PLAZA VEA",13.2);
        productos[90] = new Producto("MT001081","leche uht gloria entera pack 3un x 1l","LECHES","METRO",14.1758373786076);
        productos[91] = new Producto("PV001079","leche uht gloria light pack 3un x 1l","LECHES","PLAZA VEA",13.2);
        productos[92] = new Producto("MT001079","leche uht gloria light pack 3un x 1l","LECHES","METRO",13.4629768856092);
        productos[93] = new Producto("PV001074","leche uht gloria sin lactosa pack 3un x 1l","LECHES","PLAZA VEA",14.1);
        productos[94] = new Producto("MT001074","leche uht gloria sin lactosa pack 3un x 1l","LECHES","METRO",14.3912976206555);
        productos[95] = new Producto("PV001045","lechuga crespa bell's","VEGETALES","PLAZA VEA",1.89);
        productos[96] = new Producto("MT001045","lechuga crespa bell's","VEGETALES","METRO",2.54847511209474);
        productos[97] = new Producto("PV001030","limon acido","VEGETALES","PLAZA VEA",3.49);
        productos[98] = new Producto("PV001026","limon acido malla 500g","VEGETALES","PLAZA VEA",1.9);
        productos[99] = new Producto("PV001005","mango edward","FRUTAS","PLAZA VEA",2.69);
        productos[100] = new Producto("PV001013","manzana delicia malla 2kg","FRUTAS","PLAZA VEA",8.29);
        productos[101] = new Producto("PV001020","manzana israel","FRUTAS","PLAZA VEA",2.29);
        productos[102] = new Producto("PV001011","manzana roja importada","FRUTAS","PLAZA VEA",6.49);
        productos[103] = new Producto("PV001009","manzana royal gala importada","FRUTAS","PLAZA VEA",6.59);
        productos[104] = new Producto("PV001022","manzana verde importada","FRUTAS","PLAZA VEA",6.49);
        productos[105] = new Producto("PV001014","maracuya malla 1kg","FRUTAS","PLAZA VEA",4.19);
        productos[106] = new Producto("PV001019","melocoton premium","FRUTAS","PLAZA VEA",10.99);
        productos[107] = new Producto("MT001019","melocoton premium","FRUTAS","METRO",11.3178337354167);
        productos[108] = new Producto("PV001085","mezcla lactea bonle familiar caja 500g paquete 6un","LECHES","PLAZA VEA",15.6);
        productos[109] = new Producto("MT001085","mezcla lactea bonle familiar caja 500g paquete 6un","LECHES","METRO",15.6059483052371);
        productos[110] = new Producto("PV001078","mezcla lactea evaporada laive light caja 500g paquete 6un","LECHES","PLAZA VEA",16.79);
        productos[111] = new Producto("MT001078","mezcla lactea evaporada laive light caja 500g paquete 6un","LECHES","METRO",16.8041462768944);
        productos[112] = new Producto("PV001072","mezcla lactea evaporada pura vida lata 395g 6un","LECHES","PLAZA VEA",13.5);
        productos[113] = new Producto("MT001072","mezcla lactea evaporada pura vida lata 395g 6un","LECHES","METRO",13.9843324259165);
        productos[114] = new Producto("PV001077","mezcla lactea ideal cremosita lata 395g paquete 6un","LECHES","PLAZA VEA",17.49);
        productos[115] = new Producto("MT001077","mezcla lactea ideal cremosita lata 395g paquete 6un","LECHES","METRO",18.089858624712);
        productos[116] = new Producto("PV001101","milanesa de pollo","POLLO","PLAZA VEA",19.9);
        productos[117] = new Producto("PV001089","muslitos de pollo","POLLO","PLAZA VEA",14.9);
        productos[118] = new Producto("PV001102","muslitos de pollo","POLLO","PLAZA VEA",13.49);
        productos[119] = new Producto("MT001102","muslitos de pollo","POLLO","METRO",13.5263480391633);
        productos[120] = new Producto("MT001089","muslitos de pollo","POLLO","METRO",14.6516598858885);
        productos[121] = new Producto("PV001104","muslos de pollo sadia bolsa 1kg","POLLO","PLAZA VEA",10.9);
        productos[122] = new Producto("MT001104","muslos de pollo sadia bolsa 1kg","POLLO","METRO",11.0359391283843);
        productos[123] = new Producto("PV001023","naranja de mesa importada","FRUTAS","PLAZA VEA",8.99);
        productos[124] = new Producto("MT001023","naranja de mesa importada","FRUTAS","METRO",8.82056746697762);
        productos[125] = new Producto("PV001004","naranja para jugo","FRUTAS","PLAZA VEA",1.49);
        productos[126] = new Producto("MT001004","naranja para jugo","FRUTAS","METRO",1.78750504720494);
        productos[127] = new Producto("PV001007","naranja para jugo malla 2kg","FRUTAS","PLAZA VEA",2.79);
        productos[128] = new Producto("MT001007","naranja para jugo malla 2kg","FRUTAS","METRO",2.63546916558916);
        productos[129] = new Producto("PV001002","palta fuerte","FRUTAS","PLAZA VEA",10.99);
        productos[130] = new Producto("MT001002","palta fuerte","FRUTAS","METRO",11.2396490328406);
        productos[131] = new Producto("PV001006","palta fuerte malla 1kg","FRUTAS","PLAZA VEA",10.59);
        productos[132] = new Producto("MT001006","palta fuerte malla 1kg","FRUTAS","METRO",11.4218580217805);
        productos[133] = new Producto("PV001036","papa amarilla bells malla 2kg","VEGETALES","PLAZA VEA",8.79);
        productos[134] = new Producto("MT001036","papa amarilla bells malla 2kg","VEGETALES","METRO",9.18881929042668);
        productos[135] = new Producto("PV001044","papa amarilla peruanita","VEGETALES","PLAZA VEA",5.2);
        productos[136] = new Producto("MT001044","papa amarilla peruanita","VEGETALES","METRO",6.1881765228607);
        productos[137] = new Producto("PV001035","papa canchan bell's malla 2kg","VEGETALES","PLAZA VEA",4.69);
        productos[138] = new Producto("PV001027","papa yungay bell's malla 2kg","VEGETALES","PLAZA VEA",1.89);
        productos[139] = new Producto("MT001027","papa yungay bell's malla 2kg","VEGETALES","METRO",2.74720441293283);
        productos[140] = new Producto("PV001003","papaya","FRUTAS","PLAZA VEA",4.49);
        productos[141] = new Producto("MT001003","papaya","FRUTAS","METRO",4.53554182041139);
        productos[142] = new Producto("PV001095","pechuga de pollo con alas","POLLO","PLAZA VEA",13.5);
        productos[143] = new Producto("MT001095","pechuga de pollo con alas","POLLO","METRO",14.1267984458597);
        productos[144] = new Producto("PV001093","pechuga especial de pollo","POLLO","PLAZA VEA",19.9);
        productos[145] = new Producto("PV001039","pepinillo","VEGETALES","PLAZA VEA",1.49);
        productos[146] = new Producto("PV001010","pera packhams importada","FRUTAS","PLAZA VEA",6.99);
        productos[147] = new Producto("MT001010","pera packhams importada","FRUTAS","METRO",7.02658506398053);
        productos[148] = new Producto("PV001091","pierna con encuentro de pollo","POLLO","PLAZA VEA",11.5);
        productos[149] = new Producto("MT001091","pierna con encuentro de pollo","POLLO","METRO",11.5346619476448);
        productos[150] = new Producto("PV001109","pierna especial de pollo","POLLO","PLAZA VEA",12.9);
        productos[151] = new Producto("MT001109","pierna especial de pollo","POLLO","METRO",13.7879979425081);
        productos[152] = new Producto("PV001092","piernitas de pollo","POLLO","PLAZA VEA",14.9);
        productos[153] = new Producto("MT001092","piernitas de pollo","POLLO","METRO",14.8361142916227);
        productos[154] = new Producto("PV001034","pimiento morron bolsa 500g","VEGETALES","PLAZA VEA",3.19);
        productos[155] = new Producto("MT001034","pimiento morron bolsa 500g","VEGETALES","METRO",3.88570326157709);
        productos[156] = new Producto("PV001008","piña golden","FRUTAS","PLAZA VEA",4.89);
        productos[157] = new Producto("PV001016","piña hawai","FRUTAS","PLAZA VEA",1.89);
        productos[158] = new Producto("MT001016","piña hawai","FRUTAS","METRO",1.74952635390557);
        productos[159] = new Producto("PV001021","platano bellaco","FRUTAS","PLAZA VEA",4.29);
        productos[160] = new Producto("MT001021","platano bellaco","FRUTAS","METRO",4.97735095786922);
        productos[161] = new Producto("PV001001","platano de seda paquete 5un","FRUTAS","PLAZA VEA",2.89);
        productos[162] = new Producto("MT001001","platano de seda paquete 5un","FRUTAS","METRO",3.6054008295312);
        productos[163] = new Producto("PV001018","platano isla la florencia","FRUTAS","PLAZA VEA",4.69);
        productos[164] = new Producto("PV001024","platano palillo","FRUTAS","PLAZA VEA",4.29);
        productos[165] = new Producto("MT001024","platano palillo","FRUTAS","METRO",4.84428353564843);
        productos[166] = new Producto("PV001087","pollo fresco con menudencia","POLLO","PLAZA VEA",7.4);
        productos[167] = new Producto("MT001087","pollo fresco con menudencia","POLLO","METRO",7.84711973222496);
        productos[168] = new Producto("PV001099","pollo fresco con menudencia san fernando","POLLO","PLAZA VEA",8.9);
        productos[169] = new Producto("MT001099","pollo fresco con menudencia san fernando","POLLO","METRO",9.17059207077715);
        productos[170] = new Producto("PV001090","pollo fresco con menudencia trozado en 8 piezas","POLLO","PLAZA VEA",7.69);
        productos[171] = new Producto("PV001017","sandia","FRUTAS","PLAZA VEA",1.49);
        productos[172] = new Producto("MT001017","sandia","FRUTAS","METRO",1.68198994968284);
        productos[173] = new Producto("PV001098","sangrecita de pollo redondos bolsa 500g","POLLO","PLAZA VEA",5.99);
        productos[174] = new Producto("MT001098","sangrecita de pollo redondos bolsa 500g","POLLO","METRO",6.3456182614954);
        productos[175] = new Producto("PV001100","sasami de pollo","POLLO","PLAZA VEA",23.9);
        productos[176] = new Producto("MT001100","sasami de pollo","POLLO","METRO",24.6514336362669);
        productos[177] = new Producto("PV001025","tomate italiano bell's bolsa 1kg","VEGETALES","PLAZA VEA",3.4);
        productos[178] = new Producto("PV001015","uva verde sin pepa","FRUTAS","PLAZA VEA",9.89);
        productos[179] = new Producto("MT001015","uva verde sin pepa","FRUTAS","METRO",10.2156787164188);
        productos[180] = new Producto("PV001032","vainita americana bolsa 500g","VEGETALES","PLAZA VEA",1.89);
        productos[181] = new Producto("MT001032","vainita americana bolsa 500g","VEGETALES","METRO",2.75069033563805);
        productos[182] = new Producto("PV001043","zanahoria","VEGETALES","PLAZA VEA",2.78);
        productos[183] = new Producto("MT001043","zanahoria","VEGETALES","METRO",3.48040888963319);
        productos[184] = new Producto("PV001033","zanahoria entera malla 1kg","VEGETALES","PLAZA VEA",2.69);
        productos[185] = new Producto("PV001029","zapallo macre","VEGETALES","PLAZA VEA",1.39);
        for(int i=0;i<productos.length;i++){
            ContentValues contentValues = new ContentValues();
            contentValues.put("codProducto",productos[i].getCodProducto());
            contentValues.put("descripcion",productos[i].getDescripcion());
            contentValues.put("categoria",productos[i].getCategoria());
            contentValues.put("cadena",productos[i].getCadena());
            contentValues.put("precio",productos[i].getPrecio());
            db.insert("producto",null,contentValues);
        }
        Toast.makeText(getApplicationContext(),"Productos insertados",Toast.LENGTH_LONG).show();
        db.setTransactionSuccessful();
        db.endTransaction();
    }
/*
    private long cantidadProductos(){
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"bd_encuentralo",null,1);
        SQLiteDatabase db = conn.getReadableDatabase();
        long cn = DatabaseUtils.queryNumEntries(db,"producto");
        db.close();
        return cn;
    }

    private String[] leerArchivo(){
        InputStream inputStream = getResources().openRawResource(R.raw.producto);
        ByteArrayOutputStream byteArrayInputStream = new ByteArrayOutputStream();
        try{
            int i = inputStream.read();
            while(i !=1){
                byteArrayInputStream.write(i);
                i=inputStream.read();
            }
            inputStream.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return byteArrayInputStream.toString().split("\n");
    }*/



}