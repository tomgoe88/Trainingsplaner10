package com.example.jutom.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UebungFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UebungFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private String listName;
    private Trainingsplaner tp;
    private String adapterName;

    UebungListAdapter uebungListAdapter;
    ListAdapterBauch listAdapterBauch;
    ListAdapterBeine listAdapterBeine;
    ListAdapterBicep listAdapterBicep;
    ListAdapterBrust listAdapterBrust;
    ListAdapterObererRuecken listAdapterObererRuecken;
    ListAdapterRuecken listAdapterRuecken;
    ListAdapterSchulter listAdapterSchulter;
    ListAdapterTricep listAdapterTricep;

    List<UntererRuecken>untererRueckenList;
    List<Bauch> bauchList;
    List<Beine>beineList;
    List<Bicep>bicepList;
    List<Brust>brusts;
    List<ObererRuecken>obererRueckens;
    List<Ruecken>rueckens;
    List<Schulter>schulters;
    List<Tricep>triceps;



    private List<Uebung> uebungList;

    public UebungFragment() {
        // Required empty public constructor
    }
    public UebungFragment( String uA, String list, Trainingsplaner tp, List<UntererRuecken>uR){
        this.listName=list;
        this.adapterName=uA;
        this.tp=tp;
        this.untererRueckenList=uR;
    }
    public UebungFragment( String uA, String list, Trainingsplaner tp, List<Bauch>uR){
        this.listName=list;
        this.adapterName=uA;
        this.tp=tp;
        this.bauchList=uR;
    }
    public UebungFragment( String uA, String list, Trainingsplaner tp, List<Beine>uR){
        this.listName=list;
        this.adapterName=uA;
        this.tp=tp;
        this.beineList=uR;
    }
    public UebungFragment( String uA, String list, Trainingsplaner tp, List<Bicep>uR){
        this.listName=list;
        this.adapterName=uA;
        this.tp=tp;
        this.bicepList=uR;
    }
    public UebungFragment( String uA, String list, Trainingsplaner tp, List<Brust>uR){
        this.listName=list;
        this.adapterName=uA;
        this.tp=tp;
        this.brusts=uR;
    }
    public UebungFragment( String uA, String list, Trainingsplaner tp, List<ObererRuecken>uR){
        this.listName=list;
        this.adapterName=uA;
        this.tp=tp;
        this.obererRueckens=uR;
    }
    public UebungFragment( String uA, String list, Trainingsplaner tp, List<Ruecken>uR){
        this.listName=list;
        this.adapterName=uA;
        this.tp=tp;
        this.rueckens=uR;
    }
    public UebungFragment( String uA, String list, Trainingsplaner tp, List<Schulter>uR){
        this.listName=list;
        this.adapterName=uA;
        this.tp=tp;
        this.schulters=uR;
    }
    public UebungFragment( String uA, String list, Trainingsplaner tp, List<Tricep>uR){
        this.listName=list;
        this.adapterName=uA;
        this.tp=tp;
        this.triceps=uR;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UebungFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UebungFragment newInstance(String param1, String param2) {
        UebungFragment fragment = new UebungFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }
//das muss neu gemacht werden jeder Adapter braucht sein eigenes Fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.uebung_fragment, container, false);
        final ListView listView= (ListView)v.findViewById(R.id.uebungList);
        switch(adapterName){
            case("UntererRuecken"):
                uebungListAdapter= new UebungListAdapter(getActivity(),,tp);


        }

        //TODO hier muss noch ein Button bearbeitet werden hier muss auch die oben darrgestellte IF-Anweisung eingebracht werden um die neue Übung zu öffnen
        //TODO um welche übung es sich handelt sollte über einen String übergeben werden in den Konstruktor
        FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("StringList", "List= " +listName);
                Intent neueUebung=new Intent (getActivity(), ActivityNeueUebung.class);
                Bundle neu= new Bundle();
                neu.putString("LIST", listName);
                neueUebung.putExtra("LISTBUNDLE", neu);
                startActivity(neueUebung);

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.v("OnItem", "On item is clicked at postion "+position +" with tp = "+ tp.toString() );
                if(tp!= null){
                    FragmentTransaction ft= getActivity().getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.traininsplanerlayout,new FragmentTPUebung(uebungList.get(position),tp));
                    ft.commit();
                }
            }
        });
        return v;
    }

}
