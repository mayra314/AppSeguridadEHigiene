package com.example.miran.appseguridadehigiene;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;


import com.example.miran.appseguridadehigiene.fragment.HSEFragment;
import com.example.miran.appseguridadehigiene.fragment.PerfilEmpFragment;
import com.example.miran.appseguridadehigiene.util.Constantes;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        savedInstanceState = getIntent().getExtras();
        if (savedInstanceState != null) {
            String stringExtra = getIntent().getStringExtra(Constantes.TEXT);

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(android.R.id.content,PerfilEmpFragment.newInstance(stringExtra))
                        .commit();

            }else {

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(android.R.id.content, new HSEFragment())
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
