package com.example.dual;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_Login extends AppCompatActivity {

    TextView sitioOfical;
    EditText usuario, contra;
    Button mostrarAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuario = (EditText) findViewById(R.id.txt_matricula);
        String dato_usuario = usuario.getText().toString();
        if (dato_usuario.isEmpty()) {
            // Mostrar un mensaje de error o realizar alguna acción
            usuario.setError("El usuario no puede estar vacío");
        } else {
            // El nombre es válido, realiza otras acciones si es necesario
        }

        contra = (EditText) findViewById(R.id.txt_contra);
        String dato_contra = contra.getText().toString();
        if (dato_contra.isEmpty()) {
            // Mostrar un mensaje de error o realizar alguna acción
            contra.setError("La contraseña no puede estar vacía");
        } else {
            // El nombre es válido, realiza otras acciones si es necesario
        }

        sitioOfical = (TextView) findViewById(R.id.paginaOficial);

        sitioOfical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //URL
                try {
                    // URL de la página que quieres abrir
                    String url = "https://cecytem.mx/deo/gui/LogIn.jsp";

                    // Verifica si la URL es válida
                    if (!url.startsWith("http://") && !url.startsWith("https://")) {
                        url = "http://" + url;
                    }

                    // Crea un Intent con la acción ACTION_VIEW y la URL como datos de URI
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

                    // Verifica si hay una aplicación para manejar la acción VIEW
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        // Inicia la actividad si hay una aplicación disponible
                        startActivity(intent);
                    } else {
                        // Puedes manejar el caso en el que no haya aplicaciones disponibles para abrir la página
                        Toast.makeText(Activity_Login.this, "No hay aplicaciones disponibles para abrir la página", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(Activity_Login.this, "Error al abrir la página", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mostrarAdmin = (Button) findViewById(R.id.adminBoton);
        mostrarAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAdminSelectionDialog();
            }
        });
    }

    private void showAdminSelectionDialog() {
        final CharSequence[] adminOptions = {"Administrador Control Escolar", "Administrador Vinculacion"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Selecciona el tipo de administrador");
        builder.setItems(adminOptions, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // El usuario ha seleccionado un tipo de administrador
                String selectedAdmin = adminOptions[which].toString();

                // Puedes realizar acciones dependiendo de la selección
                if (selectedAdmin.equals("Administrador Control Escolar")) {
                    // Iniciar sesión para Admin A
                    Toast.makeText(Activity_Login.this, "Iniciar sesión como Administrador Control Escolar", Toast.LENGTH_SHORT).show();
                    // Aquí puedes abrir la actividad de inicio de sesión para Admin A
                    Intent adminCE = new Intent(Activity_Login.this, AdminCE_Login.class);
                    startActivity(adminCE);
                } else if (selectedAdmin.equals("Administrador Vinculacion")) {
                    // Iniciar sesión para Admin B
                    Toast.makeText(Activity_Login.this, "Iniciar sesión como Administrador Vinculacion", Toast.LENGTH_SHORT).show();
                    // Aquí puedes abrir la actividad de inicio de sesión para Admin B
                    Intent adminVIN = new Intent(Activity_Login.this, AdminVin_Login.class);
                    startActivity(adminVIN);
                }
            }
        });

        builder.show();
    }

    public void iniciarSesion(View view) {
        Intent iniciar = new Intent(Activity_Login.this, Activity_Inicio.class);
        startActivity(iniciar);

        Toast.makeText(Activity_Login.this, "Bienvenido/a",Toast.LENGTH_SHORT).show();
    }
    public void registrarUsuario(View view) {
        Intent registrar = new Intent(Activity_Login.this, Activity_Registro.class);
        startActivity(registrar);
    }
    public void aspiranteCambio(View view) {
        Intent iniciar = new Intent(Activity_Login.this, Activity_Aspirantes.class);
        startActivity(iniciar);
        Toast.makeText(Activity_Login.this, "Bienvenido/a aspirante",Toast.LENGTH_SHORT).show();
    }
    public void egresadoCambio(View view) {
        Intent iniciar = new Intent(Activity_Login.this, Activity_Egresado  .class);
        startActivity(iniciar);
    }
}