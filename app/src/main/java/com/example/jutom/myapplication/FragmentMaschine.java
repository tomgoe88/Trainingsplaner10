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
 * Use the {@link FragmentMaschine#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentMaschine extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private List<Fragment> uebungsFragments;
    private List<String> titles;
    //private String[] titles= {"Unterer Rücken", "Bauch", "Tricep", "Bicep", "Schulter", "Oberer Rücken", "Rücken", "Beine", "Brust"};
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

    public FragmentMaschine() {
        // Required empty public constructor
    }
    public FragmentMaschine(Trainingsplaner trainingsplaner) {
        // Required empty public constructor
        this.trainingsplaner=trainingsplaner;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentMaschine.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentMaschine newInstance(String param1, String param2) {
        FragmentMaschine fragment = new FragmentMaschine();
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
        untererRueckenFragment= new UebungFragment(new UebungListAdapter(this.getActivity(),SQLHelper.getMaschineuntererRueckens(),trainingsplaner),"MaschineUntererRuecken");
        bauchFragment = new UebungFragment(new ListAdapterBauch(this.getActivity(),SQLHelper.getMaschinebauches(),trainingsplaner),"MaschineBauch");
        tricepFragment = new UebungFragment(new ListAdapterTricep(this.getActivity(),SQLHelper.getMaschinetriceps(),trainingsplaner),"MaschineTricep");
        bicepFragment = new UebungFragment(new ListAdapterBicep(this.getActivity(),SQLHelper.getMaschinebiceps(),trainingsplaner),"MaschineBicep");
        schulterFragment = new UebungFragment(new ListAdapterSchulter(this.getActivity(),SQLHelper.getMaschineschulters(),trainingsplaner),"MaschineSchulter");
        obererRueckenFragment = new UebungFragment(new ListAdapterObererRuecken(this.getActivity(),SQLHelper.getMaschineobererRueckens(),trainingsplaner),"MaschineObererRuecken");
        rueckenFragment = new UebungFragment(new ListAdapterRuecken(this.getActivity(),SQLHelper.getMaschinerueckens(),trainingsplaner),"MaschineRuecken");
        beinFragment= new UebungFragment(new ListAdapterBeine(this.getActivity(),SQLHelper.getMaschinebeines(),trainingsplaner),"MaschineBein");
        brustFragment = new UebungFragment(new ListAdapterBrust(this.getActivity(),SQLHelper.getMaschinebrusts(),trainingsplaner),"MaschineBrust");
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
        View v= inflater.inflate(R.layout.fragment_fragment_maschine, container, false);
        ViewPager vP= (ViewPager)v.findViewById(R.id.pagerMaschine);

        vP.setAdapter(new FragmentPager(getChildFragmentManager(),uebungsFragments,titles));
        return v;
    }

}
