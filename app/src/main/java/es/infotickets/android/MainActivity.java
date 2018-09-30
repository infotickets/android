package es.infotickets.android;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import es.infotickets.android.R;
import com.pack.adapter.ServiceAdapter;
import com.pack.networking.bean.Servicio;
import com.pack.networking.handler.Response.ServiceResponseHandler;
import com.pack.networking.handler.ServiceHandler;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseAct {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showDialog(true);
        ServiceHandler serviceHandler = new ServiceHandler(this);
        serviceHandler.getService(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                showDialog(false);
                ServiceResponseHandler responseHandler = new ServiceResponseHandler();
                responseHandler.procesServices(response, MainActivity.this);
                Log.d("","");
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("","");
                showDialog(false);

            }
        });

        Log.d("","");
    }

    public void setData(Servicio[] result){
        Log.d("","");
        GridView gridView = (GridView) findViewById(R.id.grid);
        ServiceAdapter adapter = new ServiceAdapter(this,result);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
              /*  Data.setIndexActual(i);
                if(Data.getServicioActual().getCaDias()>1){
                    Intent intent=new Intent(getApplicationContext(),SelectSuject.class);
                    startActivity(intent);
                }esle{
                    Intent intent=new Intent(getApplicationContext(),SelectSuject.class);
                    startActivity(intent);
                }*/
            }
        });
    }
}
