package es.infotickets.android;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.pack.adapter.ResultAdapter;
import com.pack.networking.bean.Compra;
import com.pack.networking.handler.Response.ServiceResponseHandler;
import com.pack.networking.handler.ServiceHandler;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScannResultAct extends BaseAct {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scann_result);
        String data=getIntent().getExtras().getString("content");
        if (data!=null){
            ServiceHandler serviceHandler = new ServiceHandler(getApplication());
            GoogleSignInAccount account=GoogleSignIn.getLastSignedInAccount(getApplicationContext());
            serviceHandler.buy(account.getId(), data, new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if (response.code()==200){
                        Toast.makeText(getApplicationContext(),"Good!",Toast.LENGTH_LONG).show();
                        process(response);
                    }
                }
                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Toast.makeText(getApplicationContext(),"Failed with server!",Toast.LENGTH_LONG).show();
                }
            });
        }
    }
    private void process(Response<String> response){
        ServiceResponseHandler serviceResponseHandler = new ServiceResponseHandler();
        Compra compra = serviceResponseHandler.processBuy(response);
        ((TextView)findViewById(R.id.total_label)).setText(compra.getMonto());
        ResultAdapter resultAdapter = new ResultAdapter(compra,getApplicationContext());
        ((ListView)findViewById(R.id.listview)).setAdapter(resultAdapter);
    }
    public void accept(View v){
        showDialog(true);
        new CountDownTimer(2000, 1000) {
            @Override
            public void onTick(long l) {
            }
            @Override
            public void onFinish() {
                showDialog(false);
                Intent intent = new Intent(getApplicationContext(),BeforeMainActivity.class);
                startActivity(intent);
                finishAffinity();
            }
        }.start();
    }
}
