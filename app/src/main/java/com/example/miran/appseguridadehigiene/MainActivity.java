package com.example.miran.appseguridadehigiene;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.miran.appseguridadehigiene.fragment.LoginFragment;

import retrofit2.Retrofit;

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



    public static  class  Peticion extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            final String Url= "http://localhost:20691/Service1.svc/";

            Retrofit retrofit = new Retrofit.Builder();
            .
            return null;
        }
    }

}
