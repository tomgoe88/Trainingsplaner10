package com.example.jutom.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jutom on 30.08.2016.
 */
public class ListAdapterSatzZeit extends BaseAdapter {

    private List<Satz> uebung;
    private Context context;
    private TextView tpName;
    private TextView pause;
    private TextView pos;
    public ListAdapterSatzZeit(Context con, List<Satz> ueb){
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
            v = vi.inflate(R.layout.item_satz_zeit, null);
        }
        tpName= (TextView) v.findViewById(R.id.txtIntervall);
        pause= (TextView) v.findViewById(R.id.txtPause);
        pos= (TextView) v.findViewById(R.id.txtPosition);

        pos.setText(""+position+1);
        tpName.setText(""+String.format("%d:%02d",
                TimeUnit.MILLISECONDS.toMinutes( uebung.get(position).getBelastungsIntervall()*1000),
                TimeUnit.MILLISECONDS.toSeconds(uebung.get(position).getBelastungsIntervall()*1000) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(uebung.get(position).getBelastungsIntervall()*1000))));
               pause.setText(""+String.format("%d:%02d",
                       TimeUnit.MILLISECONDS.toMinutes( uebung.get(position).getPause()*1000),
                       TimeUnit.MILLISECONDS.toSeconds(uebung.get(position).getPause()*1000) -
                               TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(uebung.get(position).getPause()*1000))));

        //Log.v("String",uebung.get(position).getImg() );

        return v;
    }
}
