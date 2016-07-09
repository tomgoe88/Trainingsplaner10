package com.example.jutom.myapplication;

import java.util.Date;

/**
 * Created by Jutom on 28.06.2016.
 */
public class Satz
{
    private int satzZahl;



    private Date pause;
    private Date belastungsIntervall;

    public Date getBelastungsIntervall() {
        return belastungsIntervall;
    }

    public void setBelastungsIntervall(Date belastungsIntervall) {
        this.belastungsIntervall = belastungsIntervall;
    }
    public Date getPause() {
        return pause;
    }

    public void setPause(Date pause) {
        this.pause = pause;
    }

    public int getSatzZahl() {
        return satzZahl;
    }

    public void setSatzZahl(int satzZahl) {
        this.satzZahl = satzZahl;
    }
}
