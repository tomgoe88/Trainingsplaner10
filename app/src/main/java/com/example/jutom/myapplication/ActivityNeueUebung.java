package com.example.jutom.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ActivityNeueUebung extends AppCompatActivity {
    private String listName;
    private String typName;
    private EditText uebeschreibung;
    private EditText uename;
    private ImageView ueBild;
    private Button saveButton;
    String mCurrentPhotoPath;
    SQLiteDatabase trainingsplaner;

    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_TAKE_PHOTO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.neue_roh_uebung);
        Intent i= getIntent();
        Bundle bundle= i.getBundleExtra("LISTBUNDLE");
        Log.v("Bundle", "Bundle ist ok -> "+ bundle.getString("LIST"));
        listName= bundle.getString("LIST");
        typName= bundle.getString("TYP");
        Log.v("Listname", "Listname = "+listName);
        uebeschreibung= (EditText) findViewById(R.id.uebeschreibung);
        uename=(EditText)findViewById(R.id.uename);
        ueBild=(ImageView)findViewById(R.id.imageView2);

        saveButton= (Button)findViewById(R.id.saveButon);
        ueBild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("Image", "Image is pressed");
/*                Runnable newRun= new Runnable() {
                    @Override
                    public void run() {
                        dispatchTakePictureIntent();
                    }
                };
                Thread newThread= new Thread(newRun);
                newThread.start();*/
                dispatchTakePictureIntent();

            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUebung();
                Intent backTo= new Intent(ActivityNeueUebung.this, ActivityUebungskatalogGesamt.class);
                startActivity(backTo);
            }
        });


    }
    public void saveUebung(){
        UntererRuecken untererRuecken;
        Bauch bauch;
        Schulter schulter;
        Tricep tricep;
        Bicep bicep;
        Ruecken ruecken;
        ObererRuecken obererRuecken;
        Brust brust;
        Beine bein;

        String name= uename.getText().toString();
        String beschreibung= uebeschreibung.getText().toString();
        String bildpfad= mCurrentPhotoPath;
        Log.v("Bildpfad", "Bildpfad = "+bildpfad);
        switch (listName){
            case("UntererRuecken"):
                try {
                    trainingsplaner= this.openOrCreateDatabase("Trainingsplaner", Activity.MODE_PRIVATE, null);
                    trainingsplaner.execSQL("INSERT INTO UntererRuecken(uebungsname, uebungsbeschreibung, uebungsbild, uebungsart)VALUES('"+name+"','"+beschreibung+"', '"+bildpfad+"','"+typName+"')");
                } catch(Exception e){
                    Log.v("SQL_Fehler", e.getMessage());
                }

    /*            untererRuecken=new UntererRuecken();
                untererRuecken.setName(name);
                untererRuecken.setBeschreibung(beschreibung);
                untererRuecken.setImg(bildpfad);

                SQLHelper.getEigengewichtuntererRueckens().add(untererRuecken);*/
              // Log.v("StringPfad", "String = "+ SQLHelper.getEigengewichtuntererRueckens().get(SQLHelper.getEigengewichtuntererRueckens().size()-1).getImg());
                break;
            case("Bauch"):
                try {
                    trainingsplaner= this.openOrCreateDatabase("Trainingsplaner", Activity.MODE_PRIVATE, null);
                    trainingsplaner.execSQL("INSERT INTO Bauch(uebungsname, uebungsbeschreibung, uebungsbild, uebungsart)VALUES('"+name+"','"+beschreibung+"', '"+bildpfad+"','"+typName+"')");
                } catch(Exception e){
                    Log.v("SQL_Fehler", e.getMessage());
                }

    /*            bauch=new Bauch();
                bauch.setBeschreibung(beschreibung);
                bauch.setImg(bildpfad);
                bauch.setName(uename.getText().toString());
                SQLHelper.getEigengewichtbauches().add(bauch);*/
                break;
            case("Tricep"):
                try {
                    trainingsplaner= this.openOrCreateDatabase("Trainingsplaner", Activity.MODE_PRIVATE, null);
                    trainingsplaner.execSQL("INSERT INTO Tricep(uebungsname, uebungsbeschreibung, uebungsbild, uebungsart)VALUES('"+name+"','"+beschreibung+"', '"+bildpfad+"','"+typName+"')");
                } catch(Exception e){
                    Log.v("SQL_Fehler", e.getMessage());
                }

    /*            tricep=new Tricep();
                tricep.setBeschreibung(beschreibung);
                tricep.setImg(bildpfad);
                tricep.setName(uename.getText().toString());
                SQLHelper.getEigengewichttriceps().add(tricep);*/
                break;
            case("Bicep"):
                try {
                    trainingsplaner= this.openOrCreateDatabase("Trainingsplaner", Activity.MODE_PRIVATE, null);
                    trainingsplaner.execSQL("INSERT INTO Bicep(uebungsname, uebungsbeschreibung, uebungsbild, uebungsart)VALUES('"+name+"','"+beschreibung+"', '"+bildpfad+"','"+typName+"')");
                } catch(Exception e){
                    Log.v("SQL_Fehler", e.getMessage());
                }

/*                bicep=new Bicep();
                bicep.setBeschreibung(beschreibung);
                bicep.setImg(bildpfad);
                bicep.setName(uename.getText().toString());
                SQLHelper.getEigengewichtbiceps().add(bicep);*/
                break;
            case("Schulter"):
                try {
                    trainingsplaner= this.openOrCreateDatabase("Trainingsplaner", Activity.MODE_PRIVATE, null);
                    trainingsplaner.execSQL("INSERT INTO Schulter(uebungsname, uebungsbeschreibung, uebungsbild, uebungsart)VALUES('"+name+"','"+beschreibung+"', '"+bildpfad+"','"+typName+"')");
                } catch(Exception e){
                    Log.v("SQL_Fehler", e.getMessage());
                }

                schulter=new Schulter();
                schulter.setBeschreibung(beschreibung);
                schulter.setImg(bildpfad);
                schulter.setName(uename.getText().toString());
                SQLHelper.getEigengewichtschulters().add(schulter);
                break;
            case("ObererRuecken"):
                try {
                    trainingsplaner= this.openOrCreateDatabase("Trainingsplaner", Activity.MODE_PRIVATE, null);
                    trainingsplaner.execSQL("INSERT INTO ObererRuecken(uebungsname, uebungsbeschreibung, uebungsbild, uebungsart)VALUES('"+name+"','"+beschreibung+"', '"+bildpfad+"','"+typName+"')");
                } catch(Exception e){
                    Log.v("SQL_Fehler", e.getMessage());
                }

 /*               obererRuecken=new ObererRuecken();
                obererRuecken.setBeschreibung(beschreibung);
                obererRuecken.setImg(bildpfad);
                obererRuecken.setName(uename.getText().toString());
                SQLHelper.getEigengewichtobererRueckens().add(obererRuecken);*/
                break;
            case("Ruecken"):
                try {
                    trainingsplaner= this.openOrCreateDatabase("Trainingsplaner", Activity.MODE_PRIVATE, null);
                    trainingsplaner.execSQL("INSERT INTO Ruecken(uebungsname, uebungsbeschreibung, uebungsbild, uebungsart)VALUES('"+name+"','"+beschreibung+"', '"+bildpfad+"','"+typName+"')");
                } catch(Exception e){
                    Log.v("SQL_Fehler", e.getMessage());
                }

   /*             ruecken=new Ruecken();
                ruecken.setBeschreibung(beschreibung);
                ruecken.setImg(bildpfad);
                ruecken.setName(uename.getText().toString());
                SQLHelper.getEigengewichtrueckens().add(ruecken);*/
                break;
            case("Beine"):
                try {
                    trainingsplaner= this.openOrCreateDatabase("Trainingsplaner", Activity.MODE_PRIVATE, null);
                    trainingsplaner.execSQL("INSERT INTO Beine(uebungsname, uebungsbeschreibung, uebungsbild, uebungsart)VALUES('"+name+"','"+beschreibung+"', '"+bildpfad+"','"+typName+"')");
                } catch(Exception e){
                    Log.v("SQL_Fehler", e.getMessage());
                }

/*                bein=new Beine();
                bein.setBeschreibung(beschreibung);
                bein.setImg(bildpfad);
                bein.setName(uename.getText().toString());
                SQLHelper.getEigengewichtbeines().add(bein);*/
                break;
            case("Brust"):
                try {
                    trainingsplaner= this.openOrCreateDatabase("Trainingsplaner", Activity.MODE_PRIVATE, null);
                    trainingsplaner.execSQL("INSERT INTO Brust(uebungsname, uebungsbeschreibung, uebungsbild, uebungsart)VALUES('"+name+"','"+beschreibung+"', '"+bildpfad+"','"+typName+"')");
                } catch(Exception e){
                    Log.v("SQL_Fehler", e.getMessage());
                }

          /*      brust=new Brust();
                brust.setBeschreibung(beschreibung);
                brust.setImg(bildpfad);
                brust.setName(uename.getText().toString());
                SQLHelper.getEigengewichtbrusts().add(brust);*/
                break;



        }
    }
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                Log.v("Take Picture", ex.getMessage());
            }
            Log.v("Test", photoFile.toString());
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.android.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                Log.v("Test", takePictureIntent.getExtras().toString());
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }
    private void setPic() {
        Log.v("Test", mCurrentPhotoPath.toString());
        // Get the dimensions of the View
        int targetW = ueBild.getWidth();
        int targetH = ueBild.getHeight();
        Log.v("Bildgröße", "Das Bild ist: "+targetH+ " x "+targetW+" groß");

        Bitmap bitmap = BitmapFactory.decodeFile(mCurrentPhotoPath);
        Matrix matrix = new Matrix();

        matrix.postRotate(90);

        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap,600,600,true);

        Bitmap rotatedBitmap = Bitmap.createBitmap(scaledBitmap , 0, 0, scaledBitmap .getWidth(), scaledBitmap .getHeight(), matrix, true);

        //Bitmap bitmap = BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
        ueBild.setImageBitmap(rotatedBitmap);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
/*            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ueBild.setImageBitmap(imageBitmap);*/
            setPic();
        }
    }
    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath =image.getAbsolutePath();
        return image;
    }
}
