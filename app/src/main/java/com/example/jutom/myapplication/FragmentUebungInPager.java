package com.example.jutom.myapplication;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class FragmentUebungInPager extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Uebung uebung;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ListAdapterSatzKlassisch listAdapterSatzKlassisch;
    ListAdapterSatzZeit listAdapterSatzZeit;
    ImageView ueBild;


    public FragmentUebungInPager(Uebung uebung) {
        // Required empty public constructor
        this.uebung=uebung;

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        listAdapterSatzKlassisch= new ListAdapterSatzKlassisch(getActivity(), uebung.getSatzZeitList());
        listAdapterSatzZeit=new ListAdapterSatzZeit(getActivity(), uebung.getSatzList());
        View v= inflater.inflate(R.layout.fragment_fragment_uebung_in_pager, container, false);
        ListView klassischList= (ListView) v.findViewById(R.id.listSatzKlassisch);
       // ListView zeitList=(ListView)v.findViewById(R.id.listSazZeit);
        if(uebung.getSatzList().size()==0) {
            klassischList.setAdapter(listAdapterSatzKlassisch);
        } else {
            klassischList.setAdapter(listAdapterSatzZeit);
        }
        ueBild= (ImageView)v.findViewById(R.id.imagePagerUebung);
        setPic();
        TextView beschreibung= (TextView) v.findViewById(R.id.beschreibungPager);
        beschreibung.setText(uebung.getBeschreibung());


        return v;
    }
    private void setPic() {

        // Get the dimensions of the View


        Bitmap bitmap = BitmapFactory.decodeFile(uebung.getImg());
        Matrix matrix = new Matrix();

        matrix.postRotate(90);

        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap,600,600,true);

        Bitmap rotatedBitmap = Bitmap.createBitmap(scaledBitmap , 0, 0, scaledBitmap .getWidth(), scaledBitmap .getHeight(), matrix, true);

        //Bitmap bitmap = BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
        ueBild.setImageBitmap(rotatedBitmap);
    }

}
