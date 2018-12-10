package com.example.miran.appseguridadehigiene.httpService;

import android.os.AsyncTask;

import com.example.miran.appseguridadehigiene.entityTO.CatSancionTO;
import com.example.miran.appseguridadehigiene.entityTO.CatTipoFaltasTO;
import com.example.miran.appseguridadehigiene.entityTO.SancionEmpleadoTO;
import com.example.miran.appseguridadehigiene.util.UtilSeguridad;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class CatalogosService {


   public  List<CatSancionTO> getSanciones() throws ExecutionException, InterruptedException {
       AsyncTask<Void, Void, List<CatSancionTO>> asyncTask = new AsyncTask<Void, Void, List<CatSancionTO>>() {

           @Override
           protected List<CatSancionTO> doInBackground(Void... voids) {
               List<CatSancionTO> listSanciones = null;
               try {
                   URL url = new URL("http://192.168.2.13:3000/api/user/Sanciones");
                   HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                   urlConnection.setRequestMethod("GET");
                   int responseCode = urlConnection.getResponseCode();

                   if (responseCode == HttpURLConnection.HTTP_OK) {
                       JsonArray elements = (JsonArray) new JsonParser().parse(UtilSeguridad.readStream(urlConnection.getInputStream()));
                       listSanciones = new ArrayList<>();
                       CatSancionTO catSanciones;
                       for (JsonElement object : elements) {
                           catSanciones = new CatSancionTO();
                           catSanciones.setPkSancion(object.getAsJsonObject().get("PkSancion").getAsInt());
                           catSanciones.setDescSancion(object.getAsJsonObject().get("DescSancion").getAsString());
                           listSanciones.add(catSanciones);
                       }

                   }

               } catch (Exception e) {
                   e.printStackTrace();
               }

               return listSanciones;
           }
       };

           return asyncTask.execute().get();

   }



    public  List<CatTipoFaltasTO> getTipoFaltas() throws ExecutionException, InterruptedException {
        AsyncTask<Void, Void, List<CatTipoFaltasTO>> asyncTask = new AsyncTask<Void, Void, List<CatTipoFaltasTO>>() {

            @Override
            protected List<CatTipoFaltasTO> doInBackground(Void... voids) {
                List<CatTipoFaltasTO> listFaltas = null;
                try {
                    URL url = new URL("http://192.168.2.13:3000/api/user/TipoFaltas");
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    int responseCode = urlConnection.getResponseCode();

                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        JsonArray elements = (JsonArray) new JsonParser().parse(UtilSeguridad.readStream(urlConnection.getInputStream()));
                        listFaltas = new ArrayList<>();
                        CatTipoFaltasTO tipoFaltas;
                        for (JsonElement object : elements) {
                            tipoFaltas = new CatTipoFaltasTO();
                            tipoFaltas.setPkTipoFalta(object.getAsJsonObject().get("PkTipoFalta").getAsInt());
                            tipoFaltas.setDescTipoFalta(object.getAsJsonObject().get("DescTipoFalta").getAsString());
                            listFaltas.add(tipoFaltas);
                        }

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                return listFaltas;
            }
        };

        return asyncTask.execute().get();
    }


    public int saveSancion(){
       new AsyncTask<Void,Void,SancionEmpleadoTO>()
        HttpURLConnection connection;
        try {
            //Open a new URL connection
            connection = (HttpURLConnection) new URL("http://192.168.2.13:3000/api/user/saveSancionEmpleado")
                    .openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");

            JSONObject jsonParam = new JSONObject();
            try {
                jsonParam.put("campaign_id", "4193");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            OutputStreamWriter outputStream = new OutputStreamWriter(connection.getOutputStream());
            outputStream.write(jsonParam.toString());
            outputStream.flush();
            outputStream.close();

            //Get the Response code for the request
            return connection.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }


}
