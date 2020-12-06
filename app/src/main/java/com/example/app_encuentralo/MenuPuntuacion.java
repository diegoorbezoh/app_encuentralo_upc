package com.example.app_encuentralo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuPuntuacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_puntuacion);

        Button btnRegistrarComprobante = findViewById(R.id.btnRegistrarComprobante);
        Button btnSIstemaPuntuacion = findViewById(R.id.btnSIstemaPuntuacion);
        btnRegistrarComprobante.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuPuntuacion.this,RegistraComprobante.class);
                startActivity(intent);
            }
        });

        btnSIstemaPuntuacion.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuPuntuacion.this,Puntos.class);
                startActivity(intent);
            }
        });
    }
}