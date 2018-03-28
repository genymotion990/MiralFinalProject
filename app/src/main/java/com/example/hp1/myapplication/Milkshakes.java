package com.example.hp1.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Milkshakes extends AppCompatActivity implements AdapterView.OnItemClickListener,View.OnClickListener {

    ListView lvMyshakes; //3rfna 3l listview shakes
    ArrayAdapter<String> adapter;
    ArrayList<String> arrshakes = new ArrayList();

    Button btshakesrec;
    String ingredients, instructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milkshakes);

        Intent i = getIntent();
        ingredients = i.getStringExtra("ingredients");
        instructions = i.getStringExtra("instructions");

        lvMyshakes = (ListView) findViewById(R.id.lvMyshakes);

        arrshakes.add("Chocolate milkshake");
        arrshakes.add("Vanilla milkshake");
        arrshakes.add("Strawbary milkshake");

        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, arrshakes);
        lvMyshakes.setAdapter(adapter);
        lvMyshakes.setOnItemClickListener(this);

        btshakesrec = (Button) findViewById(R.id.btshakerec);
        btshakesrec.setOnClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0) {
            Intent i = new Intent(this, Chocolate_shake.class);
            startActivity(i);
        }
        if (position == 1) {
            Intent i = new Intent(this, Vanilla_shake.class);
            startActivity(i);
        }
        if (position == 2) {
            Intent i = new Intent(this, Strawbary_shake.class);
            startActivity(i);
        }
    }

    @Override
    public void onClick(View v) {
        if (v == btshakesrec) {
            Intent i = new Intent(this, Shakesrec.class);
            startActivity(i);

        }
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
}
