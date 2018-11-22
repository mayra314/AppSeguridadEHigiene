package com.example.miran.appseguridadehigiene;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.miran.appseguridadehigiene.fragment.LoginFragment;

public class MainActivity extends AppCompatActivity {

    private Button loginFragment;
    private EditText txtUser;
    private EditText txtPassword;


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
