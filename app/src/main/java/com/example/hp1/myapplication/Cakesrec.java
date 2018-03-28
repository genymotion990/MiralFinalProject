package com.example.hp1.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cakesrec extends AppCompatActivity implements View.OnClickListener{

    Button btgalery, btcamera;
    Button btnAddrecipec;
    ImageView imageview;
    private Bitmap bitmap;
    File image=null;
    String path = null;

    EditText etTitle, etIngredients, etInstructions;

    DBHandling db;

    static final int SELECT_IMAGE=1;
    static final int TAKE_IMAGE=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cakesrec);

        db = DBHandling.getInstance(this);

        etTitle = (EditText) findViewById(R.id.etTitle);
        etIngredients = (EditText) findViewById(R.id.etCakesRecipe1);
        etInstructions = (EditText) findViewById(R.id.etCakesRecipe2);

        btcamera=(Button) findViewById(R.id.btcamera);
        btgalery=(Button) findViewById(R.id.btgalery);
        btnAddrecipec = (Button) findViewById(R.id.btnAddrecipec);

        btnAddrecipec.setOnClickListener(this);
        btcamera.setOnClickListener(this);
        btgalery.setOnClickListener(this);

        imageview = (ImageView) findViewById(R.id.recipeImage);
    }

    @Override
    public void onClick(View v) {
       if(v==btcamera){
            Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(i,TAKE_IMAGE);
        }else if (v==btgalery){
            Intent i = new Intent(Intent.ACTION_PICK,
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(i, SELECT_IMAGE);
        }
        else if (v == btnAddrecipec) {

           Recipe recipe = new Recipe(etTitle.getText().toString(), etIngredients.getText().toString(), etInstructions.getText().toString(),path, "cakes");
           db.addRecipe(recipe);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Are you sure you want to Add this cake?");
            builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    startActivity(new Intent(Cakesrec.this, Cakes.class));
                }
            });
            builder.setNegativeButton("no", null);
            AlertDialog dialog = builder.create();
            dialog.show();



        }
    }
    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data){

        if (requestCode == TAKE_IMAGE && requestCode == RESULT_OK){
            Bundle extra = data.getExtras();
            bitmap = (Bitmap)extra.get("data");
            imageview.setImageBitmap(bitmap);
            image = saveImage(bitmap);
            path = image.getPath();

        }else if(requestCode == SELECT_IMAGE && resultCode == RESULT_OK) {
            Uri targetUri = data.getData();
            path = targetUri.getPath();
            Bitmap bitmap;
            try {
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
                imageview.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }


    }
    public File saveImage(Bitmap bitmap){
        File root = Environment.getExternalStorageDirectory();// internal storage launching .
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        String filePath = root.getAbsolutePath()+"/DCIM/Camera/IMG_"+timeStamp+".jpg";
        File file = new File(filePath);// determinig the type of the file and its place.

        try
        {
            // if gallary nit full create a file and save images
            file.createNewFile();// create new file to save image.
            FileOutputStream ostream = new FileOutputStream(file);//saves root in this file
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, ostream);// compass bitmap in file
            ostream.close();// close
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(this, "Faild to save image", Toast.LENGTH_SHORT).show();
        }
        return file;
    }
}

