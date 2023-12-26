package com.example.dual.formularios;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dual.R;

public class formulario_grupo extends AppCompatActivity {
    TextView datos, tramite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_grupo);

        datos = (TextView) findViewById(R.id.datosGenerales);
        tramite = (TextView) findViewById(R.id.tramidateDatos);

        tramite.setText("Para realizar un cambio de grupo, deberas imprimir el siguiente documento, sin embargo, deberas llenarlo y presentarlo en Control Escolar con los siguientes datos:");

        datos.setText("- Nombre completo." +
                "\n - Grupo en el que te encuentras" +
                "\n - Carrera en la que estas" +
                "\n - Matricula" +
                "\n - Promedio del semestre anterior" +
                "\n - Razón por la cual deseas cambiarte de grupo");
    }
    public void regresarPantalla (View view){
        onBackPressed();
    }
}