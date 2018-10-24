package com.pack.networking.interfaz;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface Interfaz {
    @GET("servicios")
    @Headers("Content-Type: application/json")
    Call<String> getServicios();

   // https://info-tickets.es/api-test/public/gmail/lkeke@gmail.com/as6d8a56sd8sa
    @GET("gmail"+"/{email}/{token}")
    @Headers("Content-Type: application/json")
    Call<String> SignIn(@Path("email") String email,@Path("token") String token);


    //https://info-tickets.es/api-test/public/asociar/tokenCliente/qrCode
    @GET("asociar"+"/{tokenCliente}/{qrCode}")
    @Headers("Content-Type: application/json")
    Call<String> buy(@Path("tokenCliente") String tokenCliente,@Path("qrCode") String qrCode);
}