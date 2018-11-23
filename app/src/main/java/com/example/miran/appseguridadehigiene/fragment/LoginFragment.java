package com.example.miran.appseguridadehigiene.fragment;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.SharedElementCallback;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miran.appseguridadehigiene.ClassHttp.HttpClient;
import com.example.miran.appseguridadehigiene.ClassHttp.ResponseService;
import com.example.miran.appseguridadehigiene.ClassHttp.ServiceConexion;
import com.example.miran.appseguridadehigiene.MainActivity;
import com.example.miran.appseguridadehigiene.R;
import com.example.miran.appseguridadehigiene.HomeActivity;
import com.google.gson.Gson;

import org.json.JSONArray;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    private Button loginFrag;
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
        txtUser = (EditText) view.findViewById(R.id.txtl_username_login);
        txtPassword = (EditText) view.findViewById(R.id.txtl_pass_login);
        loginFrag = (Button) view.findViewById(R.id.bt_loginFragment);


        loginFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // se crea un hilo
                Thread tr = new Thread() {
                    @Override
                    public void run() {
                        final String res = enviarPost_(txtUser.getText().toString(), txtPassword.getText().toString());
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                int r = objJson(res);
                                // validacion usuario contaseña
                                if (r > 0) {
                                    Intent i = new Intent(getContext(), MainActivity.class);
                                    startActivity(i);
                                } else {
                                    Toast.makeText(getContext(), "Usuario o password incorrecto",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                };
                tr.start();
            }

        });
            return  view;
    }




    public String enviarPost_(String user, String pas) {

        String parametros = "user" + user + "pas" + pas;
        HttpsURLConnection conexion = null;
        String respuesta = "";
        try {
            URL url = new URL("http://192.168.1.152:20691/Service1.svc/");
            conexion = (HttpsURLConnection) url.openConnection();
            conexion.setRequestMethod("POST");
            conexion.setRequestProperty("Content-Length", "" + Integer.toString(parametros.getBytes().length));

            conexion.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(conexion.getOutputStream());
            wr.writeBytes(parametros);
            wr.close();

            Scanner inStream = new Scanner(conexion.getInputStream());

            while (inStream.hasNextLine())
                respuesta += (inStream.nextLine());


        } catch (Exception e) {}

            return respuesta.toString();


    }

        public int objJson(String resp){
            int res = 0;
            try {
                JSONArray jsonArray = new JSONArray(resp);
                if (jsonArray.length() > 0)
                    res = 1;

            } catch (Exception e) {}
                return res;
            }


        }

 /*  public static  class  Peticion extends AsyncTask<Void, Void, Void> {

        /*@Override
       /* protected Void doInBackground(Void... voids) {

            final String Url = "http://192.168.1.152:20691/Service1.svc/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ServiceConexion service = retrofit.create(ServiceConexion.class);
            Call<List<ResponseService>> response = service.getUsuarioPost();

            try {
                for (ResponseService user : response.execute().body()) {

                    Log.e("Respuesta:  ", user.getUsuario() + user.getPwd());


                }
            } catch (IOException e) {
                 e.printStackTrace();
            }

            return null;

        }
    }*/





  /*  @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle("Seguridad e higiene");
    }*/

