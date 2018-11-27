package com.example.miran.appseguridadehigiene.httpService;

import android.os.AsyncTask;
import android.util.Log;

import com.example.miran.appseguridadehigiene.entityTO.LoginTO;
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
            URL url = new URL("http://192.168.1.68:3000/api/user/loginUser?user="+loginTOS[0].getUser()+"&password="+loginTOS[0].getPassword()+"");

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            int responseCode = urlConnection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK){
                JsonObject jobj = new Gson().fromJson(readStream(urlConnection.getInputStream()), JsonObject.class);
               name = jobj.get("name").getAsString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return name;
    }

    private String readStream(InputStream in) {
        BufferedReader reader = null;
        StringBuffer response = new StringBuffer();
        try {
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return response.toString();
    }

    @Override
    protected void onPostExecute(String s) {
        Log.i("value name tapia" , s);
        super.onPostExecute(s);
    }
}
