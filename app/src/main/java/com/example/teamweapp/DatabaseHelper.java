package com.example.teamweapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

//inheritance
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String PLAYER_CREDENTIALS = "PLAYER_CREDENTIALS";
    public static final String PLAYER_USERNAME = "PLAYER_USERNAME";
    public static final String PLAYER_PASSWORD = "PLAYER_PASSWORD";
    public static final String ID = "ID";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "credentials.db", null, 1);
    }


    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + PLAYER_CREDENTIALS + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + PLAYER_USERNAME + " TEXT, " + PLAYER_PASSWORD + " TEXT)";
        db.execSQL(createTableStatement);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

public boolean addOne(CredentialsModel credentialsModel) {
    SQLiteDatabase db = this.getWritableDatabase();

    ContentValues cv = new ContentValues();
    cv.put(PLAYER_USERNAME, credentialsModel.getUsername());
    cv.put(PLAYER_PASSWORD, credentialsModel.getPassword());

    long insert = db.insert(PLAYER_CREDENTIALS, null, cv);
    if (insert == -1) {
        return false;
    } else {
        return true;

    }
}
public List <CredentialsModel> getEveryone(){
        List<CredentialsModel> returnList=new ArrayList<>();
        String queryString="SELECT * FROM " + PLAYER_CREDENTIALS;
    SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor=db.rawQuery(queryString,null);

        if (cursor.moveToFirst()) {
            do {
                int playersID = cursor.getInt(0);
                String playersUsername = cursor.getString(1);
                String playersPassword = cursor.getString(2);
                CredentialsModel newCredential = new CredentialsModel(playersID, playersUsername, playersPassword);
                returnList.add(newCredential);
            } while (cursor.moveToNext()) ;{
            }
        }else{
            //failure-doesn't add anything to the list
        }
            cursor.close();
            db.close();
            return returnList;
    }

    }




