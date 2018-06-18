package com.example.miran.appseguridadehigiene;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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

}
