package com.example.finalgetapi.sqdatabase;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.finalgetapi.model.ResponseModel;

import java.util.ArrayList;
import java.util.List;

public class TimezoneDao {
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public TimezoneDao(Context context) {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
    }

    public void insert(ResponseModel model) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_ABBREVIATION, model.getAbbreviation());
        values.put(DatabaseHelper.COLUMN_CLIENT_IP, model.getClientIp());
        values.put(DatabaseHelper.COLUMN_DATETIME, model.getDatetime());
        values.put(DatabaseHelper.COLUMN_DAY_OF_WEEK, model.getDayOfWeek());
        values.put(DatabaseHelper.COLUMN_DAY_OF_YEAR, model.getDayOfYear());
        values.put(DatabaseHelper.COLUMN_DST, model.isDst() ? 1 : 0);
        values.put(DatabaseHelper.COLUMN_DST_FROM, model.getDstFrom());
        values.put(DatabaseHelper.COLUMN_DST_OFFSET, model.getDstOffset());
        values.put(DatabaseHelper.COLUMN_DST_UNTIL, model.getDstUntil());
        values.put(DatabaseHelper.COLUMN_RAW_OFFSET, model.getRawOffset());
        values.put(DatabaseHelper.COLUMN_TIMEZONE, model.getTimezone());
        values.put(DatabaseHelper.COLUMN_UNIXTIME, model.getUnixtime());
        values.put(DatabaseHelper.COLUMN_UTC_DATETIME, model.getUtcDatetime());
        values.put(DatabaseHelper.COLUMN_UTC_OFFSET, model.getUtcOffset());
        values.put(DatabaseHelper.COLUMN_WEEK_NUMBER, model.getWeekNumber());

        database.insert(DatabaseHelper.TABLE_NAME, null, values); // Use TABLE_NAME from DatabaseHelper
    }

    @SuppressLint("Range")
    public List<ResponseModel> getLatest() {
        List<ResponseModel> responseModels = new ArrayList<>();
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, null, null, null, null, null, DatabaseHelper.COLUMN_ID + " DESC");

        if (cursor.moveToFirst()) {
            do {
                ResponseModel model = new ResponseModel();
                model.setAbbreviation(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_ABBREVIATION)));
                model.setClientIp(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_CLIENT_IP)));
                model.setDatetime(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DATETIME)));
                model.setDayOfWeek(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_DAY_OF_WEEK)));
                model.setDayOfYear(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_DAY_OF_YEAR)));
                model.setDst(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_DST)) > 0);
                model.setDstFrom(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DST_FROM)));
                model.setDstOffset(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_DST_OFFSET)));
                model.setDstUntil(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_DST_UNTIL)));
                model.setRawOffset(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_RAW_OFFSET)));
                model.setTimezone(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_TIMEZONE)));
                model.setUnixtime(cursor.getLong(cursor.getColumnIndex(DatabaseHelper.COLUMN_UNIXTIME)));
                model.setUtcDatetime(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_UTC_DATETIME)));
                model.setUtcOffset(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_UTC_OFFSET)));
                model.setWeekNumber(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_WEEK_NUMBER)));
                responseModels.add(model);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return responseModels;
    }


    public void close() {
        if (database != null && database.isOpen()) {
            database.close();
        }
    }
}
