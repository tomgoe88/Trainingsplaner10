package com.example.jutom.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentFunktionell#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentFunktionell extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private List<Fragment> uebungsFragments;
   private List<String>titles;
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

    public FragmentFunktionell() {
        // Required empty public constructor
    }
    public FragmentFunktionell(Trainingsplaner trainingsplaner, int pos) {
        // Required empty public constructor
        this.trainingsplaner=trainingsplaner;
        this.tpPosition=pos;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentFunktionell.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentFunktionell newInstance(String param1, String param2) {
        FragmentFunktionell fragment = new FragmentFunktionell();
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

        uebungsFragments= new ArrayList<Fragment>();


        untererRueckenFragment= new UebungFragment();

        untererRueckenFragment.listName="Funktionell";
        untererRueckenFragment.adapterName="UntererRuecken";

        bauchFragment = new UebungFragment();

        bauchFragment.listName="Funktionell";
        bauchFragment.adapterName="Bauch";

        tricepFragment = new UebungFragment();

        tricepFragment.listName="Funktionell";
        tricepFragment.adapterName="Tricep";

        bicepFragment = new UebungFragment();

        bicepFragment.listName="Funktionell";
        bicepFragment.adapterName="Bicep";

        schulterFragment = new UebungFragment();

        schulterFragment.listName="Funktionell";
        schulterFragment.adapterName="Schulter";

        obererRueckenFragment = new UebungFragment();

        obererRueckenFragment.listName="Funktionell";
        obererRueckenFragment.adapterName="ObererRuecken";

        rueckenFragment = new UebungFragment();

        rueckenFragment.listName="Funktionell";
        rueckenFragment.adapterName="Ruecken";

        beinFragment= new UebungFragment();

        beinFragment.listName="Funktionell";
        beinFragment.adapterName="Beine";

        brustFragment = new UebungFragment();

        brustFragment.listName="Funktionell";
        brustFragment.adapterName="Brust";








/*        untererRueckenFragment= new UebungFragment();
        untererRueckenFragment.untererRueckenList=SQLHelper.getFunktionelluntererRueckens();
        untererRueckenFragment.adapterName="UntererRuecken";
        untererRueckenFragment.listName="FunktionallUntererRuecken";
        untererRueckenFragment.tp=trainingsplaner;
        untererRueckenFragment.tpPosition=tpPosition;

        bauchFragment = new UebungFragment();
        bauchFragment.bauchList=SQLHelper.getFunktionellbauches();
        bauchFragment.adapterName="Bauch";
        bauchFragment.listName="FunktionellBauch";
        bauchFragment.tp=trainingsplaner;
        bauchFragment.tpPosition=tpPosition;

        tricepFragment = new UebungFragment();
        tricepFragment.triceps=SQLHelper.getFunktionelltriceps();
        tricepFragment.adapterName="Tricep";
        tricepFragment.listName="FunktionellTricep";
        tricepFragment.tp=trainingsplaner;
        tricepFragment.tpPosition=tpPosition;

        bicepFragment = new UebungFragment();
        bicepFragment.bicepList=SQLHelper.getFunktionellbiceps();
        bicepFragment.adapterName="Bicep";
        bicepFragment.listName="FunktionellBicep";
        bicepFragment.tp=trainingsplaner;
        bicepFragment.tpPosition=tpPosition;

        schulterFragment = new UebungFragment();
        schulterFragment.schulters=SQLHelper.getFunktionellschulters();
        schulterFragment.adapterName="Schulter";
        schulterFragment.listName="FunktionellSchulter";
        schulterFragment.tp=trainingsplaner;
        schulterFragment.tpPosition=tpPosition;

        obererRueckenFragment = new UebungFragment();
        obererRueckenFragment.obererRueckens=SQLHelper.getFunktionellobererRueckens();
        obererRueckenFragment.adapterName="ObererRuecken";
        obererRueckenFragment.listName="FunktionellObererRuecken";
        obererRueckenFragment.tp=trainingsplaner;
        obererRueckenFragment.tpPosition=tpPosition;

        rueckenFragment = new UebungFragment();
        rueckenFragment.rueckens=SQLHelper.getFunktionellrueckens();
        rueckenFragment.adapterName="Ruecken";
        rueckenFragment.listName="FunktionellRuecken";
        rueckenFragment.tp=trainingsplaner;
        rueckenFragment.tpPosition=tpPosition;

        beinFragment= new UebungFragment();
        beinFragment.beineList=SQLHelper.getFunktionellbeines();
        beinFragment.adapterName="Beine";
        beinFragment.listName="FunktionellBein";
        beinFragment.tp=trainingsplaner;
        beinFragment.tpPosition=tpPosition;

        brustFragment = new UebungFragment();
        brustFragment.brusts=SQLHelper.getFunktionellbrusts();
        brustFragment.adapterName="Brust";
        brustFragment.listName="FunktionellBrust";
        brustFragment.tp=trainingsplaner;
        brustFragment.tpPosition=tpPosition;*/


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
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_fragment_funktionell, container, false);
        ViewPager vP= (ViewPager)v.findViewById(R.id.pagerFunktionell);

        vP.setAdapter(new FragmentPager(getChildFragmentManager(),uebungsFragments,titles));
        return v;
    }

}
