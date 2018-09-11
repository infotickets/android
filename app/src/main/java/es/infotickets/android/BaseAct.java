package es.infotickets.android;

import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import es.infotickets.android.R;

public class BaseAct  extends AppCompatActivity {

    private AlertDialog progressDialog;

    public void showDialog  (Boolean show) {
        if (progressDialog == null) {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
            LayoutInflater inflater = getLayoutInflater();
            View dialogView = inflater.inflate(es.infotickets.android.R.layout.progress_bar, null);
            dialogBuilder.setView(dialogView);
            progressDialog = dialogBuilder.create();
            progressDialog.setCancelable(false);
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            // progressDialog.getWindow().setBackgroundDrawableResource();
            //progressDialog.getWindow().setBackgroundDrawableResource();
        }
        if (show) {
            progressDialog.show();
        } else {
            progressDialog.dismiss();
        }
    }



}
