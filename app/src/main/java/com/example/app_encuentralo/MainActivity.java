package com.example.app_encuentralo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void asignarReferencias() {
        abrirFragmento(new inicio());
    }

    private void abrirFragmento(Fragment fragment){
    getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment)
    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
    }
}