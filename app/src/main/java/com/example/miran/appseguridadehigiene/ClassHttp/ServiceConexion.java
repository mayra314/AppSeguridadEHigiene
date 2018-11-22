package com.example.miran.appseguridadehigiene.ClassHttp;

import android.app.Service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ServiceConexion {

    @GET("http://localhost:20691/Service1.svc")
    Call<List<Service>>


    @POST("http://localhost:20691/Service1.svc")

}
