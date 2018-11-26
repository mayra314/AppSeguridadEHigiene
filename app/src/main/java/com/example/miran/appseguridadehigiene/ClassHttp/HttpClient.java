package com.example.miran.appseguridadehigiene.ClassHttp;


import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {

    public String lerUrlServico(String urlServico) throws IOException {
        String datos = "";
        InputStream objDatosInputStream = null;
        HttpURLConnection objUrlConnection = null;

        try{
            URL url = new URL(urlServico);
            objUrlConnection = (HttpURLConnection) url.openConnection();
            objUrlConnection.connect();
            objDatosInputStream = objUrlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(objDatosInputStream));
            StringBuffer sb = new StringBuffer();
            String linea = "";
            while((linea = br.readLine()) != null){
                sb.append(linea);
            }
            datos = sb.toString();
            br.close();
        }
        catch(Exception e)
        {
            Log.i("TAG", e.toString());
        }
        finally{
            objDatosInputStream.close();
            objUrlConnection.disconnect();
        }
        return datos;
    }




}
