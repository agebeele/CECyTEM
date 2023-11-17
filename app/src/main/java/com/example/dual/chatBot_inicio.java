package com.example.dual;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class chatBot_inicio extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ChatAdapter chatAdapter;
    private ChatBot chatBot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_bot_inicio);

        recyclerView = findViewById(R.id.recyclerView);
        FloatingActionButton fab = findViewById(R.id.fab);

        chatAdapter = new ChatAdapter();
        chatBot = new ChatBot();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(chatAdapter);

        ChatAdapter chatAdapter = new ChatAdapter(this); // 'this' es el contexto de la actividad

        fab.setOnClickListener(view -> sendMessage());
    }

    // MainActivity.java
    private void sendMessage() {
        EditText inputEditText = findViewById(R.id.inputEditText);
        String userMessage = inputEditText.getText().toString();

        // Añadir mensaje del usuario a la lista
        chatAdapter.addMessage(new ChatMessage("Usuario", userMessage));

        // Obtener respuesta del chatbot
        String botResponse = chatBot.getResponse(userMessage);

        // Añadir respuesta del chatbot a la lista
        chatAdapter.addMessage(new ChatMessage("ChatBot", botResponse));

        // Limpiar el campo de entrada
        inputEditText.getText().clear();

        // Desplazar hacia abajo para mostrar el último mensaje
        recyclerView.smoothScrollToPosition(chatAdapter.getItemCount() - 1);
    }

}