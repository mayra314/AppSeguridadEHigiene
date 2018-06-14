package com.example.miran.appseguridadehigiene;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;


import com.example.miran.appseguridadehigiene.fragment.HSEFragment;

public class HomeActivity extends AppCompatActivity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(android.R.id.content, new HSEFragment())
                .commit();


    }
}
