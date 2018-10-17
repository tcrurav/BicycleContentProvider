package com.example.tibur.bicyclecontentprovider.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.tibur.bicyclecontentprovider.bicycle.data.BicycleContract;

public class BicycleShopDatabase extends SQLiteOpenHelper {

    private final static String DATABASE_NAME = "bicycle_shop.db";
    private final static int DATABASE_VERSION = 1;

    public BicycleShopDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + BicycleContract.TABLE_NAME +
                    " ( _id INTEGER PRIMARY KEY ON CONFLICT ROLLBACK AUTOINCREMENT," +
                        BicycleContract.MODEL + " TEXT, " +
                        BicycleContract.YEAR +  " INTEGER );");

        initilizeData(db);
    }

    private void initilizeData(SQLiteDatabase db) {
        db.execSQL("INSERT INTO " + BicycleContract.TABLE_NAME + " ( " +
                BicycleContract._ID + "," + BicycleContract.MODEL + "," + BicycleContract.YEAR +" ) " +
                "VALUES (1, 'Orbea', 1982)");
        db.execSQL("INSERT INTO " + BicycleContract.TABLE_NAME + " ( " +
                BicycleContract._ID + "," + BicycleContract.MODEL + "," + BicycleContract.YEAR +" ) " +
                "VALUES (2, 'BH', 1984)");
        db.execSQL("INSERT INTO " + BicycleContract.TABLE_NAME + " ( " +
                BicycleContract._ID + "," + BicycleContract.MODEL + "," + BicycleContract.YEAR +" ) " +
                "VALUES (3, 'Trek', 2002)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + BicycleContract.TABLE_NAME);
        onCreate(db);
    }
}
