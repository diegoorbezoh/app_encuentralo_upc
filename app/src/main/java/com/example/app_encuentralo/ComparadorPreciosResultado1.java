package com.example.app_encuentralo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.app_encuentralo.entidades.Producto;

import java.util.ArrayList;

public class ComparadorPreciosResultado1 extends AppCompatActivity {

    ListView listViewProductos;
    ArrayList<String> listaInformacion;
    ArrayList<Producto> listaProducto;
    ConexionSQLiteHelper conn;

    String filtroClave,filtroCategoria;
    Double filtroDesde,filtroHasta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //filtroDesde=getIntent().getExtras().getDouble("Desde");
        //filtroHasta=getIntent().getExtras().getDouble("Hasta");
        filtroCategoria=getIntent().getExtras().getString("Categoria");
        filtroClave=getIntent().getExtras().getString("Clave");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparador_precios_resultado1);

        conn = new ConexionSQLiteHelper(getApplicationContext(),"bd_encuentralo", null,1);

        listViewProductos = (ListView) findViewById(R.id.listViewProductos);

        consultarListaProductos();

        ArrayAdapter adaptador=new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaInformacion);
        listViewProductos.setAdapter(adaptador);

    }

    public void consultarListaProductos(){
        SQLiteDatabase db=conn.getReadableDatabase();
        String parametros[]={filtroCategoria,"%"+filtroClave+"%"};
        Producto producto=null;
        listaProducto=new ArrayList<Producto>();

        Cursor cursor = db.rawQuery("SELECT descripcion,codProducto,precio from producto where categoria=? and descripcion like ?",parametros);

        while(cursor.moveToNext()){
            producto = new Producto();
            producto.setDescripcion(cursor.getString(0));
            producto.setCodProducto(cursor.getString(1));
            producto.setPrecio(Double.parseDouble(cursor.getString(2)));

            listaProducto.add(producto);
        }
        obtenerLista();
    }

    public void obtenerLista(){
        listaInformacion=new ArrayList<String>();

        for(int i=0;i<listaProducto.size();i++){
            listaInformacion.add(listaProducto.get(i).getCodProducto()+" - " +listaProducto.get(i).getDescripcion());
        }
    }
}