package com.example.hp1.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class RecipeDetailsActivity extends AppCompatActivity {

    ListView lvIng;
    ArrayList<Item> items = new ArrayList<Item>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details2);

        lvIng = (ListView) findViewById(R.id.lvIng);
        items.add(new Item("First",R.drawable.cake));

      //  CustomAdapter adapter = new CustomAdapter(this, R.layout.custom_row, items);
      //  lvIng.setAdapter(adapter);


    }
}
