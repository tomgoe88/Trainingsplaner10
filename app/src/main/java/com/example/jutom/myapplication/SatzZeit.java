package com.example.jutom.myapplication;

import java.util.Date;

/**
 * Created by Jutom on 28.06.2016.
 */
public class SatzZeit
{
    private int satzZahl;
    private Date pause;
    private int wiederholungen;

    public int getSatzZahl() {
        return satzZahl;
    }

    public void setSatzZahl(int satzZahl) {
        this.satzZahl = satzZahl;
    }

    public Date getPause() {
        return pause;
    }

    public void setPause(Date pause) {
        this.pause = pause;
    }

    public int getWiederholungen() {
        return wiederholungen;
    }

    public void setWiederholungen(int wiederholungen) {
        this.wiederholungen = wiederholungen;
    }
}
