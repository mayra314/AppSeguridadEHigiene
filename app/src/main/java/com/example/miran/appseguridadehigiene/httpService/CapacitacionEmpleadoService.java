package com.example.miran.appseguridadehigiene.httpService;

import android.os.AsyncTask;

import com.example.miran.appseguridadehigiene.entityTO.CapacitacionTO;
import com.example.miran.appseguridadehigiene.util.UtilSeguridad;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class CapacitacionEmpleadoService {


    public List<CapacitacionTO> getCapacitaciones(Long id) throws ExecutionException, InterruptedException {
        AsyncTask<Long, Void, List<CapacitacionTO>> asyncTask = new AsyncTask<Long, Void, List<CapacitacionTO>>() {

            @Override
            protected List<CapacitacionTO> doInBackground(Long... voids) {
                List<CapacitacionTO> listCapacitaciones = null;
                try {
                    URL url = new URL("http://10.11.1.46:3000/api/user/Capacitaciones?matricula="+voids[0]);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    int responseCode = urlConnection.getResponseCode();

                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        JsonArray elements = (JsonArray) new JsonParser().parse(UtilSeguridad.readStream(urlConnection.getInputStream()));
                        listCapacitaciones = new ArrayList<>();
                        CapacitacionTO capacitacion;
                        for (JsonElement object : elements) {
                            capacitacion = new CapacitacionTO();
                            capacitacion.setMatricula(object.getAsJsonObject().get("Matricula").getAsInt());
                            capacitacion.setNombre(object.getAsJsonObject().get("Nombre").getAsString());
                            JsonArray faltasCometidas = object.getAsJsonObject().get("CapacitacionesEmpleado").getAsJsonArray();

                            List<String> strings = new ArrayList<>();
                            for (int i = 0 ; i < faltasCometidas.size();i++){
                                strings.add(faltasCometidas.get(i).getAsString());
                            }
                            capacitacion.setCapacitacionesEmpleado(strings);
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
