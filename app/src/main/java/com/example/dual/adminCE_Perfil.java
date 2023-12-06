package com.example.dual;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class adminCE_Perfil extends AppCompatActivity {

    TextView nombreGeneral, matriculaGeneral;
    TextView nombre, apellido_paterno, apellido_materno;
    WebService obj = new WebService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_ce_perfil);

        nombreGeneral = findViewById(R.id.nombreUsuario);
        matriculaGeneral = findViewById(R.id.matriculaUsuario);
        nombre = findViewById(R.id.infoNombre);
        apellido_paterno = findViewById(R.id.infoPaterno);
        apellido_materno = findViewById(R.id.infoMaterno);

        // Recuperar la matrícula guardada en SharedPreferences
        SharedPreferences preferences = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        String matricula = preferences.getString("matricula", "");

        if (!matricula.isEmpty()) {
            MiAsyncTask datosAdminTask = new MiAsyncTask();
            datosAdminTask.setTaskType("datosAdmin");
            datosAdminTask.execute(matricula);
        }
    }
    class MiAsyncTask extends AsyncTask<String, String, String> {
        private String taskType; // Variable para almacenar el tipo de tarea

        // Setter para asignar el tipo de tarea
        public void setTaskType(String taskType) {
            this.taskType = taskType;
        }

        @Override
        protected String doInBackground(String... parameter) {
            String msj = null;
            switch (taskType) {
                case "datosAdmin":
                    msj = obj.datosAdmin_CE(parameter[0]);
                    break;
                default:
            }
            return msj;
        }
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            if (result != null) {
                // Aquí maneja los resultados según corresponda
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    boolean success = jsonObject.getBoolean("success");

                    if (success) {
                        JSONArray admin = jsonObject.getJSONArray("data");

                        if ("datosAdmin".equals(taskType)) {
                            // Maneja los datos del usuario
                            JSONObject adminData = admin.getJSONObject(0); // Obtén el primer objeto del JSONArray
                            matriculaGeneral.setText(adminData.getString("matricula"));
                            nombreGeneral.setText(adminData.getString("nombre"));
                            nombre.setText(adminData.getString("nombre"));
                            apellido_paterno.setText(adminData.getString("apellido_paterno"));
                            apellido_materno.setText(adminData.getString("apellido_materno"));
                        }
                    } else {
                        // Maneja el caso de error o usuario no encontrado
                        String mensaje = jsonObject.getString("message");

                        matriculaGeneral.setText("");
                        nombreGeneral.setText("");
                        nombre.setText("");
                        apellido_paterno.setText("");
                        apellido_materno.setText("");

                        // Mostrar mensaje de error en tu activity
                        Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    // Maneja errores de parsing JSON
                }
            }
        }
    }
}