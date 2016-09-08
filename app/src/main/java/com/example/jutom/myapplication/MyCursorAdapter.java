package com.example.jutom.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Jutom on 02.09.2016.
 */
public class MyCursorAdapter extends CursorAdapter {
    View v;
    public MyCursorAdapter(Context context, Cursor c) {
        super(context, c, true);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(context);
            v = vi.inflate(R.layout.uebung_adapter_list_layout, null);
        }
        return v;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView nameUebung= (TextView) v.findViewById(R.id.uebungName);
        ImageView ueBild= (ImageView)v.findViewById((R.id.uebungBild));
        if(nameUebung!=null){
            nameUebung.setText(cursor.getString(cursor.getColumnIndex("uebungsname")));
        }
        //Log.v("String",uebung.get(position).getImg() );
        if(ueBild!=null&& cursor.getString(cursor.getColumnIndex("uebungsbild")) !=null){
            int targetW = 80;
            int targetH = 80;

            // Get the dimensions of the bitmap
            BitmapFactory.Options bmOptions = new BitmapFactory.Options();
            bmOptions.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(cursor.getString(cursor.getColumnIndex("uebungsbild")), bmOptions);
            int photoW = bmOptions.outWidth;
            int photoH = bmOptions.outHeight;

            // Determine how much to scale down the image
            int scaleFactor = Math.min(photoW/targetW, photoH/targetH);

            // Decode the image file into a Bitmap sized to fill the View
            bmOptions.inJustDecodeBounds = false;
            bmOptions.inSampleSize = scaleFactor;
            bmOptions.inPurgeable = true;

            Bitmap bitmap = BitmapFactory.decodeFile(cursor.getString(cursor.getColumnIndex("uebungsbild")), bmOptions);
            ueBild.setImageBitmap(bitmap);
        }
    }
}
