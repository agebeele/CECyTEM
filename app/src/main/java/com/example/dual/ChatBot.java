package com.example.dual;

import java.util.HashMap;
import java.util.Map;

public class ChatBot {
        private Map<String, String> keywordResponses;

        public ChatBot() {
            // Inicializar el mapa de respuestas basadas en palabras clave
            keywordResponses = new HashMap<>();
            keywordResponses.put("hola", "¡Hola! ¿En qué puedo ayudarte?");
            keywordResponses.put("no me se mi matrícula", "Puedes consultar tu matricula en el departamento de Control Escolar o " +
                    "en el portal DEO, este es el enlace:");
            keywordResponses.put("credencial", "Para reponer una credencial son necesarios los siguientes datos:" +
                    "\n - Nombre completo." +
                    "\n - Grupo." +
                    "\n - Matricula." +
                    "\n - Turno.");
            keywordResponses.put("constancia", "Para solicitar una constancia son necesarios los siguientes datos:" +
                    "\n - Nombre completo." +
                    "\n - Grupo." +
                    "\n - Matricula." +
                    "\n - Carrera." +
                    "\n Estas tambien se pueden solicitar con:" +
                    "\n - Fotografia." +
                    "\n - Firma." +
                    "\n - Historial academico.");
            // Agrega más palabras clave y respuestas según sea necesario
            keywordResponses.put("historial","Para solicitar un Historial Academico, puede ser desde el DEO, sin embargo, para pedir este documento son necesarios los siguiuentes datos" +
                    "\n -Nombre completo" +
                    "\n -Grupo" +
                    "\n -Matricula" +
                    "\n -Turno");
            keywordResponses.put("cambio de turno","Para solicitar un cambio de turno, deberas llenar el siguiente formato, el cual cuenta con los siguientes apartados:" +
                    "\n -Nombre completo" +
                    "\n -Grupo" +
                    "\n -Matricula" +
                    "\n -Carrera" +
                    "\n -Motivo por el cual quieres hacer tu cambio" +
                    "\n -Promedio" +
                    "\n -Nombre o firma del alumno/a" +
                    "\n  Historial academico");
            keywordResponses.put("cambio de carrera", "Para solicitar un cambio de carrera es necesario acreditar todas tus materias y mantener un promedio de 8.5, sin embargo, debes de llenar el siguiente formato el cual lleva:" +
                    "\n -Nombre completo" +
                    "\n -Grupo" +
                    "\n -Especialidad que cursa" +
                    "\n -Especialidad a la cual se quiere cambiar" +
                    "\n -Turno" +
                    "\n -Motivo por el cual quieres hacer tu cambio" +
                    "\n -Promedio" +
                    "\n -Nombre o firma del alumno/a");
            keywordResponses.put("cambio de grupo","Para solicitar un cambio de grupo es necesario acreditar todas tus materias y mantener un promedio de 8.5 para asegurar tu cambio, sin embargo, debes de llenar el siguiente formato el cual lleva:" +
                    "\n -Nombre completo" +
                    "\n -Grupo" +
                    "\n -Carrera" +
                    "\n -Turno" +
                    "\n -Promedio" +
                    "\n -Motivo por el cual quieres hacer tu cambio" +
                    "\n -Nombre o firma del alumno/a");
            keywordResponses.put("cambio de plantel","Para solicitar un cambio de plantel es necesario acreditar todas tus materias y mantener un promedio de 8.5 para asegurar tu cambio, sin embargo, debes de llenar el siguiente formato el cual lleva:" +
                    "\n -Nombre completo" +
                    "\n -Grupo" +
                    "\n -Carrera" +
                    "\n -Plantel y cespecialidad a el cual te cambiaras" +
                    "\n -Turno" +
                    "\n -Promedio" +
                    "\n -Motivo por el cual quieres hacer tu cambio" +
                    "\n -Nombre o firma del alumno/a");
            keywordResponses.put("gracias", "Fue un placer. Que tengas buen dia");
            keywordResponses.put("cuánto tiempo tarda", "El tramite del documento varia, cada uno va desde que lo tramitas, por ejemplo:" +
                    "\n -Credencial: 1 dia." +
                    "\n -Constancia: 1 dia." +
                    "\n -Historial Academico 1 dia." +
                    "\n -Cambio de Turno: Deberas esperar en el periodo vacacional por semestre." +
                    "\n -Cambio de Grupo: Deberas esperar en el periodo vacacional por semestre." +
                    "\n -Cambio de Plantel: Deberas esperar en el periodo vacacional por semestre." +
                    "\n -Cambio de Carrera: Deberas esperar en el periodo vacacional por semestre.");
            keywordResponses.put("cuando estara listo", "El tramite del documento varia, cada uno va desde que lo tramitas, por ejemplo:" +
                    "\n -Credencial: 1 dia." +
                    "\n -Constancia: 1 dia." +
                    "\n -Historial Academico 1 dia." +
                    "\n -Cambio de Turno: Deberas esperar en el periodo vacacional por semestre." +
                    "\n -Cambio de Grupo: Deberas esperar en el periodo vacacional por semestre." +
                    "\n -Cambio de Plantel: Deberas esperar en el periodo vacacional por semestre." +
                    "\n -Cambio de Carrera: Deberas esperar en el periodo vacacional por semestre.");
            keywordResponses.put("precio","El precio de los documentos son los siguientes:" +
                    "\n -Duplicado de Credencial: $64." +
                    "\n -Constancia de estudios con o sin tira de materias: $53" +
                    "\n -Certificado: $164" +
                    "\n -Certificafo parcial: $164" +
                    "\n -Duplicado de certificado: $164" +
                    "\n -Titulo Profesional: $392" +
                    "\n -Seguro contra accidentes: $42" +
                    "\n -Seminario de Titulacion: $286" +
                    "\n -Examen Extraordinario 1: $143" +
                    "\n -Examen Extraordinario 2: $143" +
                    "\n -Examen Extraordinario 3 (Titulo de suficiencia): $154");
            keywordResponses.put("no tengo seguro","Para adquirir tu numero de seguridad social, debes de realizar los siguientes pasos");
            keywordResponses.put("no tengo numero de seguridad social","Para adquirir tu numero de seguridad social, debes de realizar los siguientes pasos");
        }

        public String getResponse(String userMessage) {
            // Lógica del chatbot basada en palabras clave
            String response = "No entiendo tu mensaje. ¿Puedes ser más específico?";

            // Convierte el mensaje del usuario a minúsculas para hacer la comparación de manera insensible a mayúsculas
            String lowerCaseMessage = userMessage.toLowerCase();

            for (Map.Entry<String, String> entry : keywordResponses.entrySet()) {
                if (lowerCaseMessage.contains(entry.getKey())) {
                    response = entry.getValue();
                    break;
                }
            }

            return response;
        }
}
