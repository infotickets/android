package es.infotickets.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
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

        Toolbar toolbar=findViewById(R.id.my_toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);



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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.action_bar,menu);
        return true;
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        //return super.onMenuOpened(featureId, menu);
        Intent intent = new Intent(getApplicationContext(),OptionAct.class);
        startActivity(intent);
        closeOptionsMenu();
        return true;
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
