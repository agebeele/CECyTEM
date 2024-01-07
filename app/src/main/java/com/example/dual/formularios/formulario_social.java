package com.example.dual.formularios;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dual.R;
import com.example.dual.WebService;

public class formulario_social extends AppCompatActivity {
    String crud;
    static WebService obj = new WebService();
    TextView nombreAlumno, promedio , telefonoCasa,telefonoCelular, grupo, correo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_social);
        nombreAlumno = (EditText) findViewById(R.id.txtNombre);
        promedio = (EditText) findViewById(R.id.txtpromedio);
        telefonoCasa = (EditText) findViewById(R.id.txtTelefonoCasa);
        telefonoCelular = (EditText) findViewById(R.id.txtTelefonoCelular);
        grupo = (EditText) findViewById(R.id.txtgrupo);
        correo = (EditText) findViewById(R.id.txtCorreo);
    }
    public void enviarDatosCredencial(View view) {

        nombreAlumno.setText("");
        promedio.setText("");
        telefonoCasa.setText("");
        telefonoCelular.setText("");
        grupo.setText("");
        correo.setText("");

        Toast.makeText(formulario_social.this, "Solicitud enviada",Toast.LENGTH_SHORT).show();
    }
    public void regresarPantalla (View view){
        onBackPressed();
    }
}