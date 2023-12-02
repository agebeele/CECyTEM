package com.example.dual;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class agregarItem_VIN extends AppCompatActivity {

    EditText titulo_et, descripcion_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_item_vin);

        titulo_et = (EditText) findViewById(R.id.titulo_et);
        descripcion_et = (EditText) findViewById(R.id.descripcion_et);

    }
    public void agregarPublicacion (View view){
        // Obtener la fecha y hora actual
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());

        String fechaActual = dateFormat.format(calendar.getTime());
        String horaActual = timeFormat.format(calendar.getTime());

        // Obtener el título y la descripción ingresados por el usuario
        String titulo = titulo_et.getText().toString();
        String descripcion = descripcion_et.getText().toString();

        // Aquí puedes realizar la lógica para guardar la publicación en tu base de datos
        // Asegúrate de usar fechaActual y horaActual para almacenarlas por separado en tu base de datos

        Toast.makeText(agregarItem_VIN.this, "Publicacion creada",Toast.LENGTH_SHORT).show();

        // Ejemplo de impresión para verificar en la consola
        System.out.println("Título: " + titulo);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Fecha: " + fechaActual);
        System.out.println("Hora: " + horaActual);
    }
}