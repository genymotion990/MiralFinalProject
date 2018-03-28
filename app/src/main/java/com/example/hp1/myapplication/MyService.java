package com.example.hp1.myapplication;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Menu;
import android.view.MenuItem;

public class MyService extends Service{
	private MediaPlayer mp;
	private static boolean isRunning=false;
	public MyService(){
		
	}
	@Override
	/**
	 * return null
	 */
	public IBinder onBind(Intent intent) {
		return null;
	}
	@Override
	public void onCreate() {
		super.onCreate();
		mp=MediaPlayer.create(getApplicationContext(), R.raw.bensound_sweet);
	}
	
	@Override
	/**
	 * Start music
	 */
	public int onStartCommand(Intent intent, int flags, int startId) {
		mp.setLooping(true);
		mp.start();
		isRunning=true;
		return START_NOT_STICKY;
	}
	@Override
	/**
	 * Destroy and stop music
	 */
	public void onDestroy() {
		mp.stop();
		isRunning=false;
		super.onDestroy();
	}
	/**
	 * 
	 * @return isRunning
	 */
	public static boolean isRunning() {
		return isRunning;
	}


}