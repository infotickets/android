package com.pack.networking.interfaz;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface Interfaz {
    @GET("servicios")
    @Headers("Content-Type: application/json")
    Call<String> getServicios();


}
