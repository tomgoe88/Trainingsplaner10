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
public class ListAdapterTrainingsplaner extends BaseAdapter {

    private List<Trainingsplaner> uebung;
    private Context context;
    private TextView tpName;
    private TextView uebungAnzahl;
    public ListAdapterTrainingsplaner(Context con, List<Trainingsplaner> ueb){
        this.context= con;
        this.uebung=ueb;

        Log.v("Adapter", "Adapter ist erstellt");
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
            v = vi.inflate(R.layout.list_item_trainingsplaner, null);
        }
        tpName= (TextView) v.findViewById(R.id.nameTrainingsplan);
        //uebungAnzahl= (TextView) v.findViewById(R.id.uebungenAnzahl);

        if(uebung.get(position).getName()!= null){
            tpName.setText(uebung.get(position).getName());
        }
        uebungAnzahl.setText(""+uebung.get(position).getAnzahlUebung());

        //Log.v("String",uebung.get(position).getImg() );

        return v;
    }
}
