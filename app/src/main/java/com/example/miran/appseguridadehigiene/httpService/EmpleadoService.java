package com.example.miran.appseguridadehigiene.httpService;

import android.os.AsyncTask;
import android.util.Log;

import com.example.miran.appseguridadehigiene.entityTO.EmpleadoTO;
import com.example.miran.appseguridadehigiene.util.UtilSeguridad;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.modelmapper.ModelMapper;

import java.net.HttpURLConnection;
import java.net.URL;

public class EmpleadoService extends AsyncTask<Long,Integer,EmpleadoTO> {
    @Override
    protected EmpleadoTO doInBackground(Long... longs) {
        EmpleadoTO empleado = null;
        try {
            URL url = new URL("http://fa981656.ngrok.io/api/user/getEmpleado?matricula=" + longs[0]);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            int responseCode = urlConnection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK){
               empleado = new EmpleadoTO();
                JsonObject jobj = new Gson().fromJson(UtilSeguridad.readStream(urlConnection.getInputStream()), JsonObject.class);
                empleado.setPkEmpleado(jobj.get("PkEmpleado").getAsInt());
                empleado.setFkEmpresa(jobj.get("FkEmpresa").getAsInt());
                empleado.setFkTipoUsuario(jobj.get("FkTipoUsuario").getAsInt());
                empleado.setNombre(jobj.get("Nombre").getAsString());
                empleado.setApellidoPaterno(jobj.get("ApellidoPaterno").getAsString());
                empleado.setApellidoMaterno(jobj.get("ApellidoMaterno").getAsString());
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return empleado;
    }


}
