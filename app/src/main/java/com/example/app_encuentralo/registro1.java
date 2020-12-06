package com.example.app_encuentralo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app_encuentralo.utilidades.Utilidades;

public class registro1 extends AppCompatActivity {

    EditText campoNombre,campoContrasenia,campoEmail,campoEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro1);



        campoNombre = (EditText) findViewById(R.id.txtNombreReg);
        campoContrasenia= (EditText) findViewById(R.id.txtContraseniaReg);
        campoEmail= (EditText) findViewById(R.id.txtEmailReg);
        campoEdad= (EditText) findViewById(R.id.txtEdadReg);

        Button btnRegistrar = findViewById(R.id.btnRegistroUsuario);
        btnRegistrar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                registrarUsuarios();
            }
        });


    }

    /*public void onClick(View view){
        registrarUsuarios();
    }*/

    private void registrarUsuarios(){
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_encuentralo",null,1);
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Utilidades.TABLA_USUARIO_NOMBRE,campoNombre.getText().toString());
        values.put(Utilidades.TABLA_USUARIO_CONTRASENIA,campoContrasenia.getText().toString());
        values.put(Utilidades.TABLA_USUARIO_EMAIL,campoEmail.getText().toString());
        values.put(Utilidades.TABLA_USUARIO_EDAD,campoEdad.getText().toString());

        Long idRegistro = db.insert(Utilidades.TABLA_USUARIO,null,values);

        Toast.makeText(getApplicationContext(), "El usuario fue creado", Toast.LENGTH_SHORT).show();
        db.close();

        campoNombre.setText(" ");
        campoContrasenia.setText(" ");
        campoEmail.setText(" ");
        campoEdad.setText(" ");
    }
}