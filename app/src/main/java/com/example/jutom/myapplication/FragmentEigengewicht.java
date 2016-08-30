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



    public FragmentEigengewicht() {
        // Required empty public constructor
    }
    public FragmentEigengewicht(Trainingsplaner tp) {
        // Required empty public constructor
        this.trainingsplaner=tp;
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
        untererRueckenFragment= new UebungFragment("UntererRuecken","EigenUntererRuecken",trainingsplaner,SQLHelper.getEigengewichtuntererRueckens());
        bauchFragment = new UebungFragment("Bauch","EigenBauch",trainingsplaner,SQLHelper.getEigengewichtbauches());
        tricepFragment = new UebungFragment("Tricep","EigenTricep",trainingsplaner,SQLHelper.getEigengewichttriceps());
        bicepFragment = new UebungFragment("Bicep","EigenBicep", trainingsplaner, SQLHelper.getEigengewichtbiceps());
        schulterFragment = new UebungFragment("Schulter","EigenSchulter", trainingsplaner, SQLHelper.getEigengewichtschulters());
        obererRueckenFragment = new UebungFragment("ObererRuecken","EigenObererRuecken", trainingsplaner,SQLHelper.getEigengewichtobererRueckens());
        rueckenFragment = new UebungFragment("Ruecken","EigenRuecken", trainingsplaner, SQLHelper.getEigengewichtrueckens());
        beinFragment= new UebungFragment("Beine","EigenBein", trainingsplaner, SQLHelper.getEigengewichtbeines());
        brustFragment = new UebungFragment("Brust","EigenBrust", trainingsplaner,SQLHelper.getEigengewichtbrusts());
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
