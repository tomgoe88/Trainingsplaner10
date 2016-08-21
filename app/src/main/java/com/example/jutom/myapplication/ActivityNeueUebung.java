package com.example.jutom.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class ActivityNeueUebung extends AppCompatActivity {
    private String listName;
    private EditText uebeschreibung;
    private EditText uename;
    private ImageView ueBild;
    private Button saveButton;

    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.neue_roh_uebung);
        Bundle bundle= getIntent().getExtras();

        listName= bundle.getString("LIST");
        Log.v("Listname", "Listname = "+listName);
        uebeschreibung= (EditText) findViewById(R.id.uebeschreibung);
        uename=(EditText)findViewById(R.id.uename);
        ueBild=(ImageView)findViewById(R.id.uebungBild);
        saveButton= (Button)findViewById(R.id.saveButon);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (listName){
                    case(""):
                        Bauch uebung=new Bauch();
                        uebung.setName(uename.getText().toString());
                        SQLHelper.getEigengewichtbauches().add(uebung);
                        break;


                }
            }
        });


    }
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ueBild.setImageBitmap(imageBitmap);
        }
    }
}
