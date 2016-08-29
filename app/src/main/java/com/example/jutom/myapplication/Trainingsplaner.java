package com.example.jutom.myapplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jutom on 26.08.2016.
 */
public class Trainingsplaner {
    private String name;
    private int anzahlUebung;
    private List<Uebung> tpUebungen;

    public Trainingsplaner() {
        this.tpUebungen = new ArrayList<Uebung>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAnzahlUebung() {
        return tpUebungen.size();
    }

    public void setAnzahlUebung(int anzahlUebung) {
        this.anzahlUebung = anzahlUebung;
    }

    public List<Uebung> getTpUebungen() {
        return tpUebungen;
    }

    public void setTpUebungen(List<Uebung> tpUebungen) {
        this.tpUebungen = tpUebungen;
    }
}
