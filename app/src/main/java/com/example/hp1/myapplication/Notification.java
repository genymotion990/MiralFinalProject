package com.example.hp1.myapplication;

import android.app.NotificationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class Notification extends AppCompatActivity implements View.OnClickListener{

private NotificationCompat.Builder builder;
    private Button btnNotify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        btnNotify = (Button) findViewById(R.id.btnNotify);

        //create builder object
        builder = new NotificationCompat.Builder(this);

        //customize the builder
        builder.setSmallIcon(R.drawable.blucupcake);
        builder.setContentTitle("cupcake");
        builder.setContentText("new ideas for cupcakes");
    }

    @Override
    public void onClick(View v) {
        //add as notification
        NotificationManager manager = (NotificationManager) getSystemService(getApplicationContext().NOTIFICATION_SERVICE);

    }
}
