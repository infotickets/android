package com.infotickets.android;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.infotickets.android.databinding.ActivitySelectSujectBinding;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;
import static com.facebook.FacebookSdk.getApplicationContext;

public class SelectSuject extends BaseAct {
    ActivitySelectSujectBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_select_suject);
        SpinnerAdap spinnerAdap = new SpinnerAdap(getApplicationContext());
        binding.spinner1.setAdapter(spinnerAdap);
        binding.spinner2.setAdapter(spinnerAdap);
        binding.spinner3.setAdapter(spinnerAdap);
        showDialog(true);
        new CountDownTimer(2000, 1000) {
            @Override
            public void onTick(long l) {
            }

            @Override
            public void onFinish() {
                showDialog(false);
            }
        }.start();

        binding.buttonPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),PayAct.class);
                startActivity(intent);
            }
        });

    }

    class SpinnerAdap extends BaseAdapter{
        LayoutInflater inflater;
        SpinnerAdap(Context ct) {
            inflater = (LayoutInflater) ct.getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return 30;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup){
            view = inflater.inflate(R.layout.list_item_days,null);
            ((TextView)view.findViewById(R.id.textView_item_day)).setText(""+i);
            return view;
        }
    }


}
