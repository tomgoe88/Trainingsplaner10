package com.example.jutom.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
    private EditText uebeschreibung;
    private EditText uename;
    private ImageView ueBild;
    private Button saveButton;
    String mCurrentPhotoPath;

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
            case("EigenUntererRuecken"):
                untererRuecken=new UntererRuecken();
                untererRuecken.setName(name);
                untererRuecken.setBeschreibung(beschreibung);
                untererRuecken.setImg(bildpfad);

                SQLHelper.getEigengewichtuntererRueckens().add(untererRuecken);
               Log.v("StringPfad", "String = "+ SQLHelper.getEigengewichtuntererRueckens().get(SQLHelper.getEigengewichtuntererRueckens().size()-1).getImg());
                break;
            case("EigenBauch"):
                bauch=new Bauch();
                bauch.setBeschreibung(beschreibung);
                bauch.setImg(bildpfad);
                bauch.setName(uename.getText().toString());
                SQLHelper.getEigengewichtbauches().add(bauch);
                break;
            case("EigenTricep"):
                tricep=new Tricep();
                tricep.setBeschreibung(beschreibung);
                tricep.setImg(bildpfad);
                tricep.setName(uename.getText().toString());
                SQLHelper.getEigengewichttriceps().add(tricep);
                break;
            case("EigenBicep"):
                bicep=new Bicep();
                bicep.setBeschreibung(beschreibung);
                bicep.setImg(bildpfad);
                bicep.setName(uename.getText().toString());
                SQLHelper.getEigengewichtbiceps().add(bicep);
                break;
            case("EigenSchulter"):
                schulter=new Schulter();
                schulter.setBeschreibung(beschreibung);
                schulter.setImg(bildpfad);
                schulter.setName(uename.getText().toString());
                SQLHelper.getEigengewichtschulters().add(schulter);
                break;
            case("EigenObererRuecken"):
                obererRuecken=new ObererRuecken();
                obererRuecken.setBeschreibung(beschreibung);
                obererRuecken.setImg(bildpfad);
                obererRuecken.setName(uename.getText().toString());
                SQLHelper.getEigengewichtobererRueckens().add(obererRuecken);
                break;
            case("EigenRuecken"):
                ruecken=new Ruecken();
                ruecken.setBeschreibung(beschreibung);
                ruecken.setImg(bildpfad);
                ruecken.setName(uename.getText().toString());
                SQLHelper.getEigengewichtrueckens().add(ruecken);
                break;
            case("EigenBein"):
                bein=new Beine();
                bein.setBeschreibung(beschreibung);
                bein.setImg(bildpfad);
                bein.setName(uename.getText().toString());
                SQLHelper.getEigengewichtbeines().add(bein);
                break;
            case("EigenBrust"):
                brust=new Brust();
                brust.setBeschreibung(beschreibung);
                brust.setImg(bildpfad);
                brust.setName(uename.getText().toString());
                SQLHelper.getEigengewichtbrusts().add(brust);
                break;
            case("FreieUntererRuecken"):
                untererRuecken=new UntererRuecken();
                untererRuecken.setBeschreibung(beschreibung);
                untererRuecken.setImg(bildpfad);

                untererRuecken.setName(uename.getText().toString());
                SQLHelper.getFreieuntererRueckens().add(untererRuecken);
                break;
            case("FreieBauch"):
                bauch=new Bauch();
                bauch.setBeschreibung(beschreibung);
                bauch.setImg(bildpfad);
                bauch.setName(uename.getText().toString());
                SQLHelper.getFreiebauches().add(bauch);
                break;
            case("FreieTricep"):
                tricep=new Tricep();
                tricep.setBeschreibung(beschreibung);
                tricep.setImg(bildpfad);
                tricep.setName(uename.getText().toString());
                SQLHelper.getFreietriceps().add(tricep);
                break;
            case("FreieBicep"):
                bicep=new Bicep();
                bicep.setBeschreibung(beschreibung);
                bicep.setImg(bildpfad);
                bicep.setName(uename.getText().toString());
                SQLHelper.getFreiebiceps().add(bicep);
                break;
            case("FreieSchulter"):
                schulter=new Schulter();
                schulter.setBeschreibung(beschreibung);
                schulter.setImg(bildpfad);
                schulter.setName(uename.getText().toString());
                SQLHelper.getFreieschulters().add(schulter);
                break;
            case("FreieObererRuecken"):
                obererRuecken=new ObererRuecken();
                obererRuecken.setBeschreibung(beschreibung);
                obererRuecken.setImg(bildpfad);

                obererRuecken.setName(uename.getText().toString());
                SQLHelper.getFreieobererRueckens().add(obererRuecken);
                break;
            case("FreieRuecken"):
                ruecken=new Ruecken();
                ruecken.setBeschreibung(beschreibung);
                ruecken.setImg(bildpfad);
                ruecken.setName(uename.getText().toString());
                SQLHelper.getFreierueckens().add(ruecken);
                break;
            case("FreieBein"):
                bein=new Beine();
                bein.setBeschreibung(beschreibung);
                bein.setImg(bildpfad);
                bein.setName(uename.getText().toString());
                SQLHelper.getFreiebeines().add(bein);
                break;
            case("FreieBrust"):
                brust=new Brust();
                brust.setBeschreibung(beschreibung);
                brust.setImg(bildpfad);
                brust.setName(uename.getText().toString());
                SQLHelper.getFreiebrusts().add(brust);
                break;
            case("FunktionallUntererRuecken"):
                untererRuecken=new UntererRuecken();
                untererRuecken.setBeschreibung(beschreibung);
                untererRuecken.setImg(bildpfad);
                untererRuecken.setName(uename.getText().toString());
                SQLHelper.getFunktionelluntererRueckens().add(untererRuecken);
                break;
            case("FunktionellBauch"):
                bauch=new Bauch();
                bauch.setBeschreibung(beschreibung);
                bauch.setImg(bildpfad);
                bauch.setName(uename.getText().toString());
                SQLHelper.getFunktionellbauches().add(bauch);
                break;
            case("FunktionellTricep"):
                tricep=new Tricep();
                tricep.setBeschreibung(beschreibung);
                tricep.setImg(bildpfad);
                tricep.setName(uename.getText().toString());
                SQLHelper.getFunktionelltriceps().add(tricep);
                break;
            case("FunktionellBicep"):
                bicep=new Bicep();
                bicep.setBeschreibung(beschreibung);
                bicep.setImg(bildpfad);
                bicep.setName(uename.getText().toString());
                SQLHelper.getFunktionellbiceps().add(bicep);
                break;
            case("FunktionellSchulter"):
                schulter=new Schulter();
                schulter.setBeschreibung(beschreibung);
                schulter.setImg(bildpfad);
                schulter.setName(uename.getText().toString());
                SQLHelper.getFunktionellschulters().add(schulter);
                break;
            case("FunktionellObererRuecken"):
                obererRuecken=new ObererRuecken();
                obererRuecken.setBeschreibung(beschreibung);
                obererRuecken.setImg(bildpfad);
                obererRuecken.setName(uename.getText().toString());
                SQLHelper.getFunktionellobererRueckens().add(obererRuecken);
                break;
            case("FunktionellRuecken"):
                ruecken=new Ruecken();
                ruecken.setBeschreibung(beschreibung);
                ruecken.setImg(bildpfad);
                ruecken.setName(uename.getText().toString());
                SQLHelper.getFunktionellrueckens().add(ruecken);
                break;
            case("FunktionellBein"):
                bein=new Beine();
                bein.setBeschreibung(beschreibung);
                bein.setImg(bildpfad);
                bein.setName(uename.getText().toString());
                SQLHelper.getFunktionellbeines().add(bein);
                break;
            case("FunktionellBrust"):
                brust=new Brust();
                brust.setBeschreibung(beschreibung);
                brust.setImg(bildpfad);
                brust.setName(uename.getText().toString());
                SQLHelper.getFunktionellbrusts().add(brust);
                break;
            case("MaschineUntererRuecken"):
                untererRuecken=new UntererRuecken();
                untererRuecken.setBeschreibung(beschreibung);
                untererRuecken.setImg(bildpfad);
                untererRuecken.setName(uename.getText().toString());
                SQLHelper.getMaschineuntererRueckens().add(untererRuecken);
                break;
            case("MaschineBauch"):
                bauch=new Bauch();
                bauch.setBeschreibung(beschreibung);
                bauch.setImg(bildpfad);
                bauch.setName(uename.getText().toString());
                SQLHelper.getMaschinebauches().add(bauch);
                break;
            case("MaschineTricep"):
                tricep=new Tricep();
                tricep.setBeschreibung(beschreibung);
                tricep.setImg(bildpfad);
                tricep.setName(uename.getText().toString());
                SQLHelper.getMaschinetriceps().add(tricep);
                break;
            case("MaschineBicep"):
                bicep=new Bicep();
                bicep.setBeschreibung(beschreibung);
                bicep.setImg(bildpfad);
                bicep.setName(uename.getText().toString());
                SQLHelper.getMaschinebiceps().add(bicep);
                break;
            case("MaschineSchulter"):
                schulter=new Schulter();
                schulter.setBeschreibung(beschreibung);
                schulter.setImg(bildpfad);
                schulter.setName(uename.getText().toString());
                SQLHelper.getMaschineschulters().add(schulter);
                break;
            case("MaschineObererRuecken"):
                obererRuecken=new ObererRuecken();
                obererRuecken.setBeschreibung(beschreibung);
                obererRuecken.setImg(bildpfad);
                obererRuecken.setName(uename.getText().toString());
                SQLHelper.getMaschineobererRueckens().add(obererRuecken);
                break;
            case("MaschineRuecken"):
                ruecken=new Ruecken();
                ruecken.setBeschreibung(beschreibung);
                ruecken.setImg(bildpfad);
                ruecken.setName(uename.getText().toString());
                SQLHelper.getMaschinerueckens().add(ruecken);
                break;
            case("MaschineBein"):
                bein=new Beine();
                bein.setBeschreibung(beschreibung);
                bein.setImg(bildpfad);
                bein.setName(uename.getText().toString());
                SQLHelper.getMaschinebeines().add(bein);
                break;
            case("MaschineBrust"):
                brust=new Brust();
                brust.setBeschreibung(beschreibung);
                brust.setImg(bildpfad);
                brust.setName(uename.getText().toString());
                SQLHelper.getMaschinebrusts().add(brust);
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

        // Get the dimensions of the bitmap
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
        int photoW = bmOptions.outWidth;
        int photoH = bmOptions.outHeight;

        // Determine how much to scale down the image
        int scaleFactor = Math.min(photoW/targetW, photoH/targetH);

        // Decode the image file into a Bitmap sized to fill the View
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;
        bmOptions.inPurgeable = true;

        Bitmap bitmap = BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
        ueBild.setImageBitmap(bitmap);
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
