package com.example.dual.formularios;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dual.R;

public class formulario_historial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_historial);
    }
    public void regresarPantalla (View view){
        onBackPressed();
    }
}