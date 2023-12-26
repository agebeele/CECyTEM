package com.example.dual.alumnos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dual.R;

public class Activity_Egresado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egresado);
    }
    public void regresarLogin (View view) {
        Intent regresar = new Intent(Activity_Egresado.this, Activity_Login.class);
        startActivity(regresar);
    }
}