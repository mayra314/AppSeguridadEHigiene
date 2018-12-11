package com.example.miran.appseguridadehigiene.httpService;

import android.os.AsyncTask;
import android.util.Log;

import com.example.miran.appseguridadehigiene.entityTO.EmpleadoTO;
import com.example.miran.appseguridadehigiene.util.UtilSeguridad;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.modelmapper.ModelMapper;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoService extends AsyncTask<Long,Integer,List<EmpleadoTO>> {
    @Override
    protected List<EmpleadoTO> doInBackground(Long... longs) {
        List<EmpleadoTO> empleados = new ArrayList<>();
        EmpleadoTO empleado = null;
        try {
            URL url = new URL("http://10.11.1.46:3000/api/user/getEmpleado?matricula=" + longs[0]);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            int responseCode = urlConnection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK){


                JsonArray elements = (JsonArray) new JsonParser().parse(UtilSeguridad.readStream(urlConnection.getInputStream()));
                for (JsonElement element : elements ) {
                    empleado = new EmpleadoTO();
                    empleado.setPkEmpleado(element.getAsJsonObject().get("PkEmpleado").getAsInt());
                    empleado.setFkEmpresa(element.getAsJsonObject().get("FkEmpresa").getAsInt());
                    empleado.setFkTipoUsuario(element.getAsJsonObject().get("FkTipoUsuario").getAsInt());
                    empleado.setNombre(element.getAsJsonObject().get("Nombre").getAsString());
                    empleado.setApellidoPaterno(element.getAsJsonObject().get("ApellidoPaterno").getAsString());
                    empleado.setApellidoMaterno(element.getAsJsonObject().get("ApellidoMaterno").getAsString());
                    empleado.setPuesto(element.getAsJsonObject().get("Puesto").getAsString());
                    empleados.add(empleado);
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return empleados;
    }


}
