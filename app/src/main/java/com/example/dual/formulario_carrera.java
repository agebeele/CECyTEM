package com.example.dual;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class formulario_carrera extends AppCompatActivity {

    TextView datos, tramite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_carrera);

        datos = (TextView) findViewById(R.id.datosGenerales);
        tramite = (TextView) findViewById(R.id.tramidateDatos);

        tramite.setText("Para realizar un cambio de carrera, deberas imprimir el siguiente documento, sin embargo, deberas llenarlo y presentarlo en Control Escolar con los siguientes datos:");

        datos.setText("- Nombre completo." +
                "\n - Grupo en el que te encuentras" +
                "\n - Carrera en la que estas" +
                "\n - Matricula" +
                "\n - Promedio del semestre anterior" +
                "\n - Razón por la cual deseas cambiarte de carrera");
    }
    public void regresarPantalla (View view){
        onBackPressed();
    }
    public void descargarPDF (View view){
        Toast.makeText(formulario_carrera.this, "PDF descargado",Toast.LENGTH_SHORT).show();
    }

}