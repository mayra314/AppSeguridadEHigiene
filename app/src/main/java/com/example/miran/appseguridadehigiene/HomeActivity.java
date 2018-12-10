package com.example.miran.appseguridadehigiene;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


import com.example.miran.appseguridadehigiene.entityTO.EmpleadoTO;
import com.example.miran.appseguridadehigiene.entityTO.ResponseUserTO;
import com.example.miran.appseguridadehigiene.fragment.HSEFragment;
import com.example.miran.appseguridadehigiene.fragment.PerfilEmpFragment;
import com.example.miran.appseguridadehigiene.interfaz.ComunicadorDialog;
import com.example.miran.appseguridadehigiene.util.Constantes;

import java.util.List;

public class HomeActivity extends AppCompatActivity  {
    public static final String USER_ADMIN = "userAdmin";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

            ResponseUserTO userTO = (ResponseUserTO) getIntent().getSerializableExtra(USER_ADMIN);
            EmpleadoTO stringExtra = (EmpleadoTO) getIntent().getSerializableExtra(Constantes.TEXT);

            if (userTO != null && stringExtra != null) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(android.R.id.content, PerfilEmpFragment.newInstance(stringExtra, userTO))
                        .commit();

            }else {

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(android.R.id.content, HSEFragment.newInstance(userTO))
                    .commit();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.cerrar_sesion:
                startActivity(new Intent(this,MainActivity.class));
                return Boolean.TRUE;
        }
        return super.onOptionsItemSelected(item);
    }



}
