package com.pack.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.pack.networking.bean.Compra;
import es.infotickets.android.R;

public class ResultAdapter extends BaseAdapter {

    Compra compra;
    LayoutInflater layoutInflater;
    public ResultAdapter(Compra compra, Context context) {
        this.compra=compra;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return compra.getLineas().length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.list_item_buy_result,null);
        ((TextView)convertView.findViewById(R.id.textView__item_price)).setText(compra.getLineas()[position].getPrecio());
        ((TextView)convertView.findViewById(R.id.textView_item_many)).setText(compra.getLineas()[position].getCantidad());
        ((TextView)convertView.findViewById(R.id.textView_item_name)).setText(compra.getLineas()[position].getNombre());
        return convertView;
    }
}
