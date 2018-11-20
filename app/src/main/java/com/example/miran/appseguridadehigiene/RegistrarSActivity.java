package com.example.miran.appseguridadehigiene;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.miran.appseguridadehigiene.fragment.AgregarSancionFragment;
import com.example.miran.appseguridadehigiene.fragment.PerfilEmpFragment;
import com.example.miran.appseguridadehigiene.util.Constantes;

public class RegistrarSActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_s);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(android.R.id.content, new AgregarSancionFragment())
                    .commit();

        }



}
