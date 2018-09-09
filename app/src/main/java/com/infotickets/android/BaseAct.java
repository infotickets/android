package com.infotickets.android;
import android.app.AlertDialog;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.graphics.drawable.ColorDrawable;

public class BaseAct  extends AppCompatActivity {

    private android.app.AlertDialog progressDialog;

    public void showDialog  (Boolean show) {
        if (progressDialog == null) {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
            LayoutInflater inflater = getLayoutInflater();
            View dialogView = inflater.inflate(R.layout.progress_bar, null);
            dialogBuilder.setView(dialogView);
            progressDialog = dialogBuilder.create();
            progressDialog.setCancelable(false);
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
