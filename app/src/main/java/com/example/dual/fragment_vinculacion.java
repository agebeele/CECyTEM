package com.example.dual;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class fragment_vinculacion extends Fragment {
    TextView datos_controlEscolar;
    Button tramite;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_vinculacion, container, false);
            //Spinner
        Spinner spinner = v.findViewById(R.id.spinner_list);
            final TextView textView = v.findViewById(R.id.texto_spinner);

            tramite = (Button) v.findViewById(R.id.boton_tramite);
            tramite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String selectedItem = (String) spinner.getSelectedItem();
                    switch (selectedItem){
                        case "Tramite de Becas":
                            Intent intent_becas = new Intent(getActivity(),formulario_social.class);
                            startActivity(intent_becas);
                            break;
                        case "Registro de Eventos":
                            Intent intent_constancia = new Intent(getActivity(),formulario_constancia.class);
                            startActivity(intent_constancia);
                            break;
                        case "Tramite_de_Servicio_Social":
                            Intent intent_historial = new Intent(getActivity(),formulario_historial.class);
                            startActivity(intent_historial);
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

            return v;
        }
    }

