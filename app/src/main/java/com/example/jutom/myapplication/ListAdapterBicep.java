package com.example.jutom.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Jutom on 28.06.2016.
 */
public class ListAdapterBicep extends BaseAdapter {

    private List<Bicep> uebung;
    private Context context;
    Trainingsplaner trainingsplaner;
    public ListAdapterBicep(Context con, List<Bicep> ueb, Trainingsplaner trainingsplaner){
        this.context= con;
        this.uebung=ueb;
        this.trainingsplaner= trainingsplaner;
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
        ImageView ueBild= (ImageView)v.findViewById((R.id.uebungBild));
        if(nameUebung!=null){
            nameUebung.setText(uebung.get(position).getName());
        }
        //Log.v("String",uebung.get(position).getImg() );
        if(ueBild!=null&& uebung.get(position).getImg()!=null){
            int targetW = 80;
            int targetH = 80;

            // Get the dimensions of the bitmap
            BitmapFactory.Options bmOptions = new BitmapFactory.Options();
            bmOptions.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(uebung.get(position).getImg(), bmOptions);
            int photoW = bmOptions.outWidth;
            int photoH = bmOptions.outHeight;

            // Determine how much to scale down the image
            int scaleFactor = Math.min(photoW/targetW, photoH/targetH);

            // Decode the image file into a Bitmap sized to fill the View
            bmOptions.inJustDecodeBounds = false;
            bmOptions.inSampleSize = scaleFactor;
            bmOptions.inPurgeable = true;

            Bitmap bitmap = BitmapFactory.decodeFile(uebung.get(position).getImg(), bmOptions);
            ueBild.setImageBitmap(bitmap);
        }
        return v;
    }
}
