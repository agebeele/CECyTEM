package com.example.dual;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_RecorridoGeorreferenciado extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 100;
    private LocationMonitor locationMonitor;
    private static final String[] placeNames = {"CECYTEM PLANTEL COACALCO","EXPLANADA","EDIFICIO E","EDIFICO C","EDIFICO D","EDIFICIO F","EDIFICO A","EDIFICIO B","CANCHAS TECHADAS","CANCHAS DE FUTBOL","APARATOS PARA EJERCICIO","CAFETERIA"};
    private static final double[] placeLatitudes = {19.621657519104424,19.621558987342432,19.62187469769862,19.621275927637605,19.621119287000365,19.621677634380514,19.621455306244368,19.621263295333822,19.621010649037206,19.62044977286626,19.62096011973266,19.62167433399482};
    private static final double[] placeLongitudes = {-99.10122717781451,-99.10089994832774,-99.10070938921567,-99.10077108002054,-99.10088909721249,-99.10080594873634,-99.10036070205763,-99.10044653274268,-99.10036338425675,-99.10051627016449,-99.10067452049006,-99.1003947910647};
    private static final double[] radio = {5,10,8,6,6,7,6,6,27,10,8,8};
    private TextView placeTitle, placeDescription;
    private ImageView placeImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recorrido_georreferenciado);

        placeTitle = findViewById(R.id.placeTitle);
        placeDescription = findViewById(R.id.placeDescription);
        placeImage = findViewById(R.id.placeImage);
        locationMonitor = new LocationMonitor(this);
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_CODE);
        } else {
            locationMonitor.startMonitoring();
        }
    }
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                locationMonitor.startMonitoring();
            } else {
                Toast.makeText(this, "La aplicación requiere permiso para acceder a la ubicación.", Toast.LENGTH_SHORT).show();
            }
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        locationMonitor.stopMonitoring();
    }
    public void updatePlaceInfo(int nearestPlaceIndex) {
        String title;
        String description;
        int imageResourceId;

        switch (nearestPlaceIndex) {
            case 0:
                title = placeNames[nearestPlaceIndex];
                description = "Bienvenido a nuestras instalaciones donde tenemos las siguientes carreras:\n" +
                        "\n" +
                        "Soporte y Mantenimiento en equipos de computo.\n" +
                        "Desarrollo Organizacional.\n" +
                        "Programacion.\n" +
                        "¡Nuestras instalaciones te estan esperando!.";
                imageResourceId = R.drawable.ic_launcher_foreground;
                break;
            case 1:
                title = placeNames[nearestPlaceIndex];
                description = "Estas en nuestra Explanada cerca de dos edificios donde se imparten clases: \n " +
                        "\n" +
                        "A tu mano izquierda tienes: \n" +
                        "EDIFICIO F Y EDIFICIO E.\n" +
                        "A tu mano derecha tienes: \n" +
                        "EDIFICIO C Y EDIFICIO D.\n" +
                        "Hacia el frente tienes: \n" +
                        "EDIFICIO B Y EDIFICIO A.";
                imageResourceId = R.drawable.ic_launcher_foreground;
                break;
            case 2: //EDIFI E
                title = placeNames[nearestPlaceIndex];
                description = "En este Edificio se puede encontrar lo siguiente:\n" +
                        "\n" +
                        "PLANTA BAJA.\n" +
                        "Papeleria (Antes de subir o bajar a los salones.\n" +
                        "Salones de clase del (agregar salones).\n" +
                        "PLANTA ALTA\n" +
                        "Salones de clase del (agregar salones).\n";
                imageResourceId = R.drawable.ic_launcher_foreground;
                break;
            case 3://EDIFI C
                title = placeNames[nearestPlaceIndex];
                description = "En este Edificio se puede encontrar lo siguiente:\n" +
                        "PLANTA BAJA.\n" +
                        "Laboratorio de computo\n" +
                        "PLANTA ALTA\n" +
                        "Salones de clase del (agregar salones)";
                imageResourceId = R.drawable.ic_launcher_foreground;
                break;
            case 4://EDIFI D
                title = placeNames[nearestPlaceIndex];
                description = "En este Edificio se puede encontrar lo siguiente:\n" +
                        "PLANTA BAJA.\n" +
                        "Laboratorio Multifuncional y bodegas\n" +
                        "PLANTA ALTA\n" +
                        "Salones de clase del (agregar salones)";
                imageResourceId = R.drawable.ic_launcher_foreground;
                break;
            case 5://EDIFI F
                title = placeNames[nearestPlaceIndex];
                description = "En este Edificio se puede encontar lo siguiente: \n" +
                        "\n" +
                        "PLANTA BAJA\n" +
                        "Laboratorio de ingles.\n" +
                        "Laboratorio de Mantenimiento.\n" +
                        "Orientacion Escolar.\n" +
                        "PLANTA ALTA\n" +
                        "Salones de clase del (agregar salones)";
                imageResourceId = R.drawable.ic_launcher_foreground;
                break;
            case 6://EDIFI A
                title = placeNames[nearestPlaceIndex];
                description = "En este Edifico puedes encontrar lo siguiente: \n" +
                        "\n" +
                        "PLANTA BAJA\n" +
                        "Biblioteca.\n" +
                        "Enfermeria.\n" +
                        "PLANTA ALTA" +
                        "Direccion Academica.\n" +
                        "Subdirecion Academica.\n" +
                        "Sala de maestros.\n";
                imageResourceId = R.drawable.ic_launcher_foreground;
                break;
            case 7://EDIFI B
                title = placeNames[nearestPlaceIndex];
                description = "En este edificio puedes encontrar lo siguiente: \n" +
                        "\n" +
                        "PLANTA BAJA\n" +
                        "Auditorio.\n" +
                        "PLANTA ALTA\n" +
                        "Area de Vinculacion Adademica (Atiente en ventanilla).\n" +
                        "Subdireccion Administrativa .\n" +
                        "Control Escolar (Atiente en ventanilla).\n"+
                        "Club de Lectura.\n";
                imageResourceId = R.drawable.ic_launcher_foreground;
                break;
            case 8://CANCHA TECHADA
                title = placeNames[nearestPlaceIndex];
                description = "Area deportiva para los alumnos donde pueden practicar lo siguiente:\n" +
                        "\n" +
                        "Volleyball.\n" +
                        "Basketball.\n" +
                        "Dos Canchas se encuentra techadas y las otras dos no\n";
                imageResourceId = R.drawable.ic_launcher_foreground;
                break;
            case 9://CANCHAS DE FUTBOL
                title = placeNames[nearestPlaceIndex];
                description = "Area para que los alumnos puedan jugar de manera segura:\n" +
                        "\n" +
                        "Se puede pedir el acceso al area de Subdireccion Administrativa.\n";
                imageResourceId = R.drawable.ic_launcher_foreground;
                break;
            case 10://APARATOS PARA EL EJERCICIO
                title = placeNames[nearestPlaceIndex];
                description = "Area para los alumnos y puedan ejercitarse cuenta con: \n" +
                        "\n" +
                        "Aparato para correr.\n" +
                        "Aparato para levantar tu propio peso.\n" +
                        "Aparato para hacer abdominales y otros más.\n" +
                        "Frente ahi se encuentran unos tubos para hacer barra";
                imageResourceId = R.drawable.ic_launcher_foreground;
                break;
            case 11://CAFETERIA
                title = placeNames[nearestPlaceIndex];
                description = "Area de los alumnos y maestros que ofrece:\n" +
                        "\n" +
                        "Comida hecha al momento.\n" +
                        "Botanas y dulces.\n" +
                        "Mesas y sillas fuera y dentro de la cafeteria.";
                imageResourceId = R.drawable.ic_launcher_foreground;
                break;
            default:
                title = "Colegio de Estudios Cientificos y Tecnologicos del Estado de México Plantel Coacalco";
                description = "No te encuentras cerca de ningún lugar, sigue caminando.";
                imageResourceId = R.drawable.ic_launcher_background; //
                break;
        }
        placeTitle.setText(title);
        placeDescription.setText(description);
        placeImage.setImageResource(imageResourceId);
    }
    public void onLocationUpdate(Location location) {
        double userLat = location.getLatitude();
        double userLng = location.getLongitude();
        int nearestPlaceIndex = -1;
        for (int i = 0; i < placeNames.length; i++) {
            double placeLat = placeLatitudes[i];
            double placeLng = placeLongitudes[i];
            double distance = calculateDistance(userLat, userLng, placeLat, placeLng);
            if (distance < (radio[i])) {
                nearestPlaceIndex = i;
                break;
            }
        }
        if (nearestPlaceIndex != -1) {
            updatePlaceInfo(nearestPlaceIndex);
            placeImage.setVisibility(View.VISIBLE);
        } else {
            placeTitle.setText("Colegio de Estudios Cientificos y Tecnologicos del Estado de México Plantel Coacalco");
            placeDescription.setText("No te encuentras cerca de ningún lugar, sigue caminando.");
            placeImage.setImageResource(R.drawable.ic_launcher_foreground);
            placeImage.setVisibility(View.VISIBLE);
        }
    }
    private double calculateDistance(double userLat, double userLng, double placeLat, double placeLng) {
        final double R = 6371000;
        double lat1 = Math.toRadians(userLat);
        double lon1 = Math.toRadians(userLng);
        double lat2 = Math.toRadians(placeLat);
        double lon2 = Math.toRadians(placeLng);
        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(lat1) * Math.cos(lat2) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c;
        return distance;
    }
}
