package com.example.hp1.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class Shakesrec extends AppCompatActivity implements View.OnClickListener{

    TextView tvmilkIns, tvmilkIng;
    Button btAddImagesh;
    Button btAddrecipesh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shakesrec);

        tvmilkIns = (TextView)findViewById(R.id.tvmilkIns);
        tvmilkIng = (TextView)findViewById(R.id.tvmilkIng);

        btAddrecipesh = (Button)findViewById(R.id.btAddrecipesh);
        btAddrecipesh.setOnClickListener(this);

        btAddImagesh = (Button) findViewById(R.id.btAddImagesh);
        btAddImagesh.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==btAddImagesh){
            Intent i = new Intent(this, Camera.class);
            i.putExtra("category","shakes");
            startActivity(i);
        }
        else if(v == btAddrecipesh){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Are you sure you want to Add this milkshake?");
            builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {


                @Override
                public void onClick(DialogInterface dialog, int which) {

                    Intent i = new Intent(Shakesrec.this,Milkshakes.class);
                    i.putExtra("ingredients",tvmilkIng.getText().toString() );
                    i.putExtra("instructions",tvmilkIns.getText().toString() );
                    startActivity(i);
                }
            });
            builder.setNegativeButton("no",null);
            AlertDialog dialog = builder.create();
            dialog.show();

        }


        }

    }


