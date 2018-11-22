package com.example.miran.appseguridadehigiene.ClassHttp;

import android.app.Service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ServiceConexion {

    @GET("GetLogin")
    Call<List<ResponseService>> getUsuarioGet();


    @POST("GetLogin")
    Call<List<ResponseService>> getUsuarioPost();

}
