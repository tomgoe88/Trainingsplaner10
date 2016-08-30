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
 * Use the {@link FragmentFreieGewichte#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentFreieGewichte extends Fragment {
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


    public FragmentFreieGewichte() {
        // Required empty public constructor
    }
    public FragmentFreieGewichte(Trainingsplaner trainingsplaner, int pos) {
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
     * @return A new instance of fragment FragmentFreieGewichte.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentFreieGewichte newInstance(String param1, String param2) {
        FragmentFreieGewichte fragment = new FragmentFreieGewichte();
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
        untererRueckenFragment.untererRueckenList=SQLHelper.getFreieuntererRueckens();
        untererRueckenFragment.adapterName="UntererRuecken";
        untererRueckenFragment.listName="FreieUntererRuecken";
        untererRueckenFragment.tp=trainingsplaner;
        untererRueckenFragment.tpPosition=tpPosition;

        bauchFragment = new UebungFragment();
        bauchFragment.bauchList=SQLHelper.getFreiebauches();
        bauchFragment.adapterName="Bauch";
        bauchFragment.listName="FreieBauch";
        bauchFragment.tp=trainingsplaner;
        bauchFragment.tpPosition=tpPosition;

        tricepFragment = new UebungFragment();
        tricepFragment.triceps=SQLHelper.getFreietriceps();
        tricepFragment.adapterName="Tricep";
        tricepFragment.listName="FreieTricep";
        tricepFragment.tp=trainingsplaner;
        tricepFragment.tpPosition=tpPosition;

        bicepFragment = new UebungFragment();
        bicepFragment.bicepList=SQLHelper.getFreiebiceps();
        bicepFragment.adapterName="Bicep";
        bicepFragment.listName="FreieBicep";
        bicepFragment.tp=trainingsplaner;
        bicepFragment.tpPosition=tpPosition;

        schulterFragment = new UebungFragment();
        schulterFragment.schulters=SQLHelper.getFreieschulters();
        schulterFragment.adapterName="Schulter";
        schulterFragment.listName="FreieSchulter";
        schulterFragment.tp=trainingsplaner;
        schulterFragment.tpPosition=tpPosition;

        obererRueckenFragment = new UebungFragment();
        obererRueckenFragment.obererRueckens=SQLHelper.getFreieobererRueckens();
        obererRueckenFragment.adapterName="ObererRuecken";
        obererRueckenFragment.listName="FreieObererRuecken";
        obererRueckenFragment.tp=trainingsplaner;
        obererRueckenFragment.tpPosition=tpPosition;

        rueckenFragment = new UebungFragment();
        rueckenFragment.rueckens=SQLHelper.getFreierueckens();
        rueckenFragment.adapterName="Ruecken";
        rueckenFragment.listName="FreieRuecken";
        rueckenFragment.tp=trainingsplaner;
        rueckenFragment.tpPosition=tpPosition;

        beinFragment= new UebungFragment();
        beinFragment.beineList=SQLHelper.getFreiebeines();
        beinFragment.adapterName="Beine";
        beinFragment.listName="FreieBein";
        beinFragment.tp=trainingsplaner;
        beinFragment.tpPosition=tpPosition;

        brustFragment = new UebungFragment();
        brustFragment.brusts=SQLHelper.getFreiebrusts();
        brustFragment.adapterName="Brust";
        brustFragment.listName="FreieBrust";
        brustFragment.tp=trainingsplaner;
        brustFragment.tpPosition=tpPosition;

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
        View v= inflater.inflate(R.layout.fragment_fragment_freie_gewichte, container, false);
        ViewPager vP= (ViewPager)v.findViewById(R.id.pagerFreieGewichte);

        vP.setAdapter(new FragmentPager(getChildFragmentManager(),uebungsFragments,titles));
        return v;
    }

}
