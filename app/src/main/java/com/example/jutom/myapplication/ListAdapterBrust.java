package com.example.jutom.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Jutom on 28.06.2016.
 */
public class ListAdapterBrust extends BaseAdapter {

    private List<Brust> uebung;
    private Context context;
    public ListAdapterBrust(Context con, List<Brust> ueb){
        this.context= con;
        this.uebung=ueb;
    }

    @Override
    public int getCount() {
        return uebung.size();
    }

    @Override
    public Object getItem(int position) {
        return uebung.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(context);
            v = vi.inflate(R.layout.uebung_adapter_list_layout, null);
        }
        TextView nameUebung= (TextView) v.findViewById(R.id.uebungName);
        if(nameUebung!=null){
            nameUebung.setText(uebung.get(position).getName());
        }
        return v;
    }
}
