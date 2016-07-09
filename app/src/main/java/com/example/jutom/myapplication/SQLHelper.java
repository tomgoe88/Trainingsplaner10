package com.example.jutom.myapplication;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Jutom on 28.06.2016.
 */
public class SQLHelper
{
    private static List<Uebung> hauptlist = new ArrayList<>();



    private static List<Ruecken> eigengewichtrueckens= new ArrayList<Ruecken>();
    private static List<Brust> eigengewichtbrusts= new ArrayList<Brust>();
    private static List<UntererRuecken> eigengewichtuntererRueckens= new ArrayList<UntererRuecken>();
    private static List<ObererRuecken> eigengewichtobererRueckens= new ArrayList<ObererRuecken>();
    private static List<Beine> eigengewichtbeines= new ArrayList<Beine>();
    private static List<Bicep> eigengewichtbiceps= new ArrayList<Bicep>();
    private static List<Tricep> eigengewichttriceps= new ArrayList<Tricep>();
    private static List<Bauch> eigengewichtbauches= new ArrayList<Bauch>();
    private static List<Schulter> eigengewichtschulters= new ArrayList<Schulter>();

    private static List<Ruecken> maschinerueckens= new ArrayList<Ruecken>();
    private static List<Brust> maschinebrusts= new ArrayList<Brust>();
    private static List<UntererRuecken> maschineuntererRueckens= new ArrayList<UntererRuecken>();
    private static List<ObererRuecken> maschineobererRueckens= new ArrayList<ObererRuecken>();
    private static List<Beine> maschinebeines= new ArrayList<Beine>();
    private static List<Bicep> maschinebiceps= new ArrayList<Bicep>();
    private static List<Tricep> maschinetriceps= new ArrayList<Tricep>();
    private static List<Bauch> maschinebauches= new ArrayList<Bauch>();
    private static List<Schulter> maschineschulters= new ArrayList<Schulter>();

    private static List<Ruecken> funktionellrueckens= new ArrayList<Ruecken>();
    private static List<Brust> funktionellbrusts= new ArrayList<Brust>();
    private static List<UntererRuecken> funktionelluntererRueckens= new ArrayList<UntererRuecken>();
    private static List<ObererRuecken> funktionellobererRueckens= new ArrayList<ObererRuecken>();
    private static List<Beine> funktionellbeines= new ArrayList<Beine>();
    private static List<Bicep> funktionellbiceps= new ArrayList<Bicep>();
    private static List<Tricep> funktionelltriceps= new ArrayList<Tricep>();
    private static List<Bauch> funktionellbauches= new ArrayList<Bauch>();
    private static List<Schulter> funktionellschulters= new ArrayList<Schulter>();

    private static List<Ruecken> freierueckens= new ArrayList<Ruecken>();
    private static List<Brust> freiebrusts= new ArrayList<Brust>();
    private static List<UntererRuecken> freieuntererRueckens= new ArrayList<UntererRuecken>();
    private static List<ObererRuecken> freieobererRueckens= new ArrayList<ObererRuecken>();
    private static List<Beine> freiebeines= new ArrayList<Beine>();
    private static List<Bicep> freiebiceps= new ArrayList<Bicep>();
    private static List<Tricep> freietriceps= new ArrayList<Tricep>();
    private static List<Bauch> freiebauches= new ArrayList<Bauch>();
    private static List<Schulter> freieschulters= new ArrayList<Schulter>();
    public static List<Schulter> getFreieschulters() {
        return freieschulters;
    }

    public static void setFreieschulters(List<Schulter> freieschulters) {
        SQLHelper.freieschulters = freieschulters;
    }

    public static List<Uebung> getHauptlist() {
        return hauptlist;
    }

    public static void setHauptlist(List<Uebung> hauptlist) {
        SQLHelper.hauptlist = hauptlist;
    }

    public static List<Ruecken> getEigengewichtrueckens() {
        return eigengewichtrueckens;
    }

    public static void setEigengewichtrueckens(List<Ruecken> eigengewichtrueckens) {
        SQLHelper.eigengewichtrueckens = eigengewichtrueckens;
    }

    public static List<Brust> getEigengewichtbrusts() {
        return eigengewichtbrusts;
    }

    public static void setEigengewichtbrusts(List<Brust> eigengewichtbrusts) {
        SQLHelper.eigengewichtbrusts = eigengewichtbrusts;
    }

    public static List<UntererRuecken> getEigengewichtuntererRueckens() {
        return eigengewichtuntererRueckens;
    }

    public static void setEigengewichtuntererRueckens(List<UntererRuecken> eigengewichtuntererRueckens) {
        SQLHelper.eigengewichtuntererRueckens = eigengewichtuntererRueckens;
    }

    public static List<ObererRuecken> getEigengewichtobererRueckens() {
        return eigengewichtobererRueckens;
    }

    public static void setEigengewichtobererRueckens(List<ObererRuecken> eigengewichtobererRueckens) {
        SQLHelper.eigengewichtobererRueckens = eigengewichtobererRueckens;
    }

    public static List<Beine> getEigengewichtbeines() {
        return eigengewichtbeines;
    }

    public static void setEigengewichtbeines(List<Beine> eigengewichtbeines) {
        SQLHelper.eigengewichtbeines = eigengewichtbeines;
    }

    public static List<Bicep> getEigengewichtbiceps() {
        return eigengewichtbiceps;
    }

    public static void setEigengewichtbiceps(List<Bicep> eigengewichtbiceps) {
        SQLHelper.eigengewichtbiceps = eigengewichtbiceps;
    }

    public static List<Tricep> getEigengewichttriceps() {
        return eigengewichttriceps;
    }

    public static void setEigengewichttriceps(List<Tricep> eigengewichttriceps) {
        SQLHelper.eigengewichttriceps = eigengewichttriceps;
    }

    public static List<Bauch> getEigengewichtbauches() {
        return eigengewichtbauches;
    }

    public static void setEigengewichtbauches(List<Bauch> eigengewichtbauches) {
        SQLHelper.eigengewichtbauches = eigengewichtbauches;
    }

    public static List<Schulter> getEigengewichtschulters() {
        return eigengewichtschulters;
    }

    public static void setEigengewichtschulters(List<Schulter> eigengewichtschulters) {
        SQLHelper.eigengewichtschulters = eigengewichtschulters;
    }

    public static List<Ruecken> getMaschinerueckens() {
        return maschinerueckens;
    }

    public static void setMaschinerueckens(List<Ruecken> maschinerueckens) {
        SQLHelper.maschinerueckens = maschinerueckens;
    }

    public static List<Brust> getMaschinebrusts() {
        return maschinebrusts;
    }

    public static void setMaschinebrusts(List<Brust> maschinebrusts) {
        SQLHelper.maschinebrusts = maschinebrusts;
    }

    public static List<UntererRuecken> getMaschineuntererRueckens() {
        return maschineuntererRueckens;
    }

    public static void setMaschineuntererRueckens(List<UntererRuecken> maschineuntererRueckens) {
        SQLHelper.maschineuntererRueckens = maschineuntererRueckens;
    }

    public static List<ObererRuecken> getMaschineobererRueckens() {
        return maschineobererRueckens;
    }

    public static void setMaschineobererRueckens(List<ObererRuecken> maschineobererRueckens) {
        SQLHelper.maschineobererRueckens = maschineobererRueckens;
    }

    public static List<Beine> getMaschinebeines() {
        return maschinebeines;
    }

    public static void setMaschinebeines(List<Beine> maschinebeines) {
        SQLHelper.maschinebeines = maschinebeines;
    }

    public static List<Bicep> getMaschinebiceps() {
        return maschinebiceps;
    }

    public static void setMaschinebiceps(List<Bicep> maschinebiceps) {
        SQLHelper.maschinebiceps = maschinebiceps;
    }

    public static List<Tricep> getMaschinetriceps() {
        return maschinetriceps;
    }

    public static void setMaschinetriceps(List<Tricep> maschinetriceps) {
        SQLHelper.maschinetriceps = maschinetriceps;
    }

    public static List<Bauch> getMaschinebauches() {
        return maschinebauches;
    }

    public static void setMaschinebauches(List<Bauch> maschinebauches) {
        SQLHelper.maschinebauches = maschinebauches;
    }

    public static List<Schulter> getMaschineschulters() {
        return maschineschulters;
    }

    public static void setMaschineschulters(List<Schulter> maschineschulters) {
        SQLHelper.maschineschulters = maschineschulters;
    }

    public static List<Ruecken> getFunktionellrueckens() {
        return funktionellrueckens;
    }

    public static void setFunktionellrueckens(List<Ruecken> funktionellrueckens) {
        SQLHelper.funktionellrueckens = funktionellrueckens;
    }

    public static List<Brust> getFunktionellbrusts() {
        return funktionellbrusts;
    }

    public static void setFunktionellbrusts(List<Brust> funktionellbrusts) {
        SQLHelper.funktionellbrusts = funktionellbrusts;
    }

    public static List<UntererRuecken> getFunktionelluntererRueckens() {
        return funktionelluntererRueckens;
    }

    public static void setFunktionelluntererRueckens(List<UntererRuecken> funktionelluntererRueckens) {
        SQLHelper.funktionelluntererRueckens = funktionelluntererRueckens;
    }

    public static List<ObererRuecken> getFunktionellobererRueckens() {
        return funktionellobererRueckens;
    }

    public static void setFunktionellobererRueckens(List<ObererRuecken> funktionellobererRueckens) {
        SQLHelper.funktionellobererRueckens = funktionellobererRueckens;
    }

    public static List<Beine> getFunktionellbeines() {
        return funktionellbeines;
    }

    public static void setFunktionellbeines(List<Beine> funktionellbeines) {
        SQLHelper.funktionellbeines = funktionellbeines;
    }

    public static List<Bicep> getFunktionellbiceps() {
        return funktionellbiceps;
    }

    public static void setFunktionellbiceps(List<Bicep> funktionellbiceps) {
        SQLHelper.funktionellbiceps = funktionellbiceps;
    }

    public static List<Tricep> getFunktionelltriceps() {
        return funktionelltriceps;
    }

    public static void setFunktionelltriceps(List<Tricep> funktionelltriceps) {
        SQLHelper.funktionelltriceps = funktionelltriceps;
    }

    public static List<Bauch> getFunktionellbauches() {
        return funktionellbauches;
    }

    public static void setFunktionellbauches(List<Bauch> funktionellbauches) {
        SQLHelper.funktionellbauches = funktionellbauches;
    }

    public static List<Schulter> getFunktionellschulters() {
        return funktionellschulters;
    }

    public static void setFunktionellschulters(List<Schulter> funktionellschulters) {
        SQLHelper.funktionellschulters = funktionellschulters;
    }

    public static List<Ruecken> getFreierueckens() {
        return freierueckens;
    }

    public static void setFreierueckens(List<Ruecken> freierueckens) {
        SQLHelper.freierueckens = freierueckens;
    }

    public static List<Brust> getFreiebrusts() {
        return freiebrusts;
    }

    public static void setFreiebrusts(List<Brust> freiebrusts) {
        SQLHelper.freiebrusts = freiebrusts;
    }

    public static List<UntererRuecken> getFreieuntererRueckens() {
        return freieuntererRueckens;
    }

    public static void setFreieuntererRueckens(List<UntererRuecken> freieuntererRueckens) {
        SQLHelper.freieuntererRueckens = freieuntererRueckens;
    }

    public static List<ObererRuecken> getFreieobererRueckens() {
        return freieobererRueckens;
    }

    public static void setFreieobererRueckens(List<ObererRuecken> freieobererRueckens) {
        SQLHelper.freieobererRueckens = freieobererRueckens;
    }

    public static List<Beine> getFreiebeines() {
        return freiebeines;
    }

    public static void setFreiebeines(List<Beine> freiebeines) {
        SQLHelper.freiebeines = freiebeines;
    }

    public static List<Bicep> getFreiebiceps() {
        return freiebiceps;
    }

    public static void setFreiebiceps(List<Bicep> freiebiceps) {
        SQLHelper.freiebiceps = freiebiceps;
    }

    public static List<Tricep> getFreietriceps() {
        return freietriceps;
    }

    public static void setFreietriceps(List<Tricep> freietriceps) {
        SQLHelper.freietriceps = freietriceps;
    }

    public static List<Bauch> getFreiebauches() {
        return freiebauches;
    }

    public static void setFreiebauches(List<Bauch> freiebauches) {
        SQLHelper.freiebauches = freiebauches;
    }




}
