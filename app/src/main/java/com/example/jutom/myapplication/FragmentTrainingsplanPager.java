package com.example.jutom.myapplication;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
//TODO hier muss der FragmentPager eingefügt werden und gleichzeitig ein ALERTDIALOH für die Auswahl welche neue Uebung hinzugefügt werden soll


public class FragmentTrainingsplanPager extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private List<Fragment> tpFragments;
    private List<String> titles;
    AlertDialog.Builder builder;
    AlertDialog.Builder auswahlUK;
    AlertDialog.Builder auswahlNeueUebung;
    AlertDialog.Builder auswahlNeueUebungUebungsart;
    int position;
    private Button neueUebung; //TODO hier müssen neue Übungen hinzugefügt werden
    private Trainingsplaner trainingsplaner;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public FragmentTrainingsplanPager(Trainingsplaner trainingsplaner) {
        // Required empty public constructor
        this.trainingsplaner= trainingsplaner;
    }


    // TODO: Rename and change types and number of parameters


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        tpFragments= new ArrayList<Fragment>();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_fragment_trainingsplan_pager, container, false);
        ViewPager vP= (ViewPager)v.findViewById(R.id.pagerTrainingeplaner);//TODO in dem Layout muss noch ein Pager eingefügt werden

        vP.setAdapter(new FragmentPager(getChildFragmentManager(),tpFragments,titles));
        for(Uebung u:trainingsplaner.getTpUebungen()){
            tpFragments.add(new FragmentTPUebung(u));//in diesem Fragment werden nur die Übungsdatenangezeigt
        }
        vP.setCurrentItem(tpFragments.size()-1);
        FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.fabNeueUebung);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder = new AlertDialog.Builder(getActivity());
                LayoutInflater inflaters = getActivity().getLayoutInflater();
                View theView = inflaters.inflate(R.layout.alert_neue_uebung, null);
                Button ueAusUk= (Button) theView.findViewById(R.id.uebungKatalog);
                Button neueUE= (Button) theView.findViewById(R.id.neueTPuebung);

                ueAusUk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        auswahlUK = new AlertDialog.Builder(getActivity());
                        LayoutInflater inflaters = getActivity().getLayoutInflater();
                        View theView = inflaters.inflate(R.layout.alert_uebung_aus_katalog, null);
                        Button eigen= (Button) theView.findViewById(R.id.uekatEigengewicht);
                        Button maschine= (Button) theView.findViewById(R.id.uekatMaschine);
                        Button funktionell= (Button) theView.findViewById(R.id.uekatFunktionelle);
                        Button freie= (Button) theView.findViewById(R.id.uekatFreieGewichte);

                        eigen.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                FragmentTransaction ft= getActivity().getSupportFragmentManager().beginTransaction();

                                ft.replace(R.id.traininsplanerlayout,new FragmentEigengewicht());
                                ft.commit();
                            }
                        });

                        maschine.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                FragmentTransaction ft= getActivity().getSupportFragmentManager().beginTransaction();

                                ft.replace(R.id.traininsplanerlayout,new FragmentMaschine());
                                ft.commit();
                            }
                        });

                        funktionell.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                FragmentTransaction ft= getActivity().getSupportFragmentManager().beginTransaction();

                                ft.replace(R.id.traininsplanerlayout,new FragmentFunktionell());
                                ft.commit();
                            }
                        });

                        freie.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                FragmentTransaction ft= getActivity().getSupportFragmentManager().beginTransaction();

                                ft.replace(R.id.traininsplanerlayout,new FragmentFreieGewichte());
                                ft.commit();
                            }
                        });

                        builder.show();
                    }
                });
                neueUE.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        auswahlNeueUebung = new AlertDialog.Builder(getActivity());
                        LayoutInflater inflaters = getActivity().getLayoutInflater();
                        View theView = inflaters.inflate(R.layout.alert_neue_uebung, null);





                        builder.show();
                    }
                });




                builder.show();
              //TODO, hier musst ein weiteres Fragment füt die neue Übung geöffnet werden  z.B NeueTPUebungFragment

            }
        });



        return v;

    }

}
