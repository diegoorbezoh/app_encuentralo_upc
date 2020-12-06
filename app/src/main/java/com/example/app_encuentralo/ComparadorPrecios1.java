package com.example.app_encuentralo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.app_encuentralo.utilidades.Utilidades;

import java.util.ArrayList;

public class ComparadorPrecios1 extends AppCompatActivity {

    EditText txtDesde,txtHasta,txtPalabraClave;
    Spinner comboCategorias;
    ConexionSQLiteHelper conn;
    ArrayList<String> categorias = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparador_precios1);

        txtDesde = (EditText) findViewById(R.id.txtDesde);
        txtHasta= (EditText) findViewById(R.id.txtHasta);
        txtPalabraClave= (EditText) findViewById(R.id.txtPalabraClave);

        conn = new ConexionSQLiteHelper(getApplicationContext(),"bd_encuentralo", null,1);
        comboCategorias = (Spinner)findViewById(R.id.comboCategorias);
        consultarListaCategorias();
        ArrayAdapter<CharSequence> adaptador = new ArrayAdapter(this, android.R.layout.simple_spinner_item,categorias);
        comboCategorias.setAdapter(adaptador);


        Button btnBuscar = findViewById(R.id.btnBuscar);
        btnBuscar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ComparadorPrecios1.this,ComparadorPreciosResultado1.class);
                //intent.putExtra("Desde", Double.parseDouble(txtDesde.getText().toString()));
                //intent.putExtra("Hasta", Double.parseDouble(txtHasta.getText().toString()));
                intent.putExtra("Categoria", comboCategorias.getSelectedItem().toString());
                intent.putExtra("Clave", txtPalabraClave.getText().toString());
                startActivity(intent);
            }
        });
    }

    public void consultarListaCategorias(){
        SQLiteDatabase db = conn.getReadableDatabase();

        Cursor cursor =db.rawQuery("SELECT distinct categoria FROM "+ Utilidades.TABLA_PRODUCTO,null);

        while(cursor.moveToNext()){
            categorias.add(cursor.getString(0));
        }
    }
}