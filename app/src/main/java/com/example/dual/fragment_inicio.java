package com.example.dual;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class fragment_inicio extends Fragment {

    RecyclerView recyclerView;
    PublicacionAdapter myAdapter;
    private List<item_publicacion> itemPublicacionList;
    private FloatingActionButton floatingActionButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_inicio, container, false);

        itemPublicacionList = generatePublicacionItems();

        recyclerView = v.findViewById(R.id.recyclerView_inicio);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        myAdapter = new PublicacionAdapter(itemPublicacionList);

        recyclerView.setAdapter(myAdapter);

        floatingActionButton = v.findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirChatbot();
            }
        });

        return v;
    }

    private void abrirChatbot() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Chatbot");
        builder.setMessage("¡Bienvenido al Chatbot!");

        // Incluye un EditText para que el usuario escriba mensajes
        final EditText userInput = new EditText(getActivity());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        userInput.setLayoutParams(layoutParams);
        builder.setView(userInput);

        builder.setPositiveButton("Enviar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String userMessage = userInput.getText().toString().trim();
                if (!userMessage.isEmpty()) {
                    // Envía el mensaje del usuario al chatbot y obtén la respuesta
                    String chatbotResponse = obtenerRespuestaDelChatbot(userMessage);

                    // Muestra la respuesta del chatbot en un cuadro de diálogo
                    mostrarRespuestaDelChatbot(chatbotResponse);
                }
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // El usuario hizo clic en "Cancelar", no hacer nada
            }
        });

        builder.show();
    }

    // Método para simular la obtención de una respuesta del chatbot
    private String obtenerRespuestaDelChatbot(String userMessage) {
        // Aquí deberías implementar la lógica para enviar userMessage al servicio de chatbot
        // y obtener la respuesta del chatbot.
        // Por ahora, simulamos una respuesta.
        return "Chatbot: Gracias por tu mensaje: " + userMessage;
    }

    // Método para mostrar la respuesta del chatbot en un cuadro de diálogo
    private void mostrarRespuestaDelChatbot(String chatbotResponse) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Respuesta del Chatbot");
        builder.setMessage(chatbotResponse);
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // El usuario hizo clic en "Aceptar", no hacer nada adicional
            }
        });
        builder.show();
    }

    private List<item_publicacion> generatePublicacionItems(){
        List<item_publicacion> itemPublicacions = new ArrayList<>();
        itemPublicacions.add(new item_publicacion(R.drawable.cecytem,"Consejo tecnico","El dia de mañana se llevara a cabo", "08/11/2023", "10:12"));
        itemPublicacions.add(new item_publicacion(R.drawable.cecytem,"Junta de Padres","Firma de boletas", "14/12/2023", "03:12"));
        itemPublicacions.add(new item_publicacion(R.drawable.cecytem,"No hay clases","Por el cumpleaños de Brandon", "10/11/2023", "08:30"));
        itemPublicacions.add(new item_publicacion(R.drawable.cecytem,"Consejo tecnico","El dia de mañana se llevara a cabo", "08/11/2023", "10:12"));
        itemPublicacions.add(new item_publicacion(R.drawable.cecytem,"Junta de Padres","Firma de boletas", "14/12/2023", "03:12"));
        itemPublicacions.add(new item_publicacion(R.drawable.cecytem,"No hay clases","Por el cumpleaños de Brandon", "10/11/2023", "08:30"));
        itemPublicacions.add(new item_publicacion(R.drawable.cecytem,"Consejo tecnico","El dia de mañana se llevara a cabo", "08/11/2023", "10:12"));
        itemPublicacions.add(new item_publicacion(R.drawable.cecytem,"Junta de Padres","Firma de boletas", "14/12/2023", "03:12"));
        itemPublicacions.add(new item_publicacion(R.drawable.cecytem,"No hay clases","Por el cumpleaños de Brandon", "10/11/2023", "08:30"));

        return itemPublicacions;
    }
}