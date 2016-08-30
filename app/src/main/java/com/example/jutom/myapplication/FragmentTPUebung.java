package com.example.jutom.myapplication;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FragmentTPUebung extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Trainingsplaner trainingsplaner;
    int tpPositon;

    private ImageView imageView;
    private TextView uebungsname;
    private EditText editTPuebungsname;
    private TextView beschreibung;
    private EditText editBeschreibung;
    private Button save;
    private Button neuerSatz;
    private TextView satzzahl;

    String mCurrentPhotoPath;

    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_TAKE_PHOTO = 1;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Uebung uebung;
    Uebung neu;

    public FragmentTPUebung(Uebung uebung, Trainingsplaner trainingsplaner, int pos) {
        // Required empty public constructor
        this.uebung=uebung; //durch diese Referenzu werden die einzelen Parameter der Übung angezeigt
        this.trainingsplaner=trainingsplaner; //dieser Traingsplaner muss mitgegeben werden, wenn das FragmentTrainingsplanPager aufgerufen wird
        this.tpPositon=pos; //wird benötigt um die übung am Ende im Richtigen Trainingsplaner zu speicher
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        mCurrentPhotoPath=uebung.getImg();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         neu=new Uebung();
        Log.v("String", "Name ist "+uebung.getName());
        View v= inflater.inflate(R.layout.fragment_fragment_tpuebung, container, false);
        save = (Button) v.findViewById(R.id.btnSaveTP);
        imageView= (ImageView) v.findViewById(R.id.imageTPuebung);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent();

            }
        });
        setPic();
        editBeschreibung=(EditText)v.findViewById(R.id.editTPbeschreibung);
        editTPuebungsname=(EditText)v.findViewById(R.id.editTPuebung);
        satzzahl= (TextView)v.findViewById(R.id.txtSatzZiffer);
        if(uebung.getName()!=null){
           editTPuebungsname.setText(uebung.getName());
        }
        if(uebung.getBeschreibung()!=null){
            editBeschreibung.setText(uebung.getBeschreibung());
        }

        //TODO: Es muss noch geschaut werden, warum die onreult Methode nicht läuft

        satzzahl.setText(""+(uebung.getSatzList().size()+uebung.getSatzZeitList().size())); //der Teil muss auch hinzugefügt werden, wenn ein neuer Satz angelegt wird

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(uebung.getImg()!= mCurrentPhotoPath&& mCurrentPhotoPath!=null){
                    neu.setImg(mCurrentPhotoPath);
                }
                else{
                    neu.setImg(uebung.getImg());
                }
                if(uebung.getBeschreibung()==null){
                    neu.setBeschreibung(editBeschreibung.getText().toString());
                }
                else {
                    neu.setBeschreibung(uebung.getBeschreibung());
                }
                if(uebung.getName()==null){
                    neu.setName(editTPuebungsname.getText().toString());
                }
                else{
                    neu.setName(uebung.getName());
                }

                FragmentTrainingsplanerList.getTrainingsplaners().get(tpPositon).getTpUebungen().add(neu);
                FragmentTransaction ft= getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.traininsplanerlayout,new FragmentTrainingsplanPager(FragmentTrainingsplanerList.getTrainingsplaners().get(tpPositon), tpPositon));
                ft.commit();
            }
        });
        return v;
    }
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
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
                Uri photoURI = FileProvider.getUriForFile(getActivity(),
                        "com.example.android.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                Log.v("Test", takePictureIntent.getExtras().toString());
                getActivity().startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }
    private void setPic() {

        // Get the dimensions of the View
        int targetW = imageView.getWidth();
        int targetH = imageView.getHeight();
        Log.v("Bildgröße", "Das Bild ist: "+targetH+ " x "+targetW+" groß");

        Bitmap bitmap = BitmapFactory.decodeFile(mCurrentPhotoPath);
        Matrix matrix = new Matrix();

        matrix.postRotate(90);

        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap,600,600,true);

        Bitmap rotatedBitmap = Bitmap.createBitmap(scaledBitmap , 0, 0, scaledBitmap .getWidth(), scaledBitmap .getHeight(), matrix, true);

        //Bitmap bitmap = BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
        imageView.setImageBitmap(rotatedBitmap);
    }
    @Override
    public  void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == Activity.RESULT_OK) {
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
        File storageDir = getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
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
