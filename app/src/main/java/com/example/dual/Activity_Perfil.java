package com.example.dual;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Activity_Perfil extends AppCompatActivity {
    TextView nombreGeneral, matriculaGeneral;
    TextView nombre, apellido_paterno, apellido_materno;
    WebService obj = new WebService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        nombreGeneral = findViewById(R.id.nombreUsuario);
        matriculaGeneral = findViewById(R.id.matriculaUsuario);
        nombre = findViewById(R.id.infoNombre);
        apellido_paterno = findViewById(R.id.infoPaterno);
        apellido_materno = findViewById(R.id.infoMaterno);

        // Recuperar la matrícula guardada en SharedPreferences
        SharedPreferences preferences = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        String matricula = preferences.getString("matricula", "");

        if (!matricula.isEmpty()) {
            // Ejecutar AsyncTask para obtener los datos del usuario
            MiAsyncTask miAsyncTask = new MiAsyncTask();
            miAsyncTask.execute("datosUser", matricula);
        }
    }

    class MiAsyncTask extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... parameter) {
            String msj = null;
            switch (parameter[0]) {
                case "datosUser":
                    msj = obj.datosUsuario(parameter[1]);
                    publishProgress(msj);
                    break;
                default:
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... progress) {
            super.onProgressUpdate(progress);
            Log.d("JSON_DEBUG", progress[0]);  // Agrega esta línea para imprimir el JSON en la consola
            try {
                JSONObject jsonObject = new JSONObject(progress[0]);
                boolean success = jsonObject.getBoolean("success");

                if (success) {
                    JSONArray data = jsonObject.getJSONArray("data");
                    JSONObject usuario = data.getJSONObject(0);

                    // Asignar los datos del usuario a los TextViews
                    matriculaGeneral.setText(usuario.getString("matricula"));
                    nombreGeneral.setText(usuario.getString("nombre"));
                    nombre.setText(usuario.getString("nombre"));
                    apellido_paterno.setText(usuario.getString("apellido_paterno"));
                    apellido_materno.setText(usuario.getString("apellido_materno"));

                } else {
                    // Manejar el caso de error o usuario no encontrado
                    String mensaje = jsonObject.getString("message");
                    // Mostrar mensaje de error en tu activity
                    Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
                matriculaGeneral.setText("");
                nombreGeneral.setText("");
                nombre.setText("");
                apellido_paterno.setText("");
                apellido_materno.setText("");
                Toast.makeText(getApplicationContext(), "Error al obtener los datos del usuario", Toast.LENGTH_LONG).show();
            }
        }
    }
}