package com.example.jutom.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class FragmentTPUebung extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Trainingsplaner trainingsplaner;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Uebung uebung;


    public FragmentTPUebung(Uebung uebung, Trainingsplaner trainingsplaner) {
        // Required empty public constructor
        this.uebung=uebung; //durch diese Referenzu werden die einzelen Parameter der Übung angezeigt
        this.trainingsplaner=trainingsplaner; //dieser Traingsplaner muss mitgegeben werden, wenn das FragmentTrainingsplanPager aufgerufen wird
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
        return inflater.inflate(R.layout.fragment_fragment_tpuebung, container, false);
    }

}
