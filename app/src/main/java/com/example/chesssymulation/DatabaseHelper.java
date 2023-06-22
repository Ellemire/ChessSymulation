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

/**
 * Klasa do obsługi bazy danych
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    /** Nazwa bazy danych*/
    private static final String DATABASE_NAME = "GameRecords.db";
    /**Wersja bazy danych*/
    private static final int DATABASE_VERSION = 1;
    /** Liczba zagranych partii*/
    private static final String TABLE_NAME = "games_played";
    /** id kolumny*/
    private static final String COLUMN_ID = "id";
    /** Wykonane ruchy*/
    private static final String COLUMN_MOVES = "moves";
    /** Czas zakończenia symulacji*/
    private static final String COLUMN_TIME = "time";
    /** położenie*/
    private static final String COLUMN_POSITION = "position";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_MOVES + " TEXT, " +
                COLUMN_TIME + " TEXT, " +
                COLUMN_POSITION + " TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    /** metoda do czytania bazy danych
     * @return kursor położenia w bazie danych
     */
    Cursor readAllData()
    {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null)
            cursor = db.rawQuery(query, null);
        return cursor;
    }

    /** metoda do dowania zapisów partii do bazy danych
     * @param moves wykonane ruchy
     * @param time czas zakończenia symulacji
     * @param startingPosition pozycja początkowa
     * @throws JSONException obsługa wyjątków
     */
    public void addRecord(ArrayList<String> moves, String time, String startingPosition) throws JSONException {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("moves", new JSONArray(moves));
        String jsonArrayList = jsonObject.toString();

        cv.put(COLUMN_MOVES, jsonArrayList);
        cv.put(COLUMN_TIME, time);
        cv.put(COLUMN_POSITION, startingPosition);

        db.insert(TABLE_NAME, null, cv);
    }

    /** metoda do usuwania zapisów z bazy danych
     * @param row_id indeks usuwanego zapisu w bazie danych
     */
    public void deleteRecord(String row_id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "id=?", new String[]{row_id});
    }
}
