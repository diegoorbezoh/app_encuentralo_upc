package com.example.app_encuentralo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app_encuentralo.utilidades.Utilidades;

public class Login1 extends AppCompatActivity {

    EditText campoCorreo, campoClave;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);

        conn = new ConexionSQLiteHelper(getApplicationContext(),"bd_encuentralo", null,1);

        Button btnIngresarLogin = findViewById(R.id.btnIngresarLogin);
        btnIngresarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                consultar();
            }
        });

        campoCorreo = (EditText)findViewById(R.id.txtCorreo);
        campoClave = (EditText)findViewById(R.id.txtClave);
    }

    private void consultar() {
        SQLiteDatabase db = conn.getReadableDatabase();
        String[] parametros = {campoCorreo.getText().toString(),campoClave.getText().toString()};
        String[] campos ={Utilidades.TABLA_USUARIO_EMAIL,Utilidades.TABLA_USUARIO_CONTRASENIA};

        try{
            Cursor cursor = db.query(Utilidades.TABLA_USUARIO,campos,Utilidades.TABLA_USUARIO_EMAIL+"=? AND "+Utilidades.TABLA_USUARIO_CONTRASENIA+"=?",parametros,null,null,null);
            if(cursor.moveToFirst()){
                Intent intent = new Intent(Login1.this,Menu1.class);
                startActivity(intent);

            }else{
                Toast.makeText(getApplicationContext(),"El usuario y/o contraseña son incorrectos",Toast.LENGTH_LONG).show();
            }

        }catch(Exception e){
            Toast.makeText(getApplicationContext(),"El usuario y/o contraseña son incorrectos",Toast.LENGTH_LONG).show();
        }


    }
}