package com.example.dual;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class publicacionAdapter extends RecyclerView.Adapter<publicacionAdapter.publicacionViewHolder> {

    private List<Publicacion> listaPublicaciones;

    // Constructor y métodos del adaptador

    static class publicacionViewHolder extends RecyclerView.ViewHolder {
        // Declaraciones de las vistas (ImageView, TextViews, etc.)

        publicacionViewHolder(View itemView) {
            super(itemView);
            // Inicializa las vistas aquí
        }
    }

    @NonNull
    @Override
    public publicacionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull publicacionAdapter.publicacionViewHolder holder, int position) {

    }
    @Override
    public int getItemCount() {
        return listaPublicaciones.size();
    }
}