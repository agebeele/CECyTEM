package com.example.dual;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class FragmentCE_Inicio extends Fragment {

    RecyclerView recyclerView;
    AdapterCE adapterCE;
    private List<item_ce> item_ceList;
    FloatingActionButton agregarItem;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_c_e__inicio, container, false);
        // Inflate the layout for this fragment

        agregarItem = (FloatingActionButton) v.findViewById(R.id.floatingActionButton_ce);

        item_ceList = generatePublicacionItems();

        recyclerView = v.findViewById(R.id.recyclerView_inicio_ce);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapterCE = new AdapterCE(item_ceList);

        recyclerView.setAdapter(adapterCE);

        agregarItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarPublicacion();
            }
        });

        return v;
    }

    private void agregarPublicacion() {
        Intent publicaion = new Intent(getActivity(),agregarItem_CE.class);
        startActivity(publicaion);
    }

    private List<item_ce> generatePublicacionItems() {
        List<item_ce> item_ces = new ArrayList<>();
        item_ces.add(new item_ce(R.drawable.cecytem,"Consejo tecnico","El dia de mañana se llevara a cabo", "08/11/2023", "10:12"));
        item_ces.add(new item_ce(R.drawable.cecytem,"Junta de Padres","Firma de boletas", "14/12/2023", "03:12"));
        item_ces.add(new item_ce(R.drawable.cecytem,"No hay clases","Por el cumpleaños de Brandon", "10/11/2023", "08:30"));
        item_ces.add(new item_ce(R.drawable.cecytem,"Consejo tecnico","El dia de mañana se llevara a cabo", "08/11/2023", "10:12"));
        item_ces.add(new item_ce(R.drawable.cecytem,"Junta de Padres","Firma de boletas", "14/12/2023", "03:12"));
        item_ces.add(new item_ce(R.drawable.cecytem,"No hay clases","Por el cumpleaños de Brandon", "10/11/2023", "08:30"));
        item_ces.add(new item_ce(R.drawable.cecytem,"Consejo tecnico","El dia de mañana se llevara a cabo", "08/11/2023", "10:12"));
        item_ces.add(new item_ce(R.drawable.cecytem,"Junta de Padres","Firma de boletas", "14/12/2023", "03:12"));
        item_ces.add(new item_ce(R.drawable.cecytem,"No hay clases","Por el cumpleaños de Brandon", "10/11/2023", "08:30"));

        return item_ces;
    }
}