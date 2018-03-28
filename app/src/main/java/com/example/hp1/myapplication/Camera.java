package com.example.hp1.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.app.Activity.RESULT_OK;

public class Camera extends AppCompatActivity implements View.OnClickListener {

    Button btcamera,btgalery;
    ImageView imageview;
    private Bitmap bitmap;
    static final int SELECT_IMAGE=1;
    static final int TAKE_IMAGE=0;
    String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        category = getIntent().getStringExtra("category");

        imageview=(ImageView)findViewById(R.id.imageview);

        btcamera=(Button) findViewById(R.id.btcamera);
        btgalery=(Button) findViewById(R.id.btgalery);

        btcamera.setOnClickListener(this);
        btgalery.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==btcamera){
            Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(i,TAKE_IMAGE);
        }else{
            Intent i = new Intent(Intent.ACTION_PICK,
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(i, SELECT_IMAGE);
        }

    }
    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data){
        File image=null;
        if (requestCode == TAKE_IMAGE && requestCode == RESULT_OK){
            Bundle extra = data.getExtras();
            bitmap = (Bitmap)extra.get("data");
            imageview.setImageBitmap(bitmap);
            image = saveImage(bitmap);

        }else if(requestCode == SELECT_IMAGE && resultCode == RESULT_OK) {
            Uri targetUri = data.getData();

            Bitmap bitmap;
            try {
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
                imageview.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        if(category.equals("Cakes") && image != null)
        {
            Intent i = new Intent(this, Cakesrec.class);
            i.putExtra("path",image.getAbsoluteFile());
            startActivity(i);
        }else{
            if(image != null) {
                Intent i = new Intent(this, Shakesrec.class);
                i.putExtra("path", image.getAbsoluteFile());
                startActivity(i);
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

