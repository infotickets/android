package com.pack.networking;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetroBase {
    public Retrofit obj;
   // private final String URL="https://info-tickets.es/api-test/public/";

    public RetroBase(String url) {
        obj = new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .baseUrl(url)
                .build();

     /*   Interfaz interfaz= retrofit.create(Interfaz.class);


       Call<String > call =interfaz.getServicios();

       call.enqueue(new Callback<String>() {
           @Override
           public void onResponse(Call<String> call, Response<String> response) {
               String body = response.body().toString();

               Log.d("deb",""+body);
               Gson gson = new Gson();

               Servicio[] result =  gson.fromJson(body,Servicio[].class);

               Log.d("","");

           }

           @Override
           public void onFailure(Call<String> call, Throwable t) {

           }
       });
*/
    }
}
