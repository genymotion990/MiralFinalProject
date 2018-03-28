package com.example.hp1.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Cakes extends AppCompatActivity implements AdapterView.OnItemClickListener,View.OnClickListener {

    ListView lvmycakes;//3rfna 3listview Cakes
    CustomAdapter adapter;
    ArrayList<Recipe> arrcakes = new ArrayList<Recipe>();
    ArrayList<Recipe> recipes = new ArrayList<>();

    DBHandling db;
    Button btcakesrec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cackes_list_activity);

        lvmycakes = (ListView) findViewById(R.id.lvMyCakes);

        db =DBHandling.getInstance(this);
        recipes = db.getData("cakes");
//    public Recipe(String title, String ingredients, String instructions, String imagePath, String category) {

        arrcakes.add(new Recipe("Chees Cake","a","B","C","cakes"));
        arrcakes.add(new Recipe ("Orange Cake","","","","cakes"));
        arrcakes.add(new Recipe ("Chocolate Cake","","","","cakes"));

        for (int i = 0; i < recipes.size(); i++)
        {
            arrcakes.addAll(i,recipes);
        }

        adapter = new CustomAdapter(this, R.layout.custom_row,arrcakes);
        lvmycakes.setAdapter(adapter);
        lvmycakes.setOnItemClickListener(this);

        btcakesrec = (Button) findViewById(R.id.btAddrecipe);
        btcakesrec.setOnClickListener(this);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_menu, menu);
        return super.onCreateOptionsMenu(menu);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i;
        switch(item.getItemId())
        {
            case R.id.mnabout:
                i =  new Intent(this,About.class);
                startActivity(i);
                break;
            case R.id.mnwarning:
                i = new Intent(this,Warning.class);
                startActivity(i);
                break;
        }
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Recipe item = (Recipe) adapter.getItem(position);
        Intent i = new Intent(this, CakesActivity.class);
        i.putExtra("item",item);
        startActivity(i);

    }

    @Override
    public void onClick(View v) {
        if (v == btcakesrec) {
            Intent i = new Intent(this, Cakesrec.class);
            startActivity(i);
        }
    }
}