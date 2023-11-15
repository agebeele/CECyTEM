package com.example.dual;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class formulario_turno extends AppCompatActivity {

    TextView datos, tramite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_turno);

        datos = (TextView) findViewById(R.id.datosGenerales);
        tramite = (TextView) findViewById(R.id.tramidateDatos);

        tramite.setText("Para realizar un cambio de turno, deberas imprimir el siguiente documento, sin embargo, deberas llenarlo y presentarlo en Control Escolar con los siguientes datos:");

        datos.setText("- Nombre completo." +
                "\n - Grupo en el que te encuentras" +
                "\n - Carrera en la que estas" +
                "\n - Matricula" +
                "\n - Promedio del semestre anterior" +
                "\n - Turno al cual te quieres cambiar" +
                "\n - Razón por la cual deseas cambiarte de carrera");
    }
}