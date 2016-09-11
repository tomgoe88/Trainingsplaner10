package com.example.jutom.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jutom on 02.09.2016.
 */
public class MyCusrorAdapterTrainingsplan extends CursorAdapter {
    View v;
    List<String> tpIDString= new ArrayList<String>();
    int tpID;
    public MyCusrorAdapterTrainingsplan(Context context, Cursor c) {
        super(context, c, FLAG_REGISTER_CONTENT_OBSERVER);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {



        return LayoutInflater.from(context).inflate(R.layout.list_item_trainingsplaner, parent, false);
    }

    @Override
    public void bindView(View v, Context context, Cursor cursor) {

        //Log.v("Cursor Test", " Wert ist: "+ cursor.getString(cursor.getColumnIndex("uebungsname")) );
        ViewHolder holder= new ViewHolder();

        holder.tpName= (TextView) v.findViewById(R.id.nameTrainingsplan);
        //holder.uebungAnzahl= (TextView) v.findViewById(R.id.uebungenAnzahl);
        int id=cursor.getInt(cursor.getColumnIndex("_id"));
        tpIDString.add(""+id);

        if(holder.tpName!= null){
            holder.tpName.setText(cursor.getString(cursor.getColumnIndex("trainingsplanname")));
        }
       // uebungAnzahl.setText(""+uebung.get(position).getAnzahlUebung());




    }
    public class ViewHolder{
        TextView tpName;
        TextView uebungsAnzahl;
        int tpID;

    }
}
