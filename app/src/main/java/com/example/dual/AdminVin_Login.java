package com.example.dual;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdminVin_Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_vin_login);
    }
    public void regresarLogin (View view){
        onBackPressed();
    }
    public void ingresarVIN (View view){
        Intent iniciar = new Intent(AdminVin_Login.this, AdminVIN_Inicio.class);
        startActivity(iniciar);
        Toast.makeText(AdminVin_Login.this, "Bienvenido adminitrador",Toast.LENGTH_SHORT).show();
    }
}