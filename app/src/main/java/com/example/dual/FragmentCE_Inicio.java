package com.example.dual;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FragmentCE_Inicio extends Fragment {

    RecyclerView recyclerView;
    AdapterCE adapterCE;
    //private List<item_ce> item_ceList;
    FloatingActionButton agregarItem;
    String msj;
    WebService obj = new WebService();
    private List<String> titloList = new ArrayList<>();
    private List<String> descripcionList = new ArrayList<>();
    private List<String> fechaList = new ArrayList<>();
    private List<String> horaList = new ArrayList<>();
    private List<String> imageList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_c_e__inicio, container, false);
        // Inflate the layout for this fragment

        agregarItem = (FloatingActionButton) v.findViewById(R.id.floatingActionButton_ce);

        //item_ceList = generatePublicacionItems();

        recyclerView = v.findViewById(R.id.recyclerView_inicio_ce);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getActivity(), R.drawable.divider_line);
        recyclerView.addItemDecoration(itemDecoration);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapterCE = new AdapterCE(titloList, descripcionList, horaList, fechaList, imageList);

        recyclerView.setAdapter(adapterCE);

        MiAsyncTask miAsyncTask = new MiAsyncTask();
        miAsyncTask.execute();

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

    /*
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
    */
    class MiAsyncTask extends AsyncTask<Void, String, Void> {
        @Override
        protected Void doInBackground(Void... parameters) {
            msj = obj.muroPublicaciones();
            publishProgress(msj);
            return null;
        }
        @SuppressLint({"NotifyDataSetChanged", "DiscouragedApi"})
        @Override
        protected void onProgressUpdate(String... progress) {
            try {
                JSONArray jsonArray = new JSONArray(progress[0]);
                JSONObject json_data;
                int length = jsonArray.length();
                for (int i = 0; i < length; i++) {
                    json_data = jsonArray.getJSONObject(i);

                    titloList.add(json_data.getString("titulo"));
                    descripcionList.add(json_data.getString("descripcion"));
                    fechaList.add(json_data.getString("fecha"));
                    horaList.add(json_data.getString("hora"));
                }
                imageList.add(String.valueOf(R.drawable.cecytem));
                imageList.add(String.valueOf(R.drawable.cecytem));
                imageList.add(String.valueOf(R.drawable.cecytem));
                imageList.add(String.valueOf(R.drawable.cecytem));
                imageList.add(String.valueOf(R.drawable.cecytem));
                imageList.add(String.valueOf(R.drawable.cecytem));
                imageList.add(String.valueOf(R.drawable.cecytem));
                imageList.add(String.valueOf(R.drawable.cecytem));
            } catch (JSONException e) {
                Toast.makeText(getActivity(), progress[0], Toast.LENGTH_LONG).show();
            }
            adapterCE.notifyDataSetChanged();
        }
    }
}