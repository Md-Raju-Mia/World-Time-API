package com.example.finalgetapi.sqdatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "timezone.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "timezone_data"; // Ensure this matches
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_ABBREVIATION = "abbreviation";
    public static final String COLUMN_CLIENT_IP = "client_ip";
    public static final String COLUMN_DATETIME = "datetime";
    public static final String COLUMN_DAY_OF_WEEK = "day_of_week";
    public static final String COLUMN_DAY_OF_YEAR = "day_of_year";
    public static final String COLUMN_DST = "dst";
    public static final String COLUMN_DST_FROM = "dst_from";
    public static final String COLUMN_DST_OFFSET = "dst_offset";
    public static final String COLUMN_DST_UNTIL = "dst_until";
    public static final String COLUMN_RAW_OFFSET = "raw_offset";
    public static final String COLUMN_TIMEZONE = "timezone";
    public static final String COLUMN_UNIXTIME = "unixtime";
    public static final String COLUMN_UTC_DATETIME = "utc_datetime";
    public static final String COLUMN_UTC_OFFSET = "utc_offset";
    public static final String COLUMN_WEEK_NUMBER = "week_number";

    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_ABBREVIATION + " TEXT, " +
                    COLUMN_CLIENT_IP + " TEXT, " +
                    COLUMN_DATETIME + " TEXT, " +
                    COLUMN_DAY_OF_WEEK + " INTEGER, " +
                    COLUMN_DAY_OF_YEAR + " INTEGER, " +
                    COLUMN_DST + " INTEGER, " +
                    COLUMN_DST_FROM + " TEXT, " +
                    COLUMN_DST_OFFSET + " INTEGER, " +
                    COLUMN_DST_UNTIL + " TEXT, " +
                    COLUMN_RAW_OFFSET + " INTEGER, " +
                    COLUMN_TIMEZONE + " TEXT, " +
                    COLUMN_UNIXTIME + " INTEGER, " +
                    COLUMN_UTC_DATETIME + " TEXT, " +
                    COLUMN_UTC_OFFSET + " TEXT, " +
                    COLUMN_WEEK_NUMBER + " INTEGER);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
