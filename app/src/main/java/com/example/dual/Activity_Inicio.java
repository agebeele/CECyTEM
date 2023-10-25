package com.example.dual;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.dual.databinding.ActivityInicioBinding;

public class Activity_Inicio extends AppCompatActivity {
    ActivityInicioBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        binding = ActivityInicioBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            if (item.getItemId()==R.id.Inicio){
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout, new fragment_inicio());
                fragmentTransaction.commit();

            } else if (item.getItemId()==R.id.CE) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout, new fragment_control_escolar());
                fragmentTransaction.commit();

            } else if (item.getItemId()==R.id.Vinculacion) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout, new fragment_vinculacion());
                fragmentTransaction.commit();

            } else if (item.getItemId()==R.id.Config) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout, new fragment_configuracion());
                fragmentTransaction.commit();

            }
            return true;
        });
    }
}