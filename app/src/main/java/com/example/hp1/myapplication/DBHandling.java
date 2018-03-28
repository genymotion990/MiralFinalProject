package com.example.hp1.myapplication;

/**
 * Created by Hp1 on 14/02/2018.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Hp1 on 25/01/2018.
 */

public class DBHandling extends SQLiteOpenHelper {
    private static DBHandling sInstance;
    public static final int DATABASE_VERSION=4;
    //database name
    public static final String DATABASE_NAME="sweetrecipe.db";
    //data table name
    public static final String TABLE_RECIPE="recipe";
    //Column names
    public static final String COL_ID="id";
    public static final String COL_TITLE="title";
    public static final String COL_ING="ingredients";
    public static final String COL_INST="instructions";
    public static final String COL_IMG="imgpath";
    public static final String COL_CATEGORY="category";


    public DBHandling(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public static synchronized DBHandling getInstance(Context context) {

        if (sInstance == null) {
            sInstance = new DBHandling(context.getApplicationContext());
        }
        return sInstance;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //in case table already exists need to drop then re build
        //save query to create table in database according to requirements in a string variable

        String query = " CREATE TABLE " + TABLE_RECIPE
                + "(" + COL_ID	+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_TITLE + " TEXT, "
                + COL_ING + " TEXT, "
                + COL_INST + " TEXT, "
                + COL_IMG + " TEXT, "
                + COL_CATEGORY + " TEXT "
                +");";
        Log.d("QUERY", query);

        try {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECIPE);
            db.execSQL(query);
        }catch(Exception e){
            Log.d("Couldn't add table", e.getMessage());
        }
    }
    //this method must be implemented as part of implementing the interface SQLiteoverhelper
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_RECIPE);
        onCreate(db);

    }
    //add user to the database method
    public void addRecipe(Recipe recipe){
        //create ContentValue containning values to be inserted/updated in database in this case only on column
        ContentValues values = new ContentValues();

        values.put(COL_TITLE, recipe.getTitle());
        values.put(COL_ING, recipe.getIngredients());
        values.put(COL_INST, recipe.getInstructions());
        values.put(COL_IMG, recipe.getImagePath());
        values.put(COL_CATEGORY, recipe.getCategory());

        //create SQLiteDatabase object to enable writing/reading in database
        SQLiteDatabase db = getWritableDatabase();
        long id = db.insert(TABLE_RECIPE, null, values);
        recipe.setId(id);//update the user ID according to the auto incremented id in the DB

        //logging for debugging purposes
        Log.d("ID ", "Recipe id: "+id+" added to DB");

        //close connection to database
        db.close();
    }
    //search data from DB
    public ArrayList<Recipe> getData(String category){
        String[] r = new String[6];
        int[] col = new int[6];
        String query = "SELECT * FROM "+ TABLE_RECIPE+" WHERE "+COL_CATEGORY+"='"+category+"'";

        ArrayList<Recipe> alc= new ArrayList<Recipe>();
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        col[0]=c.getColumnIndex(COL_ID);
        col[1]=c.getColumnIndex(COL_TITLE);
        col[2]=c.getColumnIndex(COL_ING);
        col[3]=c.getColumnIndex(COL_INST);
        col[4]=c.getColumnIndex(COL_IMG);
        col[5]=c.getColumnIndex(COL_CATEGORY);

        while(!c.isAfterLast()){
            for(int i=0;i<col.length;i++){
                r[i]=c.getString(col[i]);
            }
            alc.add(new Recipe(Long.parseLong(r[0]),r[1],r[2],r[3],r[4],r[5]));
            c.moveToNext();
        }
        return alc;
    }
}