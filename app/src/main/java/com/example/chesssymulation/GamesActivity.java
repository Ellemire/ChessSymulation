package com.example.chesssymulation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

import Chess.GameRecord;

/**
 * Klasa obsługująca ekran z bazą zapisów partii.
 */
public class GamesActivity extends AppCompatActivity implements GamesInterface {

    RecyclerView recyclerView;
    DatabaseHelper myDB;
    ArrayList<GameRecord> games;
    GamesAdapter gamesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);

        recyclerView = findViewById(R.id.rv_games);

        myDB = new DatabaseHelper(GamesActivity.this);
        games = new ArrayList<>();

        try {
            storeDataInArrays();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        gamesAdapter = new GamesAdapter(this, games, this);
        recyclerView.setAdapter(gamesAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(GamesActivity.this));
    }

    /** zapis do bazy danych
     * @throws JSONException obsługa wyjątku
     */
    public void storeDataInArrays() throws JSONException {
        Cursor cursor = myDB.readAllData();
        while(cursor.moveToNext())
        {
            JSONObject jsonObject = new JSONObject(cursor.getString(1));
            JSONArray jsonArray = jsonObject.optJSONArray("moves");
            ArrayList<String> moves = new ArrayList<>();
            for(int i = 0; i < Objects.requireNonNull(jsonArray).length(); i++)
            {
                moves.add(jsonArray.get(i).toString());
            }
            games.add(new GameRecord(cursor.getString(2), moves, cursor.getString(3)));
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, GameRecordActivity.class);
        intent.putExtra("moves", games.get(position).getMoves());
        startActivity(intent);
    }

    @Override
    public void onBtnDeleteClick(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Usunąć zapis " + (position + 1) + "?");
        builder.setMessage("Czy na pewno usunąć zapis partii nr " + (position + 1) + "?");
        builder.setPositiveButton("Tak", (dialog, which) -> {
            DatabaseHelper myDB = new DatabaseHelper(GamesActivity.this);
            myDB.deleteRecord(String.valueOf(position + 1));
            recreate();
        });
        builder.setNegativeButton("Nie", (dialog, which) -> {

        });
        builder.create().show();
    }

    @Override
    public void onBtnStartingPositionClick(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Pozycja startowa");
        builder.setMessage(games.get(position).getStartingPosition());
        builder.setNeutralButton("OK", (dialog, which) -> {

        });
        builder.create().show();
    }
}