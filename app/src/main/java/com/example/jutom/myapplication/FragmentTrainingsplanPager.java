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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

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
    int count;
    Cursor cursor;
    AlertDialog.Builder auswahlUK;
    AlertDialog.Builder auswahlNeueUebung;
    AlertDialog.Builder auswahlNeueUebungUebungsart;
    int position;
    private Button neueUebung; //TODO hier müssen neue Übungen hinzugefügt werden
    private Trainingsplaner trainingsplaner;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    int tempId;
    int tpPosition;
    int tempTraining;
    boolean neueUebungx;
    boolean ausKatalogx;
    Button neueUebungErstellen;
    Button uebungAusKatalog;
    Spinner spinner2;
    Spinner spinner;

    int uebungID;
    int muskelID;


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
        titles= new ArrayList<String>();
        try{
            SQLiteDatabase trainingsplaner= getActivity().openOrCreateDatabase("Trainingsplaner", Activity.MODE_PRIVATE, null);
             cursor= trainingsplaner.rawQuery("SELECT trainingsplanuebung._id AS _id," +
                    "Uebung.Uebung_id," +
                    "Uebung.uebungsname," +
                    "Uebung.uebungsbeschreibung," +
                    "Uebung.uebungsbild " +
                    "FROM Uebung " +
                    "INNER JOIN trainingsplanuebung ON " +
                    "trainingsplanuebung.Uebungs_id = Uebung.Uebung_id " +
                    "WHERE trainingsplanuebung.TrainingsplanID = '"+tpPosition+"'"
                   , null);  //der Satz wird dann in dem FragmentUebungInPager gesucht Referen trainingsplanuebung._id
        }catch (Exception e){
            Log.v("PagerTrainingsplan", e.getMessage());
        }
            //10-04 19:02:45.967 5472-5472/? V/PagerTrainingsplan: Couldn't read row 0, col -1 from CursorWindow.  Make sure the Cursor is initialized correctly before accessing data from it.
        try {
            cursor.moveToFirst();

            do {
                count++;
                Uebung uebung = new Uebung();
                uebung.setTpUebungId(cursor.getInt(cursor.getColumnIndex("_id")));
                uebung.setName(cursor.getString(cursor.getColumnIndex("uebungsname")));
                uebung.setImg(cursor.getString(cursor.getColumnIndex("uebungsbild")));
                uebung.setBeschreibung(cursor.getString(cursor.getColumnIndex("uebungsbeschreibung")));


                tpFragments.add(new FragmentUebungInPager(uebung));
                titles.add(uebung.getName());

                // Log.v("Test", cursor.getString(cursor.getColumnIndex("Uebung.uebungsname"))+" ,"+ cursor.getInt(cursor.getColumnIndex("Uebung.wiederholung"))+" "+cursor.getInt(cursor.getColumnIndex("Uebung.intervall")));
            } while (cursor.moveToNext());
            Log.v("Test", "Count = " + count);
        }catch (Exception e){
            Log.v("PagerTrainingsplan", e.getMessage());
        }



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
                       // Uebung uebung= new Uebung();
                        neueUebungx=true;

                    }
                });
                uebungAusKatalog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ausKatalogx=true;
                    }
                });
                spinner = (Spinner) theView.findViewById(R.id.spinner);
                List<String> list = new ArrayList<String>();
                list.add("Maschine");
                list.add("Funktionell");
                list.add("FreieGewichte");
                list.add("Eigengewicht");

                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(),
                        android.R.layout.simple_spinner_item, list);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(dataAdapter);
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String uebung= parent.getSelectedItem().toString();
                        try {
                            //TODO hier muss noch die übungsid eingefügt werden bzw gesucht werden
                            SQLiteDatabase trainingsplaner= getActivity().openOrCreateDatabase("Trainingsplaner", Activity.MODE_PRIVATE, null);
                            Cursor cursor3= trainingsplaner.rawQuery("SELECT uebungsart_id AS _id FROM Uebungsart WHERE uebungsartname = '"+uebung+"'",null);
                            cursor3.moveToFirst();
                            do{
                                uebungID= cursor3.getInt(cursor3.getColumnIndex("_id"));
                                Log.v("get Uebung_id", ""+uebungID);
                            }while (cursor3.moveToNext());
                            cursor3.close();
                        } catch(Exception e){
                            Log.v("NeueUebung", e.getMessage());
                        }
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                spinner2 = (Spinner) theView.findViewById(R.id.spinner2);
                List<String> list1 = new ArrayList<String>();
                list1.add("Brust");
                list1.add("UntererRuecken");
                list1.add("ObererRuecken");
                list1.add("Beine");
                list1.add("Bicep");
                list1.add("Tricep");
                list1.add("Bauch");
                list1.add("Schulter");
                ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(getActivity(),
                        android.R.layout.simple_spinner_item, list1);
                dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner2.setAdapter(dataAdapter2);
                spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String muskel= parent.getSelectedItem().toString();
                        try {
                            //TODO hier muss noch die übungsid eingefügt werden bzw gesucht werden
                            SQLiteDatabase trainingsplaner= getActivity().openOrCreateDatabase("Trainingsplaner", Activity.MODE_PRIVATE, null);
                            Cursor cursor4= trainingsplaner.rawQuery("SELECT muskelgruppe_id AS _id FROM Muskelgruppe WHERE muskegruppenname = '"+muskel+"'",null);
                            cursor4.moveToFirst();
                            do{
                                muskelID= cursor4.getInt(cursor4.getColumnIndex("_id"));
                                Log.v("get Uebung_id", ""+muskelID);
                            }while (cursor4.moveToNext());
                            cursor4.close();
                        } catch(Exception e){
                            Log.v("NeueUebung", e.getMessage());
                        }


                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(neueUebungx==true){
                            try {
                                //TODO hier muss noch die übungsid eingefügt werden bzw gesucht werden
                                SQLiteDatabase trainingsplaner= getActivity().openOrCreateDatabase("Trainingsplaner", Activity.MODE_PRIVATE, null);
                                trainingsplaner.execSQL("INSERT INTO Uebung(uebungsname, uebungsbeschreibung, uebungsbild, muskelgruppe_id, uebungsart_id) VALUES('neu', 'neu', 'neu','"+muskelID+"', '"+uebungID+"')");
                            } catch(Exception e){
                                Log.v("NeueUebung", e.getMessage());
                            }
                            try {
                                SQLiteDatabase trainingsplaner= getActivity().openOrCreateDatabase("Trainingsplaner", Activity.MODE_PRIVATE, null);
                                Cursor cursor= trainingsplaner.rawQuery("SELECT Uebung_id AS _id FROM Uebung WHERE Uebung_id =(SELECT MAX(Uebung_id) FROM Uebung)", null);
                                cursor.moveToFirst();
                                do{
                                    tempId= cursor.getInt(cursor.getColumnIndex("_id"));
                                    Log.v("get Uebung_id", ""+tempId);
                                }while (cursor.moveToNext());
                                cursor.close();
                            } catch(Exception e){
                                Log.v("NeueUebung", e.getMessage());
                            }
                            try {
                                SQLiteDatabase trainingsplaner= getActivity().openOrCreateDatabase("Trainingsplaner", Activity.MODE_PRIVATE, null);
                                trainingsplaner.execSQL("INSERT INTO trainingsplanuebung(Uebungs_id, TrainingsplanID) VALUES ('" + tempId + "','" + tpPosition + "')");

                                //es muss noch die letzte Übung abgefragt werden
                            } catch(Exception e){
                                Log.v("NeueUebung", e.getMessage());
                            }
                            try {
                                SQLiteDatabase trainingsplaner= getActivity().openOrCreateDatabase("Trainingsplaner", Activity.MODE_PRIVATE, null);
                                Cursor cursor2= trainingsplaner.rawQuery("SELECT  _id FROM trainingsplanuebung WHERE _id =(SELECT MAX(_id) FROM trainingsplanuebung)", null);
                                cursor2.moveToFirst();
                                do{
                                    tempTraining= cursor2.getInt(cursor2.getColumnIndex("_id"));
                                    Log.v("get Uebung_id", ""+tempTraining);
                                }while (cursor2.moveToNext());
                                cursor2.close();

                            } catch(Exception e){
                                Log.v("NeueUebung", e.getMessage());
                            }

                            FragmentTransaction ft= getActivity().getSupportFragmentManager().beginTransaction();
                            ft.replace(R.id.traininsplanerlayout,new FragmentTPUebung(tpPosition,tempId, tempTraining));
                            ft.commit();
                            neueUebungErstellen.setVisibility(View.INVISIBLE);
                            uebungAusKatalog.setVisibility(View.INVISIBLE);
                        }
                        else if(ausKatalogx==true){
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
        //TODO prepare Spinner for your own requires



        return v;

    }

}
