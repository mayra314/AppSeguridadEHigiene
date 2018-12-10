package com.example.miran.appseguridadehigiene.httpService;

import android.os.AsyncTask;
import android.util.Log;

import com.example.miran.appseguridadehigiene.entityTO.CatSancionTO;
import com.example.miran.appseguridadehigiene.entityTO.CatTipoFaltasTO;
import com.example.miran.appseguridadehigiene.entityTO.ReporteSancionTO;
import com.example.miran.appseguridadehigiene.entityTO.SancionEmpleadoTO;
import com.example.miran.appseguridadehigiene.util.UtilSeguridad;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class SancionEmpleadoService {

   public  List<CatSancionTO> getSanciones() throws ExecutionException, InterruptedException {
       AsyncTask<Void, Void, List<CatSancionTO>> asyncTask = new AsyncTask<Void, Void, List<CatSancionTO>>() {

           @Override
           protected List<CatSancionTO> doInBackground(Void... voids) {
               List<CatSancionTO> listSanciones = null;
               try {
                   URL url = new URL("http://10.11.1.46:3000/api/user/Sanciones");
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
                    URL url = new URL("http://10.11.1.46:3000/api/user/TipoFaltas");
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


    public Long saveSancion(final SancionEmpleadoTO sancionEmpleado) throws ExecutionException, InterruptedException {

        AsyncTask<SancionEmpleadoTO, Void, Long> asyncTask = new AsyncTask<SancionEmpleadoTO, Void, Long>() {
            @Override
            protected Long doInBackground(SancionEmpleadoTO... SancionEmpleados) {
                HttpURLConnection connection;
                try {
                    connection = (HttpURLConnection) new URL("http://10.11.1.46:3000/api/user/SaveSancion")
                            .openConnection();
                    connection.setRequestMethod("POST");
                    connection.setRequestProperty("Content-Type", "application/json");
                    connection.setRequestProperty("Accept", "application/json");
                    OutputStreamWriter outputStream = new OutputStreamWriter(connection.getOutputStream());
                    JSONObject sancion = new JSONObject();
                    sancion.put("PkRegSancion",SancionEmpleados[0].getPkRegSancion());
                    sancion.put("FkEmpleado",SancionEmpleados[0].getFkEmpleado());
                    sancion.put("FkEmpresa",SancionEmpleados[0].getFkEmpresa());
                    sancion.put("FkTipoUsuario",SancionEmpleados[0].getFkTipoUsuario());
                    sancion.put("Fecha",SancionEmpleados[0].getFecha());
                    sancion.put("NumSancion",SancionEmpleados[0].getNumSancion());
                    sancion.put("OtrasFaltas",SancionEmpleados[0].getOtrasFaltas());
                    sancion.put("Observaciones",SancionEmpleados[0].getObservaciones());
                    sancion.put("FkSancion",SancionEmpleados[0].getFkSancion());
                    sancion.put("FkEstatus",SancionEmpleados[0].getFkEstatus());
                    sancion.put("FkUsuarioGral",SancionEmpleados[0].getFkUsuarioGral());
                    sancion.put("IdSancionesFaltas",new JSONArray(SancionEmpleados[0].getIdSancionesFaltas()));
                    outputStream.write(sancion.toString());
                    outputStream.flush();
                    outputStream.close();

                    return (long) connection.getResponseCode();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return -1L;
            }

        };

        return asyncTask.execute(sancionEmpleado).get();
    }




    public  List<ReporteSancionTO> getCapacitaciones(Long id) throws ExecutionException, InterruptedException {
        AsyncTask<Long, Void, List<ReporteSancionTO>> asyncTask = new AsyncTask<Long, Void, List<ReporteSancionTO>>() {

            @Override
            protected List<ReporteSancionTO> doInBackground(Long... voids) {
                List<ReporteSancionTO> listCapacitaciones = null;
                try {
                    URL url = new URL("http://10.11.1.46:3000/api/user/getReporteSancion?matricula="+voids[0]);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    int responseCode = urlConnection.getResponseCode();

                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        JsonArray elements = (JsonArray) new JsonParser().parse(UtilSeguridad.readStream(urlConnection.getInputStream()));
                        listCapacitaciones = new ArrayList<>();
                        ReporteSancionTO capacitacion;
                        for (JsonElement object : elements) {
                            capacitacion = new ReporteSancionTO();
                            capacitacion.setFecha(object.getAsJsonObject().get("Fecha").getAsString());
                            capacitacion.setNumeroSancion(object.getAsJsonObject().get("NumeroSancion").getAsString());
                            capacitacion.setSancionAplica(object.getAsJsonObject().get("sancionAplica").getAsString());
                            capacitacion.setSupervisor(object.getAsJsonObject().get("Supervisor").getAsString());
                            JsonArray faltasCometidas = object.getAsJsonObject().get("FaltasCometidas").getAsJsonArray();
                            List<String> strings = new ArrayList<>();
                            for (int i = 0 ; i < faltasCometidas.size();i++){
                                strings.add(faltasCometidas.get(i).getAsString());
                            }
                            capacitacion.setFaltasCometidas(strings);
                            listCapacitaciones.add(capacitacion);
                        }

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                return listCapacitaciones;
            }
        };

        return asyncTask.execute(id).get();
    }
}
