package com.example.miran.appseguridadehigiene.httpService;

import android.os.AsyncTask;
import android.util.Log;

import com.example.miran.appseguridadehigiene.entityTO.LoginTO;
import com.example.miran.appseguridadehigiene.util.UtilSeguridad;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoginService extends AsyncTask<LoginTO,Integer,String> {

    @Override
    protected String doInBackground(LoginTO... loginTOS) {
         String name = "";
        try {
            URL url = new URL("http://fa981656.ngrok.io/api/user/loginUser?user="+loginTOS[0].getUser()+"&password="+loginTOS[0].getPassword()+"");

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            int responseCode = urlConnection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK){
                JsonObject jobj = new Gson().fromJson(UtilSeguridad.readStream(urlConnection.getInputStream()), JsonObject.class);
               name = jobj.get("name").getAsString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return name;
    }

}
