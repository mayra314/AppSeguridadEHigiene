package com.example.miran.appseguridadehigiene;

import android.app.Service;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.miran.appseguridadehigiene.ClassHttp.ResponseService;
import com.example.miran.appseguridadehigiene.ClassHttp.ServiceConexion;
import com.example.miran.appseguridadehigiene.fragment.LoginFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(android.R.id.content,new LoginFragment())
                .commit();
    }





}
