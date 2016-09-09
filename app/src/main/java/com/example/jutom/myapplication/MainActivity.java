package com.example.jutom.myapplication;

import android.content.Intent;
import android.database.Cursor;
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
import android.widget.Toast;

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
/*            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS Ruecken(_id INTEGER PRIMARY KEY AUTOINCREMENT, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255), uebungsart VARCHAR(55))");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS Brust(_id INTEGER PRIMARY KEY AUTOINCREMENT, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255), uebungsart)");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS UntererRuecken(_id INTEGER PRIMARY KEY AUTOINCREMENT, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255), uebungsart)");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS ObererRuecken(_id INTEGER PRIMARY KEY AUTOINCREMENT, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255), uebungsart)");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS Beine(_id INTEGER PRIMARY KEY AUTOINCREMENT, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255), uebungsart)");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS Bicep(_id INTEGER PRIMARY KEY AUTOINCREMENT, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255), uebungsart)");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS Tricep(_id INTEGER PRIMARY KEY AUTOINCREMENT, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255), uebungsart)");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS Bauch(_id INTEGER PRIMARY KEY AUTOINCREMENT, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255), uebungsart)");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS Schulter(_id INTEGER PRIMARY KEY AUTOINCREMENT, uebungsname VARCHAR(50), uebungsbeschreibung TEXT, uebungsbild VARCHAR(255), uebungsart)");*/


            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS trainingsplan(" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " trainingsplanname VARCHAR(50)" +
                    ")");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS trainingsplanuebung(" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "Uebungs_id INTEGER , " +
                    "TrainingsplanID INTEGER, " +
                    "FOREIGN KEY(TrainingsplanID) REFERENCES trainingsplan(_id), " +
                    "FOREIGN KEY(Uebungs_id) REFERENCES Uebung(Uebung_id)" +
                    ")");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS satzintervall(" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " intevall INTEGER, pause INTEGER, " +
                    "TrainingUebungID INTEGER, " +
                    "FOREIGN KEY(TrainingUebungID) REFERENCES trainingsplanuebung(_id)" +
                    ")");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS satzklassisch(" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "wiederholung INTEGER, pause INTEGER, " +
                    "TrainingUebungID INTEGER, " +
                    "FOREIGN KEY(TrainingUebungID) REFERENCES trainingsplanuebung(_id)" +
                    ")");


            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS Uebung(" +
                    "Uebung_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "uebungsname VARCHAR(50), " +
                    "uebungsbeschreibung TEXT, " +
                    "uebungsbild VARCHAR(255), " +
                    "muskelgruppe_id INTEGER, " +
                    "uebungsart_id INTEGER," +
                    "FOREIGN KEY(muskelgruppe_id) REFERENCES Muskelgruppe(muskelgruppe_id)" +
                    "FOREIGN KEY(uebungsart_id) REFERENCES Uebungsart(uebungsart_id)" +
                    ")");

            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS Muskelgruppe(muskelgruppe_id INTEGER PRIMARY KEY AUTOINCREMENT, muskegruppenname VARCHAR(50))");
            trainingsplaner.execSQL("CREATE TABLE IF NOT EXISTS Uebungsart(uebungsart_id INTEGER PRIMARY KEY AUTOINCREMENT, uebungsartname VARCHAR(50))");

            Cursor cursor= trainingsplaner.rawQuery("SELECT * FROM Muskelgruppe", null);
            if(cursor.getCount()==0){
                trainingsplaner.execSQL("INSERT INTO Muskelgruppe(muskegruppenname)VALUES('Ruecken')");
                trainingsplaner.execSQL("INSERT INTO Muskelgruppe(muskegruppenname)VALUES('Brust')");
                trainingsplaner.execSQL("INSERT INTO Muskelgruppe(muskegruppenname)VALUES('UntererRuecken')");
                trainingsplaner.execSQL("INSERT INTO Muskelgruppe(muskegruppenname)VALUES('ObererRuecken')");
                trainingsplaner.execSQL("INSERT INTO Muskelgruppe(muskegruppenname)VALUES('Beine')");
                trainingsplaner.execSQL("INSERT INTO Muskelgruppe(muskegruppenname)VALUES('Bicep')");
                trainingsplaner.execSQL("INSERT INTO Muskelgruppe(muskegruppenname)VALUES('Tricep')");
                trainingsplaner.execSQL("INSERT INTO Muskelgruppe(muskegruppenname)VALUES('Bauch')");
                trainingsplaner.execSQL("INSERT INTO Muskelgruppe(muskegruppenname)VALUES('Schulter')");

                trainingsplaner.execSQL("INSERT INTO Uebungsart(uebungsartname)VALUES('Maschine')");
                trainingsplaner.execSQL("INSERT INTO Uebungsart(uebungsartname)VALUES('Funktionell')");
                trainingsplaner.execSQL("INSERT INTO Uebungsart(uebungsartname)VALUES('FreieGewichte')");
                trainingsplaner.execSQL("INSERT INTO Uebungsart(uebungsartname)VALUES('Eigengewicht')");
                Toast.makeText(this,"Erfolgreich gestartet", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this,"Datenbank ist ok!", Toast.LENGTH_LONG).show();
            }

         /*   trainingsplaner.execSQL("INSERT INTO Muskelgruppe(muskegruppenname)VALUES('Ruecken')");
            trainingsplaner.execSQL("INSERT INTO Muskelgruppe(muskegruppenname)VALUES('Brust')");
            trainingsplaner.execSQL("INSERT INTO Muskelgruppe(muskegruppenname)VALUES('UntererRuecken')");
            trainingsplaner.execSQL("INSERT INTO Muskelgruppe(muskegruppenname)VALUES('ObererRuecken')");
            trainingsplaner.execSQL("INSERT INTO Muskelgruppe(muskegruppenname)VALUES('Beine')");
            trainingsplaner.execSQL("INSERT INTO Muskelgruppe(muskegruppenname)VALUES('Bicep')");
            trainingsplaner.execSQL("INSERT INTO Muskelgruppe(muskegruppenname)VALUES('Tricep')");
            trainingsplaner.execSQL("INSERT INTO Muskelgruppe(muskegruppenname)VALUES('Bauch')");
            trainingsplaner.execSQL("INSERT INTO Muskelgruppe(muskegruppenname)VALUES('Schulter')");

            trainingsplaner.execSQL("INSERT INTO Uebungsart(uebungsartname)VALUES('Maschine')");
            trainingsplaner.execSQL("INSERT INTO Uebungsart(uebungsartname)VALUES('Funktionell')");
            trainingsplaner.execSQL("INSERT INTO Uebungsart(uebungsartname)VALUES('FreieGewichte')");
            trainingsplaner.execSQL("INSERT INTO Uebungsart(uebungsartname)VALUES('Eigengewicht')");*/




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
