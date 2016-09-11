package com.example.jutom.myapplication;


import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
    int tpPosition;
    Button neueUebungErstellen;
    Button uebungAusKatalog;


    public FragmentTrainingsplanPager(int position) {
        // Required empty public constructor
        this.trainingsplaner= trainingsplaner;
        this.tpPosition=position;
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
        try{
            SQLiteDatabase trainingsplaner= getActivity().openOrCreateDatabase("Trainingsplaner", Activity.MODE_PRIVATE, null);
            Cursor cursor= trainingsplaner.rawQuery("SELECT trainingsplanuebung._id AS _id," +
                    "Uebung.Uebung_id," +
                    "Uebung.uebungsname," +
                    "Uebung.uebungsbeschreibung," +
                    "Uebung.uebungsbild," +
                    "satzintervall.intevall," +
                    "satzintervall.pause," +
                    "satzklassisch.wiederholung," +
                    "satzklassisch.pause " +
                    "FROM trainingsplanuebung INNER JOIN trainingsplan ON " +
                    "trainingsplanuebung.TrainingsplanID=trainingsplan._id " +
                    "INNER JOIN Uebung ON " +
                    "trainingsplanuebung.Uebungs_id= Uebung.Uebung_id " +
                    "INNER JOIN satzintervall ON " +
                    "satzintervall.TrainingUebungID=trainingsplanuebung._id " +
                    "INNER JOIN satzklassisch ON " +
                    "satzklassisch.TrainingUebungID= trainingsplanuebung._id " +
                    "WHERE trainingsplan._id='"+tpPosition+"'", null);
            cursor.moveToFirst();
            do{
                Log.v("Test", cursor.getString(cursor.getColumnIndex("uebungsname"))+" ,"+ cursor.getInt(cursor.getColumnIndex("wiederholung"))+" "+cursor.getInt(cursor.getColumnIndex("intervall")));
            } while(cursor.moveToNext());

        }catch (Exception e){
            Log.v("PagerTrainingsplan", e.getMessage());
        }
        titles= new ArrayList<String>();
 /*       for(Uebung u:FragmentTrainingsplanerList.getTrainingsplaners().get(tpPosition).getTpUebungen()){
            tpFragments.add(new FragmentUebungInPager(u));//in diesem Fragment werden nur die Übungsdatenangezeigt
            titles.add(u.getName());
        }*/

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_fragment_trainingsplan_pager, container, false);
        ViewPager vP= (ViewPager)v.findViewById(R.id.pagerTrainingeplaner);//TODO in dem Layout muss noch ein Pager eingefügt werden
        //Log.v("Get Trainingsplaner", "Trainingsplan "+ trainingsplaner.getName());
        vP.setAdapter(new FragmentPager(getChildFragmentManager(),tpFragments,titles));

        vP.setCurrentItem(tpFragments.size()-1);
        FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.fabNeueUebung);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 builder = new AlertDialog.Builder(getActivity());
                LayoutInflater inflaters = getActivity().getLayoutInflater();
                View theView = inflaters.inflate(R.layout.alert_neue_uebung, null);



                neueUebungErstellen= (Button) theView.findViewById(R.id.neueUebungErstellen);
                uebungAusKatalog=(Button)theView.findViewById(R.id.uebungAusKatalog);

                neueUebungErstellen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Uebung uebung= new Uebung();
                        FragmentTransaction ft= getActivity().getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.traininsplanerlayout,new FragmentTPUebung(uebung,trainingsplaner, tpPosition));
                        ft.commit();
                        neueUebungErstellen.setVisibility(View.INVISIBLE);
                        uebungAusKatalog.setVisibility(View.INVISIBLE);
                    }
                });
                uebungAusKatalog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        auswahlUK = new AlertDialog.Builder(getActivity());
                        LayoutInflater inflaters = getActivity().getLayoutInflater();
                        final View theView = inflaters.inflate(R.layout.alert_uebung_aus_katalog, null);
                       final Button eigen= (Button) theView.findViewById(R.id.uekatEigengewicht);
                        final Button maschine= (Button) theView.findViewById(R.id.uekatMaschine);
                        final Button funktionell= (Button) theView.findViewById(R.id.uekatFunktionelle);
                        final Button freie= (Button) theView.findViewById(R.id.uekatFreieGewichte);
                        neueUebungErstellen.setVisibility(View.INVISIBLE);
                        uebungAusKatalog.setVisibility(View.INVISIBLE);

                        eigen.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                FragmentTransaction ft= getActivity().getSupportFragmentManager().beginTransaction();

                                ft.replace(R.id.traininsplanerlayout,new FragmentEigengewicht(trainingsplaner,tpPosition));
                                ft.commit();
                                eigen.setVisibility(View.INVISIBLE);
                                maschine.setVisibility(View.INVISIBLE);
                                funktionell.setVisibility(View.INVISIBLE);
                                freie.setVisibility(View.INVISIBLE);


                            }
                        });

                        maschine.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                FragmentTransaction ft= getActivity().getSupportFragmentManager().beginTransaction();

                                ft.replace(R.id.traininsplanerlayout,new FragmentMaschine(trainingsplaner,tpPosition));
                                ft.commit();
                                eigen.setVisibility(View.INVISIBLE);
                                maschine.setVisibility(View.INVISIBLE);
                                funktionell.setVisibility(View.INVISIBLE);
                                freie.setVisibility(View.INVISIBLE);
                            }
                        });

                        funktionell.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                FragmentTransaction ft= getActivity().getSupportFragmentManager().beginTransaction();

                                ft.replace(R.id.traininsplanerlayout,new FragmentFunktionell(trainingsplaner,tpPosition));
                                ft.commit();
                                eigen.setVisibility(View.INVISIBLE);
                                maschine.setVisibility(View.INVISIBLE);
                                funktionell.setVisibility(View.INVISIBLE);
                                freie.setVisibility(View.INVISIBLE);
                            }
                        });

                        freie.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                FragmentTransaction ft= getActivity().getSupportFragmentManager().beginTransaction();

                                ft.replace(R.id.traininsplanerlayout,new FragmentFreieGewichte(trainingsplaner,tpPosition));
                                ft.commit();
                                eigen.setVisibility(View.INVISIBLE);
                                maschine.setVisibility(View.INVISIBLE);
                                funktionell.setVisibility(View.INVISIBLE);
                                freie.setVisibility(View.INVISIBLE);
                            }
                        });
                        auswahlUK.create().cancel();
                        auswahlUK.setView(theView);
                        auswahlUK.show();
                    }
                });


/*                builder.setNeutralButton("Übung aus Übungskatalog", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
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

                                ft.replace(R.id.traininsplanerlayout,new FragmentEigengewicht(trainingsplaner,tpPosition));
                                ft.commit();
                            }
                        });

                        maschine.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                FragmentTransaction ft= getActivity().getSupportFragmentManager().beginTransaction();

                                ft.replace(R.id.traininsplanerlayout,new FragmentMaschine(trainingsplaner,tpPosition));
                                ft.commit();
                            }
                        });

                        funktionell.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                FragmentTransaction ft= getActivity().getSupportFragmentManager().beginTransaction();

                                ft.replace(R.id.traininsplanerlayout,new FragmentFunktionell(trainingsplaner,tpPosition));
                                ft.commit();
                            }
                        });

                        freie.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                FragmentTransaction ft= getActivity().getSupportFragmentManager().beginTransaction();

                                ft.replace(R.id.traininsplanerlayout,new FragmentFreieGewichte(trainingsplaner,tpPosition));
                                ft.commit();
                            }
                        });
                        auswahlUK.setView(theView);
                        auswahlUK.show();

                    }

                });*/
     /*           builder.setNeutralButton("Neue Übung erstellen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Uebung uebung= new Uebung();
                        FragmentTransaction ft= getActivity().getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.traininsplanerlayout,new FragmentTPUebung(uebung,trainingsplaner, tpPosition));
                        ft.commit();
                    }
                });*/





                builder.setView(theView);
                builder.show();
              //TODO, hier musst ein weiteres Fragment füt die neue Übung geöffnet werden  z.B NeueTPUebungFragment

            }
        });



        return v;

    }

}
