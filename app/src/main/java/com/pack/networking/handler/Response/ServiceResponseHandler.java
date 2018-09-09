package com.pack.networking.handler.Response;

import com.infotickets.android.MainActivity;
import com.google.gson.Gson;
import com.pack.networking.bean.Servicio;

import retrofit2.Response;

public class ServiceResponseHandler {
    private Gson gson = new Gson();

    public void procesServices(Response<String> response, MainActivity activity){
        String body = response.body().toString();
        Servicio[] result =  gson.fromJson(body,Servicio[].class);
        activity.setData(result);
    }
}