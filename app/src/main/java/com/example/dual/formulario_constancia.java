package com.example.dual;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class formulario_constancia extends AppCompatActivity {

    TextView numeroControl, grupo, apellidoPaterno, apellidoMaterno, nombre, fecha, observaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_constancia);

        numeroControl = (EditText) findViewById(R.id.ingresa_numeroControl1);
        grupo = (EditText) findViewById(R.id.ingresa_grupo1);
        apellidoPaterno = (EditText) findViewById(R.id.ingresa_paterno1);
        apellidoMaterno = (EditText) findViewById(R.id.ingresa_materno1);
        nombre = (EditText) findViewById(R.id.ingresa_nombre1);
        fecha = (EditText) findViewById(R.id.ingresa_fecha1);
        observaciones = (EditText) findViewById(R.id.ingresa_observaciones1);
    }
    public void enviarDatosConstancia(View view) {

        numeroControl.setText("");
        grupo.setText("");
        apellidoPaterno.setText("");
        apellidoMaterno.setText("");
        nombre.setText("");
        fecha.setText("");
        observaciones.setText("");

        Toast.makeText(formulario_constancia.this, "Solicitud enviada",Toast.LENGTH_SHORT).show();
    }
    public void regresarPantalla (View view){
        onBackPressed();
    }
}