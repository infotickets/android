package es.infotickets.android;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ScannResultAct extends BaseAct {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scann_result);
        String data=getIntent().getExtras().getString("content");
        ((TextView)findViewById(R.id.content)).setText(data);

        if (!data.contains("http")){
            findViewById(R.id.table_result).setVisibility(View.GONE);
            ((TextView)findViewById(R.id.textview_title)).setText("Error de codigo");
        }
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
