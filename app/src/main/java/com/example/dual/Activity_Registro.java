package com.example.dual;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_Registro extends AppCompatActivity {
    EditText nombre, paterno, materno, matricula, curp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nombre = (EditText) findViewById(R.id.nombre_et);
        paterno = (EditText) findViewById(R.id.paterno_et);
        materno = (EditText) findViewById(R.id.materno_et);
        matricula = (EditText) findViewById(R.id.matricula_et);
        curp = (EditText) findViewById(R.id.curp_et);
    }
    public void registrarUsuario (View view){



        Toast.makeText(Activity_Registro.this, "Usuario registrado",Toast.LENGTH_SHORT).show();
        //Borrar campos una vez enviados los datos
        nombre.setText("");
        paterno.setText("");
        materno.setText("");
        matricula.setText("");
        curp.setText("");
    }
}