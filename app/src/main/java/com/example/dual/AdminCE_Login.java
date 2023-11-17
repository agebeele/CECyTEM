package com.example.dual;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdminCE_Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_ce_login);
    }
    public void regresarLogin (View view){
        onBackPressed();
    }
    public void iniciarSesion(View view) {
        Intent iniciar = new Intent(AdminCE_Login.this, AdminCE_Inicio.class);
        startActivity(iniciar);

        Toast.makeText(AdminCE_Login.this, "Bienvenido Administrador",Toast.LENGTH_SHORT).show();
    }
}