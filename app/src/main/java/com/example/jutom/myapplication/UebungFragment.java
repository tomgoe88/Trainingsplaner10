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
    private UebungListAdapter uebungListAdapter;
    private ListAdapterBauch listAdapterBauch= null;
    private ListAdapterBeine listAdapterBeine= null;
    private ListAdapterTricep listAdapterTricep= null;
    private ListAdapterBicep listAdapterBicep= null;
    private ListAdapterBrust listAdapterBrust= null;
    private ListAdapterObererRuecken listAdapterObererRuecken= null;
    private ListAdapterSchulter listAdapterSchulter= null;
    private ListAdapterRuecken listAdapterRuecken= null;
    private String listName;
    private Trainingsplaner tp;


    private List<Uebung> uebungList;

    public UebungFragment() {
        // Required empty public constructor
    }
    public UebungFragment( UebungListAdapter uA, String list){
        this.listName=list;
        this.uebungListAdapter=uA;
    }
    public UebungFragment( ListAdapterBrust uA, String list){
        this.listName=list;
        this.listAdapterBrust=uA;
    }
    public UebungFragment( ListAdapterRuecken uA, String list){
        this.listName=list;
        this.listAdapterRuecken=uA;
    }
    public UebungFragment( ListAdapterSchulter uA, String list){
        this.listName=list;
        this.listAdapterSchulter=uA;
    }
    public UebungFragment( ListAdapterObererRuecken uA, String list){
        this.listName=list;
        this.listAdapterObererRuecken=uA;
    }
    public UebungFragment( ListAdapterBauch uA, String list){
        this.listName=list;
        this.listAdapterBauch=uA;
    }
    public UebungFragment( ListAdapterBeine uA, String list){
        this.listName=list;
        this.listAdapterBeine=uA;
    }
    public UebungFragment( ListAdapterBicep uA, String list){
        this.listName=list;
        this.listAdapterBicep=uA;
    }
    public UebungFragment( ListAdapterTricep uA, String list){
        this.listName=list;
        this.listAdapterTricep=uA;
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
        if (uebungListAdapter!= null){
            listView.setAdapter(uebungListAdapter);
            tp= uebungListAdapter.trainingsplaner;
            uebungList.addAll(uebungListAdapter.uebung);
            }
       else if (listAdapterBrust!= null){
            listView.setAdapter(listAdapterBrust);
            tp= listAdapterBrust.trainingsplaner;
            uebungList.addAll(listAdapterBrust.uebung);
        }
       else if (listAdapterTricep!= null){
           listView.setAdapter(listAdapterTricep);
            tp= listAdapterTricep.trainingsplaner;
            uebungList.addAll(listAdapterTricep.uebung);
            }
       else if (listAdapterBeine!= null){
            listView.setAdapter(listAdapterBeine);
            tp= listAdapterBeine.trainingsplaner;
            uebungList.addAll(listAdapterBeine.uebung);
            }
       else if (listAdapterBauch!= null){
            listView.setAdapter(listAdapterBauch);
            tp= listAdapterBauch.trainingsplaner;
            uebungList.addAll(listAdapterBauch.uebung);
            }
       else if (listAdapterObererRuecken!= null){
            listView.setAdapter(listAdapterObererRuecken);
            tp= listAdapterObererRuecken.trainingsplaner;
            uebungList.addAll(listAdapterObererRuecken.uebung);
            }
        else if (listAdapterSchulter!= null){
            listView.setAdapter(listAdapterSchulter);
            tp= listAdapterSchulter.trainingsplaner;
            uebungList.addAll(listAdapterSchulter.uebung);
            }
       else if (listAdapterBicep!= null){
            listView.setAdapter(listAdapterBicep);
            tp= listAdapterBicep.trainingsplaner;
            uebungList.addAll(listAdapterBicep.uebung);
            }
      else if (listAdapterRuecken!= null){
            listView.setAdapter(listAdapterRuecken);
            tp= listAdapterRuecken.trainingsplaner;
            uebungList.addAll(listAdapterRuecken.uebung);
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
