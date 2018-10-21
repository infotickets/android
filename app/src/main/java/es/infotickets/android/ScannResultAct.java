package es.infotickets.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ScannResultAct extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scann_result);
        String data=getIntent().getExtras().getString("content");
        ((TextView)findViewById(R.id.content)).setText(data);
    }
}
