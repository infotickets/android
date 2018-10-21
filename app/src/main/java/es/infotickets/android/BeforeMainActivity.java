package es.infotickets.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BeforeMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_main);
        findViewById(R.id.button_go_buy).setOnClickListener(onClickListener);
        findViewById(R.id.button_go_lista).setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId()==R.id.button_go_buy){
                Intent intent = new Intent(getApplicationContext(),ScannQrActivity.class);
                startActivity(intent);
            }
            if (view.getId()==R.id.button_go_lista){
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        }
    };
}
