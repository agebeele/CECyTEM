package com.example.dual;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class fragment_inicio extends Fragment {

    private RecyclerView recyclerView;
    private publicacionAdapter publicacionAdapter;
    private List<Publicacion> listaPublicaciones;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_inicio, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView_inicio);
        listaPublicaciones = new ArrayList<>();
        publicacionAdapter = new publicacionAdapter();

        // Configura el RecyclerView con un LinearLayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(publicacionAdapter);

        return v;
    }
}