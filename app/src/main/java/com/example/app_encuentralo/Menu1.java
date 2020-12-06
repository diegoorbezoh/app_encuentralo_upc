package com.example.app_encuentralo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu1);

        Button btnComparador = findViewById(R.id.btnComparador);
        Button btnPuntuacion = findViewById(R.id.btnPuntuacion);
        btnComparador.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu1.this,ComparadorPrecios1.class);
                startActivity(intent);
            }
        });

        btnPuntuacion.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu1.this,MenuPuntuacion.class);
                startActivity(intent);
            }
        });
    }
}