package com.example.jutom.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.sql.SQLClientInfoException;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentEigengewicht#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentEigengewicht extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private List<Fragment> uebungsFragments;
    private List<String> titles;
    UebungFragment brustFragment = null;
    UebungFragment beinFragment = null;
    UebungFragment rueckenFragment= null;
    UebungFragment obererRueckenFragment= null;
    UebungFragment schulterFragment= null;
    UebungFragment bicepFragment= null;
    UebungFragment tricepFragment= null;
    UebungFragment bauchFragment= null;
    UebungFragment untererRueckenFragment= null;
    Trainingsplaner trainingsplaner;
    int tpPosition;



    public FragmentEigengewicht() {
        // Required empty public constructor
    }
    public FragmentEigengewicht(Trainingsplaner tp, int pos) {
        // Required empty public constructor
        this.trainingsplaner=tp;
        this.tpPosition=pos;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentEigengewicht.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentEigengewicht newInstance(String param1, String param2) {
        FragmentEigengewicht fragment = new FragmentEigengewicht();
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
        titles= new ArrayList<String>();
        titles.add("Unterer Rücken");
        titles.add("Bauch");
        titles.add("Tricep");
        titles.add("Bicep");
        titles.add("Schulter");
        titles.add("Oberer Rücken");
        titles.add("Rücken");
        titles.add("Beine");
        titles.add("Brust");
        if(trainingsplaner!=null){
            Log.v("Get Training", "Trainings pla "+ trainingsplaner.getName());
        }

        uebungsFragments= new ArrayList<Fragment>();










        untererRueckenFragment= new UebungFragment();/*
        untererRueckenFragment.untererRueckenList=SQLHelper.getEigengewichtuntererRueckens();
        untererRueckenFragment.adapterName="UntererRuecken";
        untererRueckenFragment.listName="EigenUntererRuecken";
        untererRueckenFragment.tp=trainingsplaner;
        untererRueckenFragment.tpPosition=tpPosition;*/
        untererRueckenFragment.listName="Eigengewicht";
        untererRueckenFragment.adapterName="UntererRuecken";
        untererRueckenFragment.tpPosition=tpPosition;
        untererRueckenFragment.tp= trainingsplaner;

        bauchFragment = new UebungFragment();
/*        bauchFragment.bauchList=SQLHelper.getEigengewichtbauches();
        bauchFragment.adapterName="Bauch";
        bauchFragment.listName="EigenBauch";
        bauchFragment.tp=trainingsplaner;
        bauchFragment.tpPosition=tpPosition;*/
        bauchFragment.listName="Eigengewicht";
        bauchFragment.adapterName="Bauch";
        bauchFragment.tpPosition=tpPosition;
        bauchFragment.tp= trainingsplaner;

        tricepFragment = new UebungFragment();
 /*       tricepFragment.triceps=SQLHelper.getEigengewichttriceps();
        tricepFragment.adapterName="Tricep";
        tricepFragment.listName="EigenTricep";
        tricepFragment.tp=trainingsplaner;
        tricepFragment.tpPosition=tpPosition;*/
        tricepFragment.listName="Eigengewicht";
        tricepFragment.adapterName="Tricep";
        tricepFragment.tpPosition=tpPosition;
        tricepFragment.tp= trainingsplaner;

        bicepFragment = new UebungFragment();
/*        bicepFragment.bicepList=SQLHelper.getEigengewichtbiceps();
        bicepFragment.adapterName="Bicep";
        bicepFragment.listName="EigenBicep";
        bicepFragment.tp=trainingsplaner;
        bicepFragment.tpPosition=tpPosition;*/
        bicepFragment.listName="Eigengewicht";
        bicepFragment.adapterName="Bicep";
        bicepFragment.tpPosition=tpPosition;
        bicepFragment.tp= trainingsplaner;

        schulterFragment = new UebungFragment();
/*        schulterFragment.schulters=SQLHelper.getEigengewichtschulters();
        schulterFragment.adapterName="Schulter";
        schulterFragment.listName="EigenSchulter";
        schulterFragment.tp=trainingsplaner;
        schulterFragment.tpPosition=tpPosition;*/
        schulterFragment.listName="Eigengewicht";
        schulterFragment.adapterName="Schulter";
        schulterFragment.tpPosition=tpPosition;
        schulterFragment.tp= trainingsplaner;

        obererRueckenFragment = new UebungFragment();
/*        obererRueckenFragment.obererRueckens=SQLHelper.getEigengewichtobererRueckens();
        obererRueckenFragment.adapterName="ObererRuecken";
        obererRueckenFragment.listName="EigenObererRuecken";
        obererRueckenFragment.tp=trainingsplaner;
        obererRueckenFragment.tpPosition=tpPosition;*/
        obererRueckenFragment.listName="Eigengewicht";
        obererRueckenFragment.adapterName="ObererRuecken";
        obererRueckenFragment.tpPosition=tpPosition;
        obererRueckenFragment.tp= trainingsplaner;

        rueckenFragment = new UebungFragment();
/*        rueckenFragment.rueckens=SQLHelper.getEigengewichtrueckens();
        rueckenFragment.adapterName="Ruecken";
        rueckenFragment.listName="EigenRuecken";
        rueckenFragment.tp=trainingsplaner;
        rueckenFragment.tpPosition=tpPosition;*/
        rueckenFragment.listName="Eigengewicht";
        rueckenFragment.adapterName="Ruecken";
        rueckenFragment.tpPosition=tpPosition;
        rueckenFragment.tp= trainingsplaner;

        beinFragment= new UebungFragment();
/*        beinFragment.beineList=SQLHelper.getEigengewichtbeines();
        beinFragment.adapterName="Beine";
        beinFragment.listName="EigenBein";
        beinFragment.tp=trainingsplaner;
        beinFragment.tpPosition=tpPosition;*/
        beinFragment.listName="Eigengewicht";
        beinFragment.adapterName="Beine";
        beinFragment.tpPosition=tpPosition;
        beinFragment.tp= trainingsplaner;

        brustFragment = new UebungFragment();
/*        brustFragment.brusts=SQLHelper.getEigengewichtbrusts();
        brustFragment.adapterName="Brust";
        brustFragment.listName="EigenBrust";
        brustFragment.tp=trainingsplaner;
        brustFragment.tpPosition=tpPosition;*/
        brustFragment.listName="Eigengewicht";
        brustFragment.adapterName="Brust";
        brustFragment.tpPosition=tpPosition;
        brustFragment.tp= trainingsplaner;

        uebungsFragments.add(untererRueckenFragment);
        uebungsFragments.add(bauchFragment);
       uebungsFragments.add(tricepFragment);
       uebungsFragments.add(bicepFragment);
        uebungsFragments.add(schulterFragment);
        uebungsFragments.add(obererRueckenFragment);
uebungsFragments.add(rueckenFragment);
        uebungsFragments.add(beinFragment);
        uebungsFragments.add(brustFragment);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.fragment_fragment_eigengewicht, container, false);
        ViewPager vP= (ViewPager)v.findViewById(R.id.pagerEigengewicht);

        vP.setAdapter(new FragmentPager(getChildFragmentManager(),uebungsFragments,titles));
        return v;
    }

}
