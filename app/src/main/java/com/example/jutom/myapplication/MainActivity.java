package com.example.jutom.myapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        Uebung uebung = new Uebung();
        uebung.setName("Test");
        SQLHelper.getHauptlist().add(uebung);

        try{
            SQLiteDatabase trainingsplaner= this.openOrCreateDatabase("Trainingsplaner", MODE_PRIVATE, null);
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS EigengewichtRuecken(id INTEGER PRIMARY KEY, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255))");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS eigengewichtbrusts(id INTEGER PRIMARY KEY, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255))");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS eigengewichtobererRueckens(id INTEGER PRIMARY KEY, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255))");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS eigengewichtbeines(id INTEGER PRIMARY KEY, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255))");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS eigengewichtbiceps(id INTEGER PRIMARY KEY, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255))");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS eigengewichttriceps(id INTEGER PRIMARY KEY, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255))");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS eigengewichtbauches(id INTEGER PRIMARY KEY, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255))");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS eigengewichtschulters(id INTEGER PRIMARY KEY, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255))");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS maschinerueckens(id INTEGER PRIMARY KEY, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255))");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS maschinebrusts(id INTEGER PRIMARY KEY, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255))");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS maschineuntererRueckens(id INTEGER PRIMARY KEY, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255))");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS maschineobererRueckens(id INTEGER PRIMARY KEY, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255))");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS maschinebeines(id INTEGER PRIMARY KEY, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255))");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS maschinebiceps(id INTEGER PRIMARY KEY, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255))");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS maschinetriceps(id INTEGER PRIMARY KEY, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255))");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS maschinebauches(id INTEGER PRIMARY KEY, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255))");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS maschineschulters(id INTEGER PRIMARY KEY, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255))");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS funktionellrueckens(id INTEGER PRIMARY KEY, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255))");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS funktionellbrusts(id INTEGER PRIMARY KEY, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255))");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS funktionelluntererRueckens(id INTEGER PRIMARY KEY, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255))");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS funktionellobererRueckens(id INTEGER PRIMARY KEY, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255))");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS funktionellbeines(id INTEGER PRIMARY KEY, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255))");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS funktionellbiceps(id INTEGER PRIMARY KEY, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255))");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS funktionelltriceps(id INTEGER PRIMARY KEY, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255))");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS funktionellbauches(id INTEGER PRIMARY KEY, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255))");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS funktionellschulters(id INTEGER PRIMARY KEY, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255))");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS freierueckens(id INTEGER PRIMARY KEY, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255))");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS freiebrusts(id INTEGER PRIMARY KEY, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255))");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS freieuntererRueckens(id INTEGER PRIMARY KEY, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255))");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS freieobererRueckens(id INTEGER PRIMARY KEY, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255))");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS freiebeines(id INTEGER PRIMARY KEY, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255))");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS freiebiceps(id INTEGER PRIMARY KEY, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255))");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS freietriceps(id INTEGER PRIMARY KEY, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255))");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS freiebauches(id INTEGER PRIMARY KEY, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255))");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS freieschulters(id INTEGER PRIMARY KEY, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255))");

            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS trainingsplan(TrainingsplanID INTEGER PRIMARY KEY, trainingsplanname VARCHAR(50)) ");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS trainingsplanuebung(UebungID INTEGER PRIMARY KEY,  uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255), TrainingsID INTERGER, FOREIGN KEY(TrainingsID) REFERENCES trainingsplan(TrainingsplanID))");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS satzintervall(IntervallID INTEGER PRIMARY KEY, intevall INTEGER, pause INTEGER, UeID INTEGER, FOREIGN KEY(UeID) REFERENCES trainingsplanuebung(UebungID))");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS satzklassisch(KlassischID INTEGER PRIMARY KEY, wiederholung INTEGER, pause INTEGER, UeID INTEGER, FOREIGN KEY(UeID) REFERENCES trainingsplanuebung(UebungID))");
            trainingsplaner.close();
        } catch(Exception e){
            Log.v("SQL Exception", "Fehler: "+e.getMessage());
        }








        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.uebungskatalog) {
            Intent eigen= new Intent(this, ActivityUebungskatalogGesamt.class);
            this.startActivity(eigen);

        } else if (id == R.id.trainingsplan) {
            Intent tp= new Intent(this, Activity_Trainingsplaner.class);
            this.startActivity(tp);

        } else if (id == R.id.training) {}





        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
