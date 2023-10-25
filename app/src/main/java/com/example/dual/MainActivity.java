package com.example.dual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);

        // Establece el progreso inicial (opcional)
        progressBar.setProgress(0);

        // Configura un Handler para retrasar la navegación
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Después de 5 segundos (5000 milisegundos), navega a la siguiente actividad
                Intent intent = new Intent(MainActivity.this, Activity_Login.class);
                startActivity(intent);
                finish(); // Opcional, para cerrar esta actividad después de la navegación
            }
        }, 5000); // 5000 milisegundos (5 segundos)
    }
}


