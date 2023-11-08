package com.example.dual;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class fragment_inicio extends Fragment {

    RecyclerView recyclerView;
    PublicacionAdapter myAdapter;
    private List<item_publicacion> itemPublicacionList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_inicio, container, false);

        itemPublicacionList = generatePublicacionItems();

        recyclerView = v.findViewById(R.id.recyclerView_inicio);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        myAdapter = new PublicacionAdapter(itemPublicacionList);

        recyclerView.setAdapter(myAdapter);

        return v;
    }
    private List<item_publicacion> generatePublicacionItems(){
        List<item_publicacion> itemPublicacions = new ArrayList<>();
        itemPublicacions.add(new item_publicacion(R.drawable.coacalco_imagen,"Consejo tecnico","El dia de mañana se llevara a cabo", "08/11/2023", "10:12"));
        itemPublicacions.add(new item_publicacion(R.drawable.coacalco_imagen,"Junta de Padres","Firma de boletas", "14/12/2023", "03:12"));
        itemPublicacions.add(new item_publicacion(R.drawable.coacalco_imagen,"No hay clases","Por el cumpleaños de Brandon", "10/11/2023", "08:30"));

        return itemPublicacions;
    }
}