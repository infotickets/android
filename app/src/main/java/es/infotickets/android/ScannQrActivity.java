package es.infotickets.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.pack.adapter.CameraPreview;

public class ScannQrActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scann_qr);

        System.loadLibrary("iconv");

        FrameLayout fm = (FrameLayout)findViewById(R.id.prev_screen);
        fm.addView(new CameraPreview(this));
    }
}
