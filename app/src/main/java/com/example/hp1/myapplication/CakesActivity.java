package com.example.hp1.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CakesActivity extends AppCompatActivity {

    TextView tvIngredients, tvinstrostions, tvTitle;
    ImageView imageViewRecipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cakes);


        tvIngredients = (TextView) findViewById(R.id.tvIngredients);
        tvinstrostions = (TextView) findViewById(R.id.tvinstructions);
        tvTitle = (TextView) findViewById(R.id.tvTitle);

        imageViewRecipe = (ImageView) findViewById(R.id.imageViewRecipe);

        Recipe recipe = (Recipe)getIntent().getSerializableExtra("item");
        if(recipe != null) {
            tvIngredients.setText(recipe.getIngredients());
            tvinstrostions.setText(recipe.getInstructions());
            tvTitle.setText(recipe.getTitle());
        }

        Bitmap myBitmap = BitmapFactory.decodeFile(recipe.getImagePath());
        imageViewRecipe.setImageBitmap(myBitmap);
    }
}
