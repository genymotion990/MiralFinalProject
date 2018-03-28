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

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

   Button btshakes,btcakes; // 1 lal shakes w 2 lal Cakes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btshakes=(Button)findViewById(R.id.btshakes);
        btshakes.setOnClickListener(this);

        btcakes=(Button)findViewById(R.id.btcakes);
        btcakes.setOnClickListener(this);

//plays background music
        Intent sr = new Intent(this, MyService.class);
        startService(sr);


    }

    /**
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        if (v == btshakes) {
            Intent i = new Intent(this, Milkshakes.class);
            startActivity(i);
        }
        if (v == btcakes) {
            Intent i = new Intent(this, Cakes.class);
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
