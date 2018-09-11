package com.pack.networking.handler;

import android.content.Context;

import es.infotickets.android.R;
import com.pack.networking.RetroBase;
import com.pack.networking.interfaz.Interfaz;

import retrofit2.Callback;

public class ServiceHandler {
    private RetroBase retro;

    public ServiceHandler(Context ctx) {
        this.retro = new RetroBase(ctx.getString(R.string.baseUrl));
    }

    public void getService(Callback<String> call){
        Interfaz service  = retro.obj.create(Interfaz.class);
        service.getServicios().enqueue(call);
    }
}
