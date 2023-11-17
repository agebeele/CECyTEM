package com.example.dual;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.dual.databinding.ActivityAdminVinInicioBinding;

public class AdminVIN_Inicio extends AppCompatActivity {

    ActivityAdminVinInicioBinding bindingVIN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_vin_inicio);

        bindingVIN = ActivityAdminVinInicioBinding.inflate(getLayoutInflater());
        setContentView(bindingVIN.getRoot());

        bindingVIN.bottomNavigationViewVIN.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.InicioVIN) {
                replaceFragment(new FragmentVIN_Inicio());
            } else if (item.getItemId() == R.id.VinculacionVIN) {
                replaceFragment(new FragmentVIN_vinculacion());
            } else if (item.getItemId() == R.id.ConfigVIN) {
                replaceFragment(new FragmentVIN_Config());
            }
            return true;
        });
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layoutVIN, fragment);
        fragmentTransaction.commit();
    }
}