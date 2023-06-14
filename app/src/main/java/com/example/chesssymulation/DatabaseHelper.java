package com.example.chesssymulation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "GameRecords.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "games_played";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_MOVES = "moves";
    private static final String COLUMN_TIME = "time";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_MOVES + " TEXT, " +
                COLUMN_TIME + " TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    Cursor readAllData()
    {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null)
            cursor = db.rawQuery(query, null);
        return cursor;
    }

    public void addRecord(int numberOfMoves, ArrayList<String> moves, String time) throws JSONException {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("moves", new JSONArray(moves));
        String jsonArrayList = jsonObject.toString();

        cv.put(COLUMN_MOVES, jsonArrayList);
        cv.put(COLUMN_TIME, time);

        db.insert(TABLE_NAME, null, cv);
    }

    public void deleteRecord(String row_id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "id=?", new String[]{row_id});
    }
}
