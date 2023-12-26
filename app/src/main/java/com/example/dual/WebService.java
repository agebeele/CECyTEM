package com.example.dual;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class WebService {
    public String login(String matricula, String curp) {
        String aux = "";
        try {
            URL url = new URL("http://192.168.100.16:80/conexion_cecytem/login_usuarios.php");

            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("POST");
            conexion.setDoOutput(true);
            OutputStreamWriter data1 = new OutputStreamWriter(conexion.getOutputStream());

            String data = "matricula=" + URLEncoder.encode(matricula, "UTF-8")
                    +  "&curp=" + URLEncoder.encode(curp, "UTF-8");

            data1.write(data);
            data1.flush();
            data1.close();

            if (conexion.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
                String linea = reader.readLine();
                while (linea != null) {
                    aux = aux + linea; // Concatenar datos línea por línea
                    linea = reader.readLine(); // Leer siguiente línea
                }
                reader.close(); // Cerrar buffer de lectura
                if (aux.equals("2002")) {
                    aux = "ERROR DE CONEXION AL SERVIDOR DE DATOS";
                } else if (aux.equals("001")) {
                    aux = "Correo sin validar";
                } else if (aux.equals("000")) {
                    aux = "No se pudo mostrar la contraseña";
                } else if (aux.equals("010")) {
                    aux = "El Usuario o Contraseña no existe";
                }
            } else {
                aux = "ERROR al procesar servicio: " + conexion.getResponseCode();
            }
            conexion.disconnect();
        } catch (Exception ex) {
            aux = "ERROR de SERVIDOR: " + ex.getMessage();
        }
        return aux;
    }
    public String registarUsuario (String matricula, String curp, String nombre, String paterno, String materno) {
        String response = "";
        try {
            URL url = new URL("http://192.168.100.16:80/conexion_cecytem/registro_usuarios.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            // Construye los datos a enviar en el cuerpo de la solicitud
            String data = "matricula=" + URLEncoder.encode(matricula, "UTF-8")
                    + "&curp=" + URLEncoder.encode(curp, "UTF-8")
                    + "&nombre=" + URLEncoder.encode(nombre, "UTF-8")
                    + "&apellido_paterno=" + URLEncoder.encode(paterno, "UTF-8")
                    + "&apellido_materno=" + URLEncoder.encode(materno, "UTF-8");

            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(data);
            writer.flush();
            writer.close();

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    response += line;
                }
                if (response.equals("002")) {
                    response = "Usuario creado";
                } else if (response.equals("000")) {
                    response = "No se pudo crear el registro";
                } else {
                    response += line;
                }
                reader.close();
            } else {
                response = "ERROR al procesar el servicio: " + connection.getResponseCode();
            }
            connection.disconnect();
        } catch (Exception ex) {
            response = "ERROR de SERVIDOR: " + ex.getMessage();
        }
        return response;
    }
    public String datosUsuario(String matricula) {
        String aux = "";
        try {
            URL url = new URL("http://192.168.100.16:80/conexion_cecytem/mostrar_datos.php");
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("POST");
            conexion.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(conexion.getOutputStream());
            String data = "matricula=" + URLEncoder.encode(matricula, "UTF-8"); // Pasar el correo electrónico del usuario
            writer.write(data);
            writer.flush();
            writer.close();
            if (conexion.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
                String linea = reader.readLine();
                if (!linea.equals("010")) { // Verificar si no es un error de "No se encontraron resultados"
                    aux = linea; // Recuperar el JSON con los datos del usuario
                } else {
                    aux = "No se encontraron resultados"; // Manejar el caso de usuario no encontrado
                }
                reader.close(); // Cerrar buffer de lectura
            } else {
                aux = "ERROR al procesar servicio: " + conexion.getResponseCode();
            }
            conexion.disconnect();
        } catch (Exception ex) {
            aux = "ERROR de SERVIDOR: " + ex.getMessage();
        }
        return aux;
    }
    public String muroPublicaciones() {
        String aux = "";
        try {
            URL url = new URL("http://192.168.100.16:80/conexion_cecytem/publicaciones_buscar.php");
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("POST");
            conexion.setDoOutput(true);
            OutputStreamWriter datSal = new OutputStreamWriter(conexion.getOutputStream());
            String data = "id=" + URLEncoder.encode("1", "UTF-8");;
            datSal.write(data);
            datSal.flush();
            datSal.close();
            if (conexion.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
                String linea = reader.readLine();
                while (linea != null) {
                    aux = aux + linea; // Concatenar datos línea por línea
                    linea = reader.readLine(); // Leer siguiente línea
                }
                reader.close(); // Cerrar buffer de lectura
                if (aux.equals("2002")) {
                    aux = "ERROR DE CONEXION AL SERVIDOR DE DATOS";
                } else if (aux.equals("001")) {
                    aux = "Sin ID para validar";
                } else if (aux.equals("000")) {
                    aux = "No se pudo mostrar la ID";
                } else if (aux.equals("010")) {
                    aux = "No se encontraron resultados";
                }
            } else {
                aux = "ERROR al procesar servicio: " + conexion.getResponseCode();
            }
            conexion.disconnect();
        } catch (Exception ex) {
            aux = "ERROR de SERVIDOR: " + ex.getMessage();
        }
        return aux;
    }
    public String login_admin(String matricula, String curp) {
        String aux = "";
        try {
            URL url = new URL("http://192.168.100.16:80/conexion_cecytem/login_admin.php");

            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("POST");
            conexion.setDoOutput(true);
            OutputStreamWriter data1 = new OutputStreamWriter(conexion.getOutputStream());

            String data = "matricula=" + URLEncoder.encode(matricula, "UTF-8")
                    +  "&curp=" + URLEncoder.encode(curp, "UTF-8");

            data1.write(data);
            data1.flush();
            data1.close();

            if (conexion.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
                String linea = reader.readLine();
                while (linea != null) {
                    aux = aux + linea; // Concatenar datos línea por línea
                    linea = reader.readLine(); // Leer siguiente línea
                }
                reader.close(); // Cerrar buffer de lectura
                if (aux.equals("2002")) {
                    aux = "ERROR DE CONEXION AL SERVIDOR DE DATOS";
                } else if (aux.equals("001")) {
                    aux = "Correo sin validar";
                } else if (aux.equals("000")) {
                    aux = "No se pudo mostrar la contraseña";
                } else if (aux.equals("010")) {
                    aux = "El Usuario o Contraseña no existe";
                }
            } else {
                aux = "ERROR al procesar servicio: " + conexion.getResponseCode();
            }
            conexion.disconnect();
        } catch (Exception ex) {
            aux = "ERROR de SERVIDOR: " + ex.getMessage();
        }
        return aux;
    }
    public String agregarEvento(String titulo, String descripcion, String fecha) {
        String aux = "";
        try {
            URL url = new URL("http://192.168.100.16:80/conexion_cecytem/eventos.php");
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("POST");
            conexion.setDoOutput(true);

            OutputStreamWriter datSal = new OutputStreamWriter(conexion.getOutputStream());
            String data = "titulo=" + URLEncoder.encode(titulo, "UTF-8") +
                    "&descripcion=" + URLEncoder.encode(descripcion, "UTF-8") +
                    "&fecha=" + URLEncoder.encode(fecha, "UTF-8");
            datSal.write(data);
            datSal.flush();
            datSal.close();

            if (conexion.getResponseCode() == HttpURLConnection.HTTP_OK) {
                // Manejar la respuesta del servidor si es necesario
            } else {
                aux = "ERROR al procesar servicio: " + conexion.getResponseCode();
            }

            conexion.disconnect();
        } catch (Exception ex) {
            aux = "ERROR de SERVIDOR: " + ex.getMessage();
        }
        return aux;
    }
    public String obtenerEventos(String fecha) {
        String aux = "";
        try {
                URL url = new URL("http://192.168.100.16:80/conexion_cecytem/mostrar_eventos.php");
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("POST");
            conexion.setDoOutput(true);

            OutputStreamWriter datSal = new OutputStreamWriter(conexion.getOutputStream());
            String data = "fecha=" + URLEncoder.encode(fecha, "UTF-8");
            datSal.write(data);
            datSal.flush();
            datSal.close();

            if (conexion.getResponseCode() == HttpURLConnection.HTTP_OK) {
                // Leer la respuesta del servidor
                BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                in.close();
                aux = response.toString();
            } else {
                aux = "ERROR al procesar servicio: " + conexion.getResponseCode();
            }

            conexion.disconnect();
        } catch (Exception ex) {
            aux = "ERROR de SERVIDOR: " + ex.getMessage();
        }
        return aux;
    }
    public String datosDomicilio(String matricula) {
        String aux = "";
        try {
            URL url = new URL("http://192.168.100.16:80/conexion_cecytem/mostrar_domicilio.php");
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("POST");
            conexion.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(conexion.getOutputStream());
            String data = "matricula=" + URLEncoder.encode(matricula, "UTF-8"); // Pasar el correo electrónico del usuario
            writer.write(data);
            writer.flush();
            writer.close();
            if (conexion.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
                String linea = reader.readLine();
                if (!linea.equals("010")) { // Verificar si no es un error de "No se encontraron resultados"
                    aux = linea; // Recuperar el JSON con los datos del usuario
                } else {
                    aux = "No se encontraron resultados"; // Manejar el caso de usuario no encontrado
                }
                reader.close(); // Cerrar buffer de lectura
            } else {
                aux = "ERROR al procesar servicio: " + conexion.getResponseCode();
            }
            conexion.disconnect();
        } catch (Exception ex) {
            aux = "ERROR de SERVIDOR: " + ex.getMessage();
        }
        return aux;
    }
    public String datosAdmin_CE(String matricula) {
        String aux = "";
        try {
            URL url = new URL("http://192.168.100.16:80/conexion_cecytem/datosadmin_CE.php");
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("POST");
            conexion.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(conexion.getOutputStream());
            String data = "matricula=" + URLEncoder.encode(matricula, "UTF-8"); // Pasar el correo electrónico del usuario
            writer.write(data);
            writer.flush();
            writer.close();
            if (conexion.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
                String linea = reader.readLine();
                if (!linea.equals("010")) { // Verificar si no es un error de "No se encontraron resultados"
                    aux = linea; // Recuperar el JSON con los datos del usuario
                } else {
                    aux = "No se encontraron resultados"; // Manejar el caso de usuario no encontrado
                }
                reader.close(); // Cerrar buffer de lectura
            } else {
                aux = "ERROR al procesar servicio: " + conexion.getResponseCode();
            }
            conexion.disconnect();
        } catch (Exception ex) {
            aux = "ERROR de SERVIDOR: " + ex.getMessage();
        }
        return aux;
    }
    public String solicitudesCredencial() {
        String aux = "";
        try {
            URL url = new URL("http://192.168.100.16:80/conexion_cecytem/solicitudes_credencial.php");
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("POST");
            conexion.setDoOutput(true);

            // No enviamos la matrícula en este caso

            if (conexion.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
                String linea = reader.readLine();
                while (linea != null) {
                    aux = aux + linea; // Concatenar datos línea por línea
                    linea = reader.readLine(); // Leer siguiente línea
                }
                reader.close(); // Cerrar buffer de lectura
                // Resto del código para manejar la respuesta del servidor...
            } else {
                aux = "ERROR al procesar servicio: " + conexion.getResponseCode();
            }
            conexion.disconnect();
        } catch (Exception ex) {
            aux = "ERROR de SERVIDOR: " + ex.getMessage();
        }
        return aux;
    }
    public String crearPublicacion (String titulo, String descripcion, String fecha, String hora) {
        String response = "";
        try {
            URL url = new URL("http://192.168.100.16:80/conexion_cecytem/crearPublicacion.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            // Construye los datos a enviar en el cuerpo de la solicitud
            String data = "titulo=" + URLEncoder.encode(titulo, "UTF-8")
                    + "&descripcion=" + URLEncoder.encode(descripcion, "UTF-8")
                    + "&fecha=" + URLEncoder.encode(fecha, "UTF-8")
                    + "&hora=" + URLEncoder.encode(hora, "UTF-8");

            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(data);
            writer.flush();
            writer.close();

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    response += line;
                }
                if (response.equals("002")) {
                    response = "Publicacion creado";
                } else if (response.equals("000")) {
                    response = "No se pudo crear la publicacion";
                } else {
                    response += line;
                }
                reader.close();
            } else {
                response = "ERROR al procesar el servicio: " + connection.getResponseCode();
            }
            connection.disconnect();
        } catch (Exception ex) {
            response = "ERROR de SERVIDOR: " + ex.getMessage();
        }
        return response;
    }
}
