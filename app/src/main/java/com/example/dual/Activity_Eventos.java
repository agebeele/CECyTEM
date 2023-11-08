package com.example.dual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;

public class Activity_Eventos extends AppCompatActivity {

    private DatePicker datePicker;
    private EditText eventTitle;
    private EditText eventDescription;
    private TextView eventTextView;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);

        datePicker = findViewById(R.id.datePicker);
        eventTitle = findViewById(R.id.eventTitle);
        eventDescription = findViewById(R.id.eventDescription);
        eventTextView = findViewById(R.id.eventTextView);

        sharedPreferences = getPreferences(MODE_PRIVATE);

        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarEvento();
            }
        });
        Button borrarEvento = findViewById(R.id.borrarEvento);
        borrarEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                borrarEvento();
            }
        });

        datePicker.setOnDateChangedListener((view, year, monthOfYear, dayOfMonth) -> {
            String selectedDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
            mostrarEventos(selectedDate);
            cambiarColorDiaConEvento(selectedDate);
        });

        eventTitle.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    // Mover el foco al siguiente EditText
                    eventDescription.requestFocus();
                    return true;
                }
                return false;
            }
        });
    }

    private void guardarEvento() {
        String title = eventTitle.getText().toString();
        String description = eventDescription.getText().toString();
        String date = getDateFromDatePicker(datePicker);

        // Verificar si los campos de texto no están vacíos
        if (title.isEmpty() || description.isEmpty()) {
            Toast.makeText(this, "Completa todos los campos antes de guardar el evento", Toast.LENGTH_SHORT).show();
            return;
        }

        // Almacenar el evento en SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(date, "Evento: " + title + "\n Descripción: " + description);
        editor.apply();

        Toast.makeText(this, "Evento guardado", Toast.LENGTH_SHORT).show();

        eventTitle.setText("");
        eventDescription.setText("");

        // Actualizar el color del día en el DatePicker
        cambiarColorDiaConEvento(date);
    }
    public void borrarEvento() {
        String date = getDateFromDatePicker(datePicker);

        // Verificar si existe un evento en la fecha seleccionada
        if (sharedPreferences.contains(date)) {
            // Eliminar el evento existente
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.remove(date);
            editor.apply();
            Toast.makeText(this, "Evento eliminado", Toast.LENGTH_SHORT).show();

            // Limpiar la vista de eventos
            eventTextView.setText("No hay ningún evento para hoy");

            // Actualizar el color del día en el DatePicker
            cambiarColorDiaConEvento(date);
        } else {
            Toast.makeText(this, "No hay evento para borrar en esta fecha", Toast.LENGTH_SHORT).show();
        }
    }

    private void mostrarEventos(String selectedDate) {
        // Obtener el evento desde SharedPreferences
        String evento = sharedPreferences.getString(selectedDate, "");

        if (!evento.isEmpty()) {
            eventTextView.setText(evento);
        } else {
            eventTextView.setText("No hay ningún evento para hoy");
        }
    }

    private String getDateFromDatePicker(DatePicker datePicker) {
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth() + 1;
        int year = datePicker.getYear();
        return day + "/" + month + "/" + year;
    }

    private void cambiarColorDiaConEvento(String selectedDate) {
        // Cambiar el color del texto del día en el DatePicker si hay un evento
        if (hayEvento(selectedDate)) {
            int colorEvento = Color.RED; // Cambia esto según tus preferencias de color

            try {
                Field ll = datePicker.getClass().getDeclaredField("mDaySpinner");
                ll.setAccessible(true);
                Object llObj = ll.get(datePicker);

                if (llObj instanceof LinearLayout) {
                    LinearLayout llInstance = (LinearLayout) llObj;

                    for (int i = 0; i < llInstance.getChildCount(); i++) {
                        if (llInstance.getChildAt(i) instanceof NumberPicker) {
                            NumberPicker dayPicker = (NumberPicker) llInstance.getChildAt(i);
                            for (int j = 0; j < dayPicker.getChildCount(); j++) {
                                if (dayPicker.getChildAt(j) instanceof EditText) {
                                    EditText dayEditText = (EditText) dayPicker.getChildAt(j);
                                    dayEditText.setTextColor(colorEvento);
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private boolean hayEvento(String selectedDate) {
        // Implementa la lógica para determinar si hay un evento en la fecha seleccionada
        // Por ejemplo, verifica si existe un evento en tu fuente de datos
        return sharedPreferences.contains(selectedDate);
    }
}