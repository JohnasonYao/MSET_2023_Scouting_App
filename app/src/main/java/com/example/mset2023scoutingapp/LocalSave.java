package com.example.mset2023scoutingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LocalSave extends MainActivity{

    static public class DBHelper extends SQLiteOpenHelper {

        private static final String DATABASE_NAME = "myDatabase.db";
        private static final int DATABASE_VERSION = 1;

        public DBHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String CREATE_TABLE = "CREATE TABLE records (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "firstName TEXT, lastName TEXT, matchNumber INTEGER," +
                    "team INTEGER, mobility INTEGER, autoRaw TEXT," +
                    "teleRaw TEXT, broke INTEGER, totalScore INTEGER," +
                    "comments TEXT, cycleTime INTEGER, defenceRating INTEGER)";
            db.execSQL(CREATE_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS records");
            onCreate(db);
        }

        public void addRecord(String firstName, String lastName, int match,
                              int team, boolean mobility, String autoRaw,
                              String teleRaw, boolean broke, int totalScore,
                              String comments, int cycleTime, int defenceRating) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("firstName", firstName);
            contentValues.put("lastName", lastName);
            contentValues.put("matchNumber", match);
            contentValues.put("team", team);
            contentValues.put("mobility", mobility ? 1 : 0);
            contentValues.put("autoRaw", autoRaw);
            contentValues.put("teleRaw", teleRaw);
            contentValues.put("broke", broke ? 1 : 0);
            contentValues.put("totalScore", totalScore);
            contentValues.put("comments", comments);
            contentValues.put("cycleTime", cycleTime);
            contentValues.put("defenceRating", defenceRating);
            db.insert("records", null, contentValues);
            db.close();
        }
    }





}
