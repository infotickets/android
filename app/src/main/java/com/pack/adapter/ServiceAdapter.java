package com.pack.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.infotickets.android.R;
import com.pack.networking.bean.Servicio;

public class ServiceAdapter extends BaseAdapter {

    LayoutInflater inflater;
    Servicio[] result;

    public ServiceAdapter(Context context, Servicio[] result) {
        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.result = result;
    }

    @Override
    public int getCount() {
        return result.length;
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.list_item_service,null);
        TextView textView = (TextView)view.findViewById(R.id.textView_item_service_name);
        //TextView textView2 = (TextView)view.findViewById(R.id.textView_item_service_provider);
        textView.setText(result[i].getNb_servicio());
        //textView2.setText(result[i].getNb_empresa());
        return view;
    }
}