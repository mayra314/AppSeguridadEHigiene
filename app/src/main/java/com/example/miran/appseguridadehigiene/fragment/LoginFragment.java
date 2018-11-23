package com.example.miran.appseguridadehigiene.fragment;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.SharedElementCallback;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.miran.appseguridadehigiene.ClassHttp.ResponseService;
import com.example.miran.appseguridadehigiene.ClassHttp.ServiceConexion;
import com.example.miran.appseguridadehigiene.R;
import com.example.miran.appseguridadehigiene.HomeActivity;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
private Button loginFragment;
private EditText txtUser;
private EditText txtPassword;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        txtUser =(EditText) view.findViewById(R.id.txtl_username_login);
        txtPassword =(EditText) view.findViewById(R.id.txtl_pass_login);
        loginFragment =(Button) view.findViewById(R.id.bt_loginFragment);





        loginFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext() , HomeActivity.class));
            }
        });
        return view;
    }

    public String enviarPost_(String user, String pas)
    {


    }



    public static  class  Peticion extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            final String Url = "http://localhost:20691/Service1.svc/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ServiceConexion service = retrofit.create(ServiceConexion.class);
            Call<List<ResponseService>> response = service.getUsuarioGet();

            try {
                for (ResponseService user : response.execute().body()) {

                    Log.e("Respuesta:  ", user.getUsuario() + user.getPwd());


                }
            } catch (IOException e) {
                 e.printStackTrace();
            }

            return null;

        }
    }





    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle("Seguridad e higiene");
    }
}
