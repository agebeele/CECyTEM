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

public class fragment_control_escolar extends Fragment {

    TextView datos_controlEscolar;
    Button tramite;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_control_escolar, container, false);

        //Spinner
        Spinner spinner = v.findViewById(R.id.spinner_list);
        final TextView textView = v.findViewById(R.id.texto_spinner);

        tramite = (Button) v.findViewById(R.id.boton_tramite);
        tramite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedItem = (String) spinner.getSelectedItem();
                switch (selectedItem){
                    case "Credencial":
                        Intent intent_credencial = new Intent(getActivity(),formulario_credencial.class);
                        startActivity(intent_credencial);
                        break;
                    case "Constancia":
                        Intent intent_constancia = new Intent(getActivity(),formulario_constancia.class);
                        startActivity(intent_constancia);
                        break;
                    case "Historial Academico":
                        Intent intent_historial = new Intent(getActivity(),formulario_historial.class);
                        startActivity(intent_historial);
                        break;
                    case "Cambio de turno":
                        Intent intent_turno = new Intent(getActivity(),formulario_turno.class);
                        startActivity(intent_turno);
                        break;
                    case "Cambio de carrera":
                        Intent intent_carrera = new Intent(getActivity(),formulario_carrera.class);
                        startActivity(intent_carrera);
                        break;
                    case "Cambio de grupo":
                        Intent intent_grupo = new Intent(getActivity(),formulario_grupo.class);
                        startActivity(intent_grupo);
                        break;
                    case  "Cambio de plantel":
                        Intent intent_platenl = new Intent(getActivity(),formulario_plantel.class);
                        startActivity(intent_platenl);
                        break;
                    default:
                        break;
                }
            }
        });

        datos_controlEscolar = (TextView) v.findViewById(R.id.datosCE);
        datos_controlEscolar.setText("En Control escolar es un portal para que el estudiante pueda realizar distintos tramites, por ejemplo:" +
                "\n - Tramite o reposicion de una credencial." +
                "\n - Tramite de una Constancia de estudios." +
                "\n - Solititudes para cambio de turno, grupo, carrera o platel, es a fin de semestre." +
                "\n - Revalidacion de materias." +
                "\n - Informacion para la titulacion y/o cedula profesional");

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View selectedItemView, int position, long id) {
                // Obtiene el item actual seleccionado
                String selectedItem = (String) adapterView.getItemAtPosition(position);

                switch (selectedItem){
                    case "Credencial":
                        textView.setText("Para reponer una credencial son necesarios los siguientes datos:" +
                                "\n - Nombre completo" +
                                "\n - Grupo" +
                                "\n - Matricula" +
                                "\n - Turno");
                        break;
                    case "Constancia":
                        textView.setText("Para solicitar una constancia son necesarios los siguientes datos:" +
                                "\n - Nombre completo" +
                                "\n - Grupo" +
                                "\n - Matricula" +
                                "\n - Carrera" +
                                "\n Estas tambien se pueden solicitar con:" +
                                "\n - Fotografia" +
                                "\n - Firma" +
                                "\n - Historial academico");
                        break;
                    case "Historial Academico":
                        textView.setText("Para solicitar un Historial Academico, puede ser desde el DEO, sin embargo, para pedir este documento son necesarios los siguiuentes datos" +
                                "\n -Nombre completo" +
                                "\n -Grupo" +
                                "\n -Matricula" +
                                "\n -Turno");
                        break;
                    case "Cambio de turno":
                        textView.setText("Para solicitar un cambio de turno, deberas llenar el siguiente formato, el cual cuenta con los siguientes apartados:" +
                                "\n -Nombre completo" +
                                "\n -Grupo" +
                                "\n -Matricula" +
                                "\n -Carrera" +
                                "\n -Motivo por el cual quieres hacer tu cambio" +
                                "\n -Promedio" +
                                "\n -Nombre o firma del alumno/a" +
                                "\n  Historial academico");
                        break;
                    case "Cambio de carrera":
                        textView.setText("Para solicitar un cambio de carrera es necesario acreditar todas tus materias y mantener un promedio de 8.5, sin embargo, debes de llenar el siguiente formato el cual lleva:" +
                                "\n -Nombre completo" +
                                "\n -Grupo" +
                                "\n -Especialidad que cursa" +
                                "\n -Especialidad a la cual se quiere cambiar" +
                                "\n -Turno" +
                                "\n -Motivo por el cual quieres hacer tu cambio" +
                                "\n -Promedio" +
                                "\n -Nombre o firma del alumno/a");
                        break;
                    case "Cambio de grupo":
                        textView.setText("Para solicitar un cambio de grupo es necesario acreditar todas tus materias y mantener un promedio de 8.5 para asegurar tu cambio, sin embargo, debes de llenar el siguiente formato el cual lleva:" +
                                "\n -Nombre completo" +
                                "\n -Grupo" +
                                "\n -Carrera" +
                                "\n -Turno" +
                                "\n -Promedio" +
                                "\n -Motivo por el cual quieres hacer tu cambio" +
                                "\n -Nombre o firma del alumno/a");
                        break;
                    case "Cambio de plantel":
                        textView.setText("Para solicitar un cambio de plantel es necesario acreditar todas tus materias y mantener un promedio de 8.5 para asegurar tu cambio, sin embargo, debes de llenar el siguiente formato el cual lleva:" +
                                "\n -Nombre completo" +
                                "\n -Grupo" +
                                "\n -Carrera" +
                                "\n -Plantel y cespecialidad a el cual te cambiaras" +
                                "\n -Turno" +
                                "\n -Promedio" +
                                "\n -Motivo por el cual quieres hacer tu cambio" +
                                "\n -Nombre o firma del alumno/a");
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