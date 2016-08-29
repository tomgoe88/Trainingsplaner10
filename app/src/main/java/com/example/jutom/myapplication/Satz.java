package com.example.jutom.myapplication;

import java.util.Date;

/**
 * Created by Jutom on 28.06.2016.
 */
public class Satz
{
    private int satzZahl;



    private int pause;
    private int belastungsIntervall;

    public int getBelastungsIntervall() {
        return belastungsIntervall;
    }

    public void setBelastungsIntervall(int belastungsIntervall) {
        this.belastungsIntervall = belastungsIntervall;
    }
    public int getPause() {
        return pause;
    }

    public void setPause(int pause) {
        this.pause = pause;
    }

    public int getSatzZahl() {
        return satzZahl;
    }

    public void setSatzZahl(int satzZahl) {
        this.satzZahl = satzZahl;
    }
}
