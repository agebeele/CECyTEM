package com.example.dual;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class fragment_vinculacion extends Fragment {
    TextView datos_controlEscolar, bienvenida;
    Button tramite;
    Intent intent;
    private FloatingActionButton floatingActionButton;
    WebService obj = new WebService();

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_vinculacion, container, false);
            //Spinner
        Spinner spinner = v.findViewById(R.id.spinner_list);
            final TextView textView = v.findViewById(R.id.texto_spinner);

        floatingActionButton = v.findViewById(R.id.floatingActionButtonBot_Vin);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirChat();
            }
        });

            tramite = (Button) v.findViewById(R.id.boton_tramite);
            tramite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String selectedItem = (String) spinner.getSelectedItem();
                    switch (selectedItem){
                        case "Tramite de Becas":
                            Intent intent_becas = new Intent(getActivity(),formulario_becas.class);
                            startActivity(intent_becas);
                            break;
                        case "Registro de Eventos":
                            Intent intent_eventos = new Intent(getActivity(),formulario_eventos.class);
                            startActivity(intent_eventos);
                            break;
                        case "Tramite de Servicio Social":
                            Intent intent_ss = new Intent(getActivity(),formulario_social.class);
                            startActivity(intent_ss);
                            break;
                        default:
                            break;
                    }
                }
            });

            datos_controlEscolar = (TextView) v.findViewById(R.id.datosCE);
            datos_controlEscolar.setText("En Vinculacion es un portal para que el estudiante pueda realizar distintos tramites, por ejemplo:" +
                    "\n - Tramite de Becas" +
                    "\n - Registro de Eventos" +
                    "\n - Tramite de Servicio Social" );

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View selectedItemView, int position, long id) {
                    // Obtiene el item actual seleccionado
                    String selectedItem = (String) adapterView.getItemAtPosition(position);

                    switch (selectedItem){
                        case "Tramite de Becas":
                            textView.setText("Para reponer una credencial son necesarios los siguientes datos:" +
                                    "\n - Nombre completo" +
                                    "\n - Grupo" +
                                    "\n - Matricula" +
                                    "\n - Turno"+
                                    "\n Y ademas de otros datos que se solicitaran en el formulario.");
                            break;
                        case "Registro de Eventos":
                            textView.setText("Para solicitar una constancia son necesarios los siguientes datos:" +
                                    "\n - Nombre completo" +
                                    "\n - Grupo" +
                                    "\n - Matricula" +
                                    "\n - Carrera" +
                                    "\n Y ademas de otros datos que se solicitaran en el formulario.");
                            break;
                        case "Tramite de Servicio Social":
                            textView.setText("Para realizar tu tramite de Servicio Social son necesarios los siguientes datos:" +
                                    "\n -Nombre completo" +
                                    "\n -Promedio" +
                                    "\n -Telefono de Casa" +
                                    "\n -Telefono Celular" +
                                    "\n -Grupo" +
                                    "\n -Correo Institucional" +
                                    "\n Y ademas de otros datos que se solicitaran en el formulario.");
                            break;
                        default:
                            textView.setText("Selecciona una opcion");
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                    // Maneja la situación en la que no se ha seleccionado nada
                    textView.setText("Selecciona una opcion");
                }
            });

        bienvenida = (TextView) v.findViewById(R.id.bienvenida_txt1);

        // Recuperar la matrícula (nombre de usuario) guardada en SharedPreferences
        SharedPreferences preferences = getActivity().getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        String nombreUsuario = preferences.getString("matricula", "");

        if (!nombreUsuario.isEmpty()) {
            // Ejecutar AsyncTask para obtener los datos del usuario
            MiAsyncTask miAsyncTask = new MiAsyncTask();
            miAsyncTask.execute("datosUser", nombreUsuario);
        }

            return v;
        }

    private void abrirChat() {
        intent = new Intent(getActivity(), ChatBot_VinPrincipal.class);
        startActivity(intent);
    }

    class MiAsyncTask extends AsyncTask<String, String, String> {
        private SharedPreferences preferences;

        @Override
        protected String doInBackground(String... parameter) {
            String msj = null;
            switch (parameter[0]) {
                case "datosUser":
                    // Utilizar el nombre de usuario obtenido de SharedPreferences
                    msj = obj.datosUsuario(parameter[1]);
                    publishProgress(msj);
                    break;
                default:
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Recuperar las SharedPreferences en onPreExecute
            preferences = getActivity().getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        }

        @Override
        protected void onProgressUpdate(String... progress) {
            super.onProgressUpdate(progress);
            Log.d("JSON_DEBUG", progress[0]);

            try {
                JSONObject jsonObject = new JSONObject(progress[0]);
                boolean success = jsonObject.getBoolean("success");

                if (success) {
                    // Utilizar el nombre de usuario obtenido del JSON
                    JSONArray data = jsonObject.getJSONArray("data");
                    JSONObject usuario = data.getJSONObject(0);
                    String nombreUsuario = usuario.getString("nombre");

                    // Concatenar el mensaje de bienvenida con el nombre del usuario
                    String mensajeBienvenida = "Bienvenido " + nombreUsuario;

                    // Asignar el mensaje concatenado al TextView
                    bienvenida.setText(mensajeBienvenida);

                } else {
                    String mensaje = jsonObject.getString("message");
                    Toast.makeText(requireActivity(), mensaje, Toast.LENGTH_LONG).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
                bienvenida.setText("");
                Toast.makeText(requireActivity(), "Error al obtener los datos del usuario", Toast.LENGTH_LONG).show();
            }
        }

    }
}

