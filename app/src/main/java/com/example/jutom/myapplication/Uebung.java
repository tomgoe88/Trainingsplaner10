package com.example.jutom.myapplication;

import java.util.List;

/**
 * Created by Jutom on 28.06.2016.
 */
public class Uebung
{
    private String name;
    private String beschreibung;
    private String img;
    private List<Satz> satzList;
    private List<SatzZeit> satzZeitList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List<Satz> getSatzList() {
        return satzList;
    }

    public void setSatzList(List<Satz> satzList) {
        this.satzList = satzList;
    }

    public List<SatzZeit> getSatzZeitList() {
        return satzZeitList;
    }

    public void setSatzZeitList(List<SatzZeit> satzZeitList) {
        this.satzZeitList = satzZeitList;
    }
}
