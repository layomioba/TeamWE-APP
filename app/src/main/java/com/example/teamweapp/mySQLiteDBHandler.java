package com.example.teamweapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



    public class mySQLiteDBHandler extends SQLiteOpenHelper {
        public static final String TABLE_NAME="entry";
        public static final String COLUMN_NAME="title";
        public static final String COLUMN_NAME_SUBTITLE="subtitle";

        public mySQLiteDBHandler(Context context,  String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

