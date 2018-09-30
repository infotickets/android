package com.pack.networking.handler.Response;

import es.infotickets.android.MainActivity;
import com.google.gson.Gson;
import com.pack.networking.bean.Servicio;

import retrofit2.Response;

public class ServiceResponseHandler {
    private Gson gson = new Gson();

    public void procesServices(Response<String> response, MainActivity activity){
        String body = response.body().toString();
        activity.setData(gson.fromJson(body,Servicio[].class));
      //  Data.setServicio( gson.fromJson(body,Servicio[].class));
       // activity.setData(Data.getServicio());
    }
}