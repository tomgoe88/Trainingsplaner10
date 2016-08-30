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

import java.util.ArrayList;
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

     String listName;
     Trainingsplaner tp;
     String adapterName;

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

    int tpPosition;



    private List<Uebung> uebungList;

    public UebungFragment() {
        // Required empty public constructor
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
        uebungList= new ArrayList<Uebung>();

        switch(adapterName){
            case("UntererRuecken"):
                uebungListAdapter= new UebungListAdapter(getActivity(),untererRueckenList,tp);
                listView.setAdapter(uebungListAdapter);
                if(untererRueckenList!= null){
                    uebungList.addAll(untererRueckenList);
                }

                break;
            case("Bauch"):
                listAdapterBauch= new ListAdapterBauch(getActivity(),bauchList,tp);
                listView.setAdapter(listAdapterBauch);
                if(bauchList!= null){
                    uebungList.addAll(bauchList);
                }
                break;
            case("Tricep"):
                listAdapterTricep= new ListAdapterTricep(getActivity(),triceps,tp);
                listView.setAdapter(listAdapterTricep);
                if(triceps!= null){
                    uebungList.addAll(triceps);
                }
                break;
            case("Bicep"):
                listAdapterBicep= new ListAdapterBicep(getActivity(),bicepList,tp);
                listView.setAdapter(listAdapterBicep);
                if(bicepList!= null){
                    uebungList.addAll(bicepList);
                }
                break;
            case("Schulter"):
                listAdapterSchulter= new ListAdapterSchulter(getActivity(),schulters,tp);
                listView.setAdapter(listAdapterSchulter);
                if(schulters!= null){
                    uebungList.addAll(schulters);
                }
                break;
            case("ObererRuecken"):
                listAdapterObererRuecken= new ListAdapterObererRuecken(getActivity(),obererRueckens,tp);
                listView.setAdapter(listAdapterObererRuecken);
                if(obererRueckens!= null){
                    uebungList.addAll(obererRueckens);
                }
                break;
            case("Ruecken"):
                listAdapterRuecken= new ListAdapterRuecken(getActivity(),rueckens,tp);
                listView.setAdapter(listAdapterRuecken);
                if(rueckens!= null){
                    uebungList.addAll(rueckens);
                }
                break;
            case("Beine"):
                listAdapterBeine= new ListAdapterBeine(getActivity(),beineList,tp);
                listView.setAdapter(listAdapterBeine);
                if(beineList!= null){
                    uebungList.addAll(beineList);
                }
                break;
            case("Brust"):
                listAdapterBrust= new ListAdapterBrust(getActivity(),brusts,tp);
                listView.setAdapter(listAdapterBrust);
                if(brusts!= null){
                    uebungList.addAll(brusts);
                }
                break;



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
             //   Log.v("OnItem", "On item is clicked at postion "+position +" with tp = "+ tp.toString() );
                if(tp!= null){
                    FragmentTransaction ft= getActivity().getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.traininsplanerlayout,new FragmentTPUebung(uebungList.get(position),tp, tpPosition));
                    ft.commit();
                }
            }
        });
        return v;
    }

}
