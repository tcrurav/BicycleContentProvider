package com.example.tibur.bicyclecontentprovider.bicycle.data;

import android.provider.BaseColumns;

import com.example.tibur.bicyclecontentprovider.BicycleShopApplication;

public class BicycleContract implements BaseColumns {
    public static String TABLE_NAME = "bicycle";
    public static String CONTENT_URI = "content://" + BicycleShopApplication.AUTHORITY + "/" + TABLE_NAME;

    public static String MODEL = "model";
    public static String YEAR = "year";
}
