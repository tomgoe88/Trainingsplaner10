package com.example.jutom.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentTrainingsplanerList#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentTrainingsplanerList extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Button newPlan; //TODO, hierrüber soll eine neuer Plan angelegt werden, anschließend muss der Adapter refreshed werden.
    View v;
    ListView trainerList;
    ListAdapterTrainingsplaner listAdapterTrainingsplaner;
   public static List<Trainingsplaner> trainingsplaners=new ArrayList<Trainingsplaner>();
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public FragmentTrainingsplanerList() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentTrainingsplanerList.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentTrainingsplanerList newInstance(String param1, String param2) {
        FragmentTrainingsplanerList fragment = new FragmentTrainingsplanerList();
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

        Trainingsplaner tp= new Trainingsplaner();
        tp.setName("Testplan");

        tp.getTpUebungen().add(new Bauch());
        tp.getTpUebungen().add(new Beine());
        Log.v("Fragment", "TP Fragment ist erstellt");
        trainingsplaners.add(tp);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_fragment_trainingsplaner_list, container, false);
        trainerList = (ListView) v.findViewById(R.id.listTrainingsplaner);
        listAdapterTrainingsplaner= new ListAdapterTrainingsplaner(getActivity(), trainingsplaners);
        trainerList.setAdapter(listAdapterTrainingsplaner);
        FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.fabNeuerTP);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Trainingsplaner tp= new Trainingsplaner();
                tp.setName("Neuer Plan");
                Log.v("Fragment", "TP Fragment ist erstellt");
                trainingsplaners.add(tp);
                trainerList.setAdapter(null);
                listAdapterTrainingsplaner.notifyDataSetChanged();
                trainerList.setAdapter(listAdapterTrainingsplaner);


            }
        });

        trainerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        FragmentTransaction ft= getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.traininsplanerlayout,new FragmentTrainingsplanPager(trainingsplaners.get(position), position));
        ft.commit();
            }
        });


        return  v;
    }

    public static List<Trainingsplaner> getTrainingsplaners() {
        return trainingsplaners;
    }

    public static void setTrainingsplaners(List<Trainingsplaner> trainingsplaners) {
        FragmentTrainingsplanerList.trainingsplaners = trainingsplaners;
    }
}
